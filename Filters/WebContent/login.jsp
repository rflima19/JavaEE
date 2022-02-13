<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<h1>Login</h1>

<form action="/Filters/Login" method="POST">
	<label>Usuário: </label>
	<input type="text" name="user" minlength="2" maxlength="8" required="required"></input></br>
	<label>Senha: </label>
	<input type="password" name="password" size="8" minlength="4" maxlength="15" required="required"></input></br>
	<input type="submit" value="Enviar"></input></br>
</form>

</body>
</html>