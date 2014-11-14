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

<!-- <script type="text/javascript" charset="utf-8">
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
</script> -->
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

		<c:choose>
			<c:when test="${isStatistics eq true}">
				<h3>Wynik: ${scoreClub1} - ${scoreClub2}</h3>
			</c:when>
			<c:otherwise>
				<h3>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<a
							href="${pageContext.request.contextPath}/game/addScore/${game.id}">Zapisz
							wynik</a>
					</sec:authorize>
				</h3>
			</c:otherwise>
		</c:choose>

		<div>&nbsp;</div>

		<div id="tabLeft">
			<h4>Skład ${game.club[0].name}</h4>
			<p>
				<c:set var="count" value="0" scope="page" />
				<c:forEach items="${playersOneList}" var="pOne">
					<c:set var="count" value="${count + 1}" scope="page" />
					<ul class="list">
						<li>${count}.&nbsp;${pOne.lastName}&nbsp;${pOne.firstName}</li>
					</ul>
				</c:forEach>
			</p>
		</div>
		<div id="tabRigth">
			<h4>Skład ${game.club[1].name}</h4>
			<p>
				<c:set var="count" value="0" scope="page" />
				<c:forEach items="${playersTwoList}" var="pTwo">
					<c:set var="count" value="${count + 1}" scope="page" />
					<ul class="list">
						<li>${count}.&nbsp;${pTwo.lastName}&nbsp;${pTwo.firstName}</li>
					</ul>
				</c:forEach>
			</p>
		</div>

		<div class="clb" id="referee">
			<h4>Skład sędziowski:</h4>
			<p>
				<c:set var="count" value="0" scope="page" />
				<c:forEach items="${refereeList}" var="referee">
					<c:set var="count" value="${count + 1}" scope="page" />
					<ul class="list">
						<li>${count}.&nbsp;${referee.lastName}&nbsp;${referee.firstName}</li>
					</ul>
				</c:forEach>
			</p>
		</div>
	</div>
	<footer>
		<jsp:include page="../templates/footer.jsp" />
	</footer>
</body>
</html>