<jsp:include page="header.jsp" />

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>Lista de Salas Cadastradas</h1>

<table border="1" style="width: 100%">
	<tr>
		<th align="center"><strong>Número</strong></th>
		<th align="center"><strong>Capacidade</strong></th>
		<th align="center"><strong>Turma</strong></th>
		<th></th>
	</tr>

	<c:forEach var="sala" items="${salas}">

		<tr>
			<td align="center">${ sala.numero }</td>
			<td align="center">${ sala.capacidade }</td>
			<td align="center">${ sala.turma.nome }</td>

			<c:url var="alunosURL" value="/ListarAlunos.action">
				<c:param name="numSala" value="${sala.numero}"></c:param>
			</c:url>

			<td align="center"><a href="${ alunosURL }">Alunos</a></td>
		</tr>

	</c:forEach>

</table>


<jsp:include page="footer.jsp" />