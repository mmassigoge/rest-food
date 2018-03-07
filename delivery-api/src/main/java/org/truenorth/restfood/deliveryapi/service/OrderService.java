package org.truenorth.restfood.deliveryapi.service;

import org.truenorth.restfood.deliveryapi.entity.OrderEntity;
import org.truenorth.restfood.deliveryapi.entity.ReviewEntity;
import org.truenorth.restfood.deliveryapi.exception.NotificationServiceException;
import org.truenorth.restfood.deliveryapi.exception.OrderServiceException;
import org.truenorth.restfood.deliveryapi.exception.ReviewServiceException;

public interface OrderService {
    OrderEntity doOrder(long restaurantId, OrderDTO order) throws OrderServiceException, NotificationServiceException;
}
