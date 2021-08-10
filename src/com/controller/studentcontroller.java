package com.controller;

import java.io.IOException;

import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.*;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.vo.*;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.dao.*;


@Controller 
public class studentcontroller {
	
	@Autowired
	leave_application_dao leave_application_dao;
	
	@Autowired
	reg_dao reg_dao;
	
	@Autowired
	food_coupon_dao food_coupon_dao;
	
	@Autowired
	fee_receipt_dao fee_receipt_dao;
	
	@Autowired
	guest_stay_dao guest_stay_dao;
	
	@Autowired
	complain_dao complain_dao;
	
	@Autowired
	food_dao food_dao;
	
	@Autowired
	student_dashboard_dao student_dashboard;
	
	@Autowired
	generatehostelid_dao generate_hostelid;
	
	@Autowired
	locker_dao locker_dao;;
	
	@RequestMapping(value = "loadstudentsignup.html", method = RequestMethod.GET)
	public ModelAndView loadstudentsignup() {
		return new ModelAndView("general/student_reg", "student_reg", new student_reg());
	}
	
	
	@RequestMapping(value="studentregistration.html",method=RequestMethod.POST) 
	public ModelAndView studentregistration(@ModelAttribute student_reg student_reg,HttpServletRequest request)
	{	
		
		System.out.println("l1");
		String hostelid=student_reg.getHostelid();
		System.out.println(hostelid);
		generate_hostelid_vo generate_hostelid=new generate_hostelid_vo();
		reg_dao.student_reg_insert(student_reg);
		System.out.println("l2");
		generate_hostelid.setFlag(1);
		generate_hostelid.setHostelid(hostelid);
		reg_dao.update_flag(generate_hostelid);
		return new ModelAndView("general/student_upload_photo");
	}
	
	@RequestMapping(value ="leaveapplication.html", method = RequestMethod.GET)
	public ModelAndView leaveapplication() {
		return new ModelAndView("student/leave_application");
	}
	
