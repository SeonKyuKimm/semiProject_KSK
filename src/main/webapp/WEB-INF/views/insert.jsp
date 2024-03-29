<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="icon" href="/resources/fav/watersolid.png">
	<link rel="stylesheet" href="/resources/css/train-main.css">
</head>
<body>
	<main>
		<h1> 오늘은 어떤걸 ?</h1>
		<h1>─────────</h1>
	
		<form action="/insert" method="post">
			<p>연습</p>
			<input type="text" name="title" required>
		
			<p>상세내용</p>
			<textarea name="memo" style="resize : none" font-size : 15px;" cols="25" rows =" 5"></textarea>
	
			<br>
			<br>
		
			<button class="insert-btn">ADD</button>
			
			<h3>고생했어요~</h3>
		</form>
	
	
	</main>

</body>
</html>