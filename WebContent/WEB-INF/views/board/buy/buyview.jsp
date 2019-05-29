<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />







<h1 class="pull-left">게시판 - VIEW</h1>

<div class="clearfix"></div>
<hr>

<table class="table table-bordered">
<tr>
<td class="info">글번호</td><td colspan="3">${viewBoard.boardno }</td>
</tr>

<tr>
<td class="info">제목</td><td colspan="3">${viewBoard.title }</td>
</tr>

<tr>
<td class="info">아이디</td><td>${viewBoard.writer }</td>
<td class="info">닉네임</td><td>${viewNick }</td>
</tr>

<tr>
<td class="info">조회수</td><td>${viewBoard.hit }</td>
<%-- <td class="info">추천수</td><td id="recommend">${viewBoard.recommend }</td> --%>
</tr>

<tr>
<td class="info">작성일</td><td colspan="3">${viewBoard.writtendate }</td>
</tr>

<tr><td class="info"  colspan="4">본문</td></tr>

<tr><td colspan="4">${viewBoard.content }</td></tr>

</table>

<c:import url="/WEB-INF/views/layout/footer.jsp" />


