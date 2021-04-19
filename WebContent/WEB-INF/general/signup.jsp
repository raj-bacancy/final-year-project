<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SignUp</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style type="text/css">

	.input-box
	{
		border-radius: 20px;
		padding:10px ; 
		margin:10px 0;
		width:80%;
		border:1px solid #999;
		outline:none;
		
	}
  </style>
<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<div class="container text-center">
		<h2 class="pt-3 pb-2"><b><a style="color:  #FF5C20">Hostel</a> Management System</b></h2>
		<hr class="w-100 mx-auto">
	</div>

	
<center><div class="container" style="border:2px solid orange; border-radius: 5%; margin-top: 5%;margin-bottom: 5%;width:50%">
		 <f:form action="main_reg.html" method="get" modelAttribute="reg_vo">
							<h1>Hostel Owner Info</h1><br>
							
							 <f:input  type="text" path="ownername" placeholder=" Owner Name" cssClass="input-box" /><br/> 
							 <f:input type="text" cssClass="input-box" path="username" placeholder="User Name" cssStyle="width: 40%;" />
							
							<f:input type="text" cssClass="input-box pl-3 ml-3"  placeholder=" Mobile Number" path="mobilenumber"  cssStyle="width: 40%;"/>
							<f:input type="email" cssClass="input-box" path="emailid" placeholder="Owner Email Id" />
							
							<center><h1>Hostel Info</h1></center>
							<f:input type="text" cssClass="input-box" path="hostelname" placeholder=" Hostel Name "/>
							<f:textarea cssClass="input-box" rows="4" cols="50" path="hosteladdress" placeholder=" Hostel Address "/><br/>
							<f:input type="text" cssClass="input-box" path="city" placeholder=" City" cssStyle="width: 40%;"/>
							<f:input type="text" cssClass="input-box pl-3 ml-3" path="state" placeholder=" State" cssStyle="width: 40%;" />	<br>
							
							<f:input type="password" class="input-box" path="password" placeholder=" Password" cssStyle="width: 40%;"/>
							<f:input type="password" class="input-box pl-3 ml-3" path="confirmpassword" placeholder=" Confirm Password" cssStyle="width: 40%;" /><br><br>
							<center><input type="submit" class="btn btn-danger" path="submit" style="margin-bottom: 5%;width:30%"></center><br><br>							
						</f:form>
	</div></center> 

</body>
</html>