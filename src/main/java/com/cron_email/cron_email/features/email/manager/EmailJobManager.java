package com.cron_email.cron_email.features.email.manager;

import com.cron_email.cron_email.features._template._repository.BaseRepository;
import com.cron_email.cron_email.features._template.manager.AbstractBaseManager;
import com.cron_email.cron_email.features.email._entity.EmailJob;
import com.cron_email.cron_email.features.email._repository.EmailJobRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class EmailJobManager extends AbstractBaseManager<EmailJob, Long> {

    private final EmailJobRepository repository;

    @Override
    protected BaseRepository<EmailJob, Long> getRepository() {
        return repository;
    }

    @Override
    protected void setActive(EmailJob entity, boolean active) {
        entity.setIsActive(active ? 'Y' : 'N');
    }

    @Override
    protected void displayMissingLog(Long id) {
        log.warn("Email job with id {} not found", id);
    }

    @Override
    protected String getEntityName() {
        return "EmailJob";
    }
}
