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
	width: 90%;
	margin: 0 auto;
}

.MainMenu {
	position: relative;
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
	float: left;
	width: 20%;
	line-height: 40px;
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
	<div>
		<h1><a href="/main" style="text-decoration: none; color: black;">낚시모아</a></h1>
		<br><br><br>
	</div>

	<div class="MainMenu">
		<ul class="menu">
			<li><span>메뉴</span>
				<ul class="SubMenu">
					<li id="nop">sub01</li>
					<li id="nop">sub02</li>
					<li id="nop">sub03</li>
					<li id="nop">sub04</li>
					<li id="nop">sub05</li>
				</ul></li>
			<li><span>Menu02</span>
				<ul class="SubMenu">
					<li id="nop">sub01</li>
					<li id="nop">sub02</li>
					<li id="nop">sub03</li>
					<li id="nop">sub04</li>
					<li id="nop">sub05</li>
				</ul></li>
			<li><span>Menu03</span>
				<ul class="SubMenu">
					<li id="nop">sub01</li>
					<li id="nop">sub02</li>
					<li id="nop">sub03</li>
					<li id="nop">sub04</li>
					<li id="nop">sub05</li>
				</ul></li>
			<li><span>Menu04</span>
				<ul class="SubMenu">
					<li id="nop">sub01</li>
					<li id="nop">sub02</li>
					<li id="nop">sub03</li>
					<li id="nop">sub04</li>
					<li id="nop">sub05</li>
				</ul></li>
			<li><span>Menu05</span>
				<ul class="SubMenu">
					<li id="nop">sub01</li>
					<li id="nop">sub02</li>
					<li id="nop">sub03</li>
					<li id="nop">sub04</li>
					<li id="nop">sub05</li>
				</ul></li>
		</ul>
	</div>

</body>
</html>