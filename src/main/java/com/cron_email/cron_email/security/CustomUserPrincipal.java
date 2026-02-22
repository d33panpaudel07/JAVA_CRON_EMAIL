package com.cron_email.cron_email.security;

import com.cron_email.cron_email.core.entity.User;
import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * ░█▀▄░▀▀█░▀▀█░█▀█░█▀█░█▀█
 * ░█░█░░▀▄░░▀▄░█▀▀░█▀█░█░█
 * ░▀▀░░▀▀░░▀▀░░▀░░░▀░▀░▀░▀
 *
 * @author d33pan on 2/16/2026
 */
@Getter
@Setter
@RequiredArgsConstructor
public class CustomUserPrincipal implements UserDetails {

    private final User user;
    private final Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public @Nullable String getPassword() {
        return user.getPassword();
    }

    @Override
    public @Nullable String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.getIsAccountExpired() != null && user.getIsAccountExpired() != 'Y';
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.getIsLocked() != null && user.getIsLocked() != 'Y';
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.getIsCredentialExpired() != null && user.getIsCredentialExpired() != 'Y';
    }

    @Override
    public boolean isEnabled() {
        return user.getIsActive() != null && user.getIsActive() == 'Y';
    }
}
