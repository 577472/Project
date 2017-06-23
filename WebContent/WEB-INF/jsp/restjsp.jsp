<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.login
{ width:400px;
margin-left:500px;
margin-top:100px;
background-color:#bfbfbf;
border-radius:20px;
}
body{
background-color: white;
}
.button {
  border-radius: 4px;
  background-color: powderblue;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 28px;
  padding: 8px;
  width: 150px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}
h2{
padding-top: 80px;
font-style: italic;
}
.input{
width: 70%;

}
input.Placeholder{
align: center;
}

</style>
<body ng-app="myApp" ng-controller="AppCtrl">
	<center>
		<marquee behavior="alternate"><h2 class="h2" >Welcome To Bank Management System</h2></marquee><hr>
	</center>
	<!-- Please add your application links by replacing the below sample links -->
	<div class="login"><center>
	
		<h3>LOGIN</h3>
	</center>
	<!-- Please add your application links by replacing the below sample links -->
	<form method="POST" action="mvc/rest" name="userForm">
		<br>
		
		<center><div class="input">
			<input Placeholder="Account Number" type="Text" maxlength="16"
				name="AccNo" ng-model="AccountNumber" required="true"
				ng-pattern="/^[0-9/b./b]{1,16}$/"></input>
			<td><errors path="AccountNumber" cssClass="error" /></td>
			<td><span
				ng-show="userForm.AccNo.$error.required && !userForm.AccNo.$pristine"
				style="color: #FF0000">Enter Account Number.</span></td>
			<td><span
				ng-show="userForm.AccNo.$error.pattern && !userForm.AccNo.$pristine"
				style="color: #FF0000">Only Numeric input.</span></td>
				<input Placeholder="Loan Account Number" type="Text" maxlength="16"
				name="LoanAccNo" ng-model="LoanAccountNumber" required="true"
				ng-pattern="/^[0-9/b./b]{1,16}$/"></input>
			<td><errors path="AccountNumber" cssClass="error" /></td>
			<td><span
				ng-show="userForm.LoanAccNo.$error.required && !userForm.LoanAccNo.$pristine"
				style="color: #FF0000">Enter Account Number.</span></td>
			<td><span
				ng-show="userForm.AccNo.$error.pattern && !userForm.LoanAccNo.$pristine"
				style="color: #FF0000">Only Numeric input.</span></td>
			<center>
				<button class="button" type="submit" ng-disabled="userForm.$invalid"><span>Login</span></button>
			</center>
		</div></center></div>
	</form>
	</center>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
	<script>
		var app = angular.module('myApp', []);

		app.controller('AppCtrl', function($scope) {

		})
	</script>

</body>
</html>