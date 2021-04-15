<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" import="java.time.LocalDate"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Complain Apply</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="style.css" rel="stylesheet">
</head>
<body>


<%-- <jsp:include page="header.jsp"></jsp:include>  
<jsp:include page="student_table.jsp"></jsp:include> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%   LocalDate date = LocalDate.now(); 
	String hostel_id=(String)session.getAttribute("hostel_id");
%>
<div class="mx-auto mt-3 leave_div bg-white">
	   			<h2 class="pt-4 text-center"><b>Complain Apply</b></h2>
	   			<hr>
		   			<f:form action="complianapply.html" modelAttribute="complain" method="POST">
		   			<div class="row">
		   			<div class="col-12 col-sm-3 "><h3 class="pl-4"> Hostel Id:</h3></div>
		   			<div class="col-10 col-sm-5 mb-5 set_input_box"><f:input type="text" path="hostelid" class="form-control" value="<%=hostel_id%>" readonly="true"/></div>
		   			
		   		</div>
		   		<div class="row">
		   			<div class="col-12 col-sm-3 "><h3 class="pl-4"> Subject:</h3></div>
		   			<div class="col-10 col-sm-5 mb-5 set_input_box"><f:input required="required" type="text" path="subject" class="form-control" placeholder=" Subject for Complain"/></div>
		   			
		   		</div>
		   		<br>
		   		<div class="row">
					
					<div class="col-12 col-sm-3"><h3 class="pl-4">Complain Box:</h3></div>
					<div class="col-10 col-sm-8 set_input_box">
					
					<f:textarea path="complain"  class="form-control" cols="40" rows="10" style="font-family:Arial;font-size:20px;border-radius:15px;outline:none" placeholder=" Pl give the Full Details of Complain" required="required" />
				
					</div>
				</div>
			
					<div class="col-1 col-sm-1"><f:input type="hidden" path="flag" value="0"/></div>
					<div class="col-1 col-sm-1"><f:input type="hidden" path="reply" value="  "/></div>
					
					
					<div class="col-1 col-sm-1"><f:input type="hidden" path="date" value="<%=date	%>"/></div>
					<div class="col-1 col-sm-1"><f:input type="hidden" path="status" value="pending"/></div>
				
		   		
		   		
		   		
		   		
		   		
		   		<br>
		   		<div class="row">
		   			<div class="col-12 col-sm-12">
		   			<center>
		   			<button class="btn btn-info" type="submit"/>Submit</button>
		   			</center>
		   			</div>
		   		</div>
	<br>
		   			
					</f:form>
	   		</div>


</body>
</html>