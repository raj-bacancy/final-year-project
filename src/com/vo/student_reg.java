package com.vo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="student_registration")
public class student_reg {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	
	@Column(name="firstname")
	String firstname;

	@Column(name="lastname")
	String lastname;

	@Column(name="email")
	String email;

	@Column(name="roomno")
	int roomno;

	@Column(name="hostelid")
	String hostelid;

	@Column(name="phoneno")
	String phoneno;

	@Column(name="nameofinstitute")
	String nameofinstitute;
	
	@Column(name="program")
	String program;
	
	@Column(name="field")
	String field;

	@Column(name="image")
	String image;

	@Column(name="gender")
	String gender;
	
	@Column(name="dateofbirth")
	String dateofbirth;

	@Column(name="bloodgroup")
	String bloodgroup;

	@Column(name="nationality")
	String nationality;
	
	@Column(name="applicationdate")
	String applicationdate;

	@Column(name="fathername")
	String fathername;

	@Column(name="fathercellno")
	String fathercellno;
	
	@Column(name="fatheremailid")
	String fatheremailid;
	
	@Column(name="address")
	String address;

	@Column(name="mothername")
	String mothername;
	
	@Column(name="mothercellno")
	String mothercellno;

	

	@Column(name="docno")
	String docno;

	@Column(name="doclink")
	String doclink;

	@Column(name="doctype")
	String doctype;

	public String getDocno() {
		return docno;
	}

	public void setDocno(String docno) {
		this.docno = docno;
	}

	public String getDoclink() {
		return doclink;
	}

	public void setDoclink(String doclink) {
		this.doclink = doclink;
	}

	public String getDoctype() {
		return doctype;
	}

	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getRoomno() {
		return roomno;
	}

	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}

	public String getFatheremailid() {
		return fatheremailid;
	}

	public void setFatheremailid(String fatheremailid) {
		this.fatheremailid = fatheremailid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public String getHostelid() {
		return hostelid;
	}

	public void setHostelid(String hostelid) {
		this.hostelid = hostelid;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getNameofinstitute() {
		return nameofinstitute;
	}

	public void setNameofinstitute(String nameofinstitute) {
		this.nameofinstitute = nameofinstitute;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getApplicationdate() {
		return applicationdate;
	}

	public void setApplicationdate(String applicationdate) {
		this.applicationdate = applicationdate;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public String getFathercellno() {
		return fathercellno;
	}

	public void setFathercellno(String fathercellno) {
		this.fathercellno = fathercellno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMothername() {
		return mothername;
	}

	public void setMothername(String mothername) {
		this.mothername = mothername;
	}

	public String getMothercellno() {
		return mothercellno;
	}

	public void setMothercellno(String mothercellno) {
		this.mothercellno = mothercellno;
	}

}
