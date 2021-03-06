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
<title><spring:message code="club.new.title" /></title>

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
			<h3>Dodanie nowego klubu</h3>

			<form:form method="post"
				action="${pageContext.request.contextPath}/club/add"
				commandName="club">

				<table class="inputData">
					<tr>
						<td><form:label path="name" class="col-sm-2 control-label">
								<spring:message code="club.name" />
							</form:label></td>
						<td><form:errors path="name" cssClass="error" /></td>
					</tr>
					<tr>
						<td></td>
						<td><form:input path="name" class="form-control input-sm" /></td>
					</tr>
					<tr>
						<td><form:label path="description"
								class="col-sm-2 control-label">
								<spring:message code="club.description" />
							</form:label></td>
						<td><form:errors path="description" cssClass="error" /></td>
					</tr>
					<tr>
						<td></td>
						<td><form:input path="description"
								class="form-control input-sm" /></td>
					</tr>
					<tr>
						<td><form:label path="district"
								class="col-sm-2 control-label">
								<spring:message code="club.district" />
							</form:label></td>
					</tr>
					<tr>
						<td></td>
						<td><select name="districtId" class="form-control input-sm">
								<c:forEach items="${districtList}" var="district">
									<option value="${district.id}">${district.league.name}
										- ${district.name}</option>
								</c:forEach>
						</select></td>
					</tr>
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