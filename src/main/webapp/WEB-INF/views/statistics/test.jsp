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
<meta http-equiv="content-type" content="text/html; charset=utf-8" />

<title>Lista meczów</title>

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

		<table class="table tablesorter">
			<thead>
				<tr>
					<th></th>
					<th><h4>
							<spring:message code="statistics.club" />
						</h4></th>
					<th><h4>
							<spring:message code="statistics.games" />
						</h4></th>
					<th><h4>
							<spring:message code="statistics.wins" />
						</h4></th>
					<th><h4>
							<spring:message code="statistics.draws" />
						</h4></th>
					<th><h4>
							<spring:message code="statistics.loses" />
						</h4></th>
					<th><h4>
							<spring:message code="statistics.goals" />
						</h4></th>
					<th><h4>
							<spring:message code="statistics.points" />
						</h4></th>
				</tr>
			</thead>
			<tbody>
				<c:set var="count" value="0" scope="page" />
				<c:forEach items="${statisticList}" var="statistics">
					<c:set var="count" value="${count + 1}" scope="page" />
					<tr>
						<td><h5>${count}</h5></td>
						<td><h5>${statistics.club}</h5></td>
						<td>${statistics.games}</td>
						<td>${statistics.wins}</td>
						<td>${statistics.draws}</td>
						<td>${statistics.loses}</td>
						<td>${statistics.goalsScored}:${statistics.goalsAgainst}</td>
						<td><h5>${statistics.points}</h5></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

	<footer>
		<jsp:include page="../templates/footer.jsp" />
	</footer>

</body>
</html>