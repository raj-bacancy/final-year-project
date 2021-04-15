<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fee Receipt Upload</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="style.css" rel="stylesheet">
</head>
<body>



<%-- <jsp:include page="header.jsp"></jsp:include>  
<jsp:include page="student_table.jsp"></jsp:include> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>
<%
	session.setAttribute("filetype", "feereceipt");
	String hostel_id=(String)session.getAttribute("hostel_id");
%>
<div class="mx-auto mt-3 box_form mb-5 bg-white">
	   			<h2 class="pt-4 text-center"><b>Fee Receipt Upload</b></h2>
	   			<hr>
		   			<form action="<%=request.getContextPath()%>/filepath" method="post" enctype="multipart/form-data">
		   		<div class="row">
		   			<div class="col-12 col-sm-5 "><h3 class="pl-4">Hostel Id</h3></div>
		   			<div class="col-1"></div>
		   			<div class="col-10 col-sm-5 mb-5"><input type="text" class="form-control" name="hostelid" style="border-radius:7px " value="<%=hostel_id %>" readonly="true"></div>
		   			
		   		</div>
		   		
		   		<div class="row">
		   			<div class="col-12 col-sm-5 "><h3 class="pl-4">Current Year</h3></div>
		   			<div class="col-1"></div>
		   			<div class="col-10 col-sm-5 mb-5"><input type="text" class="form-control"   name="currentyear" placeholder=" Ex.2020" value="2020" readonly="true"></div>
		   			
		   		</div>
		   		
		   		<div class="row">
		   			<div class="col-12 col-sm-5 "><h3 class="pl-4">Input File </h3></div>
		   			<div class="col-1"></div>
		   			<div class="col-10 col-sm-5 mb-5"><input type="file" class="form-control" name="file" required="required"></div>
		   			
		   		</div>
		   		<input type="hidden" name="status" value="pending">
		   		<br>
		   		<div class="row">
		   			<div class="col-12 col-sm-12">
		   			<center>
		   			<button class="btn btn-info" type="submit">Submit</button>
		   			</center>
		   			</div>
		   		</div>
	<br>
		   			
					</form>
	   		</div>



</body>
</html>