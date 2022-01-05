<%@page import="com.pickfl.member.model.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.pickfl.cart.model.vo.CartVo"%>
<%@page import="com.pickfl.member.model.vo.MemberVo"%>
<%
    int point = (int) request.getAttribute("point");
int totalPrice = (int) request.getAttribute("totalPrice");
 %>
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
    <link rel="stylesheet" href="assets/css/join.css">

    <!-- jQuerty-->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	
	

</head>

<body>

    <%@ include file="../common/header.jsp" %>

    <section>
        <div id="orderPage">
            <div id="order-Text">
                <span>주문 하기</span>
            </div>
            <div id="order-form">

                    <div class="col-sm-3 a">
                        <span class="form-control" style="font-size: 27px; color: #72947ae5;"><u><b>주문자 정보</b></u></span>
                    </div>
                    <div class="col-md-6 col-sm-6 a">
                    </div>
                    <div class="col-sm-3 a">
                    </div>
                    
                    
                    <div class="col-sm-3 a">
                        <span class="form-control" style="font-size: large;">아이디</span>
                    </div>
                    <div class="col-md-6 col-sm-6 a">
                        <input type="text" name="id" class="form-control" value="${loginUser.getId()}">
                    </div>
                    <div class="col-sm-3 a">
                    </div>
                    
                    
                    <div class="col-sm-3 a">
                        <span class="form-control" style="font-size: large;">이름</span>
                    </div>
                    <div class="col-md-6 col-sm-6 a">
                        <input type="text" name="name" class="form-control" value="${loginUser.getName()}">
                    </div>
                    <div class="col-sm-3 a">
                    </div>
                    
                    
                    <div class="col-sm-3 a">
                        <span class="form-control" style="font-size: large;">이메일</span>
                    </div>
                    <div class="col-md-6 col-sm-6 a">
                        <input type="text" name="id" class="form-control"  value="${loginUser.getEmail()}">
                    </div>
                    <div class="col-sm-3 a">
                    </div>
					
                    <br><br>
                    <hr>
                    
                    <div class="col-sm-3 a">
                    </div>
                    <div class="col-md-6 col-sm-6 a">
                    </div>
                    <div class="col-sm-3 a">
                    </div>
                    
                <form class="row g-3" action="order" method="post" name="orderform">
                    <div class="col-sm-3 a">
                        <span class="form-control" style="font-size: 27px; color: #72947ae5;"><u><b>수령 정보</b></u></span>
                    </div>
                    <div class="col-md-6 col-sm-6 a">
                    </div>
                    <div class="col-sm-3 a">
                    </div>
                    
                    
                    <div class="col-sm-3 a">
                        <span class="form-control" style="font-size: large;">수령인 이름</span>
                    </div>
                    <div class="col-md-6 col-sm-6 a">
                        <input type="text"class="form-control" id="getName" name="getName" required maxlength="16" placeholder="수령인 이름 입력하세요.">
                    </div>
                    <div class="col-sm-3 a">
                    </div>
                    
                    
                    <div class="col-sm-3 a">
                        <span class="form-control" style="font-size: large;">수령인 핸드폰 번호</span>
                    </div>
                    <div class="col-md-6 col-sm-6 a">
                        <input type="text" class="form-control" id="phoneNum" name="phoneNum" required maxlength="16" placeholder="번호를 입력하세요 01012347890" ">
                    </div>
                    <div class="col-sm-3 a">
                    </div>
                    <br>
                    
                    <div class="col-sm-3 a">
                        <span class="form-control" style="font-size: large;">주소</span>
                    </div>
                    <div class="col-md-6 col-sm-6 a">
                    	<input type="text" name="postcode" id="postcode" class="form-control" required placeholder="우편번호">
                        <input type="text" name="address" id="address" class="form-control" required placeholder="주소를 입력하세요.">
                        <input type="text" name="detailAddress" id="detailAddress" class="form-control" required placeholder="상세 주소를 입력하세요.">
                    </div>
                    <div class="col-sm-3 a">
						<input type="button" class="btn btn-success" onclick="execDaumPostcode()" value="우편번호 찾기">
                    </div>
                    
                    <div class="col-sm-3 a">
                    </div>
                    <div class="col-md-6 col-sm-6 a">
                    </div>
                    <div class="col-sm-3 a">
                    </div>
                    
                    <hr>
                    
                    <div class="col-sm-3 a">
                    </div>
                    <div class="col-md-6 col-sm-6 a">
                    </div>
                    <div class="col-sm-3 a">
                    </div>
                    
                    <div class="col-sm-3 a">
                    </div>
                    <div class="col-md-6 col-sm-6 a">
                    	<span style="font-size: 20px; text-align: right; margin-left: 65%;"><b>적립금 사용 : </b></span><input type="button" class="dhd" value="O">
                    </div>
                    <div class="col-sm-3 a">
                    	<input type="text" name="usedPoint" style="border: 1px solid lightgrey; margin-left: 7%">
                    	<span style="font-size: 20px; text-align: right; margin-left: 6%;"><b>사용가능한 적립금 : <%=point%></b></span>
                    </div>
                    
                    <div class="col-sm-3 a">
                    </div>
                    <div class="col-md-6 col-sm-6 a" >
                        <span class="form-control" style="font-size: 20px; text-align: right;"><b>적립금 : </b></span>
                    </div>
                    <div class="col-sm-3 a">
                        <span class="form-control" style="font-size: 20px; text-align: right;"><b> 468원</b></span>
                    </div>
                    
                    <div class="col-sm-3 a">
                    </div>
                    <div class="col-md-6 col-sm-6 a">
                        <span class="form-control" style="font-size: 25px; text-align: right;"><u><b>합계 금액 : </b></u></span>
                    </div>
                    <div class="col-sm-3 a">
                        <span class="form-control" style="font-size: 25px; text-align: right;"><u><b> <%=totalPrice %></b></u></span>
                    </div>
                    
                    <div class="col-sm-3 a">
                    </div>
                    <div class="col-md-6 col-sm-6 a">
                    </div>
                    <div class="col-sm-3 a">
                    </div>
                    
                    
                    
                    <div class="col-sm-3 a">
                    </div>
                    <div class="col-md-6 col-sm-6 a">
                    	<div style="text-align: center;">
		                    <input type="submit" class="btnsss1" value="주문하기">
		                    <input type="button" class="btnsss2" value="취소" onclick="location.href='main'">
                    	</div>
                    </div>
                    <div class="col-sm-3 a">
                    </div>
                    
                    
                </form>
            </div>
        </div>
    </section>

    </main><!-- End #main -->

    <%@ include file="../common/footer.jsp" %>
    <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>
    


    <!-- Vendor JS Files -->
    <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
    <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
    <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
    <script src="assets/vendor/php-email-form/validate.js"></script>

    <!-- Template Main JS File -->
    <script type="text/javascript" src="assets/js/main.js"></script>
   
	<!-- POSTCODE API -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
    	function execDaumPostcode() {
        	new daum.Postcode({
            	oncomplete: function(data) {
                	// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                	// 각 주소의 노출 규칙에 따라 주소를 조합한다.
                	// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                	var addr = ''; // 주소 변수
                	var extraAddr = ''; // 참고항목 변수

                	//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                	if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                	    addr = data.roadAddress;
                	} else { // 사용자가 지번 주소를 선택했을 경우(J)
                	    addr = data.jibunAddress;
                	}

                	// 우편번호와 주소 정보를 해당 필드에 넣는다.
                	document.getElementById('postcode').value = data.zonecode;
                	document.getElementById("address").value = addr;
                	// 커서를 상세주소 필드로 이동한다.
                	document.getElementById("detailAddress").focus();
            	}
        	}).open();
    	}
	</script>

</body>

</html>

