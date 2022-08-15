<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>

 <div class="container">
 <br>
<h3> 인기순위 </h3><br>
<hr class="my-2" ><br>



  
  <c:forEach var="cocktaildetail" items="${cocktaildetail.content}">
 
<a href="/auth/cocktailDetail/${cocktaildetail.cocktailnum}" class="imgClick" style=" text-decoration: none; color: black;"> 

  <div class="card mb-4" style="width: 100%; height:180px ;" >
  
   <div class="row no-gutters" style="margin:10px;">
  
   <div class="col-md-3" align="center" >
   
      <img src="${cocktaildetail.imgpath}"  alt="..." style="height:150px;">
 
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title">${cocktaildetail.cocktailname}</h5>
        <p class="card-text">${cocktaildetail.content}</p>
        <p class="card-text"><small class="text-muted">조회수 : ${cocktaildetail.cnt }</small></p>
      </div>
   </div>
  </div>
   

</div>

      </a> 

    </c:forEach>
  
     </div>









<%@ include file="layout/footer.jsp"%>