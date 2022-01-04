<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page import="com.pickfl.cart.model.vo.CartVo"%>
<%@page import="com.pickfl.member.model.vo.MemberVo"%>
<%
int totalCartPrice = (int) request.getAttribute("totalCartPrice");
int totalPNum = (int) request.getAttribute("totalPNum");
%>   
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
	    <form name="orderform" id="orderform" method="post" class="orderform" action="order" >
            <input type="hidden" name="cmd" value="order">
            <div class="cartdiv" id="cart">
                <div class="row head"  style="font-size: 20px; font-weight: bolder;">
                
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
                <div class="row head2">
                
                    <div class="subdiv">
                    
                        <div class="pname">
                            <input type="text" id="pname" name="bqName" value="${c.bouquetName}">
                        </div>
                        
                        <div class="detail"><input type="text" id="detail" value="${c.bouquetDetail}"></div>
                        
                        <div class="wColor"><input type="text" id="wColor" value="${c.wrapColor}"></div>
                        
                    </div>
                    
                    
                    <div class="subdiv">
                    
                        <div class="cartprice"><input type="text" name="bq_price" id="bq_price1" class="bq_price" value="${c.bouquetPrice}"></div>
                        
                        <div class="num">
                        
                            <div class="updown">
                            
                                <input type="hidden" name="bq_numVal" value="">
                                <input type="text" name="bq_num1" id="p_num1" size="2" maxlength="4" class="bq_num" value="${c.buyNumBQ}">
                        		<a href="javascript:void(0)" class="abutton" onclick="modNumChange(this);">수정</a>
                        		<a href="javascript:void(0)" class="abutton" onclick="changedNumUpdate(this);">등록</a>
                                
                            </div>
                            
                        </div>
                        
                        <div class="sum"><input type="text" id="cartprice" value="${c.bouquetTotalPrice}"></div>
                        
                    </div>
                    
                    
                    <div class="subdiv">
                        <div class="cartcmd"><a href="javascript:void(0)" class="abutton" onclick="deleteBQ(this);">삭제</a></div>
                    </div>
                </div>
           </c:forEach>     
        
            </div>
    
            <div class="bigtext right-align sumcount" id="sum_bq_num" >
                <a href="javascript:void(0)" style="font-size: medium;" class="abutton aaa" onclick="javascript:cart.delAllItem();">전체 상품 삭제</a>
           </div>
    
            <div class="bigtext right-align sumcount" id="sum_bq_num" style="font-size: 25px;">상품 개수<pre style="border: none; text-align: right;">: <%=totalPNum%>개</pre></div>
            <div class="bigtext right-align box black summoney" id="sum_bq_price" style="font-size: 25px;">합계 금액<pre style="border: none; text-align: right;">: <%=totalCartPrice%>원</pre></div>
    
            <div id="goorder" class="">
                <div class="clear"></div>
                <div class="buttongroup center-align cmd">
                    <a href="order">상품 주문</a>
                </div>
            </div>
            
          
        </form>
	</section>


        <%@ include file="../common/footer.jsp" %>
        
     <script type="text/javascript">
  		function modNumChange(m) {
			let upBQNum = m.previousElementSibling;
			let upBQNumHid = m.previousElementSibling.previousElementSibling;
			
			console.log(upBQNum);
			console.log(upBQNumHid);
			console.log(upBQNum.value);
			console.log(upBQNumHid.value);
			
			upBQNumHid.value = upBQNum.value;
			
			console.log(upBQNumHid.value);
			console.log(upBQNum.value);
		}
			
  		
  		function changedNumUpdate(c) {
  			let chNum = c.previousElementSibling.previousElementSibling.previousElementSibling;
			let bqName = c.parentNode.parentNode.parentNode.previousElementSibling.childNodes[1].childNodes[1];
  			
			console.log(chNum);
			console.log(bqName);
			
			var url = "cartModChange?chNum=" + chNum.value + "&bqName=" + bqName.value;
			
			location.href = url;
		}
  		
  		function deleteBQ(d) {
  			let bqDetail = d.parentNode.parentNode.previousElementSibling.previousElementSibling.childNodes[3].childNodes[0];
			let bqName = d.parentNode.parentNode.previousElementSibling.previousElementSibling.childNodes[1].childNodes[1];
  			
			console.log(bqDetail);
			console.log(bqName);
  			
			console.log(bqDetail.value);
			console.log(bqName.value);
  			
			var url = "deleteCart?bqDetail=" + bqDetail.value + "&bqName=" + bqName.value;
			
			location.href = url;
		}
     
     </script>   
        
	</body>
</html>