<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Student Information</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="style.css" rel="stylesheet">

<!-- Script for data table -->
	<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script> -->
</head>

<!-- <script>
    $(document).ready(function () {
        $('#table_id').DataTable();
    });
</script> -->

<body >
<%int a=0;
int startpoint=(Integer)session.getAttribute("startpoint");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%-- <jsp:include page="header.jsp"></jsp:include>  
<jsp:include page="menu.jsp"></jsp:include> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>

<div style="border:2px solid orange;border-radius:5%" class="bg-white mx-auto p-5">
	   			
		   			
		   				<div class="row">
						    <div class="col-sm-12 col-12">
                                <table id="table_id" class="table table-stripped table-hover table-bordered table-responsive-sm">
                                    <thead class="thead-dark">
                                    <tr>
                                    <th><b>No.</b></th>
                                    <th><b>Hostelid</b></th>
                                    <th><b>Name</b></th>
                                    <th><b>Room No</b></th>
                                    <th><b>View</b></th>
                                    </tr>
                                    <tbody>
                                              
      <c:forEach items="${data }" var="i">	
			<tr class="table">	
		   	<td><b><%=++a %></b></td>
			<td><b>${i.hostelid}</b></td>
			<td><b> ${i.lastname }   ${i.firstname }  ${i.fathername}</b></td>
			<td><b>${i.roomno }</b></td>
			<td><b style="color:blue"><a href="viewprofile.html?hostelid=${i.hostelid}">View Profile</a></b></td>

			</tr>
			</c:forEach> 		   			

           
                                    </tbody>
					</table>		
						</div>
                </div>
            </div>

<%-- <div class="mx-auto mt-3 box_form mb-5 bg-white">
	   			<h2 class="pt-4 text-center "><b>Student Details</b></h2>
	   			<hr>
		   			<table class="table table-stripped table-hover table-bordered table-responsive">
		   	<tr class="table-danger">		
		   	<td><b>No.</b></td>
			<td><b>Hostelid</b></td>
			<td><b>Name</b></td>
			<td><b>Room No</b></td>
			<td><b>View</b></td>
			
			</tr>
			
			
			 <c:forEach items="${data }" var="i">	
			<tr>	
		   	<td><b><%=++a %></b></td>
			<td><b>${i.hostelid}</b></td>
			<td><b> ${i.lastname }   ${i.firstname }  ${i.fathername}</b></td>
			<td><b>${i.roomno }</b></td>
			<td><b><a href="viewprofile.html?hostelid=${i.hostelid}">View Profile</a></b></td>

			</tr>
			</c:forEach> 		   			
		   			</table>
		   			<a href="viewstudent.html?start=<%=startpoint%>" class="ml-5"><b>Next</b></a>
	   		</div>
</div> --%>


</body>
</html>