package com.yolkin.bookservice.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (09.01.18)
 */
public class JMSConsumer {

    public static void main(String[] args) {
        try {
            // Получение контекста JNDI
            Context jndiContext = new InitialContext();
            // Выполняется поиск администрируемых объектов
            ConnectionFactory connectionFactory = (ConnectionFactory)
                    jndiContext.lookup("jms/test/ConnectionFactory");
            Destination queue = (Destination) jndiContext.lookup("jms/test/Queue");

            createSynchroniousConsumer(connectionFactory, queue);
            createAsynchroniousConsumer(connectionFactory, queue);
        } catch (NamingException | JMSException e) {
            e.printStackTrace();
        }
    }

    private static void createSynchroniousConsumer(ConnectionFactory connectionFactory, Destination queue) throws JMSException {
        // Создаются необходимые для подключения к очереди артефакты
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        MessageConsumer consumer = session.createConsumer(queue);
        connection.start();

        // Выполняется цикл получения сообщений
        while (true) {
            TextMessage message = (TextMessage) consumer.receive();
            System.out.println("Сообщение получено: " + message.getText());
        }
    }

    private static void createAsynchroniousConsumer(ConnectionFactory connectionFactory, Destination queue) throws JMSException {
        try (JMSContext jmsContext = connectionFactory.createContext()) {

            // регистрируем листенер для получения сообщений
            jmsContext.createConsumer(queue).setMessageListener(new JMSListener());
        }
    }

    private static class JMSListener implements MessageListener {
        @Override
        public void onMessage(Message message) {
            try {
                System.out.println("Сообщение получено: " + message.getBody(String.class));
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

}
