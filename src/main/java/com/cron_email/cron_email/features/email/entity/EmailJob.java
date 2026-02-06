package com.cron_email.cron_email.features.email.entity;

import com.cron_email.cron_email.features.base.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "EMAIL_JOB")
@Getter
@Setter
@NoArgsConstructor
public class EmailJob extends BaseEntity<Long> {

    @Column(name = "JOB_NAME")
    private String jobName;

    @Column(name = "CRON_EXPRESSION")
    private String cronExpression;

    @Column(name = "SUBJECT")
    private String subject;

    @Column(name = "BODY")
    private String body;

}
