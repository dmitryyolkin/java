import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by yolkin on 03.05.2016.
 * It's test class to check receiving message
 */
public class Consumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        //declare Durable queue
        channel.queueDeclare(Producer.QUEUE_NAME, true, false, false, null);

        //everything containing test as second word
        //should be handled by this queue
        channel.queueBind(Producer.QUEUE_NAME, Producer.EXCHANGE_NAME, "*.test");
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");

                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };

        //Set prefetcCount not to take a new message until a consumer is free
        channel.basicQos(1);
        channel.basicConsume(Producer.QUEUE_NAME, true, consumer);

    }
}
