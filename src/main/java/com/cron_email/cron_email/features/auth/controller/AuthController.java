package com.cron_email.cron_email.features.auth.controller;

import com.cron_email.cron_email.features.auth.dto.LoginRequestDto;
import com.cron_email.cron_email.features.auth.dto.RegisterRequestDto;
import com.cron_email.cron_email.features.auth.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ░█▀▄░▀▀█░▀▀█░█▀█░█▀█░█▀█
 * ░█░█░░▀▄░░▀▄░█▀▀░█▀█░█░█
 * ░▀▀░░▀▀░░▀▀░░▀░░░▀░▀░▀░▀
 *
 * @author d33pan on 1/26/2026
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDto userDto) {
        return ResponseEntity.ok(authenticationService.createUserByUserDto(userDto));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequest) {
        return ResponseEntity.ok(authenticationService.loginUserByLoginRequestDto(loginRequest));
    }
}
