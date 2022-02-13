<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contexto Context</title>
</head>
<body>

	<h1>Set atributo no contexto context</h1>

	<form action="/integracao/ProcessarContextoAplicacao" method="POST">
		<label>Nome:</label> &nbsp;
		<input type="text" name="nome" maxlength="50" ></input> </br></br>
		
		<label>Valor:</label> &nbsp;
		<input type="text" name="valor" maxlength="50"></input> </br></br>
		
		<input type="submit" value="Salvar"></input> </br>
	</form>
</body>
</html>