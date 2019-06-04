<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<c:import url="/WEB-INF/views/layout/header.jsp" />
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>   
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style type="text/css">
.tablename{
	width: 1080px;
	margin: 0 auto;
}
.table > thead {
      background-color: #BDBDBD;
    }
</style>
<script type="text/javascript">
$(document).ready(function(){
	$("#btnSearch").click(function() {
		location.href="/member/management?search="+$("#search").val();
	});
});

</script>
<body>
<h3 style="margin-top:70px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
회원관리</h3>
<c:if test="${member_group==1}">
<div class="tablename">
<hr>
<table class="table table-hover table-bordered ">
<thead>
	<tr>
		<th style="width: 10%;">회원번호</th>
		<th style="width: 15%;">아이디</th> 
		<th style="width: 15%;">이름</th>
		<th style="width: 10%;">성별</th>
		<th style="width: 20%;">이메일</th>
		<th style="width: 20%;">휴대전화</th>
		<th style="width: 10%;">탈퇴</th>
	</tr>
</thead>
<c:forEach items="${list}" var="i">
	<tr>
		<td>${i.member_code}</td>
		<td>${i.member_id}</td>
		<td>${i.member_name}</td>
		<td>${i.member_gender}</td>
		<td>${i.member_email}</td>
		<td>${i.member_phone}</td>
		<td><a style="text-decoration: none; color: blue;" href="/member/forceout?member_id=${i.member_id}">탈퇴</a></td>
	</tr>
</c:forEach>
</table>
</div>
</c:if>
<c:if test="${not login}"><h1>권한이 없습니다</h1></c:if>
<c:if test="${member_group ==0}"><h1>권한이 없습니다</h1></c:if>
<c:import url="/WEB-INF/views/member/paging.jsp" />
<br>
<div class="form-inline text-center">
	<input class="form-control" type="text" id="search" />
	<button id="btnSearch" class="btn">검색</button>
</div> 
</body>
</html>