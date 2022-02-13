<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dados do Cadastro</title>

<style type="text/css">
table, th, td {
	border: 1px solid black;
	width: 100%;
	text-align: center;
}

td.titulo {
	padding: 15px;
	font-weight: bold;
}
</style>

</head>
<body>

<h1>Dados do Cadastro</h1>

<table>
<tr>
	<td class="titulo">Email</td>
	<td class="titulo">Nome</td>
	<td class="titulo">Telefone</td>
</tr>
<tr>
	<td><%= session.getAttribute("email") %></td>
	<td><%= session.getAttribute("nome") %></td>
	<td><%= session.getAttribute("telefone") %></td>
</tr>
</table>

</body>
</html>