package com.dao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.vo.*;
import com.controller.*;

@Repository
public class reg_dao {
	
	@Autowired
	SessionFactory sessionfactory;

	
	public void reg_insert(reg_vo vo) throws Exception
	{
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.saveOrUpdate(vo);
		transaction.commit();
		session.close();
	}
	
	public void student_reg_insert(student_reg student_reg)
	{
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.saveOrUpdate(student_reg);
		transaction.commit();
		session.close();
	}
	
	public void update_flag(generate_hostelid_vo generate_hostelid)
	{
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query q=session.createQuery("update generate_hostelid_vo set flag='"+generate_hostelid.getFlag()+"' where hostelid='"+generate_hostelid.getHostelid()+"'");
		int i=q.executeUpdate();
		transaction.commit();
		session.close();
	}
	
	public void login_insert(login_vo vo) throws Exception
	{
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.saveOrUpdate(vo);
		transaction.commit();
		session.close();
	}
	
	public List logincheck(String us1,String ps1)
	{	
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from reg_vo where username='"+us1+"'  and password='"+ps1+"' ");
		List l=q.list();
		session.close();
		return l;		
	}

	public void removeroom(student_reg student_reg) {
		String sql="delete from student_reg where roomno="+student_reg.getRoomno();
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query q=session.createQuery(sql);
		int i=q.executeUpdate();
		transaction.commit();
		session.close();		
	}
	
	public List collect_student_info(String hostelid)
	{
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from student_reg where hostelid='"+hostelid+"'");
		List l=q.list();
		session.close();
		return l;
		
	}

	public String getownermail() {
		
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from reg_vo");
		List l=q.list();
		reg_vo ob=(reg_vo)l.get(0);
		String email=ob.getEmailid();
		session.close();
		return email;
	}

	public String getmessmail() {
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from mess_reg_vo");
		List l=q.list();
		mess_reg_vo ob=(mess_reg_vo)l.get(0);
		String email=ob.getEmail();
		session.close();
		return email;
	}
	
	public void updateownerpassword(String newpassword) {
		
		int id=1;
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query q=session.createQuery("update reg_vo set password='"+newpassword+"',confirmpassword='"+newpassword+"' where id='"+id+"'");
		int i=q.executeUpdate();
		transaction.commit();
		session.close();
		
		
	}

	public void updatemesspassword(String newpassword) {
		int id=1;
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query q=session.createQuery("update mess_reg_vo set password='"+newpassword+"',confirmpassword='"+newpassword+"' where id='"+id+"'");
		int i=q.executeUpdate();
		transaction.commit();
		session.close();
		
	}

	public String getstudentmail(String hostelid) {
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from student_reg where hostelid='"+hostelid+"'");
		List l=q.list();
		if(!l.isEmpty())
		{
			student_reg ob=(student_reg)l.get(0);
			String email=ob.getEmail();
			session.close();
			return email;
		}
		else
		{
			session.close();
			return "not generated";
		}
		
	} 

	public void updatestudentpassword(String newpassword, String hostelid) {
		System.out.println("updatestudentpassword");
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query q=session.createQuery("update generate_hostelid_vo set password='"+newpassword+"' where hostelid='"+hostelid+"'");
		int i=q.executeUpdate();
		transaction.commit();
		session.close();
		
	}

	public String checkaccount() {
		
		String check_acc="";
		Session session=sessionfactory.openSession();
        Query q = session.createQuery("from reg_vo");
        List l = q.list();
        session.close();
        if(l.isEmpty()){
        	check_acc="not created";
        }
        else{
        	check_acc="created";
        }
		return check_acc;
	}
}
