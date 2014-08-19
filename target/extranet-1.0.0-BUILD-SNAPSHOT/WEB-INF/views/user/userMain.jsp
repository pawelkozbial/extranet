<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<table class=inputData>
	<tr>
		<td><form:label path="firstName" class="col-sm-2 control-label">
				<spring:message code="user.firstname" />
			</form:label></td>
		<td><form:errors path="firstName" cssClass="error" /></td>
	</tr>
	<tr>
		<td></td>
		<td><form:input path="firstName" class="form-control input-sm"
				placeholder="Imię" /></td>
	</tr>
	<tr>
		<td><form:label path="lastName" class="col-sm-2 control-label">
				<spring:message code="user.lastname" />
			</form:label></td>
		<td><form:errors path="lastName" cssClass="error" /></td>
	</tr>
	<tr>
		<td></td>
		<td><form:input path="lastName" class="form-control input-sm"
				placeholder="Nazwisko" /></td>
	</tr>

	<tr>
		<td><form:label path="email" class="col-sm-2 control-label">
				<spring:message code="user.email" />
			</form:label></td>
		<td><form:errors path="email" cssClass="error" /></td>
	</tr>
	<tr>
		<td></td>
		<td><form:input path="email" class="form-control input-sm"
				placeholder="Email" /></td>
	</tr>
	<tr>
		<td><form:label path="dateOfBirth" class="col-sm-2 control-label">
				<spring:message code="user.dateOfBirth" />
			</form:label></td>
		<td><form:errors path="dateOfBirth" cssClass="error" /></td>
	</tr>
	<tr>
		<td></td>
		<td><form:input path="dateOfBirth" class="form-control input-sm"
				id="datepicker" placeholder="DD-MM-YYYY" readonly="true" /><span
			class="add-on"><i class="icon-calendar"></i></span></td>
	</tr>
	<tr>
		<td><form:label path="password" class="col-sm-2 control-label">
				<spring:message code="user.password" />
			</form:label></td>
		<td><form:errors path="password" cssClass="error" /></td>
	</tr>
	<tr>
		<td></td>
		<td><form:input path="password" type="password"
				class="form-control input-sm" placeholder="Hasło" maxlength="16" />
	</tr>

	<tr>
		<td><form:label path="" class="col-sm-2 control-label">
				<spring:message code="user.repeatPassword" />
			</form:label></td>
		<td><c:choose>
				<c:when test="${equalFields eq false}">
					<p class="error">${passwordRepeatError}</p>
				</c:when>
				<%-- <c:otherwise>
									<p>TRUE</p>
									</c:otherwise> --%>
			</c:choose></td>
	<tr>
		<td></td>
		<td><input type="password" class="form-control input-sm"
			name="repeatPassword" placeholder="Powtórz Hasło" maxlength="16"></td>
	</tr>

	<tr>
		<td><form:label path="enabled" class="col-sm-2 control-label">
				<spring:message code="user.enabled" />
			</form:label></td>
	</tr>
	<tr>
		<td></td>
		<td><select name="enableOptions" class="form-control input-sm">
				<option value="true">Tak</option>
				<option value="false">Nie</option>
		</select></td>
	</tr>
	<tr>
		<td><form:label path="role" class="col-sm-2 control-label">
				<spring:message code="user.role" />
			</form:label></td>
	</tr>
	<tr>
		<td></td>
		<td><select name="options" class="form-control input-sm">
				<c:forEach items="${roleList}" var="role">
					<option value="${role.id}">${role.authority}-
						${role.description}</option>
				</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td colspan="2" align="right"><input type="submit"
			class="btn btn-default input-sm"
			value="<spring:message code="user.btn.add"/>" /></td>
	</tr>

</table>