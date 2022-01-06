<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원정보변경</title>
    <script>
        function goIndex() {
            location.href="main";
        }
    </script>
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
    <link rel="stylesheet" type="text/css" href="assets/css/util.css">
	<link rel="stylesheet" type="text/css" href="assets/css/main.css">

    <!-- jQuerty-->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<div class="container-login100">
		<div class="wrap-Join p-t-50 p-b-90">
			<span class="login100-form-title p-b-51">Modifycation</span> 
			
			<form class="row g-3" action="modify" method="post" name="insertform">
                    <div class="col-sm-3 a">
                        <span class="form-control">아이디</span>
                    </div>
                    <div class="col-md-6 col-sm-6 a">
                        <input type="text" name="id" class="form-control" id="userId" required maxlength="12" placeholder="아이디를 입력하세요." value="${member.id}" onfocusout="validate()">
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

                        <input type="password" name="pwd" class="form-control" id="userPwd1" required maxlength="16" placeholder="비밀번호를 입력하세요." value=""  onfocusout="validate()">

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
                        <input type="password" name="userPwd2" class="form-control" id="userPwd2" required maxlength="16" placeholder="비밀번호를 입력하세요." value="" onfocusout="validate()">
                        <div id="pwdCheckError" class="form-text">
                        </div>
                    </div>
                    <div class="col-sm-3 a">
                    </div>

                    <div class="col-sm-3 a">
                        <span class="form-control">이름</span>
                    </div>
                    <div class="col-md-6 col-sm-6 a">

                        <input type="text" name="name" class="form-control" id="userName" required placeholder="이름을 입력하세요." value="${member.name}" onfocusout="validate()">

                        <div id="nameRegError" class="form-text">
                        </div>
                    </div>
                    <div class="col-sm-3 a">
                    </div>
    
                    <div class="col-sm-3 a">
                        <span class="form-control">이메일</span>
                    </div>

                    <div class="col-md-6 col-sm-6 a">

                        <input type="email" name="email" class="form-control" id="email" required placeholder="이메일을 입력하세요." value="${member.email}" onfocusout="validate()">

                        <div id="emailRegError" class="form-text">
                        </div>
                    </div>
                    <div class="col-sm-3 a">

                        <button type="button" class="btn btn-success" id="emailDupCheck">중복확인</button>
                        <input type="button" class="btn btn-success" id="sendEmailBtn" onclick="emailcheck(insertform.email.value)" value="인증번호 받기"></input>

                    </div>
    
                    <div class="col-sm-3 a">
                        <span class="form-control">생년월일</span>
                    </div>
                    <div class="col-md-6 col-sm-6 a">

                    	<input type="text" name="birth" class="form-control" id="birth" maxlength="6" required placeholder="생년월일을 적어주세요. ex)950101" value="${member.birth}" onfocusout="validate()">
                        <div id="birthRegError" class="form-text">

                        </div>
                    </div>
					
				<span class="login100-form-title p-b-51">
                    <input type="submit" value="Update" class="joinbtn"/>  
                    <input type="button" value="Cansle" onclick="goIndex()" class="join2btn"/>
                </span>
			</form>
		</div>
	</div>
	
	<script type="text/javascript" src="assets/js/modify.js?ver=12"></script>
</body>
</html>