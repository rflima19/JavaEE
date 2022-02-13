<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contexto Context</title>

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

<h1>Lista de atributos contexto context</h1>

<table>
<tr>
	<td class="titulo">Nome</td>
	<td class="titulo">Valor</td>
</tr>
<%
	// recupera o atributo do contexto request
	Map<String, Object> atributos = (Map<String, Object>) request.getAttribute("map");
	
	Set<Map.Entry<String, Object>> entrys = atributos.entrySet();
	for (Map.Entry<String, Object> entry : entrys) {
		String nameAttr = entry.getKey();
		Object attr = entry.getValue();
%>
<tr>
	<td><%= nameAttr.toString() %></td>
	<td><%= attr.toString() %></td>
</tr>
<%
	}
%>
</table>

<p><a href="/integracao/formContextoAplicacao.jsp">Set atributo</a></p>

</body>
</html>