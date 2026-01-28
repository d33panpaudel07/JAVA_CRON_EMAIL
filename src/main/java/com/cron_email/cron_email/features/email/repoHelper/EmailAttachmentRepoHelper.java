package com.cron_email.cron_email.features.email.repoHelper;

import com.cron_email.cron_email.features._template._repository.BaseRepository;
import com.cron_email.cron_email.features._template.repoHelper.AbstractBaseRepoHelper;
import com.cron_email.cron_email.features.email._entity.EmailAttachment;
import com.cron_email.cron_email.features.email._repository.EmailAttachmentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@AllArgsConstructor
public class EmailAttachmentRepoHelper extends AbstractBaseRepoHelper<EmailAttachment, Long> {

    private final EmailAttachmentRepository repository;

    @Override
    protected BaseRepository<EmailAttachment, Long> getRepository() {
        return repository;
    }

    @Override
    protected void setActive(EmailAttachment entity, boolean active) {
        entity.setIsActive(active ? 'Y' : 'N');
    }

    @Override
    protected void displayMissingLog(Long id) {
        log.warn("Email attachment with id {} not found", id);
    }

    @Override
    protected String getEntityName() {
        return "EmailAttachment";
    }
}
