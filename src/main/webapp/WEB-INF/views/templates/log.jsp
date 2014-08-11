<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="footer" class="main">

	<h3>Login with Username and Password (Custom Page)</h3>

	<c:if test="${not empty error}">
		<div class="errorblock">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>

	<form name='f' action="${loginUrl}" method='POST'>
		<c:if test="${param.logout != null}">
			<div class="errorblock">You have been logged out.</div>
		</c:if>

		<table>
			<tr>
				<td>User:<input type='text' name='j_username' value=''></td>
			</tr>
			<tr>
				<td>Password:<input type='password' name='j_password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="submit" /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="reset" type="reset" /></td>
			</tr>
		</table>

	</form>
</div>