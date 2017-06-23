<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
h3{
color: blue;}
h2{
padding-top:30px;
font-style: italic;

}
table, td, th {
    border: 1px solid black;
}

table {
    border-collapse: collapse;
    width: 80%;
    align:center;
    overflow: scroll;
}

th {
    height: 50px;
     background-color: #4CAF50;
    color: white;
}
tr:hover{background-color:lightgray;}
tr:nth-child(even){background-color: #f2f2f2}
</style>
<title>View Transaction</title>
</head>

<center><h2>View Transactions</h2></center>
<h3>Welcome ${name }</h3>
<p align="center">
			<button>
					<a
						href="http://localhost:8080/BaseCodeSlice_BankManagementSystem/mvc/home?AccNo=${msg}">Home</a>
				</button></p>
<body ng-app="myApp">
	<div ng-controller="EmpCtrl">

		<input type="text" ng-model="search.$" placeholder="Search By All" />
		<hr />

		<center><table>
			<tr>
				<th>Transaction Id</th>
				<th>Transaction Description</th>
				<th>Transaction Type</th>
				<th>Transaction Amount</th>
			</tr>
			<tr ng-repeat="detail in transactionDetailsList | filter: search">
				<td>{{detail.transactionId}}</td>
				<td>{{detail.transactionDescription}}</td>
				<td>{{detail.transactionType}}</td>
				<td>{{detail.transactionAmount}}</td>

			</tr>
		</table></center>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
	<script>
        var app = angular.module('myApp', []);
        app.controller('EmpCtrl', function($scope, $http){
            $http({
              method: 'GET',
              url: 'http://localhost:8080/BaseCodeSlice_BankManagementSystem/mvc/getTransactionDetails?AccNo=${msg}'
            }).then(res=>res.data)
            .then(data => {
            	console.log(data);
            	$scope.transactionDetailsList = data;
            })
        
           })
    </script>
</body>
</html>