package com.wipro.velocity.team8.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "details")
	private String details;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "image_link")
	private String imageLink;
	
	@OneToMany( cascade = CascadeType.ALL, targetEntity = UserProducts.class)
	@JoinColumn(name="p_id", referencedColumnName = "id")
	private List<UserProducts> userProducts;
	
	public Product() {
	}

	public Product(Long id, String name, String details, float price, String imageLink) {
		this.id = id;
		this.name = name;
		this.details = details;
		this.price = price;
		this.imageLink = imageLink;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", details=" + details + ", price=" + price + "]";
	}
	
	
}
