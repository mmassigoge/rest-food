package org.truenorth.restfood.deliveryapi.exception;

/**
 * A generic Domain exception, this could be a Business Exception hierarchy
 */
public class OrderServiceException extends Exception{
    public OrderServiceException(String message){
        super(message);
    }

    public OrderServiceException(String message, Throwable cause){
        super(message,cause);
    }
}
