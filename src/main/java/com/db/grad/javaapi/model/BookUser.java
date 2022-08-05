package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book_user")
public class BookUser {
	
	@Id
	private long book_id;
	private long user_id;
		
	public BookUser() {
		super();
	}
	
	@Id
	@Column(name = "book_id", nullable = false)
	public long getBook_id() {
		return book_id;
	}
	public void setBook_id(long book_id) {
		this.book_id = book_id;
	}
	
	@Column(name = "user_id", nullable = false)
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	

}
