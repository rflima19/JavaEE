<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista</title>
</head>
<body>

<h1>Dados do Cadastro</h1>

<p> Email: ${ sessionScope["email"] }</p>

<p> Nome: ${ sessionScope["nome"] }</p>

<p> Telefone: ${ sessionScope["telefone"] }</p>

</body>
</html>