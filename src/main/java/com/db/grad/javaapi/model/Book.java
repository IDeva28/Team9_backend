package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	
	@Id
	private long id;
	private String book_name;
	
	public Book() {
		super();
	}
	public Book(long id, String book_name) {
		super();
		this.id = id;
		this.book_name = book_name;
	}
	
	@Id
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "book_name", nullable = false)
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	
}
