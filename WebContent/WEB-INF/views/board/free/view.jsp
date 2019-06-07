<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:import url="/WEB-INF/views/layout/header.jsp" />

<script type="text/javascript">
$(document).ready(function() {
	//목록버튼 동작
	$("#btnList").click(function() {
		$(location).attr("href", "/board/free/list");
	});
	
	//수정버튼 동작
	$("#btnUpdate").click(function() {
		$(location).attr("href", "/board/free/update?free_board_no=${viewBoard.free_board_no }");
	});

	//삭제버튼 동작
	$("#btnDelete").click(function() {
		$(location).attr("href", "/board/free/delete?free_board_no=${viewBoard.free_board_no }");
	});
	
	// 댓글 입력
	$("#btnCommInsert").click(function() {

		$form = $("<form>").attr({
			action: "comment/insert",
			method: "post"
		}).append(
			$("<input>").attr({
				type:"hidden",
				name:"free_board_no",
				value:"${viewBoard.free_board_no }"
			})
		).append(
			$("<input>").attr({
				type:"hidden",
				name:"member_id",
				value:"${sessionScope.member_id }"
			})
		).append(
			$("<textarea>")
				.attr("name", "free_board_content")
				.css("display", "none")
				.text($("#commentContent").val())
		);
		$(document.body).append($form);
		$form.submit();
		
	});
	
});


//댓글 삭제
function deleteComment(free_board_comment_no) {
	$.ajax({
		type: "post"
		, url: "comment/delete"
		, dataType: "json"
		, data: {
			free_board_comment_no: free_board_comment_no
		}
		, success: function(data){
			if(data.success) {
				
				$("[data-commentno='"+free_board_comment_no+"']").remove();
				
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
<td class="info">글번호</td><td colspan="3">${viewBoard.free_board_no }</td>
</tr>

<tr>
<td class="info">제목</td><td colspan="3">${viewBoard.free_board_title }</td>
</tr>

<tr>
<td class="info">아이디</td><td>${viewBoard.free_board_writer }</td>
<td class="info">닉네임</td><td>${member_nick }</td>
</tr>

<tr>
<td class="info">조회수</td><td>${viewBoard.free_board_hit }</td>
<td class="info">추천수</td><td id="recommend">[ 추후 추가 ]</td>
</tr>

<tr>
<td class="info">작성일</td><td colspan="2">${viewBoard.free_board_written_date }</td>
</tr>

<tr><td class="info"  colspan="4">본문</td></tr>

<tr><td colspan="4">${viewBoard.free_board_content }</td></tr>

<tr>
<td class="info">첨부파일</td><td colspan="3"><a href="/board/free/download?fileno=${boardFile.free_board_file_no }">${boardFile.free_board_file_origin_name }</a>
</td>
</tr>

</table>

<%-- <div>
<h2>파일</h2>
<a href="/board/free/download?fileno=${boardFile.free_board_file_no }">${boardFile.free_board_file_origin_name }</a>
</div>
 --%>
<div class="text-center">	
	<button id="btnList" class="btn btn-primary">목록</button>
	<c:if test="${member_id eq viewBoard.free_board_writer }">
	<button id="btnUpdate" class="btn btn-info">수정</button>
	<button id="btnDelete" class="btn btn-danger">삭제</button>
	</c:if>
</div>

<!-- 로그인상태 -->
<c:if test="${login }">
<!-- 댓글 입력 -->
<div class="form-inline text-center">
	<input type="text" size="10" class="form-control" id="commentWriter" value="${member_nick }" readonly="readonly"/>
	<textarea rows="2" cols="60" class="form-control" id="commentContent"></textarea>
	<button id="btnCommInsert" class="btn">입력</button>
</div>	<!-- 댓글 입력 end -->
</c:if>
 
 
<!-- 댓글 리스트 -->
<table class="table table-striped table-hover table-condensed">
<thead>
<tr>
	<th style="width: 5%;">번호</th>
	<th style="width: 10%;">작성자</th>
	<th style="width: 50%;">댓글</th>
	<th style="width: 20%;">작성일</th>
	<th style="width: 5%;"></th>
</tr>
</thead>
<tbody id="commentBody">
<c:forEach items="${commentList }" var="comment">
<tr data-commentno="${comment.free_board_comment_no }">
	<td>${comment.free_board_comment_no}</td>
	<td>${comment.member_id }</td><!-- 닉네임으로 해도 좋음 -->
	<td>${comment.free_board_content }</td>
	<td>${comment.free_board_comment_date }</td>
	<td>
		<c:if test="${sessionScope.member_id eq comment.member_id }">
		<button class="btn btn-default btn-xs"
			onclick="deleteComment(${comment.free_board_comment_no  });">삭제</button>
		</c:if>
	</td>
	
</tr>
</c:forEach>
</tbody>
</table>	<!-- 댓글 리스트 end -->

<c:import url="/WEB-INF/views/layout/footer.jsp" />
