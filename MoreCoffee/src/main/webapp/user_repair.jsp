
<%@ page import="java.util.List"%>
<%@ page import="com.ppp.grade.user.persistence.UserDAO"%>
<%@ page import="com.ppp.grade.user.persistence.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	UserVO stu = (UserVO) request.getAttribute("stu_info");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Conten<!--  -->t-Type"
	content="text/html; charset=EUC-KR">
<title>회원정보 수정</title>
</head>
<body>
	
		<form action="userrepairproccontroller.do">
			학번 : <input type="text" name="학번" value="<%=stu.get학번()%>"><br>
			비밀번호 : <input type="text" name="비밀번호" value="<%=stu.get패스워드()%>"><br>
			이름 : <input type="text" name="이름" value="<%=stu.get이름()%>"><br>
			주전공 : <input type="text" name="주전공" value="<%=stu.get주전공()%>"><br>
			복수전공: <input type="text" name="복수전공" value="<%=stu.get복수전공()%>"><br>
			<input type="submit"  value="회원정보수정">
		</form>
</body>
</html>