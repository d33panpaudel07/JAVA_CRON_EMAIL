package com.cron_email.cron_email.features.email.controller;

import com.cron_email.cron_email.core.dto.GlobalResponse;
import com.cron_email.cron_email.core.dto.InternalResponse;
import com.cron_email.cron_email.features.email.dto.EmailDetails;
import com.cron_email.cron_email.features.email.service.EmailService;
import com.cron_email.cron_email.features.email.service.CronEmailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.cron_email.cron_email.core.constants.ControllerConstants.READ_BY_ID;

@Slf4j
@RestController
@RequestMapping("/v1/email")
@AllArgsConstructor
public class EmailController {

    private final CronEmailService cronEmailService;

    // todo: d33pan, replace email service with CronEmailService which utilizes this service below to do work
    private final EmailService emailService;

    @GetMapping(READ_BY_ID + "/{jobId}")
    public GlobalResponse<?> getById(@PathVariable Long jobId) {
        log.info("Fetching logs by jobId: {}", jobId);
        return cronEmailService.getJobByJobId(jobId);
    }

    @PostMapping("/sendMail")
    public ResponseEntity<?> sendMail(@RequestBody EmailDetails details) {

        // todo: d33pan, need to change dto from EmailDetails to EmailJobDto

        InternalResponse<?> internalResponse = emailService.sendEmail(details);
        return ResponseEntity.ok(internalResponse);
    }

    @PostMapping("/sendMailWithAttachment")
    public ResponseEntity<?> sendMailWithAttachment(@RequestBody EmailDetails details) {
        InternalResponse<?> internalResponse = emailService.sendEmailWithAttachment(details);
        return ResponseEntity.ok(internalResponse);
    }
}
