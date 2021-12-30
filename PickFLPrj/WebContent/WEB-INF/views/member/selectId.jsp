<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PickFL forgotID</title>
	<link rel="stylesheet" href="assets/css/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/css/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
	<link rel="stylesheet" href="assets/css/util.css">
	<link rel="stylesheet" href="assets/css/main.css">
	<link rel="stylesheet" href="assets/css/login.css">

    <link href="assets/css/mainPage.css" rel="stylesheet">

	
	<style>
	#login_btn{
		text-decoration:none;
	}
    #securedLoginForm{
        display: none;
    }
    .txt1, .txt2 {
    	font-size: large;
    	font-weight: bold;
    	color: #72947ae5;
    }
	</style>
<title>PickFL-Login</title>
</head>
<body>

    <%@ include file="../common/header.jsp" %>

		<div class="container-login100">
			<div class="wrap-login100 p-t-50 p-b-90">
					<span class="login100-form-title p-b-60">
						Forgot ID?
					</span>

					<form action="selectId" method="post">
						<div class="wrap-input100 validate-input m-b-16" data-validate = "UserName is required">
								<input class="input100" type="text" name="name" id="userName" placeholder="이름" required />
								
						</div>
						<div class="wrap-input100 validate-input m-b-16" data-validate = "Email is required">
							<input class="input100" type="text" name="email" id="email" placeholder="이메일" required />
						</div>

						<div class="container-login100-form-btn m-t-17">
							<input class="login100-form-btn" type="submit" value="아이디 찾기">
						</div>
					
					</form>
			</div>
		</div>

    <%@ include file="../common/footer.jsp" %>

</body>
</html>