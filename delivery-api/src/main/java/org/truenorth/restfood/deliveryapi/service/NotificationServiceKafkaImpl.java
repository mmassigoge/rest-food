package org.truenorth.restfood.deliveryapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.truenorth.restfood.common.MealMessage;
import org.truenorth.restfood.common.OrderMessage;
import org.truenorth.restfood.common.RestaurantMessage;
import org.truenorth.restfood.deliveryapi.entity.MealEntity;
import org.truenorth.restfood.deliveryapi.entity.OrderEntity;
import org.truenorth.restfood.deliveryapi.entity.RestaurantEntity;
import org.truenorth.restfood.deliveryapi.exception.NotificationServiceException;

/**
 * Notification Service based on Kafka queue that delegate notification process on another component like notification-service
 */
@Service
public class NotificationServiceKafkaImpl implements NotificationService{

    private ObjectMapper mapper = new ObjectMapper();

    @Value("${kafka.topic.orders}")
    private String ordersTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * Build a json msg and send it to the orders kafka topic
     * @param order
     * @throws NotificationServiceException
     */
    @Override
    public void notifyOrder(OrderEntity order) throws NotificationServiceException {
        try{
            OrderMessage message = toMessage(order);
            kafkaTemplate.send(ordersTopic, mapper.writeValueAsString(message));
        }catch(Exception e){
            throw new NotificationServiceException("Something went wrong when trying to publish an order: "+e.getMessage(),e);
        }
    }

    private OrderMessage toMessage(OrderEntity order) {
        OrderMessage message = new OrderMessage();
        message.setAddress(order.getAddress());
        message.setMobile(order.getMobile());
        message.setId(order.getId());
        message.setLatitud(order.getLatitud());
        message.setLongitud(order.getLongitud());
        message.setTotalCost(order.getTotalCost());
        message.setRestaurant(toMessage(order.getRestaurant()));
        for (MealEntity mealEntity :order.getMeals()) {
            message.getMeals().add(toMessage(mealEntity));
        }
        return message;
    }

    private RestaurantMessage toMessage(RestaurantEntity restaurant) {
        RestaurantMessage message = new RestaurantMessage();
        message.setAddress(restaurant.getAddress());
        message.setId(restaurant.getId());
        message.setLatitud(restaurant.getLatitud());
        message.setLongitud(restaurant.getLongitud());
        message.setAdminNumber(restaurant.getAdminNumber());
        message.setCommercialEmail(restaurant.getCommercialEmail());
        message.setCommercialName(restaurant.getCommercialName());
        message.setLegalName(restaurant.getLegalName());
        message.setRating(restaurant.getRating());
        message.setLogo(restaurant.getLogo());
        return message;
    }

    private MealMessage toMessage(MealEntity mealEntity) {
        MealMessage message = new MealMessage();
        message.setDescription(mealEntity.getDescription());
        message.setId(mealEntity.getId());
        message.setName(mealEntity.getName());
        message.setPrice(mealEntity.getPrice());
        return message;
    }
}
