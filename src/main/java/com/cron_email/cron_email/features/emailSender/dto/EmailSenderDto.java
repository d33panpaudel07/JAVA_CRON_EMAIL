package com.cron_email.cron_email.features.emailSender.dto;

import com.cron_email.cron_email.features.base.dto.BaseDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * @author d33pan on 2/16/2026
 */
@Getter
@Setter
public class EmailSenderDto extends BaseDto<Long> {
    @NotBlank(message = "Email cannot be blank")
    @Email
    private String email;
    @NotBlank(message = "Password cannot be blank")
    private String password;

    @NotBlank(message = "Password cannot be blank")
    private String smtpHost;
    @NotNull(message = "SMTP port is required")
    private Long smtpPort;

    private Character isTlsEnabled;
}
