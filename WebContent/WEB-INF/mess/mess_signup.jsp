<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@include file="../general/header.jsp" %>
<div class="container mt-5 mb-5 bg-light" style="border:2px solid orange ; border-radius: 5%">
	   			<div style="width:50%;margin-left:25%" class="mt-5">
	   			<h2>Sign Up For Mess</h2>
	   			<hr class="mb-5" style="border:1px solid orange">
	   			<f:form method="get" action="messregistration.html" modelAttribute="mess_reg_vo" >
					  <div class="row">
					    <div class="col">
					      <label><b>First name</b></label>
					      <f:input path="firstname" class="form-control" placeholder="Enter Your First Name" required="required"/>
					    </div>
					    <div class="col">
					      <label><b>Last Name</b></label>
					      <f:input path="lastname" class="form-control" placeholder="Enter Your Last Name" required="required"/>
					    </div>
					  </div>
					  
					  <div class="row mt-2">
					    <div class="col">
					      <label><b>Mobile No</b></label>
					      <f:input path="mobileno" class="form-control" placeholder="Enter Your Mobile No" required="required"/>
					    </div>
					  </div>
					  
					  <div class="row mt-2">
					    <div class="col">
					      <label><b>Email id</b></label>
					      <f:input path="email" class="form-control" placeholder="Enter Your Email Id" required="required"/>
					    </div>
					  </div>
					  
					   <div class="row mt-2" >
					    <div class="col">
					      <label><b>UserName</b></label>
					      <f:input path="username" class="form-control" placeholder="Enter Your UserName" required="required"/>
					    </div>
					  </div>
					   <div class="row">
					    <div class="col">
					      <label><b>Password</b></label>
					      <f:input path="password" type="password" class="form-control" placeholder="Enter Your Password" required="required"/>
					    </div>
					    <div class="col">
					      <label><b>Confirm Password</b></label>
					      <f:input path="confirmpassword" type="password" class="form-control" placeholder="Confirm Password" required="required"/>
					    </div>
					  </div>
					  <f:button class="btn btn-primary mt-3 mb-5"><b>Sign Up</b></f:button>
				</f:form>
	   </div>
</div>
</body>
</html>