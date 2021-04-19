<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<!-- <link href="../general/style.css" rel="stylesheet"> -->
<link href="style.css" rel="stylesheet">


</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<jsp:include page="new_menu_header.jsp"></jsp:include>
	   		<div style="border:2px solid orange;border-radius:5%" id="info_div" class="bg-light mx-auto">
	   			
		   			
		   				<div class="row">
						    <div class="col-sm-12 col-12">
							<c:forEach items="${list }" var="i"> 
							<!-- section1 -->
							<div class="col-sm-12 col-12">    	 
							<center><h3 class="p-4 text-center"><b> Welcome   ${i.ownername }</b></h3><hr></center>
							</div>
						
						<!-- section2 -->
						<div class="col-sm-12 col-12">
						<center><h5><b><button class="btn btn-danger">General Information</button></b></h5></center><br>
						<b>Mobile Number:    ${i.mobilenumber }</b><br>

						<b> Email Id:      ${i.emailid}</b><br>
						<b>City:   ${i.city}</b> <br>    <b>State:     ${i.state }</b><br>
						<b>hosteladdress:     ${i.hosteladdress }</b>
						</div>
						
						</c:forEach>

						<!-- section3 -->
						<hr/>
						<div class="col-sm-12 col-12">
						<center> <h5><b><button class="btn btn-danger">Hostel Information</button></b></h5></center>
						</div><br>

						<!-- section4 -->
						<div class="col-sm-12 col-12 text-center">
						   	<h5><u>About No. of Rooms</u></h5>
						</div>

							
						  <!-- section5 -->
						  <div class="col-sm-12 col-12">
						  	<div class="row">
						  		<div class="col-sm-4 col-12">
							    	<b>Total no of room = ${noofroom}</b>
							    </div>
							    <div class="col-sm-4 col-12">
							    	<b>No of student's room = ${noofstudentroom}</b>
							    </div>
							    <div class="col-sm-4 col-12">
							    	<b>No of guest's rooms = ${noofguestroom}</b>
							    </div>
							  </div>
						  </div><br/><br/>
						  
						  
						  <!-- section6 -->
						  <div class="col-sm-12 col-12 text-center">
							  <h5><u>About Capacity of Hostel</u></h5>
						  </div>
						  
						  <div class="col-sm-12 col-12">
						  	<div class="row">
						  		<div class="col-sm-4 col-12">
							    	<b>Capacity for students = ${totalcapacity}</b>
							    </div>
							    <div class="col-sm-4 col-12">
							    	<b>No of students in hostel  = ${totalmamber}</b>
							    </div>
							    <div class="col-sm-4 col-12">
							    	<b>Vacancy in hostel = ${vacancy}</b>
							    </div>
							  </div>
						  </div><br/>
						 
						  
						  
						   
					
	   		</div>
</body>
</html>