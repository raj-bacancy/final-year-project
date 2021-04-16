<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Requsts</title>

<!-- <link href="../general/style.css" rel="stylesheet"> -->
<!-- <link href="style.css" rel="stylesheet"> -->

<style>
@media only screen and (max-width: 2000px) {
    .box{
        border:2px solid orange;
		width:80%;
		float:left;
		border-radius:7%;
		margin-left:10%
    }
}



@media only screen and (max-width: 600px) {
    .box{
		width:100%; 
		margin-left:0%
    }
	.last_box{
		margin-bottom:50%
	}
}

.box:hover{
        transform: scale(1.1);
        z-index: 1;
        color: red;
    }

</style>
</head>
<body>

<%-- <%@ include file="header.jsp" %> --%>
<%-- <jsp:include page="menu.jsp"></jsp:include> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>

<div class="row mt-5">
		<div class="col-lg-6 col-md-6 col-12" >
			 <a href="feereceiptrequests.html?start=0"><div style="box-shadow: 10px 10px 20px 10px rgba(1, 1, 1, .1);border:2px solid orange;border-radius:7%" class="card mt-5 box">
				  <center><i class='fas fa-exclamation-triangle mt-2' style='font-size:100px;color:#FC3900'></i></center>
				  <hr>
				  <div class="row" style="height:auto;width:100%;border:0px solid black">
				  	<div class="col col-7"><h4 class="ml-3 mt-1"><b>Fee<br> Request</b></h4>
				  	</div>
				  	<div class="col col-2"><div style="height:90%;width:1%;border:2px solid black"></div>
				  	</div>
				  	<div class="col col-3"><h4 class=" mt-1"><b>${no_of_fee}</b></h4>
				  	</div>
				  </div>
			</div></a>
			<a href="gueststayowner.html?start=0"><div style="box-shadow: 10px 10px 20px 10px rgba(1, 1, 1, .1);border:2px solid orange;border-radius:7%" class="card mt-5 box">
					<center><i class='fas fa-bed mt-2' style='font-size:100px;color:#FC3900'></i></center>
				  <hr>
				  <div class="row" style="height:auto;width:100%;border:0px solid black">
				  	<div class="col col-7"><h4 class="ml-3 mt-1"><b>Guest's<br> Stay</b></h4>
				  	</div>
				  	<div class="col col-2"><div style="height:90%;width:1%;border:2px solid black"></div>
				  	</div>
				  	<div class="col col-3"><h4 class=" mt-1"><b>${no_of_gueststay}</b></h4>
				  	</div>
				  </div>				 
			</div></a>
		</div>
		<div class="col-lg-6 col-md-6 col-12" style="border:0px solid black">
			<a href="leaverequestowner.html?start=0"> <div style="box-shadow: 10px 10px 20px 10px rgba(1, 1, 1, .1);border:2px solid orange;border-radius:7%" class="card mt-5 box" >
				  <center><i class='fa fa-building mt-2' style='font-size:100px;color:#FC3900'></i></center>
				  <hr>
				  <div class="row" style="height:auto;width:100%;border:0px solid black">
				  	<div class="col col-7"><h4 class="ml-3 mt-1"><b>Leave <br>Request</b></h4>
				  	</div>
				  	<div class="col col-2"><div style="height:90%;width:1%;border:2px solid black"></div>
				  	</div>
				  	<div class="col col-3"><h4 class=" mt-1"><b>${no_of_leave}</b></h4>
				  	</div>
				  </div>
			</div></a>
			<a href="foodcouponowner.html?start=0"><div style="box-shadow: 10px 10px 20px 10px rgba(1, 1, 1, .1);border:2px solid orange;border-radius:7%" class="card mt-5 box last_box" >
				  <center><i class='fas fa-concierge-bell mt-2' style='font-size:100px;color:#FC3900'></i></center>
				  <hr>
				  <div class="row" style="height:auto;width:100%;border:0px solid black">
				  	<div class="col col-7"><h4 class="ml-3 mt-1"><b>Food<br> Coupon</b></h4>
				  	</div>
				  	<div class="col col-2"><div style="height:90%;width:1%;border:2px solid black"></div>
				  	</div>
				  	<div class="col col-3"><h4 class=" mt-1"><b>${no_of_foodcoupon}</b></h4>
				  	</div>
				  </div>
			</div></a>
		</div>
	</div>
</div>





</body>
</html>