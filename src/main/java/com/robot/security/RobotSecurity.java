package com.robot.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Created by hezouatz on 08/12/17.
 */
@Configuration
@EnableWebSecurity
public class RobotSecurity  extends WebSecurityConfigurerAdapter {
    Logger logger = LoggerFactory.getLogger(RobotSecurity.class);



    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/rest/**").authenticated()
                .antMatchers(HttpMethod.PUT, "/rest/**").authenticated()
                .antMatchers(HttpMethod.DELETE, "/rest/**").authenticated()
                .anyRequest().permitAll()
        .and()
                .httpBasic().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
        // add this line to use H2 web console
        http.headers().frameOptions().disable();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password("{noop}admin1").roles("ADMIN")
                .and()
                .withUser("robotA").password("{noop}test1").roles("ROBOTA")
                .and()
                .withUser("robotB").password("{noop}test2").roles("ROBOTB");
    }

}
