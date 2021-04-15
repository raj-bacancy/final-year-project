<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Generate Hostel Id</title>
<link href="style.css" rel="stylesheet">

</head>
<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%-- <jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>
<div class="mx-auto mt-3 box_form mb-5 bg-white">
	   			<h2 class="pt-4 text-center"><b>Attendance</b></h2>
	   			<hr>
		   			<form action="makeattendance.html" method="get">
						  <div class="row pl-5">
						    <div class="col">
						      <label class="pt-2"><b>Today's Date</b></label>
						      <input name="date" value="${date}" type="text" class="form-control" style="width:60%" readonly>
						    </div>
						  </div>
						  <div class="row pl-5">
						    <div class="col">
						      <label class="pt-2"><b>Room no</b></label>
						      <input name="roomno" type="text" class="form-control" style="width:60%" placeholder="Enter Roomno" required>
						    </div>
						  </div>
						   <div class="row pl-5 pb-5">
						    <div class="col">
						  		<button type="submit" class="btn btn-primary mt-3"><b>Get Students</b></button>
						    </div>
						    <div class="col pt-4" style="margin-right:40%">
						  		<a href="getabsent.html"><b><u>Get Absent Students</u></b></a>
						    </div>
						  </div>  						  
					</form>
	   		</div>
</body>
</html>