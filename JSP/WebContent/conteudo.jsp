<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página Inicial</title>
</head>
<body>

	<!-- adicionando conteúdo JSP externo utilizando a diretiva include -->
	<%@ include file="header.jsp"%>
	
	<!-- adicionando conteúdo JSP externo utilizando a action JSP include -->
	<jsp:include page="header.jsp"></jsp:include>
</body>
</html>