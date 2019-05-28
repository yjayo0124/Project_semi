<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<script type="text/javascript">
$(document).ready(function() {
	//페이지 첫 접속 시 입력창으로 포커스 이동
	$("input").eq(0).focus();
	
	//패스워드 입력 창에서 엔터 입력 시 form submit
	$("input").eq(1).keydown(function(key) {
		if(key.keyCode == 13) {
			$(this).parents("form").submit();
		}
	})

	//로그인 버튼 클릭 시 form submit
	$("#btnJoin").click(function() {
		$(this).parents("form").submit();
	})
	
	//취소 버튼 누르면 뒤로가기
	$("#btnCancel").click(function() {
		history.go(-1);
	})
});
</script>

<div id="joinhead">
<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;회원가입</h3>
<hr>
</div>
<form action="/member/join" method="post" class="form-horizontal">
	<div class="form-group">
		<label for="member_id" class="col-sm-3 col-sm-offset-1 control-label">아이디</label>
		<div class="col-sm-5">
		<input type="text" id="member_id" name="member_id" 
			class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label for="member_pw" class="col-sm-3 col-sm-offset-1 control-label">비밀번호</label>
		<div class="col-sm-5">
		<input type="text" id="member_pw" name="member_pw" 
			class="form-control"/>
		</div>
	</div>

	<div class="form-group">
		<label for="member_nick" class="col-sm-3 col-sm-offset-1 control-label">닉네임</label>
		<div class="col-sm-5">
		<input type="text" id="member_nick" name="member_nick" 
			class="form-control"/>
		</div>
	</div>
	
	<div class="form-group">
		<label for="member_name" class="col-sm-3 col-sm-offset-1 control-label">이름</label>
		<div class="col-sm-5">
		<input type="text" id="member_name" name="member_name" 
			class="form-control"/>
		</div>
	</div>

	<div class="form-group">
		<label for="member_gender" class="col-sm-3 col-sm-offset-1 control-label">성별</label>
		<div class="col-sm-5">
		<input type="text" id="member_gender" name="member_gender" 
			class="form-control"/>
		</div>
	</div>

	<div class="form-group">
		<label for="member_email" class="col-sm-3 col-sm-offset-1 control-label">이메일</label>
		<div class="col-sm-5">
		<input type="text" id="member_email" name="member_email" 
			class="form-control"/>
		</div>
	</div>
	
	<div class="form-group">
		<label for="member_birthday" class="col-sm-3 col-sm-offset-1 control-label">생년월일</label>
		<div class="col-sm-5">
		<input type="Date" id="member_birthday" name="member_birthday" 
			class="form-control"/>
		</div>
	</div>
	

	<div class="form-group">
		<label for="member_phone" class="col-sm-3 col-sm-offset-1 control-label">휴대전화</label>
		<div class="col-sm-5">
		<input type="text" id="member_phone" name="member_phone" 
			class="form-control"/>
		</div>
	</div>

	<div class="col-sm-offset-4">
		<button type="button" id="btnJoin" class="btn btn-primary">가입하기</button>
		<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
	</div>
</form>

<c:import url="/WEB-INF/views/layout/footer.jsp" />
