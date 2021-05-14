<%@page import="com.Payment"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 
<link rel="stylesheet" href="Views/bootstrap.min.css">
<link rel="stylesheet" href="Views/bootstrap.min.js">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/jquery-3.2.1.js"></script>
<script src="Components/Investors.js"></script>
<meta charset="ISO-8859-1">
<title>Payment service</title>
</head>
<body>
	
<div class="container">
<div class="row">
	
	<div class="col-8">
	<form id="formItem" name="formItem">
	
			 Benefactor: 
			<input id="Benefactor" name="Benefactor" type="text" 
			 class="form-control form-control-sm">
			 
			<br> Payer: 
			<input id="Payer" name="Payer" type="text" 
			 class="form-control form-control-sm">
			 
			<br> Amount: 
			<input id="Amount" name="Amount" type="text" 
			 class="form-control form-control-sm">
			 
			<br> Account_No: 
			<input id="Account_No" name="Account_No" type="text" 
			 class="form-control form-control-sm">
			<br>
			
			<br> Bank: 
			<input id="Bank" name="Bank" type="text" 
			 class="form-control form-control-sm">
			<br>
			
			<input id="btnSave" name="btnSave" type="button" value="Save" 
			 class="btn btn-primary">
			<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
			</form>
			<div id="alertSuccess" class="alert alert-success"></div>
			<div id="alertError" class="alert alert-danger"></div>
			
			<br>
			<div id="divItemsGrid">
			<%
				Payment itemObj = new Payment();
				out.print(itemObj.readPayment());
			%>	
			</div>
			
			
			
			
	
		</div>

	</div>

</div>
	
</body>
</html>