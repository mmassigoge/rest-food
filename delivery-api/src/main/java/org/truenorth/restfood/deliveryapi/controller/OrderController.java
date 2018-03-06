package org.truenorth.restfood.deliveryapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.truenorth.restfood.deliveryapi.entity.OrderEntity;
import org.truenorth.restfood.deliveryapi.entity.ReviewEntity;
import org.truenorth.restfood.deliveryapi.exception.LogisticServiceException;
import org.truenorth.restfood.deliveryapi.exception.OrderServiceException;
import org.truenorth.restfood.deliveryapi.service.LogisticService;
import org.truenorth.restfood.deliveryapi.service.OrderDTO;
import org.truenorth.restfood.deliveryapi.service.OrderService;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private LogisticService logisticService;

    @PostMapping("restaurant/{restaurantId}/order")
    public ETA doReview(@PathVariable long restaurantId, @RequestBody OrderDTO orderDto) throws OrderServiceException, LogisticServiceException {
        OrderEntity order = orderService.doOrder(restaurantId, orderDto);
        return new ETA(logisticService.calculateETA(order));
    }

}
