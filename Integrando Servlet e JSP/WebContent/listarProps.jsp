<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar</title>

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

	<%
		/*
			recupera o atributo passado do servlet no escopo request 
		*/
		Map<String, String> map = (Map<String, String>) request.getAttribute("props");
	%>

	<h1>Listar Propriedades</h1>

	<a href="/integracao/editar">Criar nova propriedade</a>
	<table>
		<tr>
			<td class="titulo">Key</td>
			<td class="titulo">Value</td>
			<td colspan="2"></td>
		</tr>
		
		<%
			Set<Map.Entry<String, String>> entrys = map.entrySet();
			
			for (Map.Entry<String, String> entry : entrys) {
				String key = entry.getKey();
				String value = entry.getValue();
		%>
		
		<tr>
			<td><%= key.toString() %></td>
			<td><%= value.toString() %></td>
			<td><a href="/integracao/editar?prop=<%= key.toString() %>">Editar</a></td>
			<td><a href="/integracao/deletar?prop=<%= key.toString() %>">Excluir</a></td>
		</tr>
		
		<% } %>
	</table>

</body>
</html>