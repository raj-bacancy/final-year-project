<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Students Information</title>
</head>
<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<jsp:include page="header.jsp"></jsp:include>  
<jsp:include page="menu.jsp"></jsp:include>
<div class="container">
	<div class="row mt-5" style="margin-left: 20%">
	<c:forEach items="${list}" var="l">
		<div class="col-lg-6 col-md-6 col-12 mb-3" style="border:0px solid black">
				 <div class="card" style="width:auto;border:2px solid orange;border-radius: 5%;background-color:#FBF3F2 ">
				  <center><div><img class="card-img-top mt-3" src="${l.image}" alt="Card image" style="width:150px;height:200px;"></div></center>
				  <div class="card-body">
				    <center><h4 class="card-title">${l.firstname}</h4></center>
				    <p class="card-text"><b>Email-id : ${l.email}</b></p>
				    <p class="card-text"><b>Hostel Id : ${l.hostelid}</b></p>
				    <p class="card-text"><b>Field : ${l.field}</b></p>
				    <p class="card-text"><b>Phone No : ${l.phoneno}</b></p>
				    <center><a href="viewprofile.html?hostelid=${l.hostelid}" class="btn btn-primary"><b>See Profile</b></a></center>
				  </div>
				</div>
		</div>
		</c:forEach>
	</div>
</div>
</body>
</html>