package com.book.service.orders;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (23.01.18)
 */
public class OrderConsumer {
    public static void main(String[] args) throws NamingException {
        // Получение контекста JNDI
        Context jndiContext = new InitialContext();

        // Выполняется поиск администрируемых объектов
        ConnectionFactory connectionFactory = (ConnectionFactory)
                jndiContext.lookup("jms/test/ConnectionFactory");
        Destination topic = (Destination) jndiContext.lookup("jms/test/Topic");

        // Цикл получения сообщений
        try (JMSContext jmsContext = connectionFactory.createContext()) {
            while (true) {
                OrderDTO order = jmsContext
                        .createConsumer(topic)
                        .receiveBody(OrderDTO.class);
                System.out.println("Заказ получен: " + order);
            }
        }
    }
}
