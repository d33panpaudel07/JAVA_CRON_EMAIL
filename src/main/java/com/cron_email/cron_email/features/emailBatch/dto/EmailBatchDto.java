package com.cron_email.cron_email.features.emailBatch.dto;

import com.cron_email.cron_email.features.base.dto.BaseDto;

import java.util.List;

/**
 * @author d33pan on 2/22/2026
 */
public class EmailBatchDto extends BaseDto<Long> {
    private String batchName;
    private List<String> recipientEmails;
}
