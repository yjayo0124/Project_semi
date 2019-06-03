<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/views/layout/header.jsp" />

<script type="text/javascript">

$(document).ready(function(){

	
	$("#btnSearchSubmit").click(function() {
		
		$("form").submit(); 
		
		$.ajax({
			url: "/board/search",
			type: 'POST',
			data : {"insttNm1" : insttNm1, "insttNm2" : insttNm2, "fshlcNm" : fshlcNm, "kdfsh" : kdfsh}, 
			dataType: 'json',
			success: function(data){
			
				console.log(data.response.body.items.item);
				var myItem = data.response.body.items.item;
				
				for(var i=0; myItem.length; i++){
					var output = '';
					
					console.log(myItem.length);
					
					output += '<h4>'+i+' 번 째 낚시터 정보 조회 결과'+'</h4>';
					output += '<h4>'+myItem[i].fshlcNm+'</h4>'; //낚시터명
					output += '<h4>'+myItem[i].rdnmadr+'</h4>'; //도로명주소
					output += '<h4>'+myItem[i].fshlcPhoneNumber+'</h4>'; //낚시터 전화번호
					output += '<h4>'+myItem[i].kdfsh+'</h4>'; //주요어종
					output += '<h4>'+myItem[i].useCharge+'</h4>'; //이용요금
					output += '<h4>'+myItem[i].cvntl+'</h4>'; //편의시설현황
					output += '<h4>'+myItem[i].cfrTrrsrt+'</h4>'; //주변관광지
					
					$('#result').html(data);
					
					
				}		
				
		
				
			}
		})
		 
	});


})


	
function gugunSelect(e){
		
		var area1 = ["구/군 선택","강남구","강동구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중구","중랑구"];
		var area2 = ["구/군 선택","계양구","남구","남동구","동구","부평구","서구","연수구","중구","강화군","옹진군"];
		var area3 = ["구/군 선택","대덕구","동구","서구","유성구","중구"];
		var area4 = ["구/군 선택","광산구","남구","동구", "북구","서구"];
		var area5 = ["구/군 선택","남구","달서구","동구","북구","서구","수성구","중구","달성군"];
		var area6 = ["구/군 선택","남구","동구","북구","중구","울주군"];
		var area7 = ["구/군 선택","강서구","금정구","남구","동구","동래구","부산진구","북구","사상구","사하구","서구","수영구","연제구","영도구","중구","해운대구","기장군"];
		var area8 = ["구/군 선택","고양시","과천시","광명시","광주시","구리시","군포시","김포시","남양주시","동두천시","부천시","성남시","수원시","시흥시","안산시","안성시","안양시","양주시","오산시","용인시","의왕시","의정부시","이천시","파주시","평택시","포천시","하남시","화성시","가평군","양평군","여주군","연천군"];
		var area9 = ["구/군 선택","강릉시","동해시","삼척시","속초시","원주시","춘천시","태백시","고성군","양구군","양양군","영월군","인제군","정선군","철원군","평창군","홍천군","화천군","횡성군"];
		var area10 = ["구/군 선택","제천시","청주시","충주시","괴산군","단양군","보은군","영동군","옥천군","음성군","증평군","진천군","청원군"];
		var area11 = ["구/군 선택","계룡시","공주시","논산시","보령시","서산시","아산시","천안시","금산군","당진군","부여군","서천군","연기군","예산군","청양군","태안군","홍성군"];
		var area12 = ["구/군 선택","군산시","김제시","남원시","익산시","전주시","정읍시","고창군","무주군","부안군","순창군","완주군","임실군","장수군","진안군"];
		var area13 = ["구/군 선택","광양시","나주시","목포시","순천시","여수시","강진군","고흥군","곡성군","구례군","담양군","무안군","보성군","신안군","영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군"];
		var area14 = ["구/군 선택","경산시","경주시","구미시","김천시","문경시","상주시","안동시","영주시","영천시","포항시","고령군","군위군","봉화군","성주군","영덕군","영양군","예천군","울릉군","울진군","의성군","청도군","청송군","칠곡군"];
		var area15 = ["구/군 선택","거제시","김해시","마산시","밀양시","사천시","양산시","진주시","진해시","창원시","통영시","거창군","고성군","남해군","산청군","의령군","창녕군","하동군","함안군","함양군","합천군"];
		var area16 = ["구/군 선택","서귀포시","제주시","남제주군","북제주군"];
		
		var target = document.getElementById("insttNm2");
		
	
		if(e.value == "서울특별시") var area = area1;
		else if(e.value == "인천광역시") var area = area2; 
		else if(e.value == "대전광역시") var area = area3;
		else if(e.value == "광주광역시") var area = area4;
		else if(e.value == "대구광역시") var area = area5;
		else if(e.value == "울산광역시") var area = area6;
		else if(e.value == "부산광역시") var area = area7;
		else if(e.value == "경기도") var area = area8; 
		else if(e.value == "강원도") var area = area9;
		else if(e.value == "충청북도") var area = area10;
		else if(e.value == "충청남도") var area = area11;
		else if(e.value == "전라북도") var area = area12;
		else if(e.value == "전라남도") var area = area13;
		else if(e.value == "경상북도") var area = area14;
		else if(e.value == "경상남도") var area = area15;
		else if(e.value == "제주특별자치도") var area = area16;
		
		
		target.options.length = 0;
		
	
		for (x in area ){
			var opt = document.createElement("option");
			opt.value = area[x];
			opt.innerHTML = area[x];
			target.appendChild(opt);
		}
		 
};
 
 
 
	 
	
	

