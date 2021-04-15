package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vo.add_room_vo;
import com.vo.guest_stay_vo;
import com.vo.leave_application;

@Repository
public class guest_stay_dao {
	@Autowired
	SessionFactory sessionfactory;
	
	
	public void insert(guest_stay_vo guest_stay)
	{
		System.out.println("INSERT INTO DATABASE");
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.saveOrUpdate(guest_stay);
		transaction.commit();
		session.close();
	}
	
	public List getlist(String hostelid)
	{
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from guest_stay_vo where hostelid='"+hostelid+"'");
		List l=q.list();
		session.close();
		return l;
	}
	
	public List featallchdata(int start)
	{
		String status="pending";
		System.out.println("Featch All Data");
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from guest_stay_vo where status='"+status+"'");
		q.setFirstResult(start);
		q.setMaxResults(5);
		List l=q.list();
		session.close();
		return l;	
	}
	
	public void rejectgueststay(guest_stay_vo guest_stay_vo)
	{
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query q=session.createQuery("update guest_stay_vo set status='"+guest_stay_vo.getStatus()+"' where id='"+guest_stay_vo.getId()+"'");
		int i=q.executeUpdate();
		transaction.commit();
		session.close();
	}
	
	public String updatestatus(guest_stay_vo guest_stay_vo,int vacancy)
	{
		int noofguest = 0,roomno=0;
		String s="";
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		String status=guest_stay_vo.getStatus();
		Query q1=session.createQuery("from guest_stay_vo where id='"+guest_stay_vo.getId()+"'");
		List l=q1.list();
		if(!l.isEmpty()){
			
				guest_stay_vo ob=(guest_stay_vo) l.get(0);
				noofguest = ob.getNoofguest();
			if(noofguest>vacancy)
			{
				s="overflow";
			}
			else
			{
				Query q2=session.createQuery("from add_room_vo where roomno='"+guest_stay_vo.getAllocatedroom()+"'");
				List l1=q2.list();
				add_room_vo ob1=(add_room_vo)l1.get(0);
				int currentmember=ob1.getCurrentmember()+noofguest;
				Query q=session.createQuery("update guest_stay_vo set status ='"+status+"',allocatedroom='"+guest_stay_vo.getAllocatedroom()+"' where id ='"+guest_stay_vo.getId()+"'");
				Query q3=session.createQuery("update add_room_vo set currentmember='"+currentmember+"' where roomno='"+guest_stay_vo.getAllocatedroom()+"'");
				int j=q3.executeUpdate();
				int i=q.executeUpdate();
				s="allocated";
			}

		}
						
		transaction.commit();
		session.close();
		return s;
	}

	public List getguestroom(int id,String speciality,int noofguest) {
		
		String type="guest room";
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from add_room_vo where roomtype='"+type+"' and speciality='"+speciality+"' and capacity>='"+noofguest+"'");
		List l=q.list();
		session.close();
		return l;
	}

	public List getapplication() {
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from guest_stay_vo where status='approved'");
		List l=q.list();
		session.close();
		return l;
	}

	public int getnoofrequests() {
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from guest_stay_vo where status='pending'");
		List l=q.list();
		session.close();
		return l.size();
	}

	public List getallocatedrooms() {
		
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from guest_stay_vo where status='approved'");
		List l=q.list();
		session.close();

		return l;
	}

	public void deallocateroom(int id, int allocatedroom, int noofguest) {
		
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("update guest_stay_vo set status='deallocated' where id='"+id+"'");
		int i1=q.executeUpdate();
		Query q1=session.createQuery("from add_room_vo where roomno='"+allocatedroom+"'");
		List l=q1.list();
		add_room_vo ob=(add_room_vo)l.get(0);
		int currentmember=ob.getCurrentmember();
		currentmember=currentmember-noofguest;
		Query q2=session.createQuery("update add_room_vo set currentmember='"+currentmember+"' where roomno='"+allocatedroom+"'");
		int i2=q2.executeUpdate();
		session.close();
	}

}
