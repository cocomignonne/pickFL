<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/myPage.css">
    <title>PickFL</title>
</head>
<body>    
    <form id="wrap">
        <header id="headers">
            <nav id="menu"></nav>
        </header>

        <section id="contents">
            <article id="content1">
                
                <div id="content1_1">
                    <h2>MYPAGE</h2>
                </div>

                <div id="container1_2">
                    <h4>나의 꽃밭</h4>
                    <ul class="hover">
                        <li><a href="review">상품리뷰</a></li>
                        <li><a href="inquery">문의하기</a></li>
                    </ul>
                </div>
            
                <div id="container1_3">
                    <h4>나의 계정설정</h4>
                    <ul class="hover">
                        <li><a href="#">회원정보수정</a></li>
                    </ul>
                </div>
            
                <div id="container1_4">
                    <h4>HOME</h4>
                    <ul class="hover">
                        <li><a href="main">메인으로</a></li>
                    </ul>
                </div>
            </article>

            <article id="content2">
                <ul id="content_backgroundColor">
                    <li id="content2_1">
                        <a href="#" id="content_1a">
                            <div id="content_1a_1">회원등급 ></div>
                            <div id="content_1a_2">GREEN</div>
                        </a>
                    </li>

                    <li id="content2_3">
                        <div id="content2_3_1"></div>
                        <div id="content2_3_2">마일리지 ></div>
                        <div id="content2_3_3">0</div>
                    </li>
                </ul>
                
				<div id="content2_backgroundColor">
                    <p id="content2_p">결제내역</p>
                </div>
                <table class = "table-striped table-hover" id="content2_2">
                    <tr class="content2_2_tr">
                        <th class="content2_2_td">주문번호</th>
                        <th class="content2_2_td">상품번호</th>
                        <th class="content2_2_td">구매개수</th>
                        <th class="content2_2_td">배송상태</th>
                        <th class="content2_2_td">구매금액</th>
                        <th class="content2_2_td">결제날짜</th>
                    </tr>
                    <c:forEach items="${list}" var="l">
						<tr class="content2_2_tr">
							<td class="content2_2_td" id="td1">${l.orderNo}</td>
							<td class="content2_2_td">${l.productNo}</td>
							<td class="content2_2_td">${l.orderNum}</td>
							<td class="content2_2_td">${l.delivery}</td>	
							<td class="content2_2_td">${l.price}</td>	
							<td class="content2_2_td">${l.orderDate}</td>	
						</tr>
					</c:forEach>
                </table>
            </article>
        </section>
    </form>
</body>
</html>