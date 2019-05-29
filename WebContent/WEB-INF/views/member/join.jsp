<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<style>
input{
	border: none;
}
label{ 
    display: inline-block;
    max-width: 100%;
    margin-bottom: 5px;
    font-weight: 700;
}
.join_content{
    margin: 0 auto;
    max-width: 335px;
    min-width: 200px;
    }
.row_group {
    overflow: hidden;
    width: 100%;
}
.join_title{
	margin: 19px 0 8px;
    font-size: 14px;
    font-weight: 700;
}
.inputtext{
    display: block;
    position: relative;
	width: 100%;
    height: 29px;
}

.intext, .genderdiv{
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
.intext{
    padding-right: 10px;
}
#gender{
	background: #fff;
	background-size: 20px 8px;
	webkit-background-size: 20px 8px;
}
.gen{
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
.btnarea{
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



</script>

<form action="/member/join" method="post" class="form">
<div class="join_content">
	<div class="row_group">
		<h3 class="join_title">
			<label for="id">아이디</label>
		</h3>
		<span class="intext">
			<input type="text" id="member_id" name="member_id" class="inputtext" maxlength="20"/>
		</span> 
		<span class="error">
		
		</span>
		
		<h3 class="join_title">
			<label for="pw1">비밀번호</label>		
		</h3>
		<span class="intext">
			<input type="password" id="member_pw" name="member_pw" class="inputtext" maxlength="20"/>
		</span>
		<span class="error">
		
		</span>
		<h3 class="join_title">
			<label for="pw2">비밀번호 확인</label>		
		</h3>
		<span class="intext">
			<input type="password" id="member_pw2" name="member_pw2" class="inputtext" maxlength="20" onkeyup="checkPwd()"/>
		</span>
		<span class="error">
		
		</span>
		<h3 class="join_title">
			<label for="name">이름</label>
		</h3>
		<span class="intext">
			<input type="text" id="member_name" name="member_name" class="inputtext" maxlength="40"/>
		</span>
		<span class="error">
		
		</span>
		<h3 class="join_title">
			<label for="nick">닉네임</label>
		</h3>
		<span class="intext">
			<input type="text" id="member_nick" name="member_nick" class="inputtext" maxlength="40"/>
		</span>
		<span class="error">
		
		</span>
		<h3 class="join_title">
			<label for="birthday">생년월일</label>
		</h3>
		<span class="intext">
			<input type="date" id="member_birthday" name="member_birthday" class="inputtext"/>
		</span>
		<span class="error">
		
		</span>
		<h3 class="join_title">
			<label for="gender">성별</label>
		</h3>
		<div class="genderdiv">
			<select id="gender" name="gender" class="gen">
				<option selected>성별</option>
				<option value="M">남자</option>
				<option value="F">여자</option>
			</select>
		</div>
		<h3 class="join_title">
			<label for="email">이메일</label>
		</h3>
		<span class="intext">
			<input type="email" id="member_email" name="member_email" class="inputtext" maxlength="100"/>
		</span>
		<span class="error">
		
		</span>
		<h3 class="join_title">
			<label for="phone">휴대전화</label>
		</h3>
		<span class="intext">
			<input type="text" id="member_phone" name="member_phone" class="inputtext" maxlength="16"/>
		</span>
		<span class="error">
		
		</span>
		<div class="btnarea">
			<button type="button" id="btnJoin" class="btn_type">
				<span>가입하기</span>
			</button>
		</div>
	</div>



</div>



</form>
<c:import url="/WEB-INF/views/layout/footer.jsp" />
