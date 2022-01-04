<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Document</title>
<link rel="stylesheet" href="assets/css/memberController.css">
<title>PickFL</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
	function goIndex() {
		location.href="main";
	}
</script>
</head>
<body>
    <span id="content_span">회원정보</span>
    <table class = "table-bordered table-hover" id="table">
        <tr class="table_tr">
            <th class="table_td">회원번호</th>
            <th class="table_td">회원아이디</th>
            <th class="table_td">회원등급</th>
            <th class="table_td">생년월일</th>
            <th class="table_td">생성날짜</th>
            <th class="table_td">결제내역</th>
            <th class="table_td">탈퇴여부</th>
            <th class="table_td">회원정보수정</th>
        </tr>

       <c:forEach items="${list}" var="l">
			<tr class="table_tr">
				<td class="table_td" id="td1">${l.memberNo}</td>
				<td class="table_td">${l.id}</td>
				<td class="table_td">${l.gradeNo}</td>
				<td class="table_td">${l.birth}</td>
				<td class="table_td">${l.joinDate}</td>
				<td class="table_td_button">
					<form action="paylist" method="get">
						<input type="hidden" name="mNum" value="${l.memberNo}">
						<input type="submit" class="table_button" value="확인하기">
					</form>
				</td>
				<td class="table_td">${l.quitYN}</td>
				<td class="table_td_button">
					<form action="adminModify" method="get">
						<input type="hidden" name="mNum" value="${l.memberNo}">
						<input type="submit" class="table_button" value="수정하기">
					</form>
				</td>
		</tr>
		</c:forEach>
    </table>

    <div id="page_btn">
		<ul class="pagination">
			<li class="page-item"><a class="page-link" href="memberInfo?currentPage=${searchVo.currentPage-10}">Previous</a></li>
				<c:forEach var="p" begin="${searchVo.startPage}" end="${searchVo.endPage}" step="1">
					<c:if test="${p <= searchVo.maxPage}">
						<li class="page-item"><a class="page-link" href="memberInfo?currentPage=${p}">${p}</a></li>				
					</c:if>
				</c:forEach>
			<li class="page-item"><a class="page-link" href="memberInfo?currentPage=${searchVo.currentPage+10}">Next</a></li>
		</ul>
	</div>


    <div id="index_btn">
        <input type="button" value="Main" onclick="goIndex()" class="btn btn-outline-success">
    </div>
</body>
</html>
</body>
</html>