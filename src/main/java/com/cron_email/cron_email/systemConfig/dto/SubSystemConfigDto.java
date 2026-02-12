package com.cron_email.cron_email.systemConfig.dto;

import com.cron_email.cron_email.core.enums.systemConfig.SYSTEM_CONFIG_ENUMS;
import com.cron_email.cron_email.features.base.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

/**
 * ░█▀▄░▀▀█░▀▀█░█▀█░█▀█░█▀█
 * ░█░█░░▀▄░░▀▄░█▀▀░█▀█░█░█
 * ░▀▀░░▀▀░░▀▀░░▀░░░▀░▀░▀░▀
 *
 * @author d33pan on 2/12/2026
 */
@Getter
@Setter
public class SubSystemConfigDto extends BaseDto<Long> {
    private String configLabel;
    private String configValue;
    private String description;
    private Long systemConfigId;

    private SYSTEM_CONFIG_ENUMS.INPUT_TYPE inputType;
    private SYSTEM_CONFIG_ENUMS.CATEGORY category;
}
