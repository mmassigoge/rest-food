package org.truenorth.restfood.notificationservice.services;

import org.truenorth.restfood.common.OrderMessage;

public interface EmailService {
    void sendEmail(OrderMessage orderMessage);
}
