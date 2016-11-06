<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>관리자</title>
</head>
<body>
	<center>
		<h1>회원관리</h1>

		<form class="login-form" action="usergetlist.do" method="post">
			<input id="loginbutton" type="submit" value="회원관리" />
		</form>

		<h1>과목관리</h1>

		<form class="login-form" action="subjectgetlist.do" method="post">
			<input id="loginbutton" type="submit" value="과목관리" />
		</form>
	</center>
</body>
</html>