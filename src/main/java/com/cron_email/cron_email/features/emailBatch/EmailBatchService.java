package com.cron_email.cron_email.features.emailBatch;

import com.cron_email.cron_email.core.dto.InternalResponse;
import com.cron_email.cron_email.features.emailBatch.dto.EmailBatchDto;

/**
 * @author d33pan on 2/22/2026
 */
public interface EmailBatchService {
    InternalResponse<?> createEmailBatch(EmailBatchDto emailBatchDto);

    InternalResponse<?> updateEmailBatch(Long batchId, EmailBatchDto emailBatchDto);

    InternalResponse<?> readById(Long batchId);

    InternalResponse<?> readAllActive();

    InternalResponse<?> deleteEmailBatch(Long id);
}
