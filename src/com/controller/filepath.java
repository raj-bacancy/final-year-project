package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
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
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
				 String accesskey = "AKIASSUNY6Y4XSRJVLKV";
				 String secretkey = "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";
				 String bucketname = "enrhostelmanagement";
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
					Connection c=DriverManager.getConnection("jdbc:mysql://enr-hostel-database.cxi8oq6r3cya.us-east-1.rds.amazonaws.com/enr","admin12345","admin12345");
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
				 String accesskey = "AKIASSUNY6Y4XSRJVLKV";
				 String secretkey = "RAXGB3TWlX46bRW6gfp+oCgDDm9C0Rmn1Y6L0SJN";
				 String bucketname = "enrhostelmanagement";
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
					Connection c=DriverManager.getConnection("jdbc:mysql://enr-hostel-database.cxi8oq6r3cya.us-east-1.rds.amazonaws.com/enr","admin12345","admin12345");
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
				 String accesskey = "AKIASSUNY6Y4XSRJVLKV";
				 String secretkey = "RAXGB3TWlX46bRW6gfp+oCgDDm9C0Rmn1Y6L0SJN";
				 String bucketname = "enrhostelmanagement";
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
					Connection c=DriverManager.getConnection("jdbc:mysql://enr-hostel-database.cxi8oq6r3cya.us-east-1.rds.amazonaws.com/enr","admin12345","admin12345");
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
				 String accesskey = "AKIASSUNY6Y4XSRJVLKV";
				 String secretkey = "RAXGB3TWlX46bRW6gfp+oCgDDm9C0Rmn1Y6L0SJN";
				 String bucketname = "enrhostelmanagement";
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
					Connection c=DriverManager.getConnection("jdbc:mysql://enr-hostel-database.cxi8oq6r3cya.us-east-1.rds.amazonaws.com/enr","admin12345","admin12345");
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
				 String accesskey = "AKIASSUNY6Y4XSRJVLKV";
				 String secretkey = "RAXGB3TWlX46bRW6gfp+oCgDDm9C0Rmn1Y6L0SJN";
				 String bucketname = "enrhostelmanagement";
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
					Connection c=DriverManager.getConnection("jdbc:mysql://enr-hostel-database.cxi8oq6r3cya.us-east-1.rds.amazonaws.com/enr","admin12345","admin12345");
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
			}
	}
}
