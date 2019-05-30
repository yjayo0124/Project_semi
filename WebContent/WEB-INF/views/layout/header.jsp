<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript"
   src="http://code.jquery.com/jquery-2.2.4.js"></script>

<!-- Bootstrap 3 -->
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


<!-- 썸머 노트 -->
<!-- include libraries(jQuery, bootstrap) -->
<!-- <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet"> -->

<!-- <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> --> 

<!-- <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>  -->

<!-- include summernote css/js -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>
<!-- summer note korean language pack -->

<script src="resources/summernote/lang/summernote-ko-KR.js"></script>



<script type="text/javascript">


	$(document).on('mouseover', '.MainMenu span', function() {
		$('.SubMenu').slideDown(300);
	});
	$(document).on('mouseover', 'div', function() {
		if (!$(this).hasClass('MainMenu')) {
			$('.SubMenu').slideUp(300);
		}
	});
	

	$(document).ready(function() {
		
		$('#summernote').summernote({
			height: 300,          // 기본 높이값
		    minHeight: null,      // 최소 높이값(null은 제한 없음)
		    maxHeight: null,      // 최대 높이값(null은 제한 없음)
		    focus: true,          // 페이지가 열릴때 포커스를 지정함
		    lang: 'ko-KR'         // 한국어 지정(기본값은 en-US)
		});
		
	})

	


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
					<li id="nop"><a href="/board/notice/list">공지사항</a></li>
					<li id="nop">&nbsp;</li>
				</ul></li>
			<li><span>낚시정보</span>
				<ul class="SubMenu">
					<li id="nop"><a href="/board/search">낚시터 정보 검색</a></li>
					<li id="nop">물고기 정보</li>
					<li id="nop"><a href="/board/festival">대회 & 축제</a></li>
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