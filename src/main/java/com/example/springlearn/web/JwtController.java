package com.example.springlearn.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springlearn.entity.JwtRequest;
import com.example.springlearn.entity.JwtResponse;
import com.example.springlearn.helper.JwtUtil;
import com.example.springlearn.service.CustomeUserDetailsService;

@RestController
public class JwtController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private CustomeUserDetailsService customUserDetailsService;
	
	@RequestMapping(value = "/token", method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		System.err.println(jwtRequest);
		
		 try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
			
		 }catch(UsernameNotFoundException e){
			 e.printStackTrace();
			 throw new Exception("Bed Credentials Exception..!!");
		 }catch (BadCredentialsException e) {
			 e.printStackTrace();
			 throw new Exception("Bed Credentials Exception..!!");
		 }
		
		 
		 UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		 
		 String token = jwtUtil.generateToken(userDetails);
		 System.err.println(token);
		 
		return ResponseEntity.ok(new JwtResponse(token));
	}
}
