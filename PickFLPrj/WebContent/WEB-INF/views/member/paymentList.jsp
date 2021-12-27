<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/paymentList.css">
    <title>PickFL</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>    
    <form id="wrap">
        <header id="headers">
            <div id="header_contents">
                <div id="header_content1"></div>
                <div id="header_content2">
                    <!-- 표시만 -->
                    <h1>결제내역</h1>
                </div>
                <div id="header_content3"></div>
            </div>
            <nav id="menu"></nav>
        </header>

        <section id="contents">
            <article id="content1">
                
                <div id="content1_1">
                    <h2>3조</h2>
                </div>

                <div id="container1_2">
                    <h4>나의 꽃밭</h4>
                    <ul class="hover">
                        <li><a href="#">주문배송조회</a></li>
                        <li><a href="#">구매 내역</a></li>
                        <li><a href="#">상품 리뷰</a></li>
                    </ul>
                </div>
            
                <div id="container1_3">
                    <h4>나의 계정설정</h4>
                    <ul class="hover">
                        <li><a href="#">회원정보수정</a></li>
                        <li><a href="#">쿠폰</a></li>
                    </ul>
                </div>
            
                <div id="container1_4">
                    <h4>고객센터 </h4>
                    <ul class="hover">
                        <li><a href="#">1:1문의내역</a></li>
                        <li><a href="#">상품Q&A내역</a></li>
                        <li><a href="#">고객의 소리</a></li>
                    </ul>
                </div>
            </article>

            <article id="content2">
                <div id="content2_backgroundColor">
                    <p id="content2_p">결제내역</p>
                </div>
                <table class = "table-striped" id="content2_2">
                    <tr class="content2_2_tr">
                        <th class="content2_2_td">상품번호</th>
                        <th class="content2_2_td">선택옵션</th>
                        <th class="content2_2_td">구매개수</th>
                        <th class="content2_2_td">배송상태</th>
                        <th class="content2_2_td">쿠폰여부</th>
                        <th class="content2_2_td">구매금액</th>
                        <th class="content2_2_td">결제날짜</th>
                    </tr>
                    <tr class="content2_2_tr">
                        <td class="content2_2_td">1</td>
                        <td class="content2_2_td">1</td>
                        <td class="content2_2_td">1</td>
                        <td class="content2_2_td">1</td>
                        <td class="content2_2_td">1</td>
                        <td class="content2_2_td">1</td>
                        <td class="content2_2_td">1</td>
                    </tr>
                    <tr class="content2_2_tr">
                        <td class="content2_2_td">3</td>
                        <td class="content2_2_td">3</td>
                        <td class="content2_2_td">3</td>
                        <td class="content2_2_td">3</td>
                        <td class="content2_2_td">3</td>
                        <td class="content2_2_td">3</td>
                        <td class="content2_2_td">3</td>
                    </tr>
                    <tr class="content2_2_tr">
                        <td class="content2_2_td">4</td>
                        <td class="content2_2_td">4</td>
                        <td class="content2_2_td">4</td>
                        <td class="content2_2_td">4</td>
                        <td class="content2_2_td">4</td>
                        <td class="content2_2_td">4</td>
                        <td class="content2_2_td">4</td>
                    </tr>
                </table>
                
                
            </article>
        </section>
    </form>
</body>
</html>