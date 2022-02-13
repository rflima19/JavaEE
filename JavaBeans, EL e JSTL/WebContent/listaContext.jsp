<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Context</title>

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

<h1>Atributos do Escopo Context Application</h1>

<table>
	<tr>
		<td></td>
		<td class="titulo">Nome</td>
		<td class="titulo">Valor</td>
	</tr>
	<!-- acessa os atributos do escopo context através do objeto implicito applicationScope do EL -->
	<c:forEach items="${ applicationScope }" var="attr" varStatus="pos" >
		<tr>
			<td>${ pos.count }</td>
			<td>${ attr["key"] }</td>
			<td>${ attr["value"] }</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>