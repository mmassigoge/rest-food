package org.truenorth.restfood.deliveryapi.service;

import org.truenorth.restfood.deliveryapi.entity.OrderEntity;
import org.truenorth.restfood.deliveryapi.exception.NotificationServiceException;

public interface NotificationService {
    void notify(OrderEntity order) throws NotificationServiceException;
}
