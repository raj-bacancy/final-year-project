package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.dao.*;
import com.vo.*;

@Controller
public class ownercontroller {
	int rowid;
	
	@Autowired
	reg_dao regdao;
	
	@Autowired
	fee_receipt_dao fee_receipt_dao;
	
	@Autowired
	generatehostelid_dao generate_hostelid;
	
	@Autowired
	food_coupon_dao food_coupon_dao;
	
	@Autowired
	leave_application_dao leave_application_dao;
	
	@Autowired
	guest_stay_dao guest_stay_dao;
	
	@Autowired
	add_room_dao add_room_dao;
	
	@Autowired
	student_dashboard_dao student_dashboard;
	
	@Autowired
	complain_dao complain_dao;
	
	@Autowired
	food_dao food_dao;
	
	@Autowired
	mess_reg_dao mess_reg_dao;
	
	@Autowired
	attendance_dao attendance_dao;
	
	String us1="";
	String ps1="";
	
	@RequestMapping(value="studenthome.html",method=RequestMethod.GET)
	public ModelAndView studenthome(HttpServletRequest request)
	{
		String status=generate_hostelid.checkstudent(us1,ps1);
		if(status.equals("Not Generated"))
		{
			HttpSession s1 	=request.getSession();
			s1.setAttribute("alert", "generate_hostelid_first");
			return new ModelAndView("general/alert");
		}
		else if(status.equals("Wrong Info"))
		{
			HttpSession s1 	=request.getSession();
			s1.setAttribute("alert", "invalid_password");
			return new ModelAndView("general/alert");
		}
		else if(status.equals("Not registered"))
		{
			int roomno=generate_hostelid.getroomno(us1);
			HttpSession session=request.getSession();
			session.setAttribute("hostel_id", us1);
			session.setAttribute("roomno",roomno);
			return new ModelAndView("general/student_reg","student_reg",new student_reg());
		}
		else if(status.equals("Correct Student"))
		{
			ModelAndView mv=new ModelAndView();
			HttpSession session=request.getSession();
			session.setAttribute("hostel_id", us1);
			
			List name=student_dashboard.getstudent(us1);
			student_reg ob=(student_reg)name.get(0);
			String studentname=ob.getFirstname();
			int roomno=ob.getRoomno();
			mv.addObject("firstname", studentname);
			mv.addObject("roomno", roomno);
							
			List room=student_dashboard.getroom(roomno);
			mv.addObject("room", room);
			
			int no_of_room=student_dashboard.getnoofroom();
			mv.addObject("noofroom", no_of_room);
			
			int no_of_student_room=student_dashboard.getnoofstudentroom();
			mv.addObject("noofstudentroom", no_of_student_room);
			
			int no_of_guest_room=student_dashboard.getnoofguestroom();
			mv.addObject("noofguestroom", no_of_guest_room);
			
			int capacity[]=student_dashboard.getcapacity();
			mv.addObject("totalcapacity", capacity[0]);
			mv.addObject("totalmamber", capacity[1]);
			mv.addObject("vacancy", capacity[2]);
			
			mv.setViewName("student/student_dashboard");
			return mv;
		}
		return null;
	}
	
	
	@RequestMapping(value ="dashboard.html", method = RequestMethod.POST)
	public ModelAndView dashboard(@ModelAttribute login_vo log,HttpServletRequest request) {
		us1 = log.getUsername();
		ps1 = log.getPassword();
		String p1=log.getPerson();	
		System.out.println("dashboard"+p1);
		if(p1.equals("owner"))
		{
			List l1=regdao.logincheck(us1, ps1);
			if (!l1.isEmpty()) 
			{
				List list=food_dao.collectownerdata();
				ModelAndView mv=new ModelAndView();
				HttpSession session=request.getSession();
				session.setAttribute("hostel_id", us1);
				
				int no_of_room=student_dashboard.getnoofroom();
				mv.addObject("noofroom", no_of_room);
				
				int no_of_student_room=student_dashboard.getnoofstudentroom();
				mv.addObject("noofstudentroom", no_of_student_room);
				
				int no_of_guest_room=student_dashboard.getnoofguestroom();
				mv.addObject("noofguestroom", no_of_guest_room);
				
				int capacity[]=student_dashboard.getcapacity();
				mv.addObject("totalcapacity", capacity[0]);
				mv.addObject("totalmamber", capacity[1]);
				mv.addObject("vacancy", capacity[2]);
				mv.addObject("list", list);
				
				mv.setViewName("owner/home");
				return mv;
			
			}
			else
			{
				HttpSession s1 	=request.getSession();
				s1.setAttribute("alert", "logincheck");
				return new ModelAndView("general/alert");
			}
		}
		else if(p1.equals("student"))
		{
			String status=generate_hostelid.checkstudent(us1,ps1);
			if(status.equals("Not Generated"))
			{
				HttpSession s1 	=request.getSession();
				s1.setAttribute("alert", "generate_hostelid_first");
				return new ModelAndView("general/alert");
			}
			else if(status.equals("Wrong Info"))
			{
				HttpSession s1 	=request.getSession();
				s1.setAttribute("alert", "invalid_password");
				return new ModelAndView("general/alert");
			}
			else if(status.equals("Not registered"))
			{
				int roomno=generate_hostelid.getroomno(us1);
				HttpSession session=request.getSession();
				session.setAttribute("hostel_id", us1);
				session.setAttribute("roomno",roomno);
				return new ModelAndView("general/student_reg","student_reg",new student_reg());
			}
			else if(status.equals("Correct Student"))
			{
				ModelAndView mv=new ModelAndView();
				HttpSession session=request.getSession();
				session.setAttribute("hostel_id", us1);
				
				List name=student_dashboard.getstudent(us1);
				student_reg ob=(student_reg)name.get(0);
				String studentname=ob.getFirstname();
				int roomno=ob.getRoomno();
				mv.addObject("firstname", studentname);
				mv.addObject("roomno", roomno);
								
				List room=student_dashboard.getroom(roomno);
				mv.addObject("room", room);
				
				int no_of_room=student_dashboard.getnoofroom();
				mv.addObject("noofroom", no_of_room);
				
				int no_of_student_room=student_dashboard.getnoofstudentroom();
				mv.addObject("noofstudentroom", no_of_student_room);
				
				int no_of_guest_room=student_dashboard.getnoofguestroom();
				mv.addObject("noofguestroom", no_of_guest_room);
				
				int capacity[]=student_dashboard.getcapacity();
				mv.addObject("totalcapacity", capacity[0]);
				mv.addObject("totalmamber", capacity[1]);
				mv.addObject("vacancy", capacity[2]);
				
				mv.setViewName("student/student_dashboard");
				return mv;
			}
		}
		else 
		{
			System.out.println("Mess");
			List l1 = this.mess_reg_dao.logincheck(us1, ps1);
            if (!l1.isEmpty()) {
            	System.out.print("gff");
            	List list=food_dao.collectmessdata();
            	System.out.println("messsss"+list);
                return new ModelAndView("mess/homepage","list",list);
            }
            else
            {
            	HttpSession s1 = request.getSession();
	            s1.setAttribute("alert","messlogin");
	            return new ModelAndView("general/alert");
            }
		}
			return null;
	}
	
