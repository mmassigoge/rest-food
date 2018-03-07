package org.truenorth.restfood.notificationservice.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.truenorth.restfood.common.OrderMessage;

/**
 * Process Notificacion from others systems like delivery-api
 */
@Service
public class NotificationServiceImpl implements NotificationService {
    private static final Logger logger = LogManager.getLogger(SMSServiceImpl.class);

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private EmailService emailService;

    @Autowired
    private SMSService smsService;

    /**
     * Process Order Notificacions
     * Send an email to the restaurant and a SMS to the customer
     * @param orderNotification
     */
    @Override
    public void proccessOrderNotification(String orderNotification) {
        try {
            OrderMessage orderMessage = mapper.readValue(orderNotification, OrderMessage.class);
            emailService.sendEmailToRestaurant(orderMessage);
            smsService.sendSMSToCustomer(orderMessage);
        }catch(Exception e){
            logger.error(e.getMessage());
            logger.debug(e.getMessage(),e);
        }
    }
}
