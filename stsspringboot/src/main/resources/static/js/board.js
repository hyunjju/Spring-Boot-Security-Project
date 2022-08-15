let index ={
	init: function(){
		$("#btn-save").on("click", ()=>{
		this.save();
		});
		$("#btn-delete").on("click", ()=>{
		this.deleteById();
		});
		$("#btn-update").on("click", ()=>{
		this.update();
		});
		$("#btn-reply-save").on("click", ()=>{
		this.replySave();
		});
	
	},
	
	save:function(){
		// alert('member의 save 함수 호출됨');
		let data = {
			title:$("#title").val(),
			content:$("#content").val()
		};
		
		  $.ajax({
		 	type:"POST",
		 	url:"/api/board",
		 	data:JSON.stringify(data), 
		 	contentType:"application/json; charset=utf-8", 
		 	dataType:"json"
		  }).done(function(resp){
		  	alert("작성이 완료되었습니다.");
		  	console.log(resp);
		  	location.href = "/";
		  }).fail(function(error){
		  	alert(JSON.stringify(error));
		  });   
	},
	
	
	deleteById:function(){
		let id = $("#num").text();
		
		  $.ajax({
		 	type:"DELETE",
		 	url:"/api/board/" + id,
		 	dataType:"json"
		  }).done(function(resp){
		  	alert("삭제가 완료되었습니다.");
		  	console.log(resp);
		  	location.href = "/";
		  }).fail(function(error){
		  	alert(JSON.stringify(error));
		  });   
	},
	
	
	update:function(){
		let num = $("#num").val();
		
		let data = {
			title:$("#title").val(),
			content:$("#content").val()
		};
		
		  $.ajax({
		 	type:"PUT",
		 	url:"/api/board/" + num,
		 	data:JSON.stringify(data), 
		 	contentType:"application/json; charset=utf-8", 
		 	dataType:"json"
		  }).done(function(resp){
		  	alert("수정이 완료되었습니다.");
		  	console.log(resp);
		  	location.href = "/";
		  }).fail(function(error){
		  	alert(JSON.stringify(error));
		  });   
	},
	
	replySave: function(){

			let data = {
					usernum: $("#usernum").val(),
					boardnum: $("#boardnum").val(),
					content: $("#reply-content").val()
			};
			
			
			$.ajax({ 
				type: "POST",
				url: `/api/board/${data.boardnum}/reply`,
				data: JSON.stringify(data),
				contentType: "application/json; charset=utf-8",
				dataType: "json"
			}).done(function(resp){
				alert("댓글작성이 완료되었습니다.");
				location.href = `/board/${data.boardnum}`;
			}).fail(function(error){
				alert(JSON.stringify(error));
			}); 
		},
		
		replyDelete : function(boardnum, replynum){
			$.ajax({ 
				type: "DELETE",
				url: `/api/board/${boardnum}/reply/${replynum}`,
				dataType: "json"
			}).done(function(resp){
				alert("댓글삭제 성공");
				location.href = `/board/${boardnum}`;
			}).fail(function(error){
				alert(JSON.stringify(error));
			}); 
		},
	
}
index.init();
