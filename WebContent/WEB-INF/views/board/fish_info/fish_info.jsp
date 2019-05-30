<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript"
 src="http://code.jquery.com/jquery-2.2.4.js"></script>
 
<script type="text/javascript">
$(document).ready(function() {
	$("#btnWrite").click(function() {
		$(location).attr("href", "/board/fish/info/write");
	});
});
</script>

<style type="text/css">
 
#title {
 	margin-left: 320px ;
 	margin-right: 300px ;
 	font-weight: 600px ;
 	font-size: 30px ;
 	width: 1300px ;
}
#write {
	float: right ;
	margin-right: 320px ;
}
#img {
	float: left ;
}
#text {
	float: left ;
	background-color: yellow ;
	text-align: center;
 }
 
#fname {
 	font-weight: 700px ;
 	font-size: 30px ;
}
#fnam , #ftype ,#fsesson ,#flength, #fcare {
	font-size: 20px ;
	font-weight: 650px ;
}


 </style>
 
 <c:import url="/WEB-INF/views/layout/header.jsp" />
 
<br><br>
<div id = "title">
&nbsp;&nbsp;&nbsp;&nbsp;물고기 정보
<hr>
</div>
<div id = "write">
<button id = "btnWrite">글쓰기</button>
</div>
<br>

<div style = "width: 1000px ; margin: 0 auto ; text-align: center;">
<c:forEach items="${fishlist}" var="i">
<div class="item" style="display: inline-block;">
	<div style="width: 220px; height: 350px" id = "img">
		<a href="/board/fish/info/detail"><img src="/imgs/fishing.jpg" alt="Fishing" width="220px" height="350px"></a>
	</div>
	<a href="/board/fish/info/detail">
		<div id = "text" style="width: 240px; height: 350px" ><br>	
			<div id = "fname">${i.fish_name } </div><br><br>
			<div id = "ftype">낚시 종류 : ${i.fish_type } </div><br>
			<div id = "fsesson">어획 시기 : ${i.fish_sesson }</div><br>
			<div id = "flength">최소 체장 : ${i.fish_min_length }</div><br>
			<div id = "fcare">특징 : ${i.fish_care } </div><br>
		</div>
	</a>
	<div style="clear: both;"></div>
</div>
<br>
</c:forEach>
</div>

<c:import url="/WEB-INF/views/layout/fish_paging.jsp" />

<c:import url="/WEB-INF/views/layout/footer.jsp" />