package com.db.grad.javaapi.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "trade")
public class Trade {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	@Column(name = "id", nullable = false)
	private long id;
	
	@Column(name = "quantity", nullable = false)
	private long quantity;

	@Column(name = "status", nullable = false)
	private String status;
	
	@Column(name = "price", nullable = false)
	private long price;
	
	@Column(name = "buy_sell", nullable = false)
	private String buy_sell;
	
	@Column(name = "trade_date", nullable = false)
	private LocalDateTime trade_date;
	
	@Column(name = "settlement_date", nullable = false)
	private LocalDateTime settlement_date;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "book_id")	
	private Book book;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "security_id")	
	private Security security;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "counter_party_id")	
	private CounterParty counterParty;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getBuy_sell() {
		return buy_sell;
	}

	public void setBuy_sell(String buy_sell) {
		this.buy_sell = buy_sell;
	}

	public LocalDateTime getTrade_date() {
		return trade_date;
	}

	public void setTrade_date(LocalDateTime trade_date) {
		this.trade_date = trade_date;
	}

	public LocalDateTime getSettlement_date() {
		return settlement_date;
	}

	public void setSettlement_date(LocalDateTime settlement_date) {
		this.settlement_date = settlement_date;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	public Security getSecurity() {
		return security;
	}

}
