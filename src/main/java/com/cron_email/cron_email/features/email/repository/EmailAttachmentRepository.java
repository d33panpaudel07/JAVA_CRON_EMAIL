package com.cron_email.cron_email.features.email.repository;

import com.cron_email.cron_email.features.template.repository.BaseRepository;
import com.cron_email.cron_email.features.email.entity.EmailAttachment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmailAttachmentRepository extends BaseRepository<EmailAttachment, Long> {
    @Query("SELECT ea FROM EmailAttachment ea WHERE ea.isActive = :y")
    Optional<EmailAttachment> findByIdAndStatus(Long id, char y);

    @Query("SELECT ea FROM EmailAttachment ea WHERE ea.isActive = :y AND ea.id IN :list")
    List<EmailAttachment> findAllByStatusAndIdsList(char y, List<Long> list);
}
