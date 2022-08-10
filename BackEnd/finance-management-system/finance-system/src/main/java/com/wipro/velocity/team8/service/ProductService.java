package com.wipro.velocity.team8.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.velocity.team8.model.Product;
import com.wipro.velocity.team8.model.User;
import com.wipro.velocity.team8.model.UserProducts;
import com.wipro.velocity.team8.repository.CrudRepository;
import com.wipro.velocity.team8.repository.ProductRepository;
import com.wipro.velocity.team8.repository.UserProductsCrudRepository;
import com.wipro.velocity.team8.repository.UserRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository prepo;
	
	@Autowired
	private UserRepository urepo;
	
	@Autowired
	private UserProductsCrudRepository crepo;
	
	public List<Product> listAll() {
		return prepo.findAll();
	}
	
	public Optional<User> findUserByUid(Long id) {
		return urepo.findById(id); // invokes save() method of JpaRepo
	}
	public Optional<Product> findProductByPid(Long id) {
		return prepo.findById(id); // invokes save() method of JpaRepo
	}
//	public UserProducts findUserProductData(Long u_id,Long p_id) {
//		return crepo.findUserProducts();
//	}
}
