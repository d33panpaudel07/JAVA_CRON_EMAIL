package com.cron_email.cron_email.features.email.repoHelper;

import com.cron_email.cron_email.features.template.repository.BaseRepository;
import com.cron_email.cron_email.features.template.repoHelper.AbstractBaseRepoHelper;
import com.cron_email.cron_email.features.email.entity.EmailJob;
import com.cron_email.cron_email.features.email.repository.EmailJobRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class EmailJobRepoHelper extends AbstractBaseRepoHelper<EmailJob, Long> {

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
