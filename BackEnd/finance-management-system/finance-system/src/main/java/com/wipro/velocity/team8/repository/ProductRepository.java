package com.wipro.velocity.team8.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.velocity.team8.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
