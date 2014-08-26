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
<title>Lista wszystkich użytkowników</title>

<jsp:include page="../templates/resources.jsp" />

</head>
<body>

	<header>
		<jsp:include page="../templates/header.jsp" />
	</header>
	<%-- <section>
		<jsp:include page="../templates/log.jsp"></jsp:include>
	</section> --%>
	<nav>
		<jsp:include page="../templates/menu.jsp" />
	</nav>
	<div id="content" class="main">
		<sec:authorize access="isAuthenticated()">
			<c:if test="${param.logout != null}">
				<div class="error">You have been logged out.</div>
			</c:if>
		</sec:authorize>

		<h3>Użytkownicy</h3>
		<c:if test="${!empty userList}">
			<table id="mytable" class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Nazwisko</th>
						<th>Imię</th>
						<th>Email</th>
						<th>Data urodzenia</th>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<th>Aktywny</th>
							<th>Rola</th>
							<th class="nosort">&nbsp;</th>
						</sec:authorize>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userList}" var="user">
						<tr>
							<td>${user.lastName}</td>
							<td>${user.firstName}</td>
							<td>${user.email}</td>
							<td>${user.dateOfBirth}</td>
							<sec:authorize access="hasRole('ROLE_ADMIN')">
								<c:choose>
									<c:when test="${user.enabled == true}">
										<td>Tak</td>
									</c:when>
									<c:otherwise>
										<td>Nie</td>
									</c:otherwise>
								</c:choose>
								<td>${user.role.authority}</td>
								<td><a
									href="${pageContext.request.contextPath}/user/edit/${user.id}"><spring:message
											code="general.edit" /></a> <a
									href="${pageContext.request.contextPath}/user/delete/${user.id}"><spring:message
											code="general.delete" /></a></td>
							</sec:authorize>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<%-- <div class="form-group">
			<ul class="pagination">
				<c:if test="${page == startpage}">
					<li class="disabled"><span>&laquo;</span></li>
				</c:if>
				<c:if test="${page > startpage}">
					<li><a
						href="${pageContext.request.contextPath}/user/list/?page=${page-1}">&laquo;</a></li>
				</c:if>

				<form:form method="get"
					commandName="${pageContext.request.contextPath}/user/list/?page=${page}">
					<li><input type="text" name="page"
						class="form-control input-sm" size="2" value="${page}"
						maxlength="3" /></li>
				</form:form>

				<c:forEach begin="${startpage}" end="${endpage}" var="p">
			<li><a
				href="${pageContext.request.contextPath}/user/list/?page=${p}">${p}</a></li>
		
		</c:forEach>

				<li><a
					href="${pageContext.request.contextPath}/user/list/?page=${endpage}">${endpage}</a></li>
				<c:if test="${page < endpage}">
					<li><a
						href="${pageContext.request.contextPath}/user/list/?page=${page+1}">&raquo;</a></li>
				</c:if>
				<c:if test="${page == endpage}">
					<li class="disabled"><span>&raquo;</span></li>
				</c:if>
			</ul>
		</div> --%>

	</div>

	<footer>
		<jsp:include page="../templates/footer.jsp" />
	</footer>
</body>
</html>
