package com.wipro.velocity.team8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.velocity.team8.model.User;
import com.wipro.velocity.team8.repository.CrudRepository;
import com.wipro.velocity.team8.repository.UserRepository;

@Service
@Transactional
public class ConsumerService {

	@Autowired
	private UserRepository urepo;
	
	@Autowired
	private CrudRepository crepo;
	
	public void saveDealer(User consumer) {
		urepo.save(consumer);
		// invokes save() method of JpaRepo
	}
	
	public User findByEmail(String email) {
		return crepo.findByEmail(email); // invokes save() method of JpaRepo
	}
	
}