package com.workintech.s19d2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
        // BCryptPasswordEncoder dışında da yöntemler var.
        // Bcrpyt - SHA-256 - SHA-512 - Argon2 - PBKDF2 - SCrypt
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // csrf(AbstractHttpConfigurer::disable) = csrf(csrf -> csrf.disable())
        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers( "/auth/**").permitAll();
                    auth.requestMatchers( "/welcome/**").permitAll();
                    auth.requestMatchers( "/actuator/**").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/account/**").hasAnyAuthority("ADMIN", "USER");
                    auth.requestMatchers(HttpMethod.POST, "/account/**").hasAnyAuthority("ADMIN");
                    auth.requestMatchers(HttpMethod.PUT, "/account/**").hasAnyAuthority("ADMIN");
                    auth.requestMatchers(HttpMethod.DELETE, "/account/**").hasAnyAuthority(
                      "ADMIN");

                    auth.anyRequest().authenticated();
                })
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean // Güvenliğin Veritanı ile çalıştığını sisteme söyler.
    public AuthenticationManager authManager(UserDetailsService userDetailsService){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(provider);
    }

}
