package com.cron_email.cron_email.systemConfig.repository;

import com.cron_email.cron_email.systemConfig.entity.SystemConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * ░█▀▄░▀▀█░▀▀█░█▀█░█▀█░█▀█
 * ░█░█░░▀▄░░▀▄░█▀▀░█▀█░█░█
 * ░▀▀░░▀▀░░▀▀░░▀░░░▀░▀░▀░▀
 *
 * @author d33pan on 2/12/2026
 */
public interface SystemConfigRepo extends JpaRepository<SystemConfig, Long> {
    @Query("SELECT sc FROM SystemConfig sc WHERE sc.isActive = :status")
    List<SystemConfig> getAllByStatus(char status);

    @Query("SELECT sc FROM SystemConfig sc WHERE sc.id = :id AND sc.isActive = :status")
    Optional<SystemConfig> getByIdAndStatus(Long id, char status);
}
