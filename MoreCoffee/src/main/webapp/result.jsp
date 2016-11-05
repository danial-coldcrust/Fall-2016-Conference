<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.ppp.grade.subject.persistence.SubjectDAO"%>
<%@ page import="com.ppp.grade.subject.persistence.SubjectVO"%>
<%@ page import="com.ppp.grade.select.persistence.SelectDAO"%>
<%@ page import="com.ppp.grade.select.persistence.SelectVO"%>
<%@ page import="com.ppp.grade.graduation.persistence.GraduationDAO"%>
<%@ page import="com.ppp.grade.graduation.persistence.GraduationVO"%>
<%@ page import="com.ppp.grade.user.controller.LoginController"%>
<%@ page
	import="com.ppp.grade.minortable.persistence.MinortableDAO,
com.ppp.grade.minortable.persistence.MinortableVO"%>
<%
	//얼마나 남았는지 알려주기 위한 계산값.....
	String Majorresult = (String) request.getAttribute("Majorresult");
	String Generalresult1 = (String) request.getAttribute("Generalresult1");
	String Generalresult2 = (String) request.getAttribute("Generalresult2");
	String Minorresult = (String) request.getAttribute("Minorresult");
	String Majorbaseresult = (String) request.getAttribute("Majorbaseresult");
	//현재 들은 학점을 계산하기위한값.....
	String MajorSum = (String) request.getAttribute("MajorSum");
	String MinorSum = (String) request.getAttribute("MinorSum");
	String GeneralSum1 = (String) request.getAttribute("GeneralSum1");
	String GeneralSum2 = (String) request.getAttribute("GeneralSum2");
	String MajorbaseSum = (String) request.getAttribute("MajorbaseSum");

	String MajorNum = LoginController.getStu_전공();
	String MinorNum = LoginController.getStu_복수전공();
	GraduationDAO graduationDAO = new GraduationDAO();
	GraduationVO graduation = new GraduationVO();
	MinortableDAO minortableDAO = new MinortableDAO();
	MinortableVO minortable = new MinortableVO();
	graduation = graduationDAO.getGraduationWithMajorNum(MajorNum);
	minortable = minortableDAO.getMinortableWithMinorNum(MinorNum);

	List<SubjectVO> MatchingSelectList = (List) request.getAttribute("MatchingSelectList");//수강이력
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<jsp:include page="include.jsp" />
<script type="text/javascript">
	function print(printArea) {
		win = window.open();
		self.focus();
		win.document.open();

		/*
			1. div 안의 모든 태그들을 innerHTML을 사용하여 매개변수로 받는다.
			2. window.open() 을 사용하여 새 팝업창을 띄운다.
			3. 열린 새 팝업창에 기본 <html><head><body>를 추가한다.
			4. <body> 안에 매개변수로 받은 printArea를 추가한다.
			5. window.print() 로 인쇄
			6. 인쇄 확인이 되면 팝업창은 자동으로 window.close()를 호출하여 닫힘
		 */
		win.document.write('<html><'head'><title></title><style>');
		win.document
				.write('body, td {font-falmily: Verdana; font-size: 10pt;}');
		win.document.write('</style></haed><body>');
		win.document.write(printArea);
		win.document.write('</body></html>');
		win.document.close();
		win.print();
		win.close();
	}
</script>
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
<!-- <script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
   integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
   crossorigin="anonymous"></script> -->

