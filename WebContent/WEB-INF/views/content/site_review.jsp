<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript"
 src="http://code.jquery.com/jquery-2.2.4.js"></script>
 
 <style type="text/css">
 
img{
	width: 500px;
	height: 400px;
	float: center;
	overflow: hidden;
}
 
</style>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<div class="wrap">

<div class="container" style="width: 1000px;">
<div class="row" style="margin-bottom: 100px;">
	<div class="col-md-12" id="text">
	<h2>낚시모아를 소개합니다.</h2>
	<hr>
	</div>
	<!-- 제목  -->
	<div class="col-md-6" id="img" style="padding : 10px;">
	<img src="imgs/fish.jpg" />
	</div>
	<!-- 사진  -->
	<div class="col-md-6">
		<h3>저희는 공공데이터 API를 활용한 '낚시터 찾기 프로그램'을 서비스하는 사이트입니다.</h3><br>
		<h3>또한, 낚시를 좋아하고 즐기는 이들을 위한 커뮤니티 사이트입니다.</h3><br>
		<h3>낚시를 즐기는 이들이 매년 증가하고 있으며, 낚시를 즐기는 사람들이 등산을 즐기는 사람들보다 많아졌다는 통계도 있습니다. </h3>
		<h3>건강한 낚시문화를 '낚시모아'와 함께 만들어갑시다. </h3>
		
	</div>
</div>
</div>

</div>



<c:import url="/WEB-INF/views/layout/footer.jsp" />
