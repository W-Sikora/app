package pl.wsikora.successbudget.v3.common.ui;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static pl.wsikora.successbudget.v3.common.util.Constants.I18N_PATH;
import static pl.wsikora.successbudget.v3.common.util.Constants.LANDING_PAGE_PATH;


@RestController
@RequestMapping(I18N_PATH)
class LocaleController {

    private static final String LANGUAGE = "language";
    private static final int MAX_AGE = 1209600;

    @PostMapping
    private void changeLocale(String code, HttpServletResponse response) {

        Cookie cookie = new Cookie(LANGUAGE, code);
        cookie.setMaxAge(MAX_AGE);
        cookie.setPath(LANDING_PAGE_PATH);

        response.addCookie(cookie);
    }

}
