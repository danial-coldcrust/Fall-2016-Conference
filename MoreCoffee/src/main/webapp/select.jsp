<%@ page import="java.util.List"%>
<%@ page import="com.ppp.grade.subject.persistence.SubjectDAO"%>
<%@ page import="com.ppp.grade.subject.persistence.SubjectVO"%>
<%@ page import="com.ppp.grade.select.persistence.SelectVO"%>
<%@ page import= "com.ppp.grade.history.persistence.HistoryDAO"%>
<%@ page import= "com.ppp.grade.history.persistence.HistoryVO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<SelectVO> MysubjectList = (List) request.getAttribute("mysubjectList"); //수강이력
	List<SubjectVO> subjectList = (List) request.getAttribute("subjectList"); //전공
	List<SubjectVO> subjectList2 = (List) request.getAttribute("subjectList2");//교양
	List<SubjectVO> subjectList3 = (List) request.getAttribute("subjectList3");//필수교양
	String studentNum = (String) request.getAttribute("num");
	
	SubjectDAO subjectDAO = new SubjectDAO();
	SubjectVO subjectVO = new SubjectVO();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>졸업사정 FOR SCH STUDENT</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="resources/css/main.css">
<link type="text/css" rel="stylesheet"
	href="resources/css/multi-select.css">
<link type="text/css" rel="stylesheet" href="resources/css/result.css">

</head>

