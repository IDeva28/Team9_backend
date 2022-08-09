package com.db.grad.javaapi.model;

import java.util.List;

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

@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	@Column(name = "id", nullable = false)
	private long id;
	
	@Column(name = "book_name", nullable = false)
	private String book_name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
	private List<BookUser> bookUser;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
	private List<Trade> trade;
   
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	   
	public List<BookUser> getBookUser() {
		return bookUser;
	}

	public void setBookUser(List<BookUser> bookUser) {
		this.bookUser = bookUser;
	}
	
	public List<Trade> getTrade() {
		return trade;
	}
	public void setTrade(List<Trade> trade) {
		this.trade = trade;
	}
	
	
}
