<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:import url="/WEB-INF/views/layout/header.jsp" />

<style type="text/css">
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

#logtable{

width:1200px; margin-left:400px; margin-top:70px;
}


</style>

<h3 style="margin-top:70px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
로그인기록</h3>
<hr>

<div class="next1" ><a href="/member/update?member_id=${member_id }" >회원정보수정</a></div>
<div class="next2" ><a href="/member/mypagedelete">회원탈퇴</a></div>
<div class="next2" ><a href="/member/log">로그인기록</a></div>




<table class="table table-hover table-condensed" id="logtable" style="margin-top:20px;">
<thead style="background: #337AB7; color: white;" >
	<tr>
		<th style="width: 10%;">시간</th>
		<th style="width: 10%;">아이피</th>
		<th style="width: 5%;">아이디</th>
	</tr>
</thead>
<tbody>
<c:forEach items="${list}" var="i">
	<tr>
<%-- 		<td><a href="/board/free/view?free_board_no=${i.free_board_no }">${i.free_board_title }</a></td> --%>
		<td>${i.logintime }</td>
		<td>${i.loginip }</td>
		<td>${i.member_id }</td>
	</tr>
</c:forEach>
</tbody>
</table>
<div id="pagingBox" style="margin-left:50px;">
<c:import url="/WEB-INF/views/layout/freepaging/paging.jsp" />

<c:import url="/WEB-INF/views/layout/footer.jsp" />
