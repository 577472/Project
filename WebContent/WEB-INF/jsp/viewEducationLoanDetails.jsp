<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Education Loan</title>
</head>

<body ng-app="myApp">
	<div ng-controller="EmpCtrl">


		<input type="text" ng-model="search.eduLoanAccountNumber"
			placeholder="Search By Loan Account Number" />
		<hr />

		<table>
			<tr>
				<th>Loan Account Number</th>
				<th>Loan Id</th>
				<th>Loan Amount</th>
				<th>Apply Date</th>
				<th>Loan Duration</th>
				<th>Father Annual Income</th>
				<th>Course Fee</th>
				<th>Course Name</th>
				<th>Father Name</th>
				<th>Id Card Number</th>
			</tr>
			<tr ng-repeat="e in eduLoan | filter: search">
				<td>{{e.eduLoanAccountNumber}}</td>
				<td>{{e.educationLoanID}}</td>
				<td>{{e.eduLoanAmount}}</td>
				<td>{{e.loanApplyDate}}</td>
				<td>{{e.eduLoanDuration}}</td>
				<td>{{e.fatherAnnualIncome}}</td>
				<td>{{e.courseFee}}</td>
				<td>{{e.courseName}}</td>
				<td>{{e.fatherName}}</td>
				<td>{{e.idCardNumber}}</td>
			</tr>
		</table>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
	<script>
        var app = angular.module('myApp', []);
        app.controller('EmpCtrl', function($scope, $http){
            $http({
              method: 'GET',
              url: 'http://localhost:8080/BaseCodeSlice_BankManagementSystem/mvc/viewEducationLoanDetails1'
            }).then(res=>res.data)
            .then(data => {
            	console.log(data);
            	$scope.eduLoan = data;
            	console.log($scope.eduLoan);
            })
        
           
        })
    </script>
</body>
</html>