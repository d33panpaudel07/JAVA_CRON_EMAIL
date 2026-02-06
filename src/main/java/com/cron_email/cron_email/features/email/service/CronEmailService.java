package com.cron_email.cron_email.features.email.service;

import com.cron_email.cron_email.core.dto.GlobalResponse;
import com.cron_email.cron_email.features.email.dto.ScheduleEmailDto;
import com.cron_email.cron_email.features.email.dto.internalDto.EmailRecipientDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CronEmailService {

    GlobalResponse<?> createScheduledEmail(ScheduleEmailDto dto);

    GlobalResponse<?> updateScheduledEmail(ScheduleEmailDto dto);

    GlobalResponse<?> enableScheduledEmailJob(Long jobId);
    GlobalResponse<?> disableScheduledEmailJob(Long jobId);

    GlobalResponse<?> getAllActiveJobs();

    GlobalResponse<?> getRecipientsByJobId(Long jobId);

    GlobalResponse<?> addRecipientsToJob(Long jobId, List<EmailRecipientDto> recipients);

    GlobalResponse<?> removeRecipient(Long recipientId);

    GlobalResponse<?> getLogsByJobId(Long jobId);

    GlobalResponse<?> getJobByJobId(Long jobId);

}
