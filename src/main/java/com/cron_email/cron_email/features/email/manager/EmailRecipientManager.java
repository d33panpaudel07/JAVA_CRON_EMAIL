package com.cron_email.cron_email.features.email.manager;

import com.cron_email.cron_email.features.email.repoHelper.EmailRecipientRepoHelper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailRecipientManager {
    private final EmailRecipientRepoHelper emailRecipientRepoHelper;

}
