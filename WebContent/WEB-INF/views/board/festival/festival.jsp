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

<script type="text/javascript">
$(document).ready(function() {
	$("#btnWrite").click(function() {
		$(location).attr("href", "/board/festival/write");
	});
});
</script>

<style type="text/css">
a:link { text-decoration:none; color:black;}
a:visited { text-decoration:none;color:black;}
a:active {text-decoration:none; color:black; }
a:hover { text-decoration:none; color:black;}

.main {
	margin: 0 auto;
    padding: 8px 10px 0;
    width: 1170px;
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
	width: 1170px;
	height: 378px;
	margin: 0 auto;
}

.event_img {
	float:left;
	width: 298px;
	height: 378px;
	border: none;
	border-color: rgba(33, 33, 33, 0.25);
	overflow: hidden;
}

.event_content {
	width: 872px;
	height: 378px;
    padding: 60px;
    float: left;
    overflow: hidden;
    box-sizing: border-box;
    border-top: 1px solid #e1e1e1;
    border-bottom: 1px solid #e1e1e1;
    border-right: 1px solid #e1e1e1;
}


.div_img {
	width:100%;
	height: 100%
}
#btnWrite {
width: 100px;
height: 40px;
background: #474e60;
font-size: 13px;
color: #fff;
border: solid 2px;
border-radius: 1px;
}

.title {

}
</style>
</head>
<body>
	<div class="main">
		<div id="title">
			<h3>대회 & 축제</h3>
		</div>
		<br> <br> <br>
		<div class="event_tap">
			<ul>
				<li style="border-bottom: none;">
				<div class="tab_span"></div>
				<a href="/board/festival/ongoing">진행중인 이벤트</a>
				</li>
				<li style="background-color: #E0E0E0;"><a href="/board/festival/closed">종료된 이벤트</a></li>
			</ul>
		</div>
		<br><br><br><br>

<c:forEach items="${list}" var="i">
		<div class="event">
			<div class="event_img">
			<img src="/upload/${i.festival_storedname }" alt="/imgs/fishing.jpg" class="div_img"></img>
			</div>

			<div class="event_content">
					<c:choose>
						<c:when test="${fn:length(i.festival_title) > 15}">
							<span>${fn:substring(i.festival_title,0,14)}....</span>
						</c:when>
						<c:otherwise>
							<span>${i.festival_title }</span>
						</c:otherwise>
					</c:choose>
				 <c:choose>
				 	 <c:when test="${fn:length(i.festival_content) > 200}">
				 	 	<span>${fn:substring(i.festival_content,0,199)}....</span>
					</c:when>
					<c:otherwise>
						<span>${i.festival_content }</span>
					</c:otherwise>
				</c:choose>
					<div class="event_date">${i.festival_start } ~ ${i.festival_end }</div>
					<a href="/board/festival/detail?festival_board_no=${i.festival_board_no }"><strong>상세보기</strong></a>
			</div>
		</div>
		<br>
</c:forEach>
		<br><br>
		<c:if test="${member_group == 1 }">
		<div style="padding-right:50px;">
		<button style="float: right;" id="btnWrite">글쓰기</button>
		</div>
		</c:if>
	</div>
<c:import url="/WEB-INF/views/layout/festival/festival_paging.jsp" />
</body>
</html>