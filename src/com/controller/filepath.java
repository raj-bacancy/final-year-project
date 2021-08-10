package com.controller;

import java.sql.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;



/**
 * Servlet implementation class filepath
 */
@WebServlet("/filepath") @MultipartConfig
public class filepath extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public filepath() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	private void generatetoken(String CardNumber,String mon,String year,String CVC,String amount) throws Exception{
		String SecretKey="sk_test_51IKcX5JvMhB28Qnk9fMHc1ws88pz34plPnwmGccDPSu9hvo7BHzCeTPaPDUdBWWQY9nwdSJiIh42JzeZLGcnkyeH00RLKjqlup";
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
			pay(Token,amount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	}
	
	private void pay(String token,String amount) throws Exception {
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
		arguments.put("amount", amount);
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
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String link1="";
		HttpSession session=request.getSession();
		String filetype=(String)session.getAttribute("filetype");
		System.out.println(filetype);
		if(filetype.equals("feereceipt"))
		{
			System.out.println("fee Receipt");
			String hostelid=request.getParameter("hostelid");
			String currentyear=request.getParameter("currentyear");
			String status="pending";
			
			System.out.println("filepath");
			Part filepart=request.getPart("file");
			InputStream fileinputstream=filepart.getInputStream();
			File filetosave=new File(filepart.getSubmittedFileName());
			Files.copy(fileinputstream,filetosave.toPath(),StandardCopyOption.REPLACE_EXISTING);
			
			String link = "";
			
			 String key = "feereceipt/"+hostelid+"/"+ filepart.getSubmittedFileName();
			 String accesskey = "AKIAZYZ57NNJ2MRI6NUX";
			 String secretkey = "fj7JA00SWBWeumlnlBWhbIV2yhx7hcG5VE19oOV+";
			 String bucketname = "rajpatel";
			 AmazonS3Client s3 = new AmazonS3Client(new BasicAWSCredentials(accesskey, secretkey));
			
			
				System.out.println("1) ----file uploading---");
				PutObjectRequest request1 = new PutObjectRequest(bucketname, key, filetosave);
		        request1.setCannedAcl(CannedAccessControlList.PublicRead);
				s3.putObject(request1);
				System.out.println("----File uploaded----");
				System.out.println("\n\n2) ----Get Object---");
				link = s3.getUrl(bucketname, key).toString();
				System.out.println("S3 Link: " + link);	
				
			session.setAttribute("redirect", "loadfeereceipt");
			System.out.println("--------------------------------------"+hostelid);
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost/enr","root","root");
				Statement s=c.createStatement();
				s.executeUpdate("insert into fee_receipt (currentyear,feereceipt,hostelid,status) values ('"+currentyear+"','"+link+"','"+hostelid+"','"+status+"')");
				s.close();
				c.close();
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}	
			response.sendRedirect("redirection.jsp");
		}
		else if(filetype.equals("photo"))
		{
			session.setAttribute("redirect", "uniqueid");
			String hostelid=(String)session.getAttribute("hostel_id");
			System.out.println("--------------------------------------"+hostelid);
			System.out.println("filepath");
			Part filepart=request.getPart("file");
			InputStream fileinputstream=filepart.getInputStream();
			File filetosave=new File(filepart.getSubmittedFileName());
			Files.copy(fileinputstream,filetosave.toPath(),StandardCopyOption.REPLACE_EXISTING);
			
			String link = "";
			
			String key = "photo/"+hostelid+"/"+ filepart.getSubmittedFileName();
			  String accesskey = "AKIAZYZ57NNJ2MRI6NUX";
			 String secretkey = "fj7JA00SWBWeumlnlBWhbIV2yhx7hcG5VE19oOV+";
			 String bucketname = "rajpatel";
			 AmazonS3Client s3 = new AmazonS3Client(new BasicAWSCredentials(accesskey, secretkey));
			
			
				System.out.println("1) ----file uploading---");
				PutObjectRequest request1 = new PutObjectRequest(bucketname, key, filetosave);
		        request1.setCannedAcl(CannedAccessControlList.PublicRead);
				s3.putObject(request1);
				System.out.println("----File uploaded----");
				System.out.println("\n\n2) ----Get Object---");
				link = s3.getUrl(bucketname, key).toString();
				System.out.println("S3 Link: " + link);
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost/enr","root","root");
				Statement s=c.createStatement();
				s.executeUpdate("update student_registration set image='"+link+"' where hostelid='"+hostelid+"'");
				s.close();
				c.close();
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}	
			response.sendRedirect("redirection.jsp");	
		}
		else if(filetype.equals("uniqueid"))
		{
			String doctype=request.getParameter("doctype");
			String docno=request.getParameter("docno"); 
			session.setAttribute("redirect", "loadlogin");
			String hostelid=(String)session.getAttribute("hostel_id");
			System.out.println("--------------------------------------"+hostelid);
			System.out.println("filepath");
			Part filepart=request.getPart("doc");
			InputStream fileinputstream=filepart.getInputStream();
			File filetosave=new File(filepart.getSubmittedFileName());
			Files.copy(fileinputstream,filetosave.toPath(),StandardCopyOption.REPLACE_EXISTING);
			
			String link = "";
			
			String key = "uniqueid/"+hostelid+"/"+ filepart.getSubmittedFileName();
			  String accesskey = "AKIAZYZ57NNJ2MRI6NUX";
			 String secretkey = "fj7JA00SWBWeumlnlBWhbIV2yhx7hcG5VE19oOV+";
			 String bucketname = "rajpatel";
			 AmazonS3Client s3 = new AmazonS3Client(new BasicAWSCredentials(accesskey, secretkey));
			
			
				System.out.println("1) ----file uploading---");
				PutObjectRequest request1 = new PutObjectRequest(bucketname, key, filetosave);
		        request1.setCannedAcl(CannedAccessControlList.PublicRead);
				s3.putObject(request1);
				System.out.println("----File uploaded----");
				System.out.println("\n\n2) ----Get Object---");
				link = s3.getUrl(bucketname, key).toString();
				System.out.println("S3 Link: " + link);
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost/enr","root","root");
				Statement s=c.createStatement();
				s.executeUpdate("update student_registration set doctype='"+doctype+"',docno='"+docno+"',doclink='"+link+"' where hostelid='"+hostelid+"'");
				s.close();
				c.close();
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}	
			response.sendRedirect("redirection.jsp");	
		}
		else if(filetype.equals("mess_photo"))
		{
			session.setAttribute("redirect", "messpersonphoto");
			Part filepart=request.getPart("file");
			InputStream fileinputstream=filepart.getInputStream();
			File filetosave=new File(filepart.getSubmittedFileName());
			Files.copy(fileinputstream,filetosave.toPath(),StandardCopyOption.REPLACE_EXISTING);
			
			String link = "";
			
			String key = "messpersonphoto/"+ filepart.getSubmittedFileName();
			 String accesskey = "AKIAZYZ57NNJ2MRI6NUX";
			 String secretkey = "fj7JA00SWBWeumlnlBWhbIV2yhx7hcG5VE19oOV+";
			 String bucketname = "rajpatel";
			 AmazonS3Client s3 = new AmazonS3Client(new BasicAWSCredentials(accesskey, secretkey));
			
			
				System.out.println("1) ----file uploading---");
				PutObjectRequest request1 = new PutObjectRequest(bucketname, key, filetosave);
		        request1.setCannedAcl(CannedAccessControlList.PublicRead);
				s3.putObject(request1);
				System.out.println("----File uploaded----");
				System.out.println("\n\n2) ----Get Object---");
				link = s3.getUrl(bucketname, key).toString();
				System.out.println("S3 Link: " + link);
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost/enr","root","root");
				Statement s=c.createStatement();
				s.executeUpdate("update messregistration set image='"+link+"'");
				s.close();
				c.close();
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}	
			response.sendRedirect("redirection.jsp");	
		}
		else if(filetype.equals("locker"))
		{
			String hostelid=(String)session.getAttribute("hostel_id");
			String docname=request.getParameter("docname");
			String description=request.getParameter("description");
			session.setAttribute("redirect", "locker");
			Part filepart=request.getPart("doc");
			InputStream fileinputstream=filepart.getInputStream();
			File filetosave=new File(filepart.getSubmittedFileName());
			Files.copy(fileinputstream,filetosave.toPath(),StandardCopyOption.REPLACE_EXISTING);
			
			String link = "";
			
			String key = "locker/"+ filepart.getSubmittedFileName();
			 String accesskey = "AKIAZYZ57NNJ2MRI6NUX";
			 String secretkey = "fj7JA00SWBWeumlnlBWhbIV2yhx7hcG5VE19oOV+";
			 String bucketname = "rajpatel";
			 AmazonS3Client s3 = new AmazonS3Client(new BasicAWSCredentials(accesskey, secretkey));
			
			
				System.out.println("1) ----file uploading---");
				PutObjectRequest request1 = new PutObjectRequest(bucketname, key, filetosave);
		        request1.setCannedAcl(CannedAccessControlList.PublicRead);
				s3.putObject(request1);
				System.out.println("----File uploaded----");
				System.out.println("\n\n2) ----Get Object---");
				link = s3.getUrl(bucketname, key).toString();
				System.out.println("S3 Link: " + link);
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost/enr","root","root");
				Statement s=c.createStatement();
				s.executeUpdate("insert into locker (hostelid,docname,description,link) values ('"+hostelid+"','"+docname+"','"+description+"','"+link+"')");
				s.close();
				c.close();
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}	
			response.sendRedirect("redirection.jsp");	
		}else if(filetype.equals("feepayment") || filetype.equals("foodpayment")){
				String CardNumber=request.getParameter("cardnumber");
		        String mon=request.getParameter("expmonth");
		        String year=request.getParameter("expyear");
		        String CVC=request.getParameter("cvc");
		        String amount=request.getParameter("amount");
		        
		        try {
		        	
		        	String currentyear =String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		        	String hostelid=(String)session.getAttribute("hostel_id");
					generatetoken(CardNumber,mon,year,CVC,amount);
					Class.forName("com.mysql.jdbc.Driver");
					Connection c=DriverManager.getConnection("jdbc:mysql://localhost/enr","root","root");
					Statement s=c.createStatement();
					if(filetype.equals("feepayment")){
						session.setAttribute("redirect", "feepayment");
						s.executeUpdate("insert into fee_receipt (currentyear,hostelid,status) values ('"+currentyear+"','"+hostelid+"','approved')");
						s.close();
						c.close();
						session.setAttribute("redirect", "feepaymentsuccess");
					}else if(filetype.equals("foodpayment")){
						LocalDate date = LocalDate.now();
						String today=date.toString();
						String lunchprice=request.getParameter("lunchprice");
				        String dinnerprice=request.getParameter("dinnerprice");
				        String lunchmenu=request.getParameter("lunchmenu");
				        String dinnermenu=request.getParameter("dinnermenu");
				        String nooffoodcoupon=request.getParameter("nooffoodcoupon");
				        String foodtime=request.getParameter("foodtime");
				        int number=Integer.parseInt(nooffoodcoupon);
				       // FoodBill("abc", 123, 50, 20, 5, "abc", "xyz", "xyz");
				        
						s.executeUpdate("insert into food_coupon (date,foodtime,hostelid,nooffoodcoupon,status,cost) values ('"+today+"','"+foodtime+"','"+hostelid+"','"+number+"','approved','"+amount+"')");
						ResultSet r= s.executeQuery("select dinner,lunch,total_count,id from coupon_count where date ='"+today+"'");
						int lunchcount = 0,dinnercount = 0,id=0,total_count=0;
						while(r.next()){
							lunchcount=r.getInt("lunch");
							dinnercount=r.getInt("dinner");
							id=r.getInt("id");
						}
						total_count =  lunchcount +dinnercount;
						s.close();
						Statement s1=c.createStatement();
							if(foodtime.equals("lunch")){
								System.out.print("foodtime = "+foodtime);
								lunchcount=lunchcount+Integer.parseInt(nooffoodcoupon);
								total_count = total_count + Integer.parseInt(nooffoodcoupon);
								s1.executeUpdate("update coupon_count set lunch='"+lunchcount+"' , total_count='"+total_count+"' where id='"+id+"'");
								System.out.print("lunchcount = "+lunchcount);
							}else if (foodtime.equals("dinner")){
								System.out.print("foodtime = "+foodtime);
								dinnercount=dinnercount+Integer.parseInt(nooffoodcoupon);
								total_count = total_count + Integer.parseInt(nooffoodcoupon);
								s1.executeUpdate("update coupon_count set dinner='"+dinnercount+"' , total_count='"+total_count+"' where id='"+id+"'");
								System.out.print("dinnercount = "+dinnercount);
								
							}else if(foodtime.equals("both")){
								System.out.print("foodtime = "+foodtime);
								lunchcount=lunchcount+Integer.parseInt(nooffoodcoupon);
								dinnercount=dinnercount+Integer.parseInt(nooffoodcoupon);
								total_count = total_count + Integer.parseInt(nooffoodcoupon) +Integer.parseInt(nooffoodcoupon);
								s1.executeUpdate("update coupon_count set dinner='"+dinnercount+"' , lunch='"+lunchcount+"' , total_count='"+total_count+"' where id='"+id+"'");
								System.out.print("lunchcount = "+lunchcount);
								System.out.print("dinnercount = "+dinnercount);
								System.out.print("id = "+id);
							}
						
						s1.close();
						c.close();
						session.setAttribute("redirect", "foodpaymentsuccess");
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					session.setAttribute("redirect", "foodpaymentfailed");
				}
		        response.sendRedirect("redirection.jsp");
			}
	}
}
