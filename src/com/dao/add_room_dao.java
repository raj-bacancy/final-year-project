package com.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vo.add_room_vo;
import com.vo.generate_hostelid_vo;

@Repository
public class add_room_dao {

		@Autowired
		SessionFactory sessionfactory;
		
		public boolean insert(add_room_vo add_room_vo)
		{
			Session session=sessionfactory.openSession();
			Transaction transaction=session.beginTransaction();
			Query q=session.createQuery("from add_room_vo where roomno='"+add_room_vo.getRoomno()+"'");
			List l=q.list();
			if(l.isEmpty()){
				session.saveOrUpdate(add_room_vo);
				transaction.commit();
				session.close();
				return true;
			}else{
				transaction.commit();
				session.close();
				return false;
			}
			
		}
		
		/*public void insert(add_room_vo add_room_vo)
		{
			Session session=sessionfactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.saveOrUpdate(add_room_vo);
			transaction.commit();
			session.close();
		}*/

		public String removeroom(add_room_vo add_room_vo) {
		
			String status="";
			System.out.println("removeroom1");
			Session session=sessionfactory.openSession();
			Transaction transaction=session.beginTransaction();
			Query q=session.createQuery("from add_room_vo where roomno='"+add_room_vo.getRoomno()+"'");
			List l=q.list();
			if(l.isEmpty()){
				status="can't remove";
				transaction.commit();
				session.close();	
				
				return status;
			}
			add_room_vo ob=(add_room_vo)l.get(0);
			int currentmember=ob.getCurrentmember();
			System.out.println("removeroom currentmember1 "+ob.getCurrentmember());
			if(currentmember==0)
			{
				status="deleted";
				Query q1=session.createQuery("delete add_room_vo where roomno='"+add_room_vo.getRoomno()+"'");
				int i=q1.executeUpdate();
				System.out.println("removeroom currentmember2 "+ob.getCurrentmember());
			}
			else
			{
				status="can't remove";
			}

			transaction.commit();
			session.close();	
			
			return status;
		}

		public List getrooms() {
			Session session=sessionfactory.openSession();
			Transaction transaction=session.beginTransaction();
			Query q=session.createQuery("from add_room_vo where roomtype='student room'");
			List l=q.list();
			transaction.commit();
			session.close();
			return l;
		}

		public List getstudents(int roomno) {
			Session session=sessionfactory.openSession();
			Transaction transaction=session.beginTransaction();
			Query q=session.createQuery("from student_reg where roomno='"+roomno+"'");
			List l=q.list();
			transaction.commit();
			session.close();
			return l;
		}
}
