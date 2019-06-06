<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/views/layout/header.jsp" />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"> 
<style>

#map{
	height: 300px;
	/* width: 400px; */
}

</style>
<script type="text/javascript">

$(document).ready(function(){
	
	$("#btnBack").click(function(){
		history.go(-1);
	});
	
})

</script>
<script>
		function initMap() {
			
		  var spot = {lat: ${res.latitude}, lng: ${res.hardness}};
		  
		  var map = new google.maps.Map(
		      document.getElementById('map'), {zoom: 15, center: spot});
		  // The marker, positioned at Uluru
		  var marker = new google.maps.Marker({position: spot, map: map});
		}
	      
	   </script>
	 <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA3gnxHyQJmWhz0seVyFEdSSMQHDAEDpbg&callback=initMap"
	    async defer></script>

<div class="container" style="width:1000px; margin-bottom: 80px;">
<h2>낚시터 상세정보</h2>

<div>
<hr>
<h3><small>${res.insttNm }</small><br> ${res.fshlcNm }</h3>
<div class="form-group">
<div id="map" class="col-md-4"></div>

<div class="col-md-8">
<table class="table" style="border: 0.5px solid #ccc;">
	<tr>
		<th class="success" style="width: 30%;">상호명</th>
		<th style="width: 70%;">${res.fshlcNm }</th>
	</tr>
	<tr>
		<th class="success" style="width: 30%;">도로명주소</th>
		<th style="width: 70%;">${res.rdnmadr }</th>
	</tr>
	<tr>
		<th class="success" style="width: 30%;">지번주소</th>
		<th style="width: 70%;">${res.lnmadr }</th>
	</tr>
	<tr>
		<th class="success" style="width: 30%;">전화번호</th>
		<th style="width: 70%;">${res.fshlcPhoneNumber }</th>
	</tr>
	<tr>
		<th class="success" style="width: 30%;">주요어종</th>
		<th style="width: 70%;">${res.kdfsh }</th>
	</tr>
	<tr>
		<th class="success" style="width: 30%;">이용요금&nbsp;(원)</th>
		<th style="width: 70%;">${res.useCharge }</th>
	</tr>
	<tr>
		<th class="success" style="width: 30%;">편익시설현황</th>
		<th style="width: 70%;">${res.cvntl }</th>
	</tr>
	<tr>
		<th class="success" style="width: 30%;">주변관광</th>
		<th style="width: 70%;">${res.cfrTrrsrt }</th>
	</tr>	
</table>
</div>
</div>
</div>
<div class="text-center">
<button class="button btn-lg btn-default" type="button" id="btnBack">뒤로가기</button>
</div>
</div> <!-- 컨테이너   -->
<c:import url="/WEB-INF/views/layout/footer.jsp" />

