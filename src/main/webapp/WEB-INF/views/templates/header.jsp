<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<style type="text/css">
h2 {
	margin: 0;
	color: #666;
	padding-top: 90px;
	font-size: 52px;
	font-family: "trebuchet ms", sans-serif;
}

.item {
	background: #333;
	text-align: center;
	height: 300px !important;
}

.carousel {
	margin-top: 20px;
}

.bs-example {
	margin: 20px;
}
</style>

<div id="header" class="main">
	<%-- <a href="/extranet/"><img
		src="${pageContext.request.contextPath}/resources/images/artykul.png"
		alt="Image1" /></a> --%>

	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Carousel indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<!-- Carousel items -->
		<div class="carousel-inner">
			<div class="item active">
				<h2>Slide 1</h2>
				<div class="carousel-caption">
					<h3>First slide label</h3>
					<p>Lorem ipsum dolor sit amet consectetur…</p>
				</div>
			</div>
			<div class="item">
				<h2>Slide 2</h2>
				<div class="carousel-caption">
					<h3>Second slide label</h3>
					<p>Aliquam sit amet gravida nibh, facilisis gravida…</p>
				</div>
			</div>
			<div class="item">
				<h2>Slide 3</h2>
				<div class="carousel-caption">
					<h3>Third slide label</h3>
					<p>Praesent commodo cursus magna vel…</p>
				</div>
			</div>
		</div>
		<!-- Carousel nav -->
		<a class="carousel-control left" href="#myCarousel" data-slide="prev">
			<!-- <span class="glyphicon glyphicon-chevron-left"></span> -->
		</a> <a class="carousel-control right" href="#myCarousel"
			data-slide="next"> <!-- <span
			class="glyphicon glyphicon-chevron-right"></span> -->
		</a>
	</div>

	<%-- <c:url var="logoutUrl" value="/logout" />
	<div id="nav-account" class="nav-collapse pull-right">
		<div>
			<ul class="nav">
				<sec:authorize access="authenticated" var="authenticated" />
				<c:choose>
					<c:when test="${authenticated}">
						<li id="greeting">
							<div>
								Welcome
								<sec:authentication property="name" />
							</div>
						</li>
						<li><a id="navLogoutLink" href="${logoutUrl}">Wyloguj</a></li>
					</c:when>
					<c:otherwise>
						<c:url var="loginUrl" value="/login" />
						<li><a id="navLoginLink" href="${loginUrl}">Zaloguj</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div> --%>
</div>