package com.cron_email.cron_email.security;

import com.cron_email.cron_email.core.entity.User;
import com.cron_email.cron_email.core.exception.BusinessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * ░█▀▄░▀▀█░▀▀█░█▀█░█▀█░█▀█
 * ░█░█░░▀▄░░▀▄░█▀▀░█▀█░█░█
 * ░▀▀░░▀▀░░▀▀░░▀░░░▀░▀░▀░▀
 *
 * @author d33pan on 8/18/25
 */
public class AuthenticationUtil {
    public static User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(!isUserAuthenticated(authentication)){
            return null;
        }

        Object principal = authentication.getPrincipal();

        if (principal instanceof CustomUserPrincipal customUser) {
            return (customUser).getUser();
        } else {
            throw new BusinessException("Principal is not instance of UserDetails");
        }
    }

    private static boolean isUserAuthenticated(Authentication authentication){
        return authentication != null && authentication.isAuthenticated();
    }


}
