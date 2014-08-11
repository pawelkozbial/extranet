<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login Page</title>
<style>
table,td,th {
	margin: 0 auto;
	/* border: 1px solid green; */
}

table td {
	padding: 10px;
}

.errorblock {
	width: 60%;
	margin: 0 auto;
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	/* margin: 16px; */
	color: #ff0000;
}
</style>
<jsp:include page="templates/resources.jsp" />
</head>
<body onload='document.f.j_username.focus();'>
	<div id="content" class="main">
		<h3>Login with Username and Password (Custom Page)</h3>

		<c:if test="${not empty error}">
			<div class="errorblock">
				<spring:message code="login.errorInfo" />
				<br />
				<spring:message code="login.caused" />
				${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
			</div>
		</c:if>

		<form name='f' action="j_spring_security_check" method='POST'>

			<table>
				<tr>
					<td><spring:message code="login.username" /></td>
					<td><input type="text" name="j_username" value=""
						class="form-control input-sm"></td>
				</tr>
				<tr>
					<td><spring:message code="login.password" /></td>
					<td><input type="password" name="j_password"
						class="form-control input-sm" /></td>
				</tr>
				<tr>
					<td colspan='2' align="right"><input name="submit"
						type="submit" class="btn btn-default input-sm"
						value="<spring:message code="login.btn.login" />" /></td>
				</tr>
				<!-- <tr>
					<td colspan='2'><input name="reset" type="reset"
						class="btn btn-default input-sm" /></td>
				</tr> -->
				<tr>
					<td colspan='2' align="right"><a
						href="${pageContext.request.contextPath}/">Powrót na główną
							stronę</a></td>
				</tr>
			</table>
			<%-- <p>
				<a href="${pageContext.request.contextPath}/">Powrót na główną
					stronę</a>
			</p> --%>

		</form>
	</div>
</body>
</html>