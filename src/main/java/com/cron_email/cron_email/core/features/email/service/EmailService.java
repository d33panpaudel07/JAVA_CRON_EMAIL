package com.cron_email.cron_email.core.features.email.service;

import com.cron_email.cron_email.core.dto.ServerResponse;
import com.cron_email.cron_email.core.features.email.dto.EmailDetails;

/**
 * ░█▀▄░▀▀█░▀▀█░█▀█░█▀█░█▀█
 * ░█░█░░▀▄░░▀▄░█▀▀░█▀█░█░█
 * ░▀▀░░▀▀░░▀▀░░▀░░░▀░▀░▀░▀
 *
 * @author d33pan on 2/8/2026
 */
public interface EmailService {
    ServerResponse<?> sendEmail(EmailDetails emailDetails);
    ServerResponse<?> sendEmailWithAttachment(EmailDetails emailDetails);
}
