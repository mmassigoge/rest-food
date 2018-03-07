package org.truenorth.restfood.notificationservice.services;

import org.truenorth.restfood.common.OrderMessage;

public interface EmailService {
    void sendEmailToRestaurant(OrderMessage orderMessage);
}
