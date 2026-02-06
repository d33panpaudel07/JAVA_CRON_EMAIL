package com.cron_email.cron_email.features.email.controller;

import com.cron_email.cron_email.core.dto.GlobalResponse;
import com.cron_email.cron_email.features.email.service.CronEmailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.cron_email.cron_email.core.constants.ControllerConstants.*;

@Slf4j
@RestController
@RequestMapping("/v1/email")
@AllArgsConstructor
public class EmailController {

    private final CronEmailService cronEmailService;

    @GetMapping(GET_BY_ID + "/{jobId}")
    public GlobalResponse<?> getById(@PathVariable Long jobId) {
        log.info("Fetching logs by jobId: {}", jobId);
        return cronEmailService.getJobByJobId(jobId);
    }
}
