package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trade")
public class Trade {

	@Id
	private int id;
	
	private int book_id;
	private int counter_party_id;
	private int security_id;
	private int quantity;
	private String status;
	private int price;
	private String buy_sell;
	private String trade_date;
	private String settlement_date;
	
	public Trade() {
		super();
	}
		

	public Trade(int id, int book_id, int counter_party_id, int security_id, int quantity, String status, int price,
			String buy_sell, String trade_date, String settlement_date) {
		super();
		this.id = id;
		this.book_id = book_id;
		this.counter_party_id = counter_party_id;
		this.security_id = security_id;
		this.quantity = quantity;
		this.status = status;
		this.price = price;
		this.buy_sell = buy_sell;
		this.trade_date = trade_date;
		this.settlement_date = settlement_date;
	}



	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "book_id", nullable = false)
	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	@Column(name = "counter_party_id", nullable = false)
	public int getCounter_party_id() {
		return counter_party_id;
	}

	public void setCounter_party_id(int counter_party_id) {
		this.counter_party_id = counter_party_id;
	}

	@Column(name = "security_id", nullable = false)
	public int getSecurity_id() {
		return security_id;
	}

	public void setSecurity_id(int security_id) {
		this.security_id = security_id;
	}

	@Column(name = "quantity", nullable = false)
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
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
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
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
	public String getTrade_date() {
		return trade_date;
	}

	public void setTrade_date(String trade_date) {
		this.trade_date = trade_date;
	}

	@Column(name = "settlement_date", nullable = false)
	public String getSettlement_date() {
		return settlement_date;
	}

	public void setSettlement_date(String settlement_date) {
		this.settlement_date = settlement_date;
	}
		

}
