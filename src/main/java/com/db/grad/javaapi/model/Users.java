package com.db.grad.javaapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@Entity
@Table(name = "users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private long id;
    private String name;
    private String email;
    private String role;
    
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private List<BookUser> bookUser;
   
	public Users() {
		super();
    }  
    
	public Users(String name, String email, String role) {
		super();
		this.name = name;
		this.email = email;
		this.role = role;
	}

	@Column(name = "id", nullable = false)
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "role", nullable = false)
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
