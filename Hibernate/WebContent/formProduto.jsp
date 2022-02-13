<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Produto</title>
</head>
<body>

<form action="/Hibernate/produto/add" method="POST">
	<label>Nome:</label>
	<input type="text" maxlength="15" required="required" name="nome"/><br><br>
	<label>Valor:</label>
	<input type="number" required="required" step="0.01"  name="valor"/><br><br>
	<input type="submit" value="Cadastrar"/>
</form>
</body>
</html>