<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="resources/css/main.css">
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
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false" aria-controls="navbar">
							<span class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>

						<a class="navbar-brand">졸업할수있을까?</a>

					</div>
					<!--navbar-header close-->

					<ul class="nav navbar-nav">
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#"><span
								class="glyphicon glyphicon-pencil"></span>&nbsp;과목<span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#anch1">학과기초</a></li>
								<li><a href="#anch2">전공</a></li>
								<li><a href="#anch3">교양</a></li>
								<li><a href="#anch4">복수전공</a></li>
								<li><a href="#anch5">일반선택</a></li>
								<li class="divider"></li>
								<li><a href="#">봉사시간</a></li>
								<li><a href="#">교육</a></li>
							</ul> <!--dropdown-menu close--></li>
						<li><a href="user_repair.do" method="post" target="_self"><span
								class="glyphicon glyphicon-user" name="repair_sumbit"></span>&nbsp;회원정보수정</a></li>

						<li><a href="https://portal.sch.ac.kr/" target="_blank"><span
								class="glyphicon glyphicon-home"></span>&nbsp;포탈</a></li>
						<li><a href="#"><span
								class="glyphicon glyphicon-heart-empty"></span>&nbsp;</a></li>
					</ul>
					<!--nav navbar-nav close-->
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#"
							OnClick="print(document.getElementById('printArea').innerHTML)"><span
								class="glyphicon glyphicon-print"></span>&nbsp;Print</a></li>
						<li><a href="RsltToSltController.do"><span
								class="glyphicon glyphicon-hourglass"></span>&nbsp;Modified</a></li>
						<li><a href="login.jsp"><span
								class="glyphicon glyphicon-log-out"></span>&nbsp;LogOut</a></li>
					</ul>
					<!--navbar-right close-->
				</div>
		<!--collapse navbar-collapse drop_menu close-->
			</nav>
		</div>
		<!--container-fluid close-->

	</div>
			<fieldset>	

		<div id="page-content-wrapper">

			<div id="printArea">
				<div class="container">
					<div class="page-header">
						<div class="col-md-12 well">
							<h2>12학번 당신의 졸업요건</h2>
							<div class="table-responsive">
								<table class="table">
									<tr>
										<th class="border-top border-bottom border-left border-right"></th>
										<th class="border-top border-bottom border-right">학초</th>
										<th class="border-top border-bottom border-right">전공</th>
										<!-- 나중에 복수전공이 있으면 띄워주는걸로 바꾸기 -->
										<th class="border-top border-bottom border-right">복수전공</th>
										<!-- ################################### -->
										<th class="border-top border-bottom border-right">필수교양</th>
										<th class="border-top border-bottom border-right">교양</th>
										<th class="border-top border-bottom border-right">봉사교육</th>
										<th class="border-top border-bottom border-right">심폐소생</th>
										<th class="border-top border-bottom border-right">봉사활동</th>
									</tr>
									<!-- 주전공만들을때 실핼문 -->
									<%
										if (MinorNum == null) {
									%>
									<tr>
										<td class="border-bottom border-left border-right">졸업조건</td>
										<td class="border-bottom border-right"><%=graduation.get학과기초()%></td>
										<td class="border-bottom border-right"><%=graduation.get전공심화()%></td>
										<td class="border-bottom border-right"></td>
										<td class="border-bottom border-right"><%=graduation.get필수교양()%></td>
										<td class="border-bottom border-right"><%=graduation.get일반교양()%></td>
										<td class="border-bottom border-right"><%=graduation.get봉사교육()%></td>
										<td class="border-bottom border-right"><%=graduation.get심폐교육()%></td>
										<td class="border-bottom border-right"><%=graduation.get봉사시간()%></td>
									</tr>
									<!-- 복수전공일때 실행문 -->
									<%
										} else {
									%><tr>
										<td class="border-bottom border-left border-right">졸업조건</td>
										<td class="border-bottom border-right"><%=graduation.get학과기초()%></td>
										<td class="border-bottom border-right"><%=minortable.get전공학점()%></td>
										<td class="border-bottom border-right"><%=minortable.get복수전공학점()%></td>
										<td class="border-bottom border-right"><%=graduation.get필수교양()%></td>
										<td class="border-bottom border-right"><%=graduation.get일반교양()%></td>
										<td class="border-bottom border-right"><%=graduation.get봉사교육()%></td>
										<td class="border-bottom border-right"><%=graduation.get심폐교육()%></td>
										<td class="border-bottom border-right"><%=graduation.get봉사시간()%></td>
									</tr>
									<%
										}
									%>
									<tr>
										<td class="border-bottom border-left border-right">나의현황?</td>
										<td class="border-bottom border-right"><%=MajorbaseSum%></td>
										<td class="border-bottom border-right"><%=MajorSum%></td>
										<td class="border-bottom border-right"><%=MinorSum%></td>
										<td class="border-bottom border-right"><%=GeneralSum2%></td>
										<td class="border-bottom border-right"><%=GeneralSum1%></td>
										<td class="border-bottom border-right">Pass</td>
										<td class="border-bottom border-right">Fail</td>
										<td class="border-bottom border-right">30</td>
									</tr>
									<tr>
										<td class="border-bottom border-left border-right">남은학점!</td>
										<td class="border-bottom border-right"><%=Majorbaseresult%></td>
										<td class="border-bottom border-right"><%=Majorresult%></td>
										<td class="border-bottom border-right"><%=Minorresult%></td>
										<td class="border-bottom border-right"><%=Generalresult2%></td>
										<td class="border-bottom border-right"><%=Generalresult1%></td>
										<td class="border-bottom border-right">ㅋ</td>
										<td class="border-bottom border-right">ㅋ</td>
										<td class="border-bottom border-right">ㅋ</td>
									</tr>
								</table>
							</div>
							<h3>결과</h3>
						</div>
						<div class="col-md-12 well">
							<legend id="anch1">학&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;초</legend>
							<%
								for (SubjectVO obj : MatchingSelectList) {
									if (obj.get구분().equals("학과기초")) {
							%>
							<p><%=obj.get과목명()%></p>
							<%
								}
								}
							%>
						</div>
						<div class="col-md-12 well">
							<legend id="anch2">전&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;공</legend>
							<%
								for (SubjectVO obj : MatchingSelectList) {
									if (obj.get구분().equals("전공") && obj.get학과코드().equals(MajorNum)) {
							%>
							<p><%=obj.get과목명()%></p>
							<%
								}
								}
							%>
						</div>
						<%
							if (MinorNum != null) {
						%>
						<div class="col-md-12 well">
							<legend id="anch4">부전공</legend>
							<%
								for (SubjectVO obj : MatchingSelectList) {
										if (obj.get구분().equals("전공") && obj.get학과코드().equals(MinorNum)) {
							%>
							<p><%=obj.get과목명()%></p>
							<%
								}
									}
							%>
						</div>
						<%
							}
						%>
						<div class="col-md-12 well">
							<legend id="anch3">필&nbsp;수&nbsp;&nbsp;&nbsp;교&nbsp;양</legend>
							<%
								for (SubjectVO obj : MatchingSelectList) {
									if (obj.get구분().equals("필수교양")) {
							%>
							<p><%=obj.get과목명()%></p>
							<%
								}
								}
							%>
						</div>
						<div class="col-md-12 well">
							<legend id="anch3">교&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;양</legend>
							<%
								for (SubjectVO obj : MatchingSelectList) {
									if (obj.get구분().equals("일반교양")) {
							%>
							<p><%=obj.get과목명()%></p>
							<%
								}
								}
							%>
						</div>
						<div class="col-md-12 well">
							<legend id="anch5">일반선택</legend>
							<p>과목명을 뿌려줄거야과목명을 뿌려줄거야과목명을 뿌려줄거야과목명을 뿌려줄거야과목명을 뿌려줄거야과목명을
								뿌려줄거야과목명을 뿌려줄거야과목명을 뿌려줄거야과목명을 뿌려줄거야과목명을 뿌려줄거야과목명을 뿌려줄거야과목명을
								뿌려줄거야과목명을 뿌려줄거야과목명을 뿌려줄거야과목명을 뿌려줄거야과목명을 뿌려줄거야과목명을 뿌려줄거야과목명을
								뿌려줄거야과목명을 뿌려줄거야과목명을 뿌려줄거야과목명을 뿌려줄거야과목명을 뿌려줄거야</p>
						</div>
						
					</div>
				</div>
			</div>
		</div>
		</fieldset>
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="resources/js/bootstrap.min.js"></script>
		<script src="resources/js/main.js"></script>
		<script src="resources/js/jquery.js" type="text/javascript"></script>
		<script src="resources/js/bootstrap.js" type="text/javascript"></script>
		
</body>
</html>
