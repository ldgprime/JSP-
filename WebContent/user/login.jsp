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
	<h2 class="">로그인</h2>
	<br />
	<form action="/coffee/user?cmd=loginProc" method="post">
		<div class="form-group">
			<label for="username">아이디:</label>
			<input name="username" type="id" class="form-control" value="${cookie.usernameCookie.value}" placeholder="아이디를 입력해주세요." />
		</div>
		<div class="form-group">
			<label for="pwd">비밀번호:</label>
			<input name="password" type="password" class="form-control" placeholder="비밀번호를 입력해주세요." />
		</div>
		<div class="form-group form-check">
			<label class="form-check-label"> 
			    <c:choose>
					<c:when test="${empty cookie.usernameCookie.value}">
						<input class="form-check-input" type="checkbox" name="rememberMe"> 아이디 저장				
                    </c:when>
					<c:otherwise>
						<input class="form-check-input" type="checkbox" name="rememberMe" checked> 아이디 저장
                    </c:otherwise>
				</c:choose>
			</label>
		</div>
		<button type="submit" class="btn btn-primary p-3 px-xl-4">로그인</button>
	</form>
</div>



<%@ include file="../include/footer.jsp"%>