<body>
	<div id="wrapper">
		<!-- Page content -->
		<div id="page-content-wrapper">

			<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>

					<a class="navbar-brand">졸업할수있을까?</a>
				</div>
				<!--navbar-header close-->
				<div class="collapse navbar-collapse drop_menu" id="navbar">
					<ul class="nav navbar-nav">
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#"><span
								class="glyphicon glyphicon-pencil"></span>&nbsp;과목<span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="anch1">학과기초</a></li>
								<li><a href="anch2">전공</a></li>
								<li><a href="anch3">교양</a></li>
								<li><a href="anch4">복수전공</a></li>
								<li class="divider"></li>
								<li><a href="#">봉사시간</a></li>
								<li><a href="#">교육</a></li>
							</ul> <!--dropdown-menu close--></li>
						<li><a href="user_repair.do" method="post" target="_blank"><span
								class="glyphicon glyphicon-user" name="repair_sumbit"></span>&nbsp;회원정보수정</a></li>

						<li><a href="https://portal.sch.ac.kr/" target="_blank"><span
								class="glyphicon glyphicon-home"></span>&nbsp;포탈</a></li>
						<li><a href="#"><span
								class="glyphicon glyphicon-heart-empty"></span>&nbsp;</a></li>
					</ul>
					<!--nav navbar-nav close-->
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#"><span class="glyphicon glyphicon-print"></span>&nbsp;Print</a></li>
						<li><a href="#"><span
								class="glyphicon glyphicon-hourglass"></span>&nbsp;Modified</a></li>
						<li><a href="#"><span class="glyphicon glyphicon-log-out"></span>&nbsp;LogOut</a></li>
					</ul>
					<!--navbar-right close-->
				</div>
				<!--collapse navbar-collapse drop_menu close-->
			</div>
			<!--container-fluid close--> </nav>


			<div id="page-content-wrapper">
				<div class="page-content inset" data-spy="scroll" data-target="#spy">
					<div class="row">

						<div class="text-center">
							<h3>수강했던 과목을 선택해주세요</h3>
						</div>

					</div>

					<!--학과기초-->
					<div class="row">
						<div class="col-md-12 well">
							<legend id="anch1">학과기초</legend>

							<form method="post" action="result.do">
								<!-- 학과기초 -->
								<input type="hidden" name="num" value=<%=studentNum%>>
								<div class='row'>
									<div class='span12'>
										<select multiple class="searchable" name="subject[]">
											<%
												for (SubjectVO obj : subjectList) {
													if (obj.get구분().equals("학과기초")) {
											%>
											<option value=<%=obj.get과목코드()%>><%=obj.get과목명()%>[<%=obj.get학점()%>]&nbsp;&nbsp;<%=obj.get학년()%>학년
											</option>
											<%
												}
												}
											%>
										</select>
									</div>
								</div>
								<!--전공 : 신규회원-->
								<class="col-md-12well"> <legend id="anch2">전&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;공</legend>
								<div class='row'>
									<div class='span12'>
									<%
												if (MysubjectList == null) { %>
										<select multiple class="searchable" name="subject[]">
											<!--전공 -- : 초기회원>-->
											<%
													for (SubjectVO obj : subjectList) {
														if (obj.get구분().equals("전공")) {
											%>
											<option value=<%=obj.get과목코드()%>><%=obj.get과목명()%>[<%=obj.get학점()%>]&nbsp;&nbsp;<%=obj.get학년()%>학년
											</option>
											<%
												}
													}
											%>
										</select>
										<%	} else//if문	
			// <!--전공 -- : 기존회원-내가 선택한거 빼고 출력> -->
			 {
				int MajorSubjectCnt = 0;
				for (SubjectVO obj : subjectList) {
					if (obj.get구분().equals("전공")) {
						MajorSubjectCnt++;
					}

				}

				for (int i = 0; i < MajorSubjectCnt - 1; i++) {
					for (int j = 0; j < MysubjectList.size(); j++) {
						if (subjectList.get(i).get구분().equals("전공")) {
							if (MysubjectList.get(j).get과목코드().equals(subjectList.get(i).get과목코드())) {
								subjectList.remove(subjectList.get(i));
								MajorSubjectCnt--;
							} else {
								continue;
							}
						}
					}
				}
				%>

										<select multiple class="searchable" name="subject[]"">
											<%
												for (SubjectVO obj : subjectList) {
														if (obj.get구분().equals("전공")) {
											%>

											<option value=<%=obj.get과목코드()%>><%=obj.get과목명()%>[<%=obj.get학점()%>]&nbsp;&nbsp;<%=obj.get학년()%>학년
											</option>

											<%
												}
													}
											%>
										
								

								<!--전공 -- : 기존회원-내가 선택한거출력> --> <%
									 	for (SelectVO obj : MysubjectList) {
									 			subjectVO = subjectDAO.getSubject(obj.get과목코드());
									 			if (subjectVO.get구분().equals("전공")) {
									 %>

								<option selected value=<%=obj.get과목코드()%>><%=subjectVO.get과목명()%>[<%=subjectVO.get학점()%>]&nbsp;&nbsp;<%=subjectVO.get학년()%>학년
								</option>

								<%
									}
										}
								%> </select> 
									</div>
								</div><%
				} //else
			%> <!--교양 --> <class="col-md-12well"> <legend id="anch3">교&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;양</legend>
								<div class='row'>
									<div class='span12'>
										<select multiple class="searchable" name="subject[]"">
											<%
															for (SubjectVO obj : subjectList2) {
														%>
											<option value=<%=obj.get과목코드()%>><%=obj.get과목명()%>[<%=obj.get학점()%>]&nbsp;&nbsp;<%=obj.get학년()%>학년
											</option>
											<%
															}
															if (MysubjectList != null) {
																System.out.println("체크알고리즘");
															}
														%>
										</select>
									</div>
								</div>
								<!--  복수 전공  --> <class="col-md-12well"> <legend
									id="anch4">복수전공</legend>
								<div class='row'>
									<div class='span12'>
										<select multiple class="searchable" name="subject[]"">
											<%
															if (subjectList3 != null) {
																for (SubjectVO obj : subjectList3) {
														%>
											<option value=<%=obj.get과목코드()%>><%=obj.get과목명()%>[<%=obj.get학점()%>]&nbsp;&nbsp;<%=obj.get학년()%>학년
											</option>
											<%
															}
																if (MysubjectList != null) {
																	System.out.println("체크알고리즘");
																}
															}
														%>
										</select>
										<%
										//여기서 history 비워주자
										HistoryDAO historyDAO = new HistoryDAO();
										HistoryVO historyVO = new HistoryVO();
										historyDAO.deleteHistory(studentNum);
										%>
									</div>
								</div>
								</div>
					</div>
					<center>
						<button class="btn btn-danger btn-block" type="submit"
							name="submit" value="결과보기" style="max-width: 300px">결과보기</button>
					</center>
					</form>
					<form method="post" action="user_repair.do">
						<!--승탁이추가 여기부터  -->
						<center>
							<button class="btn btn-info btn-block" type="submit"
								name="repair_sumbit" value="회원정보수정" style="max-width: 300px">회원정보수정</button>
						</center>
						<!--여기까지  -->
						</from>
				</div>
			</div>

			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
			<script src="resources/js/bootstrap.min.js"></script>
			<script src="resources/js/main.js"></script>
			<script src="resources/js/jquery.js" type="text/javascript"></script>
			<script src="resources/js/bootstrap.js" type="text/javascript"></script>
			<script src="resources/js/jquery.tinysort.js" type="text/javascript"></script>
			<script src="resources/js/jquery.quicksearch.js"
				type="text/javascript"></script>
			<script src="resources/js/jquery.multi-select.js"
				type="text/javascript"></script>
			<script src="resources/js/rainbow.js" type="text/javascript"></script>
			<script src="resources/js/application.js" type="text/javascript"></script>
			<script src="resources/js/handlebars.js" type="text/javascript"></script>
			<script src="resources/js/github-api.js" type="text/javascript"></script>
</body>
</html>