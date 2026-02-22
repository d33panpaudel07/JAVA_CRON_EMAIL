package com.cron_email.cron_email.features.emailJob.entity;

import com.cron_email.cron_email.features.base.entity.BaseEntity;
import com.cron_email.cron_email.features.emailAttachment.entity.EmailAttachment;
import com.cron_email.cron_email.features.emailLog.entity.EmailLog;
import com.cron_email.cron_email.features.emailRecipient.entity.EmailRecipient;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

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

    @Column(name = "FREQUENCY")
    private Long frequency;

    @Column(name = "STOP_DATE")
    private LocalDate stopDate;

    @OneToMany(mappedBy = "emailJob", fetch = FetchType.LAZY)
    private List<EmailLog> emailLogs;

    @OneToMany(mappedBy = "emailJob", fetch = FetchType.LAZY)
    private List<EmailAttachment> emailAttachments;

}
