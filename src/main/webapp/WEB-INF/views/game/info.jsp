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
<title>Informacje o meczu</title>

<jsp:include page="../templates/resources.jsp" />

<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		$("#example").tablesorter({
			sortList : [ [ 0, 0 ], [ 1, 0 ] ],
			headers : {
				1 : {
					sorter : true
				}
			}
		});
	});
</script>
<style>
div#tabLeft {
	float: left;
	width: 50%;
}

div#tabRight {
	flaot: right;
	width: 50%;
}

.clb {
	clear: both;
}

div#referee {
	padding-top: 10px;
}

ul.list li {
	text-indent: 25px;
}
</style>
</head>
<body>
	<header>
		<jsp:include page="../templates/header.jsp" />
	</header>
	<nav>
		<jsp:include page="../templates/menu.jsp" />
	</nav>
	<div id="content" class="main">


		<h3>Mecz pomiędzy ${game.club[0].name} a ${game.club[1].name} -
			${game.dateOfGame}</h3>

		<div>&nbsp;</div>

		<div id="tabLeft">
			<h4>Skład ${game.club[0].name}</h4>
			<p>
				<c:forEach items="${playersOneList}" var="pOne">
					<ul class="list">
						<li>${pOne.lastName}&nbsp;${pOne.firstName}</li>
					</ul>
				</c:forEach>
			</p>
		</div>
		<div id="tabRigth">
			<h4>Skład ${game.club[1].name}</h4>
			<p>
				<c:forEach items="${playersTwoList}" var="pTwo">
					<ul class="list">
						<li>${pTwo.lastName}&nbsp;${pTwo.firstName}</li>
					</ul>
				</c:forEach>
			</p>
		</div>

		<div class="clb" id="referee">
			<h4>Skład sędziowski:</h4>
			<p>
				<c:forEach items="${refereeList}" var="referee">
					<ul class="list">
						<li>${referee.lastName}&nbsp;${referee.firstName}</li>
					</ul>
				</c:forEach>
			</p>
		</div>
		<%-- <c:if test="${!empty districtList}">
			<form:form method="post"
				action="${pageContext.request.contextPath}/league/updateDistricts">
				<table id="mytable" class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Nazwa</th>
							<th>Opis</th>
							<th>Wybór</th>
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
								<td><input type="checkbox" name="districts"
									value="${district.id}"
									<c:forEach items="${addedDistrictsList}" var="addedDistricts">
										<c:if test="${district.id == addedDistricts}">checked = "checked"</c:if>
									</c:forEach> />${district.id}<br />
									<!-- <c:if test="${'Dogs' == 'Dogs'}">checked = "checked"</c:if> -->
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div>
					<input type="submit" class="btn btn-default input-sm"
						value="<spring:message code="user.btn.save"/>" />
				</div>
			</form:form>
		</c:if> --%>
	</div>
	<footer>
		<jsp:include page="../templates/footer.jsp" />
	</footer>
</body>
</html>