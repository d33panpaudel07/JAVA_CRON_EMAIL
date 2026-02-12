package com.cron_email.cron_email.systemConfig.service;

import com.cron_email.cron_email.core.dto.InternalResponse;
import com.cron_email.cron_email.systemConfig.dto.SystemConfigDto;
import com.cron_email.cron_email.systemConfig.entity.SystemConfig;
import com.cron_email.cron_email.systemConfig.mapper.SystemConfigMapper;
import com.cron_email.cron_email.systemConfig.repository.SystemConfigRepo;
import com.cron_email.cron_email.systemConfig.validator.SystemConfigValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * ░█▀▄░▀▀█░▀▀█░█▀█░█▀█░█▀█
 * ░█░█░░▀▄░░▀▄░█▀▀░█▀█░█░█
 * ░▀▀░░▀▀░░▀▀░░▀░░░▀░▀░▀░▀
 *
 * @author d33pan on 2/12/2026
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SystemConfigService {

    private final SystemConfigRepo systemConfigRepo;

    public InternalResponse<?> getSystemConfigById(Long id) {

        Optional<SystemConfig> entityDataOpt = systemConfigRepo.getByIdAndStatus(id, 'Y');

        if(entityDataOpt.isEmpty()){
            log.error("SystemConfig with id: {} not found", id);
            return InternalResponse.errorResponse("SystemConfig with id: " + id + " not found");
        }

        SystemConfigDto dtoResponse = SystemConfigMapper.toDto(entityDataOpt.get(), new SystemConfigDto());

        return InternalResponse.successResponse(dtoResponse);
    }

    public InternalResponse<?> getAllSystemConfigs() {
        List<SystemConfig> entityDataList = systemConfigRepo.getAllByStatus('Y');

        List<SystemConfigDto> dtoResponseList = entityDataList.stream()
                .map(systemConfig -> SystemConfigMapper.toDto(systemConfig, new SystemConfigDto()))
                .toList();

        return InternalResponse.successResponse(dtoResponseList);
    }

    public InternalResponse<?> createSystemConfig(SystemConfigDto systemConfigDto) {
        InternalResponse<?> validationResponse = SystemConfigValidator.validateSystemConfigDto(systemConfigDto);

        if(!validationResponse.isSuccess()){
            InternalResponse.errorResponse(validationResponse.getMessage());
        }

        SystemConfig systemConfig = SystemConfigMapper.toEntity(systemConfigDto, new SystemConfig());


        return InternalResponse.successResponse(
                SystemConfigMapper.toDto(systemConfigRepo.save(systemConfig), new SystemConfigDto())
        );
    }


    public InternalResponse<?> updateSystemConfig(Long id, SystemConfigDto systemConfigDto) {
        InternalResponse<?> validationResponse = SystemConfigValidator.validateSystemConfigDto(systemConfigDto);

        if(!validationResponse.isSuccess()){
            InternalResponse.errorResponse(validationResponse.getMessage());
        }

        Optional<SystemConfig> existingSystemConfigOpt = systemConfigRepo.getByIdAndStatus(id, 'Y');

        if(existingSystemConfigOpt.isEmpty()){
            log.error("SystemConfig with id: {} not found", id);
            return InternalResponse.errorResponse("SystemConfig with id: " + id + " not found");
        }

        SystemConfig systemConfig = SystemConfigMapper.toEntity(systemConfigDto, new SystemConfig());

        return InternalResponse.successResponse(
                SystemConfigMapper.toDto(systemConfigRepo.save(systemConfig), new SystemConfigDto())
        );
    }

}
