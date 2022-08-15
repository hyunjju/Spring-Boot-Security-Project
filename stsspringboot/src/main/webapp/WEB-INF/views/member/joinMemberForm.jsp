<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
	<div class="container">
<form>
  <div class="form-group">
    <label for="userid">회원아이디(이메일)</label>
    <input type="email" class="form-control" placeholder="Enter userid" id="userid">
  </div>
  
  <div class="form-group">
    <label for="userpw">비밀번호</label>
    <input type="password" class="form-control" placeholder="Enter userpw" id="userpw">
  </div>
  
  <div class="form-group">
    <label for="username">이름</label>
    <input type="text" class="form-control" placeholder="Enter username" id="username">
  </div>
  
  <div class="form-group">
    <label for="userphonenum">전화번호</label>
    <input type="text" class="form-control" placeholder="Enter userphonenum" id="userphonenum">
  </div>
 
</form>

 	<button id="btn-save" class="btn btn-primary">회원가입 하기</button>
	</div>
	
	<script src="/js/member.js"></script>
	
	<%@ include file="../layout/footer.jsp"%>


