<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/views/layout/header.jsp" />
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.2.4.js"></script>
<style>
.error {
	font-size: 10px;
	color: red;
}

.join_content {
	margin: 0 auto;
	max-width: 335px;
	min-width: 200px;
}

.row_group {
	overflow: hidden;
	width: 100%;
}

.join_title {
	margin: 19px 0 8px;
	font-size: 14px;
	font-weight: 700;
}

.inputtext {
	border: none;
	display: block;
	position: relative;
	width: 100%;
	height: 29px;
}

.intext, .genderdiv {
	display: block;
	position: relative;
	width: 100%;
	height: 51px;
	border: solid 1px #dadada;
	padding: 10px 14px 10px 14px;
	background: #fff;
	box-sizing: border-box;
	vertical-align: top;
}

.gen {
	width: 100%;
	height: 29px;
	font-size: 15px;
	line-height: 18px;
	color: #000;
	border: none;
	border-radius: 0;
	height: auto;
	margin-top: 3px;
}

.btnarea {
	margin: 30px 0 9px;
}

.btn_type {
	display: block;
	width: 100%;
	padding: 21px 0 17px;
	font-size: 20px;
	font-weight: 700;
	text-align: center;
	cursor: pointer;
	box-sizing: border-box;
}
</style>


<script type="text/javascript">
	$(document).ready(function() {
		//페이지 첫 접속 시 입력창으로 포커스 이동
		$("input").eq(0).focus();

		//가입 버튼 클릭 시 form submit
		$("#btnJoin").click(function() {
			$(this).parents("form").submit();
		})

	});

	//id체크
	function idcheck() {
		var memId = $('#member_id').val();
		$.ajax({
			type : 'POST',
			url : '/member/idcheck',
			data : {
				"member_id" : $('#member_id').val()
			},
			dataType : 'json',
			success : function(data) {
				console.log(1)
				if( data.check ) {
					console.log(2)
					$('#idMsg').html("사용가능한 아이디입니다").css("color", "blue");
				} else {
					console.log(3)
					$('#idMsg').html("중복되거나 이미 있는 아이디입니다").css("color", "red");				
				}
				console.log(4)
			
// 				if ((data.check) == true) {
// 					$('#idMsg').html("사용가능한 아이디입니다").css("color", "blue");
// 				} else if ($(data.check) == false){
// 					console.log(data);
// 					alert(JSON.stringify(data.check));
// 					$('#idMsg').html("중복되거나 이미 있는 아이디입니다").css("color", "red");
// 				}else{
// 					console.log(data);
// 					alert(JSON.stringify(data.check));
// 				}
			}

		})
	}

	$(function() {
		$('.error').hide();

 		$('#member_id').focus(function() {
 			$('#idMsg').html("")
 		});
 		
 		$('#member_id').blur(
				function() {
				$('#idMsg').show();
					if ($('#member_id').val() === ''
							|| $('#member_id').val() === null) {
						$('#idMsg').html("필수 정보입니다").css("color", "red");	
					} else {
						idcheck();
					}
				}) 

		$('#member_pw1').blur(
				function() {
					if ($('#member_pw1').val() === ''
							|| $('#member_pw1').val() === null) {
						$('#pwMsg1').show();
					} else {
						$('#pwMsg1').hide();
					}
				})

		$('#member_pw2').blur(function() {
			$('#pwMsg2').show();
		})

		$('#member_name').blur(
				function() {
					if ($('#member_name').val() === ''
							|| $('#member_name').val() === null) {
						$('#nameMsg').show();
					} else {
						$('#nameMsg').hide();
					}
				})
		$('#member_nick').blur(
				function() {
					if ($('#member_nick').val() === ''
							|| $('#member_nick').val() === null) {
						$('#nickMsg').show();
					} else {
						$('#nickMsg').hide();
					}
				})
		$('#member_birthday').blur(
				function() {
					if ($('#member_birthday').val() === ''
							|| $('#member_birthday').val() === null) {
						$('#birthdayMsg').show();
					} else {
						$('#birthdayMsg').hide();
					}
				})
		$('#member_gender').blur(function() {
			if ($('select[name=gender]').val() == '0') {

				$('#genderMsg').show();
			} else {
				$('#genderMsg').hide();
			}
		})
		$('#member_email').blur(
				function() {
					if ($('#member_email').val() === ''
							|| $('#member_email').val() === null) {
						$('#emailMsg').show();
					} else {
						$('#emailMsg').hide();
					}
				})
		$('#member_phone').blur(
				function() {
					if ($('#member_phone').val() === ''
							|| $('#member_phone').val() === null) {
						$('#phoneMsg').show();
					} else {
						$('#phoneMsg').hide();
					}
				})

	});

	$(function() {

		//비밀번호 확인
		$('#member_pw2')
				.blur(
						function() {
							if ($('#member_pw1').val() != $('#member_pw2')
									.val()) {
								$('#pwMsg2').html("위 비밀번호와 일치하지 않습니다").css(
										"color", "red");
								$('#member_pw2').val('');
							} else if ($('#member_pw2').val() === ''
									|| $('#member_pw2').val() === null) {
								$('#pwMsg2').html("필수 정보입니다").css("color",
										"red");
							} else {
								$('#pwMsg2').html("두 비밀번호가 일치합니다").css("color",
										"blue");
							}
						})
	});

	/* $(function(){
	
	 $('#member_id').blur(function(){
	 if($('#member_id').val()==''){
	 $('#idMsg').show(); 
	 }
	 });
	 */
