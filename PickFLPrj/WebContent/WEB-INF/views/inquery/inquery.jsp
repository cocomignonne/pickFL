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
        window.open("inqueryWrite", "inquirywrite", "height = 700, width = 650");
    }
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	    <div class="left_bx">
	            <a href="inquery.jsp" class="qeustion" id="onlineConsult">내문의내역</a>
	            <ul class="left_menu">
	                </ul>
	            <ul class="my_menu"> 
	                <li>
	                    <a href="" onclick="inquiryWrite()">문의하기</a>
	                </li>
	                <li>
	                    <a href="main">HOME</a>
	                </li>
	            </ul>
	    </div>
	    <div class="bodymargin">
	    <h2 class="h2class">My 문의 사항 내역</h2>
	    
	     <%@ include file="inquerySearch.jsp" %>
	     
	    </div>
	</body>
</html>