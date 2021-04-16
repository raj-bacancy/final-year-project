<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
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
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%-- <jsp:include page="header.jsp"></jsp:include>
<jsp:include page="student_table.jsp"></jsp:include> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>
<form action="Pay.html" method="post"><button>PaY Now</button></form>
<div style="border:2px solid orange;border-radius:5%;margin-bottom:40%" class="bg-light mx-auto">
	   			
		   			
		   				<div class="row">
						    <div class="col-sm-12 col-12">
							
							<!-- section1 -->
							<div class="col-sm-12 col-12">    	 
							<center><h3 class="p-4 text-center"><b> Hello ${firstname} Welcome To Room No ${roomno}</b></h3><hr></center>
							</div>
						
						<!-- section2 -->
						<div class="col-sm-12 col-12">
						<center><h5><b><button class="btn btn-danger">Locker</button></b></h5></center><br>
						</div>

                        <div class="col-sm-12 col-12">
                            <div class="row">

                                 <div class="col-sm-6 col-12 text-center">
                                    <form action="addlocker.html" method="get">
                                    <button type="submit" class="btn btn-primary">Add in Locker</button>
                                    </form>
                                </div>

                                <div class="col-sm-6 col-12 text-center pt-1">
                                    <form action="showlocker.html" method="get">
                                    <button type="submit" class="btn btn-primary">Show Locker</button>
                                </form>
                                </div>
						      </div>
                        </div>

						<!-- section3 -->
						<hr/>
						<div class="col-sm-12 col-12">
						<center> <h5><b><button class="btn btn-danger">Room Members</button></b></h5></center>
						</div><br>

						<!-- section4 -->
						<div class="col-sm-12 col-12">
						   	<div class="row">
                                 <c:forEach items="${room}" var="l"> 
                                <div class="col-sm-3 col-12 mb-5">
                                    <b>Name= ${l.firstname} ${l.lastname}<br>
                                        Field= ${l.field}<br>
                                        Phone no=${l.phoneno}</b>
                                </div>
                             </c:forEach>
						</div><br/><hr/>
						  
						  
						  <!-- section6 -->
						  <div class="col-sm-12 col-12 text-center">
							  <center><h5><b><button class="btn btn-danger">Hostel Information</button></b></h5></center>
						  </div><br>


						  <!-- section4 -->
                        <div class="col-sm-12 col-12 text-center">
                            <h5><u>About No. of Rooms</u></h5>
                        </div>

                            
                          <!-- section5 -->
                          <div class="col-sm-12 col-12">
                            <div class="row">
                                <div class="col-sm-4 col-12">
                                    <b>Total no of room = 20</b>
                                </div>
                                <div class="col-sm-4 col-12">
                                    <b>No of student's room = 10</b>
                                </div>
                                <div class="col-sm-4 col-12">
                                    <b>No of guest's rooms = 10</b>
                                </div>
                              </div>
                          </div><br/><br/>
                          
                          
                          <!-- section6 -->
                          <div class="col-sm-12 col-12 text-center">
                              <h5><u>About Capacity of Hostel</u></h5>
                          </div>
                          
                          <div class="col-sm-12 col-12">
                            <div class="row">
                                <div class="col-sm-4 col-12">
                                    <b>Capacity for students = 20</b>
                                </div>
                                <div class="col-sm-4 col-12">
                                    <b>No of students in hostel  = 10</b>
                                </div>
                                <div class="col-sm-4 col-12">
                                    <b>Vacancy in hostel = 10</b>
                                </div>
                              </div>
                          </div><br/>
						 
						  
						  
						   
					
	   		</div>


<%-- <div style="height:auto;width:70%;margin-top:2%;margin-left:25%;border:2px solid orange;border-radius:5%" class=" mb-5 bg-light">
	   			<h3 class="pt-4 text-center"><b> Hello ${firstname} Welcome To Room No ${roomno}</b></h3>
	   			<hr><br>
	   			<div class="row pl-5">
						    <div class="col">
						    	<center><h5><b>Here is your locker:</b></h5></center>
						    </div>
						  </div><br>
	   			<div class="row pl-5">
						    <div class="col">
						    <!-- addlocker.html -->
						    	<form action="#" method="get">
						    	 <center><button type="submit" class="btn btn-primary">Add in Locker</button></center>
						    	 </form>
						    </div>
						    <div class="col">
						    <!-- showlocker.html -->
						    	<form action="#" method="get">
						    	 <center><button type="submit" class="btn btn-primary">Show Locker</button></center>
						    	 </form>
						    </div>
				</div><br>
		   			
		   				<div class="row pl-5">
						    <div class="col">
						    	<center><h5><b>Room Members:</b></h5></center>
						    </div>
						  </div><br>
						  
						  <div class="row pl-5">
							     <c:forEach items="${room}" var="l">
							    <div class="col">
							      	<b>Name= ${l.firstname} ${l.lastname}<br>
							      	Field= ${l.field}<br>
							      	Phone no=${l.phoneno}</b>
							     </div>
							     </c:forEach>
						  </div><br><br>
						  
						  <div class="row pl-5">
							   <div class="col">
							    	<center> <h5><b>Hostel Information:</b></h5></center>
							    </div>
						  </div><br>
							  
						  <div class="row pl-5">
							   <div class="col">
							    	<h5><b>About no of room:</b></h5>
							    </div>
						  </div>
						  
						  <div class="row pl-5">
							    <div class="col">
							    	<b>Total no of room = ${noofroom}</b>
							    </div>
							    <div class="col">
							    	<b>No of student's room = ${noofstudentroom}</b>
							    </div>
							    <div class="col">
							    	<b>No of guest's rooms = ${noofguestroom}</b>
							    </div>
						  </div><br>
						  
						  <div class="row pl-5">
							   <div class="col">
							    	<h5><b>About capacity of hostel:</b></h5>
							    </div>
						  </div>
						  
						  <div class="row pl-5">
							    <div class="col">
							    	<b>Capacity for students = ${totalcapacity}</b>
							    </div>
							    <div class="col">
							    	<b>No of students in hostel  = ${totalmamber}</b>
							    </div>
							    <div class="col">
							    	<b>Vacancy in hostel = ${vacancy}</b>
							    </div>
						  </div><br>
						   
					
	   		</div> --%>
</body>
</html>