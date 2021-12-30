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
	.orderNo, .memberNo {
		border: none;
		text-align: center;
	}
	</style>
</head>

<body>

    <%@ include file="../common/headerM.jsp" %>

    <section>
        <form id="delivery-m-box" action="deliveryM" method="post">
            <span>배송 관리</span>
            <table id="delivery-m-tb">
                <tr>
                    <th id="order-no">주문 번호</th>
                    <th id="mem-no">회원 번호</th>
                    <th id="delivery-status">배송 상태</th>
                </tr>
                <c:forEach items="${data}" var="d">
					<tr>
						<td><input type="text" class="orderNo" name="orderNo" value=${d.orderNo}></td>
						<td><input type="text" class="memberNo" name="memberNo" value=${d.memberNo}></td>
                    	<td>
                    		<input type="button" name="delivery-status" value=${d.deliveryState}>
                    		<select name="delivery-status-change">
        						<option selected>결제완료</option>
        						<option value="배송준비">배송준비</option>
        						<option value="배송중">배송중</option>
        						<option value="배송완료">배송완료</option>
        					</select>
                    	</td>
					</tr>
				</c:forEach>
            </table>
            <br><br>
            <input type="submit" id="submit" value="저장">
            <input type="reset" id="reset" onclick="location.href='mainM'" value="취소">
        </form>
    </section>

    </main><!-- End #main -->

    <%@ include file="../common/footer.jsp" %>

    <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

    <!-- Vendor JS Files -->
    <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
    <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
    <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
    <script src="assets/vendor/php-email-form/validate.js"></script>

    <!-- Template Main JS File -->
    <script src="assets/js/main.js"></script>

</body>

</html>
