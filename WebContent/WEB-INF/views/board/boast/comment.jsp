<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach items="${commentList }" var="comment">
<tr data-commentno="${comment.boast_board_comment_no }">
	<td>${comment.rnum }</td>
	<td>${comment.boast_content }</td><!-- 닉네임으로 해도 좋음 -->
	<td>${comment.member_id }</td>
	<td>${comment.boast_comment_written_date }</td>
	<td>
<c:if test="${sessionScope.member_id eq comment.member_id }">
		<button class="btn btn-default btn-xs"
			onclick="deleteComment(${comment.boast_board_comment_no });">삭제</button>
		</c:if>
	</td>
	
</tr>
</c:forEach>