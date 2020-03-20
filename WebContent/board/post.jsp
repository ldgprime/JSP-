<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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


    <script src="js/jquery.min.js"></script>
    <script src="js/jquery-migrate-3.0.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.easing.1.3.js"></script>
    <script src="js/jquery.waypoints.min.js"></script>
    <script src="js/jquery.stellar.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/jquery.magnific-popup.min.js"></script>
    <script src="js/aos.js"></script>
    <script src="js/jquery.animateNumber.min.js"></script>
    <script src="js/bootstrap-datepicker.js"></script>
    <script src="js/jquery.timepicker.min.js"></script>
    <script src="js/scrollax.min.js"></script>	
		
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-bs4.min.js"></script>   

    
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
			<li class="nav-item">
              <a href="/coffee?cmd=" class="nav-link">홈</a>
            </li>
                        <li class="nav-item">
              <a href="/coffee/menu?cmd=menu" class="nav-link">메뉴</a>
            </li>
                       <li class="nav-item">
              <a href="/coffee/menu?cmd=cart" class="nav-link">장바구니</a>
            </li>
                        <li class="nav-item">
              <a href="/coffee/user?cmd=profile" class="nav-link">마이페이지</a>
            </li>
                                 <li class="nav-item">
              <a href="/coffee/board?cmd=list" class="nav-link">구매후기</a>
            </li>
                 <li class="nav-item">
              <a href="/coffee/user?cmd=logout" class="nav-link">로그아웃</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <!-- END nav -->
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />


    <div class="container">     
        <h2>글쓰기</h2>
       
          <form action="/coffee/board?cmd=postProc" method="post">
            <div class="form-group">
              <label for="title">글제목:</label>
              <input
                type="text"
                class="form-control"
                placeholder="제목을 입력하세요."
                name="title"
                required="required"
                maxlength="20"
              />
            </div>
            <div class="form-group">
              <label for="password">글내용:</label>
              <textarea
                id="summernote"
                class="form-control"
                rows="10"
                cols="5"
                name="content"
              >
              </textarea>
            </div>
            <button type="submit" class="btn btn-primary">
              글작성
            </button>
            
          </form>
        </div>    
 
    <script>
      $('#summernote').summernote({
        placeholder: '글을 작성해주세요',
        tabsize: 2,
        height: 300
      });
    </script>
    

 

     <!-- START footer -->
     <footer class="ftco-footer ftco-section img">    
      <div class="row">
        <div class="col-md-12 text-center">
          <p>
            <h5 class="ftco-heading-3">문의처</h5><br />
            <span class="icon icon-map-marker"></span><span class="text"> 부산광역시 부산진구 부전2동 중앙대로 708 5층 506호</span><br />

            <span class="icon icon-phone"> </span
            ><span class="text"> 02) 444 5555</span><br />

            <span class="icon icon-envelope"></span
            ><span class="text"> ssar@nate.com</span><br />

            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            <span class="icon icon-phone">
            Copyright &copy;
            <script>
              document.write(new Date().getFullYear());
            </script>
            All rights reserved | This template is made with
            <i class="icon-heart" aria-hidden="true"></i> by
            <a href="https://colorlib.com" target="_blank">Colorlib</a>
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
          </span>      
        </div>
      </div>   
  </footer>
  <!-- END footer -->
    
  
  </body>
</html>
    