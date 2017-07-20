package com.example.fulfillment.integration.ams.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by luchob on 7/19/17.
 */
@Configuration
@EnableWebSecurity
@EnableConfigurationProperties(BasicAuthConfiguration.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private BasicAuthConfiguration basicAuthConfig;

    @Autowired
    public void setBasicAuthConfig(BasicAuthConfiguration basicAuthConfig) {
        this.basicAuthConfig = basicAuthConfig;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.authorizeRequests()
                    .antMatchers("/admin/healthcheck").permitAll()
                    .anyRequest().authenticated().
                and()
                    .httpBasic()
                    .realmName("Digital Bulgaria");
        // @formatter:on
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser(basicAuthConfig.getUserName()).
                password(basicAuthConfig.getUserPassword()).
                roles();
    }
}