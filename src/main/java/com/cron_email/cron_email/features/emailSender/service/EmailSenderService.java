package com.cron_email.cron_email.features.emailSender.service;

import com.cron_email.cron_email.core.dto.InternalResponse;
import com.cron_email.cron_email.features.emailSender.dto.EmailSenderDto;

/**
 * @author d33pan on 2/16/2026
 */
public interface EmailSenderService {
    InternalResponse<?> createEmailSender(EmailSenderDto emailSenderDto);

    InternalResponse<?> readEmailSenderById(Long id);

    InternalResponse<?> readAllEmail();

    InternalResponse<?> updateEmailSender(Long id, EmailSenderDto emailSenderDto);

    InternalResponse<?> disableEmailSender(Long id);

}
