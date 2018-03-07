package org.truenorth.restfood.notificationservice.services;

import org.truenorth.restfood.common.OrderMessage;

public interface SMSService {
    void sendSMSToCustomer(OrderMessage orderMessage);
}
