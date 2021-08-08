package com.vo;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name="coupon_count")
public class coupon_count {

	 	@Id
	    @Column(name = "id")
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int id;
	 	
	 	
	 	@Column(name="date")
	 	String date;
	 	

	 	@Column(name="lunch")
	 	int lunch;

	 	@Column(name="dinner")
	 	int dinner;
	 	
	 	@Column(name="total_count", columnDefinition = "int default 0")
	 	int total_count;



		public int getTotal_count() {
			return total_count;
		}


		public void setTotal_count(int total_count) {
			this.total_count = total_count;
		}


		@Column(name="lunchmenu")
	 	String lunchmenu;

	 	@Column(name="dinnermenu")
	 	String dinnermenu;

	 	public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getDate() {
			return date;
		}


		public void setDate(String date) {
			this.date = date;
		}


		public int getLunch() {
			return lunch;
		}


		public void setLunch(int lunch) {
			this.lunch = lunch;
		}


		public int getDinner() {
			return dinner;
		}


		public void setDinner(int dinner) {
			this.dinner = dinner;
		}


		public String getLunchmenu() {
			return lunchmenu;
		}


		public void setLunchmenu(String lunchmenu) {
			this.lunchmenu = lunchmenu;
		}


		public String getDinnermenu() {
			return dinnermenu;
		}


		public void setDinnermenu(String dinnermenu) {
			this.dinnermenu = dinnermenu;
		}


		public int getLunchprice() {
			return lunchprice;
		}


		public void setLunchprice(int lunchprice) {
			this.lunchprice = lunchprice;
		}


		public int getDinnerprice() {
			return dinnerprice;
		}


		public void setDinnerprice(int dinnerprice) {
			this.dinnerprice = dinnerprice;
		}


		@Column(name="lunchprice")
	 	int lunchprice;
	

	 	@Column(name="dinnnerprice")
	 	int dinnerprice;
	
}
