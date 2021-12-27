<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	function modify() {
		location.href="admin_modify";
	}
</script>
</head>
<body>
    <span id="content_span">회원정보</span>
    <table class = "table-bordered table-hover" id="table">
        <tr class="table_tr">
            <th class="table_td">회원번호</th>
            <th class="table_td">회원아이디</th>
            <th class="table_td">회원이름</th>
            <th class="table_td">생년월일</th>
            <th class="table_td">결제내역</th>
            <th class="table_td">탈퇴여부</th>
            <th class="table_td">회원정보수정</th>
        </tr>
        <tr class="table_tr">
            <td class="table_td">1</td>
            <td class="table_td">1</td>
            <td class="table_td">1</td>
            <td class="table_td">1</td>
            <td class="table_td_button"><input type="submit" onclick="" value="button" class="table_button"></td>
            <td class="table_td">1</td>
            <td class="table_td_button"><input type="submit" onclick="modify" value="button" class="table_button"></td>
        </tr>
        <tr class="table_tr">
            <td class="table_td">3</td>
            <td class="table_td">3</td>
            <td class="table_td">3</td>
            <td class="table_td">3</td>
            <td class="table_td_button"><input type="submit" onclick="" value="button" class="table_button"></td>
            <td class="table_td">3</td>
            <td class="table_td_button"><input type="submit" onclick="modify" value="button" class="table_button"></td>
        </tr>
        <tr class="table_tr">
            <td class="table_td">4</td>
            <td class="table_td">4</td>
            <td class="table_td">4</td>
            <td class="table_td">4</td>
            <td class="table_td_button"><input type="submit" onclick="" value="button" class="table_button"></td>
            <td class="table_td">4</td>
            <td class="table_td_button"><input type="submit" onclick="modify" value="button" class="table_button"></td>
        </tr>
    </table>

    <div id="page_btn">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">Next</a></li>
        </ul>
    </div>


    <div id="index_btn">
        <input type="button" value="Main" onclick="goIndex()" class="btn btn-outline-success">
    </div>
</body>
</html>
</body>
</html>