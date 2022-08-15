<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="layout/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅</title>

</head>
<div class="container">

	
	<h3>무엇이든 물어보세요</h3>
	<input type="text"  class="form-control" id="question"> </br>
	<input type="button"  class="btn btn-primary" id="chatbotbtn" value="챗봇 전송" />


</div>
<script>
	window.addEventListener("load", function(e){
		var question = document.getElementById("question");
		var chatbotbtn =  document.getElementById("chatbotbtn");
		chatbotbtn.addEventListener('click', function(e){
			var request;
			request = new XMLHttpRequest();
		    var queryString = "chatbot?question=" + question.value;

			request.open('GET', queryString, true);
			request.send('');

			request.addEventListener('load', function() {
				alert(JSON.parse(request.responseText).answer);
			});

		});
	
		
	});
</script>
</html>
		
		
<%@ include file="layout/footer.jsp"%>