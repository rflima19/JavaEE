<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulário</title>
</head>
<body>

<%
	// obtem os cookies enviados do browser do cliente 
	Cookie[] cookies = request.getCookies();
	String nome = "";
	
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("nomeUser")) {
				nome = cookie.getValue();
				break;
			}
		}
	}
%>

<form action="/integracao/processarCookie" method="POST">
	<label>Nome:</label> &nbsp;
	<input type="text" name="nome" value="<%= nome.toString() %>"></input> </br> </br>
	<input type="submit" value="Enviar"></input> </br>
</form>
</body>
</html>