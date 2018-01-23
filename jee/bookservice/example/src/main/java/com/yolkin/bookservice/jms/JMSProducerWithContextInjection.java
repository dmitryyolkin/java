package com.yolkin.bookservice.jms;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import java.time.LocalDateTime;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (11.01.18)
 */
public class JMSProducerWithContextInjection {
    @Inject
    @JMSConnectionFactory("jms/test/ConnectionFactory")
    private JMSContext context;

    @Resource(lookup = "jms/test/Queue")
    private Destination queue;

    public void sendMessage() {
            context
                    .createProducer()
                    .send(queue, "Test message is send from Producer with @JMSConnectionFactory . Time: " + LocalDateTime.now());
    }

}
