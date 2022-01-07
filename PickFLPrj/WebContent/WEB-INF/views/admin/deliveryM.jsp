<%@page import="java.util.List"%>
<%@page import="com.pickfl.deliveryM.model.vo.DeliveryMVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<%
	List<DeliveryMVo> dataList = (List<DeliveryMVo>)request.getAttribute("data");
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>PickFL</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <!-- Favicons -->
    <link href="assets/img/favicon.png" rel="icon">
    <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
    <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
    <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link rel="stylesheet" href="assets/css/deliveryM.css">
	<style type="text/css">
	#orderNo, #memberNo, #delivery-status-changeVal, #orderNoVal, #memberNoVal {
		border: none;
		text-align: center;
	}
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	

	
</head>

<body>

    <%@ include file="../common/headerM.jsp" %>

    <section>
        <div id="delivery-m-box" >
            <span>배송 관리</span>
            <table id="delivery-m-tb">
                <tr>
                    <th id="order-no">주문 번호</th>
                    <th id="mem-no">회원 번호</th>
                    <th id="delivery-status">배송 상태</th>
                    <th id="save-status">상태 저장</th>
                </tr>
                
                <c:forEach items="${data}" var="d" >
					<tr>
                		<form action="deliveryM" method="post" name="deliveryStatusM">
							<td>
								<input type="text" id="orderNo" name="orderNo" value="${d.orderNo}">
								<input type="hidden" id="orderNoVal" name="orderNoVal" value="">
							</td>
						
							<td>
								<input type="text" id="memberNo" name="memberNo" value="${d.memberNo}">
								<input type="hidden" id="memberNoVal" name="memberNoVal" value="">
							</td>
						
                    		<td>
                    			<input type="button" id="deliveryStatus" name="deliveryStatus" value="${d.deliveryState}">
								<input type="hidden" id="deliveryStatusChangeVal" name="deliveryStatusChangeVal" value="">
                    			<select name="deliveryStatusChange">
        							<option selected>결제완료</option>
        							<option value="배송준비">배송준비</option>
        							<option value="배송중">배송중</option>
        							<option value="배송완료">배송완료</option>
        						</select>
                    		</td>
                    		
				        	<td>
				        		<input type="submit" id="submit" value="저장"  onclick="getSiblingVal(this);">
				        	</td>
						</form>
					</tr>
				</c:forEach>
				
            </table>
    </section>

    </main><!-- End #main -->

    <%@ include file="../common/footer.jsp" %>

    <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <!-- Vendor JS Files -->
    <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
    <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
    <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
    <script src="assets/vendor/php-email-form/validate.js"></script>

    <!-- Template Main JS File -->
    <script src="assets/js/main.js"></script>
				        
	<script type="text/javascript">
		function getSiblingVal(t) {
	        let orderNo = t.parentNode.previousElementSibling.previousElementSibling.previousElementSibling.childNodes[1];
	        let memberNo = t.parentNode.previousElementSibling.previousElementSibling.childNodes[1];
	        let deliveryStatusChange = t.parentNode.previousElementSibling.childNodes[5];
	        
	        let orderNoVal = t.parentNode.previousElementSibling.previousElementSibling.previousElementSibling.childNodes[3];
	        let memberNoVal = t.parentNode.previousElementSibling.previousElementSibling.childNodes[3];
	        let deliveryStatusChangeVal = t.parentNode.previousElementSibling.childNodes[3];
			
	        orderNoVal.value = orderNo.value;
	        memberNoVal.value = memberNo.value;
	        deliveryStatusChangeVal.value = deliveryStatusChange.value;
		}
	</script>
</body>

</html>
