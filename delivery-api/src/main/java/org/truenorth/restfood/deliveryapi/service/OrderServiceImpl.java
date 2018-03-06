package org.truenorth.restfood.deliveryapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.truenorth.restfood.deliveryapi.entity.OrderEntity;
import org.truenorth.restfood.deliveryapi.entity.RestaurantEntity;
import org.truenorth.restfood.deliveryapi.entity.ReviewEntity;
import org.truenorth.restfood.deliveryapi.exception.OrderServiceException;
import org.truenorth.restfood.deliveryapi.exception.ReviewServiceException;
import org.truenorth.restfood.deliveryapi.repository.MealRepository;
import org.truenorth.restfood.deliveryapi.repository.OrderRepository;
import org.truenorth.restfood.deliveryapi.repository.RestaurantRepository;
import org.truenorth.restfood.deliveryapi.repository.ReviewRepository;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    MealRepository mealRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    NotificationService notificationService;

    @Override
    public OrderEntity doOrder(long restaurantId, OrderDTO order) throws OrderServiceException {
        OrderEntity orderEntity = new OrderEntity(order);
        RestaurantEntity restaurantEntity = restaurantRepository.findOne(restaurantId);
        if (restaurantEntity != null) {
            if (validateOrder(order)) {
                try {
                    orderEntity.setMeals(
                            Arrays.stream(order.getMeals())
                                    .mapToObj(mealId -> mealRepository.findOne(mealId))
                                    .filter(mealEntity -> restaurantEntity.getMeals().contains(mealEntity))
                                    .collect(Collectors.toList()));
                    orderEntity.setRestaurant(restaurantEntity);
                    orderEntity.setTotalCost(
                            orderEntity.getMeals()
                                    .stream()
                                    .mapToDouble(value -> value.getPrice())
                                    .sum());
                    orderEntity = orderRepository.save(orderEntity);
                    restaurantEntity.getOrders().add(orderEntity);
                } catch (Exception e) {
                    throw new OrderServiceException("Order process failed " + e.getMessage(), e);
                }
            }
            restaurantRepository.save(restaurantEntity);
            notificationService.notify(orderEntity);
        } else {
            throw new OrderServiceException("Restaurant not found with id: " + restaurantId);
        }
        return orderEntity;
    }

    private boolean validateOrder(OrderDTO order) throws OrderServiceException {
        if(order!=null){
            if(order.getMeals().length>0){
                return true;
            }else{
                throw new OrderServiceException("Order error, must contains meals" + order);
            }
        }else{
            throw new OrderServiceException("Order is null or empty: " + order);
        }
    }
}
