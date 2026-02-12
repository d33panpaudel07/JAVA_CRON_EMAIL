package com.cron_email.cron_email.features.emailAttachment.dto;

import com.cron_email.cron_email.core.enums.FileTypeEnum;

/**
 * ░█▀▄░▀▀█░▀▀█░█▀█░█▀█░█▀█
 * ░█░█░░▀▄░░▀▄░█▀▀░█▀█░█░█
 * ░▀▀░░▀▀░░▀▀░░▀░░░▀░▀░▀░▀
 *
 * @author d33pan on 2/8/2026
 */
public class EmailAttachmentDto {
    private String fileName;
    private String filePath;
    private FileTypeEnum fileType;
    private Long emailJobId;
}
