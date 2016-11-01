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
<title>회원 목록</title>
</head>
<body>
	<h1> 추가 </h1>
	<center>
		<form class="login-form" name="admin.do" method="post">
	      <input type="text" name="i학번"/>
	      <input type="text" name="i이름"/>
	      <input type="text" name="i패스워드"/>
	      <input type="text" name="i주전공"/>
	      <input type="text" name="i복수전공"/>
	     <input id="loginbutton" type="submit" value="추가" /> 
	    </form>
	</center>
	<h1> 수정 </h1>
	<center>
		<form class="login-form" action="admin.do" method="post">
	      <input type="text" name="u학번"/>
	      <input type="text" name="u이름"/>
	      <input type="text" name="u패스워드"/>
	      <input type="text" name="u주전공"/>
	      <input type="text" name="u복수전공"/>
	      <input id="loginbutton" type="submit" value="수정" /> 
	    </form>
	</center>
	<h1> 검색 </h1>
	<center>
		<form class="login-form" action="admin.do" method="post">
	      <input type="text" name="s학번"/>
	      <input id="loginbutton" type="submit" value="검색" />
	    </form>
	</center>
	<h1> 삭제 </h1>
	<center>
		<form class="login-form" action="admin.do" method="post">
	      <input type="text" name="d학번"/>
	      <input id="loginbutton" type="submit" value="삭제" />
	    </form>
	</center>
			<h1> 회원 목록</h1>
			<hr>		
			<table border="1" cellpadding="0" cellspacing="0"align = "center">	
				<tr >
					<th bgcolor="4D95C9" width = "200">학번</th>
					<th bgcolor="4D95C9" width = "200">이름</th>
					<th bgcolor="4D95C9" width = "200">패스워드</th>
					<th bgcolor="4D95C9" width = "200">주전공</th>
					<th bgcolor="4D95C9" width = "200">복수전공</th>
				</tr>
				<% for(UserVO obj : userList) { %>
				<tr>
					<td align = "center"><%= obj.get학번() %> </td>
					<td align = "center"><%= obj.get이름() %></td>
					<td align = "center"><%= obj.get패스워드() %></td>
					<td align = "center"><%= obj.get주전공() %></td>
					<td align = "center"><%= obj.get복수전공() %></td>
				</tr>
				<% } %>
			</table>
			<hr>
		</center>
			<h1> 과목 목록</h1>
			<hr>		
			<table border="1" cellpadding="0" cellspacing="0"align = "center">	
				<tr >
					<th bgcolor="4D95C9" width = "200">과목코드</th>
					<th bgcolor="4D95C9" width = "200">과목명</th>
					<th bgcolor="4D95C9" width = "200">구분</th>
					<th bgcolor="4D95C9" width = "200">학점</th>
					<th bgcolor="4D95C9" width = "200">학년</th>
					<th bgcolor="4D95C9" width = "200">학기</th>
					<th bgcolor="4D95C9" width = "200">학과코드</th>
				</tr>
				<% for(SubjectVO obj : subjectList) { %>
				<tr>
					<td align = "center"><%= obj.get과목코드() %> </td>
					<td align = "center"><%= obj.get과목명() %></td>
					<td align = "center"><%= obj.get구분() %></td>
					<td align = "center"><%= obj.get학점() %></td>
					<td align = "center"><%= obj.get학년() %></td>
					<td align = "center"><%= obj.get학기() %></td>
					<td align = "center"><%= obj.get학과코드() %></td>
				</tr>
				<% } %>
			</table>
			<hr>
</body>
</html>