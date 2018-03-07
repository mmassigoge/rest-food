package org.truenorth.restfood.deliveryapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.truenorth.restfood.deliveryapi.dto.ETADTO;
import org.truenorth.restfood.deliveryapi.entity.OrderEntity;
import org.truenorth.restfood.deliveryapi.exception.LogisticServiceException;
import org.truenorth.restfood.deliveryapi.exception.NotificationServiceException;
import org.truenorth.restfood.deliveryapi.exception.OrderServiceException;
import org.truenorth.restfood.deliveryapi.service.LogisticService;
import org.truenorth.restfood.deliveryapi.dto.OrderDTO;
import org.truenorth.restfood.deliveryapi.service.OrderService;

import javax.validation.Valid;

/**
 * REST Controller that process orders
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private LogisticService logisticService;

    /**
     * Process an Order for a restaurant and return ETA information
     * @param restaurantId
     * @param orderDto
     * @return
     * @throws OrderServiceException
     * @throws LogisticServiceException
     * @throws NotificationServiceException
     */
    @PostMapping("restaurant/{restaurantId}/order")
    public ETADTO doReview(@PathVariable long restaurantId, @Valid @RequestBody OrderDTO orderDto) throws OrderServiceException, LogisticServiceException, NotificationServiceException {
        OrderEntity order = orderService.doOrder(restaurantId, orderDto);
        return logisticService.calculateETA(order);
    }

}
