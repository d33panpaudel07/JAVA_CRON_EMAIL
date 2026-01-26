package com.cron_email.cron_email._core.exception;

/**
 * Custom exception for unauthorized access attempts
 * 
 * @author d33pan
 */
public class UnauthorizedException extends RuntimeException {
    
    public UnauthorizedException(String message) {
        super(message);
    }
    
    public UnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }
}
