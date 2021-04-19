<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Photo</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<section>
<%
	session.setAttribute("filetype", "uniqueid");
%>
<div class="container text-center">
		<h2 class="pt-3 pb-2"><b><a style="color:  #FF5C20">Hostel</a> Management System</b></h2>
		<hr class="w-100 mx-auto">
	</div>
<div class="container mt-5 pb-5 bg-white" style="border:2px solid orange ; border-radius:5%">

					<div class="row mt-5">
					    <div class="col">
					     <center><label><h2><b>Upload Your Unique-Id :</b></h2></label></center>
					      	<hr class="w-50 mx-auto" style="border:1px solid black"><br>
								<form action="<%=request.getContextPath()%>/filepath" method="post" enctype="multipart/form-data">
						   			<div class="row mt-4">
									    <div class="col">
									      <label><b>Select Your Doc :</b></label><br>
										     <select class="form-control" name="doctype" cssStyle="height:70%; width: 70%">
									      	<option value="aadharcard">Aadhar Card</option>
									      	<option value="drivinglicence">Driving Licence</option>
									      	<option value="passport">Passport</option>
									      </select>
									    </div>
									    <div class="col">
									      <label><b>Doc No :</b></label>
									      <input type="text" class="form-control" placeholder="Enter Document Number" name="docno"/>
									    </div>
						  			</div>
						   			<div class="row mt-2">
										    <div class="col-12 col-sm-12">
										      <label><b>Photo</b></label>
										      <input class="form-control" type="file" name="doc" ><br>
										    </div>
										    <div class="col-12 col-sm-12">
										 		<button class="btn btn-primary mt-3 mb-5" type="submit"><b>Submit</b></button>
										    </div>
									</div><br>
								</form>
						 </div>
					    
					  </div>
	
</div>
</section>
</body>
</html>