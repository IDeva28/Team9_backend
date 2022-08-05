package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "counter_party")
public class CounterParty {

	@Id
	private int id;
	private int name;
	
	public CounterParty() {
		super();
	}
	

	public CounterParty(int id, int name) {
		super();
		this.id = id;
		this.name = name;
	}

	
	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false)
	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}
	
	

}
