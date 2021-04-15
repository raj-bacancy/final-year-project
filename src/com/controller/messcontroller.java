
package com.controller;

import java.util.Date;

import java.util.*;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.Address;
import javax.mail.internet.InternetAddress;
import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
import javax.mail.Session;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import com.vo.login_vo;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.vo.*;
import com.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.dao.mess_reg_dao;
import org.springframework.stereotype.Controller;
import java.text.*;
@Controller
public class messcontroller
{
    @Autowired
    mess_reg_dao mess_reg_dao;
    
    @Autowired
    food_dao food_dao;
    
    @Autowired
    reg_dao regdao;
    
    @RequestMapping(value = { "messregistration.html" }, method = { RequestMethod.GET })
    public ModelAndView messregistration(@ModelAttribute final mess_reg_vo mess_reg_vo, final HttpServletRequest request) {
        final String password = mess_reg_vo.getPassword();
        final String confirmpassword = mess_reg_vo.getConfirmpassword();
        if (password.equals(confirmpassword)) {
            this.mess_reg_dao.insert(mess_reg_vo);
            return new ModelAndView("general/mess_upload_photo");
        }
        final HttpSession s3 = request.getSession();
        s3.setAttribute("alert","messregcheck");
        return new ModelAndView("general/alert");
    }
    
    @RequestMapping(value = { "messhome.html" }, method = { RequestMethod.GET })
    public ModelAndView messhome() {System.out.print("gff");
	List list=food_dao.collectmessdata();
	System.out.println("messsss"+list);
        return new ModelAndView("mess/homepage","list",list);
    }
    
    @RequestMapping(value = { "todaylunch.html" }, method = { RequestMethod.GET })
    public ModelAndView todaylunch() {
        return new ModelAndView("mess/today_lunch", "food_lunch", (Object)new food_lunch());
    }
    
    @RequestMapping(value = { "todaydinner.html" }, method = { RequestMethod.GET })
    public ModelAndView todaydinner() {
        return new ModelAndView("mess/today_dinner", "food_dinner", (Object)new food_dinner());
    }
    
    @RequestMapping(value = { "foodlunch.html" }, method = { RequestMethod.GET })
    public ModelAndView foodlunch(@ModelAttribute final food_lunch food_lunch,HttpServletRequest request) throws Exception {
    
        String date=food_lunch.getDate();
        List list=food_dao.checkdate(date);
       
        if(list.isEmpty())
        {
        	System.out.println("mnaaka");
        	  coupon_count obj=new coupon_count();
              obj.setLunchmenu(food_lunch.getLunchmenu());
              obj.setDate(food_lunch.getDate());
              obj.setLunchprice(food_lunch.getLunchprice());
              food_dao.setcouponlunch(obj);
              
              HttpSession s3 = request.getSession();
              s3.setAttribute("alert", "setfoodlunch");
              return new ModelAndView("general/alert");
        	
        }
        else
        {
        	food_dao.updatecouponlunch(food_lunch.getDate(),food_lunch.getLunchmenu(),food_lunch.getLunchprice());
        	HttpSession s3 = request.getSession();
             s3.setAttribute("alert", "updatefoodlunch");
             return new ModelAndView("general/alert");
        }
      
       
    }
    
    @RequestMapping(value = { "fooddinner.html" }, method = { RequestMethod.GET })
    public ModelAndView fooddinner(@ModelAttribute final food_dinner food_dinner,HttpServletRequest request) throws Exception {
   
    	
    	String date=food_dinner.getDate();
    	List list=food_dao.checkdate(date);
    	
        if(list.isEmpty())
        {	
        	
        	 coupon_count obj=new coupon_count();
             obj.setDinnermenu(food_dinner.getDinnermenu());
             obj.setDinnerprice(food_dinner.getDinnerprice());
             obj.setDate(food_dinner.getDate());
             food_dao.setcoupondinner(obj);
             
             HttpSession s3 = request.getSession();
             s3.setAttribute("alert", "setfooddinner");
             return new ModelAndView("general/alert");
             
        }
        else
        {
        	food_dao.updatecoupondinner(food_dinner.getDate(),food_dinner.getDinnermenu(),food_dinner.getDinnerprice());
        
        	HttpSession s3 = request.getSession();
            s3.setAttribute("alert", "updatefooddinner");
            return new ModelAndView("general/alert");
        }            
}
    
    
    @RequestMapping(value = { "message.html" }, method = { RequestMethod.GET })
    public ModelAndView message() {
        return new ModelAndView("mess/message");
    }
    @RequestMapping(value = { "message1.html" }, method = { RequestMethod.GET })
    public ModelAndView message1(HttpServletRequest request) {	
    	
    	String subject=request.getParameter("subject");
    	String body=request.getParameter("message");
    	List l=food_dao.collectemailid();
    	
		
		Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class",    
                  "javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.port", "465");    
        //get Session   
        Session session = Session.getDefaultInstance(props,    
         new javax.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication("rgp7714@gmail.com","raj@1234");  
         }    
        });    
        //compose message    
        try {    
        	
        	for(int i=0;i<l.size();i++)
        	{
		         MimeMessage message = new MimeMessage(session);    
		         message.addRecipient(Message.RecipientType.TO,new InternetAddress((String) l.get(i)));    
		         message.setSubject(subject);    
		         message.setText(body);    
		         //send message  
		         Transport.send(message);    
		         System.out.println("message sent successfully to "+l.get(i)); 
        	}
        } catch (MessagingException e) {throw new RuntimeException(e);}
        
        return new ModelAndView("mess/homepage");
    }
    
    @RequestMapping(value = { "todayfoodcoupons.html" }, method = { RequestMethod.GET })
    public ModelAndView todayfoodcoupons() {
    	
    	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
    	String d=f.format(new Date());
    	List l=food_dao.collecttodaycoupondata(d);
    	
        return new ModelAndView("mess/today_coupons","list",l);
    }
}