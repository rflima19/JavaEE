<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="br.com.rafael.exemplo2.model.Produto"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Produtos</title>

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
<%! 
	private Collection<Produto> lista;
%>
<body>

<h1>Lista de Produtos</h1>

<table>
<tr>
	<td class="titulo">Nome</td>
	<td class="titulo">Valor</td>
	<td></td>
</tr>
<%
	this.lista = (Collection<Produto>) request.getAttribute("lista");

	for (Produto p : this.lista) {
%>
<tr>
	<td><%= p.getNome().toString() %></td>
	<td><%= Double.valueOf(p.getValor()).toString() %></td>
	<td><a href="/integracao/adicionar?id=<%= Integer.valueOf(p.getId()).toString() %>">Adicionar ao carrinho</a></td>
</tr>
<%
	}
%>
</table>

<p><a href="/integracao/carrinho">Visualizar Carrinho</a></p>

</body>
</html>