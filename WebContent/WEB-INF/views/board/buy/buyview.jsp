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
	
	
	
	// 댓글 입력
	$("#btnCommInsert").click(function() {
		// 게시글 번호.... ${viewBoard.boardno }
	//		console.log($("#commentWriter").val());
	//		console.log($("#commentContent").val());
		
		$form = $("<form>").attr({
			action: "/comment/insert",
			method: "post"
		}).append(
			$("<input>").attr({
				type:"hidden",
				name:"boardNo",
				value:"${viewBoard.boardno }"
			})
		).append(
			$("<input>").attr({
				type:"hidden",
				name:"userid",
				value:"${sessionScope.member_id }"
			})
		).append(
			$("<textarea>")
				.attr("name", "content")
				.css("display", "none")
				.text($("#commentContent").val())
		);
		$(document.body).append($form);
		$form.submit();
		
	});
	
});
	
	

//댓글 삭제
function deleteComment(commentNo) {
	$.ajax({
		type: "post"
		, url: "/comment/delete"
		, dataType: "json"
		, data: {
			commentNo: commentNo
		}
		, success: function(data){
			if(data.success) {
				
				$("[data-commentno='"+commentNo+"']").remove();
				
			} else {
				alert("댓글 삭제 실패");
			}
		}
		, error: function() {
			console.log("error");
		}
	});
}


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


<div>
* 거래전 필독! 주의하세요! <br>
* 연락처가 없이 외부링크, 카카오톡, 댓글로만 거래할 때<br> 
* 연락처 및 계좌번호를 사이버캅과 더치트로 꼭 조회해보기 <br>
* 업체인 척 위장하여 신분증과 사업자등록증을 보내는 경우 <br>
* 고가의 물품(휴대폰,전자기기)등만 판매하고 최근(1주일 내) 게시글만 있을 때<br> 
* 해외직구로 면세받은 물품을 판매하는 행위는 불법입니다.<br>
</div>



<table class="table table-bordered">


<tr><td colspan="4">${viewBoard.content }</td></tr>



</table>


<%-- 다운로드 굳이 필요없음 
<div>
<a href="/buy/download?fileno=${buyFile.fileno }">${buyFile.originName }</a>
</div>
 --%>
 
 <div>
 <hr>
 
<!-- 댓글 리스트 -->
<table class="table table-striped table-hover table-condensed">
<thead>
<tr>
	<th style="width: 5%;">번호</th>
	<th style="width: 10%;">작성자</th>
	<th style="width: 50%;">댓글</th>
	<th style="width: 20%;">작성일</th>
	<th style="width: 5%;"></th>
</tr>
</thead>
<tbody id="commentBody">
<c:forEach items="${commentList }" var="comment">
<tr data-commentno="${comment.commentNo }">
	<td>${comment.rnum }</td>
	<td>${comment.userid }</td><!-- 닉네임으로 해도 좋음 -->
	<td>${comment.content }</td>
	<td><fmt:formatDate value="${comment.writtenDate }" pattern="yy-MM-dd hh:mm:ss" /></td>
	<td>
		<c:if test="${sessionScope.member_id eq comment.userid }">
		<button class="btn btn-default btn-xs"
			onclick="deleteComment(${comment.commentNo });">삭제</button>
		</c:if>
	</td>
	
</tr>
</c:forEach>
</tbody>
</table>	<!-- 댓글 리스트 end -->


<!-- 비로그인상태 -->
<c:if test="${not login }">
<strong>로그인이 필요합니다</strong><br>
<button onclick='location.href="/member/login";'>로그인</button>
<button onclick='location.href="/member/join";'>회원가입</button>
</c:if>

<!-- 로그인상태 -->
<c:if test="${login }">
<!-- 댓글 입력 -->
<div class="form-inline text-center">
	<input type="text" size="10" class="form-control" id="commentWriter" value="${member_nick }" readonly="readonly"/>
	<textarea rows="2" cols="60" class="form-control" id="commentContent"></textarea>
	<button id="btnCommInsert" class="btn">입력</button>
</div>	<!-- 댓글 입력 end -->
</c:if>
 
</div>



<c:import url="/WEB-INF/views/layout/footer.jsp" />


