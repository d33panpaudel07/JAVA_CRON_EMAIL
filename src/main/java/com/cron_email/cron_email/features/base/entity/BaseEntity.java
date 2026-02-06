package com.cron_email.cron_email.features.base.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity<ID> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private ID id;

    @CreatedDate
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    @CreatedBy
    @Column(name = "CREATED_BY_ID")
    private String createdBy;

    @LastModifiedBy
    @Column(name = "UPDATED_BY_ID")
    private String updatedBy;

    @Column(name = "IS_ACTIVE")
    private Character isActive = 'Y';
}
