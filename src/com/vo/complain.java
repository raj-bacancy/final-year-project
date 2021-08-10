package com.vo;

import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "complain")
public class complain
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name = "hostelid")
    String hostelid;
    @Column(name = "subject")
    String subject;
    @Column(name = "complain")
    String complain;
    @Column(name = "flag")
    int flag;
    @Column(name = "reply")
    String reply;
    @Column(name = "date")
    String date;
    @Column(name = "status")
    String Status;
    @Column(name = "assignee")
    String assignee;
    @Column(name = "type")
    String type;
    
    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getStatus() {
        return this.Status;
    }
    
    public void setStatus(final String status) {
        this.Status = status;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public String getHostelid() {
        return this.hostelid;
    }
    
    public void setHostelid(final String hostelid) {
        this.hostelid = hostelid;
    }
    
    public String getSubject() {
        return this.subject;
    }
    
    public void setSubject(final String subject) {
        this.subject = subject;
    }
    
    public String getComplain() {
        return this.complain;
    }
    
    public void setComplain(final String complain) {
        this.complain = complain;
    }
    
    public int getFlag() {
        return this.flag;
    }
    
    public void setFlag(final int flag) {
        this.flag = flag;
    }
    
    public String getReply() {
        return this.reply;
    }
    
    public void setReply(final String reply) {
        this.reply = reply;
    }
    
    public String getDate() {
        return this.date;
    }
    
    public void setDate(final String date) {
        this.date = date;
    }
}