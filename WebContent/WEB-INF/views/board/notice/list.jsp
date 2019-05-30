<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>   

<c:import url="/WEB-INF/views/layout/header.jsp" />

<script  type="text/javascript">

$(document).ready(function(){

	
	$("#btnWrite").click(function() {
		location.href="/board/notice/write";
	});
	
	$("#btnSearch").click(function() {
		location.href="/board/notice/list?search="+$("#search").val();
	});
	

	
})

</script>


<style type="text/css">
table, th {
	text-align: center;
}

.container {
	border-left: 1px solid #eee;
	border-right: 1px solid #eee;
}



</style>

<div class="wrap">

<div class="container" style="margin-top:40px;">
<div style="margin-top : 100px; ">
<h1>공지사항</h1>
</div>
<hr>


<c:if test="${res eq 1 }"><!-- 1이면 보이는 버튼  -->
<div style="padding-right:50px;">
		<button style="float: right;" id="btnWrite">글쓰기</button>
</div>
</c:if>

<br>
<table class="table table-hover table-condensed ">
<thead>
	<tr>
		<th style="width: 10%;">번호</th>
		<th style="width: 45%;">제목</th>
		<th style="width: 15%;">작성자</th>
		<th style="width: 10%;">조회수</th>
		<th style="width: 20%;">작성일</th>
		<!--  너비가 총 100퍼센트가 되도록  -->
	</tr>
</thead>
<c:forEach items="${list}" var="i">
	<tr>
		<td>${i.notice_no }</td>
		<td><a href="/board/notice/view?notice_no=${i.notice_no }">${i.notice_title }</a></td>
		<td>${i.notice_writer }</td>
		<td>${i.notice_hit }</td>
		<td><fmt:formatDate value="${i.notice_written_date }" pattern="yyyy-MM-dd" /></td>
	</tr>
</c:forEach>
</table>


</div>
<c:import url="/WEB-INF/views/board/notice/paging.jsp" />
<br>
<div class="form-inline text-center">
	<input class="form-control" type="text" id="search" />
	<button id="btnSearch" class="btn">검색</button>
</div> 

</div>
<br>
<br>
<br>
<br>

<c:import url="/WEB-INF/views/layout/footer.jsp" />


