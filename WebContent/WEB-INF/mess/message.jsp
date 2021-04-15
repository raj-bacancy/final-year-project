
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" import="java.time.LocalDate"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Message For Student</title>
</head>
<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%-- <%@ include file="header.jsp" %>
<%@ include  file="mess_table.jsp"%> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>

<div class="mx-auto mt-3 leave_div bg-white">
	   			
	   			<center><h2 class="mt-3">Message</h2></center>
	   			<hr>
	   			<form method="get" action="message1.html"  >
					  
					  
					  <div class="row">
					 <div class="col-12 col-sm-3"><label><h3 class="pl-4">Subject :</h3></label></div><br>
					  	<div class="col-10 col-sm-8 set_input_box">
					      <input type="text" name="subject" class="form-control" placeholder="Subject" required="required"/>
					    </div>
					  </div><br>
					  <div class="row">
					
						<div class="col-12 col-sm-3"><h3 class="pl-4">Message :</h3></div><br>
						<div class="col-10 col-sm-8 set_input_box">
						
						<textarea name="message"  class="form-control" cols="40" rows="7" style="font-family:Arial;font-size:20px;border-radius:15px;outline:none" placeholder=" Message for Students " required="required" ></textarea>
					
						</div>
					  </div><br>
					
					  
					  
					 
					  <center><button class="btn btn-primary mt-3 mb-5" type="submit"><b>Submit</b></button></center>
				</form>
	   </div>

</body>
</html>