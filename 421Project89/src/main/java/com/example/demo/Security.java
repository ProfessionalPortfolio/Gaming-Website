package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
public class Security extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}admin").roles("ADMIN");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/getAl").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/get").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
       /* http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/createUser").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();*/
       /* http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.PUT,"/updateUser").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();*/
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.DELETE,"/del").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
        /*http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.DELETE,"/getAllChat").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();*/
       /* http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.DELETE,"/createMessage").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();*/
       /* http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.DELETE,"/deleteMessage").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();*/
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"Review/newCategory").hasRole("ADMIN")
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.DELETE,"Review/Delete/Category").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}
