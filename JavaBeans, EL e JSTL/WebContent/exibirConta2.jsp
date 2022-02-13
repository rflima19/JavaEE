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

<!--
<jsp:setProperty property="numero" name="conta"/>
<jsp:setProperty property="saldo" name="conta"/>
-->

<!--
<jsp:setProperty property="*" name="conta"/>
-->

<jsp:setProperty property="numero" name="conta" param="numero"/>
<jsp:setProperty property="saldo" name="conta" param="saldo"/>

<h1>Dados Conta</h1>

<p> Número da Conta: <jsp:getProperty property="numero" name="conta"/> </p> 

<p> Saldo da Conta: <jsp:getProperty property="saldo" name="conta"/> </p> 

</body>
</html>