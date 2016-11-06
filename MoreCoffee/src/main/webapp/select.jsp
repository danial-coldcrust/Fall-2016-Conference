<%@ page import="java.util.List"%>
<%@ page import="com.ppp.grade.subject.persistence.SubjectDAO"%>
<%@ page import="com.ppp.grade.subject.persistence.SubjectVO"%>
<%@ page import="com.ppp.grade.select.persistence.SelectVO"%>
<%@ page import="com.ppp.grade.history.persistence.HistoryDAO"%>
<%@ page import="com.ppp.grade.history.persistence.HistoryVO"%>
<%@ page import="com.ppp.grade.user.controller.LoginController"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
   String done = (String) request.getAttribute("done"); //수강이력

   List<SubjectVO> 전체학초 = null;
   List<SubjectVO> 전체전공 = null;
   List<SubjectVO> 전체일교 = null;
   List<SubjectVO> 전체필교 = null;
   List<SubjectVO> 전체복전 = null;
   List<SubjectVO> 선택과목 = null;
   List<SubjectVO> 선택되지못한과목 = null;

   List<SelectVO> MysubjectList = null;
   List<SubjectVO> subjectList = null; //전공
   List<SubjectVO> subjectList2 = null;//교양
   List<SubjectVO> subjectList3 = null;//필수교양
   if (done.equals("result")) {  
      전체학초 = (List) request.getAttribute("전체학초");
      전체전공 = (List) request.getAttribute("전체전공");
      전체일교 = (List) request.getAttribute("전체일교");
      전체필교 = (List) request.getAttribute("전체필교");
      전체복전 = (List) request.getAttribute("전체복전");
      선택과목 = (List) request.getAttribute("mysubjectList");
      for (int i = 0; i < 선택과목.size(); i++) {
         if (선택과목.get(i).get구분().equals("학과기초")) {
            System.out.println("select.jsp  " + 선택과목.get(i).get과목코드());
         }
      }
      선택되지못한과목 = (List) request.getAttribute("unselectedList");
   } else { // login에서 오는 정보
      MysubjectList = (List) request.getAttribute("mysubjectList"); //수강이력
      subjectList = (List) request.getAttribute("subjectList"); //전공
      subjectList2 = (List) request.getAttribute("subjectList2");//교양
      subjectList3 = (List) request.getAttribute("subjectList3");//필수교양
   }
   String studentNum = (String) request.getAttribute("num");
   SubjectDAO subjectDAO = new SubjectDAO();
   SubjectVO subjectVO = new SubjectVO();
       %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="include.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<script src="js/register.js"></script>
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
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false" aria-controls="navbar">
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
									<li><a href="#anch1">학과기초</a></li>
									<li><a href="#anch2">전공</a></li>
									<li><a href="#anch3">일반교양</a></li>
									<li><a href="#anch4">필수전공</a></li>
									<li><a href="#anch5">복수전공</a></li>
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
							<li><a href="login.jsp"><span
									class="glyphicon glyphicon-log-out"></span>&nbsp;LogOut</a></li>
						</ul>
						<!--navbar-right close-->
					</div>
					<!--collapse navbar-collapse drop_menu close-->
				</div>
				<!--container-fluid close-->
			</nav>
			<div id="page-content-wrapper">
				<%
                     String actionStr = null;
                     if (done.equals("login")) {
                        actionStr = "result.do";
                     } else {
                        actionStr = "resultmodi.do";
                     }
                  %>
				<form method="post" action=<%=actionStr%>>
					<!---------------------------------------------------------------------------------------------------------------------------->
					<div class="page-content inset" data-spy="scroll"
						data-target="#spy">
						<div class="row">
							<div class="text-center">
								<h3>수강했던 과목을 선택해주세요</h3>
							</div>
						</div>
					</div>
					<!--1-1학과기초---------------------------------------------------------------------------------------------------------------------->
					<div class="container">
						<div class="col-md-12 well">
							<%
                        if (actionStr.equals("result.do")) {
                     %>
							<legend id="anch1">학&nbsp;&nbsp;과&nbsp;&nbsp;기&nbsp;&nbsp;초</legend>
							<div>
								<div class>
									<select multiple class="searchable" name="subject[]">
										<!--학과기초 -- : 초기회원>-->
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

							<legend id="anch2">전&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;공</legend>
							<div>
								<div class>
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
								</div>
							</div>
							 <legend id="anch3">일&nbsp;&nbsp;반&nbsp;&nbsp;교&nbsp;&nbsp;&nbsp;양</legend>
		                     <div class='row'>
		                        <div class='span12'>
		                           <select multiple class="searchable" name="subject[]">
		                              <!--일반교양 -- : 초기회원>-->
		                              <%
		                                 for (SubjectVO obj : subjectList2) {
		                                       if (obj.get구분().equals("일반교양")) {
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
		                     <legend id="anch4">필&nbsp;&nbsp;수&nbsp;&nbsp;교&nbsp;&nbsp;&nbsp;양</legend>
		                     <div class='row'>
		                        <div class='span12'>
		                           <select multiple class="searchable" name="subject[]">
		                              <!--일반교양 -- : 초기회원>-->
		                              <%
		                                 for (SubjectVO obj : subjectList2) {
		                                       if (obj.get구분().equals("필수교양")) {
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
  							<legend id="anch5">복수전공</legend>
							<div>
								<div class>
									<select multiple class="searchable" name="subject[]"">
										<%
                                 if (subjectList3 != null) {
                                       for (SubjectVO obj : subjectList3) {
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
							<%
                        } /* if문 끝 */
                        /* 기존회원 */
                        else {
                     %>

							<legend id="anch1">학&nbsp;&nbsp;과&nbsp;&nbsp;기&nbsp;&nbsp;초</legend>
							<div>
								<div class>

									<select multiple class="searchable" name="subject[]">

										<!--학과기초 -- : 기존 회원>-->
										<%
                                 for (SubjectVO obj : 선택되지못한과목) {
                                       if (obj.get구분().equals("학과기초") && obj.get학과코드().equals(LoginController.getStu_전공())) {
                              %>
										<option value=<%=obj.get과목코드()%>><%=obj.get과목명()%>[<%=obj.get학점()%>]&nbsp;&nbsp;<%=obj.get학년()%>학년
										</option>
										<%
                                 }
                                    }
                                    for (SubjectVO obj : 선택과목) {
                                       if (obj.get구분().equals("학과기초")) {
                              %>
										<option selected value=<%=obj.get과목코드()%>><%=obj.get과목명()%>[<%=obj.get학점()%>]&nbsp;&nbsp;<%=obj.get학년()%>학년
										</option>
										<%
                                 }
                                    }
                              %>
									</select>
								</div>
							</div>
							<legend id="anch2">전&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;공</legend>
							<div>
								<div class>

									<select multiple class="searchable" name="subject[]">

										<!--학과기초 -- : 기존 회원>-->
										<%
                                 for (SubjectVO obj : 선택되지못한과목) {
                                       if (obj.get구분().equals("전공") && obj.get학과코드().equals(LoginController.getStu_전공())) {
                              %>
										<option value=<%=obj.get과목코드()%>><%=obj.get과목명()%>[<%=obj.get학점()%>]&nbsp;&nbsp;<%=obj.get학년()%>학년
										</option>
										<%
                                 }
                                    }
                                    for (SubjectVO obj : 선택과목) {
                                       if (obj.get구분().equals("전공")&& obj.get학과코드().equals(LoginController.getStu_전공())) {
                              %>
										<option selected value=<%=obj.get과목코드()%>><%=obj.get과목명()%>[<%=obj.get학점()%>]&nbsp;&nbsp;<%=obj.get학년()%>학년
										</option>
										<%
                                 }
                                    }
                              %>
									</select>
								</div>
							</div>
							<legend id="anch3">일&nbsp;&nbsp;반&nbsp;&nbsp;교&nbsp;&nbsp;&nbsp;양</legend>
							<div>
								<div class>

									<select multiple class="searchable" name="subject[]">

										<!--학과기초 -- : 기존 회원>-->
										<%
                                 for (SubjectVO obj : 선택되지못한과목) {
                                       if (obj.get구분().equals("일반교양") && obj.get학과코드().equals("99")) {
                              %>
										<option value=<%=obj.get과목코드()%>><%=obj.get과목명()%>[<%=obj.get학점()%>]&nbsp;&nbsp;<%=obj.get학년()%>학년
										</option>
										<%
                                 }
                                    }
                                    for (SubjectVO obj : 선택과목) {
                                       if (obj.get구분().equals("일반교양") && obj.get학과코드().equals("99")) {
                              %>
										<option selected value=<%=obj.get과목코드()%>><%=obj.get과목명()%>[<%=obj.get학점()%>]&nbsp;&nbsp;<%=obj.get학년()%>학년
										</option>
										<%
                                 }
                                    }
                              %>
									</select>
								</div>
							</div>
							<legend id="anch4">필&nbsp;&nbsp;수&nbsp;&nbsp;교&nbsp;&nbsp;&nbsp;양</legend>
							<div>
								<div class>

									<select multiple class="searchable" name="subject[]">

										<!--학과기초 -- : 기존 회원>-->
										<%
                                 for (SubjectVO obj : 선택되지못한과목) {
                                       if (obj.get구분().equals("필수교양") && obj.get학과코드().equals("99")) {
                              %>
										<option value=<%=obj.get과목코드()%>><%=obj.get과목명()%>[<%=obj.get학점()%>]&nbsp;&nbsp;<%=obj.get학년()%>학년
										</option>
										<%
                                 }
                                    }
                                    for (SubjectVO obj : 선택과목) {
                                       if (obj.get구분().equals("필수교양") && obj.get학과코드().equals("99")) {
                              %>
										<option selected value=<%=obj.get과목코드()%>><%=obj.get과목명()%>[<%=obj.get학점()%>]&nbsp;&nbsp;<%=obj.get학년()%>학년
										</option>
										<%
                                 }
                                    }
                              %>
									</select>
								</div>
							</div>
							<legend id="anch5">복&nbsp;&nbsp;수&nbsp;&nbsp;전&nbsp;&nbsp;&nbsp;공</legend>
							<div>
								<div class>
									<select multiple class="searchable" name="subject[]">

										<!--학과기초 -- : 기존 회원>-->
										<%
                                 for (SubjectVO obj : 선택되지못한과목) {
                                       if (obj.get구분().equals("전공") && obj.get학과코드().equals(LoginController.getStu_복수전공())&& !obj.get학과코드().equals(LoginController.getStu_전공())) {
                              %>
										<option value=<%=obj.get과목코드()%>><%=obj.get과목명()%>[<%=obj.get학점()%>]&nbsp;&nbsp;<%=obj.get학년()%>학년
										</option>
										<%
                                 }
                                    }
                                    for (SubjectVO obj : 선택과목) {
                                       if (obj.get구분().equals("전공") && obj.get학과코드().equals(LoginController.getStu_복수전공())&& !obj.get학과코드().equals(LoginController.getStu_전공())) {
                              %>
										<option selected value=<%=obj.get과목코드()%>><%=obj.get과목명()%>[<%=obj.get학점()%>]&nbsp;&nbsp;<%=obj.get학년()%>학년
										</option>
										<%
                                 }
                                    }
                              %>
									</select>
								</div>
							</div>

							<%
                        } // eles 닫히는 괄호
                     %>



						</div>
					</div>
					<center>
						<%-- <% selected가 널 이 아니면 전송하고 비워주고 %>  --%>
						<button class="btn btn-danger btn-block" type="submit"
							name="submit" onclick=<%="historyDAO.deleteHistory(studentNum)"%>
							value="결과보기" style="max-width: 300px">결과보기</button>
						<%--    <% 값(selecte가)이 널이면 값채워달라고 alert띄워서 입력해달라고 하면 될 듯 %> --%>
					</center>
				</form>
				<form method="post" action="user_repair.do">
					<!--승탁이추가 여기부터  -->
					<center>
						<button class="btn btn-info btn-block" type="submit"
							name="repair_sumbit" value="회원정보수정" style="max-width: 300px">회원정보수정</button>
					</center>
					<!--여기까지  -->
				</form>
			</div>
		</div>
	</div>

	<!-- </div> 놀라운사실 : form이 from으로 되어있어서 안됐던거임-->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/main.js"></script>
	<script src="resources/js/jquery.js" type="text/javascript"></script>
	<script src="resources/js/bootstrap.js" type="text/javascript"></script>
	<script src="resources/js/jquery.tinysort.js" type="text/javascript"></script>
	<script src="resources/js/jquery.quicksearch.js" type="text/javascript"></script>
	<script src="resources/js/jquery.multi-select.js"
		type="text/javascript"></script>
	<script src="resources/js/rainbow.js" type="text/javascript"></script>
	<script src="resources/js/application.js" type="text/javascript"></script>
	<script src="resources/js/handlebars.js" type="text/javascript"></script>
	<script src="resources/js/github-api.js" type="text/javascript"></script>
</body>
</html>