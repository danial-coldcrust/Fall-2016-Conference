
<%@ page import="java.util.List"%>
<%@ page import="com.ppp.grade.subject.persistence.SubjectDAO"%>
<%@ page import="com.ppp.grade.subject.persistence.SubjectVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<SubjectVO> subjectList = (List) request.getAttribute("subjectList");
	List<SubjectVO> subjectList2 = (List) request.getAttribute("subjectList2");
	String num = (String)request.getAttribute("num");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	 <form method="post" action="result.do">
	 
		<input type="hidden" name="num" value=<%=num%>>
		<table border="1" cellpadding="0" cellspacing="0" align="center">
			<%
				for (SubjectVO obj : subjectList) {
			%>
			<tr>
				<td align="center"><%=obj.get과목코드()%></td>
				<td align="center"><%=obj.get과목명()%></td>
				<td align="center"><%=obj.get구분()%></td>
				<td align="center"><%=obj.get학점()%></td>
				<td align="center"><%=obj.get학년()%></td>
				<td align="center"><%=obj.get학기()%></td>
				<td align="center"><%=obj.get학과코드()%></td>
				<td><input type="checkbox" name="subject"
					value=<%=obj.get과목코드()%>></td>
			</tr>
			<%
				}
			%>
		</table>
		<table border="1" cellpadding="0" cellspacing="0" align="center">
			<%
				for (SubjectVO obj : subjectList2) {
			%>
			<tr>
				<td align="center"><%=obj.get과목코드()%></td>
				<td align="center"><%=obj.get과목명()%></td>
				<td align="center"><%=obj.get구분()%></td>
				<td align="center"><%=obj.get학점()%></td>
				<td align="center"><%=obj.get학년()%></td>
				<td align="center"><%=obj.get학기()%></td>
				<td align="center"><%=obj.get학과코드()%></td>
				<td><input type="checkbox" name="subject"
					value=<%=obj.get과목코드()%>></td>
			</tr>
			<%
				}
			%>
		</table>
		<input type="submit" name="submit" value="결과보기">
	</form> 
</body>
</html>