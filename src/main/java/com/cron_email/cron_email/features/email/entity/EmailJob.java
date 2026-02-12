package com.cron_email.cron_email.features.email.entity;

import com.cron_email.cron_email.features.base.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @OneToMany(mappedBy = "emailJob", fetch = FetchType.LAZY)
    private List<EmailRecipient> emailRecipients;

    @OneToMany(mappedBy = "emailJob", fetch = FetchType.LAZY)
    private List<EmailLog> emailLogs;

    @OneToMany(mappedBy = "emailJob", fetch = FetchType.LAZY)
    private List<EmailAttachment> emailAttachments;

}
