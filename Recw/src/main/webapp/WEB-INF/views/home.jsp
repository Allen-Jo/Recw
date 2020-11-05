<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<html>
<head>
<title>Home</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.5/examples/jumbotron/">
<!-- 부트스트립 js/css 루트 -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="${path}/resources/js/bootstrap.bundle.min.js"></script>


<link href="${path}" rel="stylesheet" />
<link href="${path}/resources/css/bootstrap.min.css" rel="stylesheet">

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


<%@include file="include/nav.jsp"%>
<body>

	<main role="main">

		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<div class="container">
				<h1 class="display-3">API 뿌릴 곳</h1>
				<p>This is a template for a simple marketing or informational
					website. It includes a large callout called a jumbotron and three
					supporting pieces of content. Use it as a starting point to create
					something more unique.</p>
				<p>
					<a class="btn btn-primary btn-lg" href="#" role="button">Learn
						more &raquo;</a>
				</p>
			</div>
		</div>

		<div class="side-menu">

			<%
				if (session.getAttribute("mem_nick") == null) {
			%>
			<div class="container">
				<h3>로그인</h3>
				<p>
					<a class="btn btn-secondary" href="member/login" role="button">임시 로그인 버튼 &raquo;</a> 
					<a class="btn btn-secondary" href="member/terms" role="button">임시 회원가입 버튼 &raquo;</a> 
					<a class="btn btn-secondary" href="member/join_succ" role="button">임시 회원가입 버튼2 &raquo;</a>
				</p>
			</div>
			<%
				} else {
			%>
			<div class="container">
				<p>
					<h3>${sessionScope.mem_nick}님 환영합니다.</h3>
					<a class="btn btn-secondary" href="member/logout" role="button">로그아웃&raquo;</a>
				</p>
			</div>
			<%
				}
			%>


		</div>

		<div class="container">
			<!-- Example row of columns -->
			<div class="row">
				<div class="col-md-4">
					<h2>BEST_뉴스</h2>
					<p>Donec id elit non mi porta gravida at eget metus. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
						ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
						magna mollis euismod. Donec sed odio dui.</p>
					<p>
						<a class="btn btn-secondary" href="#" role="button">View
							details &raquo;</a>
					</p>
				</div>
				<div class="col-md-4">
					<h2>BEST_토론</h2>
					<p>Donec id elit non mi porta gravida at eget metus. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
						ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
						magna mollis euismod. Donec sed odio dui.</p>
					<p>
						<a class="btn btn-secondary" href="#" role="button">View
							details &raquo;</a>
					</p>
				</div>
				<div class="col-md-4">
					<h2>BEST_팁</h2>
					<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis
						in, egestas eget quam. Vestibulum id ligula porta felis euismod
						semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris
						condimentum nibh, ut fermentum massa justo sit amet risus.</p>
					<p>
						<a class="btn btn-secondary" href="#" role="button">View
							details &raquo;</a>
					</p>
				</div>
			</div>

			<hr>

		</div>
		<!-- /container -->
	</main>
	<%@include file="include/footer.jsp"%>

</body>
</html>
