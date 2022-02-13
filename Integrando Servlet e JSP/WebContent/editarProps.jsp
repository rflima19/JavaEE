<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%
	String titulo = (String) request.getAttribute("titulo");
	String id = (String) request.getAttribute("id");
	String valor = (String) request.getAttribute("valor");
%>
<title><%= (titulo == null) ? "Cadastrar" : titulo %></title>
</head>
<body>

	<h1><%= (titulo == null) ? "Cadastrar" : titulo %> Propriedade</h1>

	<form action="/integracao/salvar" method="POST">
		<label>Chave:</label> &nbsp;
		<%
			if (titulo != null) {
		%>
		<input type="text" name="id" value="<%= (id == null) ? "" : id %>" maxlength="20" readonly ></input> </br></br>
		<% 
			} else { 
		%>
		<input type="text" name="id" value="<%= (id == null) ? "" : id %>" maxlength="20" ></input> </br></br>		
		<%
			}
		%>
		
		<label>Valor:</label> &nbsp;
		<input type="text" name="valor" value="<%= (valor == null) ? "" : valor %>" maxlength="20"></input> </br></br>
		
		<input type="submit" value="Salvar"></input> </br>
	</form>

</body>
</html>