	@RequestMapping(value ="leaveapplicationapply.html", method = RequestMethod.GET)
	public ModelAndView leaveapplicationapply(@ModelAttribute leave_application leave_application) {
		String hostelid=leave_application.getHostelid();
		String emailid=reg_dao.getstudentmail(hostelid);
		String reason=leave_application.getReason();
		String datefrom=leave_application.getDatefrom();
		String dateto=leave_application.getDateto();
		//-----------------------------------
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
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(emailid));    
         message.setSubject("Leave Application of "+hostelid);    
         message.setText("Date  From :  "+datefrom+"  To :  "+dateto+"  Reason For Leave :  "+reason);    
         //send message  
         Transport.send(message);    
         System.out.println("message sent successfully to "+emailid);    
        } catch (Exception e) {System.out.println("ERROR!!! = "+e.getMessage());} 
		//-----------------------------------
		leave_application.setStatus("pending");
		leave_application_dao.insert(leave_application);
		System.out.println("2");
		return new ModelAndView("student/leave_application");
	}
	
	@RequestMapping(value ="loadleaveapplicationapply.html", method = RequestMethod.GET)
	public ModelAndView loadleaveapplicationapply() {
		return new ModelAndView("student/leave_application_apply","leave_application",new leave_application());
	}
	
	@RequestMapping(value ="loadleaveapplicationstatus.html", method = RequestMethod.GET)
	public ModelAndView loadleaveapplicationstatus(HttpServletRequest request) {
		HttpSession session=request.getSession();
		String hostelid=(String)session.getAttribute("hostel_id");
		List l=new ArrayList();
		 l=leave_application_dao.featchdata(hostelid);
		return new ModelAndView("student/leave_application_status","list",l);
	}
	
	@RequestMapping(value ="ownerleaveapplicationstatus.html", method = RequestMethod.GET)
	public ModelAndView ownerleaveapplicationstatus(HttpServletRequest request) {
		String hostelid=request.getParameter("hostelid");
		List l=leave_application_dao.featchdata(hostelid);
		return new ModelAndView("student/leave_application_status","list",l);
	}
	
	@RequestMapping(value="foodcoupon.html",method=RequestMethod.GET)
	public ModelAndView foodcoupon()
	{
		return new ModelAndView("student/food_coupon");	
	}
	
	
	 @RequestMapping(value = { "todaymenu.html" }, method = { RequestMethod.GET })
	    public ModelAndView todaymenu(HttpServletRequest request) {
	         LocalDate dates = LocalDate.now();
	         String date = dates.toString();
	         List l1 = food_dao.getlunch(date);
	         List l2 = food_dao.getdinner(date);
	         if(l1.isEmpty()||l2.isEmpty())
	         {
	        	HttpSession session = request.getSession();
	 	        session.setAttribute("alert","Lunch or dinner problem");
	 	        return new ModelAndView("general/alert");
	         }
	         else
	         {
		        HttpSession session = request.getSession();
		        coupon_count ob1 = (coupon_count) l1.get(0);
		        int lunchprice = ob1.getLunchprice();
		        session.setAttribute("lunchprice", (Object)lunchprice);
		        System.out.println("lunch price " + lunchprice);
		        final coupon_count ob2 = (coupon_count) l2.get(0);
		        final int dinnerprice = ob2.getDinnerprice();
		        session.setAttribute("dinnerprice", (Object)dinnerprice);
		        System.out.println("dinner price " + dinnerprice);
		        System.out.println(l1 + " " + "man" + l2);
		        session.setAttribute("l2", (Object)l2);
		        session.setAttribute("l1", (Object)l1);
		        
		        return new ModelAndView("student/todaymenu");
		       }
	         
	    }
	    	    
	    @RequestMapping(value = { "applycoupon.html" }, method = { RequestMethod.GET })
	    public ModelAndView applycoupon() {
	        return new ModelAndView("student/food_coupon_apply", "food_coupon", (Object)new food_coupon());
	    }
	    
	    @RequestMapping(value = { "payfoodcoupon.html" }, method = { RequestMethod.GET })
	    public ModelAndView payfoodcoupon(@ModelAttribute final food_coupon food, final HttpServletRequest request) throws Exception {
	        
	        final String s = food.getFoodtime();
	        final int a = food.getNooffoodcoupon();
	        final HttpSession session = request.getSession();
	        int cost;
	        if (s.equals("lunch")) {
	            final int lunchprice = (int)session.getAttribute("lunchprice");
	            System.out.println("lunch price " + lunchprice);
	            cost = a * lunchprice;
	        }
	        else if (s.equals("dinner")) {
	            final int dinnerprice = (int)session.getAttribute("dinnerprice");
	            cost = a * dinnerprice;
	        }
	        else {
	            final int lunchprice = (int)session.getAttribute("lunchprice");
	            final int dinnerprice2 = (int)session.getAttribute("dinnerprice");
	            final int total = lunchprice + dinnerprice2;
	            cost = total * a;
	        }
	        LocalDate dates = LocalDate.now();
	         String date = dates.toString();
	         List l1 = food_dao.getlunch(date);
	         List l2 = food_dao.getdinner(date);
	        ModelAndView mv=new ModelAndView();
	        mv.addObject("nooffoodcoupon",a);
	        mv.addObject("cost",cost);
	        mv.addObject("foodtime",s);
	        mv.addObject("lunch",l1);
	        mv.addObject("dinner",l2);
	        
	        //make pdf for food coupon
	        
	        coupon_count lunchmenu= (coupon_count) l1.get(0);
	        lunchmenu.getLunchmenu();
	        coupon_count dinnermenu= (coupon_count) l2.get(0);
	        dinnermenu.getDinnermenu();
	        
	        //MAKE PDF FILE FOR COUPON
	        String hostelId = (String)session.getAttribute("hostel_id");
	        List l3 =reg_dao.collect_student_info(hostelId);
	        student_reg email= (student_reg) l3.get(0);
	        pdfConvertor con = new pdfConvertor();
	        con.PdfCretor(hostelId,lunchmenu.getLunchmenu(),dinnermenu.getDinnermenu(),s,Integer.toString(cost),Integer.toString(a),email.getEmail());
	        
	        mv.setViewName("student/payment_foodcoupon");
	        return mv;
	    }
	    
	    @RequestMapping(value = { "foodapply.html" }, method = { RequestMethod.GET })
	    public ModelAndView foodapply(@ModelAttribute final food_coupon food, final HttpServletRequest request) throws Exception {
	        
	        final String s = food.getFoodtime();
	        final int a = food.getNooffoodcoupon();
	        final HttpSession session = request.getSession();
	        int cost;
	        if (s.equals("lunch")) {
	            final int lunchprice = (int)session.getAttribute("lunchprice");
	            System.out.println("lunch price " + lunchprice);
	            cost = a * lunchprice;
	        }
	        else if (s.equals("dinner")) {
	            final int dinnerprice = (int)session.getAttribute("dinnerprice");
	            cost = a * dinnerprice;
	        }
	        else {
	            final int lunchprice = (int)session.getAttribute("lunchprice");
	            final int dinnerprice2 = (int)session.getAttribute("dinnerprice");
	            final int total = lunchprice + dinnerprice2;
	            cost = total * a;
	        }
	        HttpSession s2 = request.getSession();
	        s2.setAttribute("costs", (Object)cost);
	        HttpSession s3 = request.getSession();
	        s3.setAttribute("alert", (Object)"foodcost");
	        HttpSession s4 = request.getSession();
		    s4.setAttribute("foodtime", (Object)s);
		    food.setCost(cost);
		    food_coupon_dao.foodapply(food);
	        
	        return new ModelAndView("general/alert");
	    }
	    @RequestMapping(value = { "checkpay.html" }, method = { RequestMethod.GET })
	    public ModelAndView checkpay(HttpServletRequest request,HttpServletResponse response) throws IOException {
	    	String status=request.getParameter("status");
	    	String foodtime=request.getParameter("foodtime");
	    	String costs=request.getParameter("cost");
	    	int cost=Integer.parseInt(costs);
	    	if(status.equals("approved")){
	    		HttpSession session=request.getSession();
	    		session.setAttribute("costs", cost);
	    		session.setAttribute("foodtime", foodtime);
	    		 return new ModelAndView("redirect:payfood.html");
	    	     
		    }
	    	else
	    	{
	    		HttpSession s3 = request.getSession();
		        s3.setAttribute("alert","notapproved");
		        return new ModelAndView("general/alert");
	    	}
	    }
	    	 @RequestMapping(value = { "payfood.html" }, method = { RequestMethod.GET})
	 	    public ModelAndView payfood(HttpServletRequest request) {
	 	    	
	 	    	HttpSession s=request.getSession();
	 	    	String hostel_id=(String)s.getAttribute("hostel_id");
	 	    	List l=food_dao.collect_student_payfood_data(hostel_id);
	 	        return new ModelAndView("student/payfoodpage","listfood",l);
	 	    }
	    
	    @RequestMapping(value = { "loadfood.html" }, method = { RequestMethod.GET })
	    public ModelAndView loadfood() {
	        return new ModelAndView("student/food_coupon");
	    }
	    
	    @RequestMapping(value = { "foodstatus.html" }, method = { RequestMethod.GET })
	    public ModelAndView foodstatus(final HttpServletRequest request) throws Exception {
	        final HttpSession session = request.getSession();
	        final String hostelid = (String)session.getAttribute("hostel_id");
	        final List ll = this.food_coupon_dao.collect_data(hostelid);
	        return new ModelAndView("student/food_coupon_status", "list2", (Object)ll);
	    }
	    
	    @RequestMapping(value = { "ownerfoodstatus.html" }, method = { RequestMethod.GET })
	    public ModelAndView ownerfoodstatus(final HttpServletRequest request) throws Exception {
	        
	        final String hostelid = request.getParameter("hostelid");
	        final List ll = this.food_coupon_dao.collect_data(hostelid);
	        return new ModelAndView("student/food_coupon_status", "list2", (Object)ll);
	    }
	
	@RequestMapping(value="gueststay.html",method=RequestMethod.GET)
	public ModelAndView gueststay()
	{
		return new ModelAndView("student/guest_stay");
	}
	
	@RequestMapping(value="gueststayapply.html",method=RequestMethod.GET)
	public ModelAndView gueststayapply()
	{
		return new ModelAndView("student/guest_stay_apply","guest_stay_vo",new guest_stay_vo());
	}
	
	@RequestMapping(value="gueststayapplication.html",method=RequestMethod.POST)
	public ModelAndView gueststayapplication(@ModelAttribute guest_stay_vo guest_stay_vo)
	{
		guest_stay_vo.setStatus("pending");
		guest_stay_dao.insert(guest_stay_vo);
		return new ModelAndView("student/guest_stay");
	}
	
	@RequestMapping(value="gueststaystatus.html",method=RequestMethod.GET)
	public ModelAndView	gueststaystatus(HttpServletRequest request)
	{

		HttpSession session=request.getSession();
		String hostelid=(String)session.getAttribute("hostel_id");
		List l=guest_stay_dao.getlist(hostelid);
		return new ModelAndView("student/guest_stay_status","list",l);
	}
	
	
	
	@RequestMapping(value="feereceipt.html",method=RequestMethod.GET)
	public ModelAndView feereceipt()
	{
		return new ModelAndView("student/fee_receipt");
		
	}
	
	@RequestMapping(value="feereceiptupload.html",method=RequestMethod.GET)
	public ModelAndView feereceipt1()
	{
		return new ModelAndView("student/fee_receipt_upload","fee_receipt",new fee_receipt());
		
	}
	
	
	
	@RequestMapping(value="upload.html",method=RequestMethod.GET)
	public ModelAndView upload(@ModelAttribute fee_receipt fee) throws Exception
	{
		
		//fee_receipt_dao.feereceiptapply(fee);
		return new ModelAndView("student/fee_receipt");
		
	}
	
	@RequestMapping(value="feestatus.html",method=RequestMethod.GET)
	public ModelAndView feestatus(HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		String hostelid=(String)session.getAttribute("hostel_id");
		List l=fee_receipt_dao.getstatus(hostelid);
		return new ModelAndView("student/fee_receipt_status","list",l);
		
	}
	
	
	
	//-------------------------------------------------------------------------------------------------------
	@RequestMapping(value = { "complain.html" }, method = { RequestMethod.GET })
    public ModelAndView complain() {
        return new ModelAndView("student/complain");
    }
    
    @RequestMapping(value = { "complain_request.html" }, method = { RequestMethod.GET })
    public ModelAndView complain_request() {
        return new ModelAndView("student/complain_apply", "complain", (Object)new complain());
    }
    
    @RequestMapping(value = { "complianapply.html" }, method = { RequestMethod.POST })
    public ModelAndView complianapply(@ModelAttribute final complain complain,HttpServletRequest request) throws Exception {
        
        String date=complain.getDate();
        String hostelid=complain.getHostelid();
        String subject = complain.getSubject();
        String description = complain.getComplain();
        String type = complain.getType();
        List l=complain_dao.checkvalidcomplain(hostelid,date);
        if(l.isEmpty())
        {
        	try{
        		worker_vo ob = this.complain_dao.send_message(subject,description);
            	complain.setAssignee(ob.getName()+"-"+ob.getPhoneno());
    	        this.complain_dao.complainapply(complain);
        		
        	}catch(Exception e){
        		System.out.println("ERROR!!! "+e.getMessage());
        	}
        	
	        return new ModelAndView("student/complain");
        }
        else
        {
        	HttpSession s3 = request.getSession();
  	        s3.setAttribute("alert", (Object)"complainapplyacheck");	
  	      return new ModelAndView("general/alert");
        }
        
       
    }
    @RequestMapping(value = { "viewcomplainreply.html" }, method = { RequestMethod.GET })
    public ModelAndView viewcomplainreply(@RequestParam String hostelid,@RequestParam String date) {
    	System.out.println("mamn");
    	List l=complain_dao.collectcomplainreply(hostelid,date);
    	complain obj=(complain)l.get(0);
    	System.out.println(obj.getReply()+"mamam");
        return new ModelAndView("student/complain_details_view","list",l);
    }
    @RequestMapping(value = { "complain_status.html" }, method = { RequestMethod.GET })
    public ModelAndView complain_status(HttpServletRequest request) {
        final HttpSession session = request.getSession();
        final String hostelid = (String)session.getAttribute("hostel_id");
        final List ll = complain_dao.collect_data(hostelid);
    	System.out.println("mann patel king");
        return new ModelAndView("student/complain_status", "list5", (Object)ll);
    }
    
    @RequestMapping(value ="addlocker.html",method = RequestMethod.GET)
    public ModelAndView addlocker(){     
        return new ModelAndView("student/add_locker");
    }
    
    @RequestMapping(value ="showlocker.html",method = RequestMethod.GET)
    public ModelAndView showlocker(HttpServletRequest request){   
    	HttpSession session=request.getSession();
    	String hostelid=(String)session.getAttribute("hostel_id");
    	List l=locker_dao.getdoc(hostelid);
        return new ModelAndView("student/show_locker","list",l);
    }
    
    @RequestMapping(value = { "visitor.html" }, method = { RequestMethod.GET })
    public ModelAndView visitor() {
        return new ModelAndView("student/visitor_apply","visitors", new visitor());
    }
    
    @RequestMapping(value = { "visitorapply.html" }, method = { RequestMethod.GET })
    public ModelAndView visitorapply(@ModelAttribute visitor visitor) {
    	String emailid=visitor.getVisitoremailid();
    	String hostelid=visitor.getHostelid();
    	int roomno=generate_hostelid.getroomno(hostelid);
    	String checkin=visitor.getCheckin();
    	String checkout=visitor.getCheckout();
    	String date=visitor.getDate();
    	String name=visitor.getVisitorname();
    	
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
	         message.setSubject("Request Approved For Visit");    
	         message.setText("Hey "+name+" Your friend with Hostelid = "+hostelid+" has requested for your visitor entry. I am allowing you to enter into Room No "+roomno+" for Date="+date+" your check in time is "+checkin+" And you have to leave room no "+roomno+" before "+checkout+". Have a nice day...");    
	         //send message  
	         Transport.send(message);    
	         System.out.println("message sent successfully to "+emailid);    
	        } catch (Exception e) {System.out.println("Error!! = "+e.getMessage());}
    	food_dao.visitordata(visitor);
        return new ModelAndView("student/visitor_apply","visitors", new visitor());
    }
    
    @RequestMapping(value = { "Pay.html" }, method = { RequestMethod.POST })
    public ModelAndView Pay() throws Exception {
    	String SecretKey="sk_test_51IKcX5JvMhB28Qnk9fMHc1ws88pz34plPnwmGccDPSu9hvo7BHzCeTPaPDUdBWWQY9nwdSJiIh42JzeZLGcnkyeH00RLKjqlup";
        String CardNumber="4242424242424242";
        String mon="2";
        String year="2023";
        String CVC="123";
		String url1 = "https://api.stripe.com/v1/tokens";
		URL url = new URL(url1);
		URLConnection con = url.openConnection();
		HttpURLConnection http = (HttpURLConnection)con;
		http.setRequestMethod("POST"); // PUT is another valid option
		http.setDoOutput(true);
		http.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
		http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		http.setRequestProperty("Authorization","Bearer "+SecretKey);
		Map<String,String> arguments = new HashMap<>();
		arguments.put("card[number]", CardNumber);
		arguments.put("card[exp_month]", mon);
		arguments.put("card[exp_year]", year);
		arguments.put("card[cvc]", CVC);
		StringJoiner sj = new StringJoiner("&");
		for(Map.Entry<String,String> entry : arguments.entrySet())
		    sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" 
		         + URLEncoder.encode(entry.getValue(), "UTF-8"));
		byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
		int length = out.length;
		
		http.setFixedLengthStreamingMode(length);
		http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		http.connect();
		try(OutputStream os = http.getOutputStream()) {
		    os.write(out);
		}catch(Exception e){
			System.out.println("ERROR!!!"+e.getMessage());
		}
		BufferedReader in = new BufferedReader(
                new InputStreamReader(
                		http.getInputStream()));
    String inputLine;
    String Token = null;
    int i=1;
    while ((inputLine = in.readLine()) != null){ 
      System.out.println(inputLine);
      if(i==2){
    	 Token=inputLine.substring(9,(inputLine.length()-2));
    	 break;
      }
      i++;
    }
    in.close();
    System.out.println("Token  = = = "+Token);
    if(Token!=null){
    	try {
			pay(Token);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
        return new ModelAndView("student/complain");
    }
    
    private void pay(String token) throws Exception {
		String SecretKey="sk_test_51IKcX5JvMhB28Qnk9fMHc1ws88pz34plPnwmGccDPSu9hvo7BHzCeTPaPDUdBWWQY9nwdSJiIh42JzeZLGcnkyeH00RLKjqlup";
		String url1 = "https://api.stripe.com/v1/charges";
		
		URL url = new URL(url1);
		URLConnection con = url.openConnection();
		HttpURLConnection http = (HttpURLConnection)con;
		http.setRequestMethod("POST"); // PUT is another valid option
		http.setDoOutput(true);
		http.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
		http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		http.setRequestProperty("Authorization","Bearer "+SecretKey);
		Map<String,String> arguments = new HashMap<>();
		arguments.put("amount", "700");
		arguments.put("currency", "inr");
		arguments.put("description", "Payment From HDMS");
		arguments.put("source", token);
		StringJoiner sj = new StringJoiner("&");
		for(Map.Entry<String,String> entry : arguments.entrySet())
		    sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" 
		         + URLEncoder.encode(entry.getValue(), "UTF-8"));
		byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
		int length = out.length;
		
		http.setFixedLengthStreamingMode(length);
		http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		http.connect();
		try(OutputStream os = http.getOutputStream()) {
		    os.write(out);
		}catch(Exception e){
			System.out.println("ERROR!!!"+e.getMessage());
		}
		BufferedReader in = new BufferedReader(
                new InputStreamReader(
                		http.getInputStream()));
    String inputLine;
    while ((inputLine = in.readLine()) != null){ 
      System.out.println(inputLine);
      
    }
	}
    
    @RequestMapping(value = { "loadpayment.html" }, method = { RequestMethod.GET })
    public ModelAndView loadpayment() {
        return new ModelAndView("student/payment");
    }
	
}
