<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


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
.div_img {
	width:100%;
	height: 100%
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
				<li style="background-color: #E0E0E0;">
					<a href="/board/festival/ongoing">진행중인 이벤트</a>
				</li>
				<li style="border-bottom: none;">
					<div class="tab_span"></div>
					<a href="/board/festival/closed">종료된 이벤트</a>
				</li>
			</ul>
		</div>
		<br><br><br><br>

<c:forEach items="${closedlist}" var="i">
		<div class="event">
			<div class="event_img">
			<img src="/upload/${i.festival_storedname }" alt="/imgs/fishing.jpg" class="div_img"></img>
			</div>

			<div class="event_content">
				<div class="event_title">
					<c:choose>
						<c:when test="${fn:length(i.festival_title) > 15}">
							<span>${fn:substring(i.festival_title,0,14)}....</span>
						</c:when>
						<c:otherwise>
							<span>${i.festival_title }</span>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="event_text">
				 <c:choose>
				 	 <c:when test="${fn:length(i.festival_content) > 200}">
				 	 	<span>${fn:substring(i.festival_content,0,199)}....</span>
					</c:when>
					<c:otherwise>
						<span>${i.festival_content }</span>
					</c:otherwise>
				</c:choose>
				</div>
				<div class="event_bottom">
					<div class="event_date">${i.festival_start } ~ ${i.festival_end }</div>
					<div class="event_detail"><a href="/board/festival/detail?festival_board_no=${i.festival_board_no }" style="color: white;">상세보기</a></div>
					<div></div>
				</div>
			</div>
		</div>
		<br>
</c:forEach>
		<br><br>
		<div style="padding-right:50px;">
		<button style="float: right;" id="btnWrite">글쓰기</button>
		</div>
	</div>
<c:import url="/WEB-INF/views/layout/festival/closed_paging.jsp" />
<c:import url="/WEB-INF/views/layout/footer.jsp" />