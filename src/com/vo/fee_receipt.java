package com.vo;

import javax.persistence.*;




@Entity
@Table(name="fee_receipt")
public class fee_receipt {

	
	
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@Column(name="hostelid")
	String hostelid;
	
	@Column(name="currentyear")
	String currentyear;
	
	@Column(name="feereceipt")
	String feereceipt;

	@Column(name="status")
	String status;
	
	@Column(name="link")
	String link;
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHostelid() {
		return hostelid;
	}

	public void setHostelid(String hostelid) {
		this.hostelid = hostelid;
	}

	public String getCurrentyear() {
		return currentyear;
	}

	public void setCurrentyear(String currentyear) {
		this.currentyear = currentyear;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFeereceipt() {
		return feereceipt;
	}

	public void setFeereceipt(String feereceipt) {
		this.feereceipt = feereceipt;
	}
	
}
