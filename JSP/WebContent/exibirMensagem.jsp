<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%!
		private String mensagem;
	%>
	
	<%
		this.mensagem = config.getInitParameter("mensagem");
	%>
	
	<h1>
		<%= this.mensagem.toString() %>
	</h1>
</body>
</html>