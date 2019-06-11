<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:import url="/WEB-INF/views/layout/header.jsp" />

<!-- 썸머 노트 -->
<!-- include libraries(jQuery, bootstrap) -->

<!-- <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet"> -->

<!-- <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> --> 

<!-- <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>  -->


<!-- include summernote css/js -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>
<!-- summer note korean language pack -->
<script src="/resources/summernote/lang/summernote-ko-KR.js"></script>



<script  type="text/javascript">

$(document).ready(function(){

	$('#summernote').summernote({
		height: 300,          // 기본 높이값
	    minHeight: null,      // 최소 높이값(null은 제한 없음)
	    maxHeight: null,      // 최대 높이값(null은 제한 없음)
	    focus: true,          // 페이지가 열릴때 포커스를 지정함
	    lang: 'ko-KR'         // 한국어 지정(기본값은 en-US)
	});
	
	
	$("#btnSubmit").click(function() {
		
		$("form").submit();
		
	});
	
	//취소버튼 동작
	$("#btnCancel").click(function() {
		history.go(-1);
	});
	

	
})

</script>
<style>
#btnSubmit{
   width:100px;
   height: 40px;
   background: #474e60;
   font-size: 13px;
   color: #fff;
   border: solid 2px;
   border-radius: 1px;
}
#btnCancel{
   width:100px;
   height: 40px;
   background: #a7a7a2;
   font-size: 13px;
   color: #fff;
   border: solid 2px;
   border-radius: 1px;
}

</style>
<div class="wrap">

<div class="container" style="position: relative; width: 1000px; margin-left:270px; ">


<div style="width: 800px;">
<form action="/board/notice/write" method="POST" class="form-horizontal">
	<div class="form-group">
		<div class="col-sm-12"><h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;게시글 작성</h2></div>
	</div>
	<div class="form-group">
		<label for="writer" class="col-sm-2 control-label">작성자</label>
		<div class="col-sm-10">${member_nick }</div>
	</div>
	<div class="form-group ">
		<label for="notice_title" class="col-sm-2 control-label">제목</label>
		<div class="col-sm-10"><input type="text" name="notice_title" style="width:100%;"/></div>
	</div>
	 <div class="form-group">
        <label for="notice_content" class="col-sm-2 control-label">내용입력</label>
        <div class="col-sm-10">
          <textarea name="notice_content" id="summernote"></textarea>
        </div>
      </div>
</form>
</div>


<div class="form-group">
	<div class="col-sm-offset-2 col-sm-10">	
		<button type="button" id="btnSubmit">작성</button>
		<button type="button" id="btnCancel">취소</button>
	</div>
</div>
</div>
</div>

<br><br><br><br>
<c:import url="/WEB-INF/views/layout/footer.jsp" />


