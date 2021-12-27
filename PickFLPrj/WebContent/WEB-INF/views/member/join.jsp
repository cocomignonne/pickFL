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

</head>

<body>

    <%@ include file="../common/header.jsp" %>

    <section>
        <div id="signInPage">
            <div id="signIn-Text">
                <span>회원 가입</span>
            </div>
            <div id="signIn-form">
                <form class="row g-3">

                    
                    
                    <div class="col-sm-3 a">
                        <span class="form-control">아이디</span>
                    </div>
                    <div class="col-md-6 col-sm-6 a">
                        <input type="text" name="userId" class="form-control" id="userId" required maxlength="12" placeholder="아이디를 입력하세요.">
                        <div id="idHelpBlock" class="form-text">
                            영문, 숫자만을 포함해서  6~12자리
                        </div>
                    </div>
                    <div class="col-sm-3 a">
                        <button type="button" class="btn btn-success">중복확인</button>
                    </div>
                    
                    
                    
                    <div class="col-sm-3 a">
                        <span class="form-control">비밀번호</span>
                    </div>
                    <div class="col-md-6 col-sm-6 a">
                        <input type="password" name="userPwd1" class="form-control" id="userPwd1" required maxlength="16" placeholder="비밀번호를 입력하세요.">
                        <div id="passwordHelpBlock" class="form-text">
                            영문, 숫자, 특수문자(#, $, % 중 선택) 모두를 포함해서 8~16자리
                        </div>
                    </div>
                    <div class="col-sm-3 a">
                    </div>
                    
                    <div class="col-sm-3 a">
                        <span class="form-control">비밀번호 확인</span>
                    </div>
                    <div class="col-md-6 col-sm-6 a">
                        <input type="password" name="userPwd2" class="form-control" id="userPwd2" required maxlength="16" placeholder="비밀번호를 입력하세요.">
                        <div id="pwdCheckError" class="form-text">
                        </div>
                    </div>
                    <div class="col-sm-3 a">
                    </div>



                    <div class="col-sm-3 a">
                        <span class="form-control">이름</span>
                    </div>
                    <div class="col-md-6 col-sm-6 a">
                        <input type="text" name="userName" class="form-control" id="userName" required placeholder="이름을 입력하세요.">
                        <div id="nameError" class="form-text">
                        </div>
                    </div>
                    <div class="col-sm-3 a">
                    </div>
    


                    <div class="col-sm-3 a">
                        <span class="form-control">이메일</span>
                    </div>
                    <div class="col-md-6 col-sm-6 a">
                        <input type="email" name="email" class="form-control" id="email" required placeholder="이메일을 입력하세요.">
                        <div id="emailError" class="form-text">
                        </div>
                    </div>
                    <div class="col-sm-3 a">
                        <button type="button" class="btn btn-success" onclick="return validate();">인증번호 받기</button>
                    </div>
                    
                    <div class="col-sm-3 a">
                    </div>
                    <div class="col-md-6 col-sm-6 a">
                        <input type="text" name="emailNum" class="form-control" id="emailNum" required placeholder="인증번호를 입력해주세요.">
                    </div>
                    <div class="col-sm-3 a">
                        <button type="button" class="btn btn-success">확인</button>
                    </div>
    
                    <div class="col-sm-3 a">
                        <span class="form-control">생년 월 일</span>
                    </div>
                    <div class="col-md-6 col-sm-6 a">
                        <div id="select">
                            <select class="form-select" aria-label="Default select example">
                                <option selected>--연--</option>
                                <option value="1">One</option>
                                <option value="2">Two</option>
                                <option value="3">Three</option>
                            </select>
                        </div>
                        <div id="select">
                            <select class="form-select" aria-label="Default select example">
                                <option selected>--월--</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                            </select>
                        </div>
                        <div id="select">
                            <select class="form-select" aria-label="Default select example">
                                <option selected>--일--</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                                <option value="13">13</option>
                                <option value="14">14</option>
                                <option value="15">15</option>
                                <option value="16">16</option>
                                <option value="17">17</option>
                                <option value="18">18</option>
                                <option value="19">19</option>
                                <option value="20">20</option>
                                <option value="21">21</option>
                                <option value="22">22</option>
                                <option value="23">23</option>
                                <option value="24">24</option>
                                <option value="25">25</option>
                                <option value="26">26</option>
                                <option value="27">27</option>
                                <option value="28">28</option>
                                <option value="29">29</option>
                                <option value="30">30</option>
                                <option value="31">31</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-sm-3 a">
                    </div>
    
                    <div class="mb-3">
                        <label for="exampleFormControlTextarea1" class="form-label">이용약관 동의</label>
                        <textarea class="form-control" id="exampleFormControlTextarea1" rows="10"></textarea>
                        동의합니다.<input type="checkbox">
                    </div>
                    
                    <input type="submit" value="회원가입" onclick="return validate()">
                    <input type="reset" value="취소">
    
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
    <script src="assets/js/main.js"></script>
    <script src="assets/js/join.js"></script>

</body>

</html>
