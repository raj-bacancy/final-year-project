<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Room</title>
<link href="style.css" rel="stylesheet">

</head>
<script>
function fun()
{
	var s1=document.getElementById('i1').value;	
		if(s1=='student room')
		{
			 i2.style.display="none";
		}
		else if(s1=='guest room')
		{
			 i2.style.display="";
			 
		}
}
function check(){
	var roomno=document.getElementById('roomno').value;
	var capacity=document.getElementById('capacity').value;
	var roomtype=document.getElementById('i1').value;	
	var speciality=document.getElementById('speciality').value;	
	
	if(roomtype=='---Choose an option---'){
		document.getElementById('i1').style.border='2px solid red'
		//document.getElementById('roomtype_error').style.display=''
		return false;
	}else{
		document.getElementById('i1').style.border='1px solid black'
	}
	if(speciality=='---Choose an option---'&&roomtype=="guest room"){
		document.getElementById('speciality').style.border='2px solid red'
		//document.getElementById('speciality_error').style.display=''
		return false;
	}else{
		document.getElementById('speciality').style.border='1px solid black'
	}
	if(roomno==0 || roomno==null){
		document.getElementById('roomno_error').style.display=''
		return false;
	}else{
		document.getElementById('roomno_error').style.display='none'
	}
	if(capacity==0 || capacity==null){
		document.getElementById('capacity_error').style.display=''
		return false;
	}else{
		document.getElementById('capacity_error').style.display='none'	
	}
	
}
</script>
<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%-- <jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>
<div class="mx-auto mt-3 box_form mb-5 bg-white">
	   			<h2 class="pt-4 text-center"><b>Add Room</b></h2>
	   			<hr>
		   			<f:form action="insertroomdata.html" modelAttribute="add_room_vo" post="Post">
						  <div class="row pl-5">
						    <div class="col">
						      <label><b>Room Type</b></label><br>
						      <f:select path="roomtype" style="height:70%; width: 60%" onchange="fun()" id="i1">
						      	<option selected disabled hidden>---Choose an option---</option>
						      	<option value="student room">Student's Room</option>
						      	<option value="guest room">Guest's Room</option>
						      </f:select>
						      <span id="roomtype_error" style="display:none;color:red" >select room type</span>
						    </div>
						  </div>
						  <div class="row pl-5 pt-4" id="i2">
						    <div class="col">
						      <label><b>Speciality</b></label><br>
						      <f:select path="speciality" style="height:70%; width: 60%" id="speciality">
						      	<option selected disabled hidden>---Choose an option---</option>
						      	<option value="general">General</option>
						      	<option value="ac">Ac</option>
						      	<option value="ac-freeze">Ac-Freeze</option>
						      </f:select>
						    </div>
						  </div>
						  <div class="row pl-5 pt-4">
						    <div class="col">
						      <label class="pt-2"><b>Room No</b></label>
						      <f:input path="roomno" id="roomno" type="number" class="form-control" style="width:60%" placeholder="Enter Room No" name="room_no" />
						      <span id="roomno_error" style="display:none;color:red" >Enter correct room no</span>
						    </div>
						  </div>
						  <div class="row pl-5">
						    <div class="col">
						      <label class="pt-2"><b>Capacity</b></label>
						      <f:input path="capacity" id="capacity" type="number" class="form-control" style="width:60%" placeholder="Enter Capacity of Room" name="capacity" />
						      <span id="capacity_error" style="display:none;color:red" >Enter valid capacity</span>
						    </div>
						  </div>
						  <div class="row pl-5">
							   <div class="col">
							     <label class="pt-2"><b>Table</b></label>
							     <input id="table" type="number" class="form-control" style="width:60%" placeholder="Enter Capacity of Room" name="table" />
							     <span id="capacity_error" style="display:none;color:red" >Enter valid capacity</span>
							   </div>
							</div>
							
							<div class="row pl-5">
							   <div class="col">
							     <label class="pt-2"><b>Fan</b></label>
							     <input id="table" type="number" class="form-control" style="width:60%" placeholder="Enter Number of fan" name="table" />
							     <span id="capacity_error" style="display:none;color:red" >Enter Number of fan</span>
							   </div>
							</div>
							<div class="row pl-5">
							   <div class="col">
							     <label class="pt-2"><b>Cupboard</b></label>
							     <input id="table" type="number" class="form-control" style="width:60%" placeholder="Enter Number of cupboard" name="table" />
							     <span id="capacity_error" style="display:none;color:red" >Enter Number of cupboard</span>
							   </div>
							</div>
							<div class="row pl-5">
							   <div class="col">
							     <label class="pt-2"><b>Chair</b></label>
							     <input id="table" type="number" class="form-control" style="width:60%" placeholder="Enter Number of chair" name="table" />
							     <span id="capacity_error" style="display:none;color:red" >Enter Number of chair</span>
							   </div>
							</div>
							 <div class="row pl-5 pb-5">
							   <div class="col">
							  <f:button type="submit" onclick="return check()" class="btn btn-primary mt-3">Add Room</f:button>
							   </div>
							 </div> 
						  
						    
					</f:form>
	   		</div>
</body>
</html>