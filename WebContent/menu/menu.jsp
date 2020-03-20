<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>


<!-- START carousel -->
<section class="home-slider owl-carousel">
	<div class="slider-item" style="background-image: url(images/bg_1.jpg);" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div class="row slider-text justify-content-center align-items-center">
				<div class="col-md-7 col-sm-12 text-center ftco-animate">
					<h1 class="mb-3 mt-5 bread">메뉴</h1>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- END carousel -->

<section class="ftco-menu mb-5 pb-5">
	<div class="container">
		<div class="row justify-content-center mb-5">
			<div class="col-md-7 heading-section text-center ftco-animate">
				<h4 class="mb-4">당신이 좋아하는 커피 원두를 선택하세요.</h4>
				<p>원두 하나하나 정성을 담아 로스팅합니다.</p>
			</div>
		</div>
		<div class="row d-md-flex">
			<div class="col-lg-12 ftco-animate p-md-5">
				<div class="row">
					<div class="col-md-12 d-flex align-items-center">
						<c:forEach var="product" items="${products}" varStatus="status">
							<div class="col-4 text-center">
								<div class="menu-wrap">
									<h3>
										<a href="#">${product.productname }</a>
									</h3>
									<p>
										${product.content1 }<br /> ${product.content2 }<br /> ${product.content3 }<br />
									</p>
									<p class="price">
										<span>${product.price } &#8361;</span>
									</p>
									<p>
										<a href="/coffee/menu?cmd=menuProc&id=${product.id }" class="btn btn-primary btn-outline-primary">장바구니에 담기</a>
									</p>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>


<%@ include file="../include/footer.jsp"%>
