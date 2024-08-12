package com.example.springboottema4.security;

import com.example.springboottema4.jwt.JwtAutenticationFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig  {

    private final JwtAutenticationFilter jwtAuthenticationfilter;
    private final AuthenticationProvider authprovider;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf ->
                        csrf
                        .disable())

                .authorizeHttpRequests((authorizeHttpRequests) ->
                        authorizeHttpRequests
              .requestMatchers("/api/libros/").permitAll()
               .requestMatchers("api/libros/{id}").permitAll()
               .anyRequest().authenticated()
                )
                .sessionManagement(
                        sessionManager->
                                sessionManager
                                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(authprovider)
                .addFilterBefore(jwtAuthenticationfilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
