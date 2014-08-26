<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<link
	href="${pageContext.request.contextPath}/resources/styles/reset.css"
	rel="stylesheet" />
<%-- <link href="<c:url value="/resources/styles/reset.css" />"
	rel="stylesheet" type="text/css" /> --%>
<link
	href="${pageContext.request.contextPath}/resources/styles/master.css"
	rel="stylesheet" />

<!-- <link rel="stylesheet"
	href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css"> -->


<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> -->
<!-- <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script> -->
<%-- <script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery.ui.datepicker-pl.js"></script> --%>

<!-- BOOTSTRAP -->
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/styles/bootstrap.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/styles/bootstrap-theme.min.css">
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap-datepicker.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap-combobox.js"></script>
<%-- <link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/styles/bootstrap.css"> --%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/styles/datepicker.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/styles/bootstrap-combobox.css" />

<script
	src="${pageContext.request.contextPath}/resources/js/jquery.tablesorter.js"></script>

<script src="${pageContext.request.contextPath}/resources/js/animuj.js"></script>

<!-- DATATABLE -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/styles/dataTables.bootstrap.css">
<script type="text/javascript"
	src="http://cdn.datatables.net/1.10-dev/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/dataTables.bootstrap.js"></script>

<script>
	$(function() {
		$("#datepicker").datepicker({
			language : "pl",
			format : "dd-mm-yyyy",
			startDate : "-60y",
			endDate : "-6y",
			autoclose : true
		});
		$("#mytable").dataTable({
			aoColumnDefs : [ {
				bSortable : false,
				aTargets : [ 'nosort' ]
			} ],
			oLanguage : {
				oPaginate : {
					sNext : " >> ",
					sPrevious : " << "
				},
				sSearch : "Wyszukaj:",
				sInfo : "Wyświetlono od _START_ do _END_ z _TOTAL_ wyników",
				sInfoFiltered : " w _MAX_ rekordach",
				sInfoEmpty : "Brak wyników wyszukiwania",
				sLengthMenu : "_MENU_ rekordów na stronie",
				sLoadingRecords : "Ładowanie wyników ...",
				sZeroRecords : "Brak danych w tabeli"
			/* sUrl : "extranet/resources/txt/dataTableProperties.txt" */
			}
		});
		$(".combobox").combobox();
		$("myCarousel").carousel({
			interval : 100
		});
		/* $('#sandbox-container .input-group.date').datepicker({
			format : "yyyy-mm-dd",
			startView : 1,
			language : "pl"
		}); */
	});

	$.fn.datepicker.dates['pl'] = {
		days : [ "Niedziela", "Poniedziałek", "Wtorek", "Środa", "Czwartek",
				"Piątek", "Sobota", "Niedziela" ],
		daysShort : [ "Nie", "Pon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" ],
		daysMin : [ "N", "Pn", "Wt", "Śr", "Cz", "Pt", "So", "N" ],
		months : [ "Styczeń", "Luty", "Marzec", "Kwiecień", "Maj", "Czerwiec",
				"Lipiec", "Sierpień", "Wrzesień", "Październik", "Listopad",
				"Grudzień" ],
		monthsShort : [ "Sty", "Lu", "Mar", "Kw", "Maj", "Cze", "Lip", "Sie",
				"Wrz", "Pa", "Lis", "Gru" ],
		today : "Dzisiaj"
	};
</script>