<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
      <div>
        <h2>마이페이지</h2>       
        <a href="/coffee/menu?cmd=cart" type="button" class="btn btn-primary p-3 px-xl-4" style="float:right">구매내역 확인</a>
      </div>
     <br/>
     <br/>
     <br/>
      <form action="/coffee/user?cmd=profileProc" method="Post">
        <div class="form-group">
          <label for="username">아이디:</label>
          <input
            value="${user.username }"
            name="username"
            type="text"
            class="form-control"
            placeholder="아이디를 입력하세요."
          />
        </div>
        <div class="form-group">
          <label for="password">비밀번호:</label>
          <input
            value="${user.password}"
          	name="password"
            type="password"
            class="form-control"
            placeholder="비밀번호를 입력하세요."
           
          />
        </div>
        <div class="form-group">
          <label for="email">이메일:</label>          
          <input
           value="${user.email }"
          	name="email"
            type="email"
            class="form-control"
            placeholder="이메일을 입력하세요."           
          />
        </div>
        <div class="form-group">
          <label for="Address">주소:</label>         
          <button type="button" onClick="goPopup();" class="btn btn-primary" style="float: right">주소 수정</button>        
          <input
           value="${user.address }"
          	name="address"
            type="text"
            class="form-control"
            placeholder=""           
          />
        </div>     
        <button type="submit" class="btn btn-primary p-3 px-xl-4">수정</button>
      </form>
      </div>




<%@ include file="../include/footer.jsp"%>  


<script>

function goPopup() {
	var pop = window.open("/coffee/user/jusoPopup.jsp", "pop",
			"width=570,height=420, scrollbars=yes, resizable=yes");
}

function jusoCallBack(roadFullAddr) {
	$('#address').val(roadFullAddr)
}


</script>  