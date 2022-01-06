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
    function back(){
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
                    <p id="content2_p">상세 결제 내역</p>
                </div>
                <table class = "table-striped" id="content2_2">
                    <tr class="content2_2_tr">
                        <th class="content2_2_td">주문번호</th>
                        <th class="content2_2_td">꽃다발 번호</th>
                        <th class="content2_2_td">꽃다발 구매 개수</th>
                        <th class="content2_2_td">꽃다발 금액</th>
                        <th class="content2_2_td">총 금액</th>
                    </tr>
						<tr class="content2_2_tr">
							<td class="content2_2_td" id="td1">${orderDetailVo.orderDetailNo}</td>
							<td class="content2_2_td">${orderDetailVo.bouquetNo}</td>
							<td class="content2_2_td">${orderDetailVo.bqNum}</td>
							<td class="content2_2_td">${orderDetailVo.price}</td>	
							<td class="content2_2_td">${orderDetailVo.totalPrice}</td>	
						</tr>
                </table>
                
                <input type="button" value="회원조회로 이동" onclick="back();" class="btn btn-outline-danger padding_btn">
    </div>
    
    
</body>
</html>