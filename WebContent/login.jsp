<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Admin</title>
<style type="text/css">
form {
	width: 90%;
	margin: auto;
}

body {
	background: url("images/bg.png");
	font-family: 'Oleo Script', cursive;
}

@font-face {
	font-family: 'Oleo Script';
	font-style: normal;
	font-weight: 400;
	src: local('Oleo Script'), local('OleoScript-Regular'),
		url(http://fonts.gstatic.com/s/oleoscript/v4/_weQNDK6Uf40CiGFKBBUjo4P5ICox8Kq3LLUNMylGO4.woff2)
		format('woff2'),
		url(http://fonts.gstatic.com/s/oleoscript/v4/_weQNDK6Uf40CiGFKBBUjobN6UDyHWBl620a-IRfuBk.woff)
		format('woff');
}
</style>
<link href='http://fonts.googleapis.com/css?family=Oleo+Script'
	rel='stylesheet' type='text/css'>
<link rel="shortcut icon" href="images/favicon_lock.ico" />
<link rel="stylesheet" href="css/style_login.css" type='text/css' />
<script type="text/JavaScript" src="js/jquery2.0.2.js"></script>

<script type="text/javascript">
	$(function() {
		$("#username").attr("placeholder", "tên đăng nhập");
		$("#password").attr("placeholder", "mật khẩu");
	});
</script>
</head>
<body>
	<div class="lg-container">
		<h1 style="color: rgb(199, 14, 14);">JAVA FINAL</h1>
		<html:form focus="username" action="/CheckLogin" styleId="lg-form">
			<div>
				<html:text property="userName" styleId="username"
					styleClass="username"></html:text>
			</div>
			<div>
				<html:password property="password" styleId="password"
					styleClass="password"></html:password>
			</div>
			<div align="center">
				<html:submit value="Đăng Nhập" styleId="submit"></html:submit>
			</div>
		</html:form>
		<div id="message" style="color: red;">

			<html:errors />

		</div>
	</div>
</body>
</html:html>