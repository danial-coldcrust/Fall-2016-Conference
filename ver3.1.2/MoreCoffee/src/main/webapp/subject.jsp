<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.List"%>
<%@ page import="com.ppp.grade.subject.persistence.SubjectVO"%>
<%@ page import="com.ppp.grade.subject.persistence.SubjectDAO"%>

<%
	List<SubjectVO> subjectList = (List) request.getAttribute("subjectList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function myfunction() {
		var first = document.getElementById("textbox1").value
		alert(first);
	}
</script>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="author" content="">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
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
<link href="css/bootstrap.min.css" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="css/result.css">
<script src="resource/js/jquery.js"></script>
<script src="resource/js/bootstrap.js"></script>
<title>���� ���</title>
</head>
<body>
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

				<a class="navbar-brand">���� ����</a>
			</div>
			<!--navbar-header close-->
			<div class="collapse navbar-collapse drop_menu" id="navbar">
				<ul class="nav navbar-nav">
					<li><a href="usergetlist.do"><span
							class="glyphicon glyphicon-heart-empty"></span>&nbsp;ȸ������</a></li>
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
		<!--container-fluid close--> </nav>
		<div class="container">
			<div class="page-header">
				<div class="col-md-12 well">
					<h1>���� ���</h1>
					<table class="table table-hover">
						<thead>
							<tr>
								<th>�����ڵ�</th>
								<th>�����</th>
								<th>����</th>
								<th>����</th>
								<th>�г�</th>
								<th>�б�</th>
								<th>�а��ڵ�</th>
							</tr>
							<%
								request.setCharacterEncoding("UTF-8");
							%>
							<%
								for (SubjectVO obj : subjectList) {
							%>
							<tr>
								<td><%=obj.get�����ڵ�()%></td>
								<td><%=obj.get�����()%></td>
								<td><%=obj.get����()%></td>
								<td><%=obj.get����()%></td>
								<td><%=obj.get�г�()%></td>
								<td><%=obj.get�б�()%></td>
								<td><%=obj.get�а��ڵ�()%></td>
							</tr>
							<%
								}
							%>
						</thead>
					</table>
				</div>
			</div>
		</div>
		<div>
			<center>
				<form class="form-inline" action="subjectcreate.do" method="post">
					<div class="form-group">
						<table class="table table-hover">
							<thead>
								<tr>
									<th></th>
									<th>�����ڵ�</th>
									<th>�����</th>
									<th>����</th>
									<th>����</th>
									<th>�б�</th>
									<th>�а��ڵ�</th>
									<th>�Ϸ�</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>�߰�</td>
									<td><input type="text" class="form-control" name="c�����ڵ�" /></td>
									<td><input type="text" class="form-control" name="c�����" /></td>
									<td><input type="text" class="form-control" name="c����" /></td>
									<td><input type="text" class="form-control" name="c����" /></td>
									<td><input type="text" class="form-control" name="c�б�" /></td>
									<td><input type="text" class="form-control" name="c�а��ڵ�" /></td>
									<td><input id="loginbutton" type="submit" value="�߰�" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</form>
				<form class="form-inline" action="subjectread.do" method="post">
					<div class="form-group">
						<table class="table table-hover">
							<tr>
								<td>�˻�</td>
								<td><input type="text" class="form-control" name="r�����ڵ�" /></td>
								<td><input type="text" id="disabledTextInput"
									class="form-control" placeholder="x" readonly /></td>
								<td><input type="text" id="disabledTextInput"
									class="form-control" placeholder="x" readonly /></td>
								<td><input type="text" id="disabledTextInput"
									class="form-control" placeholder="x" readonly /></td>
								<td><input type="text" id="disabledTextInput"
									class="form-control" placeholder="x" readonly /></td>
								<td><input type="text" id="disabledTextInput"
									class="form-control" placeholder="x" readonly /></td>
								<td><input id="loginbutton" type="submit" value="�˻�" /></td>
							</tr>
						</table>
					</div>
				</form>
				<form class="form-inline" action="subjectupdate.do" method="post">
					<div class="form-group">
						<table class="table table-hover">

							<tbody>
								<tr>
									<td>����</td>
									<td><input type="text" class="form-control" name="u�����ڵ�" /></td>
									<td><input type="text" class="form-control" name="u�����" /></td>
									<td><input type="text" class="form-control" name="u����" /></td>
									<td><input type="text" class="form-control" name="u����" /></td>
									<td><input type="text" class="form-control" name="u�б�" /></td>
									<td><input type="text" class="form-control" name="u�а��ڵ�" /></td>
									<td><input id="loginbutton" type="submit" value="����" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</form>
				<form class="form-inline" action="subjectdelete.do" method="post">
					<div class="form-group">
						<table class="table table-hover">
							<tr>
								<td>����</td>
								<td><input type="text" class="form-control" name="d�����ڵ�" /></td>
								<td><input type="text" id="disabledTextInput"
									class="form-control" placeholder="x" readonly /></td>
								<td><input type="text" id="disabledTextInput"
									class="form-control" placeholder="x" readonly /></td>
								<td><input type="text" id="disabledTextInput"
									class="form-control" placeholder="x" readonly /></td>
								<td><input type="text" id="disabledTextInput"
									class="form-control" placeholder="x" readonly /></td>
								<td><input type="text" id="disabledTextInput"
									class="form-control" placeholder="x" readonly /></td>
								<td><input id="loginbutton" type="submit" value="����" /></td>
							</tr>
						</table>
					</div>
				</form>
			</center>
		</div>
	</div>
</body>
</html>