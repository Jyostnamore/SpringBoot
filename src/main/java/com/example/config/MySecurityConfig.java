package com.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import com.example.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter  {
	Logger logger = LoggerFactory.getLogger(MySecurityConfig.class);
	@Autowired
	private JwtAuthenticationEntryPoint authenticationEntryPoint;
	@Autowired
	private JwtAuthentiFilter jwtFilter;
	@Autowired
	private CustomUserDetailsService customDetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("Started Authentication");
		http.csrf().disable();
		http.cors().disable()
		
		.authorizeRequests()
        //.antMatchers("/","/public/**", "/resources/**","/resources/public/**").permitAll()
		.antMatchers("/token").permitAll()
		//.antMatchers(HttpMethod.OPTIONS, "/*").permitAll()
		  .antMatchers("/**")
		  .permitAll()
		   
		//.antMatchers("http://localhost:8080/api/v1/").permitAll()
		
		.anyRequest().authenticated()
		.and()
		
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
		.and()
		.formLogin()
		.permitAll();
		
		http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
		logger.info("ended authentication");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	
}
