package com.zuzhi.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * SecurityConfig
 *
 * @author zuzhi
 * @date 16/03/2018
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("gateUser").password("{noop}gatePass")
                .roles("ROLE_USER")
                .and()
                .withUser("gateAdmin").password("{noop}gatePass")
                .roles("ROLE_ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.formLogin()
                .and()
                .logout()
                    .permitAll()
                    .and()
                .authorizeRequests()
                    .antMatchers("/book-service/books").permitAll()
                    .antMatchers("/eureka/**").hasRole("ADMIN")
                    .anyRequest()
                    .authenticated()
                    .and()
                .csrf()
                    .disable();
        // @formatter:on
    }
}
