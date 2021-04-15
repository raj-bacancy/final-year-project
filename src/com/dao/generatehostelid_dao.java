package com.dao;


import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vo.*;



@Repository
public class generatehostelid_dao {

	@Autowired
	SessionFactory sessionfactory;
	
	public String insert(generate_hostelid_vo generate_hostelid)
	{
		String checkroom="";
		String type="student room";
		int roomno=0,currentmember=0,capacity=0;
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query q=session.createQuery("from add_room_vo where roomno='"+generate_hostelid.getRoomno()+"' and roomtype='"+type+"'");
		List l=q.list();		
		if(l.isEmpty())
		{
			checkroom="no room";
		}
		else
		{
			for(int i=0;i<l.size();i++)
			{
				add_room_vo ob=(add_room_vo) l.get(i);
				currentmember=ob.getCurrentmember();
				capacity=ob.getCapacity();
				roomno=ob.getRoomno();
			}
				if(currentmember==capacity)
				{
					checkroom="room full";
				}
				else
				{
					currentmember++;
					Query q1=session.createQuery("from generate_hostelid_vo where hostelid='"+generate_hostelid.getHostelid()+"'");
					List lst=q1.list();
					if(lst.isEmpty()){
						Query qq=session.createQuery("update add_room_vo set currentmember='"+currentmember+"' where roomno='"+roomno+"'");
						int j=qq.executeUpdate();
						checkroom="successfully generated";
						session.save(generate_hostelid);
					}else{
						System.out.println("ERROR!!! ");
						transaction.commit();
						session.close();
						return "error";
					}
					/*try
					{
						Query qq=session.createQuery("update add_room_vo set currentmember='"+currentmember+"' where roomno='"+roomno+"'");
						int j=qq.executeUpdate();
						checkroom="successfully generated";
						session.save(generate_hostelid);
						
					}
					catch(Exception e)
					{
						System.out.println("ERROR!!! "+e.getMessage());
						transaction.commit();
						session.close();
						return "error";
					}*/
					
				}
		}
		transaction.commit();
		session.close();
		return checkroom;
	}
	
	public String checkstudent(String hostelid,String password)
	{
		Session session=sessionfactory.openSession();
		int flag=1;
		Query q=session.createQuery("from generate_hostelid_vo where hostelid='"+hostelid+"'");
		List l=q.list();
		if(l.isEmpty())
		{
			session.close();
			return "Not Generated";
		}
		else
		{
			Query q1=session.createQuery("from generate_hostelid_vo where hostelid='"+hostelid+"' and password='"+password+"'");
			List l1=q1.list();
			if(l1.isEmpty())
			{
				session.close();
				return "Wrong Info";
			}
			else
			{
				Query q2=session.createQuery("from generate_hostelid_vo where hostelid='"+hostelid+"' and password='"+password+"' and flag='"+flag+"'");
				List l2=q2.list();
				if(l2.isEmpty())
				{
					session.close();
					return "Not registered";
				}
				else
				{
					session.close();
					return "Correct Student";
				}
			}
			
		}
	}

	public void removeroom(generate_hostelid_vo generate_hostelid_vo) {		
		String sql="delete from generate_hostelid_vo where roomno="+generate_hostelid_vo.getRoomno();
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query q=session.createQuery(sql);
		int i=q.executeUpdate();
		transaction.commit();
		session.close();	
	}

	public int getroomno(String hostelid) {
		int roomno=0;
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query q=session.createQuery("from generate_hostelid_vo where hostelid='"+hostelid+"'");
		List l=q.list();
		generate_hostelid_vo ob=(generate_hostelid_vo)l.get(0);
		roomno=ob.getRoomno();
		transaction.commit();
		session.close();				
		return roomno;
	}

	public String getnexthostelid() {
		
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from generate_hostelid_vo");
		List l=q.list();
		if(l.isEmpty())
		{
			session.close();
			return "H0";
		}
		else
		{
			generate_hostelid_vo ob=(generate_hostelid_vo)l.get(l.size()-1);
			String hostelid=ob.getHostelid();
			session.close();
			return hostelid;
		}
	}

	public List getstudents(String roomno) {
		int room=Integer.parseInt(roomno);
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from generate_hostelid_vo where roomno='"+room+"'");
		List l=q.list();
		session.close();
		return l;
	}

	
}
