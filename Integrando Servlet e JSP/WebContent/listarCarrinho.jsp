<%@page import="java.util.List"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.function.Consumer"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="br.com.rafael.exemplo2.model.Produto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Carrinho</title>

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

td.total {
	text-align: left;
	font-weight: bold;
}
</style>
</head>
<%! 
	private List<Produto> lista;
%>
<body>

<h1>Carrinho de Compras</h1>

<table>
<tr>
	<td class="titulo">Nome</td>
	<td class="titulo">Valor</td>
</tr>
<%
	this.lista = (List<Produto>) request.getAttribute("lista");
	
	/*
		Calcula a soma de todos os valores dos produtos do carrinho
	*/
	Double soma = this.lista.stream().mapToDouble((Produto p) -> p.getValor()).sum();
	Locale locale = Locale.getDefault();
	String valorCompra = NumberFormat.getCurrencyInstance(locale).format(soma);

	for (Produto p : this.lista) {
%>
<tr>
	<td><%= p.getNome().toString() %></td>
	<td><%= Double.valueOf(p.getValor()).toString() %></td>
</tr>
<%
	}
%>

<tr>
	<td class="total" colspan="2">Total: <%= valorCompra.toString() %></td>
</tr>

</table>

<p><a href="/integracao/produtos">Voltar as compras</a></p>

</body>
</html>