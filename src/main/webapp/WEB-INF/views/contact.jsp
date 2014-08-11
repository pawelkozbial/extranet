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
<title>Spring 3 MVC Series - Contact Manager</title>

<jsp:include page="../views/templates/resources.jsp" />

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>


<!-- <script type="text/javascript"
	src="http://jquery.bassistance.de/validate/jquery.validate.js"></script>  -->

</head>
<body>

	<header>
		<jsp:include page="templates/header.jsp" />
	</header>
	<%-- <section>
		<jsp:include page="templates/log.jsp"></jsp:include>
	</section> --%>
	<nav>
		<jsp:include page="templates/menu.jsp" />
	</nav>
	<div id="content" class="main">

		<c:if test="${param.logout != null}">
			<div class="errorblock">You have been logged out.</div>
		</c:if>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<h2>Contact Manager</h2>

			<form:form method="post" action="add" commandName="contact">
				<table>
					<tr>
						<td><form:label path="firstname">
								<spring:message code="label.firstname" />
							</form:label></td>
						<td><form:errors path="firstname" cssClass="error" /></td>
					</tr>
					<tr>
						<td></td>
						<td><form:input path="firstname" /></td>
					</tr>
					<tr>
						<td><form:label path="lastname">
								<spring:message code="label.lastname" />
							</form:label></td>
						<td><form:errors path="lastname" cssClass="error" /></td>
					</tr>
					<tr>
						<td></td>
						<td><form:input path="lastname" /></td>
					</tr>
					<tr>
						<td><form:label path="email">
								<spring:message code="label.email" />
							</form:label></td>
						<td><form:errors path="email" cssClass="error" /></td>
					<tr>
						<td></td>
						<td><form:input path="email" /></td>
					</tr>
					<tr>
						<td><form:label path="">
								<spring:message code="label.repeatEmail" />
							</form:label></td>
						<td><c:choose>
								<c:when test="${rowne eq false}">
									<p class="error">${emailRepeatError}</p>
								</c:when>
								<%-- <c:otherwise>
									<p>TRUE</p>
									</c:otherwise> --%>
							</c:choose></td>
					<tr>
						<td></td>
						<td><input type="text" name="email1"></td>
					</tr>

					<tr>
						<td><form:label path="telephone">
								<spring:message code="label.telephone" />
							</form:label></td>
						<td><form:input path="telephone" /></td>
					</tr>
					<tr>
						<td>Opcje</td>
						<td><c:forEach items="${roleList}" var="role">
								<input type="radio" name="roleList" value="${role.id}" />${role.authority} - ${role.description}
							</c:forEach></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit"
							value="<spring:message code="label.addcontact"/>" /></td>
					</tr>
				</table>
			</form:form>
		</sec:authorize>

		<h3>Contacts</h3>
		<c:if test="${!empty contactList}">
			<table class="data">
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Telephone</th>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<th>&nbsp;</th>
					</sec:authorize>
				</tr>
				<c:forEach items="${contactList}" var="contact">
					<tr>
						<td>${contact.lastname},${contact.firstname}</td>
						<td>${contact.email}</td>
						<td>${contact.telephone}</td>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<td><a href="delete/${contact.id}">delete</a></td>
						</sec:authorize>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>

	<footer>
		<jsp:include page="templates/footer.jsp" />
	</footer>
</body>


</html>
