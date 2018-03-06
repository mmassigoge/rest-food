package org.truenorth.restfood.deliveryapi.service;

import org.truenorth.restfood.deliveryapi.entity.OrderEntity;
import org.truenorth.restfood.deliveryapi.entity.RestaurantEntity;
import org.truenorth.restfood.deliveryapi.exception.LogisticServiceException;
import org.truenorth.restfood.deliveryapi.exception.OrderServiceException;

import java.util.Date;

public interface LogisticService {
    String calculateETA(OrderEntity order) throws LogisticServiceException;
}
