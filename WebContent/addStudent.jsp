
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý lịch chiếu</title>
<link rel="shortcut icon" href="images/favicon_admin.ico" />
<script type="text/javascript" src="js/jquery2.0.2.js"></script>


<script type="text/javascript" src="js/jquery.dataTables.js"></script>
<link type="text/css" href="css/jquery.dataTables.css" rel="stylesheet" />
<link type="text/css" href="css/style_layout.css" rel="stylesheet" />
<script type="text/javascript">
	$(document).ready(function() {
		$('#example').dataTable({
			"oLanguage" : {
				"sUrl" : "dataTables.vietnameses.txt"
			},
			"order" : [ [ 3, "desc" ] ]
		});
	});
</script>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div id="wrapper">
		<div id="wrapper_table2">
			<table id="example" class="display" cellspacing="0" width="100%">
				<thead>
					<tr>
						<th>Name</th>
						<th>Position</th>
						<th>Office</th>
						<th>Age</th>
						<th>Start date</th>
						<th>Salary</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td>Tiger Nixon</td>
						<td>System Architect</td>
						<td>Edinburgh</td>
						<td>61</td>
						<td>2011/04/25</td>
						<td>$320,800</td>
					</tr>

				</tbody>
			</table>
		</div>
	</div>


	<div style="clear: both"></div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>