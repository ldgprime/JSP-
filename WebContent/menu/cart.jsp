<%@page import="com.ldg.coffee.ViewModel.BillUserProductVM"%>
<%@page import="com.ldg.coffee.Model.Product"%>
<%@page import="java.util.List"%>
<%@page import="java.net.URLDecoder"%>
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

<!-- START cart -->
<section class="ftco-section ftco-cart py-3">
	<div class="container">
		<form action="/coffee/menu?cmd=bill" method="Post">
			<div class="row">
				<div class="col-md-12 ftco-animate">
					<div class="cart-list">
						<h4>장바구니</h4>
						<table id="carttable" class="table">
							<thead class="thead-primary">
								<tr class="text-center">
									<th>&nbsp;</th>
									<th>상품</th>
									<th>가격</th>
									<th>수량</th>
									
								</tr>
							</thead>
							<tbody>
								<c:forEach var="product" items="${products}" varStatus="status">
									<tr class="text-center">
										<td class="product-remove"><a href="/coffee/menu?cmd=cartDeleteProc&id=${product.id }"><span class="icon-close"></span></a></td>
										<td class="product-name">
											<h3>${product.productname }</h3>
										</td>
										<td id="price" class="price">${product.price }&#8361;</td>
										<td class="quantity">
											<div class="input-group mb-3">
												<input type="number" name="count" class="quantity form-control input-number" value="1" min="1" max="100">
											</div>
										</td>										
									</tr>
									<!-- END TR-->
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row justify-content-end">
				<div class="col col-lg-3 col-md-6 mt-5 cart-wrap ftco-animate">

					<p class="text-center">
						<button type="submit" class="btn btn-dark py-2 px-5">결제</button>
					</p>
				</div>
			</div>
		</form>
	</div>
</section>
<!-- END cart -->
<c:if test="${not empty sessionScope.user.id }">
<!-- START order -->
<section class="ftco-section ftco-cart">
	<div class="container">
		<div class="row">
			<div class="col-md-12 ftco-animate">
				<div class="cart-list">
					<h4>구매내역</h4>
					<table class="table">
						<thead class="thead-primary">
							<tr class="text-center">
								<th>상품</th>
								<th>가격</th>
								<th>수량</th>
								<th>주문자</th>
								<th>주문일시</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="bupVM" items="${bupVMs }">
								<tr class="text-center">
									<td class="price">${bupVM.product.productname }</td>
									<td class="price">${bupVM.bill.price }&#8361;</td>
									<td class="price">${bupVM.bill.count }</td>
									<td class="total">${bupVM.user.username }</td>
									<td class="price">${bupVM.bill.createtime }</td>
								</tr>
								<!-- END TR-->
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="row justify-content-end">
			<div class="col col-lg-3 col-md-6 mt-5 cart-wrap ftco-animate">
				<div class="cart-total mb-3">
					<h3>구매내역 총액</h3>
					<hr>
					<p class="d-flex total-price">
						<span>총액</span> <span id="totalbillprice"> </span>
					</p>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- END order -->
</c:if>




<%@ include file="../include/footer.jsp"%>


<script type="text/javascript">

<%
int billsum = 0;
if(request.getSession().getAttribute("user") != null){
List<BillUserProductVM> bupVMs = (List<BillUserProductVM>) request.getAttribute("bupVMs");
			
			for (int i = 0; i < bupVMs.size(); i++) {
				billsum += (bupVMs.get(i).getBill().getPrice() * bupVMs.get(i).getBill().getCount());
			}
}
%>
	var billsum =<%=billsum%>;
	var totalbillprice = document.getElementById('totalbillprice')
	totalbillprice.innerText = billsum + '₩';

</script>




























</script>