<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inquiry</title>
<script>
	function inquiryclose(){
		window.close();
	}
</script>
<link rel="stylesheet" href="assets/css/inqueryWrite.css">
</head>
<body>
	<div class="inquirywritefrom" >
			<form action="writeInquiry.jsp" name="inquiryform" target="inquiry"> <!-- 문의하기 form -->
			<div class="tablehead">
				<h2 style="margin-left:15px;">문의 입력</h2>
			</div>
			<div class="tableid">
				<h4 class="h4id"><p class="spacebar">ID (세션에서가져온아이디)</span></p></h4>
			</div>
			<div class="tablebody">
                <p class="file">첨부파일</p>
				<h4 class="h4body">제목</h4>
				<input type="text" name="title" class="textform">
			</div>
			<br/>
			<div class="tablebody">
				<h4 class="h4body">내용</h4>
				<textarea name ="text" name ="text" wrap='hard' class="textareaform"></textarea>
			</div>
			<br/>
			<input type="submit" value="작성" onclick="inquiryclose()">
			<input type="button" value="취소" onclick="inquiryclose()">
			</form>

	</div>
</body>
</html>