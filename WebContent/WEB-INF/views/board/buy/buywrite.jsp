<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />







<script type="text/javascript">
$(document).ready(function() {
	
	//작성버튼 동작
	$("#btnWrite").click(function() {
		
		
		//form submit 수행
		$("form").submit();
	});
	
	//취소버튼 동작
	$("#btnCancel").click(function() {
		history.go(-1);
	});
});
</script>



<h3>게시글 쓰기</h3>
<hr>

<div>
<form action="/buy/write" method="post" enctype="multipart/form-data">
<table class="table table-bordered">
<tr >
<td class="info" >아이디</td><td>${member_id }</td> 
<td class="info" >거래유형</td>
	<td>
	<select class="form-control " name="select" id="select" style="width:60%">
		<option value="direct" selected>직접 거래</option>
		<option value="delibery">택배 거래</option>
	</select> </td>
	<td class="info">거래가격 : <input type="text" name="price" style="width:30%"/> </td> 
</tr>
<tr><td class="info">닉네임</td><td colspan="4">${member_nick }</td>
	
	
</tr>
<tr><td class="info" style="width:30%">제목</td>

<td colspan="5"><input type="text" name="title" style="width:30%"/></td>


</tr>
<tr><td class="info" colspan="5">본문</td></tr>
	<td colspan="5">
	<textarea id="summernote" name="content" rows="10" cols="100"></textarea>
</td>


<tr>

<td rowspan="4" style="font-size: 20px; text-align: center;"> <br>작성자 정보 </td>
<td colspan="5">${member_name } &nbsp;&nbsp; ${member_phone }</td>

</tr>

<tr>

<td colspan="4">${member_email }  개인정보보호를 위해 KH메일만 사용 가능합니다</td>

</tr>
<tr>
<td colspan="4"><input type="checkbox" name="phoneAgree"> 연락처 노출 동의 </td>

</tr>
</table>


<label>첨부파일 : <input type="file" name="file" /></label>

</form>
</div>

<div class="text-center">	
	<button type="button" id="btnWrite" class="btn btn-info">작성</button>
	<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
</div>




<c:import url="/WEB-INF/views/layout/footer.jsp" />











