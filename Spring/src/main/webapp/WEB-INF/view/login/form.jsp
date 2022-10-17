<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

<form:form commandName="loginCommand">
<form.errors element="div"/>

	아이디 : <form:input path="userId"/>
		<form:errors path="userId"/>
		<br>
		
	암호 : <form:password path="password" showPassword="false"/>
		<form:errors path="password"/>
		<br>
		
		<input type="submit">

</form:form>


</body>
</html>