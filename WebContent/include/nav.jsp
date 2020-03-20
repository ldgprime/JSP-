<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <title>Coffee - Free Bootstrap 4 Template by Colorlib</title>
    <meta charset="utf-8" />
    

    
    
    
    
    
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />

    <link
      href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700"
      rel="stylesheet"
    />
    <link
      href="https://fonts.googleapis.com/css?family=Josefin+Sans:400,700"
      rel="stylesheet"
    />
    <link
      href="https://fonts.googleapis.com/css?family=Great+Vibes"
      rel="stylesheet"
    />
    

    

    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css" />
    <link rel="stylesheet" href="css/animate.css" />

    <link rel="stylesheet" href="css/owl.carousel.min.css" />
    <link rel="stylesheet" href="css/owl.theme.default.min.css" />
    <link rel="stylesheet" href="css/magnific-popup.css" />

    <link rel="stylesheet" href="css/aos.css" />

    <link rel="stylesheet" href="css/ionicons.min.css" />

    <link rel="stylesheet" href="css/bootstrap-datepicker.css" />
    <link rel="stylesheet" href="css/jquery.timepicker.css" />

    <link rel="stylesheet" href="css/flaticon.css" />
    <link rel="stylesheet" href="css/icomoon.css" />
    <link rel="stylesheet" href="css/style.css" />
    







  </head>
  <body>
    <!-- START nav -->
    <nav
      class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light"
      id="ftco-navbar"
    >
      <div class="container">
        <a class="navbar-brand" href="/coffee">Coffee<small>Beans</small></a>
        <button
          class="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#ftco-nav"
          aria-controls="ftco-nav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="oi oi-menu"></span> Menu
        </button>
        <div class="collapse navbar-collapse" id="ftco-nav">
        <ul class="navbar-nav ml-auto">
        
        	<c:choose>
					<c:when test="${not empty sessionScope.user}">
			<li class="nav-item">
              <a href="/coffee?cmd=" class="nav-link">홈</a>
            </li>
                        <li class="nav-item">
              <a href="/coffee/menu?cmd=menu" class="nav-link">메뉴</a>
            </li>
                        <li class="nav-item">
              <a href="/coffee/user?cmd=profile" class="nav-link">마이페이지</a>
            </li>
                       <li class="nav-item">
              <a href="/coffee/menu?cmd=cart" class="nav-link">장바구니</a>
            </li>
                                 <li class="nav-item">
              <a href="/coffee/board?cmd=list" class="nav-link">구매후기</a>
            </li>
                 <li class="nav-item">
              <a href="/coffee/user?cmd=logout" class="nav-link">로그아웃</a>
            </li>
					</c:when>
					<c:otherwise>
			<li class="nav-item">
              <a href="/coffee?cmd=" class="nav-link">홈</a>
            </li>
            <li class="nav-item">
              <a href="/coffee/menu?cmd=menu" class="nav-link">메뉴</a>
            </li>
            <li class="nav-item">
              <a href="/coffee/user?cmd=join" class="nav-link">회원가입</a>
            </li>
            <li class="nav-item">
              <a href="/coffee/user?cmd=login" class="nav-link">로그인</a>
            </li>
            <li class="nav-item">
              <a href="/coffee/menu?cmd=cart" class="nav-link">장바구니</a>
            </li>
                     <li class="nav-item">
              <a href="/coffee/board?cmd=list" class="nav-link">구매후기</a>
            </li>
						
			</c:otherwise>
			</c:choose>
			
		    <c:if test="${sessionScope.user.username eq 'admin' }">
<!-- 		      <li class="nav-item">
              <a href="/coffee/admin?cmd=user" class="nav-link text-primary">메뉴관리</a>
              </li> -->
		      <li class="nav-item">
              <a href="/coffee/admin?cmd=user" class="nav-link text-primary">회원관리</a>
              </li>
              <li class="nav-item">
              <a href="/coffee/admin?cmd=board" class="nav-link text-primary">구매후기관리</a>
              </li>
              <li class="nav-item">
              <a href="/coffee/admin?cmd=bill" class="nav-link text-primary">구매내역관리</a>
              </li>
		    </c:if>
				
		</ul>
         <!--  <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a href="/coffee?cmd=" class="nav-link">홈</a>
            </li>
            <li class="nav-item">
              <a href="/coffee/menu?cmd=menu" class="nav-link">메뉴</a>
            </li>
            <li class="nav-item">
              <a href="/coffee/user?cmd=join" class="nav-link">회원가입</a>
            </li>
            <li class="nav-item">
              <a href="/coffee/user?cmd=login" class="nav-link">로그인</a>
            </li>
            <li class="nav-item">
              <a href="/coffee/user?cmd=profile" class="nav-link">마이페이지</a>
            </li>
            <li class="nav-item">
              <a href="/coffee/menu?cmd=cart" class="nav-link">장바구니</a>
            </li>
            <li class="nav-item">
              <a href="/coffee/board?cmd=list" class="nav-link">구매후기</a>
            </li>
          </ul> -->
        </div>
      </div>
    </nav>
    <!-- END nav -->