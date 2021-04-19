<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Today Menu</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
@keyframes slide {
    0% {
      opacity: 0;
      transform: translateY(70%);
    } 
    100% {
      opacity: 1;
      transform: translateY(0%);
    }
  }
  @-webkit-keyframes slide {
    0% {
      opacity: 0;
      -webkit-transform: translateY(70%);
    } 
    100% {
      opacity: 1;
      -webkit-transform: translateY(0%);
    }
  }
  @media screen and (max-width: 768px) {
    .col-sm-4 {
      text-align: center;
      margin: 25px 0;
    }
    .btn-lg {
      width: 100%;
      margin-bottom: 35px;
    }
  }
  @media screen and (max-width: 480px) {
    .logo {
      font-size: 150px;
    }
  }
    body {
  background-image: url('..//images//body.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 100% 100%;
}
</style>
</head>
<body>
<div style="height:auto;width:auto">
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%-- <%@ include file="header.jsp" %>
<jsp:include page="student_table.jsp"></jsp:include>  --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>
<div class="container">
<div style="height:auto;width:70%;margin-top:5%;margin-left:20%;border:2px solid orange;border-radius:5%" class="bottom_space bg-white">
	<div class="row p-4" style="">
		

		<div class="col-sm-6 col-12 pl-2" style="border:0px solid orange;border-radius:5%;height:auto">
			 <h1>Lunch Menu</h1>
			 
		
			 <c:forEach items="${sessionScope.l1 }" var="i">
			   <textarea cols="30" rows="5" class="form-control" readonly="true">${i.lunchmenu }</textarea>
			   
			   <br><hr>
			    <h1>Lunch Price</h1><input type="text" class="form-control" value="${i.lunchprice }" readonly="true">
			   </c:forEach>
			 
		</div>
		<div class="col-sm-6 col-12 pl-2" style="border:0px solid orange;border-radius:5%;height:auto">
			 <h1>Dinner Menu</h1>
			
			 <c:forEach items="${sessionScope.l2 }" var="i">
			   <textarea cols="30" rows="5" class="form-control" readonly="true">${i.dinnermenu }</textarea>
			   
			    <br><hr>
			    <h1>Dinner Price</h1><input type="text" class="form-control" value="${i.dinnerprice }" readonly="true">
			   </c:forEach>
			
			
    
	   </div>	
	</div><br><br>	<center><a href="applycoupon.html"><button type="button" class="btn btn-success">Apply for coupon</button></a></center><br>
</div>
</div>
</body>
</html>