<%@page import="java.util.Locale"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hora</title>
</head>
<body>

<%
	LocalTime time = LocalTime.now();
%>

<h1><%= time.format(DateTimeFormatter.ofPattern("HH:mm:ss", Locale.getDefault())) %></h1>

</body>
</html>