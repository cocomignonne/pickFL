<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <script>
	function orderDetail(data){
		var orderForm = document.createElement("form");
		orderForm.method = "POST";
	    orderForm.action = "detailPaylist";
	    
	    var Input = document.createElement("input");
        Input.type = "hidden";
        Input.name = "orderNo";
        Input.value = data;
        
        orderForm.appendChild(Input);
        document.body.appendChild(orderForm);
		orderForm.submit();
		document.body.removeChild(orderForm);
	}

    function goIndex(){
    	location.href="memberInfo";
    }
    </script>
</head>
<body>    
    <div id="wrap">
                <div id="header_content1"></div>
                <div id="header_content2">
                </div>
  
                <div id="content2_backgroundColor">
                    <p id="content2_p">결제내역</p>
                </div>
                <table class = "table-striped" id="content2_2">
                    <tr class="content2_2_tr">
                        <th class="content2_2_td">주문번호</th>
                        <th class="content2_2_td">받는사람</th>
                        <th class="content2_2_td">받는사람번호</th>
                        <th class="content2_2_td">배송상태</th>
                        <th class="content2_2_td">결제날짜</th>
                        <th class="content2_2_td">상세정보</th>
                    </tr>
                    <c:forEach items="${list}" var="l">
						<tr class="content2_2_tr">
							<td class="content2_2_td" id="td1">${l.orderNo}</td>
							<td class="content2_2_td">${l.getName}</td>
							<td class="content2_2_td">${l.getPhone}</td>
							<td class="content2_2_td">${l.delivery}</td>	
							<td class="content2_2_td">${l.orderDate}</td>	
							<td class="content2_2_td">
								<input type="button" onclick="orderDetail(${l.orderNo})" value="상세내역">
							</td>	
						</tr>
					</c:forEach>
                </table>
                
                <input type="button" value="회원관리" onclick="goIndex()" class="btn btn-outline-success padding_btn">
    </div>
    
    
</body>
</html>