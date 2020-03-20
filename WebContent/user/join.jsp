<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp"%>

<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />

<div class="container">
	<h2 class="">회원가입</h2>
	<br>
	<form action="/coffee/user?cmd=joinProc" method="post" onsubmit="return vaildationCheck()">
		<div class="form-group">
			<label for="username">아이디:</label>
			<button onclick="usernameCheck()" type="button" class="btn btn-primary" style="float: right">중복확인</button>
			<input id="username" name="username" type="text" class="form-control" placeholder="아이디를 입력하세요." />
		</div>
		<div class="form-group">
			<label for="password">비밀번호:</label>
			<input name="password" type="password" class="form-control" placeholder="비밀번호를 입력하세요." />
		</div>
		<div class="form-group">
			<label for="email">이메일:</label>

			<input name="email" type="email" class="form-control" placeholder="이메일을 입력하세요." />

		</div>
		<div class="form-group">
			<label for="Address">주소:</label>
			<button type="button" onClick="goPopup();" class="btn btn-primary" style="float: right">주소 찾기</button>
			<input id="address" name="address" type="text" class="form-control" placeholder="" readonly="readonly" />
		</div>
		<button type="submit" class="btn btn-primary p-3 px-xl-4">회원가입</button>
	</form>

</div>





<%@ include file="../include/footer.jsp"%>




<script>
	var repeatUserNameCheck = false;
	
	
	function usernameCheck(){
		var username = $("#username").val();			
		if(username === "" || username === null){	
			alert('username이 입력되지 않았습니다.')
			return
	}
		
	var user = {
		username:username
		} 
	
	// JSON.parse(제이슨데이터) 자바스크립트오브젝트로 리턴 수신시
	// JSON.stringify(자바스크립트오브젝트) 제이슨데이터로 리턴 송신시
	

	

		
		
		
	$.ajax({
		type:"POST",
		url:"/coffee/user?cmd=usernameCheck",
		dataType:"text",// 안적어도 됨
		contentType:"application/json",	
	// application/x-www-form-urlencoded
	// application/json
	// multipart/form-data
		data:JSON.stringify(user),
	// user
	// "username="+username
	// JSON.stringify(user)
		success:function(data){// data = 자동 주입됨.
			if(data === "ok"){
				alert("사용할 수 있는 아이디입니다.")
				repeatUserNameCheck = true;
				$('#username').attr('readonly', 'readonly');
			}else{
				alert("사용할 수 없는 아이디입니다.")
			}			
		},
		error:function(data){// data = 자동 주입됨.
			alert("통신실패");					
		},										
	});			
		
	}
	
	
	function vaildationCheck(){
		if(!repeatUserNameCheck){
			alert('아이디 중복확인을 해주세요');
			
		}
		
		
		return repeatUserNameCheck;
		
}
	
	
	function goPopup() {
		var pop = window.open("/coffee/user/jusoPopup.jsp", "pop",
				"width=570,height=420, scrollbars=yes, resizable=yes");
	}
	
	function jusoCallBack(roadFullAddr) {
		$('#address').val(roadFullAddr)
	}
	







    
    </script>