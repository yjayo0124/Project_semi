<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<script type="text/javascript">
$(document).ready(function() {
	

	$("#btnSearch").click(function() {
		location.href="/board/boast/list?search="+$("#search").val();
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
	height: 40px;
	margin: auto;
}
#btnWrite{
	display: scroll; 
	position: fixed;
	margin-left: 800px;
	bottom: 100px;
	left: 50%;
}
#writeimg{
	height: 100px;
	width: 100px;
}

/* 검색창 css */

</style>

<h1>자랑게시판</h1>
<hr>

<table class="table table-striped table-hover table-condensed">

<thead  style="background: #337AB7; color: white;">
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
		<td>${i.boast_board_no }</td>
		<td><a href="/board/boast/view?boast_board_no=${i.boast_board_no }">${i.boast_board_title }</a></td>
		<td>${i.boast_board_writer }</td>
		<td>${i.boast_board_hit }</td>
		<td><fmt:formatDate value="${i.boast_board_written_date }" pattern="yyyy-MM-dd" /></td>
	</tr>
</c:forEach>
</tbody>

</table>

<div id="pagingBox">
<c:import url="/WEB-INF/views/layout/boastpaging/paging.jsp" />

<div id="btnBox">
	<button id="btnWrite"></button>
</div>
</div>

<div class="form-inline text-center">
	<input class="form-control" type="text" id="search" />
</div> 
	<a id="btnWrite" href="/board/boast/write"><img id="writeimg" src="/imgs/write.png"></a>



  
<c:import url="/WEB-INF/views/layout/footer.jsp" />
