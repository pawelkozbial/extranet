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

		<p></p>

		<h3>${league}-okręgi</h3>
		<c:if test="${!empty districtList}">
			<form:form method="post"
				action="${pageContext.request.contextPath}/league/updateDistricts">
				<table id="mytable" class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Nazwa</th>
							<th>Opis</th>
							<th>Wybór</th>
							<%-- <sec:authorize access="hasRole('ROLE_ADMIN')">
							<th class="disabled">&nbsp;</th>
						</sec:authorize> --%>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${districtList}" var="district">
							<tr>
								<td>${district.name}</td>
								<td>${district.description}</td>
								<td><input type="checkbox" name="districts"
									value="${district.id}"
									<c:forEach items="${addedDistrictsList}" var="addedDistricts">
										<c:if test="${district.id == addedDistricts}">checked = "checked"</c:if>
									</c:forEach> />
									<%-- ${district.id}<br /> --%></tr>
						</c:forEach>
					</tbody>
				</table>
				<div>
					<input type="submit" class="btn btn-default input-sm"
						value="<spring:message code="user.btn.save"/>" />
				</div>
			</form:form>
		</c:if>
	</div>
	<footer>
		<jsp:include page="../templates/footer.jsp" />
	</footer>
</body>
</html>