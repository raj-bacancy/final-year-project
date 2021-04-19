<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Previous Complain Details</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
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

  </style>
 -->
 <link href="style.css" rel="stylesheet">
</head>
<body  >
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>


<%-- <jsp:include page="header.jsp"></jsp:include>  
<jsp:include page="menu.jsp"></jsp:include> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>

<div style="border:2px solid orange;border-radius:5%" class="bg-white mx-auto p-5 bottom_space">
	   			
		   			<h2 class="text-center"><b>Solved Complain Details</b></h2>
	   			<hr>
		   				<div class="row">
						    <div class="col-sm-12 col-12">
                                <table id="table_id" class="table table-stripped table-hover table-bordered table-responsive-sm">
                                    <thead class="thead-dark">
                                    <tr>
                                    <th><b>No.</b></th>
									<th><b>Hostel_id</b></th>
									<th><b>Complain Subject</b></th>
									<th><b>Complain </b></th>
									<th><b>Date</b></th>
									<th><b>Reply</b></th>
                                    </tr>
                                    <tbody>
                                              
        <c:forEach items="${list }" var="i">	
			<tr>	
		   	<td><b>${i.id}</b></td>
			<td><b>${i.hostelid }</b></td>
			<td><b>${i.subject }</b></td>
			<td><b><a style="color:blue" href="view.html?id=${i.hostelid}&date=${i.date}">View Complain</a></b></td>
			<td><b>${i.date}</b></td>
			<td><center><b><a href="reply1.html?id=${i.hostelid}&date=${i.date}"><button class="btn btn-success">Show Reply</button></a></b></center></td>
			
			</tr>
			</c:forEach> 
           
                                    </tbody>
							</table>
							
						</div>
                </div>
            </div> 

<%-- <div style="height:auto;width:60%;margin-top:5%;margin-left:30%;border:2px solid orange;border-radius:5%" class="bg-light">
	   			<h2 class="pt-4 text-center "><b>Solved Complain Details</b></h2>
	   			<hr>
		   			<table class="table table-stripped table-hover table-bordered">
		   	<tr class="table-danger">		
		   	<td><b>No.</b></td>
			<td><b>Hostel_id</b></td>
			<td><b>Complain Subject</b></td>
			<td><b>Complain </b></td>
			<td><b>Date</b></td>
			
			
			<td><b>Reply</b></td>
			</tr>
			
			
			 <c:forEach items="${list }" var="i">	
			<tr>	
		   	<td><b>${i.id}</b></td>
			<td><b>${i.hostelid }</b></td>
			<td><b>${i.subject }</b></td>
			<td><b><a href="view.html?id=${i.hostelid}&date=${i.date}">View Complain</a></b></td>
			<td><b>${i.date}</b></td>
			<td><center><b><a href="reply1.html?id=${i.hostelid}&date=${i.date}"><button class="btn btn-success">Show Reply</button></a></b></center></td>
			
			</tr>
			</c:forEach> 
			
		   			
		   			
		   			</table>
	   		</div>
 --%>

</body>
</html>