package com.book.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.time.LocalDateTime;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (09.01.18)
 */
public class JMSProducer {

    public static void main(String[] args) {
        try {
            // Получает контекст JNDI
            InitialContext jndiContext = new InitialContext();

            // Выполняет поиск администрируемых объектов
            ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext
                    .lookup("jms/test/ConnectionFactory");
            Destination queue = (Destination) jndiContext.lookup("jms/test/Queue");

            sendMsgWithClassicApproach(connectionFactory, queue);
            sendMsgWithNewApproach(connectionFactory, queue);

        } catch (NamingException | JMSException e) {
            e.printStackTrace();
        }
    }

    private static void sendMsgWithClassicApproach(ConnectionFactory connectionFactory, Destination queue) throws JMSException {
        //Создает необходимые артефакты для соединения с очередью
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(queue);

        // Отправляем текстовое сообщение
        TextMessage message = session.createTextMessage("Test message is send with classic approach. Time: " + LocalDateTime.now());
        producer.send(message);
        connection.close();
    }


    private static void sendMsgWithNewApproach(ConnectionFactory connectionFactory, Destination queue) {
        try (JMSContext context = connectionFactory.createContext()) {
            context
                    .createProducer()
                    .send(queue, "Test message is send with new approach. Time: " + LocalDateTime.now());
        }
    }

}
