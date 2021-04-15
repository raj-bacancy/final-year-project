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

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

/**
 * Servlet implementation class filepath1
 */
@WebServlet("/filepath1")
public class filepath1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public filepath1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hostelid=request.getParameter("hostelid");
		String currentyear=request.getParameter("currentyear");
		String status="pending";
		System.out.println("filepath");
		Part filepart=request.getPart("file");
		InputStream fileinputstream=filepart.getInputStream();
		File filetosave=new File(filepart.getSubmittedFileName());
		Files.copy(fileinputstream,filetosave.toPath(),StandardCopyOption.REPLACE_EXISTING);
		
		String link = "";
		
		 String key = "test_1/" + filepart.getSubmittedFileName();
		 String accesskey = "AKIAVMQYK6QAN5EKYUOV";
		 String secretkey = "dkxw+GiOIC00BjSWtVHhOWKMBqaUGn+275xga9sg";
		 String bucketname = "rgpatel7714";
		 AmazonS3Client s3 = new AmazonS3Client(new BasicAWSCredentials(accesskey, secretkey));
		
		
			System.out.println("1) ----file uploading---");
			PutObjectRequest request1 = new PutObjectRequest(bucketname, key, filetosave);
	        request1.setCannedAcl(CannedAccessControlList.PublicRead);
			s3.putObject(request1);
			System.out.println("----File uploaded----");
			System.out.println("\n\n2) ----Get Object---");
			link = s3.getUrl(bucketname, key).toString();
			System.out.println("S3 Link: " + link);	
			
			HttpSession session=request.getSession();
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

}
