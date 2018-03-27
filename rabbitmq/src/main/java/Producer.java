import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by yolkin on 01.05.2016.
 * It's test class to check sending messages to rabbitmq
 */
public class Producer {
    public static final String EXCHANGE_NAME = "test_exchange";
    public final static String QUEUE_NAME = "hello";
    public final static String HELLO_BINDING_KEY = "hello.test";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");

        //Хорошая статья на хабре как правильно закрывать потоки и Closable
        //https://habrahabr.ru/post/178405/
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        //declare Durable exchange and queue
        // bind exchange with queue
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");

        for (int i = 0; i < 1000; i++) {
            //send a message
            String message = String.format("message_%d", i);
            channel.basicPublish("logs", HELLO_BINDING_KEY,
                    new AMQP.BasicProperties.Builder()
                            .deliveryMode(2)
                            .build(),
                    message.getBytes()
            );
            System.out.println(" [x] Sent '" + message + "'");
        }

        channel.close();
        connection.close();
    }
}
