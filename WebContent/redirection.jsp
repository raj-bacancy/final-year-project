<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
out.println("<script>");
	String s=(String)session.getAttribute("redirect");

	if(s.equals("loadlogin"))
	{
		out.println("alert('Registration Successful');");
		out.println("location='loadlogin.html';");
	}
	else if(s.equals("loadfeereceipt"))
	{
		out.println("alert('Fee Receipt Successfully Uploaded');");
		out.println("location='feereceipt.html';");
	}
	else if(s.equals("uniqueid"))
	{
		out.println("location='loaduniqueid.html';");
	}
	else if(s.equals("messpersonphoto"))
	{
		out.println("alert('Registration Successful');");
		out.println("location='loadlogin.html';");
	}
	else if(s.equals("locker"))
	{
		out.println("alert('Document added in locker successfully');");
		out.println("location='studenthome.html';");
	}
	out.println("</script>");
%>

</body>
</html>