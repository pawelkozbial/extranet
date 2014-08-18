<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dodanie użytkownika</title>

<jsp:include page="../templates/resources.jsp" />

</head>
<body>

	<header>
		<jsp:include page="../templates/header.jsp" />
	</header>
	<nav>
		<jsp:include page="../templates/menu.jsp" />
	</nav>
	<div id="content" class="main">
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<c:if test="${param.logout != null}">
				<div class="error">You have been logged out.</div>
			</c:if>
			<h2>User Manager</h2>

			<form:form method="post"
				action="${pageContext.request.contextPath}/user/add"
				commandName="user">

				<jsp:include page="userMain.jsp" />

				<%-- <div align="right">
					<input type="submit" class="btn btn-default input-sm"
						value="<spring:message code="user.btn.add"/>" />
				</div> --%>
			</form:form>
		</sec:authorize>
	</div>

	<footer>
		<jsp:include page="../templates/footer.jsp" />
	</footer>
</body>
</html>
