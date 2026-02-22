package com.cron_email.cron_email.features.emailSender.mapper;

import com.cron_email.cron_email.core.enums.RecipientTypeEnum;
import com.cron_email.cron_email.features.base.mapper.BaseMapper;
import com.cron_email.cron_email.features.emailRecipient.entity.EmailRecipient;
import com.cron_email.cron_email.features.emailJob.dto.internalDto.EmailRecipientDto;
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
