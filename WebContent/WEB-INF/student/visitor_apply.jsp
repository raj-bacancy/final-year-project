	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" import="java.time.LocalDate"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Visitors Apply</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="style.css" rel="stylesheet">
</head>
<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%
	String hostel_id=(String)session.getAttribute("hostel_id");

%>	
<div style="height:auto;width:auto">

<%-- <jsp:include page="header.jsp"></jsp:include>  
<jsp:include page="student_table.jsp"></jsp:include> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>
<%   LocalDate date = LocalDate.now(); %>
<div class="mx-auto mt-3 leave_div bg-white">
	   			<h2 class="pt-4 text-center"><b>Visitors Apply</b></h2>
	   			<hr>
		   			<f:form action="visitorapply.html"  method="get" modelAttribute="visitors">
		   		<div class="row">
		   			<div class="col-12 col-sm-4 "><h3 class="pl-4">Hostel Id:</h3></div>
		   			<div class="col-10 col-sm-5 mb-5 set_input_box"><f:input path="hostelid" type="text" class="form-control" style="width:60%" value="<%=hostel_id %>" readonly="true"/></div>
		   			
		   		</div>
		   		
		   		<div class="row">
		   			<div class="col-12 col-sm-4 "><h3 class="pl-4">Visitor Name: </h3></div>
		   			<div class="col-10 col-sm-5 mb-5 set_input_box"><f:input type="text"  class="form-control"  required="required"  path="visitorname"/></div>
		   			
		   		</div>
		   		
		   		<div class="row">
		   			<div class="col-12 col-sm-4 "><h3 class="pl-4">Visitor mobile no: </h3></div>
		   			<div class="col-10 col-sm-5 mb-5 set_input_box"><f:input type="text"  class="form-control" required="required"  path="visitormobileno"/></div>
		   			
		   		</div>
		   		<div class="row">
		   			<div class="col-12 col-sm-4 "><h3 class="pl-4">Visitor email id: </h3></div>
		   			<div class="col-10 col-sm-5 mb-5 set_input_box"><f:input type="text"  class="form-control" required="required"  path="visitoremailid"/></div>
		   			
		   		</div>
		   		
		   		
		   		<div class="row">
		   			<div class="col-12 col-sm-4 "><h3 class="pl-4">Date:</h3></div>
		   			<div class="col-10 col-sm-5 mb-5 set_input_box"><f:input type="date"  class="form-control"   path="date"/></div>
		   			
		   		</div>
		   		
		   		<div class="row">
		   			<div class="col-12 col-sm-3 "><h3 class="pl-4">Check In :</h3></div>
		   			<div class="col-10 col-sm-3 set_input_box"><f:input type="time" class="form-control"    path="checkin" placeholder=" Check In Time " /></div>
		   			<div class="col-12 col-sm-3 leave_to"><h3 class="pl-4">Check out:</h3></div>
		   			<div class="col-10 col-sm-3 set_input_box"><f:input type="time" class="form-control"    path="checkout" placeholder=" Check Out Time " /></div>
		   		</div>
		   		
		   		
		   		
		   		

		   		<br>
		   		<div class="row">
		   			<div class="col-12 col-sm-12">
		   			<center>
		   			<button class="btn btn-info">Submit</button>
		   			</center>
		   			</div>
		   		</div>
	<br>
		   			
					</f:form>
	   		</div>
</div>

</body>
</html>