</script>


<style type="text/css">

.map_box{

max-width: 300px;
max-heigh: 100%;
overflow: hidden;

}



.map_box img{

max-width: initial;


}

</style>

<div class="container" style="width: 1000px;">

<div class="row">
<div class="col-md-12 text-center" style="padding: 20px;" >
<h2>낚시터 정보 검색</h2>
</div>

<div>

<div class="col-md-3" style="border: 1px solid #ccc;">
	<div class="map_box" style="height: 236px; width: 250px; background-color: #fffff5 ">
		<img src="/imgs/map.png" style="width: 100%; height: 100%; overflow: hidden;">		
	</div>
</div>

<div class="col-md-9" id="search" style="border: 1px solid #ccc; background-color: #80d4f6;  padding: 35px; height: 238px;">
<form action="/board/search" method="POST" class="form-horizontal">	
	<div class="form-group">
		<label class="form-label col-md-2" for="insttNm1"> 시/도</label>
		<div class="col-md-10">
		<select class="fsearch_select" name="insttNm1" id="insttNm1" onchange="gugunSelect(this)">
			<option value="">시/도 선택</option>
			<option value="서울특별시">서울</option>
			<option value="인천광역시">인천</option>
			<option value="대전광역시">대전</option>
			<option value="광주광역시">광주</option>
			<option value="대구광역시">대구</option>
			<option value="울산광역시">울산</option>
			<option value="부산광역시">부산</option>
			<option value="경기도">경기</option>
			<option value="강원도">강원</option>
			<option value="충청북도">충북</option>
			<option value="충청남도">충남</option>
			<option value="전라북도">전북</option>
			<option value="전라남도">전남</option>
			<option value="경상북도">경북</option>
			<option value="경상남도">경남</option>
			<option value="제주특별자치도">제주</option>
		</select>
		</div>
	</div>
	
	
	<div class="form-group">
		<label class="form-label col-md-2" for="insttNm2"> 시/군/구</label>
		<div class="col-md-10">
		<select class="search_select" name="insttNm2" id="insttNm2">
		<option value="">구/군 선택</option>
		</select>
		</div>
	</div>
	
	
	<div class="form-group">
		<label class="form-label col-md-2" for="kdfsh"> 주요어종</label>
		<div class="col-md-10">
		<input type="text" id="kdfsh" name="kdfsh" class="search_input" value="" placeholder="예) 붕어, 잉어,향어 등"/>
		</div>
	</div>
	
	<div class="form-group">
		<label class="form-label col-md-2" for="fshlcNm"> 낚시터명</label>
		<div class="col-md-10">
		<input type="text" id="fshlcNm" name="fshlcNm" class="search_input" value=""></div>
	</div>
</form>

<div style=" text-align: right;">
<button id="btnSearchSubmit">검색하기</button>
</div>

</div>
</div>






</div> <!-- row  -->


<hr>

<div class="container">
<span id="result"></span>

</div>

</div> <!--container  -->




<c:import url="/WEB-INF/views/layout/footer.jsp" />
