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

</style>

<div>
<div class="container" style="margin-top: 50px; margin-bottom: 350px;">
<table class="table" style="border: 1px solid #ccc;">
	<tr>
		<td class="info">글번호</td><td colspan="3"><%=notice.getNotice_no() %></td>
 	</tr>
 	<tr>
		<td class="info">제목</td><td colspan="3"><%=notice.getNotice_title() %></td>
	</tr>
	<tr>
		<td class="info">조회수</td><td><%=notice.getNotice_hit() %></td>
	</tr>
	<tr>
		<td class="info">작성일</td><td colspan="3"><%=notice.getNotice_written_date() %></td>
	</tr>
	<tr>
		<td colspan="4"><%=notice.getNotice_content() %></td>
	</tr>
</table>

<br>
<div class="text-center">	
	<button id="btnList" class="btn btn-primary">목록</button>
	<c:if test="${writer_check eq true }">
		<button id="btnUpdate" class="btn btn-info">수정</button>
		<button id="btnDelete" class="btn btn-danger">삭제</button>
	</c:if>
</div>

<br>
<div class="row" >
	<div class="btnupdown col-md-0.5"><img src="/imgs/after.png" class="btnafter"></div>
	<div class="listtext col-md-11.5"><a href="/board/notice/view?notice_no=${next.notice_no }">${next.notice_title}</a></div>
</div>
<div class="row">		
	<div class="btnupdown col-md-0.5"><img src="/imgs/before.png" class="btnbefore"></div>
	<div class="listtext col-md-11.5"><a href="/board/notice/view?notice_no=${former.notice_no }">${former.notice_title }</a></div>
</div>
</div>

</div>


<c:import url="/WEB-INF/views/layout/footer.jsp" />
