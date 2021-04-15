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
<div class="mx-auto mt-3 leave_div bg-white">
<form method="get" action="checkmesspassword.html">
					<center><div class="row mt-5">
					    <div class="col">
					      <label><h2><b>Set New Password<b></b></h2></label>
					      	<hr><br>
					    </div>
					    
					  </div></center>
					  <div class="row mt-3 ml-5">
					    <div class="col-10 col-sm-6">
					      <label><b>New Password</b></label>
						    <input class="form-control" type="password" name="newpassword" required  placeholder="Enter New Password"> 	
					    </div>				    
					  </div>
					  
					   <div class="row mt-5 ml-5">
					    <div class="col-10 col-sm-6">
					      <label><b>Confirm Password</b></label>
						    <input class="form-control" type="password" name="confirmpassword" required placeholder="Confirm Password"> 	
					    </div>
					  </div>
					  <div class="row ml-5">
					    <div class="col">
					    	<button type="submit" class="btn mt-5 text-white mb-3" style="background-color:#FF5C20">Change Password</button>  	
					    </div>				    
					  </div>
	</form>	
</div>
</section>
</body>