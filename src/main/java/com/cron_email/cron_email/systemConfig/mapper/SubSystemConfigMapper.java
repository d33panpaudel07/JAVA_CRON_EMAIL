package com.cron_email.cron_email.systemConfig.mapper;

import com.cron_email.cron_email.core.SpringContextHolder;
import com.cron_email.cron_email.systemConfig.dto.SubSystemConfigDto;
import com.cron_email.cron_email.systemConfig.entity.SubSystemConfig;
import com.cron_email.cron_email.systemConfig.repository.SubSystemConfigRepo;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * ░█▀▄░▀▀█░▀▀█░█▀█░█▀█░█▀█
 * ░█░█░░▀▄░░▀▄░█▀▀░█▀█░█░█
 * ░▀▀░░▀▀░░▀▀░░▀░░░▀░▀░▀░▀
 *
 * @author d33pan on 2/12/2026
 */
@Slf4j
public class SubSystemConfigMapper {

    public static SubSystemConfig toEntity(SubSystemConfigDto subSystemConfigDto, SubSystemConfig subSystemConfig) {

        subSystemConfig.setConfigLabel(subSystemConfigDto.getConfigLabel());
        subSystemConfig.setConfigValue(subSystemConfigDto.getConfigValue());
        subSystemConfig.setDescription(subSystemConfigDto.getDescription());

        subSystemConfig.setInputType(subSystemConfigDto.getInputType());
        subSystemConfig.setCategory(subSystemConfigDto.getCategory());

        Optional<SubSystemConfig> subSystemConfigOpt = SpringContextHolder.getBean(SubSystemConfigRepo.class).getSubSystemConfigByIdAndIsActive(subSystemConfigDto.getId(), 'Y');

        subSystemConfigOpt.ifPresent(systemConfig -> subSystemConfig.setSystemConfig(systemConfig.getSystemConfig()));

        return subSystemConfig;
    }

    public static SubSystemConfigDto toDto(SubSystemConfig subSystemConfig, SubSystemConfigDto subSystemConfigDto) {

        subSystemConfigDto.setConfigLabel(subSystemConfig.getConfigLabel());
        subSystemConfigDto.setConfigValue(subSystemConfig.getConfigValue());
        subSystemConfigDto.setDescription(subSystemConfig.getDescription());
        subSystemConfigDto.setInputType(subSystemConfig.getInputType());
        subSystemConfigDto.setCategory(subSystemConfig.getCategory());
        subSystemConfigDto.setSystemConfigId(subSystemConfig.getSystemConfig().getId());

        return subSystemConfigDto;
    }
}
