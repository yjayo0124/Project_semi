<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:import url="/WEB-INF/views/layout/header.jsp" />


<script  type="text/javascript">

$(document).ready(function(){

	
	$("#btnSubmit").click(function() {
		
		$("form").submit();
		
	});
	
	//취소버튼 동작
	$("#btnCancel").click(function() {
		history.go(-1);
	});
	

	
})

</script>

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
		<div class="col-sm-10"><input type="text" name="notice_title"/></div>
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
		<button type="button" id="btnSubmit" class="btn btn-info">작성</button>
		<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
	</div>
</div>
</div>
</div>

<br><br><br><br>
<c:import url="/WEB-INF/views/layout/footer.jsp" />


