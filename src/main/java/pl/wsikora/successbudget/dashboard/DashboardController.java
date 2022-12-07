package pl.wsikora.successbudget.dashboard;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static pl.wsikora.successbudget.dashboard.DashboardConstants.DASHBOARD_URL;


@Controller
@RequestMapping(DASHBOARD_URL)
public class DashboardController {

    @GetMapping
    private void view(Authentication authentication) {

//        extractCurrentUserDto(authentication)
    }
}
