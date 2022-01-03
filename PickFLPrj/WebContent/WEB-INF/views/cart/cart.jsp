<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
	<title>Cart</title>
	
    <link href="assets/img/favicon.png" rel="icon">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
	<link rel="stylesheet" href="assets/css/cart.css" >
	<script type="text/javascript" src="assets/js/cart.js"></script> 


</head>
<body>
    <!--  
        1) 장바구니
            1. 상품 목록, 수량, 상품 금액, 합계 금액, 배송비
            2. 선택 상품 주문, 전체 상품 주문
            3. 장바구니 > 주문서작성/결제 > 주문완료
    -->
    <%@ include file="../common/header.jsp" %>
        <section>
        <div id="cartPage">
            <div id="cart-Text">
                <span>장바구니</span>
            </div>
        </div>
	    <form name="orderform" id="orderform" method="post" class="orderform" action="order" onsubmit="return false;">
            <input type="hidden" name="cmd" value="order">
            <div class="cartdiv" id="cart">
                <div class="row head">
                
                    <div class="subdiv">
                        <div class="pname">상품명</div>
                        <div class="detail">상품상세</div>
                        <div class="wColor">포장 테마색상</div>
                    </div>
                    
                    <div class="subdiv">
                        <div class="cartprice">가격</div>
                        <div class="num">수량</div>
                        <div class="sum">합계</div>
                    </div>
                    
                    <div class="subdiv">
                        <div class="cartcmd">삭제</div>
                    </div>
                    
                </div>
                
        <c:forEach items="${cart}" var="c" >
                <div class="row data">
                
                    <div class="subdiv">
                    
                        <div class="pname">
                            <input type="text" id="pname" value="${c.bouquetName}">
                        </div>
                        
                        <div class="detail"><input type="text" id="detail" value="${c.bouquetDetail}"></div>
                        
                        <div class="wColor"><input type="text" id="wColor" value="${c.wrapColor}"></div>
                        
                    </div>
                    
                    
                    <div class="subdiv">
                    
                        <div class="cartprice"><input type="text" name="bq_price" id="bq_price1" class="bq_price" value="${c.bouquetPrice}"></div>
                        
                        <div class="num">
                        
                            <div class="updown">
                            
                                <input type="text" name="p_num1" id="p_num1" size="2" maxlength="4" class="bq_num" value="${c.buyNumBQ}" onkeyup="javascript:cart.changePNum(1);">
                                <span onclick="javascript:cart.changePNum(1);"><i class="fas fa-arrow-alt-circle-up up"></i></span>
                                <span onclick="javascript:cart.changePNum(1);"><i class="fas fa-arrow-alt-circle-down down"></i></span>
                                
                            </div>
                            
                        </div>
                        
                        <div class="sum"><input type="text" id="wColor" value="${c.bouquetTotalPrice}"></div>
                        
                    </div>
                    
                    
                    <div class="subdiv">
                        <div class="cartcmd"><a href="javascript:void(0)" class="abutton" onclick="javascript:cart.delItem();">삭제</a></div>
                    </div>
                </div>
           </c:forEach>     
        
            </div>
    
            <div class="right-align cartrowcmd">
                <a href="javascript:void(0)" class="abutton" onclick="javascript:cart.delAllItem();">전체 상품 삭제</a>
            </div>
    
            <div class="bigtext right-align sumcount" id="sum_bq_num">상품갯수: 4개</div>
            <div class="bigtext right-align box black summoney" id="sum_bq_price">합계금액: 74,200원</div>
    
            <div id="goorder" class="">
                <div class="clear"></div>
                <div class="buttongroup center-align cmd">
                    <a href="order">상품 주문</a>
                </div>
            </div>
        </form>
	</section>


        <%@ include file="../common/footer.jsp" %>
	</body>
</html>