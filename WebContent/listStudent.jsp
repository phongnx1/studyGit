
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

	function IsEmail(email) {
		var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if (!regex.test(email)) {
			return false;
		} else {
			return true;
		}
	};
	function validatePhone(phone) {
		var filter = /^((\+[1-9]{1,4}[ \-]*)|(\([0-9]{2,3}\)[ \-]*)|([0-9]{2,4})[ \-]*)*?[0-9]{3,4}?[ \-]*[0-9]{3,4}?$/;
		if (filter.test(phone)) {
			return true;
		} else {
			return false;
		}
	};
	function validateStaffCode(staffCode) {

	};
	function validateGender(gender) {
		if (gender == 'female' || gender == 'male') {
			return true;

		} else
			return false;
	}
	function validateClass(class_if) {
		if (class_if == 'None') {
			return false;
		} else {
			return true;
		}

	}
	function isValidStaffCode(code) {
		var pattern = new RegExp(/^[a-zA-Z][0-9a-zA-Z]*[0-9][0-9a-zA-Z]*$/);
		return (pattern.test(code) && (code.length == 6));

	};
</script>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div id="wrapper">
		<div class="form_title">THÊM SINH VIÊN</div>
		<div class="form">
			<html:form action="/AddStudent">
				<table>
					<tr>
						<td colspan="2" align="center" style="font-size: 20px;"></td>
					</tr>

					<tr>
						<td class="label">* Mã Sinh Viên</td>
						<td class="input"><html:text property="studentID"
								styleClass="form_text" styleId="studentID"></html:text></td>
					</tr>
					<tr>
						<td class="label">* Họ Tên</td>
						<td class="input"><html:text property="fullName"
								styleClass="form_text" styleId="fullName"></html:text></td>
					</tr>
					<tr>
						<td class="label">* Ngày Sinh</td>
						<td class="input"><html:text property="birthday"
								styleClass="datepicker" styleId="birthday" readonly="true"></html:text></td>
					</tr>
					<tr>
						<td class="label">* Giới Tính</td>
						<td class="input"><html:radio property="sex" value="Nam">Nam</html:radio>
							<html:radio property="sex" value="Nữ">Nữ</html:radio> <html:radio
								property="sex" value="Khác">Khác</html:radio></td>
					</tr>

					<tr>
						<td class="label">* Lớp</td>
						<td class="input"><html:select property="class_name"
								styleClass="form_select">
								<html:option value="09T1">09T1</html:option>
								<html:option value="09T2">09T2</html:option>
								<html:option value="09T3">09T3</html:option>
								<html:option value="09T4">09T4</html:option>
							</html:select></td>
					</tr>
					<tr>
						<td class="label" valign="top">Sở Thích</td>
						<td class="input"><logic:iterate id="hbId" name="studentForm"
								property="hobbies">
								<div style="width: 300px">
									<html:multibox property="selectedHobbies" styleClass="multibox"
										styleId="checkbox">
										<bean:write name="hbId" />
									</html:multibox>
									<bean:write name="hbId" />
								</div>
							</logic:iterate></td>
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
		<div id="wrapper_table2">

			<table id="example" class="display" cellspacing="0" width="100%">
				<thead>
					<tr>
						<th>STT</th>
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
					<logic:iterate indexId="a" name="studentForm" id="listID"
						property="listStudent">


						<tr>
							<td align="center"><bean:write name="a" /></td>

							<td align="center"><bean:write name="listID"
									property="studentID" /></td>
							<td><bean:write name="listID" property="fullName" /></td>
							<td align="center"><bean:write name="listID"
									property="birthday" /></td>
							<td><bean:write name="listID" property="sex" /></td>
							<td><bean:write name="listID" property="class_name" /></td>
							<td><bean:write name="listID" property="hobbies" /></td>




							<td align="center"><html:link href="ShowUpdateStudent.do">
									<html:param name="studentID">
										<bean:write name="listID" property="studentID" />
									</html:param>
									<img alt="" src="images/edit.png" width="25px" height="25px">
								</html:link></td>

							<td align="center"><html:link href="DeleteStudent.do">
									<html:param name="studentID">
										<bean:write name="listID" property="studentID" />
									</html:param>
									<img alt="" src="images/delete.png" width="25px" height="25px"
										class="img_delete">
								</html:link></td>
						</tr>


					</logic:iterate>

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