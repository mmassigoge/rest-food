package org.truenorth.restfood.deliveryapi.exception;

public class NotificationServiceException  extends Exception{
    public NotificationServiceException(String message){
        super(message);
    }

    public NotificationServiceException(String message, Throwable cause){
        super(message,cause);
    }
}
