package com.cron_email.cron_email.features.email.dto;

import com.cron_email.cron_email.features.base.dto.BaseDto;
import com.cron_email.cron_email.features.email.dto.internalDto.EmailRecipientDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ScheduleEmailDto extends BaseDto<Long> {
    private String jobName;
    private String cronExpression;
    private String subject;
    private String body;
    private List<EmailRecipientDto> emailRecipientDtoList;

}
