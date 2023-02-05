package pl.wsikora.successbudget.v3.i18n.ui;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static pl.wsikora.successbudget.v3.common.Constants.SLASH;


@RestController
@RequestMapping("/locale")
class LocaleController {

    private static final String LOCALE = "locale";
    private static final int MAX_AGE = 1209600;

    @PostMapping
    private void changeLocale(@RequestBody LocaleCode localeCode, HttpServletResponse response) {

        Cookie cookie = new Cookie(LOCALE, localeCode.code);
        cookie.setMaxAge(MAX_AGE);
        cookie.setPath(SLASH);

        response.addCookie(cookie);
    }

    private record LocaleCode(String code) {}

}
