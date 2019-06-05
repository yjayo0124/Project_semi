<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/views/layout/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
$(document).ready(function (event){

    $(window).scroll(function(){

    

    var scrollHeight = $(window).scrollTop() + $(window).height();

    var documentHeight = $(document).height();

    var tmpHtml = "";
    

    //스크롤이 맨아래로 갔는지 아닌지 확인하는 if문

    if(scrollHeight == documentHeight){
		
    for(var i = 0; i < 5; i++){

    	tmpHtml = tmpHtml + '<div id="img1">'+'<img src="/imgs/fishing.jpg">'+'<h3>추가된div</h3>'+
    	'</div>'
    	
    	$("#imglist").append(tmpHtml);
    	
    }      

    }

    

    });

    });


    



</script>

<style>
.content{
	width: 1080px;
	margin: 0 auto;
    padding: 8px 10px 0;
}
.title{
	width: 100%;
	text-align: left;
}
#imglist {
	width: 100%;
}
img{
	width: 100%;
	padding: 10px;
	margin: 5px;
}
#img1{
	display: inline-block;
	width: 23%;
	padding: 3px;
	margin: 0 auto;
}
h3{
	text-align: center;
}
#img2{
	display: inline-block;
	width: 20%;
	padding: 3px;
	margin: 0 auto;
}
#btn{
	display: scroll; 
	position: fixed;
	margin-left: 600px;
	bottom: 100px;
	left: 50%;
}
</style>
</head>
<body>
<div class="content">

<div class="title">
<h2>자랑게시판</h2>
</div>
<a id="btn" href="/main"><img src="https://previews.123rf.com/images/iconmama/iconmama1601/iconmama160100162/50953770-%EA%B8%80%EC%93%B0%EA%B8%B0-%EC%95%84%EC%9D%B4%EC%BD%98.jpg"></a>
<div id="imglist">
	<div id="img1">
		<img src="/imgs/fishing.jpg">
		<h3>hello</h3>
	</div>	
	<div id="img1">
		<img src="/imgs/fishing.jpg">
		<h3>hello2</h3>
	</div>	
	<div id="img1">
		<img src="/imgs/fishing.jpg">
		<h3>hello3</h3>
	</div>	
	<div id="img1">
		<img src="/imgs/fishing.jpg">
		<h3>hello4</h3>
	</div>
	<div id="img1">
		<img src="/imgs/fishing.jpg">
		<h3>hello5</h3>
	</div>	
	<div id="img1">
		<img src="/imgs/fishing.jpg">
		<h3>hello6</h3>
	</div>	
	<div id="img1">
		<img src="/imgs/fishing.jpg">
		<h3>hello7</h3>
	</div>	
	<div id="img1">
		<img src="/imgs/fishing.jpg">
		<h3>hello8</h3>
	</div>	
	<div id="img1">
		<img src="/imgs/fishing.jpg">
		<h3>hello9</h3>
	</div>	
	<div id="img1">
		<img src="/imgs/fishing.jpg">
		<h3>hello10</h3>
	</div>	
<div id="img1">
		<img src="/imgs/fishing.jpg">
		<h3>hello5</h3>
	</div>	
	<div id="img1">
		<img src="/imgs/fishing.jpg">
		<h3>hello6</h3>
	</div>	
	<div id="img1">
		<img src="/imgs/fishing.jpg">
		<h3>hello7</h3>
	</div>	
	<div id="img1">
		<img src="/imgs/fishing.jpg">
		<h3>hello8</h3>
	</div>	
	<div id="img1">
		<img src="/imgs/fishing.jpg">
		<h3>hello9</h3>
	</div>	
	<div id="img1">
		<img src="/imgs/fishing.jpg">
		<h3>hello10</h3>
	</div>	
	<div id="img1">
		<img src="/imgs/fishing.jpg">
		<h3>hello5</h3>
	</div>	
	<div id="img1">
		<img src="/imgs/fishing.jpg">
		<h3>hello6</h3>
	</div>	
	<div id="img1">
		<img src="/imgs/fishing.jpg">
		<h3>hello7</h3>
	</div>	
	<div id="img1">
		<img src="/imgs/fishing.jpg">
		<h3>hello8</h3>
	</div>	
	<div id="img1">
		<img src="/imgs/fishing.jpg">
		<h3>hello9</h3>
	</div>	
	<div id="img1">
		<img src="/imgs/fishing.jpg">
		<h3>hello마지막</h3>
	</div>	
		
</div>
</div>
</body>
</html>
