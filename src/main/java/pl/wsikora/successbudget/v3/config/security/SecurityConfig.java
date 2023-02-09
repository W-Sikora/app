package pl.wsikora.successbudget.v3.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;

import static pl.wsikora.successbudget.v3.common.Constants.*;


@Configuration
@EnableWebSecurity
class SecurityConfig {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    SecurityConfig(PasswordEncoder passwordEncoder,
                   UserDetailsService userDetailsService) {

        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    AuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);

        return provider;
    }

    @Bean
    HttpFirewall defaultHttpFirewall() {

        return new DefaultHttpFirewall();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
            .authorizeHttpRequests(auth -> {
                auth.requestMatchers(LANDING_PAGE_PATH, I18N_PATH, REGISTRATION_PATH).permitAll();
                auth.requestMatchers(STATIC_RESOURCES_PATH, WEB_INF_RESOURCES_PATH).permitAll();
                auth.anyRequest().authenticated();
            })
            .formLogin(login -> {
                login.loginPage(LOGIN_PATH);
                login.usernameParameter(USERNAME_PARAMETER);
                login.passwordParameter(PASSWORD_PARAMETER);
                login.defaultSuccessUrl(DASHBOARD_PATH, true);
                login.failureUrl(LOGIN_FAILURE_PATH);
                login.permitAll();
            })
            .logout(logout -> {
                logout.logoutSuccessUrl(LANDING_PAGE_PATH);
                logout.permitAll();
            })
            .build();
    }

}
