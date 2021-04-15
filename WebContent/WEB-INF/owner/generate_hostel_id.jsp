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
<%-- <jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>
<div class="mx-auto mt-3 box_form mb-5 bg-white">
	   			<h2 class="pt-4 text-center"><b>Generate Hostel-Id</b></h2>
	   			<hr>
		   			<f:form action="generatehostelid.html" method="get" modelAttribute="generate_hostelid_vo">
						  <div class="row pl-5">
						    <div class="col">
						      <label class="pt-2"><b>Hostel-Id</b></label>
						      <f:input path="hostelid" type="text" class="form-control" style="width:60%" placeholder="Enter Hostel-Id" />
						    </div>
						  </div>
						  <div class="row pl-5">
						    <div class="col">
						      <label class="pt-2"><b>Room No</b></label>
						      <f:input path="roomno" type="text" class="form-control" style="width:60%" placeholder="Enter Room No"/>
						    </div>
						  </div>
						  <div class="row pl-5">
						    <div class="col">
						      <label class="pt-2"><b>Password</b></label>
						       <f:input type="password" path="password" class="form-control" style="width:60%" placeholder="Enter Password" />
						    </div>
						  </div>
						  <div class="row pl-5 pb-5">
						    <div class="col">
						  		<f:button type="submit" class="btn btn-primary mt-3">Generate Hostel-Id</f:button>
						    </div>
						  </div>  
					</f:form>
	   		</div>
</body>
</html>