<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<!-- header -->
	<c:import url="/WEB-INF/views/layout/header.jsp" />

<!-- jQuery 2.2.4 -->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.2.4.js"></script>
	
<script type="text/javascript">
// 	$(document).ready(function() {
		
// 			$('.form').show(); //페이지를 로드할 때 표시할 요소
// 			$('.form2').hide(); //페이지를 로드할 때 숨길 요소
// 			$('.show3').hide(); //페이지를 로드할 때 숨길 요소
		
// 		$('.next1').click(function(){
// 			$('.form').show(); //클릭 시 첫 번째 요소 표시
// 			$('.form2').hide(); //클릭 시 두 번째 요소 숨김
// 			$('.show3').hide(); //페이지를 로드할 때 숨길 요소
// 			return false;
// 		});
			
// 		$('.next2').click(function(){
// 			$('.form').hide(); //클릭 시 첫 번째 요소 숨김
// 			$('.form2').show(); 
// 			$('.show3').hide(); 
		
// 		return false;
// 		});
// 	});
	
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

.next2:hover {	 
				color:white;
				background:blue;
				margin-left:150px;
				width: 90px;
				height:20px;

					}
					
					
.next2{			margin-top:20px;
				margin-left:150px; 
				width: 90px; 
				height:20px;
				
					}

.form2{

	background:silver;
	margin-top:30px;
	margin-left: 450px;
	width:800px;
	height:400px;
	
}

.next3{			margin-top:20px;
				margin-left:150px; 
				width: 90px; 
				height:20px;
				
					}
					
.next1 > a:hover{text-decoration:none;
			color:white;}

.next2 > a:hover{text-decoration:none;
			color:white;}

</style>


<h3 style="margin-top:70px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
마이페이지</h3>
<hr>

<div class="next1" ><a href="/member/update?member_id=${member_id }">회원정보수정</a></div>
<div class="next2" ><a href="/member/mypagedelete">회원탈퇴</a></div>



<form action="/member/mypagedelete?member_id=${member.member_id } " method="post" class="form2">

<div class="pass_check" style="text-align : center;">
<br><br><br><br><br><br>
<h3>현재 비밀번호 확인</h3>
<input type="password" id="password_check" name="password_check"/>
	<button id="btnDelete" >
		<span>확인</span>
	</button>
</div>

</form>



<c:import url="/WEB-INF/views/layout/footer.jsp" />

