<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" import="java.time.LocalDate"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Food Coupon Apply</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="style.css" rel="stylesheet">
</head>
<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%
	String hostel_id=(String)session.getAttribute("hostel_id");
	System.out.println(hostel_id);

%>	


<%-- <jsp:include page="header.jsp"></jsp:include>  
<jsp:include page="student_table.jsp"></jsp:include> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>
<%   LocalDate date = LocalDate.now(); %>

<div class="mx-auto mt-3 leave_div bg-white">
	   			<h2 class="pt-4 text-center"><b>Food Coupon Apply</b></h2>
	   			<hr>
		   			<f:form action="payfoodcoupon.html"  method="get" modelAttribute="food_coupon">
		   		<div class="row">
		   			<div class="col-12 col-sm-3 "><h3 class="pl-4">Hostel Id:</h3></div>
		   			<div class="col-10 col-sm-5 mb-5 set_input_box"><f:input path="hostelid" type="text" class="form-control" style="width:60%" value="<%=hostel_id %>" readonly="true"/></div>
		   		</div>
		   		
		   		<div class="row">
		   			<div class="col-12 col-sm-3 "><h3 class="pl-4">No of Food Coupons:</h3></div>
		   			<div class="col-10 col-sm-5 mb-5 set_input_box"><f:input type="text" class="form-control"    path="nooffoodcoupon" placeholder=" No of Food Coupon" /></div>
		   		</div>
		   		
		   		<div class="row">
		   			<div class="col-12 col-sm-3 "><h3 class="pl-4">Date </h3></div>
		   			<div class="col-10 col-sm-5 mb-5 set_input_box"><f:input type="text" readonly="true" class="form-control" value="<%=date%>" path="date"/></div>
		   		</div>
		   		
		   		<div class="row">
		   			<div class="col-12 col-sm-3 "><h3 class="pl-4">Lunch/Dinner </h3></div>
		   			<div class="col-10 col-sm-5 mb-5 set_input_box"><f:select class="form-control" path="foodtime">
		   			<f:option value="lunch">Lunch</f:option>
		   			<f:option value="dinner">Dinner</f:option>
		   			<f:option value="both">Both(Lunch/Dinner)</f:option>
		   			</f:select></div>
		   		</div>
		   		<f:input type="hidden" path="status" value="pending"/>
		   		<br>
		   		<div class="row">
		   			<div class="col-12 col-sm-12">
		   			<center>
		   			<button class="btn btn-info">Buy Food Coupons</button>
		   			</center>
		   			</div>
		   		</div>
	<br>
		   			
					</f:form>
	   		</div>

<%-- <div class="mx-auto mt-3 leave_div bg-white">
	   			<h2 class="pt-4 text-center"><b>Food Coupon Apply</b></h2>
	   			<hr>
		   			<f:form action="foodapply.html"  method="get" modelAttribute="food_coupon">
		   		<div class="row">
		   			<div class="col-12 col-sm-3 "><h3 class="pl-4">Hostel Id:</h3></div>
		   			<div class="col-10 col-sm-5 mb-5 set_input_box"><f:input path="hostelid" type="text" class="form-control" style="width:60%" value="<%=hostel_id %>" readonly="true"/></div>
		   		</div>
		   		
		   		<div class="row">
		   			<div class="col-12 col-sm-3 "><h3 class="pl-4">No of Food Coupons:</h3></div>
		   			<div class="col-10 col-sm-5 mb-5 set_input_box"><f:input type="text" class="form-control"    path="nooffoodcoupon" placeholder=" No of Food Coupon" /></div>
		   		</div>
		   		
		   		<div class="row">
		   			<div class="col-12 col-sm-3 "><h3 class="pl-4">Date </h3></div>
		   			<div class="col-10 col-sm-5 mb-5 set_input_box"><f:input type="date"  class="form-control" value="<%=date%>" readonly="readonly"  path="date"/></div>
		   		</div>
		   		
		   		<div class="row">
		   			<div class="col-12 col-sm-3 "><h3 class="pl-4">Lunch/Dinner </h3></div>
		   			<div class="col-10 col-sm-5 mb-5 set_input_box"><f:select class="form-control" path="foodtime">
		   			<f:option value="lunch">Lunch</f:option>
		   			<f:option value="dinner">Dinner</f:option>
		   			<f:option value="both">Both(Lunch/Dinner)</f:option>
		   			</f:select></div>
		   		</div>
		   		<f:input type="hidden" path="status" value="pending"/>
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
	   		</div> --%>

</body>
</html>