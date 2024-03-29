<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	
	<link rel="stylesheet" href="/resources/css/train-main.css">
	<link rel="icon" href="/resources/fav/watersolid.png">
	<title>Surfing Trainning</title>
	
</head>
<body>
	<main>
		<c:choose>
		
			<c:when test="${empty sessionScope.loginMember}">
			
				
				<form action="/login" method="post" class="login-form">
				
				<h1> Login </h1>
				<br>
					<div>
						<p>ID</p>
						<input type="text" name ="inputId" autocomplete="off">
					</div>
					<div>
						<p>Password</p>
						<input type="password" name="inputPw">
					</div>
				
					<br>
					<button>CONNECT</button>
					<br>
					<a href="/signup" class="signup"> JOIN MEMBER</a>
				
				
				</form>
			
			
			</c:when>
			

						 <%-- 로그인을 했다면 ? 접속자의 리스트--%>
			
			<c:otherwise>
					<h1> ${sessionScope.loginMember.memberNickname} 의 연습일지</h1>
				
				<c:choose>
					<c:when test="${empty practiceList}">
						<h2>연습목록을 작성하세요</h2>
					</c:when>
					
					<c:otherwise>
						<form class="pr-form">
							<table>
								<c:forEach var="practice" items="${practiceList}">
									<tr>
										<td>${practice.practiceTitle}</td>
										<td>/ ${practice.practiceMemo} /</td>
										<td>${practice.practiceDate}</td>
										<br><br>
										<td><a href="/update?practiceNo=${practice.practiceNo}">수정</a></td>
										<td><a href="/delete?practiceNo=${practice.practiceNo}" onclick="return conrifm('정말 삭제하실?');" class="delete-btn">삭제</a></td>
									</tr>							
								</c:forEach>
							</table>
						</form>
					</c:otherwise>
					
				</c:choose>
				
				
					<div class="button-div">
						<a href="/insert" class="insert-btn">등록</a>
						
						<a href="/logout" class="logout-btn">로그아웃</a>
					</div>
					
					
			</c:otherwise>
		
		</c:choose>
	
	
	</main>
	
		<c:if test="${not empty sessionScope.message}">
		
			<script>
				alert('${message}');
			</script>
		
		
			<c:remove var ="message" scope="session" />
		
		
		</c:if>

	</body>
</html>