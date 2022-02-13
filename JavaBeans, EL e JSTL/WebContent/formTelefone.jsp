<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file="urlServlet.jsp" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Telefone</title>
</head>
<body>
<form action="${ processarCadastroServletURL }" method="POST">
	<input type="hidden" name="tela" value="telefone"></input> </br> </br>
	<label>Telefone:</label> &nbsp;
	<input type="tel" name="telefone" pattern="^\(\d{2}\)\d{4}-\d{4}$" maxlength="50" required="required"></input> </br> </br>
	<input type="submit" value="Próximo"></input> </br>
</form>
</body>
</html>