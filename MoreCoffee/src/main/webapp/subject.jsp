<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List"%>
<%@ page import="com.ppp.grade.subject.persistence.SubjectVO"%>
<%@ page import="com.ppp.grade.subject.persistence.SubjectDAO"%>

<% List<SubjectVO> subjectList = (List) request.getAttribute("subjectList"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� ���</title>
</head>
<body>
	<h1>�߰�</h1>
	<center>
		<form class="login-form" action="subjectcreate.do" method="post">
			<input type="text" name="c�����ڵ�" />
			<input type="text" name="c�����" />
			<input type="text" name="c����" />
			<input type="text" name="c����" />
			<input type="text" name="c�г�" />
			<input type="text" name="c�б�" />
			<input type="text" name="c�а��ڵ�" />
			<input id="loginbutton" type="submit" value="�߰�" />
		</form>
	</center>
	<h1>�˻�</h1>
	<center>
		<form class="login-form" action="subjectread.do" method="post">
			<input type="text" name="r�����ڵ�" id = "textbox1"/>
			<input id="loginbutton"	type="submit"value="�˻�" />
		</form>
	</center>
	<h1>����</h1>
	<center>
		<form class="login-form" action="subjectupdate.do" method="post">
			<input type="text" name="u�����ڵ�" />
			<input type="text" name="u�����" />
			<input type="text" name="u����" />
			<input type="text" name="u����" />
			<input type="text" name="u�г�" />
			<input type="text" name="u�б�" /> 
			<input type="text" name="u�а��ڵ�" />
			<input id="loginbutton" type="submit" value="����" />
		</form>
	</center>
	<h1>����</h1>
	<center>
		<form class="login-form" action="subjectdelete.do" method="post">
			<input type="text" name="d�����ڵ�" /> <input id="loginbutton"
				type="submit" value="����" />
		</form>
	</center>
	<h1>���� ���</h1>
	<hr>
	<table border="1" cellpadding="0" cellspacing="0" align="center">
		<tr>
			<th bgcolor="4D95C9" width="200">�����ڵ�</th>
			<th bgcolor="4D95C9" width="200">�����</th>
			<th bgcolor="4D95C9" width="200">����</th>
			<th bgcolor="4D95C9" width="200">����</th>
			<th bgcolor="4D95C9" width="200">�г�</th>
			<th bgcolor="4D95C9" width="200">�б�</th>
			<th bgcolor="4D95C9" width="200">�а��ڵ�</th>
		</tr>
		<% for(SubjectVO obj : subjectList) { %>
		<tr>
			<td align="center"><%= obj.get�����ڵ�() %></td>
			<td align="center"><%= obj.get�����() %></td>
			<td align="center"><%= obj.get����() %></td>
			<td align="center"><%= obj.get����() %></td>
			<td align="center"><%= obj.get�г�() %></td>
			<td align="center"><%= obj.get�б�() %></td>
			<td align="center"><%= obj.get�а��ڵ�() %></td>
		</tr>
		<% } %>
	</table>
</body>
</html>