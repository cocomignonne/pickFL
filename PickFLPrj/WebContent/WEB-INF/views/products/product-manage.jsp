<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>PickFL</title>
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
    <link href="assets/css/mainPage.css" rel="stylesheet">

    <style>
        img{
            width: 5rem;
            height: 5rem;
        }
    </style>

</head>

<body>
	
	<%@include file="/WEB-INF/views/common/headerM.jsp" %>
	
    <section>
       <div>
           <div class="container">
               <div class="row">
                   <p class="text-center fs-1 mb-5">상품 관리</p>           
               </div>
               <form action="manage-product">
	               <div class="row mb-4">
	                   <div class="col-sm-4">
	                       <h3>상품 목록</h3>
	                   </div>
	                   <div class="col-sm-5">
	                       <div class="input-group mb-3">
	                          <input type="text" class="form-control" name="searchName" placeholder="상품명 검색">
	                          <button class="btn btn-outline-secondary" type="submit" id="button-addon2">검색</button>
	                        </div>
	                   </div>
	                   <div class="col-sm-3 text-end">
	                       <a href="add-flower">
	                           <input type="button" class="btn btn-success" value="꽃 등록">
	                        </a>
	                   </div>
	               </div>
               </form>
                   <!-- table --> 
		           <table class="table">
		               <thead>
		                   <tr>
		                       <th scope="col">상품번호</td>
		                       <th scope="col">이미지</td>
		                       <th scope="col">상품명</td>
		                       <th scope="col">상품가격</td>
		                       <th scope="col">재고</td>
		                   </tr>
		               </thead>
		               <c:forEach items="${productList}" var="p">
			               <tr onClick="getParam(${p.productNo})">
			                   <td>${p.productNo}</td>
			                   <td><img src="image?fileName=${p.productImage}"></td>
			                   <td>${p.productName}</td>
			                   <td>${p.productPrice}</td>
			                   <td>${p.productStock}</td>
			               </tr>
		               </c:forEach>
		           </table>
           </div>
       </div>
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
    <script src="assets/js/join.js"></script>
    
    <script type="text/javascript">
    	function getParam(no){
    		location.href = 'manage-product-detail?no=' + no;
    	}
    </script>

</body>

</html>
