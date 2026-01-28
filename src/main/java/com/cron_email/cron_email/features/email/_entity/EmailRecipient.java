package com.cron_email.cron_email.features.email._entity;

import com.cron_email.cron_email._core.enums.RecipientTypeEnum;
import com.cron_email.cron_email.features._base.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "EMAIL_RECIPIENT")
@Getter
@Setter
@NoArgsConstructor
public class EmailRecipient extends BaseEntity<Long> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMAIL_JOB_ID")
    private EmailJob emailJob;

    @Column(name = "RECIPIENT_EMAIL")
    private String recipientEmail;

    @Column(name = "RECIPIENT_NAME")
    private String recipientName;

    @Column(name = "RECIPIENT_TYPE")
    @Enumerated(EnumType.STRING)
    private RecipientTypeEnum recipientType;

}
