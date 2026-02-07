package com.cron_email.cron_email.features.email.manager;

import com.cron_email.cron_email.features.email.repository.EmailAttachmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailAttachmentManager {
    private final EmailAttachmentRepository emailAttachmentRepository;



}
