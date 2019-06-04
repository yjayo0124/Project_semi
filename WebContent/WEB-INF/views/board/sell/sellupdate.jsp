<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<script type="text/javascript">
$(document).ready(function() {
	
	//작성버튼 동작
	$("#btnUpdate").click(function() {
		
		
		
		//form submit 수행
		$("form").submit();
	});
	
	//취소버튼 동작
	$("#btnCancel").click(function() {
		history.go(-1);
	});
});
</script>






<div class="container">

<h3>수정하기</h3>
<hr>

<div>
<form action="/buy/update" method="post" enctype="multipart/form-data">
<input type="hidden" name="boardno" value="${viewBoard.boardno }" />

<table class="table table-bordered">
<tr><td class="info">아이디</td><td>${member_id }</td></tr>
<tr><td class="info">닉네임</td><td>${member_nick }</td></tr>
<tr><td class="info">제목</td><td><input type="text" name="title" style="width:100%" value="${viewBoard.title }"/></td></tr>
<tr><td class="info" colspan="2">본문</td></tr>
<tr><td colspan="2">
	<textarea id="content" name="content" rows="10" cols="100">${viewBoard.content }</textarea>
</td></tr>
</table>

<label>기존 첨부파일 : </label>${boardFile.originName }<br>
<label>첨부파일 : <input type="file" name="file" /></label>

</form>
</div>

<div class="text-center">	
	<button type="button" id="btnUpdate" class="btn btn-info">수정 적용</button>
	<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
</div>
</div>




<c:import url="/WEB-INF/views/layout/footer.jsp" />





