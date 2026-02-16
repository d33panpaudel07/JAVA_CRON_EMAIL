package com.cron_email.cron_email.controller;

import com.cron_email.cron_email.core.constants.ControllerConstants;
import com.cron_email.cron_email.core.dto.GlobalResponse;
import com.cron_email.cron_email.core.dto.InternalResponse;
import com.cron_email.cron_email.systemConfig.dto.SystemConfigDto;
import com.cron_email.cron_email.systemConfig.service.SystemConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * ░█▀▄░▀▀█░▀▀█░█▀█░█▀█░█▀█
 * ░█░█░░▀▄░░▀▄░█▀▀░█▀█░█░█
 * ░▀▀░░▀▀░░▀▀░░▀░░░▀░▀░▀░▀
 *
 * @author d33pan on 2/12/2026
 */
@RestController
@RequestMapping("/api/system-config")
@RequiredArgsConstructor
public class SystemConfigController {

    private final SystemConfigService systemConfigService;

    @GetMapping(ControllerConstants.READ_BY_ID + "/{id}")
    public GlobalResponse<?> getSystemConfigById(@PathVariable Long id){
        InternalResponse<?> response = systemConfigService.getSystemConfigById(id);
        return GlobalResponse.successResponse(response);
    }

    @GetMapping(ControllerConstants.READ_ALL)
    public GlobalResponse<?> getAllSystemConfig(){
        InternalResponse<?> response = systemConfigService.getAllSystemConfigs();
        return GlobalResponse.successResponse(response);
    }

    @PostMapping(ControllerConstants.CREATE)
    public GlobalResponse<?> getAllSystemConfig(SystemConfigDto systemConfigDto){
        InternalResponse<?> response = systemConfigService.createSystemConfig(systemConfigDto);
        return GlobalResponse.successResponse(response);
    }

    @PostMapping(ControllerConstants.UPDATE + "/{id}")
    public GlobalResponse<?> updateSystemConfig(Long id, SystemConfigDto systemConfigDto){
        InternalResponse<?> response = systemConfigService.updateSystemConfig(id, systemConfigDto);
        return GlobalResponse.successResponse(response);
    }

}
