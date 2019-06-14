<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script src="https://service.iamport.kr/js/iamport.payment-1.1.5.js" type="text/javascript"></script>

<c:import url="/WEB-INF/views/layout/header.jsp" />


<style type="text/css">

.total {
	margin : 0 auto;
	width : 75%;
}
.sumnail{
	
	
	margin : 50px;
	margin-bottom : 15px;
	width: 40%;
	float : left;
	position : relative; 
}

.info {
	margin : 80px;
	font-size : 16px;
}

.notice {
	margin-bottom : 30px;
	font-size : 18px;
	
}

#hr {
	margin-left: 450px ;
	margin-right: 450px ; 
	margin-top: 0px ;
	margin-bottom: 0px ;
}
#btnList {
width: 80px;
height: 40px;
background: #474e60;
font-size: 13px;
color: #fff;
border: solid 2px;
border-radius: 1px;
}
#btnUpdate{
	width: 80px;
	height: 40px;
	background: #1ec0ff;
	font-size: 13px;
	color: #fff;
	border: solid 2px;
	border-radius: 1px;
}
#btnDelete{
	width: 80px;
	height: 40px;
	background: #f1404b;
	font-size: 13px;
	color: #fff;
	border: solid 2px;
	border-radius: 1px;
}

#user{

	font-size : 25px;
}

#trash{
	
	font-size : 15px;
	margin-right: 10px;
}

#trashbtn{
	padding-left: 0px;
	padding-right: 0px;
	height: 21px;
	width: 19px;
	border-right-width:0px;
	border-left-width: 0px;
	border-top-width:0px;
	border-bottom-width:0px;
	background: white;
}	
	

</style>


