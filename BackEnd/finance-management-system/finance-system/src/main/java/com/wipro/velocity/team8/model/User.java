package com.wipro.velocity.team8.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(unique = true, name="pnumber")
	private String phoneNumber; 
	
	@Column(unique = true)
	private String email; 
	
	@Column(name = "uname", unique=true)
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name="address")
	private String address;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private UserCard ucard;
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = UserProducts.class)
	@JoinColumn(name="u_id", referencedColumnName = "id")
	private List<UserProducts> userProducts;

	public User() {
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserCard getUcard() {
		return ucard;
	}

	public void setUcard(UserCard ucard) {
		this.ucard = ucard;
	}
	
	
	
	
	
	
	
}
