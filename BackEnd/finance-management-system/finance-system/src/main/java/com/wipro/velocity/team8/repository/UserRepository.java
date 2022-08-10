package com.wipro.velocity.team8.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.velocity.team8.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
}
