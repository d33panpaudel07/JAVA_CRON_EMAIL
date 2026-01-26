package com.cron_email.cron_email._core.exception;

/**
 * Utility class containing common exception messages
 * Provides consistent error messages across the application
 * 
 * @author d33pan
 */
public final class ExceptionMessages {

    private ExceptionMessages() {
    }

    // User related messages
    public static final String USER_NOT_FOUND = "User not found";
    public static final String USER_ALREADY_EXISTS = "User already exists with this username or email";
    public static final String INVALID_CREDENTIALS = "Invalid username or password";
    public static final String USERNAME_REQUIRED = "Username is required";
    public static final String EMAIL_REQUIRED = "Email is required";
    public static final String PASSWORD_REQUIRED = "Password is required";

    // Authentication related messages
    public static final String AUTHENTICATION_FAILED = "Authentication failed";
    public static final String TOKEN_EXPIRED = "Authentication token has expired";
    public static final String TOKEN_INVALID = "Invalid authentication token";
    public static final String ACCESS_DENIED = "Access denied";
    public static final String UNAUTHORIZED_ACCESS = "Unauthorized access";
    public static final String AUTHENTICATION_REQUIRED = "Authentication required. Please provide a valid access token.";
    public static final String INSUFFICIENT_PERMISSIONS = "Access denied. You don't have permission to access this resource.";
    public static final String INVALID_TOKEN_FORMAT = "Invalid token format. Please provide a valid Bearer token.";

    // Validation messages
    public static final String VALIDATION_FAILED = "Validation failed";
    public static final String INVALID_INPUT = "Invalid input provided";

    // General messages
    public static final String INTERNAL_SERVER_ERROR = "An internal server error occurred";
    public static final String UNEXPECTED_ERROR = "An unexpected error occurred";
    public static final String RESOURCE_NOT_FOUND = "Requested resource not found";

    // Database related messages
    public static final String DATABASE_ERROR = "Database operation failed";
    public static final String DATA_INTEGRITY_VIOLATION = "Data integrity violation";
}
