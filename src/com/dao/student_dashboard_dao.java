package com.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vo.add_room_vo;
import com.vo.attendance_vo;

@Repository
public class student_dashboard_dao {

	@Autowired
	SessionFactory sessionfactory;
	
	public List getstudent(String us1) {
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from student_reg where hostelid='"+us1+"'");
		List l=q.list();
		session.close();
		return l;
	}

	public List getroom(int roomno) {
		
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from student_reg where roomno='"+roomno+"'");
		List l=q.list();
		session.close();
		return l;
	
	}

	public int getnoofroom() {
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from add_room_vo");
		List l=q.list();
		session.close();
		return l.size();
	}

	public int getnoofstudentroom() {
		
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from add_room_vo where roomtype='student room'");
		List l=q.list();
		session.close();
		return l.size();
		
	}

	public int getnoofguestroom() {
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from add_room_vo where roomtype='guest room'");
		List l=q.list();
		session.close();
		return l.size();
	}

	public int[] getcapacity() {
		
		int capacity[]=new int[3];
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from add_room_vo where roomtype='student room'");
		List l=q.list();
		session.close();
		
		add_room_vo ob=new add_room_vo();
		int x=0;
		for(int i=0;i<l.size();i++)
		{
			ob=(add_room_vo)l.get(i);
			x=ob.getCapacity();
			capacity[0]=capacity[0]+x;
		}
		
		x=0;
		for(int i=0;i<l.size();i++)
		{
			ob=(add_room_vo)l.get(i);
			x=ob.getCurrentmember();
			capacity[1]=capacity[1]+x;
		}
		
		capacity[2]=capacity[0]-capacity[1];
		
		return capacity;
		
	}

	public int get_no_of_absent_student() {
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
    	String s1=f.format(new Date());
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from attendance_vo where today='"+s1+"'");
		List l=q.list();
		int no_of_absent_student = 0;
		System.out.println("List ======== outside "+l.size()+"Date is "+s1);
		if(l.size()!=0){
			attendance_vo ob = (attendance_vo) l.get(0);
			String present_student = ob.getStudents();
			no_of_absent_student = present_student.split("-").length;
			System.out.println("List ========"+l.get(0));
		}
		session.close();
		return no_of_absent_student;
	}

}
