<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />

<title>DataTables Bootstrap 3 example</title>

<link rel="stylesheet" type="text/css"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
<%-- <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/styles/dataTables.bootstrap.css"> --%>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<!-- <script type="text/javascript"
	src="http://cdn.datatables.net/1.10-dev/js/jquery.dataTables.min.js"></script> -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery.tablesorter.js"></script>
<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		$("#example").tablesorter({
			sortList : [ [ 0, 0 ], [ 1, 0 ] ],
			headers : {
				4 : {
					sorter : false
				}
			}
		});
	});
</script>
</head>


<body>
	<div class="container">

		<table class="table tablesorter" id="example">
			<thead>
				<tr>
					<th>Last Name</th>
					<th>First Name</th>
					<th>Email</th>
					<th>Due</th>
					<th>Web Site</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Smith</td>
					<td>John</td>
					<td>jsmith@gmail.com</td>
					<td>$50.00</td>
					<td>http://www.jsmith.com</td>
				</tr>
				<tr>
					<td>Bach</td>
					<td>Frank</td>
					<td>fbach@yahoo.com</td>
					<td>$50.00</td>
					<td>http://www.frank.com</td>
				</tr>
				<tr>
					<td>Doe</td>
					<td>Jason</td>
					<td>jdoe@hotmail.com</td>
					<td>$100.00</td>
					<td>http://www.jdoe.com</td>
				</tr>
				<tr>
					<td>Conway</td>
					<td>Tim</td>
					<td>tconway@earthlink.net</td>
					<td>$50.00</td>
					<td>http://www.timconway.com</td>
				</tr>
			</tbody>
		</table>

	</div>

</body>
</html>