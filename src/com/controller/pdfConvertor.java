package com.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.dao.reg_dao;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.draw.VerticalPositionMark;
import com.vo.food_dinner;
import com.vo.food_lunch;

public class pdfConvertor {
	@Autowired
	reg_dao student_info ;
public void PdfCretor(String hostelId,String lunchmenu,String dinnermenu,String foodTime,String cost,String numberOfCoupon,String email) throws Exception  {
		
		System.out.println("I am in path");
		Document document = new Document();
		File file = new File(hostelId+".pdf");
		FileOutputStream fileName = new FileOutputStream(file);
	
		System.out.println(file.getAbsolutePath());
		PdfWriter.getInstance(document, fileName);
		
		document.open();
		
		//add date and ticket no 
		Chunk glue = new Chunk(new VerticalPositionMark());
		Paragraph ticketNo = new Paragraph("Hostel Id: "+hostelId);
		ticketNo.add(new Chunk(glue));
		ticketNo.add(java.time.LocalDate.now().toString());
		ticketNo.setSpacingAfter(0);
		
		//add title
		Font font = new Font();
		font.setSize(25.45f);
		font.setStyle(Font.BOLD);
		font.setStyle(Font.UNDERLINE);
		Chunk underline = new Chunk("FOOD COUPEN");
		underline.setFont(font);
		Paragraph title = new Paragraph(underline);
		title.setAlignment(Paragraph.ALIGN_CENTER);
		
	
		
		//
		Paragraph foodDetail = new Paragraph("Food Information");
		foodDetail.setAlignment(Paragraph.ALIGN_CENTER);
		foodDetail.setSpacingBefore(30);
		foodDetail.setSpacingAfter(10);
		//add table
		PdfPTable pdfPTable = new PdfPTable(2);
		pdfPTable.setSpacingBefore(7);
		pdfPTable.setWidthPercentage(90);
			PdfPCell[] pdfCell = new PdfPCell[50];			
		
				pdfCell[0] = new PdfPCell(new Paragraph("Lunch Menu"));
				pdfCell[0].setFixedHeight(30);
				pdfPTable.addCell(pdfCell[0]);
				pdfPTable.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
				
				pdfCell[1] = new PdfPCell(new Paragraph(lunchmenu));
				pdfCell[1].setFixedHeight(30);
				pdfPTable.addCell(pdfCell[1]);
				pdfPTable.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
				
				pdfCell[2] = new PdfPCell(new Paragraph("Dinner Menu"));
				pdfCell[2].setFixedHeight(30);
				pdfPTable.addCell(pdfCell[2]);
				pdfPTable.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
				
				pdfCell[3] = new PdfPCell(new Paragraph(dinnermenu));
				pdfCell[3].setFixedHeight(30);
				pdfPTable.addCell(pdfCell[3]);
				pdfPTable.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
				
				pdfCell[4] = new PdfPCell(new Paragraph("No Of Coupon"));
				pdfCell[4].setFixedHeight(30);
				pdfPTable.addCell(pdfCell[4]);
				pdfPTable.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
				
				pdfCell[5] = new PdfPCell(new Paragraph(numberOfCoupon));
				pdfCell[5].setFixedHeight(30);
				pdfPTable.addCell(pdfCell[5]);
				pdfPTable.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
				
				pdfCell[6] = new PdfPCell(new Paragraph("Food Time"));
				pdfCell[6].setFixedHeight(30);
				pdfPTable.addCell(pdfCell[6]);
				pdfPTable.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
				
				
				pdfCell[7] = new PdfPCell(new Paragraph(foodTime));
				pdfCell[7].setFixedHeight(30);
				pdfPTable.addCell(pdfCell[7]);
				pdfPTable.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
				
				pdfCell[8] = new PdfPCell(new Paragraph("Subtotal"));
				pdfCell[8].setFixedHeight(30);
				pdfPTable.addCell(pdfCell[8]);
				pdfPTable.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
				
				pdfCell[9] = new PdfPCell(new Paragraph(cost));
				pdfCell[9].setFixedHeight(30);
				pdfPTable.addCell(pdfCell[9]);
				pdfPTable.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
				
				pdfCell[10] = new PdfPCell(new Paragraph("Other Charges"));
				pdfCell[10].setFixedHeight(30);
				pdfPTable.addCell(pdfCell[10]);
				pdfPTable.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
				
				pdfCell[11] = new PdfPCell(new Paragraph("0"));
				pdfCell[11].setFixedHeight(30);
				pdfPTable.addCell(pdfCell[11]);
				pdfPTable.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
				
				pdfCell[12] = new PdfPCell(new Paragraph("Total"));
				pdfCell[12].setFixedHeight(30);
				pdfPTable.addCell(pdfCell[12]);
				pdfPTable.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
				
				pdfCell[13] = new PdfPCell(new Paragraph(cost));
				pdfCell[13].setFixedHeight(30);
				pdfPTable.addCell(pdfCell[13]);
				pdfPTable.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
				
		//add all element
		document.add(ticketNo);
		document.add(title);
//		document.add(name);
		document.add(foodDetail);
		document.add(pdfPTable);
		document.close();
		
		
		//upload file into aws s3
		String link = "";
		
		String key = "photo/"+hostelId+"/"+file.getName();
		  String accesskey = "AKIAZYZ57NNJ2MRI6NUX";
		 String secretkey = "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";
		 String bucketname = "rajpatel";
		 AmazonS3Client s3 = new AmazonS3Client(new BasicAWSCredentials(accesskey, secretkey));
		
		
			System.out.println("1) ----file uploading---");
			PutObjectRequest request1 = new PutObjectRequest(bucketname, key, file);
	        request1.setCannedAcl(CannedAccessControlList.PublicRead);
			s3.putObject(request1);
			System.out.println("----File uploaded----");
			System.out.println("\n\n2) ----Get Object---");
			link = s3.getUrl(bucketname, key).toString();
			System.out.println("S3 Link: " + link);
        
			
		//mail sent with link
		
			
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
			         message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));    
			         message.setSubject("Food Coupen");    
			         message.setText("Download a Food Coupon"+link);    
			         //send message  
			         Transport.send(message);    
			         System.out.println("message sent successfully to "+email); 
	        	
	        } catch (Exception e) {System.out.println("ERROR!!!"+e);}
	        
    
		
		
	}
//	public static void main(String args[]) throws Exception {
//		pdfConvertor pdf = new pdfConvertor();
//		pdf.PdfCretor("HH1234","Mix","Mix212","hds","12","12");
//	}
}
