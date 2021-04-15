<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave Application</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="style.css" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

 <%-- <%@ include file="header.jsp" %>
<jsp:include page="student_table.jsp"></jsp:include>  --%> 
 <jsp:include page="new_menu_header.jsp"></jsp:include> 
 
<div class="row" style="height: 100%">
    <div class="col-sm-12 col-12 text-center" style="margin:90px 0px " >
        <div class="row">
            <div class="col-sm-6 col-12 p-1 mb-5">
                <a href="loadleaveapplicationapply.html"><div class="card box mx-auto" style="border:2px solid orange;width: 70%;border-radius:7%">
                  <center><i class='far fa-dizzy mt-2' style='font-size:100px;color:#FC3900'></i></center>
                  <hr>
                  <div class="row" style="height:auto;width:100%;border:0px solid black">
                    <div class="col "><h4 class="ml-3 mt-1"><b>Leave Application Apply</b></h4>
                    </div>
                
                  </div>
            </div></a>
            </div>
            <div class="col-sm-6 col-12 p-1">
                 <a href="loadleaveapplicationstatus.html"><div class="card box mx-auto" style="border:2px solid orange;width:70%;border-radius:7%">
                    <center><i class='fas fa-question-circle mt-2' style='font-size:100px;color:#FC3900'></i></center>
                  <hr>
                  <div class="row" style="height:auto;width:100%;border:0px solid black">
                    <div class="col"><h4 class="ml-3 mt-1"><b>Leave Application Status</b></h4>
                    </div>
                    
                  </div>                 
            </div> </a>
            </div>
    </div>
</div> 
 
<!-- <div class="container">
	<div class="row pl-5" style="margin-top:10%;">
		

		<div class="col-sm-6 col-6 pl-5" >
			 	 <a href="loadleaveapplicationapply.html"><div class="card mt-5 ml-5" style="border:2px solid orange;width:80%; float:left;border-radius:7%">
				  <center><i class='far fa-dizzy mt-2' style='font-size:100px;color:#FC3900'></i></center>
				  <hr>
				  <div class="row" style="height:auto;width:100%;border:0px solid black">
				  	<div class="col text-center"><h4 class="ml-3 mt-1"><b>Leave Application Apply</b></h4>
				  	</div>
				  </div>
			</div></a>	 
		</div>
		<div class="col-sm-6 col-6 pl-5" style="border:0px solid black">
			<a href="loadleaveapplicationstatus.html"><div class="card mt-5 ml-5" style="border:2px solid orange;width:80%; float:left;border-radius:7%">
					  <center><i class='fas fa-question-circle mt-2' style='font-size:100px;color:#FC3900'></i></center>
					  <hr>
					  <div class="row" style="height:auto;width:100%;border:0px solid black">
					  	<div class="col text-center"><h4 class="ml-3 mt-1"><b>Leave Application Status</b></h4>
					  	</div>
					  </div>
				</div></a>
	   </div>	
	</div>
</div>
 -->
</body>
</html>