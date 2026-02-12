package com.cron_email.cron_email.features.email.mapper;

import com.cron_email.cron_email.features.base.mapper.BaseMapper;
import com.cron_email.cron_email.features.email.entity.EmailJob;
import com.cron_email.cron_email.features.email.dto.ScheduleEmailDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailJobMapper {
    public static EmailJob toEntity(ScheduleEmailDto scheduleEmailDto, EmailJob emailJob) {
        if (scheduleEmailDto == null) {
            log.warn("ScheduleEmailDto is null, conversion to entity failed");
            return null;
        }

        BaseMapper.toEntity(scheduleEmailDto, emailJob);

        emailJob.setJobName(scheduleEmailDto.getJobName());
        emailJob.setCronExpression(scheduleEmailDto.getCronExpression());
        emailJob.setSubject(scheduleEmailDto.getSubject());
        emailJob.setBody(scheduleEmailDto.getBody());

        return emailJob;
    }

    public static ScheduleEmailDto toDto(EmailJob emailJob) {
        if (emailJob == null) {
            log.warn("ScheduleEmailDto is null, conversion to dto failed");
            return null;
        }

        ScheduleEmailDto scheduleEmailDto = new ScheduleEmailDto();

        BaseMapper.toDto(emailJob, scheduleEmailDto);

        scheduleEmailDto.setJobName(emailJob.getJobName());
        scheduleEmailDto.setCronExpression(emailJob.getCronExpression());
        scheduleEmailDto.setSubject(emailJob.getSubject());
        scheduleEmailDto.setBody(emailJob.getBody());

        return scheduleEmailDto;
    }
}
