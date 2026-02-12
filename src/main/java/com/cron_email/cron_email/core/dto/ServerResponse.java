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
public class ServerResponse<T> {
    private boolean success;
//    private String code;
    private String message;
    private T data;

    public static <T> ServerResponse<T> successResponse(T data) {
        return new ServerResponse<>(true, ResponseConstants.SUCCESS, data);
    }

    public static <T> ServerResponse<T> successResponse(String message, T data) {
        return new ServerResponse<>(true, message, data);
    }

    public static <T> ServerResponse<T> successResponse(String message) {
        return new ServerResponse<>(true, message, null);
    }

    public static <T> ServerResponse<T> errorResponse(String message) {
        return new ServerResponse<>(false, message, null);
    }

    public static <T> ServerResponse<T> errorResponse(String message, T data) {
        return new ServerResponse<>(false, message, data);
    }

    public static <T> ServerResponse<T> errorResponse(T data) {
        return new ServerResponse<>(false, ResponseConstants.FAILURE, data);
    }
}
