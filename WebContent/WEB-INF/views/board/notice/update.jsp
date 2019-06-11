<%@page import="web.dto.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>   

<c:import url="/WEB-INF/views/layout/header.jsp" />

<% Notice notice = (Notice) request.getAttribute("notice"); %>

<script type="text/javascript" src="/js/httpRequest.js"></script>
<script type="text/javascript">

$(document).ready(function(){

	
	$("#btnUpdate").click(function(){
	
		$("form").submit();
	
	});
	
	
	
	$("#btnCancel").click(function() {
		history.go(-1);
	});

	
})
	

	

</script>
<style >
#btnCancel{
   width:100px;
   height: 40px;
   background: #a7a7a2;
   font-size: 13px;
   color: #fff;
   border: solid 2px;
   border-radius: 1px;
}
#btnUpdate {
width: 100px;
height: 40px;
background: #474e60;
font-size: 13px;
color: #fff;
border: solid 2px;
border-radius: 1px;
}

</style>

<div>
<div class="container" style="margin-top: 50px; margin-bottom: 350px;">


<div style="width: 800px;">
<form action="/board/notice/update" method="POST" class="form-horizontal">
	<input type="hidden" name="notice_no" value="${notice.notice_no }" />
	<div class="form-group">
		<div class="col-sm-12"><h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;게시글 수정</h2></div>
	</div>
	<div class="form-group">
		<label for="writer" class="col-sm-2 control-label">작성자</label>
		<div class="col-sm-10">${member_nick }</div>
	</div>
	<div class="form-group ">
		<label for="notice_title" class="col-sm-2 control-label">제목</label>
		<div class="col-sm-10"><input type="text" name="notice_title" value="${notice.notice_title }"/></div>
	</div>
	 <div class="form-group">
        <label for="notice_content" class="col-sm-2 control-label">내용입력</label>
        <div class="col-sm-10">
          <textarea name="notice_content" id="summernote" >${notice.notice_content }</textarea>
        </div>
      </div>
</form>
</div>



<br>
<div class="text-center">	
	<button id ="btnUpdate" >수정하기</button>
	<button id ="btnCancel"	>취소</button>
</div>



</div>
</div>


<c:import url="/WEB-INF/views/layout/footer.jsp" />
