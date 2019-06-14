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
	var sel_file;

	$(document).ready(function() {
		$("#input_img").on("change", handleImgFileSelect);

	});

	function handleImgFileSelect(e) {
		var files = e.target.files;
		var filesArr = Array.prototype.slice.call(files);

		filesArr.forEach(function(f) {
			if (!f.type.match("image.*")) {
				alert("확장자는 이미지 확장자만 가능합니다.");
				return;
			}

			sel_files = f;

			var reader = new FileReader();
			reader.onload = function(e) {
				$("#img").attr("src", e.target.result);
			}
			reader.readAsDataURL(f);
		});
	}
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
	height: 120px;
	margin-top: 30px;
}

.title_left {
	float: left;
	width: 100%;
	height: 100%;
}

.img_wrap {
	width: 360px;
	height: 360px;
	margin-top: 20px;
}

.img_wrap img {
	width: 100%;
	height: 100%;
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
		<form action="/board/club/create" method="post" enctype="multipart/form-data">
			<div>
				<h2>
					<b>대표이미지 미리보기</b>
				</h2>
				<p class="img_title">대표이미지 업로드</p>
				<input type="file" id="input_img" name="upfile"/>
			</div>

			<div>
				<div class="img_wrap">
					<img id="img" />
				</div>
			</div>

			<div>
				<div style="margin-top: 50px;">
					<label>동호회 이름 </label>
				</div>
				<div>
					<input class="input_title" type="text" name="title">
				</div>

			</div>
			<br>
			<br>


			<div>
				<div style="margin-top: 50px;">
					<label>주제 (하나만 선택) </label>
				</div>
				<div>
					<input type="checkbox" value="1" name="subject" />여행 <input
						type="checkbox" value="2" name="subject" />독서 <input
						type="checkbox" value="3" name="subject" />영화 <input
						type="checkbox" value="4" name="subject" />음악 <input
						type="checkbox" value="5" name="subject" />운동 <input
						type="checkbox" value="6" name="subject" />게임
				</div>

			</div>
			<br>
			<br>

			<div>
				<div style="margin-top: 50px;">
					<label>동호회 소개 </label>
				</div>
				<div>
					<textarea name="content" cols="100" rows="8" ></textarea>
				</div>

			</div>
			<br>
			<br>

			<div>
				<div>
					<input type="submit" value="등록하기">
				</div>
			</div>

		</form>

	</div>





</body>
</html>