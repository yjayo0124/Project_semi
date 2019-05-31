<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/views/layout/header.jsp" />

<div>
<div class="container text-center" style="margin-top: 150px;">
<form action="/board/search" method="post">
	<div class="form-group">
	<label for="insttNm">위치</label>
	<input id="insttNm" name="insttNm" type="text"/>
	</div>
	<button type="submit">확인</button>
</form>
</div>
</div>

<br>
<br>
<br>
<br>

<c:import url="/WEB-INF/views/layout/footer.jsp" />
