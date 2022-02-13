<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ocorreu um error</title>
</head>
<body>

	<p><strong>Mensagem:</strong></p>
	<p><%= exception.getMessage() %></p>
</body>
</html>