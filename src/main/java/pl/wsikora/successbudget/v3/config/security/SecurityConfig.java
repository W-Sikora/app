package pl.wsikora.successbudget.v3.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;

import static pl.wsikora.successbudget.v3.common.Constants.DASHBOARD_PATH;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    public static final String USER_ROLE = "USER";

    private static final String EMPLOYEE = "employee";
    private static final String MANAGER = "manager";
    private static final String OWNER = "owner";

    private static final String CSS = "/css/style.css";

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    SecurityConfig(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {

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
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/login")
                .failureUrl("/login?invalid=true")
                .defaultSuccessUrl(DASHBOARD_PATH, true)
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .permitAll()
                .and()
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/**").permitAll();
                    auth.requestMatchers("/static/css/style.css").permitAll();
                })
                .build();
    }
}
