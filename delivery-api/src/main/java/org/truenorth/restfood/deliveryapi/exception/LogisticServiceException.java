package org.truenorth.restfood.deliveryapi.exception;

/**
 * A generic Domain exception, this could be a Business Exception hierarchy
 */
public class LogisticServiceException extends Exception{
    public LogisticServiceException(String message){
        super(message);
    }

    public LogisticServiceException(String message, Throwable cause){
        super(message,cause);
    }
}
