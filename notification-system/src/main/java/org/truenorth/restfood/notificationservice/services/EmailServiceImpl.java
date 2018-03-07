package org.truenorth.restfood.notificationservice.services;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.truenorth.restfood.common.OrderMessage;

/**
 * Email sending service
 */
@Service
public class EmailServiceImpl implements EmailService{

    private static final Logger logger = LogManager.getLogger(SMSServiceImpl.class);

    @Autowired
    public JavaMailSender emailSender;

    /**
     * Send emails to Order's Restaurant
     * @param orderMessage
     */
    @Override
    public void sendEmailToRestaurant(OrderMessage orderMessage) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(orderMessage.getRestaurant().getCommercialEmail());
            message.setSubject("New Order in place!");
            message.setText("A new Order was placed on our system");
            emailSender.send(message);
        }catch(Exception e){
            logger.error(e.getMessage());
            logger.debug(e.getMessage(),e);
        }
    }
}
