package com.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="guest_stay")
public class guest_stay_vo {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="hostelid")
	String hostelid;
	
	@Column(name="datefrom")
	String datefrom;
	
	@Column(name="dateto")
	String dateto;
	
	@Column(name="noofguest")
	int noofguest;
	
	@Column(name="checkin")
	String checkin;
	
	@Column(name="checkout")
	String checkout;
	
	@Column(name="roomtype")
	String roomtype;
	
	@Column(name="status")
	String status;
	
	@Column(name="allocatedroom")
	int allocatedroom;

	public int getAllocatedroom() {
		return allocatedroom;
	}

	public void setAllocatedroom(int allocatedroom) {
		this.allocatedroom = allocatedroom;
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

	public String getDatefrom() {
		return datefrom;
	}

	public void setDatefrom(String datefrom) {
		this.datefrom = datefrom;
	}

	public String getDateto() {
		return dateto;
	}

	public void setDateto(String dateto) {
		this.dateto = dateto;
	}

	public int getNoofguest() {
		return noofguest;
	}

	public void setNoofguest(int noofguest) {
		this.noofguest = noofguest;
	}

	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}
