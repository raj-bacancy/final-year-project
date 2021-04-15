package com.dao;
import java.util.ArrayList;
import java.util.Calendar;
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
public class fee_receipt_dao {

	@Autowired
	SessionFactory sessionfactory;
	
	public void feereceiptapply(fee_receipt fee)
	{
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.saveOrUpdate(fee);
		transaction.commit();
		session.close();
	}
	
	public List collect_data()throws Exception
	{
		String s="pending";
		String s1="H0001";
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from food_coupon where status='"+s+"' and hostelid='"+s1+"'" );
		List l=q.list();
		session.close();
		return l;
	}
	
	public List collect_datas(int start)throws Exception
	{
		String s="pending";
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from fee_receipt where status='"+s+"'");
		q.setFirstResult(start);
		q.setMaxResults(5);
		List l=q.list();
		session.close();
		return l;
	}
	
	public List getstatus(String hostelid)
	{
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from fee_receipt where hostelid='"+hostelid+"'");
		List l=q.list();
		session.close();
		return l;
	}

	public void updatestatus(fee_receipt fee_receipt)
	{
		System.out.println("Update Status");
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		String status=fee_receipt.getStatus();
		Query q=session.createQuery("update fee_receipt set status ='"+status+"' where id ='"+fee_receipt.getId()+"'");
		int i=q.executeUpdate();
		System.out.println("Update Status1");
		transaction.commit();
		session.close();
	}

	public int getnoofrequests() {
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from fee_receipt where status='pending'");
		List l=q.list();
		session.close();
		return l.size();
	}
	
	 public  List collectpaidfeealldata(int year) {
		 String currentyear=Integer.toString(year);
	       Session session = sessionfactory.openSession();
	       Query q = session.createQuery("from fee_receipt where status='approved'");
	       List l =q.list();
	       session.close();
	      return l;
	  }

	public List collectunpaidfeealldata(int year) {
		
		String query="select hostelid from fee_receipt where status='approved' and currentyear='"+year+"'";
		String query1="select hostelid from generate_hostelid_vo";
		Session session = sessionfactory.openSession();
	       Query q = session.createQuery(query);
	       Query q1=session.createQuery(query1);
	       List l =q.list();
	       List l1=q1.list();
	       session.close();
	       
	       for(int i=0;i<l.size();i++)
	       {
	    	   if(l1.contains(l.get(i)))
	    	   {
	    		   l1.remove(l.get(i));
	    	   }
	       }
	      
	       return l1;
	}

	public int[] getnoofpaidrequests() {
		
		int no[]=new int[2];
		int year = Calendar.getInstance().get(Calendar.YEAR);
		String query="select hostelid from fee_receipt where status='approved' and currentyear='"+year+"'";
		String query1="select hostelid from generate_hostelid_vo";
		Session session = sessionfactory.openSession();
	       Query q = session.createQuery(query);
	       Query q1=session.createQuery(query1);
	       List l =q.list();
	       List l1=q1.list();
	       session.close();
	       
	       for(int i=0;i<l.size();i++)
	       {
	    	   if(l1.contains(l.get(i)))
	    	   {
	    		   l1.remove(l.get(i));
	    	   }
	       }
	       no[0]=l.size();
	       no[1]=l1.size();
	       
	       return no;
	}
	
	
	
}
