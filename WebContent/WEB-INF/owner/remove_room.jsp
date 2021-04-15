<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove Room</title>
<link href="style.css" rel="stylesheet">


</head>
<body>
<%-- <jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<div class="mx-auto mt-3 box_form mb-5 bg-white">
	   			<h2 class="pt-4 text-center"><b>Remove Room</b></h2>
	   			<hr>
		   			<f:form action="removeroom.html" modelAttribute="add_room_vo" method="get">
						  <div class="row pl-5">
						    <div class="col">
						      <label class="pt-2"><b>Room No</b></label>
						      <f:input type="text" path="roomno" class="form-control" style="width:60%" placeholder="Enter Room No" name="room_no"/>
						    </div>
						  </div>
						  <div class="row pl-5 pb-5">
						    <div class="col">
						  		<f:button type="submit" class="btn btn-primary mt-3">Remove</f:button>
						    </div>
						  </div>	  
					</f:form>
	   		</div>
</body>
</html>