<%@page contentType="text/html;charset=UTF-8" language="java"
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
<title>Edycja użytkownika</title>

<jsp:include page="../templates/resources.jsp"></jsp:include>

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
			<form:form method="post"
				action="${pageContext.request.contextPath}/user/updateUser"
				commandName="user">

				<jsp:include page="editMain.jsp" />

			</form:form>
		</sec:authorize>

		<sec:authorize access="hasAnyRole('ROLE_READ','ROLE_USER')">
			<form:form method="post"
				action="${pageContext.request.contextPath}/user/update"
				commandName="user">

				<jsp:include page="editMain.jsp" />

				<%-- <input type="submit" class="btn btn-default"
				value="<spring:message code="user.btn.save"/>" /> --%>
			</form:form>
		</sec:authorize>
	</div>
	<footer>
		<jsp:include page="../templates/footer.jsp" />
	</footer>
</body>
</html>