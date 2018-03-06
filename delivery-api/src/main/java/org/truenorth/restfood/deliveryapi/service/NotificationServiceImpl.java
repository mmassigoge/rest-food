package org.truenorth.restfood.deliveryapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.truenorth.restfood.deliveryapi.entity.OrderEntity;

@Service
public class NotificationServiceImpl implements NotificationService{

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void notify(OrderEntity order) {
        kafkaTemplate.send("test1","test2");
    }
}
