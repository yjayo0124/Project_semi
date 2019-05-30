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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
.main {
	margin: 0 auto;
	padding: 8px 10px 0;
	width: 1080px;
	text-align: left;
	zoom: 1;
}

.title {
border-bottom: solid 1px;
width: 100%;
height: 120px;
margin-top : 30px;
}

.title_left {
float: left;
width: 80%;
height: 100%;
}

.title_right {
float: left;
width: 20%;
height: 100%;
}

.title_right_top {
	height:70%;
}
.title_right_bottom {
	text-align:right;
	height:30%;
}
.title_button {
	margin-right:10px;
	width: 80px;
	height: 30px;
}
</style>

<!-- header -->
<c:import url="/WEB-INF/views/layout/header.jsp" />
</head>
<body>

	<div class="main">
		<div class="title">
			<div class="title_left">
				<h3>대회 & 축제 제목1</h3>
				<br>
				<h4>작성일 : 2019-05-30</h4>
			</div>
			<div class="title_right">
				<div class="title_right_top"></div>
				<div class="title_right_bottom">
				<button class="title_button">수정</button> <button class="title_button">삭제</button>
				</div>
			</div>
		</div>

	<br><br>
	<div style="text-align: center">
	<h4>이벤트 상세 내용</h4>
	</div>
	<hr>
	<table class="table table-bordered">
		<tr style="border: solid 1px;">
			<td class="info">주최자</td><td>홍길동</td><td class="info">전화번호</td><td>02-999-9999</td>
		</tr>
		<tr style="border: solid 1px;">
			<td class="info">주최사이트</td><td>www.naver.com</td><td class="info">가격</td><td>10,000원</td>
		</tr>
		<tr style="border: solid 1px;">
			<td class="info">이벤트 기간</td><td colspan="3">2019.05.30 ~ 2019.06.30</td>
		</tr>
		
	
	
	
	</table>









	</div>





</body>
</html>








