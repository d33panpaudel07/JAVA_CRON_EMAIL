package com.cron_email.cron_email.features._auth.dto;

import com.cron_email.cron_email._core.dto.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponseDto {
    private String accessToken;
    private Date expiresIn;
    private String username;
    private String email;
    private Set<RoleDto> roles;
}
