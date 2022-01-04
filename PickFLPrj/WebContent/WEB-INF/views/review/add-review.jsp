<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>PickFL - review</title>
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


      .thumbnail{
          width: 10rem;
          height: 10rem;
      }
      
      .center{
            text-align: center;
        }
      
      .title{
          font-weight: 900;
          text-align: right;
      }

  </style>
</head>

<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
        <section id="review-container">
        	<div class="center">
                <div class="container">
                    <div class="row">
                        <div class="col-sm mb-4">
                            <div><h1>REVIEW</h1></div>
                        </div>
                    </div>
                    <form action="">
                        <div class="row mb-3">
                            <label for="bouquetName" class="col-sm-2 col-form-label title">상품명</label>
                            <div class="col-sm-4">
                                <select class="form-select" id="bouquetName" name="bouquetName" required>
                                    <option selected>상품 선택</option>
                                    <c:forEach items="${bouquetMap}" var="b">
	                                    <option value="${b.getKey()}">${b.getValue()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <label for="stars" class="col-sm-2 col-form-label title">별점</label>
                            <div class="col-sm-4">
                                <select class="form-select" id="stars" name="stars" required>
                                    <option selected>별점 선택</option>
                                    <option value="1">⭐✩✩✩✩</option>
                                    <option value="2">⭐⭐✩✩✩</option>
                                    <option value="3">⭐⭐⭐✩✩</option>
                                    <option value="4">⭐⭐⭐⭐✩</option>
                                    <option value="5">⭐⭐⭐⭐⭐</option>
                                </select>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label for="rtitle" class="col-sm-2 col-form-label title">제목</label>
                            <div class="col-sm-10">
                              <input type="text" class="form-control" id="rtitle" placeholder="제목을 입력해 주세요">
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label for="rcontent" class="col-sm-2 col-form-label title">내용</label>
                            <div class="col-sm-10">
                            <textarea class="form-control" id="rcontent" rows="15" placeholder="내용을 입력해 주세요"></textarea>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-sm-2 align-self-center title">첨부파일</div>
                            <div class="col-sm-10">
                                <div class="input-group">
                                    <input type="file" class="form-control" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04" aria-label="Upload">
                                    <button class="btn btn-outline-secondary" type="button" id="inputGroupFileAddon04">Button</button>
                                </div>
                            </div>
                        </div>
                        <div class="row mb-3">

                            <div class="col-sm">
                                <img class="thumbnail rounded m-lg-3" src="img/flower1.jpg" alt="">
                                <img class="thumbnail rounded m-lg-3" src="img/flower2.jpg" alt="">
                                <img class="thumbnail rounded m-lg-3" src="img/flower3.jpg" alt="">
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col-sm">
                                <input type="submit" class="btn btn-success " value="등록하기">
                            </div>
                            <div class="col-sm">
                                <input type="reset" class="btn btn-outline-dark" value="취소하기">
                            </div>
                        </div>
            
                    </form>
                </div>
                </div>
        </section>
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

</body>

</html>