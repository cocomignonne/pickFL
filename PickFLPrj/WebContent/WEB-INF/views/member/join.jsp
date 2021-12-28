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
                <span>회원 가입</span>
            </div>
            <div id="signIn-form">

                <form class="row g-3" action="join" method="post" name="insertform">
                    <div class="col-sm-3 a">
                        <span class="form-control">아이디</span>
                    </div>
                    <div class="col-md-6 col-sm-6 a">


                        <input type="text" name="id" class="form-control" id="userId" required maxlength="12" placeholder="아이디를 입력하세요." onfocusout="validate()">
                        <div id="idHelpBlock" class="form-text">
                            영문, 숫자만을 모두 포함해서  6~12자리
                        </div>
                    </div>
                    <div class="col-sm-3 a">
                        <button type="button" class="btn btn-success" id="idDupCheck">중복확인</button>

                    </div>
                    
                    
                    
                    <div class="col-sm-3 a">
                        <span class="form-control">비밀번호</span>
                    </div>
                    <div class="col-md-6 col-sm-6 a">

                        <input type="password" name="pwd" class="form-control" id="userPwd1" required maxlength="16" placeholder="비밀번호를 입력하세요."  onfocusout="validate()">

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

                        <input type="text" name="name" class="form-control" id="userName" required placeholder="이름을 입력하세요." onfocusout="validate()">

                        <div id="nameError" class="form-text">
                        </div>
                    </div>
                    <div class="col-sm-3 a">
                    </div>
    

                    <div class="col-sm-3 a">
                        <span class="form-control">이메일</span>
                    </div>

                    <div class="col-md-6 col-sm-6 a">

                        <input type="email" name="email" class="form-control" id="email" required placeholder="이메일을 입력하세요." onfocusout="validate()">

                        <div id="emailError" class="form-text">
                        </div>
                    </div>
                    <div class="col-sm-3 a">

                        <input type="button" class="btn btn-success" id="sendEmailBtn" onclick="emailcheck(insertform.email.value)" value="인증번호 받기"></input>

                    </div>
    
                    <div class="col-sm-3 a">
                        <span class="form-control">생년 월 일</span>
                    </div>
                    <div class="col-md-6 col-sm-6 a">

                    	<input type="text" name="birth" class="form-control" id="birth" maxlength="6" required placeholder="생년월일을 적어주세요. ex)950101" onfocusout="validate()">
                        <div id="birthError" class="form-text">

                        </div>
                    </div>
                    <div class="col-sm-3 a">
                    </div>
    
                    <div class="mb-3">

                        <span style="font-size: larger;">이용 약관 동의</span> <br><br>
  						<textarea rows="10" cols="100" style="font-size: small; color: grey">가. 수집하는 개인정보의 항목첫째, 회사는 회원가 입, 원활한 고객상담, 각종 서비스의 제공을 위해 최초 회원가입 당시 아래와 같은 최소한의 개인정보를 필수항목으로 수집하고 있습니다.
 회원가입
- 이름, 생년월일, 성별, 아이디, 비밀번호, 별명, 연락처(메일주소, 휴대폰 번호 중 선택), 가입인증정보
만14세 미만 아동 회원가입
- 이름, 생년월일, 성별, 법정대리인 정보, 아이디, 비밀번호, 연락처 (메일주소, 휴대폰 번호 중 선택), 가입인증정보
단체아이디 회원가입
- 단체아이디, 회사명, 대표자명, 대표 전화번호, 대표 이메일 주소, 단체주소, 관리자 아이디, 관리자 연락처, 관리자 부서/직위
- 선택항목 : 대표 홈페이지, 대표 팩스번호
둘째, 서비스 이용과정이나 사업처리 과정에서 아래와 같은 정보들이 자동으로 생성되어 수집될 수 있습니다.
- IP Address, 쿠키, 방문 일시, 서비스 이용 기록, 불량 이용 기록
셋째, 네이버 아이디를 이용한 부가 서비스 및 맞춤식 서비스 이용 또는 이벤트 응모 과정에서 해당 서비스의 이용자에 한해서만 개인정보 추가 수집이 발생할 수 있으며, 이러한 경우 별도의 동의를 받습니다.
넷째, 성인컨텐츠, 유료/게임 등 일부 서비스 이용시 관련 법률 준수를 위해 본인인증이 필요한 경우, 아래와 같은 정보들이 수집될 수 있습니다.
- 이름, 생년월일, 성별, 중복가입확인정보(DI), 암호화된 동일인 식별정보(CI), 휴대폰 번호(선택), 아이핀 번호(아이핀 이용시), 내/외국인 정보
다섯째, 유료 서비스 이용 과정에서 아래와 같은 결제 정보들이 수집될 수 있습니다.
- 신용카드 결제시 : 카드사명, 카드번호 등
- 휴대전화 결제시 : 이동전화번호, 통신사, 결제승인번호 등
- 계좌이체시 : 은행명, 계좌번호 등
- 상품권 이용시 : 상품권 번호
나. 개인정보 수집방법회사는 다음과 같은 방법으로 개인정보를 수집합니다.
- 홈페이지, 서면양식, 팩스, 전화, 상담 게시판, 이메일, 이벤트 응모, 배송요청
- 협력회사로부터의 제공
- 생성정보 수집 툴을 통한 수집
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

