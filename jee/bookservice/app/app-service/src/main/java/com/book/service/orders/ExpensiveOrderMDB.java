package com.book.service.orders;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (23.01.18)
 */
@MessageDriven(mappedName = "jms/test/Topic", activationConfig = {
        @ActivationConfigProperty(
                propertyName = "acknowledgeMode",
                propertyValue = "Auto-acknowledge"
        ),
        @ActivationConfigProperty(
                propertyName = "messageSelector",
                propertyValue = "orderAmount > 1000"
        )
} )
public class ExpensiveOrderMDB implements MessageListener {
    public void onMessage(Message message) {
        try {
            OrderDTO order = message.getBody(OrderDTO.class);
            System.out.println("Большой заказ получен: " + order.toString());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}