package pl.wsikora.successbudget.common.currentuser.application;

import org.springframework.security.core.Authentication;
import pl.wsikora.successbudget.common.currentuser.domain.CurrentUser;


public class CurrentUserDtoExtractor {

    private CurrentUserDtoExtractor() {

    }

    public static CurrentUserDto extractCurrentUserDto(Authentication authentication) {

        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();

        return new CurrentUserDto(
                currentUser.getId(),
                currentUser.getName(),
                currentUser.getEmail(),
                currentUser.getUuid(),
                currentUser.isConfigured()
        );
    }
}
