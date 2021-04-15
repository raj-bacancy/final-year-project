<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Owner's Menu</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
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

<body style="opacity:0.9">

<div>
	<table class="table table-hover table-striped" style="width:20%;background-color:#f4511e;float:left">
		<thead class="thead-dark">
			<tr>
				<th >Dashboard<i class="fa fa-dashboard  float-right" style="font-size:24px;color:white"></i>
				</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="text-warning"><a href="ownerhome.html" class="link"><div style="height:100%;width:100%;"><i class='fas fa-home' style='font-size:35px;color:white;'></i><x class="ml-4" style="color:black"><b>Home</b></x></div></a>
				</td>
     		</tr>
      		<tr>
    			<th><a href="viewstudent.html?start=0" class="link text-white"><div style="height:100%;width:100%"><i class='fas fa-user-graduate' style='font-size:35px;color:white'></i><x class="ml-4" style="color:black"><b> View Student Info.</b></x></div></a>
    			</th>
    		</tr>
    		<tr>
  			    <th ><a href="requests.html" class="link text-white"><div style="height:100%;width:100%"><i class='fas fa-user-edit' style='font-size:40px;color:white'></i><x class="ml-4" style="color:black"><b>Requests</b></x></div></a>
  			    </th>
  			</tr>
     		<tr>
    			<th ><a href="loadgeneratehostelid.html" class="link text-white"><div style="height:100%;width:100%"><i class='fas fa-id-card' style='font-size:40px;color:white'></i><x class="ml-4" style="color:black"><b> Generate hostel Id</b></x></div></a>
    			</th>
    		</tr>
    		<tr>
    			<th ><a href="loadroommanagement.html" class="link text-white"><div style="height:100%;width:100%"><i class='fas fa-th-list' style='font-size:40px;color:white'></i> <x class="ml-4" style="color:black"><b>Room Management</b></x></div></a>
    			</th>
    		</tr>
     		<tr>
     		<!-- loadanalysis.html -->
  			    <th><a href="loadanalysis.html" class="link text-white"><div style="height:100%;width:100%"><i class='fa fa-bar-chart' style='font-size:40px;color:white'></i> <x class="ml-4" style="color:black"><b>Analysis</b></x></div></a>
  			    </th>
    		</tr>
    		<tr>
    		<!-- attendance.html -->
    			<th><a href="attendance.html" class="link text-white"><div style="height:100%;width:100%"><i class='fa fa-address-card-o' style='font-size:40px;color:white'></i><x class="ml-4" style="color:black"><b> Attendance</b></x></div></a>
    			</th>
    		</tr>
     		<tr>
    			<th><a href="viewcomplainpart.html" class="link text-white "><div style="height:100%;width:100%"><i class='fa fa-exclamation-circle' style='font-size:40px;color:white'></i><x class="ml-4" style="color:black"><b>Complain Management</b></x></div></a></th>
    		</tr>
    		<tr>
		     	<th ><a href="ownermessage.html" class="link text-white"><div style="height:100%;width:100%"><i class='fa fa-commenting' style='font-size:40px;color:white'></i><x class="ml-4" style="color:black"><b>Message for student</b></x></div></a></th>
		     </tr>
    		<tr>
    			<th ><a href="loadlogin.html" class="link text-white"><div style="height:100%;width:100%"><i class='fa fa-sign-out' style='font-size:40px;color:white'></i> <x class="ml-4" style="color:black"><b>Logout</b></x></div></a>
    			</th>
   			 </tr>
		</tbody>
</table>
</div>
</body>
</html>