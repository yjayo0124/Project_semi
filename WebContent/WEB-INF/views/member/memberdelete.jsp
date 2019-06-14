<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<!-- header -->
	<c:import url="/WEB-INF/views/layout/header.jsp" />
	
<script type="text/javascript">
	$(document).ready(function() {
		//form 제출
		$(".btn_type1").click(function() {
			
			$(this).parents("form").submit();
		});
		
		//취소 버튼
		$(".btn_type2").click(function() {
			location.href="/member/update?member_id=${member.member_id }";
		});
		
		
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

.btn_type1 {
	display: block;
	width: 100px;
	height:22px;
	padding: 21px 0 17px;
	font-size: 20px;
	font-weight: 700;
	text-align: center;
	cursor: pointer;
	box-sizing: border-box;
		position:absolute;
	top:700px;
	left:890px;
	height:57px;
}

.btn_type2 {
	display: block;
	width: 100px;
	height:22px;
	padding: 21px 0 17px;
	font-size: 20px;
	font-weight: 700;
	text-align: center;
	cursor: pointer;
	box-sizing: border-box;
		position:absolute;
	top:700px;
	left:1060px;
	height:57px;
}

.next1:hover {	
 				margin-left:150px; 
				width: 90px; 
				height:20px; 


					} 
					
					
.next1{			
				
				font-size:15px;
				margin-left:150px; 
				width: 90px; 
				height:20px;
				
					}

 .next2:hover {	 
 				margin-left:150px; 
 				width: 90px; 
 				height:20px; 

					} 
					
					
.next2{			
				
				font-size:15px;
				margin-top:20px;
				margin-left:150px; 
				width: 90px; 
				height:20px;
				
					}



.next1 > a:hover{ 	text-decoration:none;
				  	color:#337AB7;
				  	font-weight:bold;
						}

.next2 > a:hover{ 	text-decoration:none;
				  	color:#337AB7;
				  	font-weight:bold;
						}


.form2{


	margin-top:30px;
	margin-left: 450px;
	width:800px;
	height:400px;
	
}



#title{
		position: absolute;
		top:600px;
		left: 750px;}
</style>

<h3 style="margin-top:70px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;
회원탈퇴</h3>
<hr>

<div class="next1" ><a href="/member/update?member_id=${member_id }">회원정보수정</a></div>
<div class="next2" ><a href="/member/mypagedelete">회원탈퇴</a></div>
<div class="next2" ><a href="/member/log?member_id=${member_id }">로그인기록</a></div>
	
	
<div id="deleteform">	
<form action="/member/delete" method="post" class="form2">
<input type="hidden" name="member_id" value=${member.member_id }>

<div class="pass_check" style="text-align : center;">
<br><br><br><br><br><br>
<h3 id="title">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;회원탈퇴하시겠습니까?</h3>

	<button id="btnDelete" class="btn_type1" >
		탈퇴
	</button>
</div>

</form>

	<button id="btnCancel" class="btn_type2">취소</button>

</div>



<c:import url="/WEB-INF/views/layout/footer.jsp" />

