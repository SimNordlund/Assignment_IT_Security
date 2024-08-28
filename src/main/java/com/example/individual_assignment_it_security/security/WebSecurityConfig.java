package com.example.individual_assignment_it_security.security;

import com.example.individual_assignment_it_security.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.authentication.dao.*;

import java.util.*;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/js/**", "/css/**", "/images/**", "/login/**", "/logout", "/crackHash",
                                "/queues/**", "/landing", "/hashFile/**", "/hash", "/crack", "/createNewHash ").permitAll() // Add your specific URL pattern
                        .anyRequest().authenticated()
                )
                .oauth2Login(oauth2 -> {
                    oauth2.defaultSuccessUrl("/landing", true);
                    oauth2.userInfoEndpoint(ep -> {
                        ep.userAuthoritiesMapper(this.userAuthoritiesMapper());
                    });
                })
                .formLogin((form) ->
                                form.defaultSuccessUrl("/landing", true)
                        //      .permitAll()
                )
                .logout((logout) -> {
                    logout.permitAll();
                    logout.logoutSuccessUrl("/");
                })
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }


    private GrantedAuthoritiesMapper userAuthoritiesMapper() {

        return (authorities) -> {
            List<SimpleGrantedAuthority> mappedAuthorities = new ArrayList<>();


            authorities.forEach(authority -> {

                if (authority instanceof OAuth2UserAuthority oauth2UserAuthority) {
                    //ALla som använder github kan logga in och får rollen admin.
                    mappedAuthorities.add(new SimpleGrantedAuthority("Admin"));
                }
            });

            return mappedAuthorities;
        };
    }
}
