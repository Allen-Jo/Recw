<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
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


<link href="${path}/resources/css/jumbotron.css" rel="stylesheet" />
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

@media ( max-width : 768px) {
	.col-md-2 {
		display: none;
	}
}
</style>


</head>


<%@include file="include/header.jsp"%>
<body>


	<div class="row mb-3">
		<div class="col-md-10 themed-grid-col">
			<div class="jumbotron">
				<div class="container">
					<h1 class="display-3">API 뿌릴 곳</h1>
					<p>This is a template for a simple marketing or informational
						website. It includes a large callout called a jumbotron and three
						supporting pieces of content. Use it as a starting point to create
						something more unique.</p>
					<p>
						<a class="btn btn-primary btn-lg" href="#" role="button">Learn
							more &raquo;</a> <a class="btn btn-primary btn-sm" href="board/boardList"
							role="button">임시 게시판 리스트 버튼 &raquo;</a> <a
							class="btn btn-primary btn-sm" href="board/boardWrite" role="button">임시
							게시판 입력 버튼 &raquo;</a>
					</p>
				</div>
			</div>
		</div>
		<div class="col-md-2 themed-grid-col">
			<h3>로그인</h3>
			<p>
				<a class="btn btn-primary btn-sm" href="member/login" role="button">임시
					로그인 버튼 &raquo;</a> <a class="btn btn-primary btn-sm" href="member/join"
					role="button">임시 회원가입 버튼 &raquo;</a>
			</p>
		</div>
	</div>
	<div class="row">
        <div class="col-md-4 themed-grid-col">
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
        <div class="col-md-4 themed-grid-col">
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
        <div class="col-md-4 themed-grid-col">
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


	<%@include file="include/footer.jsp"%>

</body>
</html>