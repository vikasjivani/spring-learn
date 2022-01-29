package com.example.springlearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springlearn.entity.CustomUserDetails;
import com.example.springlearn.repo.UserRepository;

@Service
public class CustomeUserDetailsService implements UserDetailsService	{

	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		

		com.example.springlearn.entity.MyUser user = this.userRepo.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("User not found..!!");
		}else {
			return new CustomUserDetails(user);
		}
		
//		if(username.equals("hello")) {
//			return new User("hello","hello123",new ArrayList<>());
//		}else {
//			throw new UsernameNotFoundException("User not found in your system");
//		}
		
	}

}
