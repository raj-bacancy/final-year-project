<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Locker</title>
<link href="style.css" rel="stylesheet">

</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
int i=0;
%>
<script type="text/javascript">
        function PrintDiv(id) {
            var divContents = document.getElementById(id).innerHTML;
            var printWindow = window.open('', '', 'height=600,width=600');
            printWindow.document.write('<html><head><title>Student Document</title>');
            printWindow.document.write('</head><body >');
            printWindow.document.write(divContents);
            printWindow.document.write('</body></html>');
            printWindow.document.close();
            printWindow.print();
        }
</script>
<%-- <jsp:include page="header.jsp"></jsp:include>
<jsp:include page="student_table.jsp"></jsp:include> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>
<div class="mx-auto mt-3 leave_div bg-white p-3">
	   			<h3 class="pt-4 text-center"><b> Your Locker</b></h3>
	   			<hr><br>	   			
					<c:forEach items="${list}" var="l">
						  <div class="row pl-5">
							     <div class="col-12 col-sm-6" id="<%=i%>">
							      	<img alt="Doc Image" style="hight:50%;width:50%" src="${l.link}">
							     </div>
							    <div class="col-12 col-sm-6">
							      	<b>Document Name = ${l.docname}<br>
							      	Description = ${l.description}<br><br></b>
							      	<button onclick="PrintDiv(<%=i%>)" class="btn btn-primary">Get PDF</button>
							     </div>
							     <%=++i%>
			  			</div><br><br>			  			
				     </c:forEach>
</div>
</body>
</html>