<%@ page import = "java.util.List" %>
<%@ page import = "com.ppp.grade.user.persistence.UserDAO" %>
<%@ page import = "com.ppp.grade.user.persistence.UserVO" %>
<%@ page import = "com.ppp.grade.subject.persistence.SubjectVO" %>
<%@ page import = "com.ppp.grade.subject.persistence.SubjectDAO" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    
<% List<UserVO> userList = (List) request.getAttribute("userList"); %>
<% List<SubjectVO> subjectList = (List) request.getAttribute("subjectList"); %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ�� ���</title>
</head>
<body>
	<h1> �߰� </h1>
	<center>
		<form class="login-form" name="admin.do" method="post">
	      <input type="text" name="i�й�"/>
	      <input type="text" name="i�̸�"/>
	      <input type="text" name="i�н�����"/>
	      <input type="text" name="i������"/>
	      <input type="text" name="i��������"/>
	     <input id="loginbutton" type="submit" value="�߰�" /> 
	    </form>
	</center>
	<h1> ���� </h1>
	<center>
		<form class="login-form" action="admin.do" method="post">
	      <input type="text" name="u�й�"/>
	      <input type="text" name="u�̸�"/>
	      <input type="text" name="u�н�����"/>
	      <input type="text" name="u������"/>
	      <input type="text" name="u��������"/>
	      <input id="loginbutton" type="submit" value="����" /> 
	    </form>
	</center>
	<h1> �˻� </h1>
	<center>
		<form class="login-form" action="admin.do" method="post">
	      <input type="text" name="s�й�"/>
	      <input id="loginbutton" type="submit" value="�˻�" />
	    </form>
	</center>
	<h1> ���� </h1>
	<center>
		<form class="login-form" action="admin.do" method="post">
	      <input type="text" name="d�й�"/>
	      <input id="loginbutton" type="submit" value="����" />
	    </form>
	</center>
			<h1> ȸ�� ���</h1>
			<hr>		
			<table border="1" cellpadding="0" cellspacing="0"align = "center">	
				<tr >
					<th bgcolor="4D95C9" width = "200">�й�</th>
					<th bgcolor="4D95C9" width = "200">�̸�</th>
					<th bgcolor="4D95C9" width = "200">�н�����</th>
					<th bgcolor="4D95C9" width = "200">������</th>
					<th bgcolor="4D95C9" width = "200">��������</th>
				</tr>
				<% for(UserVO obj : userList) { %>
				<tr>
					<td align = "center"><%= obj.get�й�() %> </td>
					<td align = "center"><%= obj.get�̸�() %></td>
					<td align = "center"><%= obj.get�н�����() %></td>
					<td align = "center"><%= obj.get������() %></td>
					<td align = "center"><%= obj.get��������() %></td>
				</tr>
				<% } %>
			</table>
			<hr>
		</center>
			<h1> ���� ���</h1>
			<hr>		
			<table border="1" cellpadding="0" cellspacing="0"align = "center">	
				<tr >
					<th bgcolor="4D95C9" width = "200">�����ڵ�</th>
					<th bgcolor="4D95C9" width = "200">�����</th>
					<th bgcolor="4D95C9" width = "200">����</th>
					<th bgcolor="4D95C9" width = "200">����</th>
					<th bgcolor="4D95C9" width = "200">�г�</th>
					<th bgcolor="4D95C9" width = "200">�б�</th>
					<th bgcolor="4D95C9" width = "200">�а��ڵ�</th>
				</tr>
				<% for(SubjectVO obj : subjectList) { %>
				<tr>
					<td align = "center"><%= obj.get�����ڵ�() %> </td>
					<td align = "center"><%= obj.get�����() %></td>
					<td align = "center"><%= obj.get����() %></td>
					<td align = "center"><%= obj.get����() %></td>
					<td align = "center"><%= obj.get�г�() %></td>
					<td align = "center"><%= obj.get�б�() %></td>
					<td align = "center"><%= obj.get�а��ڵ�() %></td>
				</tr>
				<% } %>
			</table>
			<hr>
</body>
</html>