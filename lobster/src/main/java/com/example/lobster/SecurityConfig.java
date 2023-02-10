package com.example.lobster;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()        
            .antMatchers("/h2-console/**")
            .permitAll()
            .and()            
            .authorizeRequests().antMatchers(HttpMethod.GET,"/lobster/**").permitAll().and()
            .authorizeRequests().antMatchers(HttpMethod.POST,"/lobster/**").permitAll().and()
            .authorizeRequests().antMatchers(HttpMethod.PUT,"/lobster/**").authenticated().and()
            .authorizeRequests().antMatchers(HttpMethod.DELETE,"/lobster/**").authenticated().and()	
            .httpBasic();
        http.authorizeRequests().antMatchers("/**").denyAll();
        http.csrf().disable();
        http.headers().frameOptions().disable();
        return http.build();
    }
	
	

}
