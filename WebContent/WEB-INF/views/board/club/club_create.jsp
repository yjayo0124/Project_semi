<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!-- header -->
	<c:import url="/WEB-INF/views/layout/header.jsp" />

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
	
<style type="text/css">

.main {
	margin: 0 auto;
	padding: 8px 10px 0;
	width: 1200px;
	text-align: left;
	zoom: 1;
}

.title {
	border-bottom: solid 1px;
	width: 100%;
	height: 120px;
	margin-top: 30px;
}
.title_left {
	float: left;
	width: 100%;
	height: 100%;
}
.img_wrap {
	width: 300px;
	margin-top: 50px;
}
.img_wrap img {
	max-width:100%;
}
</style>
</head>
<body>

	<div class="main">
		<div class="title">
			<div class="title_left">
				<h2>동호회 개설</h2>
				<div style="height: 20px;"></div>
				<h4>동호회 개설을 원하시면 아래의 정보를 입력해주세요.</h4>
			</div>
		</div>
		<br>
		<div>
			<h2><b>대표이미지 미리보기</b></h2>
			<p class="img_title">대표이미지 업로드</p>
			<input type="file" id="input_img" />
		</div>
		
		<div>
			<div class="img_wrap">
				<img id="img" />
			</div>
		</div>
		
		
		
		
		
		
		
		
		
		
		
		
		
	</div>





</body>
</html>