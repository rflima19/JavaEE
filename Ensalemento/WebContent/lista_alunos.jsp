<jsp:include page="header.jsp" />

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>Lista de Alunos da Sala ${ sala.numero }</h1>
<h2>Capacidade: ${ sala.capacidade }</h2>
<h3>Alunos na Sala: ${ qtdAlunos }</h3>

<table border="1" style="width: 100%">

	<c:url var="ordemMatriculaURL" value="/ListarAlunos.action">
		<c:param name="numSala" value="${ sala.numero }"></c:param>
		<c:param name="ordem" value="${ MATRICULA }"></c:param>
	</c:url>

	<c:url var="ordemNomeURL" value="/ListarAlunos.action">
		<c:param name="numSala" value="${ sala.numero }"></c:param>
		<c:param name="ordem" value="${ NOME }"></c:param>
	</c:url>

	<tr>
		<th align="center"><a href="${ ordemMatriculaURL }"><strong>Matricula</strong></a></th>
		<th align="center"><a href="${ ordemNomeURL }"><strong>Nome</strong></a></th>
		<th></th>
	</tr>

	<c:choose>
		<c:when test="${ !empyt(alunos) }">
			<c:forEach var="aluno" items="${ alunos }">
				<tr>
					<td align="center">${ aluno.matricula }</td>
					<td align="center">${ aluno.nome }</td>
					
					<c:url var="excluirAlunoURL" value="/ExcluirAlunoSala.action">
						<c:param name="matricula">${ aluno.matricula }</c:param>
					</c:url>
					
					<td align="center"><a href="${ excluirAlunoURL }">Excluir</a></td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td align="center" colspan="3">Nenhum aluno encontrado na sala</td>
			</tr>
		</c:otherwise>
	</c:choose>
</table>

<c:if test="${ qtdAlunos < sala.capacidade }">
	<c:url var="procurarAlunoURL" value="/ProcurarAluno.action">
		<c:param name="numSala" value="${ sala.numeo }"></c:param>
	</c:url>
	<p><a href="${ procurarAlunoURL }">Adicionar alunos à sala</a></p>
</c:if>

<jsp:include page="footer.jsp" />