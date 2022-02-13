<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>context</title>
</head>
<body>

<h1>Adicionar Atributo no Escopo Context Application</h1>

<c:url value="/addContext" var="addContextURL">

</c:url>

<form action="${ addContextURL }" method="POST">
	
	<label>Nome:</label>
	<input type="text" name="nome" required="required" maxlength="30"></input> </br></br>
	
	<label>Valor:</label>
	<input type="text" name="valor" required="required" maxlength="90"></input> </br></br>
	
	<input type="submit" value="Adicionar"></input>
</form>

</body>
</html>