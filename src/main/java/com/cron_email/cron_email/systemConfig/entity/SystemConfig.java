package com.cron_email.cron_email.systemConfig.entity;

import com.cron_email.cron_email.features.base.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
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
public class SystemConfig extends BaseEntity<Long> {

    @Column(name = "CONFIG_LABEL")
    private String configLabel;

    @Column(name = "CONFIG_VALUE")
    private String configValue;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "ENVIRONMENT")
    private String environment;


}
