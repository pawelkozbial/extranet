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

		<form:form method="post"
			action="${pageContext.request.contextPath}/game/createClubTwo">

			<table>
				<thead>
					<tr>
						<td><spring:message code="game.team2" /></td>
						<td><select name="team2" class="form-control input-sm">
								<c:forEach items="${clubList}" var="club">
									<option value="${club.id}">${club.name}</option>
								</c:forEach>
						</select></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</tbody>
			</table>

			<table id="mytable" class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Nazwisko</th>
						<th>Imię</th>
						<th>Data urodzenia</th>
						<th class="nosort">&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userList}" var="user">
						<tr>
							<td>${user.lastName}</td>
							<td>${user.firstName}</td>
							<td>${user.dateOfBirth}</td>
							<td><sec:authorize access="hasRole('ROLE_ADMIN')">
									<input type="checkbox" name="players" value="${user.id}" />${user.id}<br />
								</sec:authorize></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div>
				<input type="submit" class="btn btn-default input-sm"
					value="<spring:message code="user.btn.save"/>" />
			</div>
		</form:form>
	</div>

	<footer>
		<jsp:include page="../templates/footer.jsp" />
	</footer>
</body>
</html>