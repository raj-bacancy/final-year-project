<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Room Information</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="style.css" rel="stylesheet">

</head>
<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<% int i=0; %>
<%-- <jsp:include page="header.jsp"></jsp:include>  
<jsp:include page="menu.jsp"></jsp:include> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>

<div style="border:2px solid orange;border-radius:5%" class="bg-white mx-auto p-5 bottom_space">
	   			
		   			<h2 class="text-center"><b>Room Information</b></h2>
	   			<hr>
		   				<div class="row">
						    <div class="col-sm-12 col-12">
                                <table id="table_id" class="table table-stripped table-hover table-bordered table-responsive-sm">
                                    <thead class="thead-dark">
                                    <tr>
                                    <th><b>No.</b></th>
									<th><b>Room No</b></th>
									<th><b>Capacity Of Room</b></th>
									<th><b>Current Member In Room</b></th>
									<th><b>Type Of Room</b></th>
									<th><b>View Room</b></th>
                                    </tr>
                                    <tbody>
                                              
        <c:forEach items="${list}" var="i">	
			<tr>	
		   	<td><b><%=++i%></b></td>
			<td><b>${i.roomno}</b></td>
			<td><b>${i.capacity}</b></td>
			<td><b>${i.currentmember}</b></td>
			<td><b>${i.roomtype}</b></td>
			<td><center><b><a href="viewroom.html?roomno=${i.roomno}"><button class="btn btn-success">view</button></a></b></center></td>
			</tr>
			</c:forEach>
           
                                    </tbody>
							</table>
						</div>
                </div>
            </div>



<%-- <div style="height:auto;width:60%;margin-top:5%;margin-left:30%;border:2px solid orange;border-radius:5%" class="bg-light">
	   			<h2 class="pt-4 text-center "><b>Room Information</b></h2>
	   			<hr>
		   			<table class="table table-stripped table-hover table-bordered">
		   	<tr class="table-danger">		
		   	<td><b>No.</b></td>
			<td><b>Room No</b></td>
			<td><b>Capacity Of Room</b></td>
			<td><b>Current Member In Room</b></td>
			<td><b>Type Of Room</b></td>
			<td><b>View Room</b></td>
			</tr>
			
			
			 <c:forEach items="${list}" var="i">	
			<tr>	
		   	<td><b><%=++i%></b></td>
			<td><b>${i.roomno}</b></td>
			<td><b>${i.capacity}</b></td>
			<td><b>${i.currentmember}</b></td>
			<td><b>${i.roomtype}</b></td>
			<td><center><b><a href="viewroom.html?roomno=${i.roomno}"><button class="btn btn-success">view</button></a></b></center></td>
			</tr>
			</c:forEach>	   			
		   			</table>
	   		</div>
 --%>

</body>
</html>