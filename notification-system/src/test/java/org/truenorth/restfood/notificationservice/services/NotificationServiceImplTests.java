package org.truenorth.restfood.notificationservice.services;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.truenorth.restfood.common.OrderMessage;

@RunWith(MockitoJUnitRunner.class)
public class NotificationServiceImplTests {

    @InjectMocks
    NotificationServiceImpl notificationService;

    @Mock
    EmailService emailService;

    @Mock
    SMSService smsService;

    @Test
    public void proccessOrderNotificationNull(){
        notificationService.proccessOrderNotification(null);
        verify(emailService,never()).sendEmailToRestaurant(null);
        verify(smsService,never()).sendSMSToCustomer(null);
    }

    @Test
    public void proccessOrderNotificationWrongFormat(){
        notificationService.proccessOrderNotification("");
        verify(emailService,never()).sendEmailToRestaurant(any(OrderMessage.class));
        verify(smsService,never()).sendSMSToCustomer(any(OrderMessage.class));
    }

    @Test
    public void proccessOrderNotificationSuccess(){
        String orderMessageValue = "{\"id\":4,\"restaurant\":{\"id\":1,\"logo\":\"https%3A%2F%2Fwww.rd.com%2Fwp-content%2Fuploads%2F2017%2F08%2FAttention-Sushi-Lovers-There-Are-Rules-About-Eating-Japanese-Food-That-You-Must-Follow_644962144-760x506.jpg\",\"commercialName\":\"Sushi Planet\",\"legalName\":\"Sushi Planet Inc\",\"rating\":0.0,\"commercialEmail\":\"sarasa@gmail.com\",\"adminNumber\":\"(323)432254667\",\"address\":\"1350 Natoma Street, SF, CA, USA\",\"latitud\":37.767562,\"longitud\":-122.418539},\"meals\":[{\"id\":2,\"name\":\"sashimi\",\"description\":\"nice sashimi\",\"price\":15.0}],\"totalCost\":15.0,\"address\":\"my address\",\"latitud\":37.777562,\"longitud\":-122.428539,\"mobile\":\"123-123-456\"}\n";
        notificationService.proccessOrderNotification(orderMessageValue);

        ArgumentCaptor<OrderMessage> argument = ArgumentCaptor.forClass(OrderMessage.class);

        verify(emailService).sendEmailToRestaurant(argument.capture());
        assertEquals(4l, argument.getValue().getId().longValue());
        assertEquals("sarasa@gmail.com", argument.getValue().getRestaurant().getCommercialEmail());

        verify(smsService).sendSMSToCustomer(argument.capture());
        assertEquals(4l, argument.getValue().getId().longValue());
        assertEquals("123-123-456", argument.getValue().getMobile());
    }
}
