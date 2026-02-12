package com.cron_email.cron_email.features.emailLog.entity;

import com.cron_email.cron_email.core.enums.EmailStatusEnum;
import com.cron_email.cron_email.features.base.entity.BaseEntity;
import com.cron_email.cron_email.features.emailJob.entity.EmailJob;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "EMAIL_LOG")
@Getter
@Setter
@NoArgsConstructor
public class EmailLog extends BaseEntity<Long> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMAIL_JOB_ID")
    private EmailJob emailJob;

    @Column(name = "RECIPIENT_EMAIL")
    private String recipientEmail;

    @Column(name = "SENT_AT")
    private LocalDateTime sentAt;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private EmailStatusEnum status;

    @Column(name = "ERROR_MESSAGE")
    private String errorMessage;

    @Column(name = "RETRY_COUNT")
    private String retryCount;

}
