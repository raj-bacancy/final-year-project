<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" import="java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>leave application</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="style.css" rel="stylesheet">
<script>
function updatedate()
{
	var firstdate = document.getElementById("first_date").value;
    document.getElementById("second_date").min = firstdate;
}
function updatetime()
{
	var firstdate = document.getElementById("first_date").value;
	var seconddate = document.getElementById("second_date").value;
	if(firstdate==seconddate)
	{
		var firsttime = document.getElementById("first_time").value;
    	document.getElementById("second_time").min = firsttime;
	}
}

</script>
</head>
<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%
	String hostel_id=(String)session.getAttribute("hostel_id");
SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
String d=f.format(new Date());

%>


<%-- <jsp:include page="header.jsp"></jsp:include>  
<jsp:include page="student_table.jsp"></jsp:include> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>

<div class="mx-auto mt-3 leave_div bg-white">
	   			<h2 class="pt-4 text-center"><b>Leave Application Apply</b></h2>
	   			<hr>
		   			<f:form action="leaveapplicationapply.html" method="get" modelAttribute="leave_application">
		   		<div class="row">
		   			<div class="col-12 col-sm-3 "><h3 class="pl-4">Hostel Id</h3></div> 
		   			<div class="col-10 col-sm-5 mb-5 set_input_box"><f:input readonly="true" path="hostelid" type="text" class="form-control" name="hostelid" style="border-radius:7px " value="<%=hostel_id %>"  /></div>
		   			
		   		</div>
		   		
		   		<div class="row">
		   			<div class="col-12 col-sm-3"><h3 class="pl-4">Leave From:</h3></div>
		   			<div class="col-10 col-sm-3 set_input_box"><f:input type="date" min="<%=d%>" path="datefrom" id="first_date" class="form-control" placeholder=" Leave From" required="required" /></td><td></div>
		   			<div class="col-12 col-sm-3 leave_to"><h3>Leave To:</h3></div>
		   			<div class="col-10 col-sm-3 set_input_box"><f:input path="dateto" type="date" id="second_date" onchange="updatedate()" class="form-control" name="date_to" placeholder=" Leave To" required="required" /></div>
		   		
		   		</div>	
		   		<br>
		   		
				<div class="row">
					
					<div class="col-12 col-sm-3"><h3 class="pl-4">Reason for Leave:</h3></div>
					<div class="col-10 col-sm-9 set_input_box">
					
					<f:textarea path="reason" rows="6" cols="40" class="form-control" placeholder="Valid Reason for leave Application" name="reason" required="required" /></textarea>
					</div>
				
		   		
		   		</div>
		   		<br><br>
		   		<div class="row">
		   			<div class="col-12 col-sm-12">
		   			<center>
		   			<f:button type="submit" class="btn btn-info">Apply</f:button>
		   			</center>
		   			</div>
		   		</div>
	
		   			
					</f:form>
	   		</div>


</body>
</html>