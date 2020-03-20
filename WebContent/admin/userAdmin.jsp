<%@page import="com.ldg.coffee.ViewModel.BoardUserVM"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>


    <!-- START carousel -->
    <section class="home-slider owl-carousel">
      <div
        class="slider-item"
        style="background-image: url(images/bg_3.jpg);"
        data-stellar-background-ratio="0.5"
      >
        <div class="overlay"></div>        
        <div class="container">
          <div
            class="row slider-text justify-content-center align-items-center"
          >
            <div class="col-md-7 col-sm-12 text-center ftco-animate">
              <h1 class="mb-3 mt-5 bread">회원관리</h1>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- END carousel -->

    <!-- START tabel -->
    <section class="ftco-section">      
      <div class="container">
        <div class="row">
          <div class="col-md-12 ftco-animate">
            <div class="cart-list">
              <table class="table">
                <thead class="thead-primary">
                  <tr>
                    <th>&nbsp;</th>
                    <th>번호</th>
                    <th>글제목</th>
                    <th>작성자</th>
                    <th>생성시간</th>
                  </tr>
                </thead>
                <tbody>
    				<c:forEach var="user" items="${users }" varStatus="status">  
                    <tr>
                    <td class="product-remove"><a href="/coffee/admin?cmd=userProc&id=${user.id }"><span class="icon-close"></span></a></td>
                    <td>${user.id }</td>                    
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td>${user.createtime}</td>                 
                    </tr>
                    </c:forEach>
                </tbody>
              </table>
             </div>
           </div>
         </div>
         
         <!-- 
         <div class="row mt-5">
          <div class="col text-center">
            <div class="block-27">
              <ul>
                <li><a href="#">&lt;</a></li>
                <li class="active"><span>1</span></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">&gt;</a></li>
              </ul>
            </div>
          </div>
         </div>
         -->
       </div>   
    </section>
    <!-- START tabel -->


 <%@ include file="../include/footer.jsp"%>
    