package com.cron_email.cron_email.features.emailJob.dto;

import com.cron_email.cron_email.features.emailAttachment.dto.EmailAttachmentDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmailJobDto{
    private String jobName;
    private String cronExpression;
    private String subject;
    private String body;
    private List<String> recipientsEmail;
    private List<EmailAttachmentDto> emailAttachments;
}
