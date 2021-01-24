package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.JwtResponse;
import com.example.jwt.JwtUtil;
import com.example.model.JwtRequest;


@RestController
@CrossOrigin(origins = "http://localhost:4200" ,maxAge=3600)
public class JwtController {
	
	@Autowired
	private com.example.service.CustomUserDetailsService CustomUserDetailsService;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JwtUtil jwtutil;
	
	@RequestMapping(value="/token",method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception
	{
		System.out.println(jwtRequest);
		try
		{
			authManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
		}
		catch(UsernameNotFoundException e)
		{
			e.printStackTrace();
			throw new Exception("Bad Credential");
		}
		catch(BadCredentialsException e)
		{
			e.printStackTrace();
			throw new Exception("Bad Credential");
		}
		
		//fine 
	UserDetails user=this.CustomUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token=this.jwtutil.generateToken(user);
		System.out.println("JWT"+token);
		
		//{"token":"value}
		return ResponseEntity.ok(new JwtResponse(token));
	}
}
