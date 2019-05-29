<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- jQuery 2.2.4 -->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.2.4.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	$("#btnWrite").click(function() {
		$(location).attr("href", "/board/festival/write");
	});
});
</script>

<style type="text/css">
.main {
	margin: 0 auto;
    padding: 8px 10px 0;
    width: 1080px;
    text-align: left;
    zoom: 1;
}
#title {
	text-align: center;
	padding-top: 10px;
	padding-bottom: 10px;
}

.tab_span {
	width: 100%;
    height: 4%;
    background-color: #7192d0;
}
.event_tap {
	text-align: center;
}
.event_tap ul {
padding-inline-start: 0px;
}

.event_tap ul li {
	display: inline-block;
	border: 1px solid #999;
	text-align: center;
	padding: 0px;
	margin-left: 3px;
	width: 500px;
	height: 50px;
	line-height: 40px;
	font-size: 15pt;
}

.event {
	text-align: center;
	width: 950px;
	height: 300px;
	margin: 0 auto;
}

.event_img {
	float: left;
	width: 400px;
	height: 300px;
	border: solid 1px;
	border-color: rgba(33, 33, 33, 0.25);
	overflow: hidden;
}

.event_content {
	float: left;
	width: 550px;
	height: 300px;
	background-color: #E0E0E0;
}
.event_title {
	height:100px;
	line-height: 100px;
	font-size: 20pt;
}
.event_text {
	height:150px;
	padding-top:10px;
	padding-left:30px;
	padding-right:30px;
	padding-bottom:10px;
}
.event_bottom {
	height:50px;
	line-height: 50px;
}
.event_date{
	float:left;
	width: 85%;
	height: 50px;
	line-height: 50px;
	font-size: 15pt;
}
.event_detail {
	float:left;
	width: 15%;
	height: 50px;
	line-height: 50px;
	background-color: #757575;
}
</style>
</head>
<body>

	<!-- header -->
	<c:import url="/WEB-INF/views/layout/header.jsp" />
	<div class="main">
		<div id="title">
			<h3>대회 & 축제</h3>
		</div>
		<br> <br> <br>
		<div class="event_tap">
			<ul>
				<li style="border-bottom: none;">
				<div class="tab_span"></div>
				<a href="">진행중인 이벤트</a>
				</li>
				<li style="background-color: #E0E0E0;">종료된 이벤트</li>
			</ul>
		</div>
		<br><br><br><br>

		<div class="event">
			<div class="event_img">
			<img src="/imgs/fishing.jpg" alt="이미지"></img>
			</div>

			<div class="event_content">
				<div class="event_title">
					<span>낚시모아 이벤트 제목</span>
				</div>
				<div class="event_text">
					<span>없으면 공자는 풍부하게 맺어, 용감하고 인간의 찾아다녀도, 찬미를 얼음에 위하여서. 불어 튼튼하며, 것이 피고 두손을 피는 웅대한 그들은 꽃 때문이다. 모래뿐일 싶이 끓는 이성은 피어나는 부패뿐이다. 커다란 일월과 싶이 간에 반짝이는 투명하되 발휘하기 하여도 피다.</span>
				</div>
				<div class="event_bottom">
					<div class="event_date">2019.01.01 ~ 2020.01.01</div>
					<div class="event_detail"><a href="/board/festival/detail" style="color: white;">상세보기</a></div>
					<div></div>
				</div>
			</div>
		</div>
		<br><br>
		<div style="padding-right:50px;">
		<button style="float: right;" id="btnWrite">글쓰기</button>
		</div>
	</div>
	
<c:import url="/WEB-INF/views/layout/festival/festival_paging.jsp" />
</body>
</html>