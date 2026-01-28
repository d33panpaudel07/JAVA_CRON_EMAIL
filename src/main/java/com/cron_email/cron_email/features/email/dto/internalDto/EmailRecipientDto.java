package com.cron_email.cron_email.features.email.dto.internalDto;

import com.cron_email.cron_email.features._base.dto.BaseDto;

public class EmailRecipientDto extends BaseDto<Long> {
    private String recipientEmail;
    private String recipientName;
    private String recipientType;
}
