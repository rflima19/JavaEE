<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file="urlServlet.jsp" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Email</title>
</head>

<body>
<form action="${ processarCadastroServletURL }" method="POST">
	<input type="hidden" name="tela" value="email"></input> </br> </br>
	<label>Email:</label> &nbsp;
	<input type="email" name="email" required="required"></input> </br> </br>
	<input type="submit" value="Próximo"></input> </br>
</form>
</body>
</html>