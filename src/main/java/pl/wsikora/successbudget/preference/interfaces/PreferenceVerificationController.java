package pl.wsikora.successbudget.preference.interfaces;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.successbudget.common.currentuser.application.CurrentUserDto;

import static pl.wsikora.successbudget.common.Constants.ID;
import static pl.wsikora.successbudget.common.Redirector.redirect;
import static pl.wsikora.successbudget.common.Redirector.redirectWithQueryParameter;
import static pl.wsikora.successbudget.common.currentuser.application.CurrentUserDtoExtractor.extractCurrentUserDto;
import static pl.wsikora.successbudget.dashboard.DashboardConstants.DASHBOARD_URL;
import static pl.wsikora.successbudget.preference.interfaces.PreferenceConstants.AFTER_LOGIN_URL;
import static pl.wsikora.successbudget.preference.interfaces.PreferenceConstants.PREFERENCE_EDIT_URL;


@Controller
@RequestMapping(AFTER_LOGIN_URL)
public class PreferenceVerificationController {

    @GetMapping
    private String verifyPreferenceSetting(Authentication authentication) {

        CurrentUserDto currentUserDto = extractCurrentUserDto(authentication);

        if (currentUserDto.isConfigured()) {

            return redirect(DASHBOARD_URL);
        }

        return redirectWithQueryParameter(PREFERENCE_EDIT_URL, ID, currentUserDto.getId());
    }
}
