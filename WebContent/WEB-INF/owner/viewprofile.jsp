<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Profile</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="style.css" rel="stylesheet">

<script type="text/javascript">
        function PrintDiv() {
            var divContents = document.getElementById("profile").innerHTML;
            var printWindow = window.open('', '', 'height=400,width=600');
            printWindow.document.write('<html><head><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"><title>Student Profile</title>');
            printWindow.document.write('</head><body >');
            printWindow.document.write(divContents);
            printWindow.document.write('</body></html>');
            printWindow.document.close();
            printWindow.print();
        }
    </script>
</head>
<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>


<%-- <jsp:include page="header.jsp"></jsp:include>  
<jsp:include page="menu.jsp"></jsp:include> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>
<div id="profile" class="mx-auto mt-3 box_content mb-5 bg-white">
		<%-- <center><div class="mt-3"><img src="https://rgpatel7714.s3.amazonaws.com/test_1/PHOTO.jpg" style="heigth:30%;width:20%;opacity:200%"></div></center> --%>
	  <center><table class="information_table" style="margin-right:15%">
	   <c:forEach items="${list }" var="i">
	  
	   <center><div class="mt-3"><img src="${i.image}" style="heigth:30%;width:20%;opacity:200%"></div></center>
	   <center> <tr>
	   <th><p>Name:</p></th><td></td> 
	   <td><p>${i.firstname } ${i.fathername } ${i.lastname } </p></td>
	   </tr>
	   
	   <tr>
	   <th><p>Hostel Id:</p></th><td></td>
	   <td><p>${i.hostelid}</p></td>
	   </tr>
	   <tr>
	   <th><p>Email:</p></th><td></td>
	   <td><p>${i.email }</p></td>
	   </tr>
	   
	   
	   <tr>
		<th><p>Mobile-No:</p></th><td></td>
		<td>${i.phoneno }</td>
		</tr><br>
		
		<tr>
		<th><p>Birth Date:</p></th><td></td>
		<td><p>${i.dateofbirth}</p></td>
		</tr>
	   
	   <tr>
		<th><p>Address:</p></th><td></td>
		<td><p>${i.address }</p></td>
		</tr>
	   <tr>
	   <th><p>Name Of Institute:</p></th><td></td>
	   <td><p>${i.nameofinstitute }</p></td>
	   </tr>
	   
	   <tr>
	   <th><p>Program</p></th><td></td>
	   <td><p>${i.program }</p></td>
	   </tr>
		
		<tr>
		<th><p>Stream:</p></th><td></td>
		<td><p>${i.field }</p></td>
		</tr>	   
		
		<tr>
		<th><p>Father Name:</p></th><td></td>
		<td><p>${i.fathername }</p></td>
		</tr>
		
		<tr>
		<th><p>Father Contact No:</p></th><td></td>
		<td><p>${i.fathercellno }</p></td>
		</tr>
		
		<tr>
		<th><p>Father Email Id:</p></th><td></td>
		<td><p>${i.fatheremailid }</p></td>
		</tr>
		
		<tr>
		<th><p>Mother Name:</p></th><td></td>
		<td><p>${i.mothername }</p></td>
		</tr>
		
		<tr>
		<th><p>Mother Contact No:</p></th><td></td>
		<td><p>${i.mothercellno }</p></td>
		</tr>
		<br>			
		</c:forEach>
	   </table></center><br><br>
	   <center><button onclick="PrintDiv()" class="btn btn-primary">Print</button></center>
	   <div class="mb-5 ml-5"><br><br>
 <h4><b>History Of Student</b></h4><br>
	<x style="color:#007bff"><a href="ownerfeestatus.html?hostelid=${hostelid}">Fee Requests Details</a><br>
	<a href="ownergueststaystatus.html?hostelid=${hostelid}">Guests Night Stay Requests Details</a><br>
	<a href="ownerleaveapplicationstatus_owner.html?hostelid=${hostelid}">Leave Requests Details</a><br>
	<a href="ownerfoodstatus_owner.html?hostelid=${hostelid}">Food Coupon Requests Details</a><br><br></x>
	</div>	
</div>
</body>
</html>