<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>PickFL - own-flower</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: Green - v4.7.0
  * Template URL: https://bootstrapmade.com/green-free-one-page-bootstrap-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
  <style>
    .circle {
    width : 1.5rem;
    height : 1.5rem;
    border-radius: 50%;
  }

    .card img {
      width: 15rem;
      height: 15rem;
      margin: auto;
    }

    #selected-btn {
      width : 3rem;
      height : 3rem;
      position: fixed;
      bottom: 5rem;
      right: 10px;
    }

    #selected {
      position: fixed;
      bottom: 1rem;
      right: 10px;
      width: 30rem;
      height: 40rem;
      z-index: 599;
      background-color: powderblue;
    }
    
    #orderNum{
    	width: 5vw;
    }
  </style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>

<body>
  
	<%@include file="/WEB-INF/views/common/header.jsp" %>

  <main id="main">
    <section id="hero">
        <div class="carousel-inner" role="listbox">
          <!-- Slide 1 -->
          <div class="carousel-item active" style="background-image: url(assets/img/slide/own-1.jpg)">
            <div class="carousel-container">
              <div class="container">
                <h2 class="animate__animated animate__fadeInDown"> <span>나만의 꽃다발</span></h2>
                <p class="animate__animated animate__fadeInUp">나만의 조합으로 꽃다발을 만들어 보세요.</p>
              </div>
            </div>
          </div>
      </div>
    </section><!-- End Hero -->
    <section class="inner-page">
      <div class="contatiner mb-4" id="search">
        <div class="row">
          <div class="col-md-3"></div>
          <div class="col-md-1">
            <div class="float-md-start"><a href="own-flower"><h5>꽃</h5></a></div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-3"></div>
          <div class="col-md-5">
            <div>
              <div class="d-flex align-items-center">
                <div class="me-auto">색상별 검색</div>
                <div class="mx-3 circle" style="background-color: red;" onClick=sendColor('red')></div>
                <div class="mx-3 circle" style="background-color: orange;" onClick=sendColor('orange')></div>
                <div class="mx-3 circle" style="background-color: gold;" onClick=sendColor('yello')></div>
                <div class="mx-3 circle" style="background-color: seagreen;" onClick=sendColor('green')></div>
                <div class="mx-3 circle" style="background-color: cornflowerblue;" onClick=sendColor('blue')></div>
                <div class="mx-3 circle" style="background-color: rebeccapurple;" onClick=sendColor('purple')></div>
                <div class="mx-3 circle" style="background-color: grey;" onClick=sendColor('white')></div>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-3"></div>
          <div class="col-md-5">
            <div>
            	<form action="own-flower" method="get">
	              <div class="d-flex align-items-center">
	                <div class="me-auto">이름으로 검색</div>
	                <div class="input-group input-group-sm m-3">
	                  <input type="text" class="form-control" name="searchName" placeholder="이름을 입력하세요">
	                  <button class="btn btn-outline-secondary" type="submit">검색</button>
	                </div>
	              </div>
            	</form>
            </div>
          </div>
        </div>
      </div>
      <div class="container">
        <div class="row row-cols-1 row-cols-md-4 g-4">
        <c:forEach items="${productList}" var="p">        
          <div class="col">
            <div class="card p-4" onClick=getParam(${p.product_no})>
              <img src="image?fileName=${p.product_image}" class="card-img-top" alt="...">
              <div class="card-body">
                <h5 class="card-title">${p.product_name}</h5>
                <p class="card-text">${p.product_simple}</p>
                <div>${p.product_price}원</div>
              </div>
            </div>
          </div>
        </c:forEach>
        </div>
      </div>
      
      
      <button class="back-to-top d-flex align-items-center justify-content-center" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight"><i class="bi bi-archive"></i></button>

		<div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
		  <div class="offcanvas-header">
		    <h5 id="offcanvasRightLabel">현재 꽃다발</h5>
		    <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
		  </div>
		  <div class="offcanvas-body">
		  <form action="current-flower" method="post">
			    <table class="table">
			    	<tr>
			    		<td>선택한 꽃</td>
			    		<td>수량</td>
			    		<td>가격</td>
			    		<td></td>
			    	</tr>
			    	<c:forEach items="${list}" var="l" varStatus="s">
				    	<tr>
				    		<td id="pname${s.count}">${l.productName}</td>
				    		<td><input type="number" class="form-control" id="orderNum${s.count}" name="orderNum${s.count}" value="${l.orderNum }" min="1"></td>
				    		<td><input type="number" class="form-control" id="price${s.count}" value="${l.productPrice}" readonly></td>
				    		<td> <button type="button" onClick=delFlower(${l.productNo})>삭제</button> </td>
				    	</tr>
			    	</c:forEach>
		    	</table>
			    <label for="bouquet-price">전체 가격</label>
			    <input type="number" class="form-control" id="bouquet-price" name="bouquet-price" readonly>
			    <label for="bouquet-name">꽃다발이름</label>
			    <input type="text" class="form-control" id="bouquet-name" name="bouquet-name">
			    <label for="wrqp-color">포장색</label>
	            <select class="form-select" id="wrap-color" name="wrap-color">
	                <option selected>색상 선택</option>
	                <option value="red">빨강색</option>
	                <option value="yello">노랑색</option>
	                <option value="green">초록색</option>
	                <option value="blue">파랑색</option>
	                <option value="purple">보라색</option>
	                <option value="white">무채색</option>
	            </select>
	            <input type="hidden" name="row" value="${fn:length(list)}">
			    <button type="submit" class="btn-success"> Pick! </button>
		  </form>
		    
		  </div><!-- offcanvas-body end -->
		</div>
    </section>

  </main><!-- End #main -->
  
  <%@include file="/WEB-INF/views/common/footer.jsp" %>


  <!-- Vendor JS Files -->
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

	<script type="text/javascript">
	
		function sendColor(color){
			var form = document.createElement('form');
			form.setAttribute('method', 'post');
			form.setAttribute('action', 'http://localhost:8989/PickFL/own-flower');
			document.charset = 'utf-8';
			
			newInput = document.createElement('input');
			newInput.setAttribute('type', 'hidden');
			newInput.setAttribute('name', 'product_color');
			newInput.setAttribute('value', color);
			form.appendChild(newInput);
			document.body.appendChild(form);
			form.submit();
		}
    	
	
		function getParam(no){
    		location.href = 'own-flower-detail?no=' + no;
    	}
		
		function delFlower(no){
      		location.href = 'delete-flower?no=' + no;
		};
		
		
		$("#orderNum").change(function(){
			var num = $("#orderNum${l.productNo}").val();
			var price = $("#price${p.product_price}").val();
			var result = num * price;
			$("#price${p.product_price}").val('result');
			
		});
		$(function(){
			let totalPrice = 0;
			let row = ${fn:length(list)};
	        for(let i = 1; i <= row; i++ ){
	          let orderNum = parseInt($("#orderNum" + i).val());
	          let price = parseInt($("#price" + i).val());
	          totalPrice += orderNum * price;
	        }
	        $("#bouquet-price").val(totalPrice);
		})
		
    </script>
</body>

</html>