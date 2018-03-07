package org.truenorth.restfood.notificationservice.task;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.truenorth.restfood.notificationservice.services.NotificationService;
import org.truenorth.restfood.notificationservice.services.SMSServiceImpl;

import java.util.concurrent.CountDownLatch;

/**
 * Notification consumer from Kafka topics
 */
@Component
public class NotificationConsumer {

    private static final Logger logger = LogManager.getLogger(SMSServiceImpl.class);

    @Autowired
    private NotificationService notificationService;

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    /**
     * Consume an Order notificacion and call NotificationService to process it
     */
    @KafkaListener(topics = "${kafka.topic.orders}")
    public void receive(ConsumerRecord<String, String> consumerRecord) {
        try {
            notificationService.proccessOrderNotification(consumerRecord.value());
            latch.countDown();
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.debug(e.getMessage(), e);
        }
    }
}
