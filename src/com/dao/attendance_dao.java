package com.dao;

import java.util.*;
import java.text.SimpleDateFormat;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vo.*;

@Repository
public class attendance_dao {
	
	@Autowired
	SessionFactory sessionfactory;
	
	public void insertpresenr(String[] hostelid) {
		
		attendance_vo ob=new attendance_vo();
		String student=hostelid[0];
		for(int i=1;i<hostelid.length;i++)
		{
			student=student+"-"+hostelid[i];
		}
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
    	String date=f.format(new Date());
    	ob.setStudents(student);
    	ob.setToday(date);
    	
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query q=session.createQuery("from attendance_vo where today='"+date+"'");
		List l=q.list();
		if(l.size()!=0)
		{
			attendance_vo ob1=(attendance_vo)l.get(0);
			String student1=ob1.getStudents();
			student1=student+"-"+student1;
			ob1.setStudents(student1);
			session.update(ob1);
		}
		else
		{
			session.saveOrUpdate(ob);
		}
		transaction.commit();
		session.close();
		
	}

	public List getabsent() {
		
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
    	String date=f.format(new Date());
    	String query1="select hostelid from generate_hostelid_vo";
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query q=session.createQuery("from attendance_vo where today='"+date+"'");
		Query q1=session.createQuery(query1);
		List l=q.list();
		List l1=q1.list();
		if((!l.isEmpty()) &&(!l1.isEmpty())){
			
			attendance_vo ob=(attendance_vo)l.get(0);
			String student=ob.getStudents();
			String hostelid[]=student.split("-");
			Set<String> set = new HashSet<>(Arrays.asList(hostelid));		
			List studenthostelid=new ArrayList<>();
			 Iterator<String> it = set.iterator();
		     while(it.hasNext()){
		    	 studenthostelid.add(it.next());
		     }
		     
			for(int i=0;i<studenthostelid.size();i++)
			{
				if(l1.contains(studenthostelid.get(i)))
				{
		    		   l1.remove(studenthostelid.get(i));
				}
			}
			
			transaction.commit();
			session.close();
			
		}
		
		
		return l1;
	}

}
