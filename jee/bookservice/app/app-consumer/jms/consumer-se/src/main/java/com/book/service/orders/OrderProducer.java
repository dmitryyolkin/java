package com.book.service.orders;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Date;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (23.01.18)
 */
public class OrderProducer {
    public static void main(String[] args) throws NamingException {

        // Создает объект orderDto с параметром totalАmount
        Float totalAmount = Float.valueOf(args.length > 0 ? args[0] : "1000");
        OrderDTO order = new OrderDTO(1234l, new Date(), "Бетти Мореу", totalAmount);

        // Получает контекст JNDI
        Context jndiContext = new InitialContext();

        // Поиск администрируемых объектов
        ConnectionFactory connectionFactory = (ConnectionFactory)
                jndiContext.lookup("jms/test/ConnectionFactory");
        Destination topic = (Destination) jndiContext.lookup("jms/test/Topic");
        try (JMSContext jmsContext = connectionFactory.createContext()) {
            // Посылает сообщение в тему
            jmsContext
                    .createProducer()
                    .setProperty("orderAmount", totalAmount).
                    send(topic, order);
        }
    }
}
