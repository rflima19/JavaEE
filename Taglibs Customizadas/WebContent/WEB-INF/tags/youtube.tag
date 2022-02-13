<%@ tag language="java" pageEncoding="ISO-8859-1"%>

<!-- taglib tag file customizada para adicionar vídeos do youtube -->

<%@ attribute name="codigo" required="true" rtexprvalue="true" %>
<%@ attribute name="largura" required="true" rtexprvalue="true" %>
<%@ attribute name="altura" required="true" rtexprvalue="true" %>

<table>
<tr>
<td align="center">
	<iframe width="${ largura }" height="${ altura }" 
		src="https://www.youtube.com/embed/${ codigo }" frameborder="0" 
		allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" 
		allowfullscreen>
	</iframe>
</td>
</tr>
<tr>
<td>
	<jsp:doBody></jsp:doBody>
</td>
</tr>
</table>