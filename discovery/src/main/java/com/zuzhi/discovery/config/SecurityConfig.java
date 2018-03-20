package com.zuzhi.discovery.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * SecurityConfig
 *
 * @author zuzhi
 * @date 16/03/2018
 */
@Configuration
@EnableWebSecurity
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("discUser").password("{noop}discPass")
                .roles("ROLE_SYSTEM");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.httpBasic()
                .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.ALWAYS).and()
                .requestMatchers()
                    .antMatchers("/eureka/**")
                    .and()
                .authorizeRequests()
                    .antMatchers("/eureka/**")
                    .hasRole("SYSTEM")
                    .anyRequest()
                    .denyAll()
                    .and()
                .csrf()
                    .disable();
        // @formatter:on
    }

    @Configuration
    public static class AdminSecurityConfig extends WebSecurityConfigurerAdapter {
        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication();
        }

        @Override
        // no order tag means this is the last security filter to be evaluated
        protected void configure(HttpSecurity http) throws Exception {
            // @formatter:off
            http.httpBasic()
                    .and()
                    .sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.NEVER)
                        .and()
                    .authorizeRequests()
                        .antMatchers(HttpMethod.GET, "/").hasRole("ADMIN")
                        .antMatchers("/info", "/health")
                        .authenticated()
                    .anyRequest()
                        .denyAll()
                        .and()
                    .csrf().disable();
            // @formatter:on
        }
    }
}
