<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.ppp.grade.user.persistence.UserDAO"%>
<%@ page import="com.ppp.grade.user.persistence.UserVO"%>
<%@ page import="java.util.List"%>
<%
	List<UserVO> userList = (List) request.getAttribute("userList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ�� ���</title>
</head>
<body>
	<h1>�߰�</h1>
	<center>
		<form class="login-form" action="usercreate.do" method="post">
			<input type="text" name="c�й�" />
			<input type="text" name="c�̸�" />
			<input type="text" name="c�н�����" />
			<input type="text" name="c������" />
			<input type="text" name="c��������" />
			<input id="loginbutton" type="submit" value="�߰�" />
		</form>
	</center>
	<h1>�˻�</h1>
	<center>
		<form class="login-form" action="userread.do" method="post">
			<input type="text" name="r�й�"/>
			<input id="loginbutton"	type="submit" value="�˻�" />
		</form>
	</center>
	<h1>����</h1>
	<center>
		<form class="login-form" action="userupdate.do" method="post">
			<input type="text" name="u�й�" />
			<input type="text" name="u�̸�" />
			<input type="text" name="u�н�����" />
			<input type="text" name="u������" />
			<input type="text" name="u��������" />
			<input id="loginbutton" type="submit" value="����" />
		</form>
	</center>
	<h1>����</h1>
	<center>
		<form class="login-form" action="userdelete.do" method="post">
			<input type="text" name="d�й�" />
			<input id="loginbutton"	type="submit" value="����" />
		</form>
	</center>
	<h1>ȸ�� ���</h1>
	<hr>
	<table border="1" cellpadding="0" cellspacing="0" align="center">
		<tr>
			<th bgcolor="4D95C9" width="200">�й�</th>
			<th bgcolor="4D95C9" width="200">�̸�</th>
			<th bgcolor="4D95C9" width="200">�н�����</th>
			<th bgcolor="4D95C9" width="200">������</th>
			<th bgcolor="4D95C9" width="200">��������</th>
		</tr>
		<%
			for (UserVO obj : userList) {
		%>
		<tr>
			<td align="center"><%=obj.get�й�()%></td>
			<td align="center"><%=obj.get�̸�()%></td>
			<td align="center"><%=obj.get�н�����()%></td>
			<td align="center"><%=obj.get������()%></td>
			<td align="center"><%=obj.get��������()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>