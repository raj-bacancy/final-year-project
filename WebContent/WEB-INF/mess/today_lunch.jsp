
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" import="java.time.LocalDate"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Today Lunch</title>
</head>
<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%-- <%@ include file="header.jsp" %>
<%@ include  file="mess_table.jsp"%> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>
<%   LocalDate date = LocalDate.now(); %>
<div class="mx-auto mt-3 leave_div bg-white">
	   			
	   			<center><h2 class="mt-3"><b>Today Lunch</b></h2></center>
	   			<hr>
	   			<f:form method="get" action="foodlunch.html" modelAttribute="food_lunch" >
					  
					  
					  <div class="row">
					 <div class="col-12 col-sm-3"><label><h3 class="pl-4">Date :</h3></label></div><br>
					  	<div class="col-10 col-sm-3 set_input_box">
					      <f:input path="date" class="form-control" value="<%=date%>" required="required" readonly="true"/>
					    </div>
					  </div><br>
					  <div class="row">
					
						<div class="col-12 col-sm-3"><h3 class="pl-4">Lunch Menu :</h3></div><br>
						<div class="col-10 col-sm-8 set_input_box">
						
						<f:textarea path="lunchmenu"  class="form-control" cols="40" rows="7" style="font-family:Arial;font-size:20px;border-radius:15px;outline:none" placeholder=" Today Lunch Menu " required="required" />
					
						</div>
					  </div><br>
					  <div class="row">
					  <div class="col-12 col-sm-3"><label><h3 class="pl-4">Lunch Price:</h3></label></div><br>
					  	<div class="col-10 col-sm-3 set_input_box">
							  	
					  	<f:input path="lunchprice" class="form-control" placeholder=" lunch price" required="required"/>
					  	</div>
					  </div><br>
					  
					  
					  
					 <f:input type="hidden" path="username" value="p"/>
					  <center><f:button class="btn btn-primary mt-3 mb-5" type="submit"><b>Submit</b></f:button></center>
				</f:form>
	   </div>

</body>
</html>s