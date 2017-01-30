
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert 1</title>
<link rel="shortcut icon" href="images/favicon_admin.ico" />
<script type="text/javascript" src="js/jquery2.0.2.js"></script>


<script type="text/javascript" src="js/jquery.dataTables.js"></script>
<link type="text/css" href="css/jquery.dataTables.css" rel="stylesheet" />
<link type="text/css" href="css/style_layout.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery.datepick-vi.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<link type="text/css" href="css/jquery-ui.css" rel="stylesheet" />
<script type="text/javascript">
	$(document).ready(function() {
		$('#example').dataTable({
			"oLanguage" : {
				"sUrl" : "dataTables.vietnameses.txt"
			},
			"order" : [ [ 1, "asc" ] ]
		});
	});
</script>

<script>
	$(function() {
		$(".datepicker").datepicker({
			changeMonth : true,
			changeYear : true,
			showOn : "button",
			buttonImage : "images/calendar.jpg",
			buttonImageOnly : true,

		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {

		$('#btn_submit').click(function() {

			var studentID = $('#studentID').val();
			var fullName = $('#fullName').val();
			var birthday = $('#birthday').val();

			if (studentID == "") {
				alert("StudentID invalid");
				return false;
			}
			if (fullName == "") {
				alert("fullName invalid");
				return false;
			}
			if (birthday == "") {
				alert("birthday invalid");
				return false;
			}

			// kiem tra check box
			var check = $(".multibox");
			var count = 0;
			var i = 0;
			for (i = 0; i < check.length; i++) {
				if (check[i].checked == true) {
					count++;
				}
			}

			if (count == 0) {
				alert("Bạn vui lòng chọn sở thích");
				return false;
			}

		});
	});
</script>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div id="wrapper">
		<div class="form_title">THÊM...</div>
		<div class="form">
			<html:form action="/AddStudent">
				<table>
					<tr>
						<td colspan="2" align="center" style="font-size: 20px;"></td>
					</tr>

					<tr>
						<td class="label">* Mã Sinh Viên</td>
						<td class="input"></td>
					</tr>
					<tr>
						<td class="label">* Họ Tên</td>
						<td class="input"></td>
					</tr>
					<tr>
						<td class="label">* Ngày Sinh</td>
						<td class="input"></td>
					</tr>

					<tr>
						<td class="register_label" colspan="2">
							<hr>
						</td>

					</tr>
					<tr>
						<td class="register_label"></td>
						<td class="register_input"><html:image value="submit"
								src="images/SignUp_vn.png" styleId="btn_submit"></html:image></td>

					</tr>
				</table>

			</html:form>
		</div>

		<!-- Thong bao loi start-->
		<div
			style="font-size: 20px; margin: 0 auto; margin-bottom: 20px; margin-top: 20px; text-align: center;">
			<div class="msg_err">
				<html:errors />
			</div>
			<div class="msg_success">
				<html:messages id="message" message="true">
					<bean:write name="message" />
				</html:messages>
			</div>
		</div>
		<!-- Thong bao loi end -->


		<div id="wrapper_table2">

			<table id="example" class="display" cellspacing="0" width="100%">
				<thead>
					<tr>

						<th>Mã SV</th>
						<th>Họ Tên</th>
						<th>Ngày Sinh</th>
						<th>Giới Tính</th>
						<th>Lớp</th>
						<th>Sở Thích</th>
						<th>Chỉnh sửa</th>
						<th>Xóa</th>
					</tr>
				</thead>

				<tbody>
					<!-- For start -->
					<tr>
						<td align="center"></td>
						<td></td>
						<td align="center"></td>
						<td></td>
						<td></td>
						<td></td>
						<td align="center"></td>
						<td align="center"></td>
					</tr>
					<!-- for end -->

				</tbody>
			</table>

		</div>
	</div>


	<div style="clear: both"></div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$(".img_delete").click(function() {
			if (!confirm("Do you want to delete")) {
				return false;
			}
		});
	});
</script>
</html>