<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript">


</script>
<c:import url="/WEB-INF/views/layout/header.jsp" />

<div class="wrap text-center" style="margin-top: 150px;">

<div class="container" style="width: 420px; border-top: 2px solid black; padding: 40px; border-bottom: 1px solid black;">
<form action="/member/login" method="post" class="form-horizontal">
	<div class="row">
		<div class="form-group">
			<label for="member_id" class="col-md-3 control-label">아이디</label>
			<div class="col-md-9">
			<input class="form-control" type="text" name="member_id" placeholder="아이디를 입력하세요"/>
			</div>
		</div>
		<div class="form-group">
			<label for="member_pw" class="col-md-3 control-label">패스워드</label>
			<div class="col-md-9">
			<input class="form-control" type="password" id="member_pw" name="member_pw" placeholder="비밀번호를 입력하세요"/>
			</div>
		</div>
	</div>
	<div class="text-center">
	<button type="submit" class="btn btn-primary btn-sm" id="btnLogin">로그인</button>
	<button type="reset" class="btn btn-danger btn-sm">취소</button>
	</div>
</form>
<br>
<hr>
	<div class="text-left">
		<div class="col-md-10">아직 낚시모아의 회원이 아니신가요?</div>
		<div class="col-md-2">
		<button type="button" class="btn btn-default btn-xs" onclick="location='/member/join'">회원가입 가기</button>
		</div>
	</div>
	

</div>
</div>

