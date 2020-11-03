<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>nav</title>

<link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/navbar-fixed/">

<!-- nav.js -->
<%-- <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="${path}/resources/js/bootstrap.bundle.min.js"></script>
 --%>
<!-- nav.css -->
<%-- <link href="${path}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${path}/resources/css/navbar-top-fixed.css" rel="stylesheet" /> --%>


 <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
        #nav_login{
        	display:none;
        }
      }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		<a class="navbar-brand " href="/">Baskin-Robbins 31</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarsExampleDefault">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active mr-sm-3"><a class="nav-link" href="board/notice">공지사항
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item  mr-sm-3"><a class="nav-link" href="board/news">뉴스</a></li>
				<li class="nav-item mr-sm-3"><a class="nav-link" href="board/debate">토론</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="dropdown01"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">부동산</a>
					<div class="dropdown-menu" aria-labelledby="dropdown01">
						<a class="dropdown-item" href="area_search">검색</a> <a
							class="dropdown-item" href="report_relist">월간 가격동향</a> <a
							class="dropdown-item" href="freecounsel">무료상담</a>
					</div></li>
				<li class="nav-item mr-sm-3" id="nav_login"><a class="nav-link" href="member/login">로그인</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="text"	aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
			</form>
		</div>
	</nav>

</body>
</html>