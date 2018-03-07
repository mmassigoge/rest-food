package org.truenorth.restfood.deliveryapi.service;

import org.truenorth.restfood.deliveryapi.dto.ETADTO;
import org.truenorth.restfood.deliveryapi.entity.OrderEntity;
import org.truenorth.restfood.deliveryapi.entity.RestaurantEntity;
import org.truenorth.restfood.deliveryapi.exception.LogisticServiceException;
import org.truenorth.restfood.deliveryapi.exception.OrderServiceException;

import java.util.Date;

/**
 * Logistic service
 */
public interface LogisticService {

    /**
     * Calcaulates an ETA based on restaurant and client location for the order
     * @param order
     * @return
     * @throws LogisticServiceException
     */
    ETADTO calculateETA(OrderEntity order) throws LogisticServiceException;
}
