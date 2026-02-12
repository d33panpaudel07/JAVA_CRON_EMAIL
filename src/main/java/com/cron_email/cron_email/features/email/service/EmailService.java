package com.cron_email.cron_email.features.email.service;

import com.cron_email.cron_email.core.dto.InternalResponse;
import com.cron_email.cron_email.features.email.dto.EmailDetails;

/**
 * ░█▀▄░▀▀█░▀▀█░█▀█░█▀█░█▀█
 * ░█░█░░▀▄░░▀▄░█▀▀░█▀█░█░█
 * ░▀▀░░▀▀░░▀▀░░▀░░░▀░▀░▀░▀
 *
 * @author d33pan on 2/8/2026
 */
public interface EmailService {
    InternalResponse<?> sendEmail(EmailDetails emailDetails);
    InternalResponse<?> sendEmailWithAttachment(EmailDetails emailDetails);
}
