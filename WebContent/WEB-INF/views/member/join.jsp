<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
    
<c:import url="/WEB-INF/views/layout/header.jsp" />

<div class="wrap">
<h3 class="text-center">회원가입</h3>

<div class="container" style="width: 60%;">
<hr>
<form action="/member/join" method="post">
	<div class="form-group">
		<label for="member_id">아이디</label>
		<input class="form-control" type="text" name="member_id" placeholder="아이디 입력"/>
	</div>
	<div class="form-group">
		<label for="member_pw">비밀번호</label>
		<input class="form-control" type="password" name="member_pw" placeholder="비밀번호는 최소 6자리"/>
	</div>
	<div class="form-group">
		<label for="member_pw">비밀번호 재확인</label>
		<input class="form-control" type="password" name="member_pw" placeholder="비밀번호는 최소 6자리"/>
	</div>
	<div class="form-group">
		<label for="member_name">이름</label>
		<input class="form-control" type="text" name="member_name" placeholder="닉네임 입력"/>
	</div>
	<div class="text-center" style="margin-top: 50px;">
	<button type="submit" class="btn btn-primary btn-sm" id="btnJoin">가입</button>
	<button type="reset" class="btn btn-danger btn-sm">취소</button>
	</div>
	<div class="text-center" style="margin-top: 30px;">
	<button type="button" onclick="location='/main'" class="btn btn-default btn-xs">메인으로가기</button>
	</div>
</form>
</div>
</div>



