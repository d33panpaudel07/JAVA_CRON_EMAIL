package com.cron_email.cron_email.features.email.repository;

import com.cron_email.cron_email.features.template.repository.BaseRepository;
import com.cron_email.cron_email.features.email.entity.EmailJob;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmailJobRepository  extends BaseRepository<EmailJob, Long> {
    @Query("SELECT ea FROM EmailJob ea WHERE ea.isActive = :y")
    Optional<EmailJob> findByIdAndStatus(Long id, char y);

    @Query("SELECT ea FROM EmailJob ea WHERE ea.isActive = :y AND ea.id IN :list")
    List<EmailJob> findAllByStatusAndInsideList(char y, List<Long> list);
}
