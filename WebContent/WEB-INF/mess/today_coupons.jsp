
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" import="java.time.LocalDate"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Today Coupons</title>
</head>
<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%-- <%@ include file="header.jsp" %>
<%@ include  file="mess_table.jsp"%> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>
<%   LocalDate date = LocalDate.now(); %>
<div class="mx-auto mt-3 leave_div bg-white">
	   			
	   			<center><h2 class="mt-3"><b>Today Coupons</b></h2></center>
	   			<hr>
	   			
					  
					  
					  <div class="row">
					 <div class="col-12 col-sm-3"><label><h3 class="pl-4">Date :</h3></label></div><br>
					  	<div class="col-10 col-sm-3 set_input_box">
					      <input path="date" class="form-control" value="<%=date%>" required="required" readonly="true">
					    </div>
					  </div><br>

				<c:forEach items="${list}" var="i">
					 <div class="row">
					 <div class="col-12 col-sm-3"><label><h3 class="pl-4">Today Lunch Coupons</h3></label></div><br>
					  	<div class="col-10 col-sm-3 set_input_box">
					      <input path="date" class="form-control" value="${i.lunch }" required="required" readonly="true">
					    </div>
					  </div><br>
					   <div class="row">
					 <div class="col-12 col-sm-3"><label><h3 class="pl-4">Today Dinner Coupons</h3></label></div><br>
					  	<div class="col-10 col-sm-3 set_input_box">
					      <input path="date" class="form-control" value="${i.dinner }" required="required" readonly="true">
					    </div>
					  </div><br>				
				</c:forEach>
					
					  
					  
					
	   </div>

</body>
</html>