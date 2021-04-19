package com.dao;

import com.vo.*;
import org.hibernate.Query;
import java.util.List;
import com.vo.food_dinner;
import org.hibernate.Transaction;
import org.hibernate.Session;
import com.vo.food_lunch;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class food_dao
{
    @Autowired
    SessionFactory sessionfactory;
    
    /*public void setlunch(final food_lunch food) throws Exception {
        final Session session = this.sessionfactory.openSession();
        final Transaction transaction = session.beginTransaction();
        session.saveOrUpdate((Object)food);
        transaction.commit();
        session.close();
    }
    
    public void setdinner(final food_dinner food) throws Exception {
        final Session session = this.sessionfactory.openSession();
        final Transaction transaction = session.beginTransaction();
        session.saveOrUpdate((Object)food);
        transaction.commit();
        session.close();
    }*/
    
    public void updatecouponlunch(String date,String lunchmenu,int lunchprice)  {
	    
        Session session = this.sessionfactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("update coupon_count set lunchmenu='"+lunchmenu+"',lunchprice='"+lunchprice+"' where date ='" + date + "'");
        int i = q.executeUpdate();
        transaction.commit();
        session.close();
    }
    public void updatecoupondinner(String date,String dinnermenu,int dinnerprice)  {
        
        Session session = this.sessionfactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("update coupon_count set dinnermenu='"+dinnermenu+"',dinnerprice='"+dinnerprice+"' where date ='" + date + "'");
        int i = q.executeUpdate();
        transaction.commit();
        session.close();
    }
    
    public List checkdate(String date) {
        Session session = sessionfactory.openSession();
        Query q = session.createQuery("from coupon_count where  date='" + date + "'");
        List l = q.list();
        session.close();
        return l;
    }
    
    public List getlunch(String date) {
        Session session = sessionfactory.openSession();
        Query q = session.createQuery("from coupon_count where  date='" + date + "'");
        List l = q.list();
        session.close();
        return l;
    }
    
    public List getdinner(String date) {
        Session session = this.sessionfactory.openSession();
        Query q = session.createQuery("from coupon_count where  date='" + date + "'");
        List<complain> l = (List<complain>)q.list();
        session.close();
        return l;
    }
    
    public void setcouponlunch(coupon_count food){
        Session session = sessionfactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(food);
        transaction.commit();
        session.close();
    }
    public void setcoupondinner(coupon_count food){
        Session session = sessionfactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(food);
        transaction.commit();
        session.close();
    }
   /* public void setcoupondinner(coupon_count food,String date)  {
    	System.out.println("Update Status");
        Session session = this.sessionfactory.openSession();
       Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("update coupon_count set dinnermenu='"+food.getDinnermenu()+"',dinnerprice='"+food.getDinnerprice()+"' where date ='" + date + "'");
        int i = q.executeUpdate();
        System.out.println("Update Status1");
        transaction.commit();
        session.close();
    }*/
    public  List getlunchcoupon( String date) {
         Session session = sessionfactory.openSession();
         Query q = session.createQuery("from coupon_count where  date='" + date + "'");
         List<complain> l = (List<complain>)q.list();
         session.close();
        return l;
    }
    public void setlunchcoupon(String date,int a) {
    	System.out.println("Update Status");
        Session session = this.sessionfactory.openSession();
        Transaction transaction = session.beginTransaction();   
        Query q = session.createQuery("update coupon_count set lunch='"+a+"' where date ='" + date + "'");
        int i = q.executeUpdate();
        System.out.println("Update Status1");
        transaction.commit();
        session.close();
    }
    public  List getdinnercoupon( String date) {
        Session session = sessionfactory.openSession();
        Query q = session.createQuery("from coupon_count where  date='" + date + "'");
        List<complain> l = (List<complain>)q.list();
        session.close();
       return l;
   }
   public void setdinnercoupon(String date,int a) {
      Session session = this.sessionfactory.openSession();
     Transaction transaction = session.beginTransaction();
   
      Query q = session.createQuery("update coupon_count set dinner='"+a+"' where date ='" + date + "'");
       int i = q.executeUpdate(); 
       transaction.commit();
       session.close();
   }
   public  List collectcouponalldata() {
       Session session = sessionfactory.openSession();
       Query q = session.createQuery("from coupon_count");
       List l =q.list();
       session.close();
      return l;
  }
   public  List collect_student_data(int start) {
       Session session = sessionfactory.openSession();
       Query q = session.createQuery("from student_reg");
       //q.setFirstResult(start);
       //q.setMaxResults(10);
       List l =q.list();
       session.close();
      return l;
  }
   public  List collectmessdata() {
       Session session = sessionfactory.openSession();
       Query q = session.createQuery("from mess_reg_vo");
       List l =q.list();
       session.close();
      return l;
  }

   public  List collectemailid() {
       Session session = sessionfactory.openSession();
       String hql = "SELECT email FROM student_reg";
       Query query = session.createQuery(hql);
       List l = query.list();
       session.close();
      return l;
  }
   
   public  List collectownerdata() {
       Session session = sessionfactory.openSession();
       Query q = session.createQuery("from reg_vo");
       List l =q.list();
       session.close();
      return l;
  }
   
   public  List collecttodaycoupondata(String date) {
       Session session = sessionfactory.openSession();
       Query q = session.createQuery("from coupon_count where date='"+date+"'");
       List l =q.list();
       session.close();
      return l;
  }
   
   public void visitordata(visitor v){
       Session session = sessionfactory.openSession();
       Transaction transaction = session.beginTransaction();
       session.saveOrUpdate(v);
       transaction.commit();
       session.close();
   }
   
   public List collect_student_payfood_data(String hostel_id) {
       Session session = sessionfactory.openSession();
       Query q = session.createQuery("from student_reg where  hostelid='" + hostel_id + "'");
       List l = q.list();
       session.close();
       return l;
   }
   
   
}



