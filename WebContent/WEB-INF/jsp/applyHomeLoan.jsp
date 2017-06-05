<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
<title>Apply home Loan</title>
</head>
<body>
	<h1>Apply home Loan</h1>
	<form:form method="POST"
		commandName="/BaseCodeSlice_BankManagementSystem/mvc/applyHomeLoan"
		modelAttribute="homeLoan">
		
		<table>

			<tr>
				<td>Loan Amount :</td>
				<td><form:input path="loanAmount" /></td>
				<td><form:errors path="loanAmount" cssClass="error" /></td>
			</tr>
			<tr>
			 <%java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy"); %>
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
				<td><form:input path="annualIncome" /></td>
				<td><form:errors path="annualIncome" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Company Name :</td>
				<td><form:input path="companyName" /></td>
				<td><form:errors path="companyName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Designation :</td>
				<td><form:input path="designation" /></td>
				<td><form:errors path="designation" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Total Exp :</td>
				<td><form:input path="totalExperience" /></td>
				<td><form:errors path="totalExperience" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Exp with Current company :</td>
				<td><form:input path="currentExperience" /></td>
				<td><form:errors path="currentExperience" cssClass="error" /></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2"><button type="submit" value="Add">Submit</button></td>
			</tr>
		</table>
	</form:form>

</body>
</html>