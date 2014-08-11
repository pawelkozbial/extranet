<%@page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WELCOME TO SECURE AREA</title>
</head>
<body>
	<h1>
		<spring:message code="403.message" />
	</h1>
	<h1>
		<spring:message code="403.author" />
		: ${author}
	</h1>
	<c:url var="logoutUrl" value="/logout" />
	<a href="${pageContext.request.contextPath}/">Powrót na główną
		stronę</a>
	<a id="navLogoutLink" href="${logoutUrl}">Wyloguj</a>
</body>
</html>