<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<!-- header -->
	<c:import url="/WEB-INF/views/layout/header.jsp" />
<form action="/member/delete" method="post">
<input type="hidden" name="member_id" value=${member.member_id }>
<h1>회원탈퇴 하시겠습니까?</h1>
<button>탈퇴</button>
<hr>

</form>
</body>
</html>