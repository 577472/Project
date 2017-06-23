<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Successful</title>
</head>
<Style>
h2{
padding-top:30px;
font-style: italic;
}
</Style>
<body>
	<center><h2>success ${m1}</h2></center>
	<center><h2>updated balance ${m2}</h2></center>
	<p align="center">
			<button>
					<a
						href="http://localhost:8080/BaseCodeSlice_BankManagementSystem/mvc/home?AccNo=${msg}">Home</a>
				</button></p>
				</body>
</html>