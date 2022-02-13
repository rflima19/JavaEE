<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<form method="POST" action="j_security_check">
	<label>Usuário:</label>
	<input type="text" name="j_username"></input></br></br>
	<label>Senha:</label>
	<input type="password" name="j_password"></input></br></br>
	<input type="submit" value="Login"></input></br></br>
</form>
</body>
</html>