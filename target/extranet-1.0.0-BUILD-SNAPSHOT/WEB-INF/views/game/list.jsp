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
		<sec:authorize access="isAuthenticated()">
			<c:if test="${param.logout != null}">
				<div class="error">You have been logged out.</div>
			</c:if>
		</sec:authorize>

		<h3>Kluby</h3>
		<c:if test="${!empty gameList}">
			<table id="mytable" class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>DATA</th>
						<th>Kluby</th>
						<th>Kolejka</th>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<th class="nosort">&nbsp;</th>
						</sec:authorize>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${gameList}" var="game">
						<tr>
							<td>${game.dateOfGame}</td>
							<td>${game.club[0]} - ${game.club[1]}</td>
							<td>${game.queue.id}</td>
							<%-- <td>${club.district.name}</td> --%>
							<sec:authorize access="hasRole('ROLE_ADMIN')">
								<td><a
									href="${pageContext.request.contextPath}/game/edit/${game.id}"><spring:message
											code="general.edit" /></a> <a
									href="${pageContext.request.contextPath}/game/delete/${game.id}"><spring:message
											code="general.delete" /></a> <%-- <a
									href="${pageContext.request.contextPath}/club/addDistrictToLeague/${league.id}"><spring:message
											code="league.addDistrict" /></a></td> --%>
							</sec:authorize>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

	</div>

	<footer>
		<jsp:include page="../templates/footer.jsp" />
	</footer>
</body>
</html>
