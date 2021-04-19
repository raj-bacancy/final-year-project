<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Food Analysis</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="style.css" rel="stylesheet">
</head>
<body>

<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>


<%-- <jsp:include page="header.jsp"></jsp:include>  
<jsp:include page="menu.jsp"></jsp:include> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>
<%int a=0; 
int year = Calendar.getInstance().get(Calendar.YEAR);
%>

<div style="border:2px solid orange;border-radius:5%" class="bg-white mx-auto p-5 bottom_space">
	   			
		   			<h2 class="text-center"><b>List Of Student(Fee-Unpaid)</b></h2>
	   			<hr>
		   				<div class="row">
						    <div class="col-sm-12 col-12">
                                <table id="table_id" class="table table-stripped table-hover table-bordered table-responsive-sm">
                                    <thead class="thead-dark">
                                    <tr>
                                    <th><b>No.</b></th>
									<th><b>Hostel Id</b></th>
									<th><b>Year</b></th>
									<!-- <th><b>Fee Receipt</b></th> -->
                                    </tr>
                                    <tbody>
                                              
        <c:forEach items="${list}" var="i">	
			<tr>	
		   	<td><b><%=++a %></b></td>
			<td><b><a href="viewprofile.html?hostelid=${i}">${i}</a></b></td>
			<td><b><%=year%></b></td>
			<%-- <td><b><a style="color:blue" href="viewprofile.html?hostelid=${i}">View</a></b></td> --%>
			</tr>
			</c:forEach>  	
           
                                    </tbody>
							</table>
							<a href="getfeegraph.html" class="ml-5"><b><button class="btn btn-danger">Get Graphical Representation</button></b></a>
						</div>
                </div>
            </div> 
<%-- <div style="height:auto;width:60%;margin-top:5%;margin-left:30%;border:2px solid orange;border-radius:5%" class="bg-light">
	   			<h2 class="pt-4 text-center "><b>List Of Student(unpaid)</b></h2>
	   			<hr>
		   			<table class="table table-stripped table-hover table-bordered">
		   	<tr class="table-danger">		
		   	<td><b>No.</b></td>
			<td><b>Hostel Id</b></td>
			<td><b>Year</b></td>
			<td><b>View Profile</b></td>
			</tr>
			
			
			 <c:forEach items="${list}" var="i">	
			<tr>	
		   	<td><b><%=++a %></b></td>
			<td><b><a href="viewprofile.html?hostelid=${i}">${i}</a></b></td>
			<td><b><%=year%></b></td>
			<td><b><a href="viewprofile.html?hostelid=${i}">View</a></b></td>
			</tr>
			</c:forEach> 		   			
		   </table>
		   <a href="getfeegraph.html" class="ml-5"><b>Get Graph</b></a>
	   		</div>
</div> --%>


</body>
</html>