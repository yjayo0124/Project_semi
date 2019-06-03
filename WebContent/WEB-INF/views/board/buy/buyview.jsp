<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<style type="text/css">
/* #img {
	
	width: 50px;
	height: 50px;	
	float : left;
}

div 1{
	
	float: right;
	
}

div.2 {
	float : left;
} */

</style>


<script type="text/javascript">
$(document).ready(function() {
	//목록버튼 동작
	$("#btnList").click(function() {
		$(location).attr("href", "/buy/list");
	});
	
	//수정버튼 동작
	$("#btnUpdate").click(function() {
		$(location).attr("href", "/buy/update?boardno=${viewBoard.boardno }");
	});

	//삭제버튼 동작
	$("#btnDelete").click(function() {
		$(location).attr("href", "/buy/delete?boardno=${viewBoard.boardno }");
	});
});
</script>



<h1 class="pull-left">${viewBoard.title }</h1><br><br><br><br>
<h5 class="pull-left">작성일 : ${viewBoard.writtendate }</h5>
<div class="text-right">	
	<button id="btnList" class="btn btn-primary">목록</button>
	<c:if test="${member_id eq viewBoard.writer }">
	<button id="btnUpdate" class="btn btn-info">수정</button>
	<button id="btnDelete" class="btn btn-danger">삭제</button>
	</c:if>
</div>
<hr>



<!-- 썸네일  -->


<img src="/upload/${buyFile.storedName }" width="350px" height="350px"></img>








<!-- 아이디 필요없음  --> 
<%--
<td class="info">닉네임</td><td>${member_nick }</td>
</tr>

<tr>
<td class="info">조회수</td><td>${viewBoard.hit }</td> --%>
<%-- <td class="info">추천수</td><td id="recommend">${viewBoard.recommend }</td> 
</tr>
--%>


<c:if test="${viewBoard.direct eq 'direct'}" >

거래유형 : 직거래<br>

</c:if>



<c:if test="${viewBoard.delivery eq 'delivery' }">

거래유형 : 배달거래<br>

</c:if>


가격 :  ${viewBoard.price } <br>




<!-- 폰 동의 -->

<div id="2">
<c:if test="${viewBoard.phoneAgree eq 'T' }"> 
폰 번호 : ${member_phone }
</c:if>
</div>


<table class="table table-bordered">


<tr><td colspan="4">${viewBoard.content }</td></tr>



</table>


<%-- 다운로드 굳이 필요없음 
<div>
<a href="/buy/download?fileno=${buyFile.fileno }">${buyFile.originName }</a>
</div>
 --%>





<c:import url="/WEB-INF/views/layout/footer.jsp" />


