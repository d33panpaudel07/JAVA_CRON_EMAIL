package com.cron_email.cron_email.core.dto;

import com.cron_email.cron_email.core.constants.ResponseConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InternalResponse<T> {
    private boolean success;
//    private String code;
    private String message;
    private T data;

    public static <T> InternalResponse<T> successResponse(T data) {
        return new InternalResponse<>(true, ResponseConstants.SUCCESS, data);
    }

    public static <T> InternalResponse<T> successResponse(String message, T data) {
        return new InternalResponse<>(true, message, data);
    }

    public static <T> InternalResponse<T> successResponse(String message) {
        return new InternalResponse<>(true, message, null);
    }

    public static <T> InternalResponse<T> errorResponse(String message) {
        return new InternalResponse<>(false, message, null);
    }

    public static <T> InternalResponse<T> errorResponse(String message, T data) {
        return new InternalResponse<>(false, message, data);
    }

    public static <T> InternalResponse<T> errorResponse(T data) {
        return new InternalResponse<>(false, ResponseConstants.FAILURE, data);
    }
}
