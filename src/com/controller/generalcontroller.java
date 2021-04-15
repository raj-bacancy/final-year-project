package com.controller;

import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.dao.*;
import com.vo.*;

@Controller
public class generalcontroller {

	@Autowired
	reg_dao regdao;
	
	@Autowired
	mess_reg_dao mess_reg_dao;
	
   @Autowired
   food_coupon_dao food_coupon_dao;
   
   @Autowired
   fee_receipt_dao fee_receipt_dao;
	    
   
	
	
	@RequestMapping(value = "login.html", method = RequestMethod.GET)
	public ModelAndView login() {
		System.out.println("Log In");
		return new ModelAndView("general/login", "login_vo", new login_vo());
	}

	@RequestMapping(value = "signup.html", method = RequestMethod.GET)
	public ModelAndView signup(@ModelAttribute role_vo role_vo,HttpServletRequest request) {
		
		String role=role_vo.getRole();
		if(role.equals("mess"))
		{
			String check_acc=mess_reg_dao.checkaccount();
			if(check_acc.equals("created")){
				HttpSession s3 	=request.getSession();
				s3.setAttribute("alert", "account already created");
				return new ModelAndView("general/alert");
			}
			return new ModelAndView("mess/mess_signup","mess_reg_vo",new mess_reg_vo());
		}
		else if(role.equals("owner"))
		{
			String check_acc=regdao.checkaccount();
			if(check_acc.equals("created")){
				HttpSession s3 	=request.getSession();
				s3.setAttribute("alert", "account already created");
				return new ModelAndView("general/alert");
			}
			return new ModelAndView("general/signup","reg_vo",new reg_vo());
		}
		
		return null;
	}

