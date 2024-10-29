package com.jpa.parqueadero.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.
                authorizeRequests(auth -> auth
                        .requestMatchers("/","/login").permitAll()
                        .requestMatchers("/admin/**").hasRole("Administrador")
                        .requestMatchers("/user/**").hasAnyRole("Administrador","Usuario")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/perform_login")
                        .defaultSuccessUrl("/",true)
                        .failureUrl("/login?error=true")
                        .permitAll()

                )
                .logout(logout -> logout
                        .logoutUrl("/logout")  // URL para el logout
                        .logoutSuccessUrl("/login?logout")  // Redirección tras el logout
                        .permitAll()
                )
                .exceptionHandling(exception -> exception
                        .accessDeniedPage("/403")  // Página personalizada para errores 403
                )
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // Solo para pruebas, no recomendado para producción
    }


}
