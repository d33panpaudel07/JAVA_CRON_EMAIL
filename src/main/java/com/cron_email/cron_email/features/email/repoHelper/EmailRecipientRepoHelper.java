package com.cron_email.cron_email.features.email.repoHelper;

import com.cron_email.cron_email.features.template.repository.BaseRepository;
import com.cron_email.cron_email.features.template.repoHelper.AbstractBaseRepoHelper;
import com.cron_email.cron_email.features.email.entity.EmailRecipient;
import com.cron_email.cron_email.features.email.repository.EmailRecipientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class EmailRecipientRepoHelper extends AbstractBaseRepoHelper<EmailRecipient, Long> {

    private final EmailRecipientRepository repository;

    @Override
    protected BaseRepository<EmailRecipient, Long> getRepository() {
        return repository;
    }

    @Override
    protected void setActive(EmailRecipient entity, boolean active) {
        entity.setIsActive(active ? 'Y' : 'N');
    }

    @Override
    protected void displayMissingLog(Long id) {
        log.warn("Email recipient with id {} not found", id);
    }

    @Override
    protected String getEntityName() {
        return "EmailRecipient";
    }
}
