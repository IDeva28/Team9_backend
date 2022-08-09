package com.db.grad.javaapi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	@Column(name = "id", nullable = false)
	private long id;
	
	@Column(name = "name", nullable = false)
    private String name;
    
	@Column(name = "email", nullable = false)
    private String email;
    
	@Column(name = "role", nullable = false)
    private String role;    
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
	private List<BookUser> bookUser;
   
	
	public long getId() {
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

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
		 
    public List<BookUser> getBookUser() {
		return bookUser;
	}

	public void setBookUser(List<BookUser> bookUser) {
		this.bookUser = bookUser;
	}
    
}
