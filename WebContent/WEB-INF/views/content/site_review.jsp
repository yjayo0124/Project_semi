<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript"
 src="http://code.jquery.com/jquery-2.2.4.js"></script>
 
 <style type="text/css">
 
img{
	width: 500px;
	height: 500px;
	float: center;
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
	<img src="imgs/fishing.jpg" />
	</div>
	<!-- 사진  -->
	<div class="col-md-6">
		<h3><mark>낚시모아는요</mark></h3>
		<br><br>
		<br><br>
		<p>낚시를 좋아하고 낚시를 사랑하는 사람들을 위한 커뮤니티 사이트입니다.</p>
	</div>
</div>
</div>

</div>



<c:import url="/WEB-INF/views/layout/footer.jsp" />
