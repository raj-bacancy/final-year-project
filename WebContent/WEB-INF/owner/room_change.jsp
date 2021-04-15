<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Room</title>
<link href="../general/style.css" rel="stylesheet">

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
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
<div style="height:auto;width:50%;margin-top:5%;margin-left:35%;border:2px solid orange;border-radius:5%" class="bg-light">
	   			<h2 class="pt-4 text-center"><b>Change Room</b></h2>
	   			<hr>
		   			<form>
						  <div class="row pl-5">
						    <div class="col">
						      <label class="pt-2"><b>Hostel-Id</b></label>
						      <input type="text" class="form-control" style="width:60%" placeholder="Enter Hostel-Id" name="hostel_id">
						    </div>
						  </div>
						  <div class="row pl-5">
						    <div class="col">
						      <label class="pt-2"><b>Room No</b></label>
						      <input type="text" class="form-control" style="width:60%" placeholder="Enter Room No" name="room_no">
						    </div>
						  </div>
						  <div class="row pl-5 pb-5">
						    <div class="col">
						  		<button class="btn btn-primary mt-3">Change</button>
						    </div>
						  </div>	  
					</form>
	   		</div>
</body>
</html>