package com.cron_email.cron_email.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GlobalResponse<T> {
    private boolean success;
//    private String code;
    private String message;
    private T data;

    public static <T> GlobalResponse<T> successResponse(String message, T data) {
        return new GlobalResponse<>(true, message, data);
    }

    public static <T> GlobalResponse<T> successResponse(String message) {
        return new GlobalResponse<>(true, message, null);
    }

    public static <T> GlobalResponse<T> errorResponse(String message) {
        return new GlobalResponse<>(false, message, null);
    }

    public static <T> GlobalResponse<T> errorResponse(String message, T data) {
        return new GlobalResponse<>(false, message, data);
    }
}
