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
        function pwCheck(){
            if(document.userInfo.password.value != document.userInfo.passwordcheck.value ){
            alert("비밀번호를 동일하게 입력하세요.");
            return false;
        }}
    </script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="assets/css/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="assets/css/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
	<link rel="stylesheet" type="text/css" href="assets/css/util.css">
	<link rel="stylesheet" type="text/css" href="assets/css/main.css">
</head>
<body>
	<div class="container-login100">
		<div class="wrap-Join p-t-50 p-b-90">
			<span class="login100-form-title p-b-51">Modifycation</span> 
			<form action="doModify.jsp" method="post" name="userInfo" onsubmit="return pwCheck()" >
				<table>
					<tr>
						<td>이름</td>
						<td><input type="text" name ="name" value="" class="joininput"></td>
					</tr>
					<tr>
						<td>생년월일</td>
						<td><input type="text" name="birth" value="" class="joininput"></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="text" name="mail" value="" class="joininput"></td>
					</tr>
					<tr>
						<td>주소</td>
						<td><input type="text" name="home" value="" class="joininput"></td>
					</tr>
					<tr>
						<td>자기소개</td>
						<td><input type="text" name="info" value="" class="joininput"></td>
					</tr>
					<tr>
						<td>비번변경</td> 
						<td><input type="password" name="password" value="" class="joininput"></td>
					</tr>
					<tr>
						<td>비번확인</td>
						<td><input type="password" name="passwordcheck" value="" class="joininput"></td>
					</tr>
				</table>
					
				<span class="login100-form-title p-b-51">
                    <input type="submit" value="Join" class="joinbtn"/>  
                    <input type="button" value="Cansle" onclick="goIndex()" class="join2btn"/>
                </span>
			</form>
		</div>
	</div>
</body>
</html>