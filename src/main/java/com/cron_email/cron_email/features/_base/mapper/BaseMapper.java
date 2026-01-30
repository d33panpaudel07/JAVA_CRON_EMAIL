package com.cron_email.cron_email.features._base.mapper;

import com.cron_email.cron_email.features._base.dto.BaseDto;
import com.cron_email.cron_email.features._base.entity.BaseEntity;
import lombok.extern.slf4j.Slf4j;

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

        if (dto.getCreatedBy() != null) {
            entity.setCreatedBy(dto.getCreatedBy());
        }

        if (dto.getUpdatedBy() != null) {
            entity.setUpdatedBy(dto.getUpdatedBy());
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

        if (entity.getCreatedBy() != null) {
            dto.setCreatedBy(entity.getCreatedBy());
        }

        if (entity.getUpdatedBy() != null) {
            dto.setUpdatedBy(entity.getUpdatedBy());
        }

        if (entity.getIsActive() != null) {
            dto.setIsActive(entity.getIsActive());
        }

    }

}
