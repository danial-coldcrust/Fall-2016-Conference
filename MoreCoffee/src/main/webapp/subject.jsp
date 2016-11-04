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
<title>과목 목록</title>
</head>
<body>
	<h1>추가</h1>
	<center>
		<form class="login-form" action="subjectcreate.do" method="post">
			<input type="text" name="c과목코드" />
			<input type="text" name="c과목명" />
			<input type="text" name="c구분" />
			<input type="text" name="c학점" />
			<input type="text" name="c학년" />
			<input type="text" name="c학기" />
			<input type="text" name="c학과코드" />
			<input id="loginbutton" type="submit" value="추가" />
		</form>
	</center>
	<h1>검색</h1>
	<center>
		<form class="login-form" action="subjectread.do" method="post">
			<input type="text" name="r과목코드" id = "textbox1"/>
			<input id="loginbutton"	type="submit"value="검색" />
		</form>
	</center>
	<h1>수정</h1>
	<center>
		<form class="login-form" action="subjectupdate.do" method="post">
			<input type="text" name="u과목코드" />
			<input type="text" name="u과목명" />
			<input type="text" name="u구분" />
			<input type="text" name="u학점" />
			<input type="text" name="u학년" />
			<input type="text" name="u학기" /> 
			<input type="text" name="u학과코드" />
			<input id="loginbutton" type="submit" value="수정" />
		</form>
	</center>
	<h1>삭제</h1>
	<center>
		<form class="login-form" action="subjectdelete.do" method="post">
			<input type="text" name="d과목코드" /> <input id="loginbutton"
				type="submit" value="삭제" />
		</form>
	</center>
	<h1>과목 목록</h1>
	<hr>
	<table border="1" cellpadding="0" cellspacing="0" align="center">
		<tr>
			<th bgcolor="4D95C9" width="200">과목코드</th>
			<th bgcolor="4D95C9" width="200">과목명</th>
			<th bgcolor="4D95C9" width="200">구분</th>
			<th bgcolor="4D95C9" width="200">학점</th>
			<th bgcolor="4D95C9" width="200">학년</th>
			<th bgcolor="4D95C9" width="200">학기</th>
			<th bgcolor="4D95C9" width="200">학과코드</th>
		</tr>
		<% for(SubjectVO obj : subjectList) { %>
		<tr>
			<td align="center"><%= obj.get과목코드() %></td>
			<td align="center"><%= obj.get과목명() %></td>
			<td align="center"><%= obj.get구분() %></td>
			<td align="center"><%= obj.get학점() %></td>
			<td align="center"><%= obj.get학년() %></td>
			<td align="center"><%= obj.get학기() %></td>
			<td align="center"><%= obj.get학과코드() %></td>
		</tr>
		<% } %>
	</table>
</body>
</html>