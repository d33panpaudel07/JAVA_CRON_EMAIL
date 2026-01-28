package com.cron_email.cron_email.features.email.manager;

import com.cron_email.cron_email.features._template._repository.BaseRepository;
import com.cron_email.cron_email.features._template.manager.AbstractBaseManager;
import com.cron_email.cron_email.features.email._entity.EmailRecipient;
import com.cron_email.cron_email.features.email._repository.EmailRecipientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class EmailRecipientManager extends AbstractBaseManager<EmailRecipient, Long> {

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
