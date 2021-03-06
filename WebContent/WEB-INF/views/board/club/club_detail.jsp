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
		
		$("#btnlogin").click(function() {

			$(location).attr("href", "/member/login");

		});
		
		if(${club.club_tag } == 1) {
			$("#more_tag").html("여행에 대해 더보기");
			
		} else if (${club.club_tag } == 2) {
			$("#more_tag").html("독서에 대해 더보기");
			
		} else if (${club.club_tag } == 3) {
			$("#more_tag").html("영화에 대해 더보기");
			
		} else if (${club.club_tag } == 4) {
			$("#more_tag").html("음악에 대해 더보기");
			
		} else if (${club.club_tag } == 5) {
			$("#more_tag").html("음악에 대해 더보기");
			
		} else if (${club.club_tag } == 6) {
			$("#more_tag").html("게임에 대해 더보기");
			
		}
		
		$("#more_tag").click(function() {
			if(${club.club_tag } == 1) {
				$("#more_tag").attr("href", "/board/club?club_tag=1");
			} else if (${club.club_tag } == 2) {
				$("#more_tag").attr("href", "/board/club?club_tag=2");
			} else if (${club.club_tag } == 3) {
				$("#more_tag").attr("href", "/board/club?club_tag=3");
			} else if (${club.club_tag } == 4) {
				$("#more_tag").attr("href", "/board/club?club_tag=4");
			} else if (${club.club_tag } == 5) {
				$("#more_tag").attr("href", "/board/club?club_tag=5");
			} else if (${club.club_tag } == 6) {
				$("#more_tag").attr("href", "/board/club?club_tag=6");
			}
		});
		
		$("#btnjoin").click(function() {
			
			$.ajax({
				type: "post"
				, url: "/board/club/join"
				, dataType : "json"   
					, data: {
						club_no : ${club.club_no}
					}
				, success: function(data){
					
					alert("가입성공");
					location.reload();
					
				}
				, error: function(request,status,error) {
					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				}
			});
		});
		
		$("#btnleave").click(function() {
			
			$.ajax({
				type: "post"
				, url: "/board/club/leave"
				, dataType : "json"   
					, data: {
						club_no : ${club.club_no}
					}
				, success: function(data){
					
					alert("탈퇴성공");
					location.reload();
				}
				, error: function(request,status,error) {
					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				}
			});
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

function ListComment(club_board_no, div) {
	
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
				var userid = String(data.comment[i].member_id);
				var memberid =  '<%=(String)session.getAttribute("member_id")%>';
				
				if(userid == memberid) {
				$('#' + divs).append("<div class='comment'>"+
						"<div>"+
						"<div class='writer'><strong>작성자 : "+data.comment[i].club_comment_writer +"</strong></div>"+
						"<div class='delete_comment'><a href='javascript:void(0);' onclick='deleteComment(\""+club_board_no+"\",\""+div+"\",\""+data.comment[i].club_comment_no+"\")'>삭제</a>"+
						"</div>"+
						"<div class='comment_content'>"+
						"<p>"+data.comment[i].club_comment_content +"</p>"+
						"</div>"+
					"</div>");
				} else {
					$('#' + divs).append("<div class='comment'>"+
							"<div>"+
							"<div class='writer'><strong>"+data.comment[i].club_comment_writer +"</strong></div><br>"+
							"<div class='comment_content'>"+
							"<p>"+data.comment[i].club_comment_content +"</p>"+
							"</div>"+
						"</div>");
				}
			}
		}
		, error: function(request,status,error) {
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}

function insertComment(club_board_no, div, form, content) {
	
	var forms =  String(form);
	var divs = String(div);
	var contents = String(content);
	
	$.ajax({
		type: "post"
		, url: "/board/club/comment/write"
		, dataType : "json"   
		, data: $('#' + forms).serialize()
		, success: function(data){
			
			$('#' + contents).val(" ");
			
			ListComment(club_board_no, div);
		}
		, error: function(request,status,error) {
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}

function deleteComment(club_board_no, div, club_comment_no) {
	
	
	$.ajax({
		type: "get"
		, url: "/board/club/comment/delete"
		, dataType : "json"   
			, data: {
				club_comment_no: club_comment_no
			}
		, success: function(data){
			
			ListComment(club_board_no, div);
		}
		, error: function(request,status,error) {
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
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
	width: 1034px;
	text-align: left;
	zoom: 1;
	display: flex;
	position: relative;
}

aside {
	width: 208px;
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
	padding-top: 13px;
	text-align: center;
	font-size: 20px;
}

.club_info {
	font-size:13px;
	width: 100%;
}

.club_membercnt {
	float: left;
	width: 50%;
	height: 100%;
	text-align: center;
	padding-top: 5px;
	margin-bottom: 5px;
}

.club_leader {
	float: left;
	width: 50%;
	height: 100%;
	text-align: left;
	padding-top: 5px;
	margin-bottom: 5px;
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
	padding: 18px 20px 15px;
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
	padding-top: 10px;
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
	width: 456px;
	font-size: 14px;
	line-height: 1.43;
}

.board_content img {
	max-width: 456px;
	height:auto;
	text-align: center;
	border: 1px solid rgba(0, 0, 0, .05);
	border-radius: 2px;
}

.board_writebtn {
	width: 100%;
	height: 50px;
	padding-top: 25px;
	text-align: center;
	margin-bottom: 20px;
	display: block;
	border-top: 1px solid #f0f0f0;
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
	display: none;
}

.buttons {
	width: 100%;
	height: 20px;
	text-align: center;
}

.board_title {
	float:left;
	width : 80%;
	height: 30px;
}
.delete_btn {
	float:left;
	text-align:right;
	width: 20%
	
}

.paging_bar {
	float: left;
	text-align: center;
	width: 100%;
	margin-bottom: 100px;
}

.btn_comment_list_down {
	text-align: right;
	width: 100%;
	height: 40px;
	padding-top: 10px;
	padding-bottom: 10px;
	margin-bottom: 10px;
}

.btn_comment_list_up {
	text-align: right;
	width: 100%;
	height: 40px;
	padding-top: 10px;
	padding-bottom: 10px;
	margin-bottom: 10px;
}

.img_comment {
	width: 13px;
	height: 13px;
}

#boardcomment0 {
	display: none;
}

#boardcomment1 {
	display: none;
}

#boardcomment2 {
	display: none;
}

#boardcomment3 {
	display: none;
}

#boardcomment4 {
	display: none;
}

#boardcomment5 {
	display: none;
}

.comment {
	padding: 14px 20px 14px 17px;
	border-top: 1px solid #f0f0f0;
	min-height: 67px;
	padding-top: 5px;
	margin-top: 3px;
}

.comment_content p {
	margin: 0px;
	margin-top: 3px;
}

.writer {
	float: left;
	width: 80%;
}

.delete_comment {
	float: left;
	width: 20%;
	text-align: right;
}

.comment_textarea {
	width: 100%;
	resize: none;
	overflow-y: hidden; /* prevents scroll bar flash */
	padding: 1.1em; /* prevents text jump on Enter keypress */
	padding-bottom: 0.2em;
	line-height: 1.6;
	margin-bottom: 5px;
}

.club_tag {
	z-index: 1;
	display: inline-block;
	position: relative;
	height: 26px;
	padding: 0 10px 0 9px;
	background: #fff;
	border: 1px solid #e1e1e1;
	border-radius: 100px;
	line-height: 23px;
	font-size: 12px;
	font-weight: 400;
	color: #777;
	cursor: pointer;
}
a:link    { text-decoration:none; color:black }
a:visited { text-decoration:none; color:black }
a:hover   { text-decoration:none; color:black }
a:active  { text-decoration:none; color:black }

.board_write_title {
	padding:10px;
	margin-top:20px;
	margin-bottom:3px;
	width: 100%;
	background-color: #f5f5f5;
	height:50px; border: 1px solid;
	border-color: #bbb;
    border-top-left-radius: 3px;
    border-top-right-radius: 3px;
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
						<div class="club_membercnt" id="membercnt">멤버 : ${club.membercnt }명</div>
						<div class="club_leader">리더 : ${club.member_id }</div>
					</div>
					
					<c:if test="${check eq false && member_group == 0 && checkjoin eq true}">
					<div class="club_join">
						<button id="btnjoin">가입하기</button>
					</div>
					</c:if>
					
					<c:if test="${check eq true && member_group == 0  && checkleave eq true}">
					<div class="club_join">
						<button id="btnleave">탈퇴하기</button>
					</div>
					</c:if>
					
					<c:if test="${empty login }">
					<div class="club_join">
						<button id="btnlogin">로그인</button>
					</div>
					</c:if>
					
				</div>
			</aside>

			<section>

				<div class="club_include">
					<h2>동호회 소개</h2>
					<p>${club.club_include}</p>
					<div class="tag_info">
						<a class="club_tag" id="more_tag"></a>
					</div>
				</div>


				<c:forEach items="${list}" var="i" varStatus="status">
					<div class="board_list">
						<div class="board_info">
							<div style="width:100%; height: 30px;">
							<div class="board_title">
								<strong>${i.club_board_title }</strong>
							</div>
							<c:if test="${member_nick == i.club_board_writer || member_group == 1}">
							<div class="delete_btn">
								<a href="/board/club/boardDelete?club_board_no=${i.club_board_no }&club_no=${club.club_no}">삭제</a>
							</div>
							</c:if>
							</div>
							<div style="width: 100%; height: 20px;">
							<strong>${i.club_board_writer }</strong><br>
							</div>
							<div style="padding-top: 3px; border-bottom: 1px solid;">
								<label>작성일 : ${i.club_board_writedate }</label>
							</div>
							<div class="board_content">${i.club_board_content }</div>
						</div>
						<div class="btn_comment_list_down" id="listdown${status.index}"
							style="display: block;">
							<button id="btn_comment"
								onclick="viewcomment('boardcomment${status.index}','listdown${status.index}','listup${status.index}'); ListComment('${i.club_board_no}','boardcom${status.index}');">
								<img src="/imgs/comment.png" class="img_comment"> 댓글 <img
									src="/imgs/down_arrow.png" class="img_comment">
							</button>
						</div>
						<div class="btn_comment_list_up" id="listup${status.index}"
							style="display: none;">
							<button id="btn_comment"
								onclick="hidecomment('boardcomment${status.index}','listdown${status.index}','listup${status.index}')">
								<img src="/imgs/comment.png" class="img_comment"> 댓글 <img
									src="/imgs/up_arrow.png" class="img_comment">
							</button>
						</div>

						<div id="boardcomment${status.index}">
							<div id="boardcom${status.index}"></div>

							<c:if test="${check eq true || member_group == 1 }">
							<div class="board_writebtn" id="commentwrite${status.index}">
								<button
									onclick="viewwritecomment('commentwrite${status.index}','writecomment${status.index}')">댓글작성</button>
							</div>
							</c:if>

							<div id="writecomment${status.index}" style="display: none;">
								<div class="comment_write">

									<form id="CommentForm${status.index}" method="post">
										<textarea name="club_comment_content"
											id="comment_content${status.index}" class="comment_textarea"></textarea>
										<div class="buttons">
											<input type="hidden" name="club_no" value="${club.club_no}">
											<input type="hidden" name="club_board_no"
												value="${i.club_board_no}">
											<button type="button"
												onclick="insertComment('${i.club_board_no}','boardcom${status.index}','CommentForm${status.index}','comment_content${status.index}'); hidewritecomment('commentwrite${status.index}','writecomment${status.index}');">작성하기</button>
										</div>
									</form>

									<div style="text-align: right;">
										<button id="btn_comment_cancle"
											onclick="hidewritecomment('commentwrite${status.index}','writecomment${status.index}')"
											style="margin-left: 5px;">취소</button>
									</div>

								</div>
							</div>
						</div>

					</div>
				</c:forEach>

				<c:if test="${check eq true || member_group == 1 }">
				<div class="board_writebtn">
					<button id="btn_write">글쓰기</button>
				</div>
				</c:if>

				<c:if test="${check eq true || member_group == 1 }">
				<div class="board_write">
					<form action="/board/club/detail" method="post" enctype="multipart/form-data">
						<div class="board_write_title">
							제목: <input type="text" name="title" style="width:480px;">
						</div>
						<textarea name="content" id="summernote"></textarea>
						<div class="buttons">
							<input type="hidden" name="club_no" value="${club.club_no }">
							<input type="submit" value="작성하기">
						</div>
					</form>
					<div style="text-align: right;">
						<button id="btn_cancle" style="margin-left: 5px;">취소</button>
					</div>
				</div>
				</c:if>
				
				<div class="paging_bar">
					<c:import url="/WEB-INF/views/layout/club/clubBoard_paging.jsp" />
				</div>

			</section>


		</div>

	</div>


</body>
</html>