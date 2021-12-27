<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="assets/css/inquery.css">
<script>
    function inquiry(){
        window.name="inquiry"
        window.open("inqueryWrite", "inquirywrite", "height = 700, width = 650");
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
            <a href="문의.html" class="qeustion" id="onlineConsult">내문의내역</a>
            <ul class="left_menu">
                </ul>
            <ul class="my_menu"> 
                <li>
                    <a href="" onclick="inquiry()">문의하기</a>
                </li>
                <li>
                    <a href="main">HOME</a>
                </li>
            </ul>
    </div>
    <div class="bodymargin">
    <h2 class="h2class">My 문의 사항 내역</h2>

    <hr class="inquiryline">
        <div class ="inquiryBox" onclick="showOrHide(inquiry)">
        <hr/>
            <table class="inquirytable">
                <tr class="inquiry_head">
                    <th> 
                        문의 제목 : ~~
                    </th>
                </tr>
            </table>

            <div id="inquiry">
                <table class="inquirytable">
                        <tr class="inquiry_line">
                        <td>
                            <img src="assets/img/arrow.svg" class="img_icon"> &nbsp; 문의내용 : <!-- 문의내용 출력 -->
                        </td>
                    </tr>
                </table>
                    <table class="inquirytable">
                        <tr class="inquiry_head2">
                            <th>
                                답변이름 : 답변자 id<!-- 답변제목과 답변자의 id출력 -->
                            </th>
                        </tr>
                    </table>
                    <hr>
                    <table class="inquirytable">
                        <tr class="inquiry_body">
                            <td>	
                                <img src="assets/img/arrow2.png" class="img_icon"/> &nbsp; 답변 내용 :<!-- 답변내용 출력 --> 
                            </td>
                        </tr>
                    </table>
            </div>
        </div>
        <hr>
        <br/>
    </div>
</body>
</html>