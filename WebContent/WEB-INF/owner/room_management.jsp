<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Room Management</title>
<link href="../general/style.css" rel="stylesheet">
<link href="style_4option.css" rel="stylesheet">

</head>

<%-- <%@ include file="header.jsp" %>
<jsp:include page="menu.jsp"></jsp:include> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>

	<div class="row mt-3">
	
			<div class="col-lg-6 col-md-6 col-12" style="border:0px solid black">
			 <a href="roominformation.html"><div class="card mt-5 box" style="border:2px solid orange;border-radius:7%;">
				  <center><i class='fa fa-info-circle mt-2' style='font-size:100px;color:#FC3900'></i></center>
				  <hr>
				  <div class="row" style="height:auto;width:100%;border:0px solid black">
				  	<div class="col "><h4 class="ml-3 mt-1"><b>Room<br> Information</b></h4>
				  	</div>
		
				  </div>
			</div></a>
			<a href="deallocaetroom.html"><div class="card mt-5 box" style="border:2px solid orange;border-radius:7%;">
					<center><i class='fas fa-exchange-alt mt-2' style='font-size:100px;color:#FC3900'></i></center>
				  <hr>
				  <div class="row" style="height:auto;width:100%;border:0px solid black">
				  	<div class="col"><h4 class="ml-3 mt-1"><b>De-allocate<br>Room</b></h4>
				  	</div>
				  	
				  </div>				 
			</div> </a>
		</div>
		<div class="col-lg-6 col-md-6 col-12" style="border:0px solid black">
			 <a href="addroom.html"><div class="card mt-5 box" style="border:2px solid orange;border-radius:7%;">
				  <center><i class='fas fa-plus mt-2' style='font-size:100px;color:#FC3900'></i></center>
				  <hr>
				  <div class="row" style="height:auto;width:100%;border:0px solid black">
				  	<div class="col"><h4 class="ml-3 mt-1"><b>Add<br>Room</b></h4>
				  	</div>
				  	
				  </div>
			</div></a>
			<a href="loadremoveroom.html"><div class="card mt-5 box last_box" style="border:2px solid orange;border-radius:7%;">
				  <center><i class='fas fa fa-times mt-2' style='font-size:100px;color:#FC3900'></i></center>
				  <hr>
				  <div class="row" style="height:auto;width:100%;border:0px solid black">
				  	<div class="col"><h4 class="ml-3 mt-1"><b>Remove<br> Room</b></h4>
				  	</div>
				  	
				  </div>
			</div></a>
		</div>
	</div>
</div>
</body>
</html>