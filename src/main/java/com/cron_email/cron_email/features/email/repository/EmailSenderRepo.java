package com.cron_email.cron_email.features.email.repository;

import com.cron_email.cron_email.features.email.entity.EmailSender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * ░█▀▄░▀▀█░▀▀█░█▀█░█▀█░█▀█
 * ░█░█░░▀▄░░▀▄░█▀▀░█▀█░█░█
 * ░▀▀░░▀▀░░▀▀░░▀░░░▀░▀░▀░▀
 *
 * @author d33pan on 2/16/2026
 */
public interface EmailSenderRepo extends JpaRepository<EmailSender, Long> {
    @Query("SELECT es FROM EmailSender es WHERE es.id = :id AND es.isActive = :status")
    Optional<EmailSender> getByIdAndStatus(Long id, Character status);

    @Query("SELECT es FROM EmailSender es WHERE es.isActive = :status")
    List<EmailSender> getAllByStatus(Character status);
}
