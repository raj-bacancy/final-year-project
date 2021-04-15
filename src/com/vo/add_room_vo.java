package com.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="add_room")
public class add_room_vo {
	
	@Id
	@Column(name="roomno")
	int roomno;
	
	@Column(name="capacity")
	int capacity;
	
	@Column(name="currentmember")
	int currentmember;
	
	@Column(name="roomtype")
	String roomtype;
	
	@Column(name="speciality")
	String speciality;

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public int getRoomno() {
		return roomno;
	}

	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getCurrentmember() {
		return currentmember;
	}

	public void setCurrentmember(int currentmember) {
		this.currentmember = currentmember;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	
	

}
