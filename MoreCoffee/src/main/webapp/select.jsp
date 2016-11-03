
<%@ page import="java.util.List"%>
<%@ page import="com.ppp.grade.subject.persistence.SubjectDAO"%>
<%@ page import="com.ppp.grade.subject.persistence.SubjectVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<SubjectVO> MysubjectList = (List) request.getAttribute("mysubjectList"); //수강이력
	List<SubjectVO> subjectList = (List) request.getAttribute("subjectList"); //전공
	List<SubjectVO> subjectList2 = (List) request.getAttribute("subjectList2");//교양
	List<SubjectVO> subjectList3 = (List) request.getAttribute("subjectList3");//필수교양
	String studentNum = (String) request.getAttribute("num");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  전공 , 필수전공 -->
	<form method="post" action="result.do">
		<input type="hidden" name="num" value=<%=studentNum%>>
<table border="1" cellpadding="0" cellspacing="0" align="center">
		<%
			for (SubjectVO obj : subjectList) {
				if (obj.get구분().equals("전공")) {
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
			}
		%>
		</table>
		
		<!--학과기초 -->
		<table border="1" cellpadding="0" cellspacing="0" align="center">
		<%
			for (SubjectVO obj : subjectList) {
				if (obj.get구분().equals("학과기초")) {
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
			}
		%>
		</table>
		<!--교양 -->
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

				if (MysubjectList != null) {
					System.out.println("체크알고리즘");
				}
			%>
		</table>


		<!--  복수 전공  -->
		<table border="1" cellpadding="0" cellspacing="0" align="center">
			<%
				if (subjectList3 != null) {
					for (SubjectVO obj : subjectList3) {
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
				}
			%>
		</table>

		<input type="submit" name="submit" value="결과보기">
	</form>
	<form method="post" action="user_repair.do">
		<!--승탁이추가 여기부터  -->
		<input type="submit" name="repair_sumbit" value="회원정보수정">
		<!--여기까지  -->
		</from>
</body>
</html>