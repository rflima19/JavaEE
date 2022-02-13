<%@page import="br.com.rafael.agenda.model.Contato"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- Adicionando a taglib JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Contatos</title>

<style type="text/css">
table, th, td {
	border: 1px solid black;
	width: 100%;
	text-align: center;
}

td.titulo {
	padding: 15px;
	font-weight: bold;
}
</style>

</head>
<body>

<h1>Lista de Contatos</h1>

<!-- utilizando as tag libs do JSTL -->
<c:url value="/Agenda/Editar" var="novoContatoURL"></c:url>

<!-- lendo url usando Expression Language (EL) -->
<a href="${ novoContatoURL }">Criar Novo Contato</a>

</br></br>

<table>
<tr>
	<td class="titulo">Nome</td>
	<td class="titulo">Telefone</td>
	<td></td>
</tr>

 
<%
	//Set<Contato> contatos = (Set<Contato>) request.getAttribute("contatos");
%>

<!-- utilizando as tag libs do JSTL -->
<c:choose>
	
	<c:when test="${ not (empty (contatos)) }">
		
		<!-- utilizando as tag libs do JSTL -->
		<c:forEach items="${contatos}" var="contato">
		
			<tr>
				<c:url value="/Agenda/Editar" var="editarContatoURL">
					
					<c:param name="id" value="${ contato.id }"></c:param>
				</c:url>
				
				<c:url value="/Agenda/Excluir" var="excluirContatoURL">
					<c:param name="id" value="${ contato.id }"></c:param>
				</c:url>
			
				<!-- lendo dados do contato usando Expression Language (EL) -->
				<td><a href="${ editarContatoURL }">${ contato.nome }</a></td>
				<td>${ contato.telefone }</td>
				<td><a href="${ excluirContatoURL }">Excluir</a></td>
			</tr>

		</c:forEach>
	
	</c:when>

	<c:otherwise>
		<tr>
			<td colspan="3">Nenhum Contato Encontrado!!!</td>
		</tr>
	</c:otherwise>
	
</c:choose>

</table>

</body>
</html>