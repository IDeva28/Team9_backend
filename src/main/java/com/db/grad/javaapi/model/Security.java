package com.db.grad.javaapi.model;

import java.time.LocalDateTime;
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "security")
public class Security {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	@Column(name = "id", nullable = false)
	private long id;
	
	@Column(name = "ISIN", nullable = false)
	private long isin;
	
	@Column(name = "CUSIP", nullable = false)
	private long cuisp;
	
	@Column(name = "issuer", nullable = false)
	private String issuer;
	
	@Column(name = "maturity_date", nullable = false)
	private LocalDateTime maturity_date;
	
	@Column(name = "coupon", nullable = false)
	private int coupon;
	
	@Column(name = "type", nullable = false)
	private String type;
	
	@Column(name = "facevalue", nullable = false)
	private long facevalue;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@Column(name = "action", nullable = false)
	private boolean action;
	
	@Column(name = "issue", nullable = false)
	private String issue;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "security_id", referencedColumnName = "id")
	private List<Trade> trade;
   
	
	public Security() {
		super();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public long getIsin() {
		return isin;
	}

	public void setIsin(long isin) {
		this.isin = isin;
	}

	public long getCuisp() {
		return cuisp;
	}

	public void setCuisp(long cuisp) {
		this.cuisp = cuisp;
	}

	public String getIssuer() {
		return issuer;
	}


	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public LocalDateTime getMaturity_date() {
		return maturity_date;
	}


	public void setMaturity_date(LocalDateTime maturity_date) {
		this.maturity_date = maturity_date;
	}

	
	public int getCoupon() {
		return coupon;
	}


	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}

	
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

	
	public long getFacevalue() {
		return facevalue;
	}


	public void setFacevalue(long facevalue) {
		this.facevalue = facevalue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public boolean isAction() {
		return action;
	}


	public void setAction(boolean action) {
		this.action = action;
	}

	
	public String getIssue() {
		return issue;
	}


	public void setIssue(String issue) {
		this.issue = issue;
	}


	public List<Trade> getTrade() {
		return trade;
	}

	public void setTrade(List<Trade> trade) {
		this.trade = trade;
	}
		

}
