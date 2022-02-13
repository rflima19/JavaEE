<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dados Conta</title>
</head>
<body>

<!-- definindo um javabean -->
<jsp:useBean id="conta" class="br.com.rafael.test.javabeans.Conta" scope="request"></jsp:useBean>

<!-- alterando propriedades do javabean -->
<jsp:setProperty property="numero" name="conta" value="9876"/>
<jsp:setProperty property="saldo" name="conta" value="2000.0"/>

<h1>Dados Conta</h1>

<!-- acessando propriedades do javabean -->
<p> Número da Conta: <jsp:getProperty property="numero" name="conta"/> </p> 

<p> Saldo da Conta: <jsp:getProperty property="saldo" name="conta"/> </p> 

</body>
</html>