<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery 2.2.4 -->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.2.4.js"></script>

<!-- Bootstrap 3 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(document).on('mouseover', '.MainMenu span', function() {
		$('.SubMenu').slideDown(300);
	});
	$(document).on('mouseover', 'div', function() {
		if (!$(this).hasClass('MainMenu')) {
			$('.SubMenu').slideUp(300);
		}
	});
</script>

<style type="text/css">
h1 {
	text-align: center;
}

a {
	color: black;
	text-decoration: none;
}

.right {
	text-align: right;
}

li {
	list-style: none;
}

body {
	width: 100%;
	min-width: 1000px;
	margin: 0 auto;
}

.MainMenu {
	position: relative;
	z-index : 999;
	width: 100%;
	margin-bottom: 20px;
	text-align: center;
	height: 40px;
}

.MainMenu:after {
	content: "";
	display: block;
	clear: both;
}

.menu>li {
	width: 19.6%;
	line-height: 40px;	
	display:inline-block;
}

.menu span {
	font-size: 20px;
	font-weight: bold;
}

.SubMenu {
	position: absolute;
	top: 40px;
	display: none;
	width: 20%;
	padding: 20px 0;
	border-bottom: 1px solid #ccc;
	background: #fff;
}
</style>
</head>
<body>
	<br>
	<div class="right">
		<c:if test="${empty login }">
			<a href="/member/login">로그인</a>
			&nbsp;&nbsp;&nbsp;
			<a href="/member/join">회원가입</a>
			&nbsp;&nbsp;&nbsp;
		</c:if>
		<c:if test="${login }">
			<a href="/member/logout">로그아웃</a>
			&nbsp;&nbsp;&nbsp;
			<a href="/member/mypage">마이페이지</a>
			&nbsp;&nbsp;&nbsp;
		</c:if>
	</div>
	<br>
	<div>
		<h1><a href="/main" style="text-decoration: none; color: black;">낚시모아</a></h1>
		<br><br><br>
	</div>

	<hr>
	<div class="MainMenu">
		<ul class="menu" style="display:inline">
			<li><span>사이트소개</span>
				<ul class="SubMenu">
					<li id="nop"><a href="/site">낚시모아 소개</a></li>
					<li id="nop">공지사항</li>
					<li id="nop">&nbsp;</li>
				</ul></li>
			<li><span>낚시정보</span>
				<ul class="SubMenu">
					<li id="nop"><a href="/board/search">낚시터 정보 검색</a></li>
					<li id="nop">물고기 정보</li>
					<li id="nop">대회 & 축제</li>
				</ul></li>
			<li><span>낚시장터</span>
				<ul class="SubMenu">
					<li id="nop">삽니다 게시판</li>
					<li id="nop">팝니다 게시판</li>
					<li id="nop">&nbsp;</li>
				</ul></li>
			<li><span>커뮤니티</span>
				<ul class="SubMenu">
					<li id="nop"><a href="/board/free/list">자유게시판</a></li>
					<li id="nop">자랑게시판</li>
					<li id="nop">동호회 게시판</li>
				</ul></li>
		</ul>
	</div>
	<hr>
</body>
</html>