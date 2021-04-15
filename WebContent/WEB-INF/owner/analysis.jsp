<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Analysis</title>
<link href="style.css" rel="stylesheet">

</head>
<body>
<%-- <jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>
<div class="mx-auto mt-3 box_form mb-5 bg-white">
	   			<h2 class="pt-4 text-center"><b>Analysis</b></h2>
	   			<hr>
		   			<form action="analysis.html">
						  <div class="row pl-5">
						    <div class="col">
						      <select name="option" style="height:150%; width: 60%">
						      	<option selected disabled hidden>---Choose an option---</option>
						      	<option value="fee-paid">Fees-Paid</option>
						      	<option value="fee-unpaid">Fees-Unpaid</option>
								<!-- <option value="fee-unpaid">Fees-Unpaid</option> -->
								<option value="food">Food Analysis</option>
								<option value="leave">Leave Analysis</option>
								<option value="gueststay">Guest Night Stay Analysis</option>
						      </select>
						    </div>
						  </div>
						  <div class="row pl-5 pb-5">
						    <div class="col pt-3">
						  		<button class="btn btn-primary mt-3">Go</button>
						    </div>
						  </div>	  
					</form>
	   		</div>
</body>
</html>