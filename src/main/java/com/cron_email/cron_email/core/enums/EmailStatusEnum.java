package com.cron_email.cron_email.core.enums;

public enum EmailStatusEnum {
    PENDING,    // Waiting to be sent
    SENT,       // Successfully sent
    FAILED,     // Failed to send
    RETRYING,   // Retrying after failure
    CANCELLED,  // Sending cancelled by user/process
    QUEUED      // In queue, waiting for processing
}
