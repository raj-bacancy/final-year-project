<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Locker</title>
<link href="style.css" rel="stylesheet">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>

</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<%-- <jsp:include page="header.jsp"></jsp:include>
<jsp:include page="student_table.jsp"></jsp:include> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>
<div class="mx-auto mt-3 leave_div bg-white p-3">
	   			<h3 class="pt-4 text-center"><b> My Documents</b></h3>
	   			<hr><br>	   			
					<c:forEach items="${list}" var="l">
						   <a href="${l.link}" target="_blank"><div class="all_form_uniqdiv div_hover" onclick="window.location = '${l.link}'">
						        <div style="width:100%;height:150px;border:0px solid black">
						        <i class="fa fa-file-pdf-o" aria-hidden="true" style="font-size:130px;color:red"></i>
						        </div>
						        <div style="width:100%;height:50px;border:0px solid black">
						            <b>Fee Receipt</b>
						        </div>
						    </div></a><br><br>			  			
				     </c:forEach>
</div>
</body>
</html>