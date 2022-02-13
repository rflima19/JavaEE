<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>conta</title>
</head>
<body>

<h1>Formulário Conta</h1>

<form action="/SimplificandoJSP/exibirConta2.jsp" method="POST">
	
	<label>Número:</label>
	<input type="number" name="numero" required="required" ></input> </br></br>
	
	<label>Saldo:</label>
	<input type="number" name="saldo" required="required" ></input> </br></br>
	
	<input type="submit" value="Enviar"></input>
</form>

</body>
</html>