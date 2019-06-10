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

<style type="text/css">

#next > a{

font-size:16px;
}

#back > a{
font-size:16px;
}

#page{
margin-left: 50px;
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
	top:530px;
	left:1100px;
}

</style>

<h3 class="pull-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;자유게시판</h3>

<c:if test="${login }">
<button id="btnRecommend" class="btn pull-right" style="margin-top: 30px;"></button>
</c:if>

<div class="clearfix"></div>
<hr>


<div class="total">


<h1 class="pull-left">${viewBoard.free_board_title }</h1><br><br><br><br>
<h5 class="pull-left">작성일 : ${viewBoard.free_board_written_date } </h5>
<h5 class="pull-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 작성자 : ${member_nick }  </h5>
<h5 class="pull-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 조회수 : ${viewBoard.free_board_hit }  </h5>
<div class="text-right">	
	<button id="btnList" class="btn btn-primary btn-sm">목록</button>
	<c:if test="${member_id eq viewBoard.free_board_writer }">
	<button id="btnUpdate" class="btn btn-primary btn-sm">수정</button>
	<button id="btnDelete" class="btn btn-primary btn-sm">삭제</button>
	</c:if>
</div>
<hr>

<div class = "notice">
${viewBoard.free_board_content }
</div>


<!-- <table class="table table-bordered" -->
<!-- style="margin-left:130px; width:1400px; margin-top:100px;"> -->
<!-- <tr> -->
<%-- <td class="info">글번호</td><td colspan="3">${viewBoard.free_board_no }</td> --%>
<!-- </tr> -->

<!-- <tr> -->
<%-- <td class="info">제목</td><td colspan="3">${viewBoard.free_board_title }</td> --%>
<!-- </tr> -->

<!-- <tr> -->
<%-- <td class="info">닉네임</td><td>${member_nick }</td> --%>
<!-- </tr> -->

<!-- <tr> -->
<%-- <td class="info">조회수</td><td colspan="4">${viewBoard.free_board_hit }</td> --%>
<!-- </tr> -->

<!-- <tr> -->
<%-- <td class="info">작성일</td><td colspan="4">${viewBoard.free_board_written_date }</td> --%>
<!-- </tr> -->

<!-- <tr><td class="info"  colspan="4">본문</td></tr> -->

<%-- <tr><td colspan="4">${viewBoard.free_board_content }</td></tr> --%>

<div id="filediv">

<c:if test="${boardFile.free_board_file_idx ne null }">
<h5>첨부파일:&nbsp;&nbsp;&nbsp;<a href="/board/free/download?free_board_no=${boardFile.free_board_no }">${boardFile.free_board_file_origin_name }</a> </h5>
</c:if>

</div>





<!-- 댓글 리스트 -->
<table class="table table-striped table-hover table-condensed"
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
<tr data-commentno="${comment.free_board_comment_no }">

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
 
<!-- 로그인상태 -->
<c:if test="${login }">
<!-- 댓글 입력 -->
<div class="form-inline text-center">
	<input type="text" size="10" class="form-control" id="commentWriter" value="${member_nick }" readonly="readonly"/>
	<textarea rows="2" cols="60" class="form-control" id="commentContent"></textarea>
	<button id="btnCommInsert" class="btn">입력</button>
</div>	<!-- 댓글 입력 end -->
</c:if>
 


<!-- 이전글, 다음글 리스트 -->
<div id = "page">


<hr id = "hr2">
<div id = "next">
<c:if test="${prev_next.next eq 0 }">
	다음글없음
</c:if>
<c:if test="${prev_next.next ne 0 }">
	<a href="/board/free/view?free_board_no=${prev_next.next }" >
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
<a href="/board/free/view?free_board_no=${prev_next.prev}">
		이전글:&nbsp;&nbsp;&nbsp;&nbsp;${prev_next_name.prev }
	</a>
</c:if>
</div>
<hr id = "hr2">
</div>

<c:import url="/WEB-INF/views/layout/footer.jsp" />
