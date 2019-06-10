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

<script type="text/javascript">
	$(document).ready(function() {

		$("#btn_write").click(function() {


			$(".board_write").css("display","block");

			$(".board_writebtn").css("display","none");

		});

		$("#btn_cancle").click(function() {

			$(".board_write").css("display","none");

			$(".board_writebtn").css("display","block");

		});
		

});
	
	
function viewcomment(num, down, up) {
	var com = String(num);
	var listdown = String(down);
	var listup = String(up);
 	var comment = document.getElementById(com);
 	$('#' + listdown).css("display","none");
 	$('#' + listup).css("display","block");
    comment.style.display='block';

	
}

function hidecomment(num, down, up) {
	var com = String(num);
	var listdown = String(down);
	var listup = String(up);
 	var comment = document.getElementById(com);
 	$('#' + listdown).css("display","block");
 	$('#' + listup).css("display","none");
    comment.style.display='none';
	
}

function viewwritecomment(btn,div) {
	var btns = String(btn);
 	var commentbtn = document.getElementById(btns);
 	var divs = String(div);
 	var commentdiv = document.getElementById(divs);
 	
 	commentbtn.style.display='none';
 	commentdiv.style.display='block';

	
}

function hidewritecomment(btn,div) {
	var btns = String(btn);
 	var commentbtn = document.getElementById(btns);
 	var divs = String(div);
 	var commentdiv = document.getElementById(divs);
 	
 	commentbtn.style.display='block';
 	commentdiv.style.display='none';
	
}

//댓글 뷰
function ListComment(club_board_no, div) {
	
	var result = new Array();
	
	$.ajax({
		type: "get"
		, url: "/board/club/comment/view"
		, dataType : "json"   
		, data: {
			club_board_no: club_board_no
		}
		, success: function(data){
			var divs = String(div);
			
			$('#' + divs).html(" ");
			
			for(var i=0; i<data.comment.length; i++) {
			$('#' + divs).append("<div class='comment'>"+
					"<div class='writer'><strong>"+data.comment[i].club_comment_writer +"</strong></div>"+
					"<div class='comment_content'>"+
					"<p>"+data.comment[i].club_comment_content +"</p>"+
					"</div>"+
				"</div>");
			}
		}
		, error: function(request,status,error) {
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}

</script>


<style type="text/css">
.main {
	margin: 0 auto;
	padding: 8px 10px 0;
	width: 1034px;
	text-align: left;
	zoom: 1;
	display: flex;
	position: relative;
}

aside {
	width: 208px;
	height: 300px;
	margin-right: 18px;
}

section {
	width: 540px;
}

.club_banner {
	width: 208px;
	height: 300px;
}

.club_img {
	width: 180px;
	height: 180px;
	text-align: center;
	margin: 0 auto;
}

.club_img img {
	width: 100%;
	height: 100%;
	border: 1px solid rgba(0, 0, 0, .05);
	border-radius: 2px;
}

.club_name {
	width: 100%;
	height: 40px;
	padding-top: 13px;
	text-align: center;
	font-size: 20px;
}

.club_info {
	width: 100%;
	height: 30px;
}

.club_membercnt {
	float: left;
	width: 50%;
	height: 100%;
	text-align: center;
	padding-top: 5px;
}

.club_leader {
	float: left;
	width: 50%;
	height: 100%;
	text-align: center;
	padding-top: 5px;
}

.club_join {
	width: 100%;
	height: 50px;
	padding-top: 5px;
	text-align: center;
}

.club_join button {
	width: 200px;
	height: 40px;
	background: #474e60;
	font-size: 13px;
	color: #fff;
	border: solid 2px;
	border-radius: 1px;
}

.club_include {
	width: 540px;
	padding: 18px 20px 23px;
	margin-bottom: 30px;
	background: white;
	box-shadow: 0 1px 1px 0 #e5e8ec;
}

.club_include h2 {
	font-size: 14px;
	font-weight: 600;
	margin-bottom: 13px;
	margin-top: 0px;
}

.club_include p {
	margin: 0;
	padding: 0;
}

.tag_info {
	width: 500px;
	height: 40px;
	padding-top: 17px;
	margin-top: 16px;
	border-top: 1px solid #f0f2f4;
}

.board_list {
	width: 540px;
	padding: 18px 20px 23px;
	margin-bottom: 15px;
	background: white;
	box-shadow: 0 1px 1px 0 #e5e8ec;
}

.board_content {
	padding: 15px 22px 17px;
}

.board_content p {
	font-size: 14px;
	line-height: 1.43;
}

.board_content img {
	width: 494px;
	height: 246px;
	text-align: center;
	border: 1px solid rgba(0, 0, 0, .05);
	border-radius: 2px;
}

.board_writebtn {
	width: 100%;
	height: 50px;
	padding-top: 5px;
	text-align: center;
	margin-bottom: 20px;
	display:block;
}

.board_writebtn button {
	width: 200px;
	height: 40px;
	background: #474e60;
	font-size: 13px;
	color: #fff;
	border: solid 2px;
	border-radius: 1px;
}

.board_write {
	margin-bottom: 20px;
	display:none;
}
.buttons {
	width: 100%;
	height: 20px;
	text-align: center;
}

.board_title {
	height: 40px;
}
.paging_bar {
	float:left;
	text-align:center;
	width:100%;

	margin-bottom:100px;
}
.btn_comment_list_down {
	text-align:right;
	width: 100%;
	height: 40px;
	padding-top: 10px;
	padding-bottom: 10px;
	margin-bottom:10px;
}
.btn_comment_list_up {
	text-align:right;
	width: 100%;
	height: 40px;
	padding-top: 10px;
	padding-bottom: 10px;
	margin-bottom:10px;
}
.img_comment {
	width:13px;
	height: 13px;
}
#boardcomment0{
    display: none;
}
#boardcomment1{
    display: none;
}
#boardcomment2{
    display: none;
}
#boardcomment3{
    display: none;
}
#boardcomment4{
    display: none;
}
#boardcomment5{
    display: none;
}

