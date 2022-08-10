package com.wipro.velocity.team8.repository;

import com.wipro.velocity.team8.model.Product;
import com.wipro.velocity.team8.model.User;
import com.wipro.velocity.team8.model.UserProducts;

public interface CrudRepository extends org.springframework.data.repository.CrudRepository<User, Long> {

	public User findByEmail(String email);
	
}
