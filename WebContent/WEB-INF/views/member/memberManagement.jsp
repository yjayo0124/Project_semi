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
<body>
<h3 style="margin-top:70px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
회원관리</h3>
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
	<tr>
		<td>1</td>
		<td>2</td>
		<td>3</td>
		<td>4</td>
		<td>5</td>
		<td>6</td>
		<td><a style="text-decoration: none; color: blue;" href="/member/delete">탈퇴</a></td>
	</tr>
</table>
</div>
</body>
</html>