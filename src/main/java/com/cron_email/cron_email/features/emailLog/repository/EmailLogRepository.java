package com.cron_email.cron_email.features.emailLog.repository;

import com.cron_email.cron_email.features.emailLog.entity.EmailLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmailLogRepository  extends JpaRepository<EmailLog, Long> {
    @Query("SELECT ea FROM EmailLog ea WHERE ea.isActive = :y")
    Optional<EmailLog> findByIdAndStatus(Long id, char y);

    @Query("SELECT ea FROM EmailLog ea WHERE ea.isActive = :y AND ea.id IN :list")
    List<EmailLog> findAllByStatusAndInsideList(char y, List<Long> list);
}
