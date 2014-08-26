<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>

<jsp:include page="templates/resources.jsp" />

</head>
<body>

	<header>
		<jsp:include page="templates/header.jsp" />
	</header>
	<nav>
		<jsp:include page="templates/menu.jsp" />
	</nav>
	<div id="content" class="main">

		<h1>Hello world!</h1>

		<P>The time on the server is ${serverTime}.</P>
	</div>

	<footer>
		<jsp:include page="templates/footer.jsp" />
	</footer>
</body>
</html>
