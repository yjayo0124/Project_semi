<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- jQuery 2.2.4 -->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.2.4.js"></script>

<link href="https://fonts.googleapis.com/css?family=Black+Han+Sans&display=swap&subset=korean" rel="stylesheet">
<style type="text/css">

.p{

	font-family: 'Black Han Sans', sans-serif;
	font-size: 50px;
	width: 250px;
	text-align: center;
	
}

#search{
	width:600px;
	height: 180px;
	

}


.img-circle{
	height: 200px;
	width:200px;
	margin-right: 45px;
}
</style>

<!-- header -->
<c:import url="/WEB-INF/views/layout/header.jsp" />

<div class="main container" style="margin-top: 0px; margin-bottom: 100px;">

<!-- slider -->
<div class="middle" style="width: 1000px; margin: 0 auto;">
<div id="slider" style="width: 100%; height: 500px;">
<c:import url="/WEB-INF/views/layout/slider2.jsp" />
</div>
	<br>
	<br>
</div>
</div>
<section style="background-image: url('/imgs/back.png'); background-repeat: no-repeat, repeat-x; background-size: cover;">
	<br>
	<br>
	<br>
	<br>
	<br>
	<div id="search" style="margin: auto;"><c:import url="/WEB-INF/views/layout/search.jsp"/></div>		
	<br>
	<br>
	<br>
	<br>
	<br>
</section>
	<br>
	<br>
	<br>
	<div class="middle" style="width: 1000px; margin: 0 auto;">
	<div class="row">
		<div class="col-md-3">
			<a href="/board/festival"><p class="p">대회와 축제</p></a>
		</div>
		<div class="col-md-3">
			<a href="/board/fish/info"><p class="p">물고기 정보</p></a>
		</div>
		<div class="col-md-3">
			<a href="/board/club"><p class="p">동호회찾기</p></a>
		</div>
		<div class="col-md-3">
			<a href="/board/free/list"><p class="p">자유게시판</p></a>
		</div>
	</div>
</div>



<c:import url="/WEB-INF/views/layout/footer.jsp" />
	
