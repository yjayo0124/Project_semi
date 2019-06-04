<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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

<script type="text/javascript">
	$(document).ready(function() {

		$("#travel").click(function() {

			$("#list").load("/board/festival");

			return false;//웹페이지의 동적 수행을 멈추게하는 코드

		});
	});
</script>



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
	height: 80px;
	margin-top: 30px;
}

.title_left {
	float: left;
	width: 100%;
	height: 100%;
}

.tag {
	width: 1180px;
	height: 220px;
	padding-left: 19px;
	padding-right: 19px;
}

.tagselect {
	float: left;
	width: 150px;
	height: 100%;
	margin: 20px;
	cursor: pointer;
}

.select_img {
	width: 150px;
	height: 150px;
	text-align: center;
}

.tag_img {
	width: 150px;
	height: 100%;
}

.tag_name {
	width: 150px;
	height: 28px;
	text-align: center;
	margin: 0 auto;
	font-size: 20px;
}

.pop_list {
	width: 1180px;
	height: 600px;
	margin-top: 80px;
}
.pop_title {
	width: 100%;
	height: 60px;
	margin:0px; font-size: 25px; line-height: 15px;
}

.pop_firline{
	width: 100%;
	height: 180px;
	margin-top: 30px;
}
.pop_secline{
	width: 100%;
	height: 180px;
	margin-top: 50px;
}
.pop_content_l {
	float:left;
	width: 45%;
	height: 100%;
	margin-right: 80px;
}

.pop_content {
	float:left;
	width: 45%;
	height: 100%
}
.pop_img {
	float:left;
	width: 30%;
	height: 100%;
}
.pop_image{
	width: 100%;
	height: 100%;
}
.pop_clubcontent{
	float:left;
	width: 70%;
	height: 100%;
	padding-left: 15px;
}
.pop_clubname {
	width: 100%;
	height: 35%;
	line-height: 100px;
	font-size: 25px;
}
.pop_clubinclude{
	width: 100%;
	height: 40%;
	padding-top:10px;
	font-size: 15px;
}
.pop_clubdetail {
	width: 100%;
	height: 25%;
	line-height: 5px;
}
</style>

</head>
<body>
	<div class="main">
		<div class="title">
			<div class="title_left">
				<h2>주제별 찾기</h2>
			</div>
		</div>
		<br>
		<div class="tag">
			<div class="tagselect" id="travel">
				<div class="select_img">
					<img src="/imgs/travel.jpg" class="img-circle tag_img">
				</div>
				<div style="width: 100%; height: 10px;"></div>
				<div class="tag_name">
					<strong>여행</strong>
				</div>
			</div>
			<div class="tagselect">
				<div class="select_img">
					<img src="/imgs/reading.jpg" class="img-circle tag_img">
				</div>
				<div style="width: 100%; height: 10px;"></div>
				<div class="tag_name">
					<strong>독서</strong>
				</div>
			</div>
			<div class="tagselect">
				<div class="select_img">
					<img src="/imgs/movie.jpg" class="img-circle tag_img">
				</div>
				<div style="width: 100%; height: 10px;"></div>
				<div class="tag_name">
					<strong>영화</strong>
				</div>
			</div>
			<div class="tagselect">
				<div class="select_img">
					<img src="/imgs/music.jpg" class="img-circle tag_img">
				</div>
				<div style="width: 100%; height: 10px;"></div>
				<div class="tag_name">
					<strong>음악</strong>
				</div>
			</div>
			<div class="tagselect">
				<div class="select_img">
					<img src="/imgs/exercise.jpg" class="img-circle tag_img">
				</div>
				<div style="width: 100%; height: 10px;"></div>
				<div class="tag_name">
					<strong>운동</strong>
				</div>
			</div>
			<div class="tagselect">
				<div class="select_img">
					<img src="/imgs/game.jpg" class="img-circle tag_img">
				</div>
				<div style="width: 100%; height: 10px;"></div>
				<div class="tag_name">
					<strong>게임</strong>
				</div>
			</div>
		</div>
		<br>
		<div id="list">
			<div class="pop_list">
					<div class="pop_title"><strong>인기동호회</strong></div>
					<div class="pop_firline">
						<div class="pop_content_l">
						
							<div class="pop_img"><img src="/imgs/fishing.jpg"class="img-circle pop_image"></div>
							
							<div class="pop_clubcontent">
								<div class="pop_clubname"><strong>동호회 이름</strong></div>
								<div class="pop_clubinclude">싶이 천지는 실현에 우리 보이는 보배를 설산에서 목숨이 사막이다. 듣기만 곳으로 청춘을 그들은 있는가?</div>
								<div class="pop_clubdetail">000명 가입 중</div>
							</div>
						
						</div>
						<div class="pop_content">
							
							<div class="pop_img"><img src="/imgs/fishing.jpg"class="img-circle pop_image"></div>
							
							<div class="pop_clubcontent">
								<div class="pop_clubname"><strong>동호회 이름</strong></div>
								<div class="pop_clubinclude">싶이 천지는 실현에 우리 보이는 보배를 설산에서 목숨이 사막이다. 듣기만 곳으로 청춘을 그들은 있는가?</div>
								<div class="pop_clubdetail">000명 가입 중</div>
							</div>
							
						</div>
					</div>
					<div class="pop_secline">
						<div class="pop_content_l">
							
							<div class="pop_img"><img src="/imgs/fishing.jpg"class="img-circle pop_image"></div>
							
							<div class="pop_clubcontent">
								<div class="pop_clubname"><strong>동호회 이름</strong></div>
								<div class="pop_clubinclude">싶이 천지는 실현에 우리 보이는 보배를 설산에서 목숨이 사막이다. 듣기만 곳으로 청춘을 그들은 있는가?</div>
								<div class="pop_clubdetail">000명 가입 중</div>
							</div>
						
						</div>
						<div class="pop_content">
							
							<div class="pop_img"><img src="/imgs/fishing.jpg"class="img-circle pop_image"></div>
							
							<div class="pop_clubcontent">
								<div class="pop_clubname"><strong>동호회 이름</strong></div>
								<div class="pop_clubinclude">싶이 천지는 실현에 우리 보이는 보배를 설산에서 목숨이 사막이다. 듣기만 곳으로 청춘을 그들은 있는가?</div>
								<div class="pop_clubdetail">000명 가입 중</div>
							</div>
						
						</div>
					</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>