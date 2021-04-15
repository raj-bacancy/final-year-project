package com.vo;

import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "visitor")
public class visitor {

	 	@Id
	    @Column(name = "id")
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    int id;
	 	
	 	@Column(name="hostelid")
	 	String hostelid;
	 	
	 	@Column(name="date")
	 	String date;
	 	
	 	@Column(name="checkin")
	 	String checkin;
	 	

	 	@Column(name="checkout")
	 	String checkout;
	 	

	 	@Column(name="visitorname")
	 	String visitorname;
	 	
	 	@Column(name="visitormobileno")
	 	String visitormobileno;
	 	

	 	@Column(name="visitoremailid")
	 	String visitoremailid;

		

		public String getVisitoremailid() {
			return visitoremailid;
		}

		public void setVisitoremailid(String visitoremailid) {
			this.visitoremailid = visitoremailid;
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

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
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

		public String getVisitorname() {
			return visitorname;
		}

		public void setVisitorname(String visitorname) {
			this.visitorname = visitorname;
		}

		public String getVisitormobileno() {
			return visitormobileno;
		}

		public void setVisitormobileno(String visitormobileno) {
			this.visitormobileno = visitormobileno;
		}
	 	
}
