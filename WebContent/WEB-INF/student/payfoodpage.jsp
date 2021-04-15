<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

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

  </style>

</head>

<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<div style="height:auto;width:auto">

<jsp:include page="header.jsp"></jsp:include>  
<jsp:include page="student_table.jsp"></jsp:include>

<div style="height:auto;width:60%;margin-top:5%;margin-left:30%;border:2px solid orange;border-radius:5%" class="bg-light">
	   			<h2 class="pt-4 text-center"><b>Pay Money</b></h2>
	   			<hr>

<c:forEach items="${ listfood}" var="i">
<center>
<form action="<%=request.getContextPath() %>/myServlet"  name="payuform" method=POST >
<input type="hidden" name="key"value="VqML8YYB" />
<input type="hidden" name="hash_string" value="" />
<input type="hidden" name="hash" />
<input type="hidden" name="txnid"/>

				
				<div class="row">
		   			<div class="col-3 col-sm-3 "><h3 class="pl-4">Amount:</h3></div>
		   			<div class="col-5 col-sm-5 mb-5"><input class="form-control" name="amount" value="<%=session.getAttribute("costs") %>" readonly="readonly" /></div>
		   			<div class="col-4 col-sm-4"></div>
		   		</div>
		   		
		   			
				<div class="row">
		   			<div class="col-3 col-sm-3 "><h3 class="pl-4">First Name:</h3></div>
		   			<div class="col-5 col-sm-5 mb-5"><input class="form-control" name="firstname" id="firstname" value="${i.firstname }" readonly="readonly"/></div>
		   			<div class="col-4 col-sm-4"></div>
		   		</div>
		   		
		   		
				<div class="row">
		   			<div class="col-3 col-sm-3 "><h3 class="pl-4">Email-Id:</h3></div>
		   			<div class="col-5 col-sm-5 mb-5"><input class="form-control" name="email" id="email" value="${i.email }" readonly="readonly"  /></div>
		   			<div class="col-4 col-sm-4"></div>
		   		</div>

		   		
		   			
				<div class="row">
		   			<div class="col-3 col-sm-3 "><h3 class="pl-4">Phone:</h3></div>
		   			<div class="col-5 col-sm-5 mb-5"><input class="form-control" name="phone" value="${i.phoneno }" readonly="readonly" /></div>
		   			<div class="col-4 col-sm-4"></div>
		   		</div>

		   			
				<div class="row">
		   			<div class="col-3 col-sm-3 "><h3 class="pl-4">Food Time:</h3></div>
		   			<div class="col-5 col-sm-5 mb-5"><textarea class="form-control" name="productinfo" value="" readonly="readonly">  <%=session.getAttribute("foodtime") %></textarea></div>
		   			<div class="col-4 col-sm-4"></div>
		   		</div>




<input type="hidden" name="surl" value="https://www.google.com/" size="64"  />

<input type="hidden" name="furl" value="https://www.google.com/" size="64" />



<input type="hidden" name="service_provider" value="payu_paisa" />



<button class="btn btn-success" type="submit" >Pay Now</button>
 


</form>
<br>
<a href="foodcoupon.html"><button class="btn btn-danger" > Go Back</button></a>
</center>
</c:forEach>
</div></div>
</body>
</html>