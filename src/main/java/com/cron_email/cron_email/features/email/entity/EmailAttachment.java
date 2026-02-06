package com.cron_email.cron_email.features.email.entity;

import com.cron_email.cron_email.core.enums.FileTypeEnum;
import com.cron_email.cron_email.features.base.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "EMAIL_ATTACHMENT")
@Getter
@Setter
@NoArgsConstructor
public class EmailAttachment extends BaseEntity<Long> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMAIL_JOB_ID")
    private EmailJob emailJob;

    @Column(name = "FILE_NAME")
    private String fileName;

    @Column(name = "FILE_PATH")
    private String filePath;

    @Column(name = "FILE_TYPE")
    @Enumerated(EnumType.STRING)
    private FileTypeEnum fileType;

}
