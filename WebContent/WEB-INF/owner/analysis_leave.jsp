<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Food Coupon Details</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="style.css" rel="stylesheet">

</head>
<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<div style="height:auto;width:auto">

<%-- <jsp:include page="header.jsp"></jsp:include>  
<jsp:include page="menu.jsp"></jsp:include> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>
<%int i=0; %>

<div style="border:2px solid orange;border-radius:5%" class="bg-white mx-auto p-5 bottom_space">
	   			
		   			<h2 class="text-center"><b>Leave Applications</b></h2>
	   			<hr>
		   				<div class="row">
						    <div class="col-sm-12 col-12">
                                <table id="table_id" class="table table-stripped table-hover table-bordered table-responsive-sm">
                                    <thead class="thead-dark">
                                    <tr>
                                    <th><b>No.</b></th>
									<th><b>Hostel_id</b></th>
									<th><b>Date From</b></th>
									<th><b>Date To</b></th>
									<th><b>Reason</b></th>
                                    </tr>
                                    <tbody>
                                              
        <c:forEach items="${list}" var="i">	
			<tr>	
		   	<td><b><%=++i%></b></td>
			<td><b><a href="viewprofile.html?hostelid=${i.hostelid}">${i.hostelid}</a></b></td>
			<td><b>${i.datefrom}</b></td>
			<td><b>${i.dateto}</b></td>
			<td><b>${i.reason}</b></td>
			</tr>
			</c:forEach> 
			
           
                                    </tbody>
							</table>
							
						</div>
                </div>
            </div> 




<%-- <div style="height:auto;width:60%;margin-top:5%;margin-left:30%;border:2px solid orange;border-radius:5%" class="bg-light">
	   			<h2 class="pt-4 text-center "><b>Leave Applications</b></h2>
	   			<hr>
		   			<table class="table table-stripped table-hover table-bordered">
		   	<tr class="table-danger">		
		   	<td><b>No.</b></td>
			<td><b>Hostel_id</b></td>
			<td><b>Date From</b></td>
			<td><b>Date To</b></td>
			<td><b>Reason</b></td>
			</tr>
			
			
			 <c:forEach items="${list}" var="i">	
			<tr>	
		   	<td><b><%=++i%></b></td>
			<td><b><a href="viewprofile.html?hostelid=${i.hostelid}">${i.hostelid}</a></b></td>
			<td><b>${i.datefrom}</b></td>
			<td><b>${i.dateto}</b></td>
			<td><b>${i.reason}</b></td>
			</tr>
			</c:forEach> 
			
		   			
		   			
		   			</table>
	   		</div>
</div>
 --%>
</body>
</html>