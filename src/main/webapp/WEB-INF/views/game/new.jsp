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
<title><spring:message code="game.new.title" /></title>

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
			<%-- <c:if test="${param.logout != null}">
				<div class="error">You have been logged out.</div>
			</c:if> --%>
			<h3>Dodanie nowej rozgrywki</h3>

			<form:form method="post"
				action="${pageContext.request.contextPath}/game/add"
				commandName="game">

				<table class="inputData">
					<tr>
						<td><spring:message code="game.team1" /></td>
						<td><h5>${club1.name}</h5></td>
					</tr>
					<tr>
						<td></td>
						<td><a
							href="${pageContext.request.contextPath}/game/addPlayers/1"><spring:message
									code="game.createTeam" /></a></td>
					</tr>
					<tr>
						<td><spring:message code="game.team2" /></td>
						<td><h5>${club2.name}</h5></td>
					</tr>
					<tr>
						<td></td>
						<td><a
							href="${pageContext.request.contextPath}/game/addPlayers/2"><spring:message
									code="game.createTeam" /></a></td>
					</tr>
					<tr>
						<td><spring:message code="game.referees" /></td>
						<c:forEach items="${referees}" var="referee">
							<td>${referee.lastName}&nbsp;${referee.firstName }</td>
						</c:forEach>
					</tr>
					<tr>
						<td></td>
						<td><a
							href="${pageContext.request.contextPath}/game/addReferees"><spring:message
									code="game.createReferees" /></a></td>
					</tr>
					<tr>
						<td><spring:message code="game.queue" /></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td><select name="queueId" class="form-control input-sm">
								<c:forEach items="${queueList}" var="queue">
									<option value="${queue.id}">${queue.number}&nbsp;-
										${queue.round.name}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td><spring:message code="game.dateOfGame" /></td>
						<td><c:choose>
								<c:when test="${isNull eq true}">
									<p class="error">${dateIsNull}</p>
								</c:when>
							</c:choose></td>
					</tr>
					<tr>
						<td></td>
						<td><input name="dateOfGame" id="dateOfGame"
							placeholder="YYYY-MM-DD" class="form-control" readonly /></td>
					</tr>
					<%-- <tr>
						<td></td>
						<td><select name="districtId" class="form-control input-sm">
								<c:forEach items="${districtList}" var="district">
									<option value="${district.id}">${district.league.name}
										- ${district.name}</option>
								</c:forEach>
						</select></td>
					</tr> --%>
					<tr>
						<td></td>
						<td colspan="2" align="right"><input type="submit"
							class="btn btn-default input-sm"
							value="<spring:message code="user.btn.add"/>" /></td>
					</tr>
				</table>
			</form:form>
		</sec:authorize>
	</div>

	<footer>
		<jsp:include page="../templates/footer.jsp" />
	</footer>
</body>
</html>