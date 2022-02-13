<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Filter</title>
</head>
<body>

<h1>Adicionar Propriedades Session</h1>

<form action="/Filters/AdicionaAtributoSession" method="POST">
	<label>Nome: </label>
	<input type="text" name="nome" minlength="2" maxlength="8" required="required"></input></br>
	<label>Valor: </label>
	<input type="text" name="valor" minlength="2" maxlength="8" required="required"></input></br>
	<input type="submit" value="Enviar"></input>
</form>

</body>
</html>