<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<!-- <style>
	input
	{
		border-radius: 20px;
		padding:10px ; 
		margin:10px 0;
		width:30%;
		border:1px solid #999;
		outline:none;
		
	}



</style> -->
<body>
<%
String hostel_id=(String)session.getAttribute("hostel_id");
int roomno=(Integer)session.getAttribute("roomno");
%>

<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<div class="container mt-5 mb-5 bg-white" style="border:1px solid orange ; border-radius: 5%">
<div class="container text-center">
		<h2 class="pt-3 pb-2"><b><a style="color:  #FF5C20">Hostel</a> Management System</b></h2>
		<hr class="w-100 mx-auto">
	</div>
	
	   			<div style="width:50%;margin-left:25%" class="mt-5">
	   			<h2>Sign Up For Student</h2>
	   			<hr class="mb-5" style="border:1px solid black">
	   			<f:form action="studentregistration.html" method="post" modelAttribute="student_reg" >
					  <div class="row">
					    <div class="col-sm-6 col-6">
					      <label><b>First name</b></label>
					      <f:input path="firstname" class="form-control" placeholder="Enter Your First Name" required="required"/>
					    </div>
					    <div class="col-sm-6 col-6">
					      <label><b>Last Name</b></label>
					      <f:input path="lastname" class="form-control" placeholder="Enter Your Last Name" required="required"/>
					    </div>
					  </div><br>
					  
					  <div class="row mt-2">
					    <div class="col-12 col-sm-12">
					      <label><b>E mail:</b></label>
					      <f:input path="email" type="email" class="form-control" placeholder="Enter Your Email" required="required"/>
					    </div>
					  </div><br>
					  
					  <div class="row">
					    <div class="col-sm-6 col-6">
					      <label><b>Room No</b></label>
					       <f:input type="text"  class="form-control" path="roomno" value="<%=roomno%>" readonly="true"  />
					    </div>
					    <div class="col-sm-6 col-6">
					      <label><b>Hostel Id</b></label>
					     	<f:input type="text" value="<%=hostel_id%>" class="form-control" path="hostelid" readonly="true" />
					    </div>
					  </div><br>
		
					  
					  
					 <div class="row mt-2">
					    <div class="col-12 col-sm-12">
					      <label><b>Phone Number</b></label>
					      <f:input type="tel" pattern="[0-9]{10}" path="phoneno" class="form-control"  placeholder="Phone No" required="required"/>
					    </div>
					  </div>
					  <br>
					  <div class="row mt-2">
					    <div class="col-12 col-sm-12">
					      <label><b>Name of Institute</b></label>
					      <f:input  type="text" path="nameofinstitute" class="form-control" placeholder="College Name/School Name" required="required"/>
					    </div>
					  </div>
					  <br>
					  <div class="row">
					    <div class="col-sm-6 col-6">
					      <label><b>Program</b></label>
					       <f:input type="text" path="program" class="form-control"  placeholder="e.g B Tech" required="required" />
					    </div>
					    <div class="col-sm-6 col-6">
					      <label><b>Field</b></label>
					     	<f:input type="text" path="field" class="form-control"  placeholder="e.g computer engineering"  required="required"/>
					    </div>
					  </div>
					  <br>
					  
					  <div class="row">
					    <div class="col-sm-6 col-6">
					      <label><b>bloodgroup</b></label>
					       <f:input type="text" path="bloodgroup" placeholder="Blood group" class="form-control" required="required" />
					    </div>
					    <div class="col-sm-6 col-6">
					      <label><b>DOB(Date of Birth):</b></label>
					      <!-- <input type="date"  path="dateofbirth" class="form-control" min="01-01-1970" max="2018-12-31"  placeholder="Date Of Birth" required="required"/> -->
					     	 <f:input type="date"  path="dateofbirth" class="form-control" min="1970-01-01" max="2021-01-01"  placeholder="Date Of Birth" required="required"/>
					    </div>
					  </div><br>
					  
					   <div class="row">
					    <div class="col-sm-12 col-12">
					      <label><b>Sex</b></label>
					       <f:select  path="gender" class="form-control" required="required">
						 			<f:option value="">Select Gender</f:option>
						 			<f:option value="male"> Male</f:option>
						 			<f:option value="female">Female</f:option>
						 			<f:option value="other">Other</f:option>
						 	</f:select>
					    </div></div><br>
					  
					    <div class="row">
					    <div class="col-sm-6 col-6">
					      <label><b>Nationality</b></label>
					       <f:input type="text"  path="nationality"  placeholder=" ex. india,uk" class="form-control" required="required" />
					    </div>
					    <div class="col-sm-6 col-6">
					      <label><b>Application Date</b></label>
					     	<f:input type="date"  path="applicationdate" placeholder="Application Date" class="form-control" required="required"/>
					    </div>
					  </div><br>
					  
					  
					   <div class="row">
					    <div class="col-sm-6 col-6">
					      <label><b>Father Name</b></label>
					       <f:input type="text"  path="fathername" placeholder="Father Name" class="form-control" required="required" />
					    </div>
					    <div class="col-sm-6 col-6">
					      <label><b>Father Contact No.</b></label>
					     	<f:input type="tel" pattern="[0-9]{10}"  path="fathercellno"  placeholder="Father Phone No" class="form-control" required="required"/>
					    </div>
					  </div><br>
					  <div class="row mt-2">
					    <div class="col-12 col-sm-12">
					      <label><b>Father Email Id: </b></label>
					      <f:input type="email" path="fatheremailid" class="form-control" placeholder="abc@xyz.com" required="required"/>
					    </div>
					  </div>
					  <br>
					  
					  
					   <div class="row">
					    <div class="col-sm-6 col-6">
					      <label><b>Mother Name</b></label>
					       <f:input type="text"  path="mothername"  placeholder="Mother Name"  class="form-control" required="required" />
					    </div>
					    <div class="col-sm-6 col-6">
					      <label><b>Mother Contact No.</b></label>
					     	<f:input  type="tel" pattern="[0-9]{10}"  path="mothercellno" placeholder="Mother Phone No" class="form-control" required="required"/>
					    </div>
					  </div><br>
					  
					  <div class="row mt-2">
					    <div class="col-12 col-sm-12">
					      <label><b>Permanent Address</b></label>
					      <f:input  type="textarea"  path="address"  placeholder="Address" class="form-control" required="required"/>
					    </div>
					  </div><br>

					  <center><f:button class="btn btn-primary mt-3 mb-5"><b>Sign Up</b></f:button></center>
				</f:form>				
	   </div>
</div>
</body>
</html>