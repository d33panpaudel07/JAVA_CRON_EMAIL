package com.cron_email.cron_email.systemConfig.mapper;

import com.cron_email.cron_email.systemConfig.dto.SystemConfigDto;
import com.cron_email.cron_email.systemConfig.entity.SystemConfig;
import lombok.extern.slf4j.Slf4j;

/**
 * ░█▀▄░▀▀█░▀▀█░█▀█░█▀█░█▀█
 * ░█░█░░▀▄░░▀▄░█▀▀░█▀█░█░█
 * ░▀▀░░▀▀░░▀▀░░▀░░░▀░▀░▀░▀
 *
 * @author d33pan on 2/12/2026
 */
@Slf4j
public class SystemConfigMapper {
    public static SystemConfig toEntity(SystemConfigDto systemConfigDto, SystemConfig systemConfig){

        systemConfig.setConfigLabel(systemConfigDto.getConfigLabel());
        systemConfig.setConfigValue(systemConfigDto.getConfigValue());
        systemConfig.setDescription(systemConfigDto.getDescription());
        systemConfig.setCategory(systemConfigDto.getCategory());
        systemConfig.setEnvironment(systemConfigDto.getEnvironment());

        return systemConfig;
    }

    public static SystemConfigDto toDto(SystemConfig systemConfig, SystemConfigDto systemConfigDto){

        systemConfigDto.setConfigLabel(systemConfig.getConfigLabel());
        systemConfigDto.setConfigValue(systemConfig.getConfigValue());
        systemConfigDto.setDescription(systemConfig.getDescription());
        systemConfigDto.setCategory(systemConfig.getCategory());
        systemConfigDto.setEnvironment(systemConfig.getEnvironment());

        return systemConfigDto;
    }
}
