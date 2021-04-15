<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Food Coupon Status</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="style.css" rel="stylesheet">
</head>

<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<div style="height:auto;width:auto">
<%
	int i=0;
	
%>
<script>

	function fun1(n,m)
	{

		
	var i=document.getElementById("b1");
	var j=document.getElementById("h1");
	
	if(n.value=="approved")
	{
		alert("kk");
		if(j.value==m.value)
			{
		alert("mann");
		<%out.println("location='payfood.html';");%>
		alert(j.value);
			}
	}
	else
	{
		alert("Owner has not approve your request.pl try after some time");
		
	}		

}
	

</script>
<%-- <jsp:include page="header.jsp"></jsp:include>  
<jsp:include page="student_table.jsp"></jsp:include> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>

<div style="border:2px solid orange;border-radius:5%" class="bg-white mx-auto p-5 bottom_space">
	   			
		   			<h2 class="text-center"><b>Food Coupon Status</b></h2>
	   			<hr>
		   				<div class="row">
						    <div class="col-sm-12 col-12">
                                <table class="table table-stripped table-hover table-bordered table-responsive-sm">
                                    <thead class="thead-dark">
                                    <tr>
                                    <th><b>No.</b></th>
									<!-- <th><b>Hostel_id</b></th> -->
									<th><b>No of food coupon</b></th>
									<th><b>Date</b></th>
									<th><b>FoodTime</b></th>
									<th><b>Status</b></th>
									<th><b>Payment</b></th>
                                    </tr>
                                    <tbody>
                                              
       <c:forEach items="${list2 }" var="i">	
			<tr>	
		   	<td><b><%=++i%></b></td>
			<%-- <td><b>${i.hostelid }</b></td> --%>
			<td><b>${i.nooffoodcoupon }</b></td>
			<td><b>${i.date }</b></td>
			<td><b>${i.foodtime}</b></td>
			<td ><b>${i.status}</b></td>
			<td><b><a href="checkpay.html?status=${i.status }&cost=${i.cost}&foodtime=${i.foodtime}"><button  class="btn" >PaY Now</button></a></b></td>
			<input type="hidden" id="h1" value="${i.cost }">
		
			</tr>
			</c:forEach> 
           
                                    </tbody>
							</table>
						</div>
                </div>
            </div>

<%-- <div style="height:auto;width:60%;margin-top:5%;margin-left:30%;border:2px solid orange;border-radius:5%" class="bg-light">
	   			<h2 class="pt-4 text-center "><b>Food Coupon Status</b></h2>
	   			<hr>
		   			<table class="table table-stripped table-hover table-bordered">
		   	<tr class="table-danger">		
		   	<td><b>No.</b></td>
			<td><b>Hostel_id</b></td>
			<td><b>No of food coupon</b></td>
			<td><b>Date</b></td>
			<td><b>FoodTime</b></td>
			<td><b>Status</b></td>
			<td><b>Payment</b></td>
			</tr>
			
			
			 <c:forEach items="${list2 }" var="i">	
			<tr>	
		   	<td><b><%=++i%></b></td>
			<td><b>${i.hostelid }</b></td>
			<td><b>${i.nooffoodcoupon }</b></td>
			<td><b>${i.date }</b></td>
			<td><b>${i.foodtime}</b></td>
			<td ><b>${i.status}</b></td>
			<td><b><a href="checkpay.html?status=${i.status }&cost=${i.cost}&foodtime=${i.foodtime}"><button  class="btn" >PaY Now</button></a></b></td>
			<input type="hidden" id="h1" value="${i.cost }">
		
			</tr>
			</c:forEach> 
			
		   			
		   			
		   			</table>
	   		</div>
</div> --%>

</body>
</html>