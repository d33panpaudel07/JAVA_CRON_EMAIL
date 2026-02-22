package com.cron_email.cron_email.features.emailSender.entity;

import com.cron_email.cron_email.features.base.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Stores the list of emails user can use to send mails
 *
 * @author d33pan on 2/16/2026
 */
@Entity
@Table(name = "EMAIL_SENDER")
@Getter
@Setter
@NoArgsConstructor
public class EmailSender extends BaseEntity<Long> {
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "SMTP_HOST")
    private String smtpHost;
    @Column(name = "SMTP_PORT")
    private Long smtpPort;

    @Column(name = "IS_TLS_ENABLED")
    private Character isTlsEnabled;
}
