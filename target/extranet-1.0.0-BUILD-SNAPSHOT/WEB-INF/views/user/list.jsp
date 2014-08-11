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
			<%-- <h2>User Manager</h2>

			<form:form method="post"
				action="${pageContext.request.contextPath}/user/add"
				commandName="user">
				<jsp:include page="userMain.jsp" />
				<input type="submit" class="btn btn-default input-sm"
					value="<spring:message code="user.btn.add"/>" />
			</form:form> --%>
		</sec:authorize>

		<h3>Użytkownicy</h3>
		<c:if test="${!empty userList}">
			<table id="mytable" class="table table-striped table-bordered">
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
							<th class="disabled">&nbsp;</th>
						</sec:authorize>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userList}" var="user">
						<tr>
							<td>${user.firstName}</td>
							<td>${user.lastName}</td>
							<td>${user.email}</td>
							<%-- <td>${user.password}</td> --%>
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

		<%-- <table class="pagination">
			<tr>
				<td><c:if test="${page == startpage}">
						<p class="disabled">
							<span>&laquo;</span>
						</p>
					</c:if> <c:if test="${page > startpage}">
						<p>
							<a
								href="${pageContext.request.contextPath}/user/list/?page=${page-1}">&laquo;</a>
						</p>
					</c:if></td>
				<td><form:form method="get"
						commandName="${pageContext.request.contextPath}/user/list/?page=${page}">
						<input type="text" name="page" class="form-control input-sm"
							size="2" value="${page}" maxlength="3" />
					</form:form></td>
				<td><p>
						<a
							href="${pageContext.request.contextPath}/user/list/?page=${endpage}">${endpage}</a>
					</p></td>
				<td><c:if test="${page < endpage}">
						<p>
							<a
								href="${pageContext.request.contextPath}/user/list/?page=${page+1}">&raquo;</a>
						</p>
					</c:if> <c:if test="${page == endpage}">
						<p class="disabled">
							<span>&raquo;</span>
						</p>
					</c:if></td>
			</tr>
		</table> --%>

	</div>

	<footer>
		<jsp:include page="../templates/footer.jsp" />
	</footer>
</body>
</html>
