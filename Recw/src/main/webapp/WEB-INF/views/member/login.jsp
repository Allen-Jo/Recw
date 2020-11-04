<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부동산 커뮤니티</title>
<!-- Bootstrap core CSS -->
<link href="${path}/resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${path}/resources/css/floating-labels.css" rel="stylesheet">

<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<style>
.btn-social-login {
	transition: all .2s;
	outline: 0;
	border: 1px solid transparent;
	padding: .5rem !important;
	border-radius: 50%;
	color: #fff;
}

.btn-social-login:focus {
	box-shadow: 0 0 0 .2rem rgba(0, 123, 255, .25);
}

.text-dark {
	color: #343a40 !important;
}
</style>
<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>

</head>
<body>
	<div class="form-signin">
		<div class="text-center mb-4">
			<h1 class="h3 mb-3 font-weight-normal">부동산 커뮤니티</h1>
		</div>
		<hr>
		<p align="center">
			<button class='btn-social-login' style='background: #D93025'>
				<i class="xi-2x xi-google"></i>
			</button>
			<button class='btn-social-login' style='background: #1FC700'>
				<i class="xi-2x xi-naver"></i>
			</button>
			<button class='btn-social-login' style='background: #FFEB00'>
				<i class="xi-2x xi-kakaotalk text-dark"></i>
			</button>
			<button class='btn-social-login' style='background: #4267B2'>
				<i class="xi-2x xi-facebook"></i>
			</button>
			<button class='btn-social-login' style='background: #55ACEE'>
				<i class="xi-2x xi-twitter"></i>
			</button>
		</p>
		<hr>

		<form action="loginProc" method="post">
			<div class="form-label-group">
				<input type="email" id="mem_email" name="mem_email" class="form-control" placeholder="이메일" autofocus> <label for="inputEmail">이메일</label>
			</div>

			<div class="form-label-group">
				<input type="password" id="mem_password" name="mem_password" class="form-control" placeholder="비밀번호"> <label for="inputPassword">비밀번호</label>
			</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit" id="login">로 그 인</button>
		<button class="btn btn-lg btn-primary btn-block" type="button" onclick="javascript:location.href='joinView';">회원 가입</button>
		</form>
	</div>
</body>
</html>