	@RequestMapping(value="ownerhome.html",method=RequestMethod.GET)
	public ModelAndView ownerhome(HttpServletRequest request	)
	{
		List list=food_dao.collectownerdata();
		ModelAndView mv=new ModelAndView();
		HttpSession session=request.getSession();
		session.setAttribute("hostel_id", us1);
		
		int no_of_room=student_dashboard.getnoofroom();
		mv.addObject("noofroom", no_of_room);
		
		int no_of_student_room=student_dashboard.getnoofstudentroom();
		mv.addObject("noofstudentroom", no_of_student_room);
		
		int no_of_guest_room=student_dashboard.getnoofguestroom();
		mv.addObject("noofguestroom", no_of_guest_room);
		
		int capacity[]=student_dashboard.getcapacity();
		mv.addObject("totalcapacity", capacity[0]);
		mv.addObject("totalmamber", capacity[1]);
		mv.addObject("vacancy", capacity[2]);
		mv.addObject("list", list);
		
		mv.setViewName("owner/home");
		return mv;
	}
	
	@RequestMapping(value="loadstudentdashboard.html",method=RequestMethod.GET)
	public ModelAndView loadstudentdashboard()
	{
		return new ModelAndView("student/student_dashboard");
	}
	
	@RequestMapping(value="loadgeneratehostelid.html",method=RequestMethod.GET)
	public ModelAndView loadgeneratehostelid(@ModelAttribute generate_hostelid_vo generate_hostelid_vo)
	{
		ModelAndView mv=new ModelAndView();
		/*String nexthostelid=generate_hostelid.getnexthostelid();
		int substring=Integer.parseInt(nexthostelid.substring(1));
		substring=substring+1;
		nexthostelid="H"+substring;
		mv.addObject("nexthostelid", nexthostelid);*/
		mv.addObject("generate_hostelid_vo", new generate_hostelid_vo());
		mv.setViewName("owner/generate_hostel_id");
		return mv;
	}
	
