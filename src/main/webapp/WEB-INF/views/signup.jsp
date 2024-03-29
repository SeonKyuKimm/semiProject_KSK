<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>SignUp</title>
	<link rel="stylesheet" href="/resources/css/train-main.css">
	<link rel="icon" href="/resources/fav/watersolid.png">
</head>
<body>
	<main>
	
	<h1>회원가입</h1>
	<h1>───────</h1>
	
		<form action="/signup" method="post" class="signup-form" onsubmit="return validate()">
		
			<p>ID</p>
			<input type="text" name="inputId" id="inputId" autocomplete="off" required><br>
			<span id="idMsg"> 영어 대 / 소문자 ,숫자 포함 6~14글자로 입력</span>
			<br>
			<p>비밀번호</p>
			<input type="password" name="inputPw" id="inputPw" required>
			
			<p>비밀번호 확인</p>
			<input type="password" name="inputPw2" id="inputPw2" required>
			<br>
			<span id="pwMessage"></span>
			
			<p>닉네임</p>
			<input type="text" name="inputName" id="inputName" autocomplete="off" required>
			<span id="nameMessage"></span>
		
			<br><br>
				
			<button> JOIN♬ </button>
		</form>
	</main>
	
	<script src="/resources/js/signup.js"></script>
</body>
</html>