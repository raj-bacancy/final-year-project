<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>HDMS</title>

    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="style5.css">

    <!-- Font Awesome JS -->
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="wrapper">
        <!-- Sidebar Holder -->
        <nav id="sidebar">
            <div class="sidebar-header">
                <h3>Owner Dashboard</h3>
            </div>

            <ul class="list-unstyled components">
                
                <li class="active">
                    <a href="ownerhome.html" ><i class='fas fa-home' style='font-size:25px;color:orange;'></i>Home</a>
                </li>
                <li>
                    <a href="viewstudent.html?start=0" ><i class='fas fa-user-graduate' style='font-size:25px;color:orange;'></i>View Student Info</a>
                </li>
                <li>
                    <a href="requests.html" ><i class='fas  fa-user-edit' style='font-size:25px;color:orange;'></i>Requests</a>
                </li>
                <li>
                    <a href="loadgeneratehostelid.html" ><i class='fas fa-id-card' style='font-size:25px;color:orange;'></i>Generate Hostel id</a>
                </li>
                <li>
                    <a href="loadroommanagement.html" ><i class='fas fa-th-list' style='font-size:25px;color:orange;'></i>Room Management</a>
                </li>
                <li>
                    <a href="loadanalysis.html" ><i class="fas fa-chart-bar" style='font-size:25px;color:orange;'></i>Analysis</a>
                </li>
                <li>
                    <a href="attendance.html" ><i class="fas fa-users" style='font-size:25px;color:orange;'></i>Attendence</a>
                </li>	
                <li>
                    <a href="viewcomplainpart.html" ><i class='fas fa-exclamation-circle' style='font-size:25px;color:orange;'></i> Complain Management</a>
                </li>
                
                <li>
                    <a href="ownermessage.html" ><i class='fas fa-comments' style='font-size:25px;color:orange;'></i>  Message for Students</a>
                </li>
                <li>
                    <a href="loadlogin.html" ><i class="fas fa-sign-out-alt" style='font-size:25px;color:orange;'></i>Logout</a>
                </li>

            </ul>

           
        </nav>

        <!-- Page Content Holder -->
        <div id="content">

            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">

                    <button type="button" id="sidebarCollapse" class="navbar-btn">
                        <span></span>
                        <span></span>
                        <span></span>
                    </button>
                    <!--<button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <i class="fas fa-align-justify"></i>
                    </button>-->
					<h1 class="mx-auto"><b>Hostel Management System</b></h1>
                    
                </div>
            </nav>
            
            
    <!-- jQuery CDN - Slim version (=without AJAX) -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <!-- Popper.JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
                $(this).toggleClass('active');
                var infodiv=document.getElementById("sidebar");
				if(infodiv.className=='active' && window.innerWidth>700){
					document.getElementById("info_div").style.display="";			
				}else if(infodiv.className=='active'){
					document.getElementById("info_div").style.display="none";
				}else{
					document.getElementById("info_div").style.display="";
				}
            });
        });
    </script>
</body>
</html>