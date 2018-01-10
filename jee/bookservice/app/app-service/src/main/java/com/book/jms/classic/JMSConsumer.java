package com.book.jms.classic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
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
        } catch (NamingException | JMSException e) {
            e.printStackTrace();
        }
    }
}
