package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","index","/css/*","/js/*").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails lokendraUser = User.builder().username("lokendra").password(passwordEncoder().encode("password")).roles("STUDENT").build();

        return  new InMemoryUserDetailsManager(lokendraUser);

    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder(10);
    }
}
