<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mess Table</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

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

<body>

     
     <table class="table table-hover table-striped" style="width:20%;background-color:#f4511e;float:left  ">
     <thead class="thead-dark">
			<tr>
				<th >Dashboard<i class="fa fa-dashboard  float-right" style="font-size:24px;color:white"></i>
				</th>
			</tr>
	</thead>
	<tbody>
			<tr>
				<th  class="text-warning"><a href="messhome.html" class="link text-white"><div style="height:100%;width:100%;"><i class='fas fa-home' style='font-size:35px;color:white;'></i><x class="ml-4" style="color:black"><b>Home</b></x></div></a>
				</th>
     		</tr>
     		<tr>
				<th class="text-warning"><a href="todaylunch.html" class="link text-white"><div style="height:100%;width:100%;"><i class='fa fa-cutlery' style='font-size:35px;color:white;'></i><x class="ml-4" style="color:black"><b>Today's Lunch</b></x></div></a>
				</th>
     		</tr>
     		<tr>
				<th class="text-warning"><a href="todaydinner.html" class="link text-white"><div style="height:100%;width:100%;"><i class='fa fa-cutlery' style='font-size:35px;color:white;'></i><x class="ml-4" style="color:black"><b>Today's Dinner</b></x></div></a>
				</th>
     		</tr>
     		<tr>
		     	<th ><a href="todayfoodcoupons.html" class="link text-white"><div style="height:100%;width:100%"><i class='fa fa-file' style='font-size:35px;color:white'></i><x class="ml-4" style="color:black"><b>Today Food Coupons</b></x></div></a></th>
		     </tr>	
		     <tr>
		     	<th ><a href="message.html" class="link text-white"><div style="height:100%;width:100%"><i class='fa fa-commenting' style='font-size:35px;color:white'></i><x class="ml-4" style="color:black"><b>Message for student</b></x></div></a></th>
		     </tr>
		    
		     <tr>
		     	<th ><a href="loadlogin.html" class="link text-white"><div style="height:100%;width:100%"><i class='fa fa-sign-out' style='font-size:35px;color:white'></i><x class="ml-4" style="color:black"><b> Logout</b></x></div></a></th>
		     </tr>
		     
     </tbody>
     </table>


</body>
</html>