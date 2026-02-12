package com.cron_email.cron_email.features.email.impl;

import com.cron_email.cron_email.core.dto.GlobalResponse;
import com.cron_email.cron_email.features.email.entity.EmailJob;
import com.cron_email.cron_email.features.email.dto.ScheduleEmailDto;
import com.cron_email.cron_email.features.email.dto.internalDto.EmailRecipientDto;
import com.cron_email.cron_email.features.email.manager.EmailJobManager;
import com.cron_email.cron_email.features.email.mapper.EmailJobMapper;
import com.cron_email.cron_email.features.email.service.CronEmailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.cron_email.cron_email.core.constants.ResponseConstants.SUCCESS;

@Slf4j
@Service
@AllArgsConstructor
public class CronEmailImpl implements CronEmailService {

    private final EmailJobManager emailJobManager;

    @Override
    public GlobalResponse<?> createScheduledEmail(ScheduleEmailDto dto) {
        EmailJob emailJob = EmailJobMapper.toEntity(dto, new EmailJob());

        emailJob = emailJobManager.saveJob(emailJob);

        return GlobalResponse.successResponse(SUCCESS, emailJob);
    }

    @Override
    public GlobalResponse<?> updateScheduledEmail(ScheduleEmailDto dto) {
        return null;
    }

    @Override
    public GlobalResponse<?> enableScheduledEmailJob(Long jobId) {
        return null;
    }

    @Override
    public GlobalResponse<?> disableScheduledEmailJob(Long jobId) {
        return null;
    }

    @Override
    public GlobalResponse<?> getAllActiveJobs() {
        return null;
    }

    @Override
    public GlobalResponse<?> getRecipientsByJobId(Long jobId) {
        return null;
    }

    @Override
    public GlobalResponse<?> addRecipientsToJob(Long jobId, List<EmailRecipientDto> recipients) {
        return null;
    }

    @Override
    public GlobalResponse<?> removeRecipient(Long recipientId) {
        return null;
    }

    @Override
    public GlobalResponse<?> getLogsByJobId(Long jobId) {
        return null;
    }

    @Override
    public GlobalResponse<?> getJobByJobId(Long jobId) {
        //aop for automatic logging request and response

        EmailJob emailJob = emailJobManager.getJobById(jobId);

        ScheduleEmailDto emailJobDto = EmailJobMapper.toDto(emailJob);

        return GlobalResponse.successResponse(SUCCESS, emailJobDto);
    }
}
