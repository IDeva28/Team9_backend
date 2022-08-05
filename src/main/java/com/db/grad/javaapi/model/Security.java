package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "security")
public class Security {

	@Id 
	private long id;
	private long ISIN;
	private long CUSIP;
	private String issuer;
	private String maturity_date;
	private int coupon;
	private String type;
	private long facevalue;
	private String status;
	
	
	public Security() {
		super();
	}
	
	

	public Security(long id, long iSIN, long cUSIP, String issuer, String maturity_date, int coupon, String type,
			long facevalue, String status) {
		super();
		this.id = id;
		ISIN = iSIN;
		CUSIP = cUSIP;
		this.issuer = issuer;
		this.maturity_date = maturity_date;
		this.coupon = coupon;
		this.type = type;
		this.facevalue = facevalue;
		this.status = status;
	}



	@Id
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "ISIN", nullable = false)
	public long getISIN() {
		return ISIN;
	}


	public void setISIN(long iSIN) {
		ISIN = iSIN;
	}

	@Column(name = "CUSIP", nullable = false)
	public long getCUSIP() {
		return CUSIP;
	}


	public void setCUSIP(long cUSIP) {
		CUSIP = cUSIP;
	}

	@Column(name = "issuer", nullable = false)
	public String getIssuer() {
		return issuer;
	}


	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	@Column(name = "maturity_date", nullable = false)
	public String getMaturity_date() {
		return maturity_date;
	}


	public void setMaturity_date(String maturity_date) {
		this.maturity_date = maturity_date;
	}

	@Column(name = "coupon", nullable = false)
	public int getCoupon() {
		return coupon;
	}


	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}

	@Column(name = "type", nullable = false)
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "facevalue", nullable = false)
	public long getFacevalue() {
		return facevalue;
	}


	public void setFacevalue(long facevalue) {
		this.facevalue = facevalue;
	}

	@Column(name = "status", nullable = false)
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
		

}
