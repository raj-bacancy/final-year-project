package com.controller;

import java.io.File;
import java.io.FileOutputStream;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.draw.VerticalPositionMark;

public class PdfConvertorFees {
public String PdfCretor(String hostelId,String studentName,String MobileNumber,String emailId,String totalFees) throws Exception  {
		
		System.out.println("I am in path");
		Document document = new Document();
		File file = new File(hostelId+"_fee_receipt.pdf");
		FileOutputStream fileName = new FileOutputStream(file);
	
		System.out.println(file.getAbsolutePath());
		PdfWriter.getInstance(document, fileName);
		
		document.open();
		
		//add date and ticket no 
		Chunk glue = new Chunk(new VerticalPositionMark());
		Paragraph ticketNo = new Paragraph("Hostel ID: "+hostelId);
		ticketNo.add(new Chunk(glue));
		ticketNo.add(java.time.LocalDate.now().toString());
		ticketNo.setSpacingAfter(0);
		
		//add title
		Font font = new Font();
		font.setSize(25.45f);
		font.setStyle(Font.BOLD);
		font.setStyle(Font.UNDERLINE);
		Chunk underline = new Chunk("FEES RECEIPT");
		underline.setFont(font);
		Paragraph title = new Paragraph(underline);
		title.setAlignment(Paragraph.ALIGN_CENTER);
		
	
		
		//
		Paragraph foodDetail = new Paragraph("Student Information");
		foodDetail.setAlignment(Paragraph.ALIGN_CENTER);
		foodDetail.setSpacingBefore(30);
		foodDetail.setSpacingAfter(10);
		//add table
		PdfPTable pdfPTable = new PdfPTable(2);
		pdfPTable.setSpacingBefore(7);
		pdfPTable.setWidthPercentage(90);
			PdfPCell[] pdfCell = new PdfPCell[50];			
		
				pdfCell[0] = new PdfPCell(new Paragraph("Student Name"));
				pdfCell[0].setFixedHeight(30);
				pdfPTable.addCell(pdfCell[0]);
				pdfPTable.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
				
				pdfCell[1] = new PdfPCell(new Paragraph(studentName));
				pdfCell[1].setFixedHeight(30);
				pdfPTable.addCell(pdfCell[1]);
				pdfPTable.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
				
				pdfCell[2] = new PdfPCell(new Paragraph("Mobile Number"));
				pdfCell[2].setFixedHeight(30);
				pdfPTable.addCell(pdfCell[2]);
				pdfPTable.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
				
				pdfCell[3] = new PdfPCell(new Paragraph(MobileNumber));
				pdfCell[3].setFixedHeight(30);
				pdfPTable.addCell(pdfCell[3]);
				pdfPTable.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
				
				pdfCell[4] = new PdfPCell(new Paragraph("Email Id"));
				pdfCell[4].setFixedHeight(30);
				pdfPTable.addCell(pdfCell[4]);
				pdfPTable.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
				
				pdfCell[5] = new PdfPCell(new Paragraph(emailId));
				pdfCell[5].setFixedHeight(30);
				pdfPTable.addCell(pdfCell[5]);
				pdfPTable.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
				
				pdfCell[6] = new PdfPCell(new Paragraph("Total Fees"));
				pdfCell[6].setFixedHeight(30);
				pdfPTable.addCell(pdfCell[6]);
				pdfPTable.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
				
				
				pdfCell[7] = new PdfPCell(new Paragraph(totalFees));
				pdfCell[7].setFixedHeight(30);
				pdfPTable.addCell(pdfCell[7]);
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
           return link;
			
}
}
