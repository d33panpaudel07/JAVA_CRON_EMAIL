package com.cron_email.cron_email.core.exception;

/**
 * Custom exception for forbidden access attempts
 * 
 * @author d33pan
 */
public class ForbiddenException extends RuntimeException {
    
    public ForbiddenException(String message) {
        super(message);
    }
    
    public ForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }
}
