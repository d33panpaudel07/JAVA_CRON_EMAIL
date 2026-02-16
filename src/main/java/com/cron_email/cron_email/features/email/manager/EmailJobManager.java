package com.cron_email.cron_email.features.email.manager;

import com.cron_email.cron_email.core.exception.ResourceNotFoundException;
import com.cron_email.cron_email.features.emailJob.entity.EmailJob;
import com.cron_email.cron_email.features.emailJob.repository.EmailJobRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class EmailJobManager {
    private final EmailJobRepository emailJobRepository;

    public EmailJob getJobById(Long jobId) {
        Optional<EmailJob> emailJobOpt = emailJobRepository.findByIdAndStatus(jobId, 'Y');
        if (emailJobOpt.isEmpty()) {
            log.error("EmailJob with id: {} not found", jobId);
            throw new ResourceNotFoundException("EmailJob with id: " + jobId + " not found");
        }
        return emailJobOpt.get();
    }

    public EmailJob saveJob(EmailJob emailJob) {
        return emailJobRepository.save(emailJob);
    }
}
