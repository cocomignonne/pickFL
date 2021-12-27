<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        .center{
            text-align: center;
        }
        .thumbnail{
            width: 10rem;
            height: 10rem;
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
                      <div class="row mt-3">
                          <div class="col-sm mb-4">
                              <div><h1>상품 정보</h1></div>
                          </div>
                      </div>
                          <div class="row mb-3">
                              <label for="pname" class="col-sm-2 col-form-label title">상품명</label>
                              <div class="col-sm-10">
                                이름모를꽃
                              </div>
                          </div>
                          <div class="row mb-3">
                              <label for="price" class="col-sm-2 col-form-label title">상품가격</label>
                              <div class="col-sm-4">
                                2,500 원
                              </div>
                              <label for="stock" class="col-sm-2 col-form-label title">상품재고</label>
                              <div class="col-sm-4">
                                300 개
                              </div>
                          </div>
                          <div class="row mb-3">
                            <label for="flang" class="col-sm-2 col-form-label title">꽃말</label>
                            <div class="col-sm-4">
                              희망
                            </div>
                            <label for="simple" class="col-sm-2 col-form-label title">간단정보</label>
                            <div class="col-sm-4">
                              1월의 꽃
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label for="rcontent" class="col-sm-2 col-form-label title">상세정보</label>
                            <div class="col-sm-10">
                                바이며, 열락의 앞이 얼음과 가슴에 곳이 약동하다. 끓는 생생하며, 보이는 그들은 피가 전인 곧 칼이다. 피가 원대하고, 낙원을 운다. 청춘의 피고, 없으면, 피다. 천하를 전인 곳이 피어나기 칼이다.
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label for="rcontent" class="col-sm-2 col-form-label title">색상</label>
                            <div class="col-sm-4">
                                무채색
                            </div>
                            <label for="rcontent" class="col-sm-2 col-form-label title">크기</label>
                            <div class="col-sm-4">
                                M
                            </div>
                        </div>
                          <div class="row mb-3">
                              <div class="col-sm-2 align-self-center title">상품이미지</div>
                              <div class="col-sm-10">
                                  <img class="thumbnail rounded m-lg-3" src="img/flower1.jpg" alt="">
                              </div>
                          </div>
                          
                          <div class="row">
                              <div class="col-sm">
                              	<a href="update-product">
	                                <button type="button" class="btn btn-success"> 수정하기 </button>
                              	</a>
                              </div>
                              <div class="col-sm">
                              	<a href="manage-product">
                              		<button type="button" class="btn btn-outline-dark" > 목록으로 </button>
                              	</a>
                              </div>
                              <div class="col-sm">
                              	<a href="remove-product">
                              		<button type="button" class="btn btn-danger" > 삭제하기 </button>
                              	</a>
                              </div>
                          </div>
                  </div>
                  </div>
          </section>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>

</html>
