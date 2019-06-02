<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
	
});
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
<td class="info">닉네임</td><td>[ 추후 추가 ]</td>
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

<c:import url="/WEB-INF/views/layout/footer.jsp" />
