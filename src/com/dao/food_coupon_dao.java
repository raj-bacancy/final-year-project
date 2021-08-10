package com.dao;
import java.util.*;
import java.time.*;
import java.text.*;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.vo.*;
import com.dao.*;

@Repository
public class food_coupon_dao {
	
	@Autowired
	SessionFactory sessionfactory;
	
	
	    
	public void foodapply(food_coupon food)
	{
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.saveOrUpdate(food);
		transaction.commit();
		session.close();
	}
	
	public void updatestatus(food_coupon food_coupon)
	{
		System.out.print("Rejected1");
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		String status=food_coupon.getStatus();
		Query q=session.createQuery("update food_coupon set status ='"+status+"' where id ='"+food_coupon.getId()+"'");
		int i=q.executeUpdate();
		System.out.print("Rejected");
		transaction.commit();
		session.close();
	}
	
	public List collect_data(String hostelid)
	{
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from food_coupon where hostelid='"+hostelid+"'");
		List l=q.list();
		session.close();
		return l;
	}
	
	public List collect_datas(int start)throws Exception
	{
		String status="pending";
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from food_coupon where status='"+status+"'");
		//q.setFirstResult(start);
		//q.setMaxResults(5);
		List<food_coupon> l=q.list();
		session.close();
		return l;
	}

	public int getnoofrequests() {
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from food_coupon where status='pending'");
		List l=q.list();
		session.close();
		return l.size();
	}


	public List<coupon_count> getMenuCount() {
		 SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String s1=f.format(new Date());
		
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from coupon_count where date<='"+s1+"' order by date desc");
		q.setMaxResults(7);
		List<coupon_count> l=q.list();
		session.close();
		return l;
	}
	
	public List<coupon_count> getMexMenuCount() {
		 SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String s1=f.format(new Date());
		
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from coupon_count where date<='"+s1+"' order by total_count desc");
		q.setMaxResults(7);
		List<coupon_count> l=q.list();
		session.close();
		return l;
	}
	
	public List<coupon_count> getMinMenuCount() {
		 SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String s1=f.format(new Date());
		
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from coupon_count where date<='"+s1+"' order by total_count asc");
		q.setMaxResults(7);
		List<coupon_count> l=q.list();
		session.close();
		return l;
	}
	
	public List<coupon_count> getLastMonthMenuCount() {
		 SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String s1=f.format(new Date());
		
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from coupon_count where date<='"+s1+"' order by total_count asc");
		q.setMaxResults(7);
		List<coupon_count> l=q.list();
		session.close();
		return l;
	}

	public List<coupon_count> getfilterdateMenuCount(String date_from, String date_to) {
		Session session=sessionfactory.openSession();
		System.out.println("Filter by date initial ==============================");
		Query q=session.createQuery("from coupon_count where date<='"+date_to+"' AND date>='"+date_from+"'");
		List<coupon_count> l=q.list();
		session.close();
		System.out.println("Filter by date =============================="+l);
		
		return l;
	}


}
