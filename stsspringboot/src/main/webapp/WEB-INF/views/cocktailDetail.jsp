<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>


<div class="container">

	<button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
	<br/>	<br/>	<br/>

<div class="container">
	<h3>${cocktaildetail.cocktailname}</h3>  <p align="right" >조회수: ${cocktaildetail.cnt }</p>
	<hr/>
		<br/>	<br/>	<br/>
		
		
<div>
  <div class="row no-gutters">
    <div >
      <img src="${cocktaildetail.imgpath}" style="width:500px;">
    </div>
    <div class="col-md-5">
      <div class="card-body">
      <h3> 재료 </h3>
   		 <p class="card-text">${cocktaildetail.ingredients}</p><br><br>
   		 <h5> 설명 </h5><br>
   		        <p class="card-text">${cocktaildetail.content}</p>
      </div>
    </div>
  </div>
</div>

	
	

	

		





</div>
</div>
<script>
	$('.summernote').summernote({
		tabsize : 2,
		height : 300
	});
</script>
<script src="/js/board.js"></script>
<%@ include file="layout/footer.jsp"%>


