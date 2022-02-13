<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.StringWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Erro Desconhecido</title>
</head>
<body>

<h1>Erro interno da aplicação</h1>

<p><strong>Informações do erro:</strong></p>
<p>
	Mensagem de erro: <%= exception.getMessage() %>
</p>
<p>
	StackTrace: </br>
	<%
		StringWriter sw = new StringWriter();
		exception.printStackTrace(new PrintWriter(sw));
	%>
	<%= sw.toString() %>
</p>

<p>
	Contate o adm: <%= application.getInitParameter("adminEmail") %>
</p>
</body>
</html>