<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

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
	
	if(${isRecommend}) {
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

</script>
<style type="text/css">

#next > a{

font-size:16px;
}

#back > a{
font-size:16px;
}

#page{
margin-left: 250px;
margin-right:50px;
width:1200px;
margin-top: 50px;

}

.total {
	margin : 0 auto;
	width : 75%;
}
.sumnail{
	
	
	margin : 50px;
	width: 40%;
	float : left;
	position : relative; 
}

.info {
	margin : 80px;
	font-size : 16px;
}

.notice {
	font-size : 18px;
}

#filediv{
	position:absolute;
	top:540px;
	left:1100px;
}

</style>

<h3 class="pull-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;자랑게시판</h3>


<div class="clearfix"></div>
<hr>


<div class="total">


<h1 class="pull-left">${viewBoard.boast_board_title }</h1><br><br><br><br>
<h5 class="pull-left">작성일 : ${viewBoard.boast_board_written_date } </h5>
<h5 class="pull-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 작성자 : ${viewBoard.boast_board_writer }  </h5>
<h5 class="pull-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 조회수 : ${viewBoard.boast_board_hit }  </h5>
<h5 class="pull-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 추천수 : ${viewBoard.recommend }  </h5>

<div class="text-right">	
	<button id="btnList" class="btn btn-primary btn-sm">목록</button>
	<c:if test="${login }">
	<button id="btnRecommend" class="btn btn-primary btn-sm">추천</button>
	</c:if>
	<c:if test="${member_id eq viewBoard.boast_board_writer }">
	<button id="btnUpdate" class="btn btn-primary btn-sm">수정</button>
	<button id="btnDelete" class="btn btn-primary btn-sm">삭제</button>
	</c:if>
</div>
<hr>

<div class = "notice">
${viewBoard.boast_board_content }
</div>


<!-- <h1 class="pull-left">게시판 - VIEW</h1> -->

<%-- <c:if test="${login }"> --%>
<!-- <button id="btnRecommend" class="btn pull-right" style="margin-top: 30px;"></button> -->
<%-- </c:if> --%>

<!-- <div class="clearfix"></div> -->
<!-- <hr> -->

<!-- <table class="table table-bordered"> -->
<!-- <tr> -->
<%-- <td class="info">글번호</td><td colspan="3">${viewBoard.boast_board_no }</td> --%>
<!-- </tr> -->

<!-- <tr> -->
<%-- <td class="info">제목</td><td colspan="3">${viewBoard.boast_board_title }</td> --%>
<!-- </tr> -->

<!-- <tr> -->
<%-- <td class="info">아이디</td><td>${viewBoard.boast_board_writer }</td> --%>
<%-- <td class="info">닉네임</td><td>${member_nick }</td> --%>
<!-- </tr> -->

<!-- <tr> -->
<%-- <td class="info">조회수</td><td>${viewBoard.boast_board_hit }</td> --%>
<%-- <td class="info">추천수</td><td id="recommend">${viewBoard.recommend }</td> --%>
<!-- </tr> -->

<!-- <tr> -->
<%-- <td class="info">작성일</td><td colspan="2">${viewBoard.boast_board_written_date }</td> --%>
<!-- </tr> -->

<!-- <tr><td class="info"  colspan="4">본문</td></tr> -->
<%-- <tr><td colspan="4">${viewBoard.boast_board_content }</td></tr> --%>
<!-- <tr> -->
<%-- <td class="info">첨부파일</td><td colspan="3"><a href="/board/boast/download?fileno=${boardFile.boast_board_file_no }">${boardFile.boast_board_origin_name }</a> --%>
<!-- </td> -->
<!-- </tr> -->

<!-- </table> -->
<div id="filediv">

<c:if test="${boardFile.boast_board_file_idx ne null }">
<h5>첨부파일:&nbsp;&nbsp;&nbsp;<a href="/board/boast/download?fileno=${boardFile.boast_board_file_no }">${boardFile.boast_board_origin_name }</a></h5>
</c:if>

</div>





 
<!-- 댓글 리스트 -->
<table class="table table-striped table-hover table-condensed "
style=" width:1300px; margin-top:300px;">
<thead>
<tr>
	<th style="width: 10%;"></th>
	<th style="width: 50%;"></th>
	<th style="width: 20%;"></th>
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
<%-- <c:if test="${not login }"> --%>
<!-- <strong>댓글작성은 로그인이 필요합니다</strong><br> -->
<!-- <button onclick='location.href="/member/login";'>로그인</button> -->
<!-- <button onclick='location.href="/member/join";'>회원가입</button> -->
<%-- </c:if> --%>

<!-- 로그인상태 -->
<c:if test="${login }">
<!-- 댓글 입력 -->
<div class="form-inline text-center">
	<input type="text" size="10" class="form-control" id="commentWriter" value="${member_nick }" readonly="readonly"/>
	<textarea rows="2" cols="60" class="form-control" id="commentContent" placeholder="내용을 입력해 주세요"></textarea>
	<button id="btnCommInsert" class="btn btn-default">입력</button>
</div>	<!-- 댓글 입력 end -->
</c:if>
 
</div>

<!-- 이전글, 다음글 리스트 -->
<div id = "page">


<hr id = "hr2">
<div id = "next">
<c:if test="${prev_next.next eq 0 }">
	다음글없음
</c:if>
<c:if test="${prev_next.next ne 0 }">
	<a href="/board/boast/view?boast_board_no=${prev_next.next }" >
	다음글:&nbsp;&nbsp;&nbsp;&nbsp;${prev_next_name.next }
	</a>
</c:if>
</div>


<hr id = "hr2">
<div id = "back">
<c:if test="${prev_next.prev eq 0 }">
	이전글없음
</c:if>
<c:if test="${prev_next.prev ne 0 }">
<a href="/board/boast/view?boast_board_no=${prev_next.prev}">
		이전글:&nbsp;&nbsp;&nbsp;&nbsp;${prev_next_name.prev }
	</a>
</c:if>
</div>
<hr id = "hr2">
</div>

<c:import url="/WEB-INF/views/layout/footer.jsp" />
