<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- header -->
<c:import url="/WEB-INF/views/layout/header.jsp" />

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

<!-- include libraries(jQuery, bootstrap) -->
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

<!-- include summernote css/js -->
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>
<!-- summer note korean language pack -->

<script src="/resources/summernote/lang/summernote-ko-KR.js"></script>

<!-- summernote 코드 -->
<script type="text/javascript">
	$(document).ready(function() {
		$('#summernote').summernote({
			height : 300, // 기본 높이값
			minHeight : null, // 최소 높이값(null은 제한 없음)
			maxHeight : null, // 최대 높이값(null은 제한 없음)
			focus : true, // 페이지가 열릴때 포커스를 지정함
			lang : 'ko-KR' // 한국어 지정(기본값은 en-US)
		});
	})
</script>

<style type="text/css">
a:link { text-decoration:none; color:black;}
a:visited { text-decoration:none;color:black;}
a:active {text-decoration:none; color:black; }
a:hover { text-decoration:none; color:black;}

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
	height: 80px;
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

.input_td {
	width: 300px;
}

.input_text {
	width: 100%;
}

.input_date {
	width: 100%;
	height: 23px;
}

.bottom_btn {
	text-align: center;
}
.btn_write {
	margin:5px;
	width: 80px;
	height: 30px;
	background: #474e60;
	font-size: 13px;
	color: #fff;
	border: solid 2px;
	border-radius: 1px;
}

.btn_cancel {
	margin:5px;
	width: 80px;
	height: 30px;
	background: #a7a7a2;
   	font-size: 13px;
   	color: #fff;
   	border: solid 2px;
   	border-radius: 1px;
}

</style>

<body>

	<div class="main">
		<div class="title">
			<div class="title_left">
				<h3>게시글 작성</h3>
			</div>
		</div>
		<br>
		<br>
		<form action="/board/festival/write" method="post" enctype="multipart/form-data">
			<table class="table table-bordered ">
				<tr style="border: solid 1px;">
					<td class="info" style="width: 150px;">제목</td>
					<td class="input_td"><input class="input_text" type="text"
						value="" name="title"></td>
					<td class="info" style="width: 150px;">주최자</td>
					<td class="input_td"><input class="input_text" type="text"
						value="" name="host"></td>
				</tr>
				<tr style="border: solid 1px;">
					<td class="info" style="width: 150px;">전화번호</td>
					<td class="input_td"><input class="input_text" type="text"
						value="" name="phone"></td>
					<td class="info" style="width: 150px;">주최사이트</td>
					<td class="input_td"><input class="input_text" type="text"
						value=""  name="web"></td>
				</tr>
				<tr style="border: solid 1px;">
					<td class="info" style="width: 150px;">시작일</td>
					<td class="input_td"><input class="input_date" type="date"
						value=""  name="start"></td>
					<td class="info" style="width: 150px;">종료일</td>
					<td class="input_td"><input class="input_date" type="date"
						value=""  name="end"></td>
				</tr>
				<tr style="border: solid 1px;">
					<td class="info" style="width: 150px;">가격</td>
					<td class="input_td"><input class="input_text" type="text"
						value=""  name="fee"></td>
				</tr>
			</table>
			<label>썸네일 이미지 : <input type="file" name="upfile"/></label><br><br>
			<div class="content">
				<div class="content_middle">
					<textarea name="content" id="summernote" ></textarea>
				</div>
			</div>
			<c:if test="${member_group == 1 }">
			<div class="bottom_btn">
			<input class="btn_write" type="submit" value="작성">
			<button class="btn_cancel">취소</button>
			</div>
			</c:if>
		</form>
	</div>
	<br><br><br>


</body>
</html>