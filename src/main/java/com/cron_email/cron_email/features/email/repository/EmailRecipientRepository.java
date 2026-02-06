package com.cron_email.cron_email.features.email.repository;

import com.cron_email.cron_email.features.template.repository.BaseRepository;
import com.cron_email.cron_email.features.email.entity.EmailRecipient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmailRecipientRepository  extends BaseRepository<EmailRecipient, Long> {
    @Query("SELECT ea FROM EmailRecipient ea WHERE ea.isActive = :y")
    Optional<EmailRecipient> findByIdAndStatus(Long id, char y);

    @Query("SELECT ea FROM EmailRecipient ea WHERE ea.isActive = :y AND ea.id IN :list")
    List<EmailRecipient> findAllByStatusAndInsideList(char y, List<Long> list);
}
