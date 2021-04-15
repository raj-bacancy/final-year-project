package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class locker_dao {
	
	@Autowired
    SessionFactory sessionfactory;
	
	public List getdoc(String hostelid) {
        Session session = this.sessionfactory.openSession();
        Query q = session.createQuery("from locker_vo where hostelid='"+hostelid+"'");
        List l = q.list();
        session.close();
        return l;
    }
}
