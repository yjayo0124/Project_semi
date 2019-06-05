<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />
<script type="text/javascript">
$(document).ready(function() {
	
	//글쓰기 버튼 누르면 이동
	$("#btnWrite").click(function() {
		location.href="/sell/write";
		
	});
	
	$("#btnSearch").click(function() {
		location.href="/sell/list?select=" +$("#select").val() +"&search="+$("#search").val();
	});
	
	
});
</script>

<style type="text/css">
table, th {
	text-align: center;
}

/* 글쓰기 버튼 위치 설정 */
#pagingBox {
	position: relative;
}
#btnBox {
	position: absolute;
	top: 0;
	bottom: 0;
	right: 0;
	height: 100px;
	margin: auto;
}

select {
	width: 100px;
	height: 100px;
}

</style>


<h1>팝니다 게시판</h1>
<hr>
<div id="btnBox">
	<button id="btnWrite" class="btn btn-primary">글쓰기</button>
</div>

<br><br>
<table class="table table-striped table-hover table-condensed">

<thead>
	<tr>
		<th style="width: 10%;">번호</th>
		<th style="width: 45%;">제목</th>
		<th style="width: 15%;">작성자</th>
		<th style="width: 10%;">조회수</th>
		<th style="width: 20%;">작성일</th>
	</tr>
</thead>

<tbody>
<c:forEach items="${list}" var="i">
	<tr>
		<td><a href="/sell/view?boardno=${i.boardno }">${i.boardno }</a></td>
		<td><a href="/sell/view?boardno=${i.boardno }">${i.title }</a></td>
		<td>${i.writer }</td>
		<td>${i.hit }</td>
		<td><fmt:formatDate value="${i.writtendate }" pattern="yyyy-MM-dd" /></td>
	</tr>
</c:forEach>
</tbody>

</table>

<div id="pagingBox">
<c:import url="/WEB-INF/views/layout/buypaging/paging.jsp" />


</div>


<div class="form-inline text-center">
<select class="form-control form-control-sm" name="select" id="select">
	<option value="buy_board_title" selected>제목</option>
	<option value="buy_board_content">내용</option>
</select>
	<input class="form-control" type="text" id="search" />
	<button id="btnSearch" class="btn">검색</button>
</div> 


<c:import url="/WEB-INF/views/layout/footer.jsp" />






























