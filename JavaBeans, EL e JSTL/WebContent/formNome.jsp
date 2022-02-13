<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ include file="urlServlet.jsp" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nome</title>
</head>
<body>
<form action="${ processarCadastroServletURL }" method="POST">
	<input type="hidden" name="tela" value="nome"></input> </br> </br>
	<label>Nome:</label> &nbsp;
	<input type="text" name="nome" maxlength="50" required="required"></input> </br> </br>
	<input type="submit" value="Próximo"></input> </br>
</form>
</body>
</html>