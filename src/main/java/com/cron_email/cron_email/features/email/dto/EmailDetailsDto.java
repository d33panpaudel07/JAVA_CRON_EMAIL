package com.cron_email.cron_email.features.email.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author d33pan on 2/8/2026
 */
@Getter
@Setter
public class EmailDetailsDto {
    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;
}
