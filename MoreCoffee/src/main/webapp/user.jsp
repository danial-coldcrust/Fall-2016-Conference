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
<title>회원 목록</title>
</head>
<body>
	<h1>추가</h1>
	<center>
		<form class="login-form" action="usercreate.do" method="post">
			<input type="text" name="c학번" />
			<input type="text" name="c이름" />
			<input type="text" name="c패스워드" />
			<input type="text" name="c주전공" />
			<input type="text" name="c복수전공" />
			<input id="loginbutton" type="submit" value="추가" />
		</form>
	</center>
	<h1>검색</h1>
	<center>
		<form class="login-form" action="userread.do" method="post">
			<input type="text" name="r학번"/>
			<input id="loginbutton"	type="submit" value="검색" />
		</form>
	</center>
	<h1>수정</h1>
	<center>
		<form class="login-form" action="userupdate.do" method="post">
			<input type="text" name="u학번" />
			<input type="text" name="u이름" />
			<input type="text" name="u패스워드" />
			<input type="text" name="u주전공" />
			<input type="text" name="u복수전공" />
			<input id="loginbutton" type="submit" value="수정" />
		</form>
	</center>
	<h1>삭제</h1>
	<center>
		<form class="login-form" action="userdelete.do" method="post">
			<input type="text" name="d학번" />
			<input id="loginbutton"	type="submit" value="삭제" />
		</form>
	</center>
	<h1>회원 목록</h1>
	<hr>
	<table border="1" cellpadding="0" cellspacing="0" align="center">
		<tr>
			<th bgcolor="4D95C9" width="200">학번</th>
			<th bgcolor="4D95C9" width="200">이름</th>
			<th bgcolor="4D95C9" width="200">패스워드</th>
			<th bgcolor="4D95C9" width="200">주전공</th>
			<th bgcolor="4D95C9" width="200">복수전공</th>
		</tr>
		<%
			for (UserVO obj : userList) {
		%>
		<tr>
			<td align="center"><%=obj.get학번()%></td>
			<td align="center"><%=obj.get이름()%></td>
			<td align="center"><%=obj.get패스워드()%></td>
			<td align="center"><%=obj.get주전공()%></td>
			<td align="center"><%=obj.get복수전공()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>