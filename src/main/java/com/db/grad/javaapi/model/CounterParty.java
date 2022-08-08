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
@Table(name = "counter_party")
public class CounterParty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private long id;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "counter_party_id", referencedColumnName = "id")
	private List<Trade> trade;
	
	public CounterParty() {
		super();
	}
	
	public CounterParty(String name) {
		super();
		this.name = name;
	}

	@Column(name = "id", nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Trade> getTrade() {
		return trade;
	}

	public void setTrade(List<Trade> trade) {
		this.trade = trade;
	}
	
}
