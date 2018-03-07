package org.truenorth.restfood.notificationservice.services;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.truenorth.restfood.common.OrderMessage;

@Service
public class SMSServiceImpl implements SMSService {

    private static final Logger logger = LogManager.getLogger(SMSServiceImpl.class);

    @Override
    public void sendSMS(OrderMessage orderMessage) {
        logger.info("SENDING SMS - mobile " + orderMessage.getMobile() + " - message - Your order is confirmed!");
    }
}
