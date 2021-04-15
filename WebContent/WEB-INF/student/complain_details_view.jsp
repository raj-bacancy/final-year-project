<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Complain Details View</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="style.css" rel="stylesheet">
</head>
<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>


<%-- <jsp:include page="header.jsp"></jsp:include>  
<jsp:include page="student_table.jsp"></jsp:include> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>

<div class="mx-auto mt-3 leave_div bg-white">
	   			<h2 class="pt-4 text-center "><b>Complain Reply</b></h2>
	   			<hr>
				<c:forEach items="${list }" var="i">
				<div style="width:80%" class="mx-auto"><textarea class="form-control mb-5" cols="40" rows="10" style="font-family:Arial;font-size:20px;border-radius:15px;outline:none" readonly="readonly" >${i.reply }</textarea></div>	
					
				</c:forEach>  
					</div>
				



</body>
</html>