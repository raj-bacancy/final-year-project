<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guest Stay</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="style.css" rel="stylesheet">
</head>
<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%
String hostelid=(String)session.getAttribute("hostel_id");
%>


<%-- <jsp:include page="header.jsp"></jsp:include>  
<jsp:include page="student_table.jsp"></jsp:include> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>

<div class="mx-auto mt-3 leave_div bg-white">
	   			<h2 class="pt-4 text-center"><b>Guests Stay Apply</b></h2>
	   			<hr>
		   			<f:form action="gueststayapplication.html" post="Post" modelAttribute="guest_stay_vo">
		   		<div class="row">
		   			<div class="col-12 col-sm-3 "><h3 class="pl-4">Hostel Id</h3></div>
		   			<div class="col-10 col-sm-5 mb-5 set_input_box"><f:input path="hostelid" type="text" class="form-control" name="hostelid" style="border-radius:7px " value="<%=hostelid%>" readonly="true" /></div>
		   			
		   		</div>
		   		
		   		<div class="row">
		   			<div class="col-12 col-sm-3"><h3 class="pl-4">Date From</h3></div>
		   			<div class="col-10 col-sm-3 set_input_box"><f:input path="datefrom" type="date" class="form-control" id="first_date" style="border-radius:7px " name="date_from" placeholder=" Leave From" required="required" /></div>
		   			<div class="col-12 col-sm-3 leave_to"><h3>Date To</h3></div>
		   			<div class="col-10 col-sm-3 set_input_box"><f:input path="dateto" type="date" class="form-control mr-5" id="second_date" style="border-radius:7px " name="date_to" placeholder=" Leave To" required="required" /></div>
		   		
		   		</div>	
		   		<br>
		   		<div class="row">
		   			<div class="col-12 col-sm-3"><h3 class="pl-4">Check In</h3></div>
		   			<div class="col-10 col-sm-3 set_input_box"><f:input path="checkin" type="time" id="first_time" class="form-control" name="check_in" placeholder=" Check In Time" required="required" /></div>
		   			<div class="col-12 col-sm-3 leave_to"><h3>Check Out</h3></div>
		   			<div class="col-10 col-sm-3 set_input_box"><f:input path="checkout" type="time" class="form-control mr-5" name="check_out" id="second_time" placeholder=" Check Out Time"  onchange="updatetime()" required="required"/></div>
		   		</div>
		   		<br>
		   		<div class="row">
		   			<div class="col-12 col-sm-3"><h3 class="pl-4">No of Guests</h3></div>
		   			<div class="col-10 col-sm-5 mb-5 set_input_box"><f:select class="form-control" id="s1" path="noofguest" name="no_of_guest"><option selected>1</option><option>2</option><option>3</option><option>4</option><option>5</option></f:select></div>
		   			
		   		
		   		</div>
		   		<div class="row">
		   			<div class="col-12 col-sm-3"><h3 class="pl-4">Guest's Room Speciality</h3></div>
		   			<div class="col-10 col-sm-5 mb-5 set_input_box"><f:select path="roomtype" class="form-control" name="option">
					<option>GENERAL</option>
					<option>AC</option>
					<option>AC-FREEZE</option>
					</f:select></div>
		   			
		   		
		   		</div>
		   		<div class="row">
		   			<div class="col-12 col-sm-12">
		   			<center>
		   			<f:button type="submit" class="btn btn-info">Submit</f:button>
		   			</center>
		   			</div>
		   		</div>
	
		   			
					</f:form>
	   		</div>


</body>
</html>