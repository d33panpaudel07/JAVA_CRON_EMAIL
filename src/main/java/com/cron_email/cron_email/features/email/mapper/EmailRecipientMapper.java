package com.cron_email.cron_email.features.email.mapper;

import com.cron_email.cron_email._core.enums.RecipientTypeEnum;
import com.cron_email.cron_email.features._base.mapper.BaseMapper;
import com.cron_email.cron_email.features.email._entity.EmailRecipient;
import com.cron_email.cron_email.features.email.dto.internalDto.EmailRecipientDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailRecipientMapper {
    public static EmailRecipient toEntity(EmailRecipientDto emailRecipientDto) {
        if (emailRecipientDto == null) {
            log.warn("EmailRecipientDto is null");
            return null;
        }

        EmailRecipient emailRecipient = new EmailRecipient();

        BaseMapper.toEntity(emailRecipientDto, emailRecipient);

        emailRecipient.setRecipientEmail(emailRecipientDto.getRecipientEmail());
        emailRecipient.setRecipientName(emailRecipientDto.getRecipientName());

        if (emailRecipientDto.getRecipientType() != null) {
            emailRecipient.setRecipientType(
                    RecipientTypeEnum.valueOf(emailRecipientDto.getRecipientType())
            );
        }

        return emailRecipient;
    }

}
