package com.cron_email.cron_email.features._base.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseDto<ID> {
    private ID id;
    private Character isActive;
}
