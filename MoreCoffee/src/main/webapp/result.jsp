<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	
	String Majorresult = (String)request.getAttribute("Majorresult");
	String Generalresult1 = (String)request.getAttribute("Generalresult1");
	String Generalresult2 = (String)request.getAttribute("Generalresult2");
	String Minorresult = (String)request.getAttribute("Minorresult");
	String Majorbaseresult = (String)request.getAttribute("Majorbaseresult");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>결과</title>
</head>
<body>
전공남은 학점 <%=Majorresult %>
</br>학과기초남은 학점 = <%=Majorbaseresult %>
<%
	if(Minorresult != null){
		%></br>복수전공남은 학점=<%=Minorresult %>
<%
	}
%>
</br>일반교양남은 학점 = <%=Generalresult1 %>
</br>필수교양남은 학점 = <%=Generalresult2 %>
<form action="RsltToSltController.do">
    <input type="submit" value="수강이력수정">
</form>
</body>
</html>