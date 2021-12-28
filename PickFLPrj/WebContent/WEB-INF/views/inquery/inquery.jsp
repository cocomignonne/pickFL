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
        window.name="inquiryWrite"
        window.open("inqueryWrite", "inquirywrite", "height = 700, width = 650");
    }
    function inquiryContent(){
    	window.name="inquiryContent"
        window.open("inqueryContnet", "inquirycontent", "height = 700, width = 650");
    }
    function showOrHide(id){    // 작동안됨;
        var box = document.getElementById(id);
        if(box.getAttribute('display')!='block')// display 상태가 block이 아니라면 block로 설정 == show
            box.setAttribute('display', 'block');
        else// block라면 none로 설정 == hide
            box.setAttribute('display', 'none');
    }
</script>
</head>
<body>
<header>
    문의 하기
</header>
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