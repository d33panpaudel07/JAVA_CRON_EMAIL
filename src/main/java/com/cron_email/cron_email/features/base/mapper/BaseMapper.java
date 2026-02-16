package com.cron_email.cron_email.features.base.mapper;

import com.cron_email.cron_email.features.base.dto.BaseDto;
import com.cron_email.cron_email.features.base.entity.BaseEntity;
import lombok.extern.slf4j.Slf4j;

// todo: scrap this whole file as auditing may get updated unintentionally

/**
 * E -> Entity
 * D -> DTO
 */
@Slf4j
public class BaseMapper {
    public static <E extends BaseEntity<Long>, D extends BaseDto<Long>> void toEntity(D dto, E entity) {
        if (dto == null) {
            log.warn("DTO is null");
        }

        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }

        if (dto.getCreatedAt() != null) {
            entity.setCreatedAt(dto.getCreatedAt());
        }

        if (dto.getUpdatedAt() != null) {
            entity.setUpdatedAt(dto.getUpdatedAt());
        }

        if (dto.getCreatedById() != null) {
            entity.setCreatedById(dto.getCreatedById());
        }

        if (dto.getUpdatedById() != null) {
            entity.setUpdatedById(dto.getUpdatedById());
        }

        if (dto.getIsActive() != null) {
            entity.setIsActive(dto.getIsActive());
        }

    }

    public static <E extends BaseEntity<Long>, D extends BaseDto<Long>> void toDto(E entity, D dto) {
        if (entity == null) {
            log.warn("DTO is null");
        }

        if (entity.getId() != null) {
            dto.setId(entity.getId());
        }

        if (entity.getCreatedAt() != null) {
            dto.setCreatedAt(entity.getCreatedAt());
        }

        if (entity.getUpdatedAt() != null) {
            dto.setUpdatedAt(entity.getUpdatedAt());
        }

        if (entity.getCreatedById() != null) {
            dto.setCreatedById(entity.getCreatedById());
        }

        if (entity.getUpdatedById() != null) {
            dto.setUpdatedById(entity.getUpdatedById());
        }

        if (entity.getIsActive() != null) {
            dto.setIsActive(entity.getIsActive());
        }

    }

}
