package com.cron_email.cron_email.core.exception;

import com.college_projects.software_engineering.core.dto.GlobalResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Global Exception Handler for the entire application
 * Handles all exceptions and returns them in GlobalResponse format
 * 
 * @author d33pan
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * Handle custom business exceptions
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<GlobalResponse<Object>> handleBusinessException(BusinessException ex, WebRequest request) {
        log.error("Business Exception: {}", ex.getMessage(), ex);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(GlobalResponse.errorResponse(ex.getMessage()));
    }

    /**
     * Handle resource not found exceptions
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<GlobalResponse<Object>> handleResourceNotFoundException(ResourceNotFoundException ex,
            WebRequest request) {
        log.error("Resource Not Found: {}", ex.getMessage(), ex);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(GlobalResponse.errorResponse(ex.getMessage()));
    }

    /**
     * Handle unauthorized access exceptions
     */
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<GlobalResponse<Object>> handleUnauthorizedException(UnauthorizedException ex,
            WebRequest request) {
        log.error("Unauthorized Access: {}", ex.getMessage(), ex);
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(GlobalResponse.errorResponse(ex.getMessage()));
    }

    /**
     * Handle forbidden access exceptions
     */
    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<GlobalResponse<Object>> handleForbiddenException(ForbiddenException ex, WebRequest request) {
        log.error("Forbidden Access: {}", ex.getMessage(), ex);
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(GlobalResponse.errorResponse(ex.getMessage()));
    }

    /**
     * Handle validation exceptions
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(
            MethodArgumentNotValidException ex, WebRequest request) {
        log.error("Validation Error: {}", ex.getMessage(), ex);

//        Map<String, String> errors = new HashMap<>();
        List<String> errors = new ArrayList<String>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
            errors.add(errorMessage);
        });

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(GlobalResponse.errorResponse("Validation failed", errors));
    }

    /**
     * Handle authentication exceptions
     */
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<?> handleAuthenticationException(AuthenticationException ex,
            WebRequest request) {
        log.error("Authentication Error: {}", ex.getMessage(), ex);
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(GlobalResponse.errorResponse("Authentication failed: " + ex.getMessage()));
    }

    /**
     * Handle JWT token validation failures
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<GlobalResponse<Object>> handleIllegalArgumentException(IllegalArgumentException ex,
            WebRequest request) {
        String message = ex.getMessage();
        if (message != null && (message.contains("JWT") || message.contains("token"))) {
            log.error("JWT Token Error: {}", message, ex);
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(GlobalResponse.errorResponse("Invalid or expired token. Please login again."));
        }

        // For other IllegalArgumentException, let it be handled by the generic handler
        throw ex;
    }

    /**
     * Handle bad credentials exceptions
     */
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<GlobalResponse<Object>> handleBadCredentialsException(BadCredentialsException ex,
            WebRequest request) {
        log.error("Bad Credentials: {}", ex.getMessage(), ex);
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(GlobalResponse.errorResponse("Invalid username or password"));
    }

    /**
     * Handle access denied exceptions
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<GlobalResponse<Object>> handleAccessDeniedException(AccessDeniedException ex,
            WebRequest request) {
        log.error("Access Denied: {}", ex.getMessage(), ex);
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(GlobalResponse.errorResponse("Access denied: " + ex.getMessage()));
    }

    // /**
    // * Handle generic runtime exceptions
    // */
    // @ExceptionHandler(RuntimeException.class)
    // public ResponseEntity<GlobalResponse<Object>>
    // handleRuntimeException(RuntimeException ex, HttpServletRequest request) {
    // if(request.getRequestURI().startsWith("/v3/api-docs") ||
    // request.getRequestURI().startsWith("/swagger-ui")){
    // throw ex;
    // }
    //
    // log.error("Runtime Exception: {}", ex.getMessage(), ex);
    // return ResponseEntity
    // .status(HttpStatus.INTERNAL_SERVER_ERROR)
    // .body(GlobalResponse.errorResponse("An unexpected error occurred: " +
    // ex.getMessage()));
    // }
    //
    // /**
    // * Handle generic exceptions
    // */
    // @ExceptionHandler(Exception.class)
    // public ResponseEntity<GlobalResponse<Object>>
    // handleGenericException(Exception ex, HttpServletRequest request) throws
    // Exception {
    // if(request.getRequestURI().startsWith("/v3/api-docs") ||
    // request.getRequestURI().startsWith("/swagger-ui")){
    // throw ex;
    // }
    //
    // log.error("Generic Exception: {}", ex.getMessage(), ex);
    // return ResponseEntity
    // .status(HttpStatus.INTERNAL_SERVER_ERROR)
    // .body(GlobalResponse.errorResponse("An internal server error occurred"));
    // }
}
