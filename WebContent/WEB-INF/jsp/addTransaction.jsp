<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Perform Transaction</title>
</head>
<body ng-app="myapp">
<div ng-controller="appctrl">
<center><h2 class="h2">Perform Transaction Page</h2></center>
	<h2>${name }</h2>
	<p align="center">
			<button>
					<a
						href="http://localhost:8080/BaseCodeSlice_BankManagementSystem/mvc/home?AccNo=${msg}">Home</a>
				</button></p>
	<form:form method="POST"
		commandName="/BaseCodeSlice_BankManagementSystem/mvc/addTransaction?AccNmae=${name}"
		modelAttribute="transaction" name="transactionForm">
		<table>

			<tr>
				<td>Transaction Description :</td>
				<td><form:input path="transactionDescription" placeholder="Transaction Description" maxlength="30" ng-model="transactionDescription"
        required="true" ng-pattern="/^[A-Za-z\b \b]{1,30}$/" /></td>
				<td><form:errors path="transactionDescription" cssClass="error" /></td>
				<td> <span ng-show="transactionForm.transactionDescription.$error.required && !transactionForm.transactionDescription.$pristine">Transaction description is required</span></td>
       <td> <span ng-show="transactionForm.transactionDescription.$error.pattern && !transactionForm.transactionDescription.$pristine">Only Alphabets are required</span></td>
			</tr>
			<tr>
				<td>Transaction Type :</td>
				<td><form:select path="transactionType">
				<option value="" disabled selected>Select account type</option>
						<option value="DEPOSIT">DEPOSIT</option>
						<option value="WITHDRAWAL">WITHDRAWAL</option>
					</form:select></td>
				<td><form:errors path="transactionType" cssClass="error" /></td>
				
			</tr>
			<tr>
				<td>Transaction Amount :</td>
				<td><form:input path="transactionAmount" placeholder="Transaction Amount" maxlength="10"  ng-pattern="/^[0-9\b.\b]{1,10}$/" ng-model="transactionAmount" required="true" /></td>
				<td><form:errors path="transactionAmount" cssClass="error" /></td>
				<td><span ng-show="transactionForm.transactionAmount.$error.required && !transactionForm.transactionAmount.$pristine">Transaction Amount is required</span></td>
        <td><span ng-show="transactionForm.transactionAmount.$error.pattern && !transactionForm.transactionAmount.$pristine">only numbers are required</span></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2"><button type="submit" value="Add">Submit</button></td>
			</tr>
		</table>
	</form:form>
	</div>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js">
</script>
<script>
 var app=angular.module('myapp', []);
 app.controller('appctrl', function($scope){
	 $scope.transactionDescription="";
	 $scope.transactionType=""; 
	 $scope.transactionAmount="";
	 
 })
</script>
</body>
</html>