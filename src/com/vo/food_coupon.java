package com.vo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="food_coupon")
public class food_coupon {

	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="hostelid")
	String hostelid;
	
	@Column(name="nooffoodcoupon")
	int nooffoodcoupon;
	
	@Column(name="date")
	String date;
	
	@Column(name="foodtime")
	String foodtime;
	
  	@Column(name="status")
	String status;
  	
  	@Column(name="cost")
  	int cost;

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFoodtime() {
		return foodtime;
	}

	public void setFoodtime(String foodtime) {
		this.foodtime = foodtime;
	}

	public String getHostelid() {
		return hostelid;
	}

	public void setHostelid(String hostelid) {
		this.hostelid = hostelid;
	}

	public int getNooffoodcoupon() {
		return nooffoodcoupon;
	}

	public void setNooffoodcoupon(int nooffoodcoupon) {
		this.nooffoodcoupon = nooffoodcoupon;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}	 
	
}
