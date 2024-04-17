package com.legacymed.med.hub.project.entities.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.legacymed.med.hub.project.services.UserService;
@Service
public class UserDetailsServiceImp implements UserDetailsService{

	@Autowired
	private UserService service;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return new UserAuthenticated(service.findUserByEmail(username));
	}

}
