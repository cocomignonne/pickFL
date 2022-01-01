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
    <link rel="stylesheet" href="assets/css/join.css">

    <!-- jQuerty-->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>

<body>

    <%@ include file="../common/header.jsp" %>

    <section>
        <div id="signInPage">
            <div id="signIn-Text">
                <span>주문 하기</span>
            </div>
            <div id="signIn-form">

                <form class="row g-3" action="join" method="post" name="insertform">
                    <div class="col-sm-3 a">
                        <span class="form-control">수령인</span>
                    </div>
                    <div class="col-md-6 col-sm-6 a">
                        <input type="text" name="id" class="form-control" id="userId" required maxlength="12" placeholder="아이디를 입력하세요." onfocusout="validate()">
                    </div>
                    <div class="col-sm-3 a">
                        <button type="button" class="btn btn-success" id="idDupCheck">중복확인</button>
                    </div>
                    
                    
                    
                    <div class="col-sm-3 a">
                        <span class="form-control">배송 주소</span>
                    </div>
                    <div class="col-md-6 col-sm-6 a">
                        <input type="password" name="pwd" class="form-control" id="userPwd1" required maxlength="16" placeholder="비밀번호를 입력하세요."  onfocusout="validate()">
                    </div>
                    <div class="col-sm-3 a">
                    </div>
                    
                    
                    <div class="col-sm-3 a">
                        <span class="form-control">비밀번호 확인</span>
                    </div>
                    <div class="col-md-6 col-sm-6 a">
                        <input type="password" name="userPwd2" class="form-control" id="userPwd2" required maxlength="16" placeholder="비밀번호를 입력하세요." onfocusout="validate()">
                    </div>
                    <div class="col-sm-3 a">
                    </div>



                    <div class="col-sm-3 a">
                        <span class="form-control">이름</span>
                    </div>
                    <div class="col-md-6 col-sm-6 a">
                        <input type="text" name="name" class="form-control" id="userName" required placeholder="이름을 입력하세요." onfocusout="validate()">
                    </div>
                    <div class="col-sm-3 a">
                    </div>
    

                    <div class="col-sm-3 a">
                        <span class="form-control">이메일</span>
                    </div>
                    <div class="col-md-6 col-sm-6 a">
                        <input type="email" name="email" class="form-control" id="email" required placeholder="이메일을 입력하세요." onfocusout="validate()">
                    </div>
                    <div class="col-sm-3 a">
                        <input type="button" class="btn btn-success" id="sendEmailBtn" onclick="emailcheck(insertform.email.value)" value="인증번호 받기"></input>
                    </div>
    
    
                    <div class="col-sm-3 a">
                        <span class="form-control">생년 월 일</span>
                    </div>
                    <div class="col-md-6 col-sm-6 a">
                    	<input type="text" name="birth" class="form-control" id="birth" maxlength="6" required placeholder="생년월일을 적어주세요. ex)950101" onfocusout="validate()">
                    </div>
                    <div class="col-sm-3 a">
                    </div>
                    <div class="mb-3">

                        <span style="font-size: larger;">이용 약관 동의</span> <br><br>
  						<textarea rows="10" cols="100" style="font-size: small; color: grey">가. 수집하는 개인정보의 항목첫째, 회사는 회원가 입, 원활한 고객상담, 각종 서비스의 제공을 위해 최초 회원가입 당시 아래와 같은 최소한의 개인정보를 필수항목으로 수집하고 있습니다.
  						</textarea> <br>
  						<input type="checkbox" name="agree" id="agree"> 개인정보 수집 및 이용에 동의합니다.
    					</div>
                    
                    <input type="submit" value="회원가입" onclick="return validate()">
                    <input type="button" value="취소" onclick="location.href='main'">
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
    <script type="text/javascript" src="assets/js/join.js?ver=12"></script>


</body>

</html>

