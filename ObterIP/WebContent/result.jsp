<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Obter IP</title>
</head>
<body>
		<h1>Seu ip é: <%= request.getAttribute("ip")  %></h1>
</body>
</html>