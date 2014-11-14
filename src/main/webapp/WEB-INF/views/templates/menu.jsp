<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-2"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%-- <div id="menu" class="main">
	<nav>
		<ul>
			<li><a href="/extranet/">home page</a></li>
			<li><a href="/extranet/welcome">welcome</a></li>
			<li><a href="/extranet/user">user</a></li>
			<li><a href="${pageContext.request.contextPath}">request</a></li>
			<li><a href="${request.getAttribute("javax.servlet.forward.request_uri")}">TEST
				1</a></li>
			<li><span id="napis">test migania napisu</span></li>
		</ul>
	</nav>
</div> --%>

<div class="navbar navbar-default" role="navigation">

	<div class="container-fluid main">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/extranet/">Strona g³ówna</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<!-- <li class="active"><a href="#">Link</a></li> -->
				<!-- <li><a href="/extranet/welcome">welcome</a></li> -->

				<!-- Users -->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">U¿ytkownik<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<li><a href="/extranet/user/new">Nowy u¿ytkownik</a></li>
						</sec:authorize>
						<li><a href="${pageContext.request.contextPath}/user/">Lista
								u¿ytkowników</a></li>
						<!-- <li><a href="#">Something else here</a></li>
						<li class="divider"></li>
						<li><a href="#">Separated link</a></li>
						<li class="divider"></li>
						<li><a href="#">One more separated link</a></li> -->
					</ul></li>

				<!-- Districts -->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Okrêg<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<li><a href="/extranet/district/new">Nowy okrêg</a></li>
						</sec:authorize>
						<li><a href="${pageContext.request.contextPath}/district/">Lista
								okrêgów</a></li>
					</ul></li>

				<!-- Leagues -->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Liga<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<li><a href="/extranet/league/new">Nowa liga</a></li>
						</sec:authorize>
						<li><a href="${pageContext.request.contextPath}/league/">Lista
								lig</a></li>
					</ul></li>

				<!-- Clubs -->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Klub<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<li><a href="/extranet/club/new">Nowy klub</a></li>
						</sec:authorize>
						<li><a href="${pageContext.request.contextPath}/club/">Lista
								klubów</a></li>
					</ul></li>

			</ul>
			<form class="navbar-form navbar-left" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="szukaj na stronie">
				</div>
				<button type="submit" class="btn btn-default">Szukaj</button>
			</form>

			<ul class="nav navbar-nav navbar-right">
				<!-- Statistics -->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Tabele<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="${pageContext.request.contextPath}/statistics">Ekstraklasa</a></li>
						<li><a
							href="${pageContext.request.contextPath}/game/league/2">Liga
								I</a></li>
						<li><a
							href="${pageContext.request.contextPath}/game/league/3">Liga
								II</a></li>
						<%-- <sec:authorize access="hasRole('ROLE_ADMIN')">
							<li class="divider"></li>
							<li><a href="/extranet/game/new">Nowa rozgrywka</a></li>
						</sec:authorize> --%>
					</ul></li>
				<!-- Games -->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Rozgrywki<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a
							href="${pageContext.request.contextPath}/game/league/1">Ekstraklasa</a></li>
						<li><a
							href="${pageContext.request.contextPath}/game/league/2">Liga
								I</a></li>
						<li><a
							href="${pageContext.request.contextPath}/game/league/3">Liga
								II</a></li>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<li class="divider"></li>
							<li><a href="/extranet/game/new">Nowa rozgrywka</a></li>
						</sec:authorize>
					</ul></li>


				<sec:authorize access="authenticated" var="authenticated" />
				<c:choose>
					<c:when test="${authenticated}">

						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><sec:authentication property="name" />
								<span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="${pageContext.request.contextPath}/user/edit/">Edytuj
										profil</a></li>
								<!-- <li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li> -->
								<li class="divider"></li>
								<c:url var="logoutUrl" value="/logout" />
								<li><a id="navLogoutLink" href="${logoutUrl}"> <spring:message
											code="menu.logoutUrl" />
								</a></li>
							</ul></li>
					</c:when>
					<c:otherwise>
						<c:url var="loginUrl" value="/login" />
						<li><a id="navLoginLink" href="${loginUrl}"><spring:message
									code="menu.loginUrl" /></a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</div>