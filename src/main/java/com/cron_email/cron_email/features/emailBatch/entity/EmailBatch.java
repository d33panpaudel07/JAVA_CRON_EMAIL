package com.cron_email.cron_email.features.emailBatch.entity;

import com.cron_email.cron_email.features.base.entity.BaseEntity;
import com.cron_email.cron_email.features.emailJob.entity.EmailJob;
import com.cron_email.cron_email.features.emailRecipient.entity.EmailRecipient;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

/**
 * @author d33pan on 2/22/2026
 */
@Entity
@Table(name = "EMAIL_BATCH")
@Getter
@Setter
@NoArgsConstructor
public class EmailBatch extends BaseEntity<Long> {

    @Column(name = "BATCH_NAME")
    private String batchName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMAIL_JOB_ID")
    private EmailJob emailJob;

    @OneToMany(mappedBy = "emailJob", fetch = FetchType.LAZY)
    @JoinColumn(name = "EMAIL_BATCH_ID")
    private List<EmailRecipient> emailRecipients;
}
