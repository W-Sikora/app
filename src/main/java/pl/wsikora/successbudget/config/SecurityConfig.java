package pl.wsikora.successbudget.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.*;
import org.springframework.util.Assert;


@Configuration
@EnableWebSecurity
class SecurityConfig {

    private static final String EMPLOYEE = "employee";
    private static final String MANAGER = "manager";
    private static final String OWNER = "owner";

    private static final String CSS = "/css/style.css";

    private final PasswordEncoder encoder;


    SecurityConfig(PasswordEncoder encoder) {

        Assert.notNull(encoder, "encoder must not be null");

        this.encoder = encoder;
    }

    @Bean
    HttpFirewall defaultHttpFirewall() {

        return new DefaultHttpFirewall();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/**").permitAll();
                    auth.requestMatchers("/static/css/style.css").permitAll();
                })
                .build();
    }
}
