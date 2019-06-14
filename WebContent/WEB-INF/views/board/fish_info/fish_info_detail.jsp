<%@page import="web.dto.FishInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript"
 src="http://code.jquery.com/jquery-2.2.4.js"></script>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<style type="text/css">
#title {
 	margin-left: 450px ;
 	width: 1100px ;
 	
}
#head {
	font-weight: 600px ;
 	font-size: 30px ;
}
#btnUpdate {
	float: right;
	margin-right: 15px ;
	margin-top: 20px ;
}
#btnDelete {
	float: right;
	margin-right: 110px ;
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
	margin-left: 500px ;
	width: 470px ;
	height: 410px ;
}
#text {
	float: left ;
	margin-left: 95px ;
	text-align: center;
}
#fname {
	font-weight: 700px ;
 	font-size: 30px ;
}
#fnam , #ftype ,#fsesson ,#flength, #fcare {
	font-weight: 650px ;
	font-size: 25px ;
}
#btnList {
	float: right ;
	margin-right: 500px ;
}
#next , #back {
	margin-left: 500px ;
}

a:link , a:visited , a:active , a:hover {
	color: black ;
}

#content {
	width: 1600px ;
}
#hr2 {
	width: 950px ;
	margin-left : 480px ;
	margin-top : 3px ;
	margin-bottom: 3px ;
}

</style>

<script type="text/javascript">
$(document).ready(function() {
	$("#btnList").click(function() {
		$(location).attr("href", "/board/fish/info");
	});
	
	$("#btnUpdate").click(function() {
		$(location).attr("href", "/board/fish/info/update?fish_no=${fishInfo.fish_no}");
	});	
	
	$("#btnDelete").click(function() {
		$(location).attr("href", "/board/fish/info/delete?fish_no=${fishInfo.fish_no}");
	});	
	
});

function button_event(){
	if (confirm("정말 삭제하시겠습니까??") == true){    //확인
	    document.form.submit();
	}else{   //취소
	    return;
	}
	}

</script>
<style>
#btnList {
	width: 80px;
	height: 40px;
	background: #474e60;
	font-size: 13px;
	color: #fff;
	border: solid 2px;
	border-radius: 1px;
}
#btnUpdate{
	width: 80px;
	height: 40px;
	background: #1ec0ff;
	font-size: 13px;
	color: #fff;
	border: solid 2px;
	border-radius: 1px;
}
#btnDelete{
	width: 80px;
	height: 40px;
	background: #f1404b;
	font-size: 13px;
	color: #fff;
	border: solid 2px;
	border-radius: 1px;
}
#text_content {
	width: 900px ;
	margin-left : 500px ;

}
</style>
<br>
<div id = "title">
<font id = "head">물고기 정보</font>
<font id = "date">작성일 : ${ fishInfo.fish_written_date }</font>
<c:if test="${res eq 1 }">
<input type="button" id = "btnDelete" value="삭제" onclick="button_event();">
<button id = "btnUpdate">수정</button>
</c:if>
</div><div style="clear: both;"></div>
<div style="width: 1000px ;">
<hr id = "hr"><br>
</div>
<div id = "content">
<div id = "img">
	<img src="/fishupload/${ fishInfo.fish_storedname }" alt="Fishing" width="470px;" height="410px;">
</div>
	<div id = text>
	<br><div id = "fname">${ fishInfo.fish_name }</div><br><br>
		<div id = "ftype">낚시 종류 : ${ fishInfo.fish_type } </div><br>
		<div id = "fsesson">어획 시기 : ${ fishInfo.fish_sesson }</div><br>
		<div id = "flength">표준 체장 : ${ fishInfo.fish_min_length }</div><br>
		<div id = "fcare">특징 : ${ fishInfo.fish_care }</div><br>
	</div><div style="clear: both;"></div>
</div>
<br>
<div id = text_content>

<pre style="white-space: pre-wrap ;">${ fishInfo.fish_content }</pre>

</div>
<div style="width: 1900px ;">
<button id = "btnList">목록</button>
</div><div style="clear: both;"></div>
<br>
<div id = "page">

<div><hr id = hr2 ></div>
<div id = "next">
<c:if test="${prev_next.next eq 0 }">
	다음글없음
</c:if>
<c:if test="${prev_next.next ne 0 }">
	다음글 : <a href="/board/fish/info/detail?fish_no=${prev_next.next }">
	${prev_next_name.next }
	</a>
</c:if>
</div>

<div><hr id = hr2 ></div>

<div id = "back">
<c:if test="${prev_next.prev eq 0 }">
	이전글없음
</c:if>
<c:if test="${prev_next.prev ne 0 }">
이전글 : <a href="/board/fish/info/detail?fish_no=${prev_next.prev}">
	${prev_next_name.prev }
	</a>
</c:if>
</div>
<div><hr id = hr2 ></div>

</div>

<c:import url="/WEB-INF/views/layout/footer.jsp" />