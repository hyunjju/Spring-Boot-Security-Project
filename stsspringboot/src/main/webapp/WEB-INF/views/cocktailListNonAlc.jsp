<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>
<style>
.card-img-top{
	 width:150px;
    height:130px;
    overflow:hidden;
    margin:0 auto;
}
.imgClick{
 width:150px;
    height:130px;
    overflow:hidden;
    margin:0 auto;
}
.col{
margin-top:30px;

.dropdown{
  position : relative;
  display : inline-block;
}

}
</style>
<div class="container">

<div class="dropdown" align="right">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-expanded="false">
    정렬
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
 	<a class="dropdown-item" href="/auth/cocktailList">전체보기</a>
    <a class="dropdown-item" href="/auth/cocktailListAlcDesc">도수 높은 순(논알콜 제외)</a>
    <a class="dropdown-item" href="/auth/cocktailListAlc">도수 낮은 순(논알콜 제외)</a>
    <a class="dropdown-item" href="/auth/cocktailListNonAlc">논알콜(ABC순)</a>
  </div>
</div>

<h3> 논알콜(ABC) </h3><br>
<hr class="my-2" ><br>
<div class="row row-cols-1 row-cols-md-5 mb-5" >


  <c:forEach var="cocktaillistnonalc" items="${cocktaillistnonalc.content}">
<c:if test="${cocktaillistnonalc.alc == 0}">
  <div class="col" >
    <div class="card">
 <a href="/auth/cocktailDetail/${cocktaillistnonalc.cocktailnum}" class="imgClick"> 
     <img src="${cocktaillistnonalc.imgpath}" class="card-img-top" alt="..."> 
      </a>
      <div class="card-body">
        <h5 class="card-title">${cocktaillistnonalc.cocktailname}</h5> 
      </div>
    </div>
  </div>
   </c:if>
  </c:forEach>
</div>


</div>

<%@ include file="layout/footer.jsp"%>


