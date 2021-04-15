package com.dao;

import org.hibernate.Query;
import java.util.List;
import org.hibernate.Transaction;
import org.hibernate.Session;
import com.vo.complain;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class complain_dao
{
    @Autowired
    SessionFactory sessionfactory;
    
    public void complainapply(complain com) {
          Session session = this.sessionfactory.openSession();
          Transaction transaction = session.beginTransaction();
        session.saveOrUpdate((Object)com);
        transaction.commit();
        session.close();
    }
    
    public List collect_data(String hostelid) {
        Session session = sessionfactory.openSession();
        Query q = session.createQuery("from complain where hostelid='" + hostelid + "'");
        List l = q.list();
        session.close();
        return l;
    }
    public List checkvalidcomplain(String hostelid,String date) {
        Session session = sessionfactory.openSession();
        Query q = session.createQuery("from complain where hostelid='" + hostelid + "' and date='"+date+"'" );
        List l = q.list();
        session.close();
        return l;
    }
    public List collectcomplainreply(String hostelid,String date) {
        Session session = sessionfactory.openSession();
        Query q = session.createQuery("from complain where hostelid='" + hostelid + "' and  date='"+date+"'" );
        List l = q.list();
        session.close();
        return l;
    }
    public List complainreply(String hostelid,String date) {
        Session session = sessionfactory.openSession();
        Query q = session.createQuery("from complain where hostelid='" + hostelid + "' and  date='"+date+"'" );
        List l = q.list();
        session.close();
        return l;
    }
    public List collectcomplainlist() {
    	String s="Solved";
        Session session = sessionfactory.openSession();
        Query q = session.createQuery("from complain where status='"+s+"'" );
        List l = q.list();
        session.close();
        return l;
    }
    public List collect_datas(){
        String s = "pending";
        Session session = this.sessionfactory.openSession();
        Query q = session.createQuery("from complain where status='"+s+"'");
        List l = q.list();
        session.close();
        return l;
    }
    
    public List collect_complain(String id,String date) {
        Session session = sessionfactory.openSession();
        Query q = session.createQuery("from complain where hostelid='" + id + "'and date='" + date + "'");
        List l = q.list();
        session.close();
        return l;
    }
    
    public void updatestatus(String reply,String hostelid) {
        Session session = sessionfactory.openSession();
          Transaction transaction = session.beginTransaction();
          String status = "Solved";
          Query q = session.createQuery("update complain set status ='" + status + "' , reply='" + reply + "' where hostelid ='" + hostelid + "'");
          int i = q.executeUpdate();
        transaction.commit();
        session.close();
    }
}
