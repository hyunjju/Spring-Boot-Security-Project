let index ={
	init: function(){
		$("#btn-save").on("click", ()=>{
		this.save();
		});
		$("#btn-update").on("click", ()=>{
		this.update();
		});
	},
	
	save:function(){
		// alert('member의 save 함수 호출됨');
		let data = {
			userid:$("#userid").val(),
			userpw:$("#userpw").val(),
			username:$("#username").val(),
			userphonenum:$("#userphonenum").val()
		};
		 //  console.log(data);
		   
		  // ajax 호출시 default가 비동기 호출 
		  //ajax 통신을 이용해서 3개의 데이터를 Json으로 변경 insert 요청
		  $.ajax({
		 	type:"POST",
		 	url:"/auth/joinMemberProc",
		 	data:JSON.stringify(data), // http body데이터 
		 	contentType:"application/json; charset=utf-8", // body데이터가 어떤 타입인지(MIME)
		 	dataType:"json" // 요청을 서버로 해서 응답이 왔을 때 기본적으로 모든것이 문자열(생긴게 json이라면) => javascript오브젝트로 변
		  }).done(function(resp){
		  	if(resp.status==500){
		  	  alert("회원가입에 실패하였습니다.");
		  	}else{
		  	alert("회원가입이 완료되었습니다.");
		  	location.href = "/";
		  	}
		  	
		  }).fail(function(error){
		  	alert(JSON.stringify(error));
		  }); 
		
		
		  
	},
	update:function(){
		
		let data = {
			num:$("#num").val(),
			userid:$("#userid").val(),
			userpw:$("#userpw").val(),
			userphonenum:$("#userphonenum").val()
		};

		  $.ajax({
		 	type:"PUT",
		 	url:"/member",
		 	data:JSON.stringify(data), // http body데이터 
		 	contentType:"application/json; charset=utf-8", // body데이터가 어떤 타입인지(MIME)
		 	dataType:"json" // 요청을 서버로 해서 응답이 왔을 때 기본적으로 모든것이 문자열(생긴게 json이라면) => javascript오브젝트로 변
		  }).done(function(resp){
		  	alert("회원수정이 완료되었습니다.");
		  	//console.log(resp);
		  	location.href = "/";
		  }).fail(function(error){
		  	alert(JSON.stringify(error));
		  }); 
		
		
		  
	}
}
index.init();
