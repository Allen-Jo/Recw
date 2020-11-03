<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 입력</title>

<!-- 부트스트립 js/css 루트 -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="${path}/resources/js/bootstrap.bundle.min.js"></script>


<link href="${path}/resources/css/jumbotron.css" rel="stylesheet" />
<link href="${path}/resources/css/bootstrap.min.css" rel="stylesheet">



</head>
<%@include file="../include/header.jsp"%>
<body>

	<div class="container">
		<h2>게시판 입력</h2>
		<form action="" method="post" class="form-horizontal">
			<table class="table table-striped table-boardered">
				<tr>
					<th>번호</th>
					<td>1</td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" class="form-control" name="board_title"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="10" class="form-control" name="content"></textarea></td>
				</tr>
			</table>
			<button class="btn btn-primary" type="submit">작성완료</button>
		</form>
	</div>



	<hr>

	<%@include file="../include/footer.jsp"%>

</body>
</html>