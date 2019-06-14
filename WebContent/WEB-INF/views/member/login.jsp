<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.2.4.js"></script>

<script type="text/javascript">

function validate() {
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
}

$(document).ready(function() {
	$('#member_pw').keydown(function(e) {
		if( e.keyCode == 13 ) {
			validate();
		}
	})
	
	$("#btnLogin").click(function() {
		validate();	
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

.idinput,.pwinput{
	float:left;
	width: 75%;
}
.idlabel,.pwlabel{
	float:left;
	width: 25%;
	text-align: center;
}
.iddiv{
	padding-top: 30px;
	float:left;
	width: 100%;
	padding-bottom: 15px;
}
.inputstyle{
    display: block;
    width: 100%;
    height: 34px;
    padding: 6px 12px;
    font-size: 14px;
    color: #555;
    background-color: #fff;
    background-image: none;
    border: 1px solid #ccc;
    border-radius: 4px;
}
.pwdiv{
	float:left;
	width: 100%;
	padding-bottom: 15px;
}
.content{
	width: 420px;
	align-content: center;
	
}
.pulldiv{
	border-top: 2px solid black;
	border-bottom: 2px solid black;
	text-align: center;
	margin: 0 auto;
	width: 420px;
	height: 300px;
}
.btngroup{
	text-align: center;
}
.bottomdiv{
	text-align: left;
	width: 100%;
}
.btomtext{
	float:left;
	width: 75%
}
.btombtn{
	float:left;
	width: 25%;
}
.max{
	padding-top: 30px;
}
.title{
	padding-bottom: 20px;
}
</style>
<c:import url="/WEB-INF/views/layout/header.jsp" />
<div class="max">
	<h1 class="title">로그인</h1>
<div class="pulldiv">
		<form id="loginform" action="/member/login" method="post">
			<div class="content">
				<div class="iddiv">
					<div class="idlabel">
						<label for="member_id">아이디</label>
					</div>
					<div class="idinput">
						<input class="inputstyle" type="text" id="member_id" name="member_id" placeholder="아이디를 입력하세요" />
					</div>
				</div>
				<div class="pwdiv">
 					<div class="pwlabel">
						<label for="member_pw">패스워드</label>
					</div>
					<div class="pwinput">
						<input class="inputstyle" type="password" id="member_pw" name="member_pw" placeholder="비밀번호를 입력하세요" />
					</div>
				</div>
				<div class="btngroup">
					<input type="button" id="btnLogin" value="로그인">
					<input type="button" id="btnCancel" value="취소">
				</div>
			</div>
		</form>
		<br>
		<hr>
		<div class="bottomdiv">
			<div class="btomtext">아직 낚시모아의 회원이 아니신가요?</div>
			<div class="btombtn">
				<button type="button" class="btn btn-default btn-xs"
					onclick="location='/member/join'">회원가입 가기</button>
			</div>
		</div>
</div>
</div>
