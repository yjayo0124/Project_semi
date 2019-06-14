<%@page import="web.dto.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>   

<c:import url="/WEB-INF/views/layout/header.jsp" />



<% Notice notice = (Notice) request.getAttribute("notice"); %>

<script type="text/javascript" src="/js/httpRequest.js"></script>
<script type="text/javascript">

$(document).ready(function(){

	
	$("#btnUpdate").click(function(){
		$(location).attr("href","/board/notice/update?notice_no="+<%=notice.getNotice_no() %>);
	});
	
	
	$("#btnDelete").click(function(){
		$(location).attr("href","/board/notice/delete?notice_no="+<%=notice.getNotice_no() %>);
	});
	
	
	$("#btnList").click(function() {
		$(location).attr("href", "/board/notice/list");
	});

	
})
	

	

</script>


<style type="text/css">

.notice {
	font-size : 18px;
}

.btnupdown {
	float:left;
	padding-left:20px;
	width: 50px;
	height: 50px;
}
.btnafter {
	width: 100%;
	height: 45px;
}
.btnbefore {
	width: 100%;
	height: 45px;
}
.listtext {
	font-size: 18px;
	padding-left : 200px;
	padding-top: 12px;
}
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
</style>


<div class="container" style="margin-top: 50px; margin-bottom: 350px;">

<h4 class="pull-left">공지사항</h4>
<div class="clearfix"></div>
<hr>

<div class="total">
	<h1 class="pull-left"><%=notice.getNotice_title() %></h1><br><br><br><br>
	<h5 class="pull-left">작성일 : <%=notice.getNotice_written_date() %></h5>	
	<h5 class="pull-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 조회수<%=notice.getNotice_hit() %></h5>
	<h5 class="pull-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 글번호 : <%=notice.getNotice_no() %></h5>
	
	<div class="text-right">
	<button id="btnList">목록</button>
	
	<c:if test="${writer_check eq true }">
		<button id="btnUpdate" >수정</button>
		<button id="btnDelete" class="btn btn-danger">삭제</button>
	</c:if>
	</div>
	<hr>
	
	<div class="notice">
	<%=notice.getNotice_content() %>
	</div>

</div>

<br>


<br>


<hr>
<div class="row" >
	<div class="btnupdown col-md-0.5"><img src="/imgs/after.png" class="btnafter"></div>
	<div class="listtext col-md-11.5"><a href="/board/notice/view?notice_no=${next.notice_no }">${next.notice_title}</a></div>
</div>
<div class="row">		
	<div class="btnupdown col-md-0.5"><img src="/imgs/before.png" class="btnbefore"></div>
	<div class="listtext col-md-11.5"><a href="/board/notice/view?notice_no=${former.notice_no }">${former.notice_title }</a></div>
</div>
</div>



<c:import url="/WEB-INF/views/layout/footer.jsp" />
