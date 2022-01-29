package com.example.springlearn.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.springlearn.helper.JwtUtil;
import com.example.springlearn.service.CustomeUserDetailsService;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	@Autowired
	private CustomeUserDetailsService customeUserDetailsService; 
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		
		// Jwt token
		// Check with Bearer
		// Validate
		
		String authHeader = request.getHeader("Authorization");
		String userName = null;
		String jwtToken = null;
		
		if(authHeader != null && authHeader.startsWith("Bearer ")) {
			jwtToken = authHeader.substring(7);
			System.err.println("get token from header");  
			try {
				
				userName = this.jwtUtil.extractUsername(jwtToken);
				
			}catch (Exception e) {
				e.printStackTrace();
				
			}
			
			UserDetails userDetails = this.customeUserDetailsService.loadUserByUsername(userName);
			
			System.err.println(userName);
			System.err.println(userDetails);
			
			
			if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}else {
				System.err.println("User not found");
			}
			
		}else {
			System.err.println("Header does not have Bearer token");
		}
	
		filterChain.doFilter(request, response);
	}

}
