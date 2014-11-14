<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
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

		<h4>"PS": Jodłowiec w pierwszym składzie</h4>
		<br />

		<p>
			<img
				src="${pageContext.request.contextPath}/resources/images/polska_gruzja.png"
				alt="Polska-Gruzja" />
		</p>
		<br />

		<h5>Według "Przeglądu Sportowego" selekcjoner reprezentacji
			Polski Adam Nawałka w meczu z Gruzją postawi w środku pola na Tomasza
			Jodłowca i Grzegorza Krychowiaka. W ten sposób trener zastosowałby to
			samo rozwiązanie, co w październikowym spotkaniu z Niemcami (2:0).</h5>

		<p>W piątek reprezentacja Polski zagra na wyjeździe z Gruzją w 4.
			kolejce eliminacji do mistrzostw Europy w 2016 roku. Jeśli
			"biało-czerwoni" zdobędą trzy punkty, to zrobią duży krok w kierunku
			awansu do turnieju we Francji.</p>

		<p>"Przegląd Sportowy" opublikował nazwiska piłkarzy, na których
			ich zdaniem Adam Nawałka postawi od pierwszej minuty. "11" bardzo
			pokrywa się z tą, którą w czwartek zaprezentował dziennikarz Polsatu
			Sport Roman Kołtoń.</p>

		<p>I tak między słupkami zobaczymy Wojciecha Szczęsnego. Linię
			obrony stworzą Łukasz Piszczek, Kamil Glik, Łukasz Szukała i Artur
			Jędrzejczyk. Na bokach pomocy zagrają Kamil Grosicki i Maciej Rybus.
		</p>

		<p>Jednak według "PS" w środku drugiej linii selekcjoner postawi
			na Tomasza Jodłowca, a nie na Krzysztofa Mączyńskiego, jak sugerował
			Kołtoń. Drugim środkowym pomocnikiem będzie Grzegorz Krychowiak. Za
			zdobywanie bramek odpowiedzialni będą Arkadiusz Milik i Robert
			Lewandowski.</p>
		<br />

		<h5>Podstawowy skład reprezentacji Polski na mecz z Gruzją według
			"PS":</h5>


		<p>Wojciech Szczęsny - Łukasz Piszczek, Łukasz Szukała, Kamil
			Glik, Artur Jędrzejczyk - Kamil Grosicki, Grzegorz Krychowiak, Tomasz
			Jodłowiec, Maciej Rybus - Arkadiusz Milik, Robert Lewandowski</p>

		<p>The time on the server is ${serverTime}.</p>
	</div>

	<footer>
		<jsp:include page="templates/footer.jsp" />
	</footer>
</body>
</html>
