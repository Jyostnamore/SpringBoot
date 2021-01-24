package com.example.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.jwt.JwtUtil;
import com.example.service.CustomUserDetailsService;

@Component
public class JwtAuthentiFilter extends OncePerRequestFilter {
	Logger logger = LoggerFactory.getLogger(JwtAuthentiFilter.class);
	
	@Autowired
	private CustomUserDetailsService CustomUserDetailsService;
	@Autowired
	private JwtUtil jwtutil;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("Started Filter");
		//get Jwt
		//Bearer
		 

	      
		String auth=request.getHeader("Authorization");
		String username=null;
		String jwtToken=null;
		if(auth!=null&&auth.startsWith("Bearer "))
		{
			
			jwtToken=auth.substring(7);
			try
			{
				this.jwtutil.getUsernameFromToken(jwtToken);
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			UserDetails userDetails=this.CustomUserDetailsService.loadUserByUsername(username);
			if(jwtutil.validateToken(jwtToken, userDetails))
			{
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
				.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		
			else
			{
				System.out.println("Token is not validate");
			}
			
		}
		 response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		    response.setHeader("Access-Control-Allow-Credentials", "true");
		    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		    response.setHeader("Access-Control-Max-Age", "3600");
		    response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");

		filterChain.doFilter(request, response);
		

		logger.info("Ended Filter");
	}

}
