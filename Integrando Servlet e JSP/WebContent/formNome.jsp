<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nome</title>
</head>
<body>
<form action="/integracao/ProcessarFormNome" method="POST">
	<label>Nome:</label> &nbsp;
	<input type="text" name="nome" maxlength="50" required="required"></input> </br> </br>
	<input type="submit" value="Pr�ximo"></input> </br>
</form>
</body>
</html>