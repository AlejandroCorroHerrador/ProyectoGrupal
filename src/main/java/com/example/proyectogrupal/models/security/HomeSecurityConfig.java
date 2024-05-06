package com.example.proyectogrupal.models.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class HomeSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails pau = User.builder()
                .username("pau")
                .password("{noop}12345")
                .roles("STUDENT", "USER_ADMIN")
                .build();

        UserDetails borja = User.builder()
                .username("borja")
                .password("{noop}12345")
                .roles("TEACHER", "USER_ADMIN")
                .build();

        UserDetails hector = User.builder()
                .username("hector")
                .password("{noop}12345")
                .roles("TEACHER", "USER_ADMIN")
                .build();

        return new InMemoryUserDetailsManager(pau, borja, hector);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                        configurer.requestMatchers("/alumno").hasRole("STUDENT")
                                .requestMatchers("/").hasRole("TEACHER")
                                .requestMatchers("/").hasRole("USER_ADMIN")
                                .requestMatchers("/*?/create").hasRole("USER_ADMIN")
                                .anyRequest().authenticated())
                .formLogin(form ->
                        form
                                .loginPage("/login")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )
                .logout(logout ->
                        logout.permitAll()
                )
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied"));
        return http.build();
    }
}


