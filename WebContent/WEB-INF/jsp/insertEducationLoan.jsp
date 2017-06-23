<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
<title>Apply Education Loan</title>
</head>
<body ng-app="myApp">
<div ng-controller="appController">
	<center><h2>Apply Education Loan</h2></center>
	<h2>welcome:  ${name }</h2>
	<p align="center">
			<button>
					<a
						href="http://localhost:8080/BaseCodeSlice_BankManagementSystem/mvc/home?AccNo=${msg}">Home</a>
				</button></p>
	<form:form method="POST"
		commandName="/BaseCodeSlice_BankManagementSystem/mvc/insertEducationLoan?AccNmae=${name}"
		modelAttribute="educationLoan" name="userForm">
		<table>



			<tr>
				<td>Loan Amount</td>
				<td><form:input path="eduLoanAmount" maxlength="15" ng-model="eduLoanAmount" required="true" ng-pattern="/^[0-9\b.\b]{1,15}$/"/></td>
				<td><form:errors path="eduLoanAmount" cssClass="error" /></td>
				<td> <span ng-show="userForm.eduLoanAmount.$error.required && !userForm.eduLoanAmount.$pristine" class="help-block">Required Field.</span></td>
        <td><span ng-show="userForm.eduLoanAmount.$error.pattern && !userForm.eduLoanAmount.$pristine" class="help-block">Loan Amount should be numeric</span></td>
			</tr>

			<tr>
			 <%java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy"); %>
				<td>Loan Apply Date</td>
				<td><form:input path="loanApplyDate" value="<%= df.format(new java.util.Date())%>" type="hidden"/><%= df.format(new java.util.Date())%></td>
				<td><form:errors path="loanApplyDate" cssClass="error" /></td>
			</tr>

			<tr>
				<td>Loan Duration</td>
				<td><form:select path="eduLoanDuration">
						<option value="5">5</option>
						<option value="10">10</option>
					</form:select></td>
				<td><form:errors path="eduLoanDuration" cssClass="error" /></td>
			</tr>

			<tr>
				<td>Course name</td>
				<td><form:input path="courseName" maxlength="40" ng-model="courseName" required="true" ng-pattern="/^[A-Za-z\b \b]{1,30}$/"/></td>
				<td><form:errors path="courseName" cssClass="error" /></td>
			<td><span ng-show="userForm.courseName.$error.required && !userForm.courseName.$pristine" class="help-block">Required Field.</span></td>
        <td> <span ng-show="userForm.courseName.$error.pattern && !userForm.courseName.$pristine" class="help-block">course name should contain only alphabets.</span></td>
			</tr>

			<tr>
				<td>Course Fee</td>
				<td><form:input path="courseFee" maxlength="15" ng-model="courseFee" required="true" ng-pattern="/^[0-9\b.\b]{1,15}$/"/></td>
				<td><form:errors path="courseFee" cssClass="error" /></td>
				<td><span ng-show="userForm.courseFee.$error.required && !userForm.courseFee.$pristine" class="help-block">Required Field.</span></td>
        <td><span ng-show="userForm.courseFee.$error.pattern && !userForm.courseFee.$pristine" class="help-block">Course Fee should numeric</span></td>
			</tr>

			<tr>
				<td>Father Name</td>
				<td><form:input path="fatherName" maxlength="40" ng-model="fatherName" required="true" ng-pattern="/^[A-Za-z\b \b]{1,30}$/"/></td>
				<td><form:errors path="fatherName" cssClass="error" /></td>
			<td>	<span ng-show="userForm.fatherName.$error.required && !userForm.fatherName.$pristine" class="help-block">Required Field.</span></td>
       <td><span ng-show="userForm.fatherName.$error.pattern && !userForm.fatherName.$pristine" class="help-block">Please enter only alphabets.</span></td>
			</tr>

			<tr>
				<td>ID Number</td>
				<td><form:input path="idCardNumber" minlength="5" maxlength="16" ng-model="idCardNumber" required="true" ng-pattern="/^[0-9]{1,16}$/"/></td>
				<td><form:errors path="idCardNumber" cssClass="error" /></td>
			<td>	<span ng-show="userForm.idCardNumber.$error.required && !userForm.idCardNumber.$pristine" class="help-block">Required Field and must be greater than 5 digit.</span></td>
      <td>  <span ng-show="userForm.idCardNumber.$error.pattern && !userForm.idCardNumber.$pristine" class="help-block">Please Enter only numeric value.</span></td>
			</tr>
			<tr>
				<td>Father's Annual Income</td>
				<td><form:input path="fatherAnnualIncome" maxlength="15" ng-model="fatherAnnualIncome" required="true" ng-pattern="/^[0-9\b.\b]{1,15}$/" /></td>
				<td><form:errors path="fatherAnnualIncome" cssClass="error" /></td>
			<td>	<span ng-show="userForm.fatherAnnualIncome.$error.required && !userForm.fatherAnnualIncome.$pristine" class="help-block">Required Field.</span></td>
       <td><span ng-show="userForm.fatherAnnualIncome.$error.pattern && !userForm.fatherAnnualIncome.$pristine" class="help-block">Please Enter only numeric value.</span></td>
       
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
app.controller('appController', function($scope){
	
	$scope.eduLoanAmount = "";
	$scope.fatherAnnualIncome = "";
	$scope.courseFee = "";
	$scope.courseName = "";
	$scope.fatherName = "";
	$scope.idCardNumber = "";
	 
})


</script>

</body>
</html>