

package com.dao;

import org.hibernate.Query;
import com.vo.login_vo;
import java.util.List;
import org.hibernate.Transaction;
import org.hibernate.Session;
import com.vo.mess_reg_vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class mess_reg_dao
{
    @Autowired
    SessionFactory sessionfactory;
    
    public void insert(final mess_reg_vo mess_reg) {
        final Session session = this.sessionfactory.openSession();
        final Transaction transaction = session.beginTransaction();
        session.saveOrUpdate((Object)mess_reg);
        transaction.commit();
        session.close();
    }
    
    public List logincheck(String us1,String ps1) {
        Session session = this.sessionfactory.openSession();
        Query q = session.createQuery("from mess_reg_vo where username='" + us1 + "'  and password='" + ps1 + "' ");
        List l = q.list();
        session.close();
        return l;
    }

	public String checkaccount() {
		String check_acc="";
		Session session =sessionfactory.openSession();
        Query q = session.createQuery("from mess_reg_vo");
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
