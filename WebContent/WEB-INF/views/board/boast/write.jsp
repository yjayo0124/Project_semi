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
	$(document).on('mouseover', '.MainMenu span', function() {
		$('.SubMenu').slideDown(300);
	});
	$(document).on('mouseover', 'div', function() {
		if (!$(this).hasClass('MainMenu')) {
			$('.SubMenu').slideUp(300);
		}
	});
	
	
	$(document).ready(function() {
        
        $('#summernote').summernote({
           height: 300,          // 기본 높이값
            minHeight: null,      // 최소 높이값(null은 제한 없음)
            maxHeight: null,      // 최대 높이값(null은 제한 없음)
            focus: true,          // 페이지가 열릴때 포커스를 지정함
            lang: 'ko-KR'         // 한국어 지정(기본값은 en-US)
        });
        
     }) 
</script>

<!-- 스마트 에디터 라이브러리 추가 -->
<!-- <script type="text/javascript" src="/resources/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>
 -->
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

<style type="text/css">
#content {
	width: 98%;
}

#smart_editor2{
	margin : 0 auto;
}
#btnWrite {
	width: 100px;
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

<div class="container">

<h3>게시글 쓰기</h3>
<hr>

<div>
<form action="/board/boast/write" method="post" enctype="multipart/form-data">
<table class="table table-bordered">
<tr><td class="info">아이디</td><td>${member_id }</td></tr>
<tr><td class="info">닉네임</td><td>${member_nick }</td></tr>
<tr><td class="info">제목</td><td><input type="text" name="boast_board_title" style="width:100%"/></td></tr>
<tr><td class="info" colspan="2">본문</td></tr>
<tr><td colspan="2"><textarea id="summernote" name="boast_board_content" rows="10" cols="100"></textarea></td></tr>
</table>

<label>첨부파일 : <input type="file" name="file" /></label>
</form>
</div>

<div class="text-center">	
	<button type="button" id="btnWrite">작성</button>
	<button type="button" id="btnCancel">취소</button>
</div>
</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />


