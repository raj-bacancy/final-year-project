<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>alert page</title>
</head>
<body>
<% 

out.println("<script>");
String message=(String)session.getAttribute("alert");
System.out.println("Alert Message "+message);
if(message.equals("logincheck"))
{
	//out.println("<div class='alert alert-danger alert-dismissible'><a href=''#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>'Invalid data.. Pl try Again'</div>");
	out.println("alert('Invalid data.. Pl try Again');");
	out.println("location='loginalert.html';");
}
else if(message.equals("regcheck"))
{
	out.println("alert('password does not match');");
	out.println("location='signupalert.html';");
}
else if(message.equals("messregcheck"))
{
	out.println("alert('password does not match');");
	out.println("location='selectrole.html';");
}
else if(message.equals("generate_hostelid_first"))
{
	out.println("alert('Go to owner and generate hostel id first');");
	out.println("location='loadlogin.html';");
}
else if(message.equals("invalid_password"))
{
	out.println("alert('Enter valid password');");
	out.println("location='loadlogin.html';");
}
else if(message.equals("foodcost"))
{	
	int  cost=(Integer)session.getAttribute("costs");
	//System.out.println(cost);
	out.println("alert('Your Total Bill is  '+'"+cost+"'  );");
	out.println("location='loadfood.html';");
}
else if(message.equals("room is not there"))
{
	out.println("alert('Room Is Not Available In Hostel');");
	out.println("location='loadgeneratehostelid.html';");
}
else if(message.equals("room full"))
{
	out.println("alert('Not Enough Vacancy In This Room');");
	out.println("location='loadgeneratehostelid.html';");
}
else if(message.equals("successfully generated"))
{
	out.println("alert('Hostel Id Successfully Generated');");
	out.println("location='loadgeneratehostelid.html';");
}
else if(message.equals("notapproved"))
{
	out.println("alert('Your reqest is not approved yet');");
	out.println("location='foodstatus.html';");
}
else if(message.equals("overflow"))
{
	out.println("alert('Not Enough Vacancy');");
	out.println("location='gueststayowner.html';");
}
else if(message.equals("allocated"))
{
	out.println("alert('Guest Room Successfully Allocated');");
	out.println("location='gueststayowner.html?start=0';");
}
else if(message.equals("Owner Wrong OTP"))
{
	out.println("alert(' Wrong OTP');");
	out.println("location='loadgetownerotp.html';");
}
else if(message.equals("Owner password missmatch"))
{
	out.println("alert('Confirm password and New password must be same');");
	out.println("location='loadsetownernewpassword.html';");
}
else if(message.equals("Mess Wrong OTP"))
{
	out.println("alert(' Wrong OTP');");
	out.println("location='loadgetmessotp.html';");
}
else if(message.equals("Mess password missmatch"))
{
	out.println("alert('Confirm password and New password must be same');");
	out.println("location='loadsetmessnewpassword.html';");
}
else if(message.equals("Student Wrong OTP"))
{
	out.println("alert(' Wrong OTP');");
	out.println("location='loadgetstudentotp.html';");
}
else if(message.equals("Student password missmatch"))
{
	out.println("alert('Confirm password and New password must be same');");
	out.println("location='loadsetstudentnewpassword.html';");
}
else if(message.equals("error"))
{
	out.println("alert('Hostel Id Already Exist');");
	out.println("location='loadgeneratehostelid.html';");
}
else if(message.equals("messlogin"))
{	
	out.println("alert('Invalid data.. Pl try Again');");
	out.println("location='loginalert.html';");
}
else if(message.equals("removed"))
{	
	out.println("alert('Room Removed Successfully');");
	out.println("location='loadremoveroom.html';");
}
else if(message.equals("can not remove"))
{	
	out.println("alert('Can Not Remove This Room');");
	out.println("location='loadremoveroom.html';");
}
else if(message.equals("no student"))
{	
	out.println("alert('Empty Room Or Room Does Not Exist');");
	out.println("location='attendance.html';");
}
else if(message.equals("Lunch or dinner problem"))
{	
	out.println("alert('Lunch Or Dinner May Not Uploaded Yet');");
	out.println("location='foodcoupon.html';");
}
else if(message.equals("setfoodlunch"))
{	
	out.println("alert('Lunch Food Set Successfully');");
	out.println("location='todaylunch.html';");
}
else if(message.equals("updatefoodlunch"))
{	
	out.println("alert('Lunch Food Set Successfully');");
	out.println("location='todaylunch.html';");
}
else if(message.equals("setfooddinner"))
{	
	out.println("alert('Dinner Food Set Successfully');");
	out.println("location='todaydinner.html';");
}
else if(message.equals("updatefooddinner"))
{	
	out.println("alert('Dinner Food Set Successfully');");
	out.println("location='todaydinner.html';");
}
else if(message.equals("complainapplyacheck"))
{	
	out.println("alert('U have Done Complain request today,pl try another day');");
	out.println("location='complain.html';");
}
else if(message.equals("account already created"))
{	
	out.println("alert('Account is already there you can not create another account');");
	out.println("location='loadlogin.html';");
	
}else if(message.equals("room already exist")){
	out.println("alert('This room is already exist');");
	out.println("location='loadroommanagement.html';");
	
}else if(message.equals("room added succesfully")){
	out.println("alert('Room added successfully');");
	out.println("location='loadroommanagement.html';");
	
}
else
{
	out.println("alert('Something Went Wrong');");
	out.println("location='loadlogin.html';");
}
out.println("</script>");
%>

</body>
</html>