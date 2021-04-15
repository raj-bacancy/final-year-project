<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet">	
</head>
<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@include file="new_header.jsp" %>
<section>

<div class="mx-auto mt-3 leave_div bg-white">
<center><form method="get" action="otp.html">
					<div class="row mt-5">
					    <div class="col">
					      <label><h2><b>I am :<b></b></h2></label>
					      	<hr><br>
						    <select name="role" Style="height:17%; width: 70%">
					      	<option value="owner">Owner</option>
					      	<option value="mess">Mess</option>
					      	<option value="student">Student</option>
					      </select><br>
					      <h6 class="mt-2">We will send this OTP on your registered email address to verify the user...</h6>
					      <button type="submit" class="btn mt-5 text-white btn-success mb-5" style="background-color:#FF5C20">Generate OTP</button>
					    	
					    </div>
					    
					  </div>
	</form></center>	
</div>
</section>
</body>
</html>