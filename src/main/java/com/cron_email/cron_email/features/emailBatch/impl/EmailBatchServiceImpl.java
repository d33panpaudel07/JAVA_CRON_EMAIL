package com.cron_email.cron_email.features.emailBatch.impl;

import com.cron_email.cron_email.core.dto.InternalResponse;
import com.cron_email.cron_email.features.emailBatch.EmailBatchService;
import com.cron_email.cron_email.features.emailBatch.dto.EmailBatchDto;

/**
 * ░█▀▄░▀▀█░▀▀█░█▀█░█▀█░█▀█
 * ░█░█░░▀▄░░▀▄░█▀▀░█▀█░█░█
 * ░▀▀░░▀▀░░▀▀░░▀░░░▀░▀░▀░▀
 *
 * @author d33pan on 2/22/2026
 */
public class EmailBatchServiceImpl implements EmailBatchService {
    @Override
    public InternalResponse<?> createEmailBatch(EmailBatchDto emailBatchDto) {



        return null;
    }

    @Override
    public InternalResponse<?> updateEmailBatch(Long batchId, EmailBatchDto emailBatchDto) {
        return null;
    }

    @Override
    public InternalResponse<?> readById(Long batchId) {
        return null;
    }

    @Override
    public InternalResponse<?> readAllActive() {
        return null;
    }

    @Override
    public InternalResponse<?> deleteEmailBatch(Long id) {
        return null;
    }
}
