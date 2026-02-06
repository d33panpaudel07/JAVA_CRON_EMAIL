package com.cron_email.cron_email.features.auth.service;

import com.cron_email.cron_email.core.dto.GlobalResponse;
import com.cron_email.cron_email.core.dto.RoleDto;
import com.cron_email.cron_email.core.entity.Role;
import com.cron_email.cron_email.core.entity.User;
import com.cron_email.cron_email.core.exception.BusinessException;
import com.cron_email.cron_email.core.exception.ExceptionMessages;
import com.cron_email.cron_email.core.exception.ResourceNotFoundException;
import com.cron_email.cron_email.core.repository.RoleRepository;
import com.cron_email.cron_email.core.repository.UserRepository;
import com.cron_email.cron_email.security.JwtService;
import com.cron_email.cron_email.features.auth.dto.LoginRequestDto;
import com.cron_email.cron_email.features.auth.dto.LoginResponseDto;
import com.cron_email.cron_email.features.auth.dto.RegisterRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final RoleRepository roleRepository;

    public GlobalResponse<?> createUserByUserDto(RegisterRequestDto userDto) {
        if (userRepository.findByUsername(userDto.getUsername()).isPresent()) {
            throw new BusinessException(ExceptionMessages.USER_ALREADY_EXISTS);
        }

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        String roleName = "USER";
        Optional<Role> role = roleRepository.findByName(roleName);
        if (role.isEmpty()) {
            throw new ResourceNotFoundException("Role", "name", roleName);
        }
        Set<Role> userRoles = Set.of(role.get());
        user.setRoles(userRoles);

        userRepository.save(user);
        return new GlobalResponse<>(true, "User Created Successfully", userDto);
    }

    public GlobalResponse<LoginResponseDto> loginUserByLoginRequestDto(LoginRequestDto loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        String token = jwtService.generateToken(loginRequest.getUsername());
        Date expiryTime = jwtService.generateExpiryTime();
        String username = loginRequest.getUsername();

        User user = userRepository.findByUsername(loginRequest.getUsername()).get();
        String email = user.getEmail();
        Set<RoleDto> rolesDto = user.getRoles().stream()
                .map(RoleDto::new)
                .collect(Collectors.toSet());

        return new GlobalResponse<>(
                true,
                "Login Successful",
                new LoginResponseDto(token, expiryTime, username, email, rolesDto)
        );
    }
}
