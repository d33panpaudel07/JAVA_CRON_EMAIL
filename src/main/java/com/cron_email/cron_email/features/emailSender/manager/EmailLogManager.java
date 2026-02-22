package com.cron_email.cron_email.features.emailSender.manager;

import com.cron_email.cron_email.features.emailLog.repository.EmailLogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailLogManager {
    private final EmailLogRepository emailLogRepository;

}
