package com.cron_email.cron_email.controller;

import com.cron_email.cron_email.core.constants.ControllerConstants;
import com.cron_email.cron_email.core.dto.GlobalResponse;
import com.cron_email.cron_email.core.dto.InternalResponse;
import com.cron_email.cron_email.features.email.dto.EmailSenderDto;
import com.cron_email.cron_email.features.email.service.EmailSenderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * To crud emails that can be used to send emails by logged in user
 *
 * @author d33pan on 2/16/2026
 */
@RestController
@RequestMapping("/v1/email")
@AllArgsConstructor
public class EmailSenderController {

    private final EmailSenderService emailSenderService;

    @GetMapping(ControllerConstants.READ_BY_ID + "/{id}")
    public GlobalResponse<?> getSystemConfigById(@PathVariable Long id){
        InternalResponse<?> response = emailSenderService.readEmailSenderById(id);
        return GlobalResponse.successResponse(response);
    }

    @GetMapping(ControllerConstants.READ_ALL)
    public GlobalResponse<?> getAllSystemConfig(){
        InternalResponse<?> response = emailSenderService.readAllEmail();
        return GlobalResponse.successResponse(response);
    }

    @PostMapping(ControllerConstants.CREATE)
    public GlobalResponse<?> getAllSystemConfig(@RequestBody EmailSenderDto emailSenderDto){
        InternalResponse<?> response = emailSenderService.createEmailSender(emailSenderDto);
        return GlobalResponse.successResponse(response);
    }

    @PutMapping(ControllerConstants.UPDATE + "/{id}")
    public GlobalResponse<?> updateSystemConfig(@PathVariable Long id, @RequestBody EmailSenderDto emailSenderDto){
        InternalResponse<?> response = emailSenderService.updateEmailSender(id, emailSenderDto);
        return GlobalResponse.successResponse(response);
    }

    @DeleteMapping(ControllerConstants.DELETE_BY_ID + "/{id}")
    public GlobalResponse<?> deleteEmailSender(@PathVariable Long id){
        InternalResponse<?> response = emailSenderService.disableEmailSender(id);
        return GlobalResponse.successResponse(response);
    }

}
