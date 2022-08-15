<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<div class="container">
	<form action="/auth/loginProc" method="post">
		<div class="form-group">
			<label for="userid">회원아이디(이메일)</label> <input type="email" name="userid" class="form-control" placeholder="Enter userid" id="userid">
		</div>

		<div class="form-group">
			<label for="userpw">비밀번호</label> <input type="password" name="userpw" class="form-control" placeholder="Enter userpw" id="userpw">
		</div>

		<!-- <div class="form-group form-check">
			<label name ="remember" class="form-check-label"> <input class="form-check-input" type="checkbox"> Remember me
			</label>
		</div> -->

		<button style="width:154px" id="btn-login" class="btn btn-primary">로그인</button>
		<a href=" https://kauth.kakao.com/oauth/authorize?client_id=2b44e09e6827ad0baec89e576a79f3de&redirect_uri=http://localhost:8080/auth/kakao/callback&response_type=code">
		<img height ="38px" src="/image/kakao_login_button.png"></a>

	</form>
</div>

<!--  <script src="/js/member.js"></script> -->
<%@ include file="../layout/footer.jsp"%>


