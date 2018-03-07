package org.truenorth.restfood.deliveryapi.service;

import org.truenorth.restfood.deliveryapi.entity.OrderEntity;
import org.truenorth.restfood.deliveryapi.exception.NotificationServiceException;

/**
 * Notification Service
 */
public interface NotificationService {

    /**
     * Notify a new Order
     * @param order
     * @throws NotificationServiceException
     */
    void notifyOrder(OrderEntity order) throws NotificationServiceException;
}
