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
		
		$("#btncreate").click(function() {
			$(location).attr("href", "/board/club/create");
		});

		$("#travel").click(function() {
			$(location).attr("href", "/board/club?club_tag=1");
		});
		
		$("#reading").click(function() {
			$(location).attr("href", "/board/club?club_tag=2");
		});
		
		$("#movie").click(function() {
			$(location).attr("href", "/board/club?club_tag=3");
		});
		
		$("#music").click(function() {
			$(location).attr("href", "/board/club?club_tag=4");
		});
		
		$("#exercise").click(function() {
			$(location).attr("href", "/board/club?club_tag=5");
		});
		
		$("#game").click(function() {
			$(location).attr("href", "/board/club?club_tag=6");
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

.lately_list {
/* 	border-left:solid 1px; */
/* 	border-color: rgba(33, 33, 33, 0.25); */
	float:left;
	width: 580px;
	height: 180px;
	margin-right:10px; 
	margin-top:20px;
	margin-bottom:50px;
	

}
.lately_img{
/* 	border-right:solid 1px; */
/* 	border-color: rgba(33, 33, 33, 0.25); */
	float:left;
	width: 180px;
	height: 180px;
}
.lately_image{
/* 	border:solid 1px; */
/* 	border-color: rgba(33, 33, 33, 0.25); */
	width: 100%;
	height: 100%;
}
.lately_content{
	float:left;
	width: 395px;
	height: 180px;
	padding-left: 15px;
	padding-right:5px;
}

.lately_title {
	width: 100%;
	height: 35%;
	line-height: 100px;
	font-size: 25px;
}
.lately_include{
	width: 100%;
	height: 40%;
	padding-top:10px;
	font-size: 15px;
}
.lately_detail {
	width: 100%;
	height: 25%;
	line-height: 5px;
}
.paging_bar {
	float:left;
	text-align:center;
	width:100%;
	margin-top:100px;
	margin-bottom:100px;
	padding-right:100px;
}
#btncreate {
	width: 100px;
	height: 40px;
	background: #474e60;
	font-size: 13px;
	color: #fff;
	border: solid 2px;
	border-radius: 1px;
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
			<div class="tagselect" id="reading">
				<div class="select_img">
					<img src="/imgs/reading.jpg" class="img-circle tag_img">
				</div>
				<div style="width: 100%; height: 10px;"></div>
				<div class="tag_name">
					<strong>독서</strong>
				</div>
			</div>
			<div class="tagselect" id="movie">
				<div class="select_img">
					<img src="/imgs/movie.jpg" class="img-circle tag_img">
				</div>
				<div style="width: 100%; height: 10px;"></div>
				<div class="tag_name">
					<strong>영화</strong>
				</div>
			</div>
			<div class="tagselect" id="music">
				<div class="select_img">
					<img src="/imgs/music.jpg" class="img-circle tag_img">
				</div>
				<div style="width: 100%; height: 10px;"></div>
				<div class="tag_name">
					<strong>음악</strong>
				</div>
			</div>
			<div class="tagselect" id="exercise">
				<div class="select_img">
					<img src="/imgs/exercise.jpg" class="img-circle tag_img">
				</div>
				<div style="width: 100%; height: 10px;"></div>
				<div class="tag_name">
					<strong>운동</strong>
				</div>
			</div>
			<div class="tagselect" id="game">
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
						
							<div class="pop_img"><img src="/upload/${pop[0].club_storedname }"class="img-circle pop_image"></div>
							
							<div class="pop_clubcontent">
								<div class="pop_clubname">
									<c:choose>
											<c:when test="${fn:length(pop[0].club_title) > 15}">
												<strong>${fn:substring(pop[0].club_title,0,14)}....</strong>
											</c:when>
											<c:otherwise>
												<strong>${pop[0].club_title }</strong>
											</c:otherwise>
									</c:choose>
								</div>
								<div class="pop_clubinclude">										
										<c:choose>
				 	 						<c:when test="${fn:length(pop[0].club_include) > 56}">
				 	 							<a href="/board/club/detail?club_no=${pop[0].club_no }"><c:out value="${fn:substring(pop[0].club_include,0,55)}"/>....</a>
											</c:when>
											<c:otherwise>
												<a href="/board/club/detail?club_no=${pop[0].club_no }"><c:out value="${pop[0].club_include}"/></a>
											</c:otherwise>
										</c:choose>
								</div>
								<div class="pop_clubdetail">${pop[0].membercnt }명 가입 중</div>
							</div>
						
						</div>
						<div class="pop_content">
							
							<div class="pop_img"><img src="/upload/${pop[1].club_storedname }"class="img-circle pop_image"></div>
							
							<div class="pop_clubcontent">
								<div class="pop_clubname">
									<c:choose>
											<c:when test="${fn:length(pop[1].club_title) > 15}">
												<strong>${fn:substring(pop[1].club_title,0,14)}....</strong>
											</c:when>
											<c:otherwise>
												<strong>${pop[1].club_title }</strong>
											</c:otherwise>
									</c:choose>
								</div>
								<div class="pop_clubinclude">
									<c:choose>
				 	 						<c:when test="${fn:length(pop[1].club_include) > 56}">
				 	 							<a href="/board/club/detail?club_no=${pop[1].club_no }"><c:out value="${fn:substring(pop[1].club_include,0,55)}"/>....</a>
											</c:when>
											<c:otherwise>
												<a href="/board/club/detail?club_no=${pop[1].club_no }"><c:out value="${pop[1].club_include}"/></a>
											</c:otherwise>
										</c:choose>
								</div>
								<div class="pop_clubdetail">${pop[1].membercnt }명 가입 중</div>
							</div>
							
						</div>
					</div>
					<div class="pop_secline">
						<div class="pop_content_l">
							
							<div class="pop_img"><img src="/upload/${pop[2].club_storedname }"class="img-circle pop_image"></div>
							
							<div class="pop_clubcontent">
								<div class="pop_clubname">
									<c:choose>
											<c:when test="${fn:length(pop[2].club_title) > 15}">
												<strong>${fn:substring(pop[2].club_title,0,14)}....</strong>
											</c:when>
											<c:otherwise>
												<strong>${pop[2].club_title }</strong>
											</c:otherwise>
									</c:choose>
								</div>
								<div class="pop_clubinclude">
									<c:choose>
				 	 						<c:when test="${fn:length(pop[2].club_include) > 56}">
				 	 							<a href="/board/club/detail?club_no=${pop[2].club_no }"><c:out value="${fn:substring(pop[2].club_include,0,55)}"/>....</a>
											</c:when>
											<c:otherwise>
												<a href="/board/club/detail?club_no=${pop[2].club_no }"><c:out value="${pop[2].club_include}"/></a>
											</c:otherwise>
									</c:choose>
								</div>
								<div class="pop_clubdetail">${pop[2].membercnt }명 가입 중</div>
							</div>
						
						</div>
						<div class="pop_content">
							
							<div class="pop_img"><img src="/upload/${pop[3].club_storedname }"class="img-circle pop_image"></div>
							
							<div class="pop_clubcontent">
								<div class="pop_clubname">
									<c:choose>
											<c:when test="${fn:length(pop[3].club_title) > 15}">
												<strong>${fn:substring(pop[3].club_title,0,14)}....</strong>
											</c:when>
											<c:otherwise>
												<strong>${pop[3].club_title }</strong>
											</c:otherwise>
									</c:choose>
								</div>
								<div class="pop_clubinclude">
									<c:choose>
				 	 						<c:when test="${fn:length(pop[3].club_include) > 56}">
				 	 							<a href="/board/club/detail?club_no=${pop[3].club_no }"><c:out value="${fn:substring(pop[3].club_include,0,55)}"/>....</a>
											</c:when>
											<c:otherwise>
												<a href="/board/club/detail?club_no=${pop[3].club_no }"><c:out value="${pop[3].club_include}"/></a>
											</c:otherwise>
										</c:choose>
								</div>
								<div class="pop_clubdetail">${pop[3].membercnt }명 가입 중</div>
							</div>
						
						</div>
					</div>
					</div>
					
					<div style="margin-top: 80px; ">
						<div class="pop_title"><strong>최근 등록된 동호회</strong></div>
					</div>
					
					<c:forEach items="${list}" var="i" varStatus="status">
					<div class="lately_list">
						<div class="lately_img">
							<img src="/upload/${i.club_storedname }" class="lately_image img-rounded">
						</div>
						<div class="lately_content">
							<div class="lately_title">
								<c:choose>
											<c:when test="${fn:length(i.club_title) > 15}">
												<strong>${fn:substring(i.club_title,0,14)}....</strong>
											</c:when>
											<c:otherwise>
												<strong>${i.club_title }</strong>
											</c:otherwise>
									</c:choose>
							</div>
							<div class="lately_include">
								<c:choose>
				 	 					<c:when test="${fn:length(i.club_include) > 56}">
				 	 						<a href="/board/club/detail?club_no=${i.club_no }"><c:out value="${fn:substring(i.club_include,0,55)}"/>....</a>
										</c:when>
										<c:otherwise>
											<a href="/board/club/detail?club_no=${i.club_no }"><c:out value="${i.club_include}"/></a>
										</c:otherwise>
								</c:choose>
							</div>
							<div class="lately_detail">${i.membercnt}명 가입 중</div>
						</div>
					</div>
					</c:forEach>		
				</div>
				<c:if test="${check eq true && member_group == 0 }">
				<div style="float:left; width:1200px; height:50px; text-align: right; padding-right:50px;">
					<button id="btncreate">등록하기</button>
				</div>
				</c:if>
				<div class="paging_bar">
				<c:import url="/WEB-INF/views/layout/club/club_paging.jsp" />
				</div>
			</div>
	
</body>
</html>