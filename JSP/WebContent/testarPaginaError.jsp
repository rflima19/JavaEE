<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Testando p�gina de error</title>
</head>
<body>

	<%
		// causar exce��o de NullPointerException
		String s = null;
		s.toString();
	%>
</body>
</html>