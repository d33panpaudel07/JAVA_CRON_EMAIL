package com.cron_email.cron_email.systemConfig.validator;

import com.cron_email.cron_email.core.dto.InternalResponse;
import com.cron_email.cron_email.systemConfig.dto.SystemConfigDto;

/**
 * ░█▀▄░▀▀█░▀▀█░█▀█░█▀█░█▀█
 * ░█░█░░▀▄░░▀▄░█▀▀░█▀█░█░█
 * ░▀▀░░▀▀░░▀▀░░▀░░░▀░▀░▀░▀
 *
 * @author d33pan on 2/12/2026
 */
public class SystemConfigValidator {
    public static InternalResponse<?> validateSystemConfigDto(SystemConfigDto systemConfigDto){

        if(systemConfigDto == null){
            InternalResponse.errorResponse("System config dto is null");
        }

        return InternalResponse.successResponse("System config dto is valid");
    }
}
