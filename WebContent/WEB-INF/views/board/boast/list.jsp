
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<script type="text/javascript">
$(document).ready(function() {
	
	//글쓰기 버튼 누르면 이동
	$("#btnWrite").click(function() {
		location.href="/board/boast/write";
	});
	
	$("#btnSearch").click(function() {
		location.href="/board/boast/list?select=" +$("#select").val()+"&search="+$("#search").val();
	});

	
});



//윈도우 팝업
function wrapWindowByMask(){
	 
 //화면의 높이와 너비를 구한다.
 var maskHeight = $(document).height();  
 var maskWidth = $(window).width();  

 //마스크의 높이와 너비를 화면 것으로 만들어 전체 화면을 채운다.
 $("#mask").css({"width":maskWidth,"height":maskHeight});  

 //애니메이션 효과 - 일단 0초동안 까맣게 됐다가 60% 불투명도로 간다.

 $("#mask").fadeIn(0);      
 $("#mask").fadeTo("slow",0.5);    

 //윈도우 같은 거 띄운다.
 $(".window").show();

}

$(document).ready(function(){
 //검은 막 띄우기
 $(".openMask").click(function(e){
     e.preventDefault();

     console.log($(this))
     console.log($(this).attr("href"))
     
     $.ajax({
    	type:"get"
    	, url: $(this).attr("href")
     	, dataType: "html"
     	, success: function( h ) {
     		console.log("s")
     		$(".window").html( h );
     	}
     	, error: function() {
     		console.log("e")
     	}
     });
     
     wrapWindowByMask();
 });
 

 //닫기 버튼을 눌렀을 때
 $(".window .close").click(function (e) {  
     //링크 기본동작은 작동하지 않도록 한다.
     e.preventDefault();  
     $("#mask, .window").hide();  
 });       

 //검은 막을 눌렀을 때
 $("#mask").click(function () {  
     $(this).hide();  
     $(".window").hide();  

 });      

});






</script>

<style type="text/css">
table, th {
	text-align: center;
}


/* 글쓰기 버튼 위치 설정 */
#pagingBox {
	position: relative;
}



table, th {
	text-align: center;
}

.container {
	border-left : 1px solid #eee;
	border-right : 1px solid #eee;
}


/* 검색창 css */


/* 마스크 뛰우기 */
#mask {  
    position:absolute;  
    z-index:9000;  
    background-color:#000;  
    display:none;  
    left:0;
    top:0;
} 
/* 팝업으로 뜨는 윈도우 css  */ 

.window{
    display: none;
    position:absolute;  
    left:36.5%;
    top:50px;
    margin-left: -500px;
    width:1500px;
    height:800px;
    background-color:#FFF;
    z-index:10000;
    
    overflow: scroll;
 }




#writeimg{
	height: 100px;
	width: 100px;
}

#btnWrite {
width: 100px;
height: 40px;
background: #474e60;
font-size: 13px;
color: #fff;
border: solid 2px;
border-radius: 1px;
}

#btnBox {
	
	top: 0;
	bottom: 0;
	
	
	margin-left: 1050px;
}

</style>

<div class="wrap">

<div class="container" style="margin-top:40px;">
<div style="margin-top : 100px; ">

<h1>자랑게시판</h1>
</div>
<hr>

<c:if test="${res eq 1 }">
<div id="btnBox">
	<button style="float: right;" id="btnWrite">글쓰기</button>
</div>
</c:if>

<br><br>
<table class="table table-hover table-condensed" style="margin-top:20px;">


<thead style="background: #337AB7; color: white;" >
  
	<tr>
		<th style="width: 10%;">번호</th>
		<th style="width: 45%;">제목</th>
		<th style="width: 15%;">작성자</th>
		<th style="width: 10%;">조회수</th>
		<th style="width: 20%;">작성일</th>
	</tr>
</thead>

<tbody>
<c:forEach items="${list}" var="i">
	<tr>
		<td>${i.boast_board_no }</td>
		
		<td><a href="/board/boast/view?boast_board_no=${i.boast_board_no }" class="openMask">${i.boast_board_title }</a></td>
		<td>${i.boast_board_writer }</td>
		<td>${i.boast_board_hit }</td>
		<td><fmt:formatDate value="${i.boast_board_written_date }" pattern="yyyy-MM-dd" /></td>
	</tr>
</c:forEach>
</tbody>

</table>



<div id ="container">
<div id="mask"></div>
<div class="window">
<%-- 	<c:param name="boast_board_no" value="${i.boast_board_no }"/> --%>
<%-- <c:import url="/board/boast/view"> --%>
<%-- </c:import> --%>
   <p style="text-align:center; background:#ffffff; padding:20px;"><a href="#" class="close">닫기X</a></p>
</div>
</div>




<div id="pagingBox">
<c:import url="/WEB-INF/views/layout/boastpaging/paging.jsp" />


</div>

<div class="form-inline text-center">
<select class="form-control form-control-sm" name="select" id="select">
	<option value="boast_board_title" selected>제목</option>
	<option value="boast_board_content">내용</option>
</select>
	<input class="form-control" type="text" id="search" />
	<button id="btnSearch" class="btn">검색</button>
</div> 
</div>
</div>



  
<c:import url="/WEB-INF/views/layout/footer.jsp" />
