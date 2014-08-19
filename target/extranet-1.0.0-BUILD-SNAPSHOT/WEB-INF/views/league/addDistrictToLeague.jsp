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
<title>Dodanie okręgu do ligi</title>

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
	<div style="width:20%">
		<select name="leagues" class="form-control input-sm">
			<c:forEach items="${leagueList}" var="league">
				<option value="${league.id}">${league.name}</option>
			</c:forEach>
		</select>
		</div>

		<h3>Okręgi</h3>
		<c:if test="${!empty districtList}">
			<table id="mytable" class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Nazwa</th>
						<th>Opis</th>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<th class="disabled">&nbsp;</th>
						</sec:authorize>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${districtList}" var="district">
						<tr>
							<td>${district.name}</td>
							<td>${district.description}</td>
							<sec:authorize access="hasRole('ROLE_ADMIN')">
								<td><a
									href="${pageContext.request.contextPath}/district/edit/${district.id}">edit</a>
									<a
									href="${pageContext.request.contextPath}/district/delete/${district.id}">delete</a></td>
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