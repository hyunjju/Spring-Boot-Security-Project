<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>
<style>
#footer {
	width: 100%;
	height: 10px;
	clear: both; /*위쪽의 레이아웃에 적용된 float속성을 제거함으로써 footer하단 영역이 
content의 빈공백으로 올라가서 ui가 깨지는 형상을 막을 수 있다.*/
}

.card-img-top {
	width: 100%;
	height: 10rem;
	overflow: hidden;
	margin: 0 auto;
}

.card-img-top2 {
	width: 90%;
	height: 17rem;
	overflow: hidden;
	margin: 0 auto;
}

.imgClick {
	width: 100%;
	height: 100%;
	overflow: hidden;
	margin: 0 auto;
}

.col {
	margin-top: 30px;
}

#asd{
	
	max-height:800px;
	max-width:100%;
	
}
#asd1{
	
	max-height:800px;
	max-width:100%;
}
</style>


<div class="container">
	<div class="">
		<!-- style="float: left; width: 60%;" -->
		<!-- <div class="content" > -->
		<h3 align="center">인기순위</h3>

		<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<!-- style="width: 50%; margin: 0 auto" -->
						
				<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
			</ol>
			
			<div class="carousel-inner">
			<button class="carousel-control-prev" type="button" data-target="#carouselExampleIndicators" data-slide="prev">
				<span style="background-color: #BFBFC4;" class="carousel-control-prev-icon" aria-hidden="true"></span> <span class="sr-only">Previous</span>
			</button>
			<button class="carousel-control-next" type="button" data-target="#carouselExampleIndicators" data-slide="next">
				<span style="background-color: #BFBFC4;" class="carousel-control-next-icon" aria-hidden="true"></span> <span class="sr-only">Next</span>
			</button>
			
			<c:forEach var="cocktaildetail" items="${cocktaildetail.content}" begin="0" end="0">
			
				<div class="carousel-item active">
				 <a href="/auth/cocktailDetail/${cocktaildetail.cocktailnum}" class="imgClick"> 
					<img src="${cocktaildetail.imgpath}" class="d-block w-100" alt="..." id="asd">
					</a>
				</div>
						</c:forEach>
						
			<c:forEach var="cocktaildetail" items="${cocktaildetail.content}" begin="1" end="2">
			
				<div class="carousel-item">
				 <a href="/auth/cocktailDetail/${cocktaildetail.cocktailnum}" class="imgClick"> 
					<img src="${cocktaildetail.imgpath}" class="d-block w-100" alt="..." id="asd1">
					</a>
				</div>
						</c:forEach>
	<%-- 	
		<c:forEach var="cocktaildetail" items="${cocktaildetail.content}" begin="3" end="3">
			
				<div class="carousel-item">
					<img src="${cocktaildetail.imgpath}" class="d-block w-100" alt="...">
				</div>
						</c:forEach> --%>
				</div>
			
			</div>
				
			
			
		</div>
		
	</div>

	<br>
	<hr class="my-2">
	<br>

	<h3 align="center">주정</h3>

	<div class="row row-cols-1 row-cols-md-5 mb-5">


		<%--  <c:forEach var="cocktaildetail" items="${cocktaildetail.content}"> --%>

		<div class="col">
			<div class="card">
			 <input type="hidden" id="gin" name = "gin" value="진" /> 
				<a href="#" class="imgClick"> <img src="/image/jin.jpeg" class="card-img-top" alt="...">
				</a>
			
			</div>
			
        <h5 class="card-title" align="center">Gin</h5> 
      
		</div>
		
		<div class="col">
			<div class="card">
				<a href="#" class="imgClick"> <img src="/image/rum.jpeg" class="card-img-top" alt="...">
				</a>
			</div>
			
        <h5 class="card-title" align="center">Rum</h5> 
      
		</div>
		
		<div class="col">
			<div class="card">
				<a href="#" class="imgClick"> <img src="/image/vodka.jpeg" class="card-img-top" alt="...">
				</a>
			</div>
			
        <h5 class="card-title" align="center">Vodka</h5> 
      
		</div>
		
		<div class="col">
			<div class="card">
				<a href="#" class="imgClick"> <img src="/image/whiskey.jpeg" class="card-img-top" alt="...">
				</a>
			</div>
			
        <h5 class="card-title" align="center">Whiskey</h5> 
      
		</div>
		
		<div class="col">
			<div class="card">
				<a href="#" class="imgClick"> <img src="/image/thquila.jpeg" class="card-img-top" alt="...">
				</a>
			</div>
			
        <h5 class="card-title" align="center">Tequila</h5> 
      
		</div>

		<%--   </c:forEach> --%>
	</div>








	<hr class="my-2">
	<br>

	<h3 align="center">도수</h3>
	
	<div class="row row-cols-1 row-cols-md-2 ">


		<%--  <c:forEach var="cocktaildetail" items="${cocktaildetail.content}"> --%>

		<div class="col2">
			<div class="card2" align="center">
				<a href="/auth/cocktailListAlcDesc" class="imgClick"> <img src="/image/알콜.jpeg" class="card-img-top2" alt="...">
				</a>
			</div>
			
        <h5 class="card-title" align="center">Alcohol</h5> 
      
		</div>

<div class="col2">
			<div class="card2" align="center">
				<a href="/auth/cocktailListNonAlc" class="imgClick"> <img src="/image/논알콜.jpeg" class="card-img-top2" alt="...">
				</a>
			</div>
			
        <h5 class="card-title" align="center">NonAlcohol</h5> 
      
		</div>

</div>

</div>


<%-- <c:forEach var="board" items="${boards.content}"> --%>


<%-- <div class="card m-2">
			<!--  style="width: 300px"-->
			<div class="card-body">
				<h4 class="card-title">"${board.title}"</h4>
				<a href="/board/${board.num}" class="btn btn-primary">상세보기</a>
			</div>
		</div> --%>
<%-- 	</c:forEach>
 --%>
<%-- <ul class="pagination justify-content-center">
		<c:choose>
			<c:when test="${boards.first}">
				<li class="page-item disabled"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${boards.last}">
				<li class="page-item disabled"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
			</c:otherwise>
		</c:choose>
	</ul> --%>

<div id="footer"></div>



<%@ include file="layout/footer.jsp"%>


