package com.legacymed.med.hub.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.legacymed.med.hub.project.entities.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findUserByEmail(String email);
}
