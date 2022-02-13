<%@page import="java.util.Set"%>
<%@page import="java.util.Properties"%>
<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Listagem do arquivo props.txt</title>

	<style type="text/css">
		table, th, td {
			border: 1px solid black;
			width: 100%;
		}
		
		td.titulo {
			padding: 15px;
  			text-align: center;
  			font-weight: bold;
		}
	</style>

</head>

<body>

	<%!
		/*Declaration*/
	
		// atributo
		private Properties props = new Properties();
	%>

	<%
		/*Scriptlet*/

		/* utilizando objeto implicito JSP: o objeto implicito utilizado 
		foi o application que retorna o objeto ServletContext da 
		aplicação web. O caminho passado é um caminho relativo ao contexto da aplicação, 
		pois começa com /, se não possui o / é relativo a página JSP.
		*/
		InputStream in = application.getResourceAsStream("/WEB-INF/props.txt");
		//Properties props = new Properties();
		this.props.load(in);
		Set<Object> keys = this.props.keySet();
	%>

	<table>
		<tr>
			<td class="titulo">Nome</td>
			<td class="titulo">Valor</td>
		</tr>
		
		<% for(Object obj : keys) {
			String key = (String) obj;
			String value = this.props.getProperty(key);
		%>
		<tr>
			<td>
				<%= 
					/*Expressions*/
				
					key.toString()
				%>
			</td>
			<td>
				<%=
					/*Expressions*/
					
					value.toString()
				%>
			</td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>