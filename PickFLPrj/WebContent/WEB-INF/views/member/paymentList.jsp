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
                        <th class="content2_2_td">상품번호</th>
                        <th class="content2_2_td">상품이름</th>
                        <th class="content2_2_td">구매개수</th>
                        <th class="content2_2_td">배송상태</th>
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
                    </tr>
                </table>
    </div>
    
    <div id="page_btn">
		<ul class="pagination">
			<li class="page-item"><a class="page-link" href="paylist?currentPage=${searchVo.currentPage-10}">Previous</a></li>
				<c:forEach var="p" begin="${searchVo.startPage}" end="${searchVo.endPage}" step="1">
					<c:if test="${p <= searchVo.maxPage}">
						<li class="page-item"><a class="page-link" href="paylist?currentPage=${p}">${p}</a></li>				
					</c:if>
				</c:forEach>
			<li class="page-item"><a class="page-link" href="paylist?currentPage=${searchVo.currentPage+10}">Next</a></li>
		</ul>
	</div>
    
    
</body>
</html>