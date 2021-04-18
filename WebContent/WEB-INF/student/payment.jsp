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
<%
	session.setAttribute("filetype", "feepayment");
%>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-md-4 col-md-offset-4" style="width:100%">
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
									<input type="text" name="amount" class="form-control" id="amount" placeholder="Amount" required autofocus />
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
					</form>
				</div>
			</div>
		</div>
		</div>
</body>
</html>