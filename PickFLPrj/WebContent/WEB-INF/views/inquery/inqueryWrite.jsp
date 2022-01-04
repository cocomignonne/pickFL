<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inquery</title>
<script>
	function close(){
		window.close();
	}
</script>
<link rel="stylesheet" href="assets/css/inqueryWrite.css">
</head>
<body>
	<div class="inquerywritefrom" >
			<form action="inqueryWrite" name="inquiryform" method="post"> <!-- 문의하기 form -->
			<div class="tablehead">
				<h2>문의 입력</h2>
			</div>
			<div class="tablebody">
				<h4 class="h4body">제목</h4>
				<input type="text" name="title" class="textform">
			</div>
			<br/>
			<div class="tablebody">
				<h4 class="h4body">내용</h4>
				<textarea name ="text" name ="text" wrap='hard' class="textareaform"></textarea>
			</div>
			<br/>
			<div class="divbutton">
				<input type="submit" value="작성" onclick="close()">
				<input type="button" value="취소" onclick="close()">
			</div>
			</form>
	</div>
</body>
</html>