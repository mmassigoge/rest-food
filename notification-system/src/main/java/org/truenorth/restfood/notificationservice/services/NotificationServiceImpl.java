package org.truenorth.restfood.notificationservice.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.truenorth.restfood.common.OrderMessage;

@Service
public class NotificationServiceImpl implements NotificationService {
    private static final Logger logger = LogManager.getLogger(SMSServiceImpl.class);

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private EmailService emailService;

    @Autowired
    private SMSService smsService;

    @Override
    public void proccessOrderNotification(String orderNotification) {
        try {
            OrderMessage orderMessage = mapper.readValue(orderNotification, OrderMessage.class);
            emailService.sendEmail(orderMessage);
            smsService.sendSMS(orderMessage);
        }catch(Exception e){
            logger.error(e.getMessage(),e);
        }
    }
}
