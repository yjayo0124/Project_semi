<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- jQuery 2.2.4 -->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.2.4.js"></script>


<style type="text/css">

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

<div class="main container" style="margin-top: 50px; margin-bottom: 100px;">

<!-- slider -->
<c:import url="/WEB-INF/views/layout/slider.jsp" />
<br>
<br>
<div class="middle" style="width: 1000px; margin: 0 auto;">
			
	<div id="search"><c:import url="/WEB-INF/views/layout/search.jsp"/></div>		
	<br>
	<br>
	<div class="icon">
			<a href="/board/festival"> <img src="/imgs/img1.png" class="img-circle"></a>
			<a href="/board/fish/info"> <img src="/imgs/img2.png" class="img-circle"></a>
			<a href="/buy/list"> <img src="/imgs/img3.png" class="img-circle"></a>
			<a href="/board/free/list"> <img src="/imgs/img4.png" class="img-circle"></a>
	</div>
</div>
</div>


<c:import url="/WEB-INF/views/layout/footer.jsp" />
	
