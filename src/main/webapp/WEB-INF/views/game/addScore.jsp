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
<title>Zapisz wynik</title>

<jsp:include page="../templates/resources.jsp" />

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

div#content input[type="text"] {
	width: 50px;
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

		<h3>Wynik</h3>

		<div>&nbsp;</div>

		<form:form method="post"
			action="${pageContext.request.contextPath}/game/addScore/save">
			<span>${game.club[0].name}</span>
			<input type="text" name="scoreClub1" class="form-control input-sm"
				maxlength="2">
			<span>${game.club[1].name}</span>
			<input type="text" name="scoreClub2" class="form-control input-sm"
				maxlength="2">
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