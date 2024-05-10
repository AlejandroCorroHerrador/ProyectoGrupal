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

    // Método para configurar usuarios en memoria
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        // Definición de usuarios con sus roles y contraseñas
        UserDetails pau = User.builder()
                .username("pau")
                // {noop} indica que la contraseña no está codificada
                .password("{noop}12345")
                .roles("STUDENT")
                .build();

        UserDetails borja = User.builder()
                .username("borja")
                .password("{noop}12345")
                .roles("TEACHER")
                .build();

        UserDetails hector = User.builder()
                .username("hector")
                .password("{noop}12345")
                .roles("TEACHER")
                .build();

        // Devuelve un gestor de detalles de usuario con los usuarios configurados
        return new InMemoryUserDetailsManager(pau, borja, hector);
    }

    // Método para configurar la cadena de filtros de seguridad
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Configuración de reglas de seguridad
        http.authorizeHttpRequests(configurer ->
                        configurer.requestMatchers("/alumno").hasRole("STUDENT") // Ruta "/alumno" requiere rol STUDENT
                                .requestMatchers("/profesor").hasRole("TEACHER") // Ruta "/profesor" requiere rol TEACHER
                                .anyRequest().authenticated()) // Cualquier otra ruta requiere autenticación
                .formLogin(form ->
                        form
                                .loginPage("/login") // Página de inicio de sesión personalizada en "/login"
                                .loginProcessingUrl("/authenticateTheUser") // URL para procesar la autenticación
                                .permitAll() // Permitir acceso a todos
                )
                .logout(logout ->
                        logout.permitAll() // Permitir acceso a la ruta de desautenticación
                )
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied")); // Redireccionar en caso de acceso denegado
        return http.build(); // Construir y devolver la cadena de filtros de seguridad configurada
    }
}


