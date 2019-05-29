<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
$(document).ready(function() {
	
	//모든 이미지 리스트
	var $slider_list = $("#slider li");
	
	//모든 이미지를 "left: 600px"로 보내기(숨기기)
	$slider_list.css("left", "1000px");
	
	
	//첫번째 이미지를 div 안쪽으로 보내기
	//첫 이미지를 보여주기
// 	$("#slider li:first-child").css("left", 0);
	$slider_list.eq(0).css("left", 0);
	var dots = document.getElementsByClassName("dot");
	
	dots[0].className += " active";
	
	
	
	//3초마다 이미지  교체하기 - slide
	
	var curSlide = 0; //현재 보이는 이미지의 인덱스
	setInterval(function() {		
		//다음 이미지의 인덱스
		var nextSlide = (curSlide+1) % $slider_list.length;
		//확인
// 		console.log(curSlide + " : " + nextSlide);
		
		//보여져야 할 이미지 오른쪽으로 이동시키기
		$slider_list.eq(nextSlide).css("left", "1000px");
		
		//현재 이미지 숨기기 : curSlide
		$slider_list.eq(curSlide).animate({"left":"-=1000px"});
		dots[curSlide].className = dots[curSlide].className.replace(" active", "");
		//다음 이미지 보여주기 : nextSlide
		$slider_list.eq(nextSlide).animate({"left":"-=1000px"});
		dots[nextSlide].className += " active";
		
		//순환구조 만들기
		curSlide++;
		curSlide = curSlide % $slider_list.length;
	}, 3000);
	
});
</script>

<style type="text/css">
#sliderbox {
	width: 1000px;
	height: 300px;
	border: 1px solid #ccc;
	
 	overflow: hidden; /* div영역을 벗어난 내용물 숨기기 */
	margin: 0 auto; /* div박스를 화면 가운데로 정렬 */
}

#slider {
	/* ul태그의 기본 스타일 없애기 */
	padding: 0;
	margin: 0;
	list-style: none;
	
	position: relative;
}

#slider li {
	position: absolute;
}

#slider li img {
	width: 100%;
	height: 300px;
}

.dot {
  cursor: pointer;
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active, .dot:hover {
  background-color: #717171;
}
</style>
</head>
<body>

<div id="sliderbox">
	<ul id="slider">
		<li><img src="/imgs/1.png" /></li>
		<li><img src="/imgs/2.png" /></li>
		<li><img src="/imgs/3.png" /></li>
	</ul>
</div>
<br>
<div style="text-align:center" >
  <span class="dot"></span> 
  <span class="dot"></span> 
  <span class="dot"></span> 
</div>
</body>
</html>