<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Email</title>
</head>
<body>
<form action="/integracao/ProcessarFormEmail" method="POST">
	<label>Email:</label> &nbsp;
	<input type="email" name="email" required="required"></input> </br> </br>
	<input type="submit" value="Próximo"></input> </br>
</form>
</body>
</html>