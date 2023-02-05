package pl.wsikora.successbudget.v3.config.i18n;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.time.Duration;
import java.util.Locale;


@Configuration
class LocaleConfig implements WebMvcConfigurer {

    private static final Locale POLISH = new Locale("pl");
    private static final String LOCALE = "locale";
    private static final Duration COOKIE_MAX_AGE = Duration.ofDays(14L);

    @Bean
    LocaleResolver localeResolver() {

        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver(LOCALE);
        cookieLocaleResolver.setDefaultLocale(POLISH);
        cookieLocaleResolver.setCookieMaxAge(COOKIE_MAX_AGE);

        return cookieLocaleResolver;
    }

    @Bean
    LocaleChangeInterceptor localeChangeInterceptor() {

        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName(LOCALE);

        return localeChangeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(localeChangeInterceptor());
    }

}
