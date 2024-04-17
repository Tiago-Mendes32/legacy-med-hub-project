package com.legacymed.med.hub.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legacymed.med.hub.project.entities.user.User;
import com.legacymed.med.hub.project.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public User findUserByEmail(String email) {
		return repository.findUserByEmail(email);
	}
}
