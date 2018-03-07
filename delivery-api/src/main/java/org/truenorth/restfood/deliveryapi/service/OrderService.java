package org.truenorth.restfood.deliveryapi.service;

import org.truenorth.restfood.deliveryapi.entity.OrderEntity;
import org.truenorth.restfood.deliveryapi.exception.NotificationServiceException;
import org.truenorth.restfood.deliveryapi.exception.OrderServiceException;
import org.truenorth.restfood.deliveryapi.dto.OrderDTO;

/**
 * Service that process Orders
 */
public interface OrderService {

    /**
     * Process an Order for a Restaurant
     * @param restaurantId
     * @param order
     * @return
     * @throws OrderServiceException
     * @throws NotificationServiceException
     */
    OrderEntity doOrder(long restaurantId, OrderDTO order) throws OrderServiceException, NotificationServiceException;
}
