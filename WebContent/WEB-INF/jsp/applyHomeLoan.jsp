<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
<title>Apply home Loan</title>
</head>
<body ng-app="myApp">
  <div ng-controller="AppCtrl">
  <center><h2>Home Loan Application</h2></center>
	<h2>${name }</h2>
	<p align="center">
			<button>
					<a
						href="http://localhost:8080/BaseCodeSlice_BankManagementSystem/mvc/home?AccNo=${msg}">Home</a>
				</button></p>
	<form:form method="POST"
		commandName="/BaseCodeSlice_BankManagementSystem/mvc/applyHomeLoan?AccNmae=${name}"
		modelAttribute="homeLoan" name="userForm">
		
		<table>

			<tr>
				<td>Loan Amount :</td>
				<td><form:input path="loanAmount" ng-pattern="/^[0-9/b./b]{1,15}$/" maxlength="15" ng-model="loanAmount" required="true" /></td>
				<td><form:errors path="loanAmount" cssClass="error" /></td>
				<td><span ng-show="userForm.loanAmount.$error.required && !userForm.loanAmount.$pristine" >Enter Loan Amount.</span> </td>
          <td><span ng-show="userForm.loanAmount.$error.pattern && !userForm.loanAmount.$pristine" >Only Numeric input.</span></td>
			</tr>
			<tr>
			 <%java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy/dd/MM"); %>
				<td>Loan Apply Date :</td>
				<td><form:input path="loanApplyDate"  value="<%= df.format(new java.util.Date())%>"  type="hidden"/>	<%= df.format(new java.util.Date())%></td>
			
				<td><form:errors path="loanApplyDate" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Duration of the loan :</td>
				<td><form:select path="loanDuration">
						<option value="5">5</option>
						<option value="10">10</option>
						<option value="15">15</option>
					</form:select></td>
				<td><form:errors path="loanDuration" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Annual Income :</td>
				<td><form:input path="annualIncome" ng-pattern="/^[0-9\b.\b]{1,15}$/" maxlength="15" ng-model="annualIncome" required="true"/></td>
				<td><form:errors path="annualIncome" cssClass="error" /></td>
				<td><span ng-show="userForm.annualIncome.$error.required && !userForm.annualIncome.$pristine" >Enter Annual Income.</span> </td>
          <td><span ng-show="userForm.annualIncome.$error.pattern && !userForm.annualIncome.$pristine" >Only Numeric input.</span></td>
			</tr>
			<tr>
				<td>Company Name :</td>
				<td><form:input path="companyName"  maxlength="40" ng-model="companyName" required="true"/></td>
				<td><form:errors path="companyName" cssClass="error" /></td>
				<td><span ng-show="userForm.companyName.$error.required && !userForm.companyName.$pristine" >Enter Company Name.</span> </td>
          
			</tr>
			<tr>
				<td>Designation :</td>
				<td><form:input path="designation" ng-pattern="/^[A-Za-z\b \b]{1,40}$/" maxlength="40" ng-model="designation" required="true"/></td>
				<td><form:errors path="designation" cssClass="error" /></td>
			<td>	 <span ng-show="userForm.designation.$error.required && !userForm.designation.$pristine" >Enter Designation.</span> </td>
         <td> <span ng-show="userForm.designation.$error.pattern && !userForm.designation.$pristine" >Only Alphabets are allowed.</span></td>
			</tr>
			<tr>
				<td>Total Exp :</td>
				<td><form:input path="totalExperience" ng-pattern="/^[0-9\b.\b]{1,15}$/" maxlength="15" placeholder="Total Exp" ng-model="totalExperience" required="true"/></td>
				<td><form:errors path="totalExperience" cssClass="error" /></td>
				<span ng-show="userForm.totalExperience.$error.required && !userForm.totalExperience.$pristine" >Enter Total Experience.</span> 
        <td>  <span ng-show="userForm.totalExperience.$error.pattern && !userForm.totalExperience.$pristine" >Only Numeric input.</span></td>
			</tr>
			<tr>
				<td>Exp with Current company :</td>
				<td><form:input path="currentExperience" ng-pattern="/^[0-9\b.\b]{1,15}$/" maxlength="15" ng-model="currentExperience" required="true"/></td>
				<td><form:errors path="currentExperience" cssClass="error" /></td>
			<td>	<span ng-show="userForm.currentExperience.$error.required && !userForm.currentExperience.$pristine" >Enter Current Experience.</span></td> 
         <td> <span ng-show="userForm.currentExperience.$error.pattern && !userForm.currentExperience.$pristine" >Only Numeric input.</span></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2"><button type="submit" ng-disabled="userForm.$invalid" value="Add">Submit</button></td>
			</tr>
		</table>
	</form:form>
	</div>
  
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script>
	var app = angular.module('myApp', []);
	
	app.controller('AppCtrl', function($scope){
		
	})
</script>

</body>
</html>