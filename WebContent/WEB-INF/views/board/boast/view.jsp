<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<

<script type="text/javascript">
$(document).ready(function() {
	//목록버튼 동작
	$("#btnList").click(function() {
		$(location).attr("href", "/board/boast/list");
	});
	
	//수정버튼 동작
	$("#btnUpdate").click(function() {
		$(location).attr("href", "/board/boast/update?boast_board_no=${viewBoard.boast_board_no }");
	});

	//삭제버튼 동작
	$("#btnDelete").click(function() {
		$(location).attr("href", "/board/boast/delete?boast_board_no=${viewBoard.boast_board_no }");

	});
	
	if('${isRecommend}') {
		$("#btnRecommend")
			.addClass("btn-warn")
			.html('추천 취소');
		
	} else {
		$("#btnRecommend")
			.addClass("btn-primary")
			.html('추천');
	} ;
	
	$("#btnRecommend").click(function() {
		
		$.ajax({
			type: "get"
				, url: "/board/boast/recommend"
				, data: { "boast_board_no": ${viewBoard.boast_board_no } }
				, dataType: "json"
				, success: function( data ) {
					console.log("성공");
 					console.log(data);
					if( data.result ) { //추천 성공
						$("#btnRecommend")
						.addClass("btn-warn")
						.html('추천 취소');
					
					} else { //추천 취소 성공
						$("#btnRecommend")
						.addClass("btn-primary")
						.html('추천');
					
					}
					
					//추천수 적용
					$("#recommend").html(data.cnt);
					
				}
				, error: function() {
					console.log("실패");
				}
		});
		
	});
	
	// 댓글 입력
	$("#btnCommInsert").click(function() {

		$form = $("<form>").attr({
			action: "/boast/comment/insert",
			method: "post"
		}).append(
			$("<input>").attr({
				type:"hidden",
				name:"boast_board_no",
				value:"${viewBoard.boast_board_no }"
			})
		).append(
			$("<input>").attr({
				type:"hidden",
				name:"member_id",
				value:"${sessionScope.member_id }"
			})
		).append(
			$("<textarea>")
				.attr("name", "boast_content")
				.css("display", "none")
				.text($("#commentContent").val())
		);
		$(document.body).append($form);
		$form.submit();
		
	});
});

	//댓글 삭제
	function deleteComment(boast_board_comment_no) {
		$.ajax({
			type: "post"
			, url: "/boast/comment/delete"
			, dataType: "json"
			, data: {
				boast_board_comment_no: boast_board_comment_no
			}
			, success: function(data){
				if(data.success) {
					
					$("[data-commentno='"+boast_board_comment_no+"']").remove();
					
				} else {
					alert("댓글 삭제 실패");
				}
			}
			, error: function() {
				console.log("error");
			}
		});
	}
	
</script>

<h1 class="pull-left">게시판 - VIEW</h1>

<c:if test="${login }">
<button id="btnRecommend" class="btn pull-right" style="margin-top: 30px;"></button>
</c:if>

<div class="clearfix"></div>
<hr>

<table class="table table-bordered">
<tr>
<td class="info">글번호</td><td colspan="3">${viewBoard.boast_board_no }</td>
</tr>

<tr>
<td class="info">제목</td><td colspan="3">${viewBoard.boast_board_title }</td>
</tr>

<tr>
<td class="info">아이디</td><td>${viewBoard.boast_board_writer }</td>
<td class="info">닉네임</td><td>${member_nick }</td>
</tr>

<tr>
<td class="info">조회수</td><td>${viewBoard.boast_board_hit }</td>
<td class="info">추천수</td><td id="recommend">${viewBoard.recommend }</td>
</tr>

<tr>
<td class="info">작성일</td><td colspan="2">${viewBoard.boast_board_written_date }</td>
</tr>

<tr><td class="info"  colspan="4">본문</td></tr>
<tr><td colspan="4">${viewBoard.boast_board_content }</td></tr>
<tr>
<td class="info">첨부파일</td><td colspan="3"><a href="/board/boast/download?fileno=${boardFile.boast_board_file_no }">${boardFile.boast_board_origin_name }</a>
</td>
</tr>

</table>
<div>
<h3>첨부파일 이미지</h3>
<img src="/upload/${boardFile.boast_board_stored_name}" alt="첨부파일없음" width="350px" height="350px"></img>
</div>
<div class="text-center">	
	<button id="btnList" class="btn btn-primary">목록</button>
	<c:if test="${member_id eq viewBoard.boast_board_writer }">
	<button id="btnUpdate" class="btn btn-info">수정</button>
	<button id="btnDelete" class="btn btn-danger">삭제</button>
	</c:if>
</div>

<div>
<hr>
 
<!-- 댓글 리스트 -->
<table class="table table-striped table-hover table-condensed ">
<thead>
<tr class="success">
	<th style="width: 5%;">번호</th>
	<th style="width: 10%;">작성자</th>
	<th style="width: 50%;">댓글</th>
	<th style="width: 20%;">작성일</th>
	<th style="width: 5%;"></th>
</tr>
</thead>
<tbody id="commentBody">
<c:forEach items="${commentList }" var="comment">
<tr data-commentno="${comment.boast_board_comment_no }">
	<td>${comment.rnum }</td>
	<td>${comment.member_id }</td><!-- 닉네임으로 해도 좋음 -->
	<td>${comment.boast_content }</td>
	<td>${comment.boast_comment_written_date }</td>
	<td>
		<c:if test="${sessionScope.member_id eq comment.member_id }">
		<button class="btn btn-default btn-xs"
			onclick="deleteComment(${comment.boast_board_comment_no });">삭제</button>
		</c:if>
	</td>
	
</tr>
</c:forEach>
</tbody>
</table>	<!-- 댓글 리스트 end -->


<!-- 비로그인상태 -->
<c:if test="${not login }">
<strong>댓글작성은 로그인이 필요합니다</strong><br>
<button onclick='location.href="/member/login";'>로그인</button>
<button onclick='location.href="/member/join";'>회원가입</button>
</c:if>

<!-- 로그인상태 -->
<c:if test="${login }">
<!-- 댓글 입력 -->
<div class="form-inline text-center">
	<input type="text" size="7" class="form-control" id="commentWriter" value="${member_nick }" readonly="readonly"/>
	<textarea rows="3" cols="110" class="form-control" id="commentContent" placeholder="내용을 입력해 주세요"></textarea>
	<button id="btnCommInsert" class="btn btn-default">입력</button>
</div>	<!-- 댓글 입력 end -->
</c:if>
 
</div>

<hr id = "hr2">


