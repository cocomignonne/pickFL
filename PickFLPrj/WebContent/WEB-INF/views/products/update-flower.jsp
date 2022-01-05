<%@page import="com.pickfl.products.model.vo.ProductVo"%>
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
  <link href="assets/css/style.css" rel="stylesheet">
  
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  </head>
  
  <body>
   <%@include file="/WEB-INF/views/common/header.jsp" %>
           <section id="review-container">
              <div class="center">
                  <div class="container">
                      <div class="row mt-3">
                          <div class="col-sm mb-4">
                              <div><h1>꽃 수정</h1></div>
                          </div>
                      </div>
                      <form action="update-product" name="test" method="post" enctype="multipart/form-data">
                          <div class="row mb-3">
                          	<div class="col-sm-2 title"> 상품번호 </div>
                          	<div class="col-sm-1"> 
                          		<input type="text" class="form-control" name="no" value="${p.productNo}" readonly>
                          	</div>
                              <label for="pname" class="col-sm-2 col-form-label title">상품명</label>
                              <div class="col-sm-4">
                                <input type="text" class="form-control" id="pname" name="pname" value="${p.productName}" placeholder="상품명을 입력해 주세요">
                              </div>
                              <div class="col-sm-3 align-self-center">
                              	<span id="isNameDup" class="d-none" style="color: red;">이미 존재하는 상품명입니다.</span>
                              </div>
                          </div>
                          <div class="row mb-3">
                              <label for="price" class="col-sm-2 col-form-label title">상품가격</label>
                              <div class="col-sm-4">
                                <input type="number" class="form-control" id="price" name="price" value="${p.productPrice}" placeholder="상품가격 입력">
                              </div>
                              <label for="stock" class="col-sm-2 col-form-label title">상품재고</label>
                              <div class="col-sm-4">
                                <input type="number" class="form-control" id="stock"  name="stock" value="${p.productStock}" placeholder="상품재고 입력">
                              </div>
                          </div>
                          <div class="row mb-3">
                            <label for="flang" class="col-sm-2 col-form-label title">꽃말</label>
                            <div class="col-sm-4">
                              <input type="text" class="form-control" id="flang" name="flang" value="${p.flowerLang}" placeholder="꽃말을 입력해 주세요">
                            </div>
                            <label for="simple" class="col-sm-2 col-form-label title">간단정보</label>
                            <div class="col-sm-4">
                              <input type="text" class="form-control" id="simple" name="simple" value="${p.productSimple}" placeholder="간단정보를 입력해 주세요">
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label for="detail" class="col-sm-2 col-form-label title">상세정보</label>
                            <div class="col-sm-10">
                            <textarea class="form-control" id="detail" name="detail" rows="5" placeholder="내용을 입력해 주세요">${p.productDetail}</textarea>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label for="color" class="col-sm-2 col-form-label title">색상</label>
                            <div class="col-sm-4">
                                <select class="form-select" id="color" name="color">
                                    <option >색상 선택</option>
                                    <option value="red" ${"red" eq p.productColor ? "selected" : ""}>빨간색</option>
                                    <option value="yello" ${"yello" eq p.productColor ? "selected" : ""}>노랑색</option>
                                    <option value="green" ${"green" eq p.productColor ? "selected" : ""}>초록색</option>
                                    <option value="blue" ${"blue" eq p.productColor ? "selected" : ""}>파랑색</option>
                                    <option value="purple" ${"purple" eq p.productColor ? "selected" : ""}>보라색</option>
                                    <option value="white" ${"white" eq p.productColor ? "selected" : ""}>무채색</option>
                                </select>
                            </div>
                            <label for="size" class="col-sm-2 col-form-label title">크기</label>
                            <div class="col-sm-4">
                                <select class="form-select" id="size" name="size">
                                    <option>크기 선택</option>
                                    <option value="S" ${"S" eq p.productSize ? "selected" : ""}>S</option>
                                    <option value="M" ${"M" eq p.productSize ? "selected" : ""}>M</option>
                                    <option value="L" ${"L" eq p.productSize ? "selected" : ""}>L</option>

                                </select>
                            </div>
                        </div>

                          <div class="row mb-3">
                              <div class="col-sm-2 align-self-center title">상품이미지</div>
                              <div class="col-sm-10">
                                  <div class="input-group">
                                      <input type="file" onchange="readURL(this);" class="form-control" name="image" id="inputImg" aria-label="Upload">
                                  </div>
                              </div>
                          </div>
                          <div class="row mb-3">
  
                              <div class="col-sm">
                                  <img class="thumbnail rounded m-lg-3" src="image?fileName=${p.productImage}" id="img">
                              </div>
                          </div>
                          
                          <div class="row">
                              <div class="col-sm">
                                  <input type="submit" class="btn btn-success" id="submit" value="수정하기">
                              </div>
                              <div class="col-sm">
                                  <a href="manage-product-detail?no=${no}"><input type="button" class="btn btn-outline-dark" value="취소하기"></a>
                              </div>
                          </div>
              
                      </form>
                  </div>
              </div>
          </section>
          
 <%@include file="/WEB-INF/views/common/footer.jsp" %>
 
 <script>
 function readURL(input) {
	  if (input.files && input.files[0]) {
	    var reader = new FileReader();
	    reader.onload = function(e) {
	      document.getElementById('img').src = e.target.result;
	    };
	    reader.readAsDataURL(input.files[0]);
	  } else {
	    document.getElementById('img').src = "";
	  }
	}
 
 $("#pname").keyup(function(){
		$.ajax({
			url : '/PickFL/productDupCheck',
			method : 'get',
			data : {
				product_name : $("#pname").val()
			},
			dataType : "json",
			success : function(data){
					if(data.result == '1'){
						$("#isNameDup").toggleClass("d-none", false);
					} else {
						$("#isNameDup").toggleClass("d-none", true);
					}
					console.log("ajax success");
				},
			error : function(err){
				alert('fail');
			}
		})
	})
 	
 </script>
</body>

</html>
