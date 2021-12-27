<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PickFL Login</title>
	<link rel="stylesheet" href="assets/css/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/css/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
	<link rel="stylesheet" href="assets/css/util.css">
	<link rel="stylesheet" href="assets/css/main.css">
	<link rel="stylesheet" href="assets/css/login.css">
	
	<style>
	#login_btn{
		text-decoration:none;
	}
    #securedLoginForm{
        display: none;
    }
	</style>
<title>PickFL-Login</title>
</head>
<body>
		<div class="container-login100">
			<div class="wrap-login100 p-t-50 p-b-90">
					<span class="login100-form-title p-b-60">
						Login
					</span>
					
						<div class="wrap-input100 validate-input m-b-16" data-validate = "Username is required">
								<label for="username"><input class="input100" type="text" name="username" id="username" placeholder="ID" required /></label>
								<span class="focus-input100"></span>
						</div>
							<div class="wrap-input100 validate-input m-b-16" data-validate = "Password is required">
								<label for="password"><input class="input100" type="password" name="password" id="password" placeholder="pw" required /></label>
								<span class="focus-input100"></span>
							</div>
						<div class="container-login100-form-btn m-t-17">
							<a href="" class="login100-form-btn" type="submit" id="login_btn">Login</a>
						</div>
					
					<form id="securedLoginForm" name="securedLoginForm" method="post">
						<input type="hidden" name="securedUsername" id="securedUsername" value="" />
						<input type="hidden" name="securedPassword" id="securedPassword" value="" />
					</form>
					
					<div class="sign">
					
					<form method="post">
					<br/>
						<span class="txt1"><a class="txt1" href="">Sign up</a>          
						<a class="txt2" href=''> PW</a>
						<a class="txt2" href=''>forget? ID /</a>
					</form>
					
					</div>
					
			</div>
		</div>
</body>
</html>