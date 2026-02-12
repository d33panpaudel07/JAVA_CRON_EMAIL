package com.cron_email.cron_email.systemConfig.dto;

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
public class SystemConfigDto extends BaseDto<Long> {

    private String configLabel;
    private String configValue;
    private String description;
    private String category;
    private String environment;

}
