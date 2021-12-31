<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="assets/css/inquery.css">
<script>
    function inquiryWrite(){
    	window.name="inquiryWrite";
        window.open("inqueryWrite", "InqueryWrite", "height = 700, width = 650");
    }
</script>
</head>
<body>
<header>
    문의 하기
</header>
    <div class="left_bx">
            <a href="inquery.jsp" class="qeustion" id="onlineConsult">문의조회</a>
            <ul class="left_menu">
                </ul>
            <ul class="my_menu"> 
                <li>
                    <a href="" onclick="inqueryWrite()">문의하기</a>
                </li>
                <li>
                    <a href="main">HOME</a>
                </li>
            </ul>
    </div>
    <div class="bodymargin">
    <h2 class="h2class">회원 문의사항 내역</h2>
    
     <%@ include file="inquerySearchM.jsp" %>
     
    </div>
</body>
</html>