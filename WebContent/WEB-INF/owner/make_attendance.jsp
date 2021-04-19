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
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%-- <jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>
<div class="mx-auto mt-3 box_form mb-5 bg-white">
	   			<h2 class="pt-4 text-center"><b>Make Attendance</b></h2>
	   			<hr>
		   			<form action="present.html" method="get">							
							   <div class="row pl-5 pb-3 pt-3">
							    <div class="col">
							    <c:forEach items="${list}" var="l">	
							  		<center><input type="checkbox" name="hostelid" value="${l.hostelid}">
							  		<label class="pt-2"><b><a style="color:blue" href="viewprofile.html?hostelid=${l.hostelid}">${l.hostelid}</a></b></label><br></center>
								</c:forEach>
							    </div>
							  </div>  		
						  
						   <div class="row pl-5 pb-5">
							    <div class="col">
							  		<center><button type="submit" class="btn btn-primary mt-3">Make Present</button></center>
							    </div>
							  </div>				  
					</form>
	   		</div>
</body>
</html>