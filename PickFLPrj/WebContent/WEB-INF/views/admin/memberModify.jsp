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

			<form action="adminMUpdate" method="post" name="userInfo">
				<input type="hidden" name="mNum" value="${vo.memberNo}">
				<table>
					<tr>
						<td>이름</td>
						<td><input type="text" name ="name" value="${vo.name}" class="joininput"></td>
					</tr>
					<tr>
						<td>아이디</td>
						<td><input type="text" name ="id" value="${vo.id}" class="joininput"></td>
					</tr>
					<tr>
						<td>생년월일</td>
						<td><input type="text" name="birth" value="${vo.birth}" class="joininput"></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="text" name="mail" value="${vo.email}" class="joininput"></td>
					</tr>
					<tr>
						<td>비번변경</td> 
						<td><input type="text" name="password" value="${vo.pwd}" class="joininput"></td>
					</tr>
                    <tr>
						<td>탈퇴여부</td>
						<td><input type="text" name="quitYN" value="${vo.quitYN}" class="joininput"></td>
					</tr>
				</table>
					
				<span class="login100-form-title p-b-51">
					<input type="submit" value="변경하기" class="joinbtn"/>  
                    <input type="button" value="메인으로" onclick="goIndex()" class="join2btn"/>
                </span>
			</form>
		</div>
	</div>
</body>
</html>