</script>

<form action="/member/join" method="post" class="form">
	<div class="join_content">

		<div class="row_group">
			<h3 class="join_title">
				<label for="id">아이디</label>
			</h3>
			<span class="intext"> <input type="text" id="member_id"
				name="member_id" class="inputtext" maxlength="20" />
			</span> <span class="error" id="idMsg"> 필수 정보입니다 </span>
		</div>

		<div class="row_group">
			<h3 class="join_title">
				<label for="pw1">비밀번호</label>
			</h3>
			<span class="intext"> <input type="password" id="member_pw1"
				name="member_pw1" class="inputtext" maxlength="20" />
			</span> <span class="error" id="pwMsg1" role="alert"> 필수 정보입니다 </span>
			<h3 class="join_title">
				<label for="pw2">비밀번호 확인</label>
			</h3>
			<span class="intext"> <input type="password" id="member_pw2"
				name="member_pw2" class="inputtext" maxlength="20"
				onkeyup="checkPwd()" />
			</span> <span class="error" id="pwMsg2" role="alert"> 필수 정보입니다 </span>
		</div>

		<div class="row_group">
			<h3 class="join_title">
				<label for="name">이름</label>
			</h3>
			<span class="intext"> <input type="text" id="member_name"
				name="member_name" class="inputtext" maxlength="40" />
			</span> <span class="error" id="nameMsg" role="alert"> 필수 정보입니다 </span>
			<h3 class="join_title">
				<label for="nick">닉네임</label>
			</h3>
			<span class="intext"> <input type="text" id="member_nick"
				name="member_nick" class="inputtext" maxlength="40" />
			</span> <span class="error" id="nickMsg" role="alert"> 필수 정보입니다 </span>
			<h3 class="join_title">
				<label for="birthday">생년월일</label>
			</h3>
			<span class="intext"> <input type="date" id="member_birthday"
				name="member_birthday" class="inputtext" />
			</span> <span class="error" id="birthdayMsg" role="alert"> 생년월일을
				입력해주세요 </span>
			<h3 class="join_title">
				<label for="gender">성별</label>
			</h3>
			<div class="genderdiv">
				<select id="member_gender" name="member_gender" class="gen">
					<option value="0" selected>성별</option>
					<option value="M">남자</option>
					<option value="F">여자</option>
				</select>
			</div>
			<span class="error" id="genderMsg" role="alert"> 필수 정보입니다 </span>
			<h3 class="join_title">
				<label for="email">이메일</label>
			</h3>
			<span class="intext"> <input type="email" id="member_email"
				name="member_email" class="inputtext" maxlength="100" />
			</span> <span class="error" id="emailMsg" role="alert"> 필수 정보입니다 </span>
			<h3 class="join_title">
				<label for="phone">휴대전화</label>
			</h3>
			<span class="intext"> <input type="text" id="member_phone"
				name="member_phone" class="inputtext" maxlength="16" />
			</span> <span class="error" id="phoneMsg"> 필수 정보입니다 </span>
			<div class="btnarea">
				<button type="button" id="btnJoin" class="btn_type">
					<span>가입하기</span>
				</button>
			</div>
		</div>
	</div>


</form>
<c:import url="/WEB-INF/views/layout/footer.jsp" />
