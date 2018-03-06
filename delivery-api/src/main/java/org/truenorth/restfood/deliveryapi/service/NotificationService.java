package org.truenorth.restfood.deliveryapi.service;

import org.truenorth.restfood.deliveryapi.entity.OrderEntity;

public interface NotificationService {
    void notify(OrderEntity order);
}
