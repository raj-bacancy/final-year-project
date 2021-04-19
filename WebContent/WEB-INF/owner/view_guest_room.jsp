<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Availability Of Guest Room</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="style.css" rel="stylesheet">
</head>
<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<div style="height:auto;width:auto">
<% int j=0; 
	int vacancy=0;
%>
<%-- <jsp:include page="header.jsp"></jsp:include>  
<jsp:include page="menu.jsp"></jsp:include> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>

<div style="border:2px solid orange;border-radius:5%" class="bg-white mx-auto p-5 bottom_space">
	   			
		   			<h2 class="text-center"><b>Available Rooms</b></h2>
	   			<hr>
		   				<div class="row">
						    <div class="col-sm-12 col-12">
                                <table id="table_id" class="table table-stripped table-hover table-bordered table-responsive-sm">
                                    <thead class="thead-dark">
                                    <tr>
                                    <th><b>No.</b></th>
									<th><b>Room No</b></th>
									<th><b>Vacancy</b></th>
									<th><b>Allocate Room</b></th>
                                    </tr>
                                    <tbody>
                                              
       <c:forEach items="${list}" var="i">	
			<c:set var="vacancy" value="${i.capacity-i.currentmember}"></c:set>
			<tr>	
		   	<td><b><%=++j%></b></td>
			<td><b>${i.roomno}</b></td>
			<td><b>${vacancy}</b></td>
			<td><b><a href="approvegueststay.html?roomno=${i.roomno}&&currentmember=${i.currentmember}&&capacity=${i.capacity}"><button class="btn btn-success">Allocate</button></a></b></td>
			</tr>
			</c:forEach>	
           
                                    </tbody>
							</table>
						</div>
                </div>
            </div>



<%-- <div style="height:auto;width:60%;margin-top:5%;margin-left:30%;border:2px solid orange;border-radius:5%" class="bg-light">
	   			<h2 class="pt-4 text-center "><b>Availability Of Guest Room</b></h2>
	   			<hr>
		   			<table id="table_id" class="table table-stripped table-hover table-bordered">
		   	<tr class="table-danger">		
		   	<td><b>No.</b></td>
			<td><b>Room No</b></td>
			<td><b>Vacancy</b></td>
			<td><b>Allocate Room</b></td>
			</tr>		
			 <c:forEach items="${list}" var="i">	
			<c:set var="vacancy" value="${i.capacity-i.currentmember}"></c:set>
			<tr>	
		   	<td><b><%=++j%></b></td>
			<td><b>${i.roomno}</b></td>
			<td><b>${vacancy}</b></td>
			<td><b><a href="approvegueststay.html?roomno=${i.roomno}&&currentmember=${i.currentmember}&&capacity=${i.capacity}">Allocate</a></b></td>
			</tr>
			</c:forEach>	   			
		   			</table>
	   		</div>
</div>
 --%>
</body>
</html>