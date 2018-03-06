package org.truenorth.restfood.deliveryapi.exception;

/**
 * A generic Domain exception, this could be a Business Exception hierarchy
 */
public class ReviewServiceException extends Exception{
    public ReviewServiceException(String message){
        super(message);
    }

    public ReviewServiceException(String message, Throwable cause){
        super(message,cause);
    }
}
