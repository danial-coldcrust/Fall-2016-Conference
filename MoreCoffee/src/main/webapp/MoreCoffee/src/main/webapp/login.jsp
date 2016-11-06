<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
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
<link type="text/css" rel="stylesheet" href="resources/css/cover.css">

</head>

<body>
	<img src="school.jpg" width="400" height="100" />
	<div class="container">
		<form class="form-signin form-horizontal" action="login.do"
			method="post">
			<h2 class="form-signin-heading">졸&nbsp;&nbsp;&nbsp;업&nbsp;&nbsp;&nbsp;사&nbsp;&nbsp;&nbsp;정</h2>
			<h2 class="form-signin-heading">LOGIN</h2>
			<center>
				<div class="form-group">
					<label for="inputID" class="sr-only">아이디</label> <input type="text"
						class="form-control" placeholder="ID" required autofocus
						name="username"/ > <label for="inputPassword"
						class="sr-only">패스워드</label> <input type="password"
						class="form-control" placeholder="Password" required
						name="password" />
				</div>
				<div>
					<button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
				</div>

			</center>
		</form>

		<form class="form-signin form-horizontal" role="form" action="signup.do">
			<center>
				<button type="button"
					class="btn btn-lg btn-primary btn-block btn btn-success"
					data-toggle="modal" data-target="#popUpWindow">회원가입</button>
				<div class="modal fade" id="popUpWindow" tabindex="-1">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-body">
								<div class="form-group">
									<strong>회원 가입</strong>
									<div style="text-align: left">
										학과 <select class="form-control" name = "major">
											<option>학과 선택</option>
											<option>컴퓨터공학과</option>
											<option>특수교육과</option>
											<option>수학과</option>
											<option>영화애니메이션학과</option>
											<option>컴퓨터소프웨어공학과</option>
											<option>연극무용학과</option></select>
										학번 <input type="text" class="form-control" placeholder="학번"  name = "snum"/>
										이름 <input type="text" class="form-control" placeholder="이름" name = "name"/>
										비밀번호 <input type="password" class="form-control"placeholder="비밀번호" name = "password"/>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<center>
									<button class="btn btn-primary btn-block">가입</button>
								</center>
							</div>
						</div>
					</div>
				</div>
			</center>
		</form>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>

</body>
</html>