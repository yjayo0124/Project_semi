<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<!-- header -->
	<c:import url="/WEB-INF/views/layout/header.jsp" />

<!-- jQuery 2.2.4 -->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.2.4.js"></script>
	
<script type="text/javascript">
	$(document).ready(function() {
		
			$('.form').show(); //페이지를 로드할 때 표시할 요소
			$('.form2').hide(); //페이지를 로드할 때 숨길 요소
			$('.show3').hide(); //페이지를 로드할 때 숨길 요소
		
		$('.next1').click(function(){
			$('.form').show(); //클릭 시 첫 번째 요소 표시
			$('.form2').hide(); //클릭 시 두 번째 요소 숨김
			$('.show3').hide(); //페이지를 로드할 때 숨길 요소
			return false;
		});
			
		$('.next2').click(function(){
			$('.form').hide(); //클릭 시 첫 번째 요소 숨김
			$('.form2').show(); 
			$('.show3').hide(); 
		
		return false;
		});
	});
	
	$(document).ready(function() {
		//글쓰기 버튼 누르면 이동
		$("#btnUpdate").click(function() {
			location.href="/member/update";
		});
		
		$("#btnDelete").click(function() {
			location.href="/member/delete";
		});
	});
	

		
</script>	

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

.next1:hover {	color:white; 
				background:blue;
				margin-left:150px;
				width: 90px;
				height:20px;

					}
					
					
.next1{
				margin-left:150px; 
				width: 90px; 
				height:20px;
				
					}

.next2:hover {	color:white; 
				background:blue;
				margin-left:150px;
				width: 90px;
				height:20px;

					}
					
					
.next2{
				margin-left:150px; 
				width: 90px; 
				height:20px;
				
					}

.form2{

	background:silver;
	margin-top:100px;
	margin-left: 450px;
	width:800px;
	height:400px;
	
}

.pass_check{
	

}
</style>


<h3 style="margin-top:70px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
마이페이지</h3>
<hr>

<div class="next1" >회원정보수정</div>
<div class="next2" >회원탈퇴</div>





<form action="/member/mypage" method="post" class="form">
	<div class="join_content">

		<div class="row_group">
			<h3 class="join_title">
			<label for="name">이름</label>
			</h3>
			<span class="intext"> <input type="text" id="member_name"
				name="member_name" class="inputtext" value="${member.member_name }" maxlength="40" />
			</span> <span class="error" id="nameMsg" role="alert"> 필수 정보입니다 </span>
			
			<h3 class="join_title">
			<label for="id">아이디</label>
			</h3>
			<span class="intext"> <input type="text" id="member_id"
				name="member_id" class="inputtext" value= "${member.member_id }" maxlength="20" />
			</span>
			
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

			<h3 class="join_title">
				<label for="birthday">생년월일</label>
			</h3>
			<span class="intext"> <input type="date" id="member_birthday"
				name="member_birthday" class="inputtext" value=${member.member_birthday }/>
			</span> 
			
			
			<h3 class="join_title">
				<label for="gender">성별</label>
			</h3>
			<span class="intext"> <input type="text" id="member_gender"
				name="member_gender" class="inputtext" value=${member.member_gender }/>
			</span>

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
				<button type="button" id="btnUpdate" class="btn_type">
					<span>변경하기</span>
				</button>
			</div>
		</div>
	
</form>

<form action="/member/mypagedelete?member_id=${member.member_id } " method="post" class="form2">

<div class="pass_check">


현재 비밀번호 확인
<input type="password" id="password_check" name="password_check"/>
	<button id="btnDelete" >
		<span>제출</span>
	</button>
</div>

</form>

<c:import url="/WEB-INF/views/layout/footer.jsp" />

