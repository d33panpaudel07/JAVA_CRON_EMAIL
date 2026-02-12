package com.cron_email.cron_email.systemConfig.repository;

import com.cron_email.cron_email.systemConfig.entity.SubSystemConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * ░█▀▄░▀▀█░▀▀█░█▀█░█▀█░█▀█
 * ░█░█░░▀▄░░▀▄░█▀▀░█▀█░█░█
 * ░▀▀░░▀▀░░▀▀░░▀░░░▀░▀░▀░▀
 *
 * @author d33pan on 2/12/2026
 */
public interface SubSystemConfigRepo extends JpaRepository<SubSystemConfig, Long> {
    Optional<SubSystemConfig> getSubSystemConfigByIdAndIsActive(Long id, Character isActive);
}
