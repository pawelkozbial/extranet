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

		<%-- <h3>Użytkownicy</h3>
		<c:if test="${!empty userList}">
			<table id="mytable" class="table tablesorter">
				<thead>
					<tr>
						<th>Imię</th>
						<th>Nazwisko</th>
						<th>Email</th>
						<!-- <th>Hasło</th> -->
						<th>Data urodzenia</th>
						<th>Aktywny</th>
						<th>Rola</th>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<th>&nbsp;</th>
						</sec:authorize>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userList}" var="user">
						<tr>
							<td>${user.firstName}</td>
							<td>${user.lastName}</td>
							<td>${user.email}</td>
							<td>${user.password}</td>
							<td>${user.dateOfBirth}</td>
							<td>${user.enabled}</td>
							<td>${user.role.authority}</td>
							<sec:authorize access="hasRole('ROLE_ADMIN')">
								<td><a
									href="${pageContext.request.contextPath}/user/edit/${user.id}">edit</a>
									<a
									href="${pageContext.request.contextPath}/user/delete/${user.id}">delete</a></td>
							</sec:authorize>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if> --%>
	</div>

	<footer>
		<jsp:include page="../templates/footer.jsp" />
	</footer>
</body>
</html>