	@RequestMapping(value="main_reg.html",method=RequestMethod.GET)
	public ModelAndView main_reg(@ModelAttribute reg_vo vo,HttpServletRequest request)
	{
		String s1=vo.getPassword();
		String s2=vo.getConfirmpassword();
		
		if(s1.equals(s2))
		{
			try {
				regdao.reg_insert(vo);
				return new ModelAndView("redirect:loadlogin.html");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			HttpSession s3 	=request.getSession();
			s3.setAttribute("alert", "regcheck");
			return new ModelAndView("general/alert");
		}
		return null;
	}
	
	@RequestMapping(value="loadlogin.html",method=RequestMethod.GET)
	public ModelAndView loadlogin()
	{
		return new ModelAndView("general/login","login_vo",new login_vo());
	}
	
	@RequestMapping(value="loginalert.html",method=RequestMethod.GET)
	public ModelAndView  loginalert()
	{
		
		return new ModelAndView("general/login","login_vo",new login_vo());
	}
	
	@RequestMapping(value="signupalert.html",method=RequestMethod.GET)
	public ModelAndView  signupalert()
	{
		
		return new ModelAndView("general/signup","reg_vo",new reg_vo());
	}
	
	@RequestMapping(value="forgetpassword.html",method=RequestMethod.GET)
	public ModelAndView forgetpassword()
	{
		return new ModelAndView("general/selectrole_password");
	}
	
	@RequestMapping(value="otp.html",method=RequestMethod.GET)
	public ModelAndView otp(HttpServletRequest request)
	{
		String role=request.getParameter("role");
		Random rand = new Random();
		int otp = rand.nextInt((9999 - 100) + 1) + 10;
		HttpSession session1=request.getSession();
		session1.setAttribute("otp", otp);
		
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
		if(role.equals("owner"))
		{
			String emailid=regdao.getownermail();
	        //compose message    
	        try {    
	         MimeMessage message = new MimeMessage(session);    
	         message.addRecipient(Message.RecipientType.TO,new InternetAddress(emailid));    
	         message.setSubject("Verification Of User");    
	         message.setText("Hey Owner Your OTP is : "+otp);    
	         //send message  
	         Transport.send(message);    
	         System.out.println("message sent successfully to "+emailid);    
	        } catch (MessagingException e) {throw new RuntimeException(e);}
	        return new ModelAndView("general/get_owner_otp");
			
		}
		else if(role.equals("mess"))
		{
			String emailid=regdao.getmessmail();
	        //compose message    
	        try {    
	         MimeMessage message = new MimeMessage(session);    
	         message.addRecipient(Message.RecipientType.TO,new InternetAddress(emailid));    
	         message.setSubject("Verification Of User");    
	         message.setText("Hey Mess Your OTP is : "+otp);    
	         //send message  
	         Transport.send(message);    
	         System.out.println("message sent successfully to "+emailid);    
	        } catch (MessagingException e) {throw new RuntimeException(e);}
	        return new ModelAndView("general/get_mess_otp");
		}
		else if(role.equals("student"))
		{
			return new ModelAndView("general/get_hostelid");
		}
		return null;	
		
	}
	
	@RequestMapping(value = "get_student_emailid.html", method = RequestMethod.GET)
	public ModelAndView get_student_emailid(HttpServletRequest request) {
		String hostelid=request.getParameter("hostelid");
		String emailid=regdao.getstudentmail(hostelid);
		if(emailid.equals("not generated"))
		{
			HttpSession session=request.getSession();
			session.setAttribute("alert", "generate_hostelid_first");
			return new ModelAndView("general/alert");
		}
		else
		{
			Random rand = new Random();
			int otp = rand.nextInt((9999 - 100) + 1) + 10;
			HttpSession session1=request.getSession();
			session1.setAttribute("otp", otp);
			
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
	        try {    
	        	
		         MimeMessage message = new MimeMessage(session);    
		         message.addRecipient(Message.RecipientType.TO,new InternetAddress(emailid));    
		         message.setSubject("Verification Of User");    
		         message.setText("Hey "+hostelid+" Your OTP is : "+otp);    
		         //send message  
		         Transport.send(message);    
		         System.out.println("message sent successfully to "+emailid);    
		        } catch (MessagingException e) {throw new RuntimeException(e);}
		    
	        session1.setAttribute("HOSTELID", hostelid);
	        
			return new ModelAndView("general/get_student_otp");
		}
	}
	
	@RequestMapping(value = "loadgetownerotp.html", method = RequestMethod.GET)
	public ModelAndView loadgetownerotp() {
		return new ModelAndView("general/get_owner_otp");
	}
	
	@RequestMapping(value = "loadsetownernewpassword.html", method = RequestMethod.GET)
	public ModelAndView loadsetownernewpassword() {
		return new ModelAndView("general/set_owner_new_password");
	}
	
	@RequestMapping(value = "loadgetmessotp.html", method = RequestMethod.GET)
	public ModelAndView loadgetmessotp() {
		return new ModelAndView("general/get_owner_otp");
	}
	
	@RequestMapping(value = "loadsetmessnewpassword.html", method = RequestMethod.GET)
	public ModelAndView loadsetmessnewpassword() {
		return new ModelAndView("general/set_owner_new_password");
	}
	
	@RequestMapping(value = "loadgetstudentotp.html", method = RequestMethod.GET)
	public ModelAndView loadgetstudentotp() {
		return new ModelAndView("general/get_student_otp");
	}
	
	@RequestMapping(value = "loadsetstudentnewpassword.html", method = RequestMethod.GET)
	public ModelAndView loadsetstudentnewpassword() {
		return new ModelAndView("general/set_student_new_password");
	}
	
	@RequestMapping(value="checkownerotp.html",method=RequestMethod.GET)
	public ModelAndView checkownerotp(HttpServletRequest request)
	{
		String otp_s=request.getParameter("otp");
		int otp_f=Integer.parseInt(otp_s);
		HttpSession session=request.getSession();
		int otp=(Integer)session.getAttribute("otp");
		if(otp_f==otp)
		{
			return new ModelAndView("general/set_owner_new_password");
		}
		else
		{
			session.setAttribute("alert", "Owner Wrong OTP");
			return new ModelAndView("general/alert");
		}
		
	}
	
	@RequestMapping(value="checkmessotp.html",method=RequestMethod.GET)
	public ModelAndView checkmessotp(HttpServletRequest request)
	{
		String otp_s=request.getParameter("otp");
		int otp_f=Integer.parseInt(otp_s);
		HttpSession session=request.getSession();
		int otp=(Integer)session.getAttribute("otp");
		if(otp_f==otp)
		{
			return new ModelAndView("general/set_mess_new_password");
		}
		else
		{
			session.setAttribute("alert", "Mess Wrong OTP");
			return new ModelAndView("general/alert");
		}
		
	}

	@RequestMapping(value = "checkownerpassword.html", method = RequestMethod.GET)
	public ModelAndView chekcownerpassword(HttpServletRequest request) {
		String newpassword=request.getParameter("newpassword");
		String confirmpassword=request.getParameter("confirmpassword");
		
		if(newpassword.equals(confirmpassword))
		{
			regdao.updateownerpassword(newpassword);
			return new ModelAndView("redirect:loadlogin.html");
		}
		else
		{
			HttpSession session=request.getSession();
			session.setAttribute("alert", "Owner password missmatch");
			return new ModelAndView("general/alert");
		}
		
	}
	
	@RequestMapping(value = "checkmesspassword.html", method = RequestMethod.GET)
	public ModelAndView chekcmesspassword(HttpServletRequest request) {
		String newpassword=request.getParameter("newpassword");
		String confirmpassword=request.getParameter("confirmpassword");
		
		if(newpassword.equals(confirmpassword))
		{
			regdao.updatemesspassword(newpassword);
			return new ModelAndView("redirect:loadlogin.html");
		}
		else
		{
			HttpSession session=request.getSession();
			session.setAttribute("alert", "Mess password missmatch");
			return new ModelAndView("general/alert");
		}
		
	}
	
	@RequestMapping(value="checkstudentotp.html",method=RequestMethod.GET)
	public ModelAndView checkstudentotp(HttpServletRequest request)
	{
		String otp_s=request.getParameter("otp");
		int otp_f=Integer.parseInt(otp_s);
		HttpSession session=request.getSession();
		int otp=(Integer)session.getAttribute("otp");
		if(otp_f==otp)
		{
			return new ModelAndView("general/set_student_new_password");
		}
		else
		{
			session.setAttribute("alert", "Student Wrong OTP");
			return new ModelAndView("general/alert");
		}
		
	}
	
	@RequestMapping(value = "checkstudentpassword.html", method = RequestMethod.GET)
	public ModelAndView chekcstudentpassword(HttpServletRequest request) {
		String newpassword=request.getParameter("newpassword");
		String confirmpassword=request.getParameter("confirmpassword");
		HttpSession session=request.getSession();
		String hostelid=(String)session.getAttribute("HOSTELID");
		System.out.println("checkstudentpassword "+hostelid);
		if(newpassword.equals(confirmpassword))
		{
			System.out.println("password matched");
			regdao.updatestudentpassword(newpassword,hostelid);
			return new ModelAndView("redirect:loadlogin.html");
		}
		else
		{
			HttpSession session1=request.getSession();
			session1.setAttribute("alert", "Student password missmatch");
			return new ModelAndView("general/alert");
		}
		
	}	
	
	@RequestMapping(value = "selectrole.html", method = RequestMethod.GET)
	public ModelAndView selectrole() {
		System.out.println("Select Your Role");
		return new ModelAndView("general/selectrole", "role_vo", new role_vo());
	}
	
	@RequestMapping(value = "loaduniqueid.html", method = RequestMethod.GET)
	public ModelAndView loaduniqueid() {
		return new ModelAndView("general/student_upload_uniqueid");
	}
	
}
