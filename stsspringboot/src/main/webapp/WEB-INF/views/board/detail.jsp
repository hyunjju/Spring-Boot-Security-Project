<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<div class="container">
	<button class="btn btn-secondary" onclick="history.back()">돌아가기</button>

	<c:if test="${board.member.userid==principal.member.userid}">
		<a href="/board/${board.num}/updateForm" class="btn btn-secondary">수정</a>
		<button id="btn-delete" class="btn btn-secondary">삭제</button>
	</c:if>
	<br /> <br />

	<div>
		글번호 : <span id="num"><i>${board.num} </i></span> 작성자 : <span><i>${board.member.userid} </i></span> <br />
	</div>

	<div>

		<h3>${board.title}</h3>
	</div>
	<hr />
	<div>

		<div>${board.content}</div>
	</div>
	<hr />

	<div class="card">
		<form>
			<input type="hidden" id="usernum" value="${principal.member.num}" />
			<input type="hidden" id="boardnum" value="${board.num}" />
			<div class="card-body">
				<textarea id="reply-content" class="form-control" rows="1"></textarea>
			</div>
			<div class="card-footer">
				<button type="button" id="btn-reply-save" class="btn btn-primary">작성</button>
			</div>
		</form>
	</div>
	<br/>
	<div class="card">
		<div class="card-header">댓글 더보기</div>
		<ul id="reply-box" class="list-group">
			<c:forEach var="reply" items="${board.replys}">
				<li id="reply-${reply.num}" class="list-group-item d-flex justify-content-between">
					<div>${reply.content}</div>
					<div class="d-flex">
						<div class="font-italic">작성자 : ${reply.member.userid} &nbsp;</div>
						<c:if test="${reply.member.num eq principal.member.num}">
							<button onClick="index.replyDelete(${board.num}, ${reply.num})" class="badge">삭제</button>
						</c:if>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>



</div>

<script>
	$('.summernote').summernote({
		tabsize : 2,
		height : 300
	});
</script>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>


