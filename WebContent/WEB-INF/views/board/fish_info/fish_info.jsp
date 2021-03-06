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
 	margin-left: 450px ;
 	width: 1100px ;
 	
}
#head {
	font-weight: 600px ;
 	font-size: 30px ;
}
#btnWrite{
	float: right;
	margin-right: 100px ;
	margin-top: 20px ;
}
#hr {
	width: 1000px ;
	margin-left: 450px ;
	margin-right: 450px ; 
	margin-top: 0px ;
	margin-bottom: 0px ;
}
#img {
	float: left ;
	margin-left: 100px ;
}
#text {
	float: left ;
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
#margin {
	width: 1260px ;
	margin: 0 auto ;
	
}
.item {
	display: inline-block;
	margin: 10px ;
}
#btnWrite {
width: 100px;
height: 40px;
background: #474e60;
font-size: 13px;
color: #fff;
border: solid 2px;
border-radius: 1px;
}
</style>
 
<c:import url="/WEB-INF/views/layout/header.jsp" />

<br>
<div id = "title">
<font id = "head">물고기 정보</font>
<c:if test="${res eq 1 }">
<button id = "btnWrite">글쓰기</button>
</c:if>
</div><div style="clear: both;"></div>
<div style="width: 1000px ;">
<hr id = "hr">
</div><br>
<div style="width: 1260px ; float: left; margin-left: 320px ;">
<div id = "margin" >
<c:forEach items="${fishlist}" var="i">
<div class="item">
	<div style="width: 220px; height: 350px;" id = "img">
		<a href="/board/fish/info/detail?fish_no=${i.fish_no }"><img src="/fishupload/${i.fish_storedname }" alt="Fishing" width="220px;" height="350px;"></a>
	</div>
	<a href="/board/fish/info/detail?fish_no=${i.fish_no }">
		<div id = "text" style="width: 260px; height: 350px" ><br>	
			<div id = "fname">${i.fish_name } </div><br><br>
			<div id = "ftype">낚시 종류 : ${i.fish_type } </div><br>
			<div id = "fsesson">어획 시기 : ${i.fish_sesson }</div><br>
			<div id = "flength">표준 체장 : ${i.fish_min_length }</div><br>
			<div id = "fcare">특징 : ${i.fish_care } </div><br>
		</div>
	</a>
	<div style="clear: both;"></div>
</div>
</c:forEach>
</div>
</div><div style="clear: both;"></div>
<c:import url="/WEB-INF/views/layout/fish_paging.jsp" />

<c:import url="/WEB-INF/views/layout/footer.jsp" />