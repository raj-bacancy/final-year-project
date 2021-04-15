<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body><%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<%-- <%@ include file="header.jsp" %>
<%@ include  file="mess_table.jsp"%> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>


<div class="mx-auto mt-3 leave_div bg-white">
	<div class="ml-5 mb-5"><c:forEach items="${list }" var="i"> 
	   			<h1 class="pt-4 mx-auto"><b>Welcome to Mess Portal ${i.username }</b></h1>
	   			<hr>
		   		
<div class="row">
<div class="col-12 col-sm-6"><img src="${i.image}" style="heigth:70%;width:70%;opacity:200%"></div>
<div class="col-12 col-sm-6">
<br><b>Name:${i.firstname }  ${i.lastname }</b> 
<br><br>

<b>Mobile Number: ${i.mobileno }</b><br>
<br>
<b> Email Id:${i.email}</b></div>
</div>	
</c:forEach>
</div>
</div>

 



</body>
</html>