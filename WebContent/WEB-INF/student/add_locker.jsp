<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Photo</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%-- <%@include file="header.jsp" %> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>
<section>
<%
	session.setAttribute("filetype", "locker");
%>
<div class="mx-auto mt-3 leave_div bg-white p-3">

					<div class="row mt-5">
					    <div class="col">
					     <center><label><h2><b>Upload Your Document :</b></h2></label></center>
					      	<hr>
								<form action="<%=request.getContextPath()%>/filepath" method="post" enctype="multipart/form-data">
						   			<div class="row mt-4">
									    <div class="col-12 col-sm-6 mb-3">
									      <label><b>Name :</b></label><br>
										     <input type="text" class="form-control" placeholder="Enter Document Name" name="docname"/>
									    </div>
									    <div class="col-12 col-sm-6 mb-3">
									      <label><b>Description :</b></label>
									      <textarea rows="3" cols="5" name="description" class="form-control" placeholder="Enter Document's Description"></textarea>
									    </div>
						  			</div>
						   			<div class="row mt-2">
										    <div class="col-12 col-sm-12">
										      <label><b>Photo</b></label>
										      <input class="form-control" type="file" name="doc" ><br>
										    </div>
										    <div class="col-12 col-sm-12">
										 		<button class="btn btn-primary mt-3 mb-5" type="submit"><b>Submit</b></button>
										    </div>
									</div><br>
								</form>
						 </div>
					    
					  </div>
	
</div>
</section>
</body>
</html>