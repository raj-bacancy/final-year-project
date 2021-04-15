package com.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vo.food_coupon;
import com.vo.leave_application;

@Repository
public class leave_application_dao {
	@Autowired
	SessionFactory sessionfactory;
	
	public void insert(leave_application leave_application)
	{
		leave_application.setStatus("pending");
		System.out.println("INSERT INTO DATABASE");
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.saveOrUpdate(leave_application);
		transaction.commit();
		session.close();
	}
	
	public List featchdata(String hostelid)
	{
		System.out.println("Featch Data");
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from leave_application where hostelid='"+hostelid+"'");
		List l=q.list();
		session.close();
		return l;	
	}
	
	public List featallchdata(int start)
	{
		String status="pending";
		System.out.println("Featch All Data");
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from leave_application where status='"+status+"'");
		q.setFirstResult(start);
		q.setMaxResults(5);
		List l=q.list();
		session.close();
		return l;	
	}
	
	public void updatestatus(leave_application leave_application)
	{
		System.out.println("Update Status");
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		String status=leave_application.getStatus();
		Query q=session.createQuery("update leave_application set status ='"+status+"' where id ='"+leave_application.getId()+"'");
		int i=q.executeUpdate();
		System.out.println("Update Status1");
		transaction.commit();
		session.close();
	}

	public List getapplication() {
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from leave_application where status='approved'");
		List l=q.list();
		session.close();
		return l;	
	}

	public int getnoofrequests() {
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from leave_application where status='pending'");
		List l=q.list();
		session.close();
		return l.size();	
	}

}
