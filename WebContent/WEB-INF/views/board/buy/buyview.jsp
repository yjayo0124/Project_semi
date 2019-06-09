<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<style type="text/css">


.total {
	margin : 0 auto;
	width : 75%;
}
.sumnail{
	
	
	margin : 50px;
	width: 40%;
	float : left;
	position : relative; 
}

.info {
	margin : 80px;
	font-size : 16px;
}

.notice {
	font-size : 18px;
}

#hr {
	margin-left: 450px ;
	margin-right: 450px ; 
	margin-top: 0px ;
	margin-bottom: 0px ;
}

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


<div class="total">


<h1 class="pull-left">${viewBoard.title }</h1><br><br><br><br>
<h5 class="pull-left">작성일 : ${viewBoard.writtendate }</h5>
<div class="text-right">	
	<button id="btnList" class="btn btn-success btn-sm">목록</button>
	<c:if test="${member_id eq viewBoard.writer }">
	<button id="btnUpdate" class="btn btn-success btn-sm">수정</button>
	<button id="btnDelete" class="btn btn-success btn-sm">삭제</button>
	</c:if>
</div>
<hr>



<!-- 썸네일  -->

<div class="sumnail" >
<img src="/upload/${buyFile.storedName }" width="350px" height="350px"></img>
</div>







<!-- 아이디 필요없음  --> 
<%--
<td class="info">닉네임</td><td>${member_nick }</td>
</tr>

<tr>
<td class="info">조회수</td><td>${viewBoard.hit }</td> --%>
<%-- <td class="info">추천수</td><td id="recommend">${viewBoard.recommend }</td> 
</tr>
--%>

<div class = "info">
<div class = "direct">
<c:if test="${viewBoard.direct eq 'direct'}" >

거래유형 : 직거래<br>

</c:if>
</div>

<div class = "delivery">
<c:if test="${viewBoard.delivery eq 'delivery' }">

거래유형 : 배달거래<br>

</c:if>
</div>

<div class ="price">
가격 :  ${viewBoard.price } <br>
</div>



<!-- 폰 동의 -->

<div class="phoneAgree">
<c:if test="${viewBoard.phoneAgree eq 'T' }"> 
폰 번호 : ${member_phone }
</c:if>
</div>

</div>

<div class = "notice">
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
<table class="table table-striped table-hover table-condensed ">
<thead>
<tr class="success">
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
	<td>${comment.writtenDate }</td>
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
<strong>댓글작성은 로그인이 필요합니다</strong><br>
<button onclick='location.href="/member/login";'>로그인</button>
<button onclick='location.href="/member/join";'>회원가입</button>
</c:if>

<!-- 로그인상태 -->
<c:if test="${login }">
<!-- 댓글 입력 -->
<div class="form-inline text-center">
	<input type="text" size="7" class="form-control" id="commentWriter" value="${member_nick }" readonly="readonly"/>
	<textarea rows="3" cols="110" class="form-control" id="commentContent" placeholder="내용을 입력해 주세요"></textarea>
	<button id="btnCommInsert" class="btn btn-default">입력</button>
</div>	<!-- 댓글 입력 end -->
</c:if>
 
</div>


<!-- 이전글 다음글 -->



<hr id = "hr2">
<div id = "next">
<c:if test="${prev_next.next eq 0 }">
	다음글없음
</c:if>
<c:if test="${prev_next.next ne 0 }">
<span class="glyphicon glyphicon-menu-up">	<a href="/buy/view?boardno=${prev_next.next }">
	다음글 : ${prev_next_name.next }
	</a>
	</span>
</c:if>
</div>


<hr id = "hr2">
<div id = "back">
<c:if test="${prev_next.prev eq 0 }">
	이전글없음
</c:if>
<c:if test="${prev_next.prev ne 0 }">

<span class="glyphicon glyphicon-menu-down"><a href="/buy/view?boardno=${prev_next.prev}">	
	이전글 : ${prev_next_name.prev }
	</a>
	</span>
</c:if>
</div>
<hr id = "hr2">


</div> <!-- total end -->

<c:import url="/WEB-INF/views/layout/footer.jsp" />


