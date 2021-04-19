<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<script src='https://kit.fontawesome.com/a076d05399.js'></script>
</head>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
	session.setAttribute("filetype", "foodpayment");
	int lunchprice = (int)session.getAttribute("lunchprice");
	int dinnerprice = (int)session.getAttribute("dinnerprice");
	String hostelid=(String)session.getAttribute("hostel_id");
%>
<body>
<center><h2 class="mt-5">Pay for Food Coupon</h2></center>
<hr>
	<div class="container">
	
			<div class="row">
        <div class="col-sm-6">
            <div class="card ">
                <div class="card-header">
                    <h3 class="text-xs-center"><strong>Bill summary</strong></h3>
                </div>
                <div class="card-block">
                    <div class="table-responsive">
                        <table class="table table-sm">
                            <thead>
                                <tr>
                                    <td><strong>Item Name</strong></td>
                                    <td class="text-xs-center"><strong>Item Price</strong></td>
                                    
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Lunch Price</td>
                                    <td class="text-xs-center">${lunchprice }</td>
                                    
                                </tr>
                                <tr>
                                    <td>Dinner Price</td>
                                    <td class="text-xs-center">${dinnerprice}</td>    
                                    
                                </tr>
                                </tbody>
                        </table>
                        <br><br><hr style="border:2px solid black"><br>
                        <center><h2><b>Food Coupon for <%=hostelid %></b></h2></center><br>
                        <table class="table table-sm">
                        <tbody>
                                <tr>
                                    <td>Lunch Menu</td>
                                    <c:forEach items="${lunch }" var="i">
                                    	<td class="text-xs-center">${i.lunchmenu }</td>
                                    	
                                    </c:forEach>    
                                </tr>
                                 <tr>
                                    <td>Dinner Menu</td>
                                    <c:forEach items="${dinner }" var="i">
                                    	<td class="text-xs-center">${i.dinnermenu }</td>
                                    	
                                    </c:forEach>    
                                </tr>
                                <tr>
                                    <td>No Of Coupon</td>
                                    <td class="text-xs-center">${nooffoodcoupon }</td>
                                    
                                </tr>
                                <tr>
                                    <td>Food Time</td>
                                    <td class="text-xs-center">${foodtime}</td>
                                    
                                </tr>
                              
                                 <tr>
                                    <td class="highrow text-xs-center"><strong>Subtotal</strong></td>
                                    <td class="highrow text-xs-right">${cost }</td>
                                </tr>
                                <tr>
                                    <td class="emptyrow text-xs-center"><strong>Other Charges</strong></td>
                                    <td class="emptyrow text-xs-right">0</td>
                                </tr>
                                <tr>
                                    <td class="emptyrow text-xs-center"><strong>Total</strong></td>
                                    <td class="emptyrow text-xs-right"><b>${cost }</b></td>
                                </tr> 
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    
	
	
	
		
			<div class="col-sm-6 col-12 mt-5">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="row">
							<h3 class="text-center">Payment Details</h3>
							<img class="img-responsive cc-img" src="http://www.prepbootstrap.com/Content/images/shared/misc/creditcardicons.png">
						</div>
					</div>

					<form action="<%=request.getContextPath() %>/filepath" method="post" enctype="multipart/form-data">
						
					<div class="panel-body">
						
							<div class="row">
							<div class="col-xs-7 col-md-7">
								<div class="form-group">
									<label>CARD OWNER</label>
									<input type="text" name="cardname" class="form-control" id="cardname" placeholder="Card Owner Name" required autofocus />
									<span style="color:red;display:none" id='cardownererror'>enter name</span>
								</div>
								
							</div>
							<div class="col-xs-5 col-md-5 pull-right">
								<div class="form-group">
									<label>CARD NUMBER</label>
									<input type="text" name="cardnumber" class="form-control" id="cardnumber" placeholder="Valid Card Number" required autofocus />
									<span style="color:red;display:none" id='cardnumerror'>enter valid card number</span>
								</div>
							</div>
						</div><br/>
							<div class="row">
								<div class="col-xs-7 col-md-7">
									<div class="form-group">
										<label><span class="visible-xs-inline">EXP</span> Month</label>
										<select class="form-control" name="expmonth">
											<option>1</option>
											<option>3</option>
											<option>4</option>
											<option>5</option>
											<option>6</option>
											<option>7</option>
											<option>8</option>
											<option>9</option>
											<option>10</option>
											<option>11</option>
											<option>12</option>
										</select>
									</div>
									
								</div>
								<div class="col-xs-5 col-md-5 pull-right">
									<div class="form-group">
									<label><span class="visible-xs-inline">EXP</span> Year</label>
										<input type="text" name="expyear" class="form-control" id="expyear" placeholder="YY" required autofocus />
										<span style="color:red;display:none" id='expyearerror'>enter valid card number</span>
									</div>
								</div>
							</div><br/>


							<div class="row">
							<div class="col-xs-7 col-md-7">
								<div class="form-group">
									<label>Amount</label>
									<input type="text" name="amount" class="form-control" id="amount" value="${cost}" readonly placeholder="Amount" required autofocus />
								</div>
								
							</div>
							<div class="col-xs-5 col-md-5 pull-right">
								<div class="form-group">
								<label>CV CODE</label>
								<input type="text" name="cvc" class="form-control" id="cvc" placeholder="CVC" required autofocus />
								<span style="color:red;display:none" id='cvcerror'>enter valid cvc</span>
								</div>
							</div>
						</div><br/>                    


						   
						
					</div><br>
					<div class="panel-footer">
						<div class="row">
							<div class="col-xs-12">
							<button class="btn btn-warning btn-lg btn-block">Paynow</button>
						
								
							</div>
						</div>
					</div>
					<input type="hidden" name="lunchprice" value="${lunchprice}">
					<input type="hidden" name="dinnerprice" value="${dinnerprice}">
					<input type="hidden" name="nooffoodcoupon" value="${nooffoodcoupon}">
					<input type="hidden" name="foodtime" value="${foodtime}">
					</form>
				</div>
		</div>
			
			
			
	

		
		
		
			
			
			
			
			
			
		</div>
		</div>
</body>
</html>