package com.cron_email.cron_email.features.emailRecipient.repository;

import com.cron_email.cron_email.features.emailRecipient.entity.EmailRecipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmailRecipientRepository extends JpaRepository<EmailRecipient, Long> {
    @Query("SELECT ea FROM EmailRecipient ea WHERE ea.isActive = :status")
    Optional<EmailRecipient> findByIdAndStatus(Long id, char status);

    @Query("SELECT ea FROM EmailRecipient ea WHERE ea.isActive = :status AND ea.id IN :list")
    List<EmailRecipient> findAllByStatusAndInsideList(char status, List<Long> list);
}
