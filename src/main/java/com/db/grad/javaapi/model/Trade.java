package com.db.grad.javaapi.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "trade")
public class Trade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private long id;
//	private long book_id;
//	private long counter_party_id;
//	private long security_id;
	private long quantity;
	private String status;
	private long price;
	private String buy_sell;
	private LocalDateTime trade_date;
	private LocalDateTime settlement_date;
	
	public Trade() {
		super();
	}

	@Column(name = "id", nullable = false)
	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	@Column(name = "book_id", nullable = false)
//	public long getBook_id() {
//		return book_id;
//	}
//
//	public void setBook_id(int book_id) {
//		this.book_id = book_id;
//	}
//
//	@Column(name = "counter_party_id", nullable = false)
//	public long getCounter_party_id() {
//		return counter_party_id;
//	}
//
//	public void setCounter_party_id(int counter_party_id) {
//		this.counter_party_id = counter_party_id;
//	}
//
//	@Column(name = "security_id", nullable = false)
//	public long getSecurity_id() {
//		return security_id;
//	}
//
//	public void setSecurity_id(int security_id) {
//		this.security_id = security_id;
//	}

	@Column(name = "quantity", nullable = false)
	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	@Column(name = "status", nullable = false)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "price", nullable = false)
	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Column(name = "buy_sell", nullable = false)
	public String getBuy_sell() {
		return buy_sell;
	}

	public void setBuy_sell(String buy_sell) {
		this.buy_sell = buy_sell;
	}

	@Column(name = "trade_date", nullable = false)
	public LocalDateTime getTrade_date() {
		return trade_date;
	}

	public void setTrade_date(LocalDateTime trade_date) {
		this.trade_date = trade_date;
	}

	@Column(name = "settlement_date", nullable = false)
	public LocalDateTime getSettlement_date() {
		return settlement_date;
	}

	public void setSettlement_date(LocalDateTime settlement_date) {
		this.settlement_date = settlement_date;
	}
		

}
