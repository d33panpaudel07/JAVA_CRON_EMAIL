package com.cron_email.cron_email._core.exception;

/**
 * Custom exception for business logic errors
 * 
 * @author d33pan
 */
public class BusinessException extends RuntimeException {
    
    public BusinessException(String message) {
        super(message);
    }
    
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
