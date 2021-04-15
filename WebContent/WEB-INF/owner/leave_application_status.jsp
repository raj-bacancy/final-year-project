<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
<%
	int i=0;
%>
<%-- <jsp:include page="header.jsp"></jsp:include>  
<jsp:include page="menu.jsp"></jsp:include> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<div style="border:2px solid orange;border-radius:5%" class="bg-white mx-auto p-5 bottom_space">
	   			
		   			<h2 class="text-center"><b>Leave Request Status</b></h2>
	   			<hr>
		   				<div class="row">
						    <div class="col-sm-12 col-12">
                                <table class="table table-stripped table-hover table-bordered table-responsive-sm">
                                    <thead class="thead-dark">
                                    <tr>
                                    <th><b>No.</b></th>
									<th><b>Leave From:</b></th>
									<th><b>Leave To:</b></th>
									<th><b>Reason For Leave</b></th>
									<th><b>Status</b></th>
                                    </tr>
                                    <tbody>
                                              
       <c:forEach items="${list}" var="l">
			<tr>
				<td><%=++i%></td>
				<td>${l.datefrom}</td>
				<td>${l.dateto}</td>
				<td>${l.reason}</td>
				<td>${l.status}</td>
			</tr>
			</c:forEach>	
           
                                    </tbody>
							</table>
						</div>
                </div>
            </div>




<%-- <div style="height:auto;width:60%;margin-top:5%;margin-left:30%;border:2px solid orange;border-radius:5%" class="bg-light">
	   			<h2 class="pt-4 text-center "><b>Leave Request Status</b></h2>
	   			<hr>
		   			<table class="table table-stripped table-hover table-bordered">
		   	<tr>
			<th><b>No.</b></th>
			<th><b>Leave From:</b></th>
			<th><b>Leave To:</b></th>
			<th><b>Reason For Leave</b></th>
			<th><b>Status</b></th>
			
		</tr>
			<c:forEach items="${list}" var="l">
			<tr>
				<td><%=++i%></td>
				<td>${l.datefrom}</td>
				<td>${l.dateto}</td>
				<td>${l.reason}</td>
				<td>${l.status}</td>
			</tr>
			</c:forEach>
	</table>
</div> --%>
</body>
</html>