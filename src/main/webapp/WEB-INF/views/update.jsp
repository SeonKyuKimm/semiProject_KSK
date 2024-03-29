<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<title>연습일지 수정</title>
	<link rel="icon" href="/resources/fav/watersolid.png">
	<link rel="stylesheet" href="/resources/css/update.css">
</head>
<body>
	<main>잘못썼나요 ?</main>
	<h1>───────</h1>
	
	<form action="/update?practiceNo=${practice.practiceNo}" method="post">
	
		<p>연습</p>
		<input type="text" name="title" value="${practice.practiceTitle}" required>
		
	
		<p>상세내용</p>
		<textarea name="memo" style="resize:none; font-size:15px;" cols="25" rows="5">${practice.practiceMemo}</textarea>
	
			<br>
			<br>
		
		<button class="update-btn">EDIT</button>
	</form>
	
</body>
</html>