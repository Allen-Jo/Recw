<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>

<!-- 부트스트립 js/css 루트 -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="${path}/resources/js/bootstrap.bundle.min.js"></script>


<link href="${path}/resources/css/jumbotron.css" rel="stylesheet" />
<link href="${path}/resources/css/bootstrap.min.css" rel="stylesheet">

</head>
<%@include file="../include/header.jsp"%>
<body>
	<div class="container">
		<h2>게시판 리스트</h2>

		<table class="table table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>닉네임</th>
					<th>게시물카테고리</th>
					<th>내용</th>
					<th>날짜</th>
					<th>조회</th>
					<th>좋아요</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${getBoardList}" var="boardVO">
					<tr>
						<td>${boardVO.board_num}</td>
						<td>${boardVO.board_title}</td>
						<td>${boardVO.nickname}</td>
						<td>${boardVO.board_category}</td>
						<td>${boardVO.board_content}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
								value="${boardVO.board_date}" /></td>
						<td>${boardVO.board_count}</td>
						<td>${boardVO.board_like}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<hr />
		<a class="btn btn-primary" href="boardWrite">글쓰기</a>
	</div>
	<hr />

	<%@include file="../include/footer.jsp"%>
</body>
</html>