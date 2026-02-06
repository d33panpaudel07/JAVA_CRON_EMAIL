package com.cron_email.cron_email.features.email.dto.internalDto;

import com.cron_email.cron_email.features.base.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailRecipientDto extends BaseDto<Long> {
    private String recipientEmail;
    private String recipientName;
    private String recipientType;
}
