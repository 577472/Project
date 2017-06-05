<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
<title>Apply Education Loan</title>
</head>
<body>
	<h1>Apply Education Loan</h1>
	<form:form method="POST"
		commandName="/BaseCodeSlice_BankManagementSystem/mvc/insertEducationLoan"
		modelAttribute="educationLoan">
		<table>



			<tr>
				<td>Loan Amount</td>
				<td><form:input path="eduLoanAmount" /></td>
				<td><form:errors path="eduLoanAmount" cssClass="error" /></td>
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
				<td><form:input path="courseName" /></td>
				<td><form:errors path="courseName" cssClass="error" /></td>
			</tr>

			<tr>
				<td>Course Fee</td>
				<td><form:input path="courseFee" /></td>
				<td><form:errors path="courseFee" cssClass="error" /></td>
			</tr>

			<tr>
				<td>Father Name</td>
				<td><form:input path="fatherName" /></td>
				<td><form:errors path="fatherName" cssClass="error" /></td>
			</tr>

			<tr>
				<td>ID Number</td>
				<td><form:input path="idCardNumber" /></td>
				<td><form:errors path="idCardNumber" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Father's Annual Income</td>
				<td><form:input path="fatherAnnualIncome" /></td>
				<td><form:errors path="fatherAnnualIncome" cssClass="error" /></td>
			</tr>

			<tr>
				<td></td>
				<td colspan="2"><button type="submit" value="Add">Submit</button></td>
			</tr>
		</table>
	</form:form>

</body>
</html>