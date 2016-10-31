<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	
	String Majorresult = (String)request.getAttribute("Majorresult");
	String Generalresult = (String)request.getAttribute("Generalresult");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>결과</title>
</head>
<body>
전공남은 학점 <%=Majorresult %>
교양남은 학점 <%=Generalresult %>
</body>
</html>