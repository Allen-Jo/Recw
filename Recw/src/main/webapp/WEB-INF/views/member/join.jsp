<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부동산 커뮤니티</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<!-- 부가적인 테마 -->
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- 파일로 변환 -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

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
<script type="text/javascript">
	var Eresult = 0; //이메일 중복 확인 1:정상
	var Nresult = 0; //닉네임 중복 확인 1:정상
	var Presult = 0; //패스워드 일치 확인 1:정상
	
	$(document).ready(function() {
		//닉네임 중복 확인
		$('#nickname').keyup(function() {
			var nick = $(this).val();
			// ajax 실행
			$.ajax({
				type : 'POST',
				url : 'checkNick',
				data : {
					nickname : nick
				},
				success : function(result) {
					if (result == '0') {
						$("#nick_check").html("사용 가능한 닉네임 입니다.");
						Nresult = 1; //정상체크
						reg_check();
					} else if (nick == "") {
						$('#nick_check').text('닉네임을 입력해주세요 :)');
						$('#nick_check').css('color', 'red');
						$("#reg_submit").attr("disabled", true); //닉네임 중복 또는 입력안할 시 회원가입 버튼 비활성화
						Nresult = 0;

					} else {
						$("#nick_check").html("사용 불가능한 아이디 입니다.");
						$('#nick_check').css('color', 'red');
						$("#reg_submit").attr("disabled", true);
						Nresult = 0;
					}
				}
			}); // end ajax

		}); // end keyup
		
		//이메일 중복 확인
		$('#email').keyup(function() {
			var email = $(this).val();
			// ajax 실행
			$.ajax({
				type : 'POST',
				url : 'checkEmail',
				data : {
					email : email
				},
				success : function(result) {
					if (result == '0') {
						$("#eamil_check").html("사용 가능한 이메일 입니다.");
						Eresult = 1;
						reg_check();
					} else if (email == "") {
						$('#eamil_check').text('닉네임을 입력해주세요 :)');
						$('#eamil_check').css('color', 'red');
						$("#reg_submit").attr("disabled", true);
						Eresult = 0;
					} else {
						$("#eamil_check").html("사용 불가능한 이메일 입니다.");
						$('#eamil_check').css('color', 'red');
						$("#reg_submit").attr("disabled", true);
						Eresult = 0;
					}
				}
			}); // end ajax
		}); // end keyup
		
		//비밀번호 일치 확인
		$('#password2').keyup(function() {
			if ($('#password1').val() != $('#password2').val()) {
				if ($('#password2').val() != '') {
					$("#pwd_check").html("비밀번호가 일치 하지 않습니다.");
					$('#pwd_check').css('color', 'red');
					$("#reg_submit").attr("disabled", true);
					$('#password2').focus();
				}
			} else if ($('#password1').val() == $('#password2').val()) {
				$("#pwd_check").html("비밀번호가 일치합니다");
				$('#pwd_check').css('color', 'blue');
				Presult = 1;
				reg_check();
			}
		})
	});

	//정상 입력 확인
	function reg_check() {
		if (Eresult == 1 && Nresult == 1 && Presult == 1) {
			$("#reg_submit").attr("disabled", false);
		}
	};
</script>
</head>
<body>
	<div>
		<div>
			<article class="card-body mx-auto" style="max-width: 400px;">
				<h4 class="card-title mt-3 text-center">부동산 커뮤니티</h4>
				<p class="text-center">가입을 환영합니다.</p>
				<hr>
				<!-- 소셜 로그인 버튼 -->
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

				<!-- 회원가입 폼 -->
				<form action="joinProc" method="post">
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-user"></i>
								<!-- 아이콘 -->
							</span>
						</div>
						<input id="nickname" name="nickname" class="form-control" placeholder="닉네임" type="text" required="required"><br>
					</div>
					<div class="check_font" id="nick_check"></div>

					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-envelope"></i>
								<!-- 아이콘 -->
							</span>
						</div>
						<input id="email" name="email" class="form-control" placeholder="이메일" type="email" required="required">
						<div class="check_font" id="email_check"></div>
					</div>
					<div class="check_font" id="eamil_check"></div>

					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-lock"></i>
								<!-- 아이콘 -->
							</span>
						</div>
						<input id="password1" name="password" class="form-control" placeholder="비밀번호" type="password" required="required">
					</div>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-lock"></i>
								<!-- 아이콘 -->
							</span>
						</div>
						<input id="password2" class="form-control" placeholder="비밀번호 확인" type="password" required="required">
					</div>
					<div class="check_font" id="pwd_check"></div>
					<div class="form-group">
						<button id=reg_submit type="submit" class="btn btn-primary btn-block" disabled="disabled">회원 가입</button>
					</div>
					<hr>
					<div class="form-group">
						<button id="main" type="button" class="btn btn-primary btn-block" onclick="javascript:location.href='/app/';">메인으로</button>
					</div>

				</form>
			</article>
		</div>
		<!-- card.// -->

	</div>
	<!--container end.//-->
</body>
</html>