<script type="text/javascript">
$(document).ready(function() {
	//목록버튼 동작
	$("#btnList").click(function() {
		$(location).attr("href", "/sell/list");
	});
	
	//수정버튼 동작
	$("#btnUpdate").click(function() {
		$(location).attr("href", "/sell/update?boardno=${viewBoard.boardno }");
	});

	
	
	
	// 댓글 입력
	$("#btnCommInsert").click(function() {
		// 게시글 번호.... ${viewBoard.boardno }
	//		console.log($("#commentWriter").val());
	//		console.log($("#commentContent").val());
		
		$form = $("<form>").attr({
			action: "/sell/comment/insert",
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
		, url: "/sell/comment/delete"
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

function button_event(){
	if (confirm("정말 삭제하시겠습니까??") == true){    //확인
		$(location).attr("href", "/sell/delete?boardno=${viewBoard.boardno }");
	}else{   //취소
	    return;
	}
	}

// 결제 ~

$(document).ready(function() {
	// iamport 변수 초기화
	var IMP = window.IMP;
	IMP.init('imp26692662');	// 가맹점 식별코드, 회원가입해서 직접 넣어야합니다

	// 결제 모듈 불러오기
	$("#pay").click(function() {
		requestPayment();
	});
});

// 결제 요청 - 결제 모듈 불러오기
function requestPayment() {
	IMP.request_pay({
	    pg : 'html5_inicis', //PG사 - 'kakao':카카오페이, 'html5_inicis':이니시스(웹표준결제), 'nice':나이스페이, 'jtnet':제이티넷, 'uplus':LG유플러스, 'danal':다날, 'payco':페이코, 'syrup':시럽페이, 'paypal':페이팔
	    pay_method : 'card', //결제방식 - 'samsung':삼성페이, 'card':신용카드, 'trans':실시간계좌이체, 'vbank':가상계좌, 'phone':휴대폰소액결제
	    merchant_uid : 'merchant_' + new Date().getTime(), //고유주문번호 - random, unique
	    name : '주문명:결제테스트', //주문명 - 선택항목, 결제정보 확인을 위한 입력, 16자 이내로 작성
	    amount : "${viewBoard.price }", //결제금액 - 필수항목
	    buyer_email : "${member_email }", //주문자Email - 선택항목
	    buyer_name : "${sessionScope.member_name }", //주문자명 - 선택항목
	    buyer_tel : "${member_phone}", //주문자연락처 - 필수항목, 누락되면 PG사전송 시 오류 발생
	    buyer_addr : '서울특별시 강남구 삼성동', //주문자주소 - 선택항목
	    buyer_postcode : '123-456', //주문자우편번호 - 선택항목
	    m_redirect_url : 'https://www.yourdomain.com/payments/complete' //모바일결제후 이동페이지 - 선택항목, 모바일에서만 동작
	    
	}, function(rsp) { // callback - 결제 이후 호출됨, 이곳에서 DB에 저장하는 로직을 작성한다
	    if ( rsp.success ) { // 결제 성공 로직
	        var msg = '결제가 완료되었습니다.';
	        msg += '고유ID : ' + rsp.imp_uid;
	        msg += '상점 거래ID : ' + rsp.merchant_uid;
	        msg += '결제 금액 : ' + rsp.paid_amount;
	        msg += '카드 승인번호 : ' + rsp.apply_num;
	        msg += '[rsp.success]';

	        
	        // 결제 완료 처리 로직
			//[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
			jQuery.ajax({
				url: "/pay/complete", //cross-domain error가 발생하지 않도록 동일한 도메인으로 전송
				type: 'POST',
				dataType: 'json',
				data: {
					// rsp객체를 통해 전달된 데이터를 DB에 저장할 때 사용한다
					imp_uid : rsp.imp_uid
				}
			
			}).done(function(data) {
				//[2] 서버에서의 응답 처리
				if ( data == 'success' ) {
					var msg = '결제가 완료되었습니다.';
					msg += '\n고유ID : ' + rsp.imp_uid;
					msg += '\n상점 거래ID : ' + rsp.merchant_uid;
					msg += '\n결제 금액 : ' + rsp.paid_amount;
					msg += '\n카드 승인번호 : ' + rsp.apply_num;
			        msg += '\n[done]';

					alert(msg);
					
	    		} else {
	    			//[3] 아직 제대로 결제가 되지 않았습니다.
	    			//[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
	    		}
	    	});
	        
	    } else { // 결제 실패 로직
	    	var msg = '결제에 실패하였습니다.';
	        msg += '에러내용 : ' + rsp.error_msg;
	    }
	    alert(msg);
	});
}


</script>



<div class ="total">

<h1 class="pull-left">${viewBoard.title }</h1><br><br><br><br>
<h5 class="pull-left">작성일 : ${viewBoard.writtendate }</h5>
<div class="text-right">	
	<button id="btnList">목록</button>
	<c:if test="${member_nick eq viewBoard.writer }">
	<button id="btnUpdate">수정</button>
<input type="button" id = "btnDelete" value="삭제" onclick="button_event();">
	</c:if>
</div>
<hr>



<!-- 썸네일  -->

<div class="sumnail">
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

<div class= "info">
<div class= "direct">

<c:if test="${viewBoard.direct eq 'direct'}" >

거래유형 : 직거래<br>

</c:if>
</div>

<div class = "delivery">
<c:if test="${viewBoard.delivery eq 'delivery' }">

거래유형 : 배달거래<br>

</c:if>
</div>

<div class = "price">
가격 :  ${viewBoard.price } <br>
</div>



<!-- 폰 동의 -->

<div class="phoneAgree">
<c:if test="${viewBoard.phoneAgree eq 'T' }"> 
폰 번호 : ${member_phone }
</c:if>
</div>
</div>

<div class= "notice">

* 거래전 필독! 주의하세요! <br>
* 연락처가 없이 외부링크, 카카오톡, 댓글로만 거래할 때<br> 
* 연락처 및 계좌번호를 사이버캅과 더치트로 꼭 조회해보기 <br>
* 업체인 척 위장하여 신분증과 사업자등록증을 보내는 경우 <br>
* 고가의 물품(휴대폰,전자기기)등만 판매하고 최근(1주일 내) 게시글만 있을 때<br> 
* 해외직구로 면세받은 물품을 판매하는 행위는 불법입니다.<br>
</div>

<button id="pay" class="btn btn-default">결제하기</button>
<br><br><br>
<hr>

<div class="content">
${viewBoard.content }
</div>



<%-- 다운로드 굳이 필요없음 
<div>
<a href="/buy/download?fileno=${buyFile.fileno }">${buyFile.originName }</a>
</div>
 --%>
 
 <div>
 <hr>

 
<!-- 댓글 리스트 -->
<table class="table table-condensed">
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
	<td><span class="glyphicon glyphicon-user " id="user" ></span>${member_nick }</td><!-- 닉네임으로 해도 좋음 -->
	<td>${comment.content }</td>
	<td>${comment.writtenDate }</td>
	<td>
		<c:if test="${sessionScope.member_id eq comment.userid }">
		<button id="trashbtn"><span class="glyphicon glyphicon-trash" id="trash" onclick="deleteComment(${comment.commentNo });">
		</span>
		</button>
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






<hr id = "hr2">
<div id = "back">
<c:if test="${prev_next.prev eq 0 }">
	이전글없음
</c:if>
<c:if test="${prev_next.prev ne 0 }">

<span class="glyphicon glyphicon-menu-up"><a href="/sell/view?boardno=${prev_next.prev}">	
	이전글 : ${prev_next_name.prev }
	</a>
	</span>
</c:if>
</div>
<hr id = "hr2">



<div id = "next">
<c:if test="${prev_next.next eq 0 }">
	다음글없음
</c:if>
<c:if test="${prev_next.next ne 0 }">
<span class="glyphicon glyphicon-menu-down">	<a href="/sell/view?boardno=${prev_next.next }">
	다음글 : ${prev_next_name.next }
	</a>
	</span>
</c:if>
</div>

<hr id = "hr2">






</div> <!-- total end -->

<c:import url="/WEB-INF/views/layout/footer.jsp" />


