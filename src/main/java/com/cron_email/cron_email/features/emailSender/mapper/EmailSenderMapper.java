package com.cron_email.cron_email.features.emailSender.mapper;

import com.cron_email.cron_email.features.emailSender.dto.EmailSenderDto;
import com.cron_email.cron_email.features.emailSender.entity.EmailSender;
import lombok.extern.slf4j.Slf4j;

/**
 * ░█▀▄░▀▀█░▀▀█░█▀█░█▀█░█▀█
 * ░█░█░░▀▄░░▀▄░█▀▀░█▀█░█░█
 * ░▀▀░░▀▀░░▀▀░░▀░░░▀░▀░▀░▀
 *
 * @author d33pan on 2/16/2026
 */
@Slf4j
public class EmailSenderMapper {
    public static EmailSender toEntity(EmailSenderDto dto, EmailSender entity) {

        if (dto == null) {
            log.warn("EmailSenderDto is null");
            return null;
        }

        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setSmtpHost(dto.getSmtpHost());
        entity.setSmtpPort(dto.getSmtpPort());
        entity.setIsTlsEnabled(dto.getIsTlsEnabled());

        return entity;
    }

    public static EmailSenderDto toDto(EmailSender entity, EmailSenderDto dto) {

        if (entity == null) {
            log.warn("EmailSender entity is null");
            return null;
        }

        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setSmtpHost(entity.getSmtpHost());
        dto.setSmtpPort(entity.getSmtpPort());
        dto.setIsTlsEnabled(entity.getIsTlsEnabled());
        dto.setId(entity.getId());

        return dto;
    }
}