.comment {
	padding: 14px 40px 14px 17px;
	border-top: 1px solid #f0f0f0;
	min-height: 67px;
	padding-top:5px;
	margin-top: 3px;
	
}
.comment_content p {
	margin:0px;
	
}

</style>


</head>
<body>
	<div style="background: #f0f2f4;">
		<div class="main">

			<aside>
				<div class="club_banner">
					<div class="club_img">
						<img src="/upload/${club.club_storedname }">
					</div>
					<div class="club_name">
						<span><strong>${club.club_title }</strong></span>
					</div>
					<div class="club_info">
						<div class="club_membercnt">멤버 : ${club.membercnt }명</div>
						<div class="club_leader">리더 : ${club.member_id }</div>
					</div>
					<div class="club_join">
						<button id="btnjoin">가입하기</button>
					</div>
				</div>
			</aside>

			<section>

				<div class="club_include">
					<h2>동호회 소개</h2>
					<p>${club.club_include}</p>
					<div class="tag_info">
						<p>${club.club_tag }에대해 더보기</p>
					</div>
				</div>


				<c:forEach items="${list}" var="i" varStatus="status">
				<div class="board_list">
					<div class="board_info">
						<div class="board_title">
							<strong>${i.club_board_title }</strong>
						</div>
						<strong>${i.club_board_writer }</strong><br>
						<div style="padding-top: 3px; border-bottom: 1px solid;">
							<label>작성일 : ${i.club_board_writedate }</label>
						</div>
						<div class="board_content">${i.club_board_content }</div>
					</div>
					<div class="btn_comment_list_down" id="listdown${status.index}" style="display:block;">
						<button id="btn_comment" onclick="viewcomment('boardcomment${status.index}','listdown${status.index}','listup${status.index}'); ListComment('${i.club_board_no}','boardcom${status.index}');"><img src="/imgs/comment.png" class="img_comment"> 댓글 <img src="/imgs/down_arrow.png" class="img_comment"></button>
					</div>
					<div class="btn_comment_list_up" id="listup${status.index}" style="display:none;">
						<button id="btn_comment" onclick="hidecomment('boardcomment${status.index}','listdown${status.index}','listup${status.index}')"><img src="/imgs/comment.png" class="img_comment"> 댓글 <img src="/imgs/up_arrow.png" class="img_comment"></button>
					</div>
					
					<div id="boardcomment${status.index}">
						<div id="boardcom${status.index}"></div>
						
						
						<div class="board_writebtn" id="commentwrite${status.index}">
							<button onclick="viewwritecomment('commentwrite${status.index}','writecomment${status.index}')">댓글작성</button>
						</div>
					
						<div id="writecomment${status.index}" style="display:none;">
						<div class="comment_write">
						
							<form action="/board/club/comment/write" method="post">
								<textarea name="club_comment_content" id="summernote" value=""></textarea>
								<div class="buttons">
									<input type="hidden" name="club_no" value="${club.club_no}">
									<input type="hidden" name="club_board_no" value="${i.club_board_no}">
									<input type="submit" value="작성하기">
								</div>
							</form>
						
							<div style="text-align: right;">
								<button id="btn_comment_cancle" onclick="hidewritecomment('commentwrite${status.index}','writecomment${status.index}')" style="margin-left: 5px;">취소</button>
							</div>
				
						</div>
					</div>
					</div>
				
				</div>
				</c:forEach>


				<div class="board_writebtn">
					<button id="btn_write">글쓰기</button>
				</div>

				<div class="board_write">
					<form action="/board/club/detail" method="post" enctype="multipart">
						<div class="board_title">
							제목: <input type="text" name="title">
						</div>
						<textarea name="content" id="summernote" value=""></textarea>
						<div class="buttons">
							<input type="hidden" name="club_no" value="${club.club_no }">
							<input type="submit" value="작성하기">
						</div>
					</form>
					<div style="text-align: right;">
						<button id="btn_cancle" style="margin-left: 5px;">취소</button>
					</div>
				</div>

				<div class="paging_bar">
					<c:import url="/WEB-INF/views/layout/club/clubBoard_paging.jsp" />
				</div>

			</section>


		</div>

	</div>





























</body>
</html>