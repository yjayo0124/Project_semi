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
$(document).ready(function() {
	$("#btnUpdate").click(function() {
		$(location).attr("href", "/board/festival/update?festival_board_no="+${board.festival_board_no });
	});
	
	$("#btnDelete").click(function() {
		$(location).attr("href", "/board/festival/delete?festival_board_no="+${board.festival_board_no });
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

.title {
	border-bottom: solid 1px;
	width: 100%;
	height: 120px;
	margin-top: 30px;
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
	height: 70%;
}

.title_right_bottom {
	text-align: right;
	height: 30%;
}

.title_button {
	margin-right: 10px;
	width: 80px;
	height: 30px;
}

.content {
	margin-bottom: 50px;
}

.content_middle {
	text-align: center;
	margin: 0 auto;
	width: 1000px;
	height: 800px;
}

.content_img {
	width: 100%;
	height: 100%;
}

.content_text {
	text-align: left;
	margin: 30px;
	line-height:2em
}

.board_list_btn {
	text-align: right;
}

.list_btn {
	margin-right: 10px;
	width: 100px;
	height: 40px;
}
.board_list {
	border-top: solid rgba(0, 0, 0, .5) 1px;
	border-bottom: solid rgba(0, 0, 0, .5) 1px;
	width: 1050px;
	height: 100px;
	min-height: 100px;
	margin-top: 60px;
}
.after_list {
	height: 50px;
	border-bottom: solid rgba(0, 0, 0, .5) 1px;

}
.before_list {
	height: 50px;
}
.btnupdown {
	float:left;
	padding-left:20px;
	width: 50px;
	height: 50px;
}
.btnafter {
	width: 100%;
	height: 45px;
}
.btnbefore {
	width: 100%;
	height: 45px;
}
.listtext {
	font-size: 18px;
	padding-left : 200px;
	padding-top: 12px;
}
</style>

<!-- header -->
<c:import url="/WEB-INF/views/layout/header.jsp" />
</head>
<body>

	<div class="main">
		<div class="title">
			<div class="title_left">
				<h3>${board.festival_title }</h3>
				<br>
				<h4>작성일 : ${board.festival_writtendate }</h4>
			</div>
			<div class="title_right">
				<div class="title_right_top"></div>
				<div class="title_right_bottom">
					<button class="title_button" id="btnUpdate">수정</button>
					<button class="title_button" id="btnDelete">삭제</button>
				</div>
			</div>
		</div>

		<br>
		<br>
		<div style="text-align: center;">
			<h4>이벤트 상세 내용</h4>
		</div>
		<hr>
		<table class="table table-bordered ">
			<tr style="border: solid 1px;">
				<td class="info">주최자</td>
				<td>${board.festival_host }</td>
				<td class="info">전화번호</td>
				<td>${board.festival_phone }</td>
			</tr>
			<tr style="border: solid 1px;">
				<td class="info">주최사이트</td>
				<td>${board.festival_web }</td>
				<td class="info">가격</td>
				<td>${board.festival_fee }</td>
			</tr>
			<tr style="border: solid 1px;">
				<td class="info">이벤트 기간</td>
				<td colspan="3">${board.festival_start } ~ ${board.festival_end }</td>
			</tr>
		</table>

		<div class="content">
			<div class="content_middle">
				<img src="/imgs/fishing.jpg" class="content_img" />
			</div>
			<div class="content_text">${board.festival_content }</div>
		</div>

		<div class="board_list_btn">
			<button class="list_btn">목록</button>
		</div>
		
		<div class="board_list">
			<div class="after_list">
				<div class="btnupdown"><img src="/imgs/after.png" class="btnafter"></div>
				<div class="listtext">다음 글 제목 : </div>
			</div>
			
			<div class="before_list">
					<div class="btnupdown"><img src="/imgs/before.png" class="btnbefore"></div>
					<div class="listtext">이전 글 제목 : </div>
			</div>
		</div>







	</div>
	<br><br><br><br>
</body>
</html>








