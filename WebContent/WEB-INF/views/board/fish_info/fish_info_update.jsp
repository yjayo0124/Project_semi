<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" />

<!-- jQuery 2.2.4 -->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.2.4.js"></script>

<!-- Bootstrap 3 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!-- include libraries(jQuery, bootstrap) -->
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

<!-- include summernote css/js -->
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>
<!-- summer note korean language pack -->

<script src="/resources/summernote/lang/summernote-ko-KR.js"></script>

<!-- summernote 코드 -->
<script type="text/javascript">
	$(document).ready(function() {
		$('#summernote').summernote({
			height : 300, // 기본 높이값
			minHeight : null, // 최소 높이값(null은 제한 없음)
			maxHeight : null, // 최대 높이값(null은 제한 없음)
			focus : true, // 페이지가 열릴때 포커스를 지정함
			lang : 'ko-KR' // 한국어 지정(기본값은 en-US)
		});
	})
</script>
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
});
</script>

<style type="text/css">
#content {
	width: 98%;
}
a:link , a:visited , a:active , a:hover {
	color: black ;
}
#btnUpdate{
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
<form action="/board/fish/info/update" method="post" enctype="multipart/form-data">
<input type="hidden" name="fish_no" value="${fishInfo.fish_no }" />

<table class="table table-bordered">
<tr><td class="info">아이디</td><td>${member_id }</td></tr>
<tr><td class="info">물고기 이름</td><td><input type="text" name="fish_name" style="width:100%" value="${fishInfo.fish_name }"/></td></tr>
<tr><td class="info">물고기 타입</td><td><input type="text" name="fish_type" style="width:100%" value="${fishInfo.fish_type }"/></td></tr>
<tr><td class="info">물고기 시즌</td><td><input type="text" name="fish_sesson" style="width:100%" value="${fishInfo.fish_sesson }"/></td></tr>
<tr><td class="info">물고기 최소체장</td><td><input type="text" name="fish_min_length" style="width:100%" value="${fishInfo.fish_min_length }"/></td></tr>
<tr><td class="info">물고기 특징</td><td><input type="text" name="fish_care" style="width:100%" value="${fishInfo.fish_care }"/></td></tr>
<tr><td class="info" colspan="2">본문</td></tr>
<tr><td colspan="2">
	<textarea id="summernote" name="fish_content" rows="10" cols="100">${fishInfo.fish_content }</textarea>
</td></tr>
</table>

<label>썸네일 이미지 : <input type="file" name="upfile"/></label><br><br>

</form>
</div>

<div class="text-center">	
	<button type="button" id="btnUpdate">수정적용</button>
	<button type="button" id="btnCancel">취소</button>
</div>
</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />

<!-- 스마트 에디터를 생성하는 코드 -->
<!-- 스마트 에디터의 스킨을 입히는 코드 -->
<!-- <script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors,
	elPlaceHolder: "content",	//<textarea>의 id 를 입력
	sSkinURI: "/resources/se2/SmartEditor2Skin.html",
	fCreator: "createSEditor2",
	htParams: {
		bUseToolbar: true, //툴바 사용여부
		bUseVerticalResizer: false, //입력창 크기 조절 바
		bUseModeChanger: true //글쓰기 모드 탭
	}
});

//<form>의 submit이 수행되면 스마트에디터의 내용이 <textarea>에 적용됨
function submitContents(elClickedObj) {
	// 에디터의 내용이 textarea에 적용된다.
	oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);

	try {
		elClickedObj.form.submit();
	} catch (e) { }
}
</script>
 -->