	@RequestMapping(value="generatehostelid.html",method=RequestMethod.GET)
	public ModelAndView generatehostelid(@ModelAttribute generate_hostelid_vo generate_hostelid_vo,HttpServletRequest request)
	{
		String checkroom=generate_hostelid.insert(generate_hostelid_vo);
		if(checkroom.equals("no room"))
		{
			HttpSession s1 	=request.getSession();
			s1.setAttribute("alert", "room is not there");
			return new ModelAndView("general/alert");
		}
		else if(checkroom.equals("room full"))
		{
			HttpSession s1 	=request.getSession();
			s1.setAttribute("alert", "room full");
			return new ModelAndView("general/alert");
		}
		else if(checkroom.equals("error"))
		{
			HttpSession s1 	=request.getSession();
			s1.setAttribute("alert", "error");
			return new ModelAndView("general/alert");
		}
		else
		{
			HttpSession s1 	=request.getSession();
			s1.setAttribute("alert", "successfully generated");
			return new ModelAndView("general/alert");
		}
	}
	
	@RequestMapping(value="requests.html",method=RequestMethod.GET)
	public ModelAndView requests()
	{
		ModelAndView mv=new ModelAndView();
		int no_of_foodcoupon=0,no_of_leave=0,no_of_fee=0,no_of_gueststay=0;
		no_of_leave=leave_application_dao.getnoofrequests();
		no_of_fee=fee_receipt_dao.getnoofrequests();
		no_of_gueststay=guest_stay_dao.getnoofrequests();
		no_of_foodcoupon=food_coupon_dao.getnoofrequests();
		mv.addObject("no_of_leave", no_of_leave);
		mv.addObject("no_of_fee", no_of_fee);
		mv.addObject("no_of_foodcoupon", no_of_foodcoupon);
		mv.addObject("no_of_gueststay", no_of_gueststay);
		mv.setViewName("owner/requests");
		return mv;
	}
	
	@RequestMapping(value="foodcouponowner.html",method=RequestMethod.GET)
	public ModelAndView foodcouponowner(HttpServletRequest request) throws Exception
	{
		String starts=request.getParameter("start");	
		int start=Integer.parseInt(starts);
		List ll=food_coupon_dao.collect_datas(start);
		if(start!=0)
		{
			start=start+5;
			HttpSession session=request.getSession();
			session.setAttribute("startpoint", start);
		}
		else
		{
			HttpSession session=request.getSession();
			session.setAttribute("startpoint", 5);
		}
		return new ModelAndView("owner/food_coupon_details","list1",ll);
	}
	
	 @RequestMapping(value ="approve.html", method = RequestMethod.GET)
	    public ModelAndView approve(@ModelAttribute final food_coupon food1, @RequestParam final int id,@RequestParam String date,@RequestParam String foodtime,@RequestParam  int nooffoodcoupon) throws Exception {
	        food1.setId(id);
	        food1.setStatus("approved");
	        this.food_coupon_dao.updatestatus(food1);
	        if(foodtime.equals("lunch"))
	        {
	        	List lunch=food_dao.getlunchcoupon(date);
	        	coupon_count obj1=(coupon_count)lunch.get(0);
	        	int a=obj1.getLunch();
	        	a+=nooffoodcoupon;
	        	food_dao.setlunchcoupon(date,a);
	        }
	        else if(foodtime.equals("dinner"))
	        {
	        	List dinner=food_dao.getdinnercoupon(date);
	        	coupon_count obj1=(coupon_count)dinner.get(0);
	        	int a=obj1.getDinner();
	        	a+=nooffoodcoupon;
	        	food_dao.setdinnercoupon(date,a);
	        }
	       else if(foodtime.equals("both"))
	        {
	        	List lunch=food_dao.getlunchcoupon(date);
	        	List dinner=food_dao.getdinnercoupon(date);
	        	coupon_count obj1=(coupon_count)lunch.get(0);
	        	int a=obj1.getLunch();
	        	a+=nooffoodcoupon;
	        	food_dao.setlunchcoupon(date,a);
	        	
	        	
	        	coupon_count obj2=(coupon_count)dinner.get(0);
	        	int a1=obj2.getDinner();
	        	a1+=nooffoodcoupon;
	        	food_dao.setdinnercoupon(date,a1);
	        }
	        return new ModelAndView("redirect:foodcouponowner.html?start=0");
	    }
	    
	    @RequestMapping(value = "reject.html", method =RequestMethod.GET)
	    public ModelAndView reject(@ModelAttribute food_coupon food2, @RequestParam int id) {
	        food2.setId(id);
	        food2.setStatus("rejected");
	        food_coupon_dao.updatestatus(food2);
	        return new ModelAndView("redirect:foodcouponowner.html?start=0");
	    }
	
	@RequestMapping(value="leaverequestowner.html",method=RequestMethod.GET)
	public ModelAndView leaverequestowner(HttpServletRequest request) throws Exception
	{
		String starts=request.getParameter("start");	
		int start=Integer.parseInt(starts);
		
		List ll=leave_application_dao.featallchdata(start);
		if(start!=0)
		{
			start=start+5;
			HttpSession session=request.getSession();
			session.setAttribute("startpoint", start);
		}
		else
		{
			HttpSession session=request.getSession();
			session.setAttribute("startpoint", 5);
		}
		return new ModelAndView("owner/leave_request_details","list1",ll);
	}
	
	@RequestMapping(value="approveleave.html",method=RequestMethod.GET)
	public ModelAndView approveleave(@ModelAttribute leave_application leave_application,@RequestParam int id,HttpServletRequest request) 
	{
		leave_application.setId(id);
		leave_application.setStatus("approved");
		leave_application_dao.updatestatus(leave_application);
		
		leave_application leaveapplication=leave_application_dao.getleaveapplication(id);
		List student=student_dashboard.getstudent(leaveapplication.getHostelid());
		System.out.println("HostelID = "+student.get(0));
		student_reg ob=(student_reg)student.get(0);
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
        		
		         MimeMessage message = new MimeMessage(session);    
		         message.addRecipient(Message.RecipientType.TO,new InternetAddress(ob.getFatheremailid()));    
		         message.setSubject("Leave Application");    
		         message.setText(leaveapplication.getReason());    
		         //send message  
		         Transport.send(message);    
		         System.out.println("message sent successfully to "+ob.getFatheremailid()); 
        	
        } catch (Exception e) {System.out.println("ERROR!!!"+e);}
        
