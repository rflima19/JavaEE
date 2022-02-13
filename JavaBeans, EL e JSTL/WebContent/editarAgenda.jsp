<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Adicionando a taglib JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<!-- utilizando as tag libs do JSTL -->
<!-- lendo url usando Expression Language (EL) -->
<c:choose>
	<c:when test="${ contato.id != null }">
		<title>Editar Contato</title>
	</c:when>
	<c:otherwise>
		<title>Criar Contato</title>
	</c:otherwise>
</c:choose>

</head>
<body>

<!-- utilizando as tag libs do JSTL -->
<!-- lendo url usando Expression Language (EL) -->
<c:choose>
	<c:when test="${ contato.id != null }">
		<h1>Editar Contato</h1>
	</c:when>
	<c:otherwise>
		<h1>Criar Contato</h1>
	</c:otherwise>
</c:choose>

<!-- utilizando as tag libs do JSTL -->
<!-- lendo url usando Expression Language (EL) -->
<c:url value="/Agenda/Salvar" var="salvarContatoURL"></c:url>

<form action="${ salvarContatoURL }" method="POST">
	
	<c:if test="${ contato != null }">
		<input type="hidden" name="id" value="${ contato.id }"></input>
	</c:if>
	
	<label>Nome:</label>
	<input type="text" name="nome" value="${ contato.nome }" required="required" ></input> </br></br>
	
	<label>Telefone:</label>
	<input type="tel" name="telefone" value="${ contato.telefone }" required="required" ></input> </br></br>
	
	<input type="submit" value="Salvar"></input>
</form>

</body>
</html>