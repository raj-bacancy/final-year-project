<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@include file="new_header.jsp" %>
<section>

<div class="mx-auto mt-3 leave_div bg-white">
<center><f:form method="get" modelAttribute="role_vo" action="signup.html">
					<div class="row mt-5">
					    <div class="col">
					      <label><h2><b>Select Your Role :<b></b></h2></label>
					      	<hr><br>
						    <f:select path="role" cssStyle="height:17%; width: 70%">
					      	<f:option value="owner">Owner</f:option>
					      	<f:option value="mess">Mess</f:option>
					      </f:select><br>
					      <button type="submit" class="btn mt-5 text-white mb-5" style="background-color:#FF5C20">Go</button>
					    </div>
					    
					  </div>
	</f:form></center>	
</div>
</section>
</body>
</html>