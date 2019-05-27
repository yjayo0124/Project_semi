<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
 src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<style type="text/css">



</style>

<script type="text/javascript">



</script>

<!-- Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>

<div id="bar">
<div id="bar_logo" class="text-center">
<a href="/main" class="h2">낚시모아~~~~~~~~~~~~~~~~~~~~~~~~~~</a>
	<a class="h4 text-light">
		<c:if test="${empty login }">
			<a href="/member/join">회원가입</a>
			<a href="/member/login">로그인</a>
		</c:if>
		<c:if test="${login }">
			<a href="/member/mypage">마이페이지</a>
			<a href="/member/logout">로그아웃</a>
		</c:if>
	<a/>
</div>

<div class="menubar" class="gnb-bar">
	<div><span></span></div>
	<ul class="gnb">
		<li id="st01">
			<a href="#">사이트소                                      개</a>
			<div>
				<ul>
				<li><a href="#">낚시모아소개</a></li>
				<li><a href="#">공지사항</a></li>
				<li><a href="#">모아이벤트</a></li>
				</ul>
			</div>
		</li>
		<li id="st02">
			<a href="#">낚시정보</a>
			<div>
				<ul>
				<li><a href="#">낚시터 검색</a></li>
				<li><a href="#">물고기 정보</a></li>
				<li><a href="#">낚시 축제</a></li>
				</ul>
			</div>	
		</li>
		<li id="st03">
			<a href="#">낚시장터</a>	
			<div>
				<ul>
				<li><a href="#">삽니다</a></li>
				<li><a href="#">팝니다</a></li>
				</ul>
			</div>
		</li>
		<li id="st04">
			<a href="#">커뮤니티</a>	
			<div>
				<ul>
				<li><a href="#">자유게시판</a></li>
				<li><a href="#">자랑게시판</a></li>
				<li><a href="#">동호회게시판</a></li>
				</ul>
			</div>
		</li>
	</ul>
</div>

</div>

</body>
</html>