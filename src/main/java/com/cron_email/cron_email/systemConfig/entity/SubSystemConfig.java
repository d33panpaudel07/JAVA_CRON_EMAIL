package com.cron_email.cron_email.systemConfig.entity;

import com.cron_email.cron_email.core.enums.systemConfig.SYSTEM_CONFIG_ENUMS;
import com.cron_email.cron_email.features.base.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * ░█▀▄░▀▀█░▀▀█░█▀█░█▀█░█▀█
 * ░█░█░░▀▄░░▀▄░█▀▀░█▀█░█░█
 * ░▀▀░░▀▀░░▀▀░░▀░░░▀░▀░▀░▀
 *
 * @author d33pan on 2/12/2026
 */
@Entity
@Table(name = "SUB_SYSTEM_CONFIG")
@Getter
@Setter
@RequiredArgsConstructor
public class SubSystemConfig extends BaseEntity<Long> {

    @Column(name = "CONFIG_LABEL")
    private String configLabel;

    @Column(name = "CONFIG_VALUE")
    private String configValue;

    @Column(name = "INPUT_TYPE")
    @Enumerated(EnumType.STRING)
    private SYSTEM_CONFIG_ENUMS.INPUT_TYPE inputType;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CATEGORY")
    private SYSTEM_CONFIG_ENUMS.CATEGORY category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SYSTEM_CONFIG_ID")
    private SystemConfig systemConfig;

}
