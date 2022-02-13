<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Telefone</title>
</head>
<body>
<form action="/integracao/ProcessarFormTelefone" method="POST">
	<label>Telefone:</label> &nbsp;
	<input type="tel" name="telefone" pattern="^\(\d{2}\)\d{4}-\d{4}$" maxlength="50" required="required"></input> </br> </br>
	<input type="submit" value="Próximo"></input> </br>
</form>
</body>
</html>