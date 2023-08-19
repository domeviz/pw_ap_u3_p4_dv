package com.uce.edu.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurity {

	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
	    httpSecurity.cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
	            .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	            .and().authorizeRequests()
	            .anyRequest().authenticated();
	    httpSecurity.addFilterBefore(this.authJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	     return httpSecurity.build();

	}
	
	@Bean
	public AuthTokenFilter authJwtTokenFilter(){
	    return new AuthTokenFilter();
	}

	
}
