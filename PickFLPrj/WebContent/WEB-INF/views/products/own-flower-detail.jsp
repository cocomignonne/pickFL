<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Portfolio Details - Green Bootstrap Template</title>
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
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <style>
  	img {
  		width: 20rem;
  		height: 20rem;
  	}
  </style>
</head>

<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>

  <main id="main">
    <section class="inner-page">
        <div class="container">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-4">
                    <img src="image?fileName=${p.productImage}" alt="">
                </div>
                <div class="col-md-5">
                    <form action="current-flower">
                        <div id="contents">
                            <div id="simple">${p.productSimple}</div>
                            <h2><b>${p.productName}</b></h2>
                            <h4><b>${p.productDetail}</b></h2>
                            <input type="hidden" name="pno" value="${p.productNo}">
                            <input type="hidden" name="pname" value="${p.productName}">
                            <input type="hidden" name="price" value="${p.productPrice}">
                            <h3> <span id="price">${p.productPrice}</span>원</h3>
                            <label><b>수량 : </b><input type="number" name="order-num" id="num" min="1" max="20" value="1"></label>
                            <div class="mt-3"><b>가격 : </b><span name="order-price" id="result" >${p.productPrice}</span>원 </div>
                            <input type="submit" class="btn btn-success mt-4" value="꽃다발에 담기"></input> 
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>

    <section>

    </section>

  </main><!-- End #main -->
  
  <%@include file="/WEB-INF/views/common/footer.jsp" %>


  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>
	<script type="text/javascript">
		$("#num").change(function(){
			var num = $("#num").val();
			var price = '${p.productPrice}';
			var result = num * price;
			$("#result").text(result);
			
		});
	</script>
</body>

</html>