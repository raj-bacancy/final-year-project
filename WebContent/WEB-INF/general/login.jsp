<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>LogIn</title>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
 <style type="text/css">

	.input-box
	{
		border-radius: 20px;
		padding:10px ; 
		margin:10px 0;
		width:90%;
		border:1px solid #999;
		outline:none;
		
	}
  </style>
<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<!-- Log in portion -->
<section>

<div class="container">
	<div class="container text-center">
		<h2 class="pt-3 pb-2"><b>Welcome to <a style="color:  #FF5C20">Hostel</a> Management System</b></h2>
		<hr class="w-100 mx-auto">
	</div>

	 <div class="row mt-5">		
		<div class="col-sm-6 col-12">
			<div class="row">
				<div class="col-sm-12 col-12">
			<h2><b>Log In From Here</b></h2>
				</div>
			
					
					<div class="col-sm-12 col-12 p-2 mt-3">
					
					
						<f:form method="post" modelAttribute="login_vo" action="dashboard.html">
					      <label><b>Select Your Role </b></label><br>
						      <f:select path="person" cssStyle="height:40px; width: 70%">
					      	<f:option value="owner">Owner</f:option>
					      	<f:option value="student">Student</f:option>
					      	<f:option value="mess">Mess</f:option>
					      </f:select>
					 </div>
					  
					 
					
					  <br/>
					  <div class="col-sm-12 col-12 p-2">
					      <label><b>UserName/Hostel Id </b></label>
					      <f:input type="text" class="form-control" placeholder="Enter UserName" path="username" required="true"  cssStyle="width:70%"/>
					  </div><br/>
					  
					<div class="col-sm-12 col-12 p-2">
					      <label><b>Password </b></label>
					      <f:input type="Password" class="form-control" placeholder="Enter Password" path="password" required="true" cssStyle="width:70%"/>
					    
					  </div><br/>
					   
					   <div class="col-sm-5 col-12 p-2">
					<button type="submit" class="btn btn-danger text-white w-100" style="background-color:#FF5C20;">Log In</button>
					</div>
					<div class="col-sm-5 col-12 p-2">
					<a href="selectrole.html"><button type="button" class="btn text-dark w-100"  style="border:2px solid orange">Create New Account</button></a>
				</f:form> 
				</div>
				<div class="col-sm-10 col-12 p-2" >
				<a href="forgetpassword.html">Forget Password?</a>
				</div>
		</div>
	</div>

		<div class="col-sm-6 col-12" style="border:2px solid orange ; border-radius: 5%">
			<div class="p-3	">
			<h2 class="pt-5"><b>About this platform</b></h2><br>
			<p>In current scenario owner has to keep the record of all hosteller on paper which is very difficult to manage, search, update etc. If owner want some data of particular hosteller then it would be very difficult for him/her to find out data and it is also time consuming.</p>
			<p>So this is the platform where owner can store each and every information of hosteller as well as about the hostel with few clicks. This system is designed in favour of the database management which helps them to save rent related data, food management, vacancies of rooms, guest night stay data etc.</p>
			</div>
		</div>

	</div>
</div>

<%-- <div class="container">

	<div class="container text-center">
		<h2 class=" pt-3 pb-2"><b>Welcome to <a style="color:  #FF5C20">Hostel</a> management System</b></h2>
		<hr class="w-100 mx-auto">
	</div>

	 <div class="row mt-2">
		<div class="col-sm-6 col-12">
			<h2><b>Log In Form Here</b></h2>
			<f:form method="post" modelAttribute="login_vo" action="dashboard.html">
					<div class="row mt-4">
					    <div class="col">
					      <label>Select Your Role :</label><br>
						      <f:select path="person" cssStyle="height:70%; width: 70%">
					      	<f:option value="owner">Owner</f:option>
					      	<f:option value="student">Student</f:option>
					      	<f:option value="mess">Mess</f:option>
					      </f:select>
					    </div>
					  </div>
					 
					  <div class="row mt-4">
					    <div class="col">
					      <label>Owner Id :</label>
					      <f:input type="text" class="form-control" placeholder="Enter Owner Id" path="ownerid" cssStyle="width:70%"/>
					    </div>
					  </div>
					  <div class="row mt-2">
					    <div class="col">
					      <label>UserName/Hostel Id :</label>
					      <f:input type="text" class="form-control" placeholder="Enter UserName" path="username"  cssStyle="width:70%"/>
					    </div>
					  </div>
					  <div class="row mt-2">
					    <div class="col">
					      <label>Password :</label>
					      <f:input type="Password" class="form-control" placeholder="Enter Password" path="password"  cssStyle="width:70%"/>
					    </div>
					  </div>
					   
					<button type="submit" class="btn mt-3 text-white" style="background-color:#FF5C20 ; width:25%">Log In</button>
				
					<a href="selectrole.html"><button type="button" class="btn btn-light mt-3 ml-2"  style="width:40%;border:2px solid orange">Create New Account</button></a>
				</f:form> 
				<a href="forgetpassword.html">Forget Password?</a>
		</div>

		<div class="col-lg-6 col-md-6 col-12" style="border:2px solid orange ; border-radius: 5%">
			<div class="ml-5 mt-2">
			<h2 class="pt-5"><b>About this platform</b></h2><br>
			<p>In current scenario owner has to keep the record of all hosteller on paper which is very difficult to manage, search, update etc. If owner want some data of perticular hosteller then it would be very difficult for him/her to find out data and it is also time consuming.</p>
			<p>So this is the platform where owner can store each and every information of hosteller as well as about the hostel with few clicks. This system is designed in favour of the database management which helps them to save rent related data, food management, vacancies of rooms, guest night stay data etc.</p>
			</div>
		</div>

	</div>
</div> --%>
</section>
<!-- Log in portion end -->
</body>
</html>