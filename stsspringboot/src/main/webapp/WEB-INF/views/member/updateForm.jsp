<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
	<div class="container">
<form>

<input type="hidden" id="num" value="${principal.member.num}" />
  <div class="form-group">
    <label for="userid">회원아이디(이메일)</label>
    <input type="email" value="${principal.member.userid}" class="form-control" placeholder="Enter userid" id="userid" readonly>
  </div>
  
  <c:if test ="${empty principal.member.oauth}">
  <div class="form-group">
    <label for="userpw">비밀번호</label>
    <input type="password" class="form-control" placeholder="Enter userpw" id="userpw">
  </div>
  </c:if>
  
  <div class="form-group">
    <label for="username">이름</label>
    <input type="text" value="${principal.member.username}" class="form-control" placeholder="Enter username" id="username" readonly>
  </div>
  
  <c:if test ="${empty principal.member.oauth}">
  <div class="form-group">
    <label for="userphonenum">전화번호</label>
    <input type="text" value="${principal.member.userphonenum}" class="form-control" placeholder="Enter userphonenum" id="userphonenum" >
  </div>
  </c:if>
 
</form>
<c:if test ="${empty principal.member.oauth}">
 	<button id="btn-update" class="btn btn-primary">회원정보 수정하기</button>
	</div>
	</c:if>
	
	<script src="/js/member.js"></script>
	
	<%@ include file="../layout/footer.jsp"%>


