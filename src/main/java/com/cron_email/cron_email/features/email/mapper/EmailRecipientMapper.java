package com.cron_email.cron_email.features.email.mapper;

import com.cron_email.cron_email.features.email._entity.EmailRecipient;
import com.cron_email.cron_email.features.email.dto.internalDto.EmailRecipientDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailRecipientMapper {
    private static EmailRecipient toEntity(EmailRecipientDto emailRecipientDto){
        if(emailRecipientDto == null){
            log.warn("EmailRecipientDto is null");
            return null;
        };

        EmailRecipient emailRecipient = new EmailRecipient();
//        emailRecipient.
        return emailRecipient;
    }
}
