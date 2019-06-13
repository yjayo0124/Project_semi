<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.2.4.js"></script>
	
<script type="text/javascript">
	$(document).ready(function() {
		
				$("#btnLogin").click(function() {
							if ($('#member_id').val() === ''|| $('#member_id').val() === null ) {
								
								if ($('#member_pw').val() === ''|| $('#member_pw').val() === null) {
									alert("아이디와 비밀번호를 입력해 주세요");
									
								} else if ($('#member_pw').val() != ''|| $('#member_pw').val() != null) {
									alert("아이디를 입력해 주세요");
								}
							} else if ($('#member_id').val() != '' || $('#member_id').val() != null ){
								
								if ($('#member_pw').val() === ''|| $('#member_pw').val() === null) {
									alert("비밀번호를 입력해주세요");
								}
								else if($('#member_id').val() != '' || $('#member_id').val() != null &&
										$('#member_pw').val() != ''|| $('#member_pw').val() != null){
									$.ajax({
	 									type : "post",
	 									url : "/member/login",
	 									dataType : "json",
	 									data : $('#loginform').serialize(),
	 									success : function(data) {
	 										
	 										if(data.login == true){
													$(location).attr("href","/main");
	 										}
	 										else{
													alert("로그인실패");
													$("#member_id").val('');
													$("#member_pw").val('');
												}
	 		
										},
										error : function(request, status, error) {
	 										$(this).alert(
	 												"code:" + request.status + "\n"
	 														+ "message:"
	 														+ request.responseText
	 														+ "\n" + "error:"
	 														+ error);
	 									}
									
									
									})
								}
							}
			})
			$("#btnCancel").click(function() {

				location.href="/main";	
			})

	})
</script>

<style>
#btnLogin {
	width: 80px;
	height: 40px;
	background: #474e60;
	font-size: 13px;
	color: #fff;
	border: solid 2px;
	border-radius: 1px;
}

#btnCancel {
	width: 80px;
	height: 40px;
	background: #f1404b;
	font-size: 13px;
	color: #fff;
	border: solid 2px;
	border-radius: 1px;
}
</style>
<c:import url="/WEB-INF/views/layout/header.jsp" />
<div class="wrap text-center" style="margin-top: 150px;">
	<div class="container" style="width: 420px; border-top: 2px solid black; padding: 40px; border-bottom: 1px solid black;">
		<form id="loginform" action="/member/login" method="post"
			class="form-horizontal">
			<div class="row">
				<div class="form-group">
					<label for="member_id" class="col-md-3 control-label">아이디</label>
					<div class="col-md-9">
						<input class="form-control" type="text" id="member_id"
							name="member_id" placeholder="아이디를 입력하세요" />
					</div>
				</div>
				<div class="form-group">
					<label for="member_pw" class="col-md-3 control-label">패스워드</label>
					<div class="col-md-9">
						<input class="form-control" type="password" id="member_pw"
							name="member_pw" placeholder="비밀번호를 입력하세요" />
					</div>
				</div>
			</div>
			<div class="text-center">
				<input type="button" id="btnLogin" value="로그인">
				<input type="button" id="btnCancel" value="취소">
			</div>
		</form>
		<br>
		<hr>
		<div class="text-left">
			<div class="col-md-10">아직 낚시모아의 회원이 아니신가요?</div>
			<div class="col-md-2">
				<button type="button" class="btn btn-default btn-xs"
					onclick="location='/member/join'">회원가입 가기</button>
			</div>
		</div>


	</div>
</div>
