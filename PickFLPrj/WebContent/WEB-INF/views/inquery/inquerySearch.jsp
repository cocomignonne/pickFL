<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PickFL</title>
<link rel="stylesheet" href="assets/css/inquerySearch.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
	<div id="div-wrap">
		<form action="inquerysearch" method="post" id="search">
			<select name="searchType" class="form-control" id="select">
				<option value="all">전체</option>
				<option value="response">답변확인</option>
				<option value="noresponse">답변부재</option>
			</select>
			<input type="text" name="searchValue" class="form-control" id="text">
			<input type="submit" value="검색" class="btn btn-outline-secondary" id="button">
		</form>

			<article id="content">
                <table class = "table-striped table-hover" id="table">
                    <tr class="table_tr">
                        <th class="table_td">문의번호</th>
                        <th class="table_td">문의제목</th>
                        <th class="table_td">작성일</th>
                        <th class="table_td">답변여부</th>
                    </tr>
					<c:forEach items="${inqueryList}" var="i">
					<tr class="table_tr">
						<td class="table_td">${i.qNum}</td>
						<td class="table_td">${i.qTitle}</td>
						<td class="table_td">${i.createDate}</td>
						<td class="table_td">${i.qResponse}</td>
					</tr>
				</c:forEach>
                </table>
            </article>
			
			<div>
	        	<ul class="pagination">
	        	<li class="page-item"><a class="page-link" href="#">Previous</a></li>
	        	<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
					<c:if test="${i <= maxPage}">
						<li class="page-item"><a class="page-link" href=""search?currentPage=${i}"">${i}</a></li>				
					</c:if>
				<li class="page-item"><a class="page-link" href="#">Next</a></li>
				</c:forEach>
	       		</ul>
    		</div>

	</div>
</body>
</html>