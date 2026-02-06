package com.cron_email.cron_email.features.email.manager;

import com.cron_email.cron_email.features.email.entity.EmailJob;
import com.cron_email.cron_email.features.email.repoHelper.EmailJobRepoHelper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class EmailJobManager {
    private final EmailJobRepoHelper emailJobRepoHelper;

    public EmailJob getJobById(Long jobId) {
        Optional<EmailJob> emailJobOpt = emailJobRepoHelper.findByIdAndStatus(jobId, 'Y');
        if(emailJobOpt.isEmpty()){
            log.error("EmailJob with id: {} not found", jobId);
            throw new RuntimeException("EmailJob with id: " + jobId + " not found");
        }
        return emailJobOpt.get();
    }

    public EmailJob saveJob(EmailJob emailJob) {
        return emailJobRepoHelper.save(emailJob);
    }
}
