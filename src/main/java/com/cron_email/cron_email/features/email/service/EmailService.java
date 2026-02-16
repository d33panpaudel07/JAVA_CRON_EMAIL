package com.cron_email.cron_email.features.email.service;

import com.cron_email.cron_email.core.dto.InternalResponse;
import com.cron_email.cron_email.features.email.dto.EmailDetailsDto;

/**
 * ░█▀▄░▀▀█░▀▀█░█▀█░█▀█░█▀█
 * ░█░█░░▀▄░░▀▄░█▀▀░█▀█░█░█
 * ░▀▀░░▀▀░░▀▀░░▀░░░▀░▀░▀░▀
 *
 * @author d33pan on 2/8/2026
 */
public interface EmailService {
    InternalResponse<?> sendEmail(EmailDetailsDto emailDetailsDto);
    InternalResponse<?> sendEmailWithAttachment(EmailDetailsDto emailDetailsDto);
}
