package com.cron_email.cron_email.systemConfig.entity;

import com.cron_email.cron_email.features.base.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * ░█▀▄░▀▀█░▀▀█░█▀█░█▀█░█▀█
 * ░█░█░░▀▄░░▀▄░█▀▀░█▀█░█░█
 * ░▀▀░░▀▀░░▀▀░░▀░░░▀░▀░▀░▀
 *
 * @author d33pan on 2/12/2026
 */
public class SubSystemConfig extends BaseEntity<Long> {

    @Column(name = "CONFIG_LABEL")
    private String configLabel;

    @Column(name = "CONFIG_VALUE")
    private String configValue;

    @Column(name = "INPUT_TYPE")
    private String inputType; // RADIO, DROPDOWNS

    @Column(name = "VALUE_TYPE")
    private String valueType; // TEXT, PASSWORD, EMAIL

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CATEGORY")
    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SYSTEM_CONFIG_ID")
    private SystemConfig systemConfig;

}
