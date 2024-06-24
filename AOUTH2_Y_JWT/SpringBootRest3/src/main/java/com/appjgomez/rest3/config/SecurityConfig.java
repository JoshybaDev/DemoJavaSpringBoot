/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appjgomez.rest3.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author JGomez
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((request) -> request
                .requestMatchers(HttpMethod.GET, "/api/v1/security/authorized").permitAll() //client
                .requestMatchers(HttpMethod.GET, "/api/v1/users").hasAnyAuthority("SCOPE_read", "SCOPE_write") //resource Server
                .requestMatchers(HttpMethod.POST, "/api/v1/users").hasAuthority("SCOPE_write") //resource Server
                //.requestMatchers(HttpMethod.POST, "/api/v1/products").hasAuthority("SCOPE_write") //resource Server
                //.requestMatchers(HttpMethod.POST, "/api/v1/makers").hasAuthority("SCOPE_write") //resource Server
                .anyRequest().authenticated())
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2Login(login -> login.loginPage("/oauth2/authorization/oauth-client"))
                .oauth2Client(withDefaults())
                .oauth2ResourceServer(resourseServer -> resourseServer.jwt(withDefaults()));
        return http.build();

    }
}
