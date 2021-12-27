<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
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
<link rel="stylesheet" type="text/css" href="assets/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="assets/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/util.css">
<link rel="stylesheet" type="text/css" href="assets/css/main.css">
</head>
</head>
<body>
	<div class="container-login100">
		<div class="wrap-Join p-t-50 p-b-90">
			<span class="login100-form-title p-b-51">Modifycation</span> 
			<form action="doModify.jsp" method="post" name="userInfo" >
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
                    <tr>
						<td>탈퇴여부</td>
						<td><span>
                            <div class="form-check">
                                <label class="form-check-label">
                                    <input type="radio" class="form-check-input" name="optradio">Y
                                    <input type="radio" class="form-check-input" name="optradio">N
                                </label>
                        </span></td>
					</tr>
				</table>
					
				<span class="login100-form-title p-b-51">
                    <input type="submit" value="변경" class="joinbtn"/>  
                    <input type="button" value="메인" onclick="goIndex()" class="join2btn"/>
                </span>
			</form>
		</div>
	</div>
</body>
</html>