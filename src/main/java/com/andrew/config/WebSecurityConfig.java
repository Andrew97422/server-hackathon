package com.andrew.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthFilter authFilter;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)
            throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/api/v1/**", "/test"
                        )
                        .permitAll()
                        .anyRequest().authenticated()
                );
        http.sessionManagement((sessionManagement) ->
        {
            try {
                sessionManagement
                        .sessionConcurrency((sessionConcurrency) ->
                                sessionConcurrency
                                        .maximumSessions(1)
                                        .expiredUrl("/login?expired")
                        )
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).disable()
                .authenticationProvider(authenticationProvider)
                .addFilterAfter(authFilter, UsernamePasswordAuthenticationFilter.class)
                .logout((logout) -> logout.logoutSuccessUrl("/api/v1/login"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        http.cors(CorsConfigurer::disable);
        return http.build();
    }
}
