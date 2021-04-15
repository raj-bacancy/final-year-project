<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Photo</title>
</head>
<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@include file="header.jsp" %>
<section>
<%
	session.setAttribute("filetype", "photo");
%>
<div class="container mt-5 pb-5 bg-light" style="border:2px solid orange ; border-radius:5%">
	<center>
					<div class="row mt-5">
					    <div class="col">
					      <label><h2><b>Upload Your Photo :</b></h2></label>
					      	<hr class="w-50 mx-auto" style="border:1px solid orange"><br>
								<form action="<%=request.getContextPath()%>/filepath" method="post" enctype="multipart/form-data">
						   			<div class="row mt-2">
										    <div class="col-12 col-sm-12">
										      <label><b>Photo</b></label>
										      <input class="form-control" type="file" name="file" ><br>
										      <button class="btn btn-primary mt-3 mb-5" type="submit"><b>Upload</b></button>
										    </div>
									</div><br>
								</form>
						 </div>					    
					  </div>
	</center>	
</div>
</section>
</body>
</html>