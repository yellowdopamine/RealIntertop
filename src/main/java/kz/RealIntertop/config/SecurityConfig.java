package kz.RealIntertop.config;

import kz.RealIntertop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserService userService;

    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        AuthenticationManagerBuilder builder =
                httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());

        httpSecurity
                .csrf().disable()
                .formLogin()
                    .loginPage("/account/sign-in")
                    .loginProcessingUrl("/auth")
                    .defaultSuccessUrl("/")
                    .failureUrl("/account/sign-in?error")
                    .usernameParameter("email")
                    .passwordParameter("password");

        httpSecurity.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");

        return httpSecurity.build();
    }

}
