<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" />

<!-- include summernote css/js -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>
<!-- summer note korean language pack -->
<script src="/resources/summernote/lang/summernote-ko-KR.js"></script>


<script type="text/javascript">
$(document).ready(function() {
	
	//작성버튼 동작
	$("#btnUpdate").click(function() {
		
/* 		//스마트에디터의 내용으로 <textarea>에 적용시키기
		submitContents($("#btnUpdate"));
		 */
		//form submit 수행
		$("form").submit();
	});
	
	//취소버튼 동작
	$("#btnCancel").click(function() {
		history.go(-1);
	});
	
	 $('#summernote').summernote({
         height: 300,          // 기본 높이값
          minHeight: null,      // 최소 높이값(null은 제한 없음)
          maxHeight: null,      // 최대 높이값(null은 제한 없음)
          focus: true,          // 페이지가 열릴때 포커스를 지정함
          lang: 'ko-KR'         // 한국어 지정(기본값은 en-US)
      });
});
</script>

<style type="text/css">
#content {
	width: 98%;
}
</style>

<div class="container">

<h3>게시글 쓰기</h3>
<hr>

<div>
<form action="/board/boast/update" method="post" enctype="multipart/form-data">
<input type="hidden" id="boast_board_no" name="boast_board_no" value="${viewBoard.boast_board_no }" />

<table class="table table-bordered">
<tr><td class="info">아이디</td><td>${member_id }</td></tr>
<tr><td class="info">닉네임</td><td>${member_nick }</td></tr>
<tr><td class="info">제목</td><td><input type="text" name="boast_board_title" style="width:100%" value="${viewBoard.boast_board_title }"/></td></tr>
<tr><td class="info" colspan="2">본문</td></tr>
<tr><td colspan="2">
	<textarea id="summernote" name="boast_board_content" rows="10" cols="100">${viewBoard.boast_board_content }</textarea>
</td></tr>
</table>

<label>기존 첨부파일 : </label>${boardFile.boast_board_origin_name }<br>
<label>첨부파일 : <input type="file" name="file" /></label>

</form>
</div>

<div class="text-center">	
	<button type="button" id="btnUpdate" class="btn btn-info">수정적용</button>
	<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
</div>
</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