		return new ModelAndView("redirect:leaverequestowner.html?start=0");
	}
	
	@RequestMapping(value="rejectleave.html",method=RequestMethod.GET)
	public ModelAndView rejectleave(@ModelAttribute leave_application leave_application,@RequestParam int id)
	{
		leave_application.setId(id);
		leave_application.setStatus("rejected");
		leave_application_dao.updatestatus(leave_application);
		return new ModelAndView("redirect:leaverequestowner.html?start=0");
	}
	
	@RequestMapping(value="gueststayowner.html",method=RequestMethod.GET)
	public ModelAndView gueststayowner(HttpServletRequest request)
	{
		String starts=request.getParameter("start");	
		int start=Integer.parseInt(starts);
		
		List ll=guest_stay_dao.featallchdata(start);
		if(start!=0)
		{
			start=start+5;
			HttpSession session=request.getSession();
			session.setAttribute("startpoint", start);
		}
		else
		{
			HttpSession session=request.getSession();
			session.setAttribute("startpoint", 5);
		}
		
		return new ModelAndView("owner/guest_stay_details","list1",ll);
	}
	
	@RequestMapping(value="approvegueststay.html",method=RequestMethod.GET)
	public ModelAndView approvegueststay(@ModelAttribute guest_stay_vo guest_stay_vo,HttpServletRequest request,@RequestParam int roomno,@RequestParam int currentmember,@RequestParam int capacity) 
	{
		int vacancy=capacity-currentmember;
		guest_stay_vo.setAllocatedroom(roomno);
		guest_stay_vo.setId(rowid);
		guest_stay_vo.setStatus("approved");
		String s=guest_stay_dao.updatestatus(guest_stay_vo,vacancy);
		if(s.equals("overflow"))
		{
			HttpSession s1 	=request.getSession();
			s1.setAttribute("alert", "overflow");
			return new ModelAndView("general/alert");
		}
		else
		{
			HttpSession s1 	=request.getSession();
			s1.setAttribute("alert", "allocated");
			return new ModelAndView("general/alert");
		}
	}
	
	@RequestMapping(value="rejectgueststay.html",method=RequestMethod.GET)
	public ModelAndView rejectgueststay(@ModelAttribute guest_stay_vo guest_stay_vo,@RequestParam int id)
	{
		guest_stay_vo.setId(id);
		guest_stay_vo.setStatus("rejected");
		guest_stay_dao.rejectgueststay(guest_stay_vo);
		return new ModelAndView("redirect:gueststayowner.html?start=0");
	}
	
	@RequestMapping(value="loadroommanagement.html",method=RequestMethod.GET)
	public ModelAndView loadroommanagement()
	{
		return new ModelAndView("owner/room_management");
	}
	
	@RequestMapping(value="addroom.html",method=RequestMethod.GET)
	public ModelAndView addroom()
	{
		return new ModelAndView("owner/add_room","add_room_vo",new add_room_vo());
	}
	
	@RequestMapping(value="insertroomdata.html",method=RequestMethod.POST)
	public ModelAndView insertroomdata(@ModelAttribute add_room_vo add_room_vo,HttpServletRequest request)
	{
		boolean flag=add_room_dao.insert(add_room_vo);
		if(!flag){
			HttpSession s1 	=request.getSession();
			s1.setAttribute("alert", "room already exist");
			return new ModelAndView("general/alert");
			
		}else{
			HttpSession s1 	=request.getSession();
			s1.setAttribute("alert", "room added succesfully");
			return new ModelAndView("general/alert");
		}
		
	}
	
	@RequestMapping(value="loadremoveroom.html",method=RequestMethod.GET)
	public ModelAndView loadremoveroom()
	{
		return new ModelAndView("owner/remove_room","add_room_vo",new add_room_vo());
	}
	
	@RequestMapping(value="removeroom.html",method=RequestMethod.GET)
	public ModelAndView removeroom(@ModelAttribute add_room_vo add_room_vo,HttpServletRequest request)
	{
		
		int roomno=add_room_vo.getRoomno();
		String status=add_room_dao.removeroom(add_room_vo);
		if(status.equals("can't remove"))
		{
			HttpSession s1 	=request.getSession();
			s1.setAttribute("alert", "can not remove");
			return new ModelAndView("general/alert");
		}
		else
		{
			generate_hostelid_vo generate_hostelid_vo=new generate_hostelid_vo();
			generate_hostelid_vo.setRoomno(roomno);
			generate_hostelid.removeroom(generate_hostelid_vo);
			
			student_reg student_reg=new student_reg();
			student_reg.setRoomno(roomno);
			regdao.removeroom(student_reg);
			HttpSession s1 	=request.getSession();
			s1.setAttribute("alert", "removed");
			return new ModelAndView("general/alert");
		}
		
	}
	
	@RequestMapping(value="roominformation.html",method=RequestMethod.GET)
	public ModelAndView roominformation()
	{
		List l=add_room_dao.getrooms();
		return new ModelAndView("owner/room_information","list",l);
	}
	

	@RequestMapping(value="viewroom.html",method=RequestMethod.GET)
	public ModelAndView viewroom(@RequestParam int roomno)
	{
		List l=add_room_dao.getstudents(roomno);
		return new ModelAndView("owner/view_room","list",l);
	}
	
	@RequestMapping(value="checkguestroomavailability.html",method=RequestMethod.GET)
	public ModelAndView checkguestroomavailability(@RequestParam String speciality,@RequestParam int id,@RequestParam int noofguest)
	{	
		rowid=id;
		List l=guest_stay_dao.getguestroom(id,speciality,noofguest);
		return new ModelAndView("owner/view_guest_room","list",l);
	}
	
	
	
	@RequestMapping(value="viewprofile.html",method=RequestMethod.GET)
	public ModelAndView viewprofile(@RequestParam String hostelid)
	{	
		ModelAndView mv=new ModelAndView();
		mv.addObject("hostelid", hostelid);
		
		List list=regdao.collect_student_info(hostelid);
		mv.addObject("list", list);
		mv.setViewName("owner/viewprofile");
		return mv;
	}
	
	@RequestMapping(value="loadanalysis.html",method=RequestMethod.GET)
	public ModelAndView loadanalysis()
	{
		return new ModelAndView("owner/analysis");
	}
	
	@RequestMapping(value="filter_food_analysis.html",method=RequestMethod.GET)
	public ModelAndView filter_food_analysis(HttpServletRequest request)
	{
		String filter=request.getParameter("filter");
		System.out.println("Filter Applied = ");
		List<coupon_count> menu_count = null;
		if(filter.equals("Last-7-days")){
			System.out.println("Last-7-days");
			menu_count=food_coupon_dao.getMenuCount();
		}else if(filter.equals("Max-7-days")){
			System.out.println("Last-7-days");
			menu_count=food_coupon_dao.getMexMenuCount();
		}
		System.out.println("menu_count = "+menu_count);
    	return new ModelAndView("owner/food_coupon_graph","menu_count",menu_count);
	}
	
	@RequestMapping(value="analysis.html",method=RequestMethod.GET)
	public ModelAndView analysis(HttpServletRequest request)
	{
		String value=request.getParameter("option");
		if(value.equals("leave"))
		{
			List l=leave_application_dao.getapplication();
			return new ModelAndView("owner/analysis_leave","list",l);
		}
		else if(value.equals("gueststay"))
		{
			List l=guest_stay_dao.getapplication();
			return new ModelAndView("owner/analysis_guest_stay","list",l);
		}
		else if(value.equals("food"))
		{
			List l=food_dao.collectcouponalldata();
			return new ModelAndView("owner/food_analysis","list",l);
		}
		else if(value.equals("fee-paid"))
		{
			Date d=new Date();
			int year=d.getYear();
			List l=fee_receipt_dao.collectpaidfeealldata(year);
			return new ModelAndView("owner/fee_paid_analysis","list",l);
		}
		else if(value.equals("fee-unpaid"))
		{
			int year = Calendar.getInstance().get(Calendar.YEAR);
			List l=fee_receipt_dao.collectunpaidfeealldata(year);
			return new ModelAndView("owner/fee_unpaid_analysis","list",l);
		}
		
		return null;
	}
	
	@RequestMapping(value="feereceiptrequests.html",method=RequestMethod.GET)
	public ModelAndView request(HttpServletRequest request) throws Exception
	{
		String starts=request.getParameter("start");	
		int start=Integer.parseInt(starts);
		
		List ll=fee_receipt_dao.collect_datas(start);
		if(start!=0)
		{
			start=start+5;
			HttpSession session=request.getSession();
			session.setAttribute("startpoint", start);
		}
		else
		{
			HttpSession session=request.getSession();
			session.setAttribute("startpoint", 5);
		}
		return new ModelAndView("owner/fee_receipt_details","list4",ll);
	}	
	
	@RequestMapping(value="approvefee.html",method=RequestMethod.GET)
	public ModelAndView approvefee(@ModelAttribute fee_receipt fee_receipt,@RequestParam int id) throws Exception
	{
		fee_receipt.setId(id);
		fee_receipt.setStatus("approved");
		fee_receipt_dao.updatestatus(fee_receipt);
		return new ModelAndView("redirect:feereceiptrequests.html?start=0");
	}
	
	@RequestMapping(value="rejectfee.html",method=RequestMethod.GET)
	public ModelAndView rejectfee(@ModelAttribute fee_receipt fee_receipt,@RequestParam int id) throws Exception
	{
		fee_receipt.setId(id);
		fee_receipt.setStatus("rejected");
		fee_receipt_dao.updatestatus(fee_receipt);
		return new ModelAndView("redirect:feereceiptrequests.html?start=0");
	}
	
	//---------------------------------------------------------------------------------------------------------------
	 @RequestMapping(value = { "viewcomplain.html" }, method = { RequestMethod.GET })
	    public ModelAndView viewcomplain() throws Exception {
	        final List ll = this.complain_dao.collect_datas();
	        return new ModelAndView("owner/complain_details", "list6", (Object)ll);
	    }
	    
	    @RequestMapping(value = { "view.html" }, method = { RequestMethod.GET })
	    public ModelAndView view(@RequestParam final String id, @RequestParam final String date) throws Exception {
	        final List l1 = this.complain_dao.collect_complain(id, date);
	        return new ModelAndView("owner/complain_details_view", "list7", (Object)l1);
	    }
	    
	    @RequestMapping(value = { "reply.html" }, method = { RequestMethod.GET })
	    public ModelAndView reply(@RequestParam final String id, @RequestParam final String date) throws Exception {
	        return new ModelAndView("owner/complain_reply", "id", (Object)id);
	    }
	    @RequestMapping(value = { "reply1.html" }, method = { RequestMethod.GET })
	    public ModelAndView reply1(@RequestParam final String id, @RequestParam final String date) throws Exception {
	    	List l=complain_dao.complainreply(id,date);
	    	System.out.println("kkslklk");
	    	return new ModelAndView("owner/complain_reply1", "list", l);
	    }
	    
	    @RequestMapping(value = { "reply_get.html" }, method = { RequestMethod.GET })
	    public ModelAndView reply_get(final HttpServletRequest request) {
	        final String reply = request.getParameter("reply");
	        final String hostelid = request.getParameter("hostelid");
	        this.complain_dao.updatestatus(reply, hostelid);
	        return new ModelAndView("redirect:viewcomplain.html");
	    }
	    @RequestMapping(value="viewcomplainpart.html",method=RequestMethod.GET)
		public ModelAndView viewcomplianpart()
		{
			return new ModelAndView("owner/complain");
		}
		@RequestMapping(value="seepreviouscomplain.html",method=RequestMethod.GET)
		public ModelAndView seepreviouscomplain()
		{
			List l=complain_dao.collectcomplainlist();
			System.out.println(l.size()+"  "+"nhhh");
			return new ModelAndView("owner/seepreviouscomplain","list",l);
		}
	    
	    @RequestMapping(value = { "viewstudent.html" }, method = { RequestMethod.GET })
	    public ModelAndView viewstudent(final HttpServletRequest request) {
	    	String starts=request.getParameter("start");	
			int start=Integer.parseInt(starts);
			
			List data=food_dao.collect_student_data(start);
			if(start!=0)
			{
				start=start+10;
				HttpSession session=request.getSession();
				session.setAttribute("startpoint", start);
			}
			else
			{
				HttpSession session=request.getSession();
				session.setAttribute("startpoint", 10);
			}
	    	
	        return new ModelAndView("owner/view","data",data);
	    }
	    
	    @RequestMapping(value = { "ownermessage1.html" }, method = { RequestMethod.GET })
	    public ModelAndView ownermessage1(HttpServletRequest request) {
	    	
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
	        } catch (MessagingException e) {System.out.println("ERROR!!!"+e);}
	        
	        return new ModelAndView("owner/message");
	    }
	    
	    
	    @RequestMapping(value = "ownermessage.html" , method = RequestMethod.GET)
	    public ModelAndView ownermessage() {
	    		
	        return new ModelAndView("owner/message");
	    }
	    
	    @RequestMapping(value="deallocaetroom.html",method=RequestMethod.GET)
	    public ModelAndView deallocateroom()
	    {
	    	
	    	List l=guest_stay_dao.getallocatedrooms();
	    	return new ModelAndView("owner/deallocateroom","list",l);
	    }
	    
	    @RequestMapping(value="deallocate.html",method=RequestMethod.GET)
	    public ModelAndView deallocate(HttpServletRequest request)
	    {
	    	String ids=request.getParameter("id");
	    	String allocatedrooms=request.getParameter("allocatedroom");
	    	String noofguests=request.getParameter("noofguest");
	    	
	    	int id=Integer.parseInt(ids);
	    	int allocatedroom=Integer.parseInt(allocatedrooms);
	    	int noofguest=Integer.parseInt(noofguests);
	    	guest_stay_dao.deallocateroom(id,allocatedroom,noofguest);
	    	return new ModelAndView("redirect:deallocaetroom.html");
	    }
	    
	    @RequestMapping(value="getfeegraph.html",method=RequestMethod.GET)
	    public ModelAndView getfeegraph()
	    {
	    	int no[]=new int[2];
	    	no=fee_receipt_dao.getnoofpaidrequests();
	 
	    	ModelAndView mv=new ModelAndView();
	    	mv.addObject("paid", no[0]);
	    	mv.addObject("unpaid", no[1]);
	    	mv.setViewName("owner/feegraph");
	    	return mv; 
	    }
	    
	    @RequestMapping(value="GetFoodGraph.html",method=RequestMethod.GET)
	    public ModelAndView GetFoodGraph()
	    {
	    	List<coupon_count> menu_count=food_coupon_dao.getMenuCount();	 
	    	return new ModelAndView("owner/food_coupon_graph","menu_count",menu_count);
	    }
	    
	    @RequestMapping(value="attendance.html",method=RequestMethod.GET)
	    public ModelAndView attendance()
	    {
	    	SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
	    	String date=f.format(new Date());
			return new ModelAndView("owner/get_attendance","date",date);	
	    }
	    
	    @RequestMapping(value="makeattendance.html",method=RequestMethod.GET)
	    public ModelAndView makeattendance(HttpServletRequest request)
	    {
	    	String roomno=request.getParameter("roomno");
	    	String date=request.getParameter("date");
	    	List l=generate_hostelid.getstudents(roomno);
	    	if(l.isEmpty())
	    	{
	    		HttpSession s1 	=request.getSession();
				s1.setAttribute("alert", "no student");
				return new ModelAndView("general/alert");
	    	}
	    	else
	    	{
	    		return new ModelAndView("owner/make_attendance","list",l);
	    	}
	    }
	    
	    @RequestMapping(value="present.html",method=RequestMethod.GET)
	    public ModelAndView present(HttpServletRequest request)
	    {
	    	String hostelid[]=request.getParameterValues("hostelid");
	    	attendance_dao.insertpresenr(hostelid);
	    	return new ModelAndView("redirect:attendance.html");	
	    }
	    
	    @RequestMapping(value="getabsent.html",method=RequestMethod.GET)
	    public ModelAndView getabsent(HttpServletRequest request)
	    {
	    	List l=attendance_dao.getabsent();
	    	return new ModelAndView("owner/absent_students","list",l);	
	    }
	    @RequestMapping(value = { "ownerfoodstatus_owner.html" }, method = { RequestMethod.GET })
	    public ModelAndView ownerfoodstatus(final HttpServletRequest request) throws Exception {
	        
	        final String hostelid = request.getParameter("hostelid");
	        final List ll = this.food_coupon_dao.collect_data(hostelid);
	        return new ModelAndView("owner/food_coupon_status", "list2", (Object)ll);
	    }
	    @RequestMapping(value ="ownerleaveapplicationstatus_owner.html", method = RequestMethod.GET)
		public ModelAndView ownerleaveapplicationstatus(HttpServletRequest request) {
			String hostelid=request.getParameter("hostelid");
			List l=leave_application_dao.featchdata(hostelid);
			return new ModelAndView("owner/leave_application_status","list",l);
		}
	    @RequestMapping(value="ownerfeestatus.html",method=RequestMethod.GET)
		public ModelAndView ownerfeestatus(HttpServletRequest request)
		{
			
			String hostelid=request.getParameter("hostelid");
			List l=fee_receipt_dao.getstatus(hostelid);
			return new ModelAndView("owner/fee_receipt_status","list",l);
			
		}
	    @RequestMapping(value="ownergueststaystatus.html",method=RequestMethod.GET)
		public ModelAndView	ownergueststaystatus(HttpServletRequest request)
		{

			String hostelid=request.getParameter("hostelid");
			List l=guest_stay_dao.getlist(hostelid);
			return new ModelAndView("owner/guest_stay_status","list",l);
		}
	    
	    
}
