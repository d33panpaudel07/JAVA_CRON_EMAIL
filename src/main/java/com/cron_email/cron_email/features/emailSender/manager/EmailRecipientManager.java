package com.cron_email.cron_email.features.emailSender.manager;

import com.cron_email.cron_email.features.emailRecipient.repository.EmailRecipientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailRecipientManager {
    private final EmailRecipientRepository emailRecipientRepository;

}
