<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LogIn or SignUp</title>
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
<%@include file="header.jsp" %>
<!-- Log in portion -->
<section>

<div class="container">

	<div class="container text-center">
		<h2 class=" pt-3 pb-2"><b>Welcome to <a style="color:  #FF5C20">Hostel</a> management System</b></h2>
		<hr class="w-100 mx-auto">
	</div>

	 <div class="row mt-2">
		<div class="col-sm-6 col-12">
			<h2><b>Log In Form Here</b></h2>
			<form method="Post"action="main_login.html">
					<div class="row mt-4">
					    <div class="col">
					      <label>Select Your Role :</label><br>
						      <select path="person" cssStyle="height:70%; width: 70%">
					      	<option value="owner">Owner</option>
					      	<option value="student">Student</option>
					      	<option value="mess">Mess</option>
					      </select>
					    </div>
					  </div>
					  <div class="row mt-4">
					    <div class="col">
					      <label>Owner Id :</label>
					      <input type="text" class="form-control" placeholder="Enter Owner Id" path="ownerid" cssStyle="width:70%">
					    </div>
					  </div>
					  <div class="row mt-2">
					    <div class="col">
					      <label>UserName :</label>
					      <input type="text" class="form-control" placeholder="Enter UserName" path="username"  cssStyle="width:70%">
					    </div>
					  </div>
					  <div class="row mt-2">
					    <div class="col">
					      <label>Password :</label>
					      <input type="Password" class="form-control" placeholder="Enter Password" path="password"  cssStyle="width:70%">
					    </div>
					  </div>
					   
					<button type="submit" class="btn mt-3 text-white" style="background-color:#FF5C20 ; width:25%">Log In</button>
					<button type="button" class="btn btn-light mt-3 ml-2" data-toggle="modal" data-target="#mymodal" style="width:30%;border:2px solid orange">Create New Hostel</button>
				</form> 

				<div class="modal fade" id="mymodal" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header" style="background-color: #FF5C20">
						<h3 class="modal-title">Sign-Up</h3>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body" style="padding-left: 10% ; background-color: #CFF3F7">
						<f:form action="main_reg.html" post="Post"  modelAttribute="r">
							<center><h2>Hostel Owner Info</h2></center>
							 
							 <f:input  type="text" path="ownername" placeholder=" Owner Name" cssClass="input-box" ></f:input> 
							 <f:input type="text" cssClass="input-box" path="username" placeholder="User Name" cssStyle="width: 45%;" />
							
							<f:input type="text" cssClass="input-box pl-3 ml-3"  placeholder=" Mobile Number" path="mobilenumber"  cssStyle="width: 45%;"/>
							<f:input type="email" cssClass="input-box" path="emailid" placeholder="Owner Email Id" />
							
							<center><h2>Hostel Info</h2></center>
							<f:input type="text" cssClass="input-box" path="hostelname" placeholder=" Hostel Name "/>
							<f:textarea cssClass="input-box" rows="4" cols="50" path="hosteladdress" placeholder=" Hostel Address "/>
							<f:input type="text" cssClass="input-box" path="city" placeholder=" City" cssStyle="width: 45%;"/>
							<f:input type="text" cssClass="input-box pl-3 ml-3" path="state" placeholder=" State" cssStyle="width: 45%;" />	
							
							<f:input type="password" cssClass="input-box" path="password" placeholder=" Password" cssStyle="width: 45%;"/>
							<f:input type="password" cssClass="input-box pl-3 ml-3" path="confirmpassword" placeholder=" Confirm Password" cssStyle="width: 45%;" />
							<center><input type="submit" cssClass="btn btn-danger" path="submit" cssStyle="margin-right: 10%"></center>
							 
							
						</f:form>
					</div>
					<div class="modal-footer" style="background-color:#f4511e ">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
			

		</div>

		<div class="col-lg-6 col-md-6 col-12" style="border:2px solid orange ; border-radius: 5%">
			<div class="ml-5 mt-2">
			<h2 class="pt-5"><b>About this platform</b></h2><br>
			<p>In current scenario owner has to keep the record of all hosteller on paper which is very difficult to manage, search, update etc. If owner want some data of perticular hosteller then it would be very difficult for him/her to find out data and it is also time consuming.</p>
			<p>So this is the platform where owner can store each and every information of hosteller as well as about the hostel with few clicks. This system is designed in favour of the database management which helps them to save rent related data, food management, vacancies of rooms, guest night stay data etc.</p>
			</div>
		</div>

	</div>
</div>
</section>
<!-- Log in portion end -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>