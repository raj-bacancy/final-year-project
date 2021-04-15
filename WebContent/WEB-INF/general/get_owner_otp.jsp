<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@include file="new_header.jsp" %>
<section>
<%
	int otp=(Integer)session.getAttribute("otp");
%>
<div class="mx-auto mt-3 leave_div bg-white">
<center><form method="get" action="checkownerotp.html">
					<div class="row mt-5">
					    <div class="col">
					      <label><h2><b>Enter Your OTP Here<b></b></h2></label>
					      	<hr><br>
						    <input type="text" value="<%=otp%>" name="otp" required  placeholder="Enter Your OTP">
						    <br>
					      <h6 class="mt-2">We have sent OTP on your registered email address</h6>
					      <button type="submit" class="btn mt-5 text-white mb-3" style="background-color:#FF5C20">Set New Password</button>
					    	
					    </div>
					    
					  </div>
	</form></center>	
</div>
</section>
</body>