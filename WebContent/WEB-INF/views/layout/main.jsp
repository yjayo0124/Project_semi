<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- jQuery 2.2.4 -->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.2.4.js"></script>
<link rel="stylesheet" href="/resources/hover/hover-min.css" >
<link href="https://fonts.googleapis.com/css?family=Black+Han+Sans&display=swap&subset=korean" rel="stylesheet">
<style type="text/css">

/* Grow */
.hvr-grow {
    display: inline-block;
    vertical-align: middle;
    transform: translateZ(0);
    box-shadow: 0 0 1px rgba(0, 0, 0, 0);
    backface-visibility: hidden;
    -moz-osx-font-smoothing: grayscale;
    transition-duration: 0.3s;
    transition-property: transform;
}

.hvr-grow:hover,
.hvr-grow:focus,
.hvr-grow:active {
    transform: scale(1.1);
}


.p{

	font-family: 'Black Han Sans', sans-serif;
	font-size: 50px;
	width: 250px;
	text-align: center;
	
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
</div>
</div>

	<br>
	<div class="middle" style="width: 1000px; margin: 0 auto;">
	<div class="row">
		<div class="col-md-3">
			<a href="/board/festival"><img class="hvr-grow" src="/imgs/icon1.png"/></a>
		</div>
		<div class="col-md-3">
			<a href="/board/fish/info"><img class="hvr-grow" src="/imgs/icon2.png"/></a>
		</div>
		<div class="col-md-3">
			<a href="/board/club"><img class="hvr-grow" src="/imgs/icon3.png"/></a>
		</div>
		<div class="col-md-3">
			<a href="/board/free/list"><img class="hvr-grow" src="/imgs/icon4.png"/></a>
		</div>
	</div>
</div>
<br>
<br>

<section class="mid" style="width: 1000px; margin: 0 auto;">
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




<c:import url="/WEB-INF/views/layout/footer.jsp" />
	
