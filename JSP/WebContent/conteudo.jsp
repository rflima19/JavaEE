<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>P�gina Inicial</title>
</head>
<body>

	<!-- adicionando conte�do JSP externo utilizando a diretiva include -->
	<%@ include file="header.jsp"%>
	
	<!-- adicionando conte�do JSP externo utilizando a action JSP include -->
	<jsp:include page="header.jsp"></jsp:include>
</body>
</html>