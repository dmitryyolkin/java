package com.yolkin.bookservice.jms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import java.time.LocalDateTime;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (11.01.18)
 */
@Stateless
public class JMSProducerEJB {

    @Resource(lookup = "jms/test/ConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "jms/test/Queue")
    private Destination queue;

    public void sendMessage() {
        try (JMSContext context = connectionFactory.createContext()) {
            context
                    .createProducer()
                    .send(queue, "Test message is send from ProducerEJB. Time: " + LocalDateTime.now());
        }

    }
}
