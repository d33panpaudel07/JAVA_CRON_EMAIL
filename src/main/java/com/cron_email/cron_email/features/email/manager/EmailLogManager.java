package com.cron_email.cron_email.features.email.manager;

import com.cron_email.cron_email.features._template._repository.BaseRepository;
import com.cron_email.cron_email.features._template.manager.AbstractBaseManager;
import com.cron_email.cron_email.features.email._entity.EmailLog;
import com.cron_email.cron_email.features.email._repository.EmailLogRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class EmailLogManager extends AbstractBaseManager<EmailLog, Long> {

    private final EmailLogRepository repository;

    @Override
    protected BaseRepository<EmailLog, Long> getRepository() {
        return repository;
    }

    @Override
    protected void setActive(EmailLog entity, boolean active) {
        entity.setIsActive(active ? 'Y' : 'N');
    }

    @Override
    protected void displayMissingLog(Long id) {
        log.warn("Email log with id {} not found", id);
    }

    @Override
    protected String getEntityName() {
        return "EmailLog";
    }
}
