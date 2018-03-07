package org.truenorth.restfood.notificationservice.task;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.truenorth.restfood.notificationservice.services.NotificationService;

import java.util.concurrent.CountDownLatch;

@Component
public class NotificationConsumer {

    @Autowired
    private NotificationService notificationService;


    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }
    @KafkaListener(topics = "${kafka.topic.orders}")
    public void receive(ConsumerRecord<String, String> consumerRecord) {
        notificationService.proccessOrderNotification(consumerRecord.value());
        latch.countDown();
    }
}
