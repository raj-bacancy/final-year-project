<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Food Coupon Analysis</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%-- <jsp:include page="header.jsp"></jsp:include>  
<jsp:include page="menu.jsp"></jsp:include> --%>
<jsp:include page="new_menu_header.jsp"></jsp:include>
<div style="border:2px solid orange;border-radius:5%" class="row bg-white mx-auto p-5">
	<div id="chart_div" class="mt-2 col"></div>
	<div class="col">
		<h2 class="pt-4 text-center "><b>Menu</b></h2>
	   			<hr>
		   			<table class="table table-stripped table-hover table-bordered">
		   	<tr class="table-danger">		
		   	
			<td><b>Date</b></td>
			<td><b>Lunch Menu</b></td>
			<td><b>Dinner Menu</b></td>
			</tr>
			 <c:forEach items="${menu_count }" var="i">	
			<tr>	
			<td><b>${i.date }</b></td>
			<td><b>${i.lunchmenu }</b></td>
			<td><b>${i.dinnermenu }</b></td>			
			</tr>
			</c:forEach> 
		   			</table>
	</div>
</div>


	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {packages: ['corechart', 'bar']});
      google.charts.setOnLoadCallback(drawMultSeries);

      function drawMultSeries() {
            var data = google.visualization.arrayToDataTable([
              ['Date', 'No of coupon for lunch', 'No of coupon for dinner'],
              ['${menu_count.get(0).getDate()}', ${menu_count.get(0).getLunch()}, ${menu_count.get(0).getDinner()}],
              ['${menu_count.get(1).getDate()}', ${menu_count.get(1).getLunch()}, ${menu_count.get(1).getDinner()}],
              ['${menu_count.get(2).getDate()}', ${menu_count.get(2).getLunch()}, ${menu_count.get(2).getDinner()}],
              ['${menu_count.get(3).getDate()}', ${menu_count.get(3).getLunch()}, ${menu_count.get(3).getDinner()}],
              ['${menu_count.get(4).getDate()}', ${menu_count.get(4).getLunch()}, ${menu_count.get(4).getDinner()}],
              ['${menu_count.get(5).getDate()}', ${menu_count.get(5).getLunch()}, ${menu_count.get(5).getDinner()}],
              ['${menu_count.get(6).getDate()}', ${menu_count.get(6).getLunch()}, ${menu_count.get(6).getDinner()}]
            ]);
            var options = {
              title: 'Food Analysis for week',
              chartArea: {width: '50%'},
              hAxis: {
                title: 'No of coupon',
                minValue: 0
              },
              vAxis: {
                title: 'Date'
              }
            };

            var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
            chart.draw(data, options);
          }
    </script>
    
    
</body>
</html>