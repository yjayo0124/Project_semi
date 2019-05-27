<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
 src="http://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


</head>
<body>

<div id="bar">
<div id="bar_logo">
<a href="/main" class="h2">낚시모아</a>
	<h4 class="text-light">
		<c:if test="${empty login }">
			<a href="/member/join">회원가입</a>
			<a href="/member/login">로그인</a>
		</c:if>
		<c:if test="${login }">
			<a href="/member/mypage">마이페이지</a>
			<a href="/member/logout">로그아웃</a>
		</c:if>
	</h4>
</div>
</div>

</body>
</html>