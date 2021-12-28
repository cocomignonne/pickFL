<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="assets/css/inquery.css">
<title>Inquery</title>
</head>
<body>
	<div class ="inquiryBox" onclick="showOrHide(inquiry)">
        <hr/>
            <table class="inquirytable">
                <tr class="inquiry_head">
                    <th> 
                        문의 제목 : ~~
                    </th>
                </tr>
            </table>

            <div id="inquiry">
                <table class="inquirytable">
                        <tr class="inquiry_line">
                        <td>
                            <img src="assets/img/arrow.svg" class="img_icon"> &nbsp; 문의내용 : <!-- 문의내용 출력 -->
                        </td>
                    </tr>
                </table>
                    <table class="inquirytable">
                        <tr class="inquiry_head2">
                            <th>
                                답변이름 : 답변자 id<!-- 답변제목과 답변자의 id출력 -->
                            </th>
                        </tr>
                    </table>
                    <hr>
                    <table class="inquirytable">
                        <tr class="inquiry_body">
                            <td>	
                                <img src="assets/img/arrow2.png" class="img_icon"/> &nbsp; 답변 내용 :<!-- 답변내용 출력 --> 
                            </td>
                        </tr>
                    </table>
            </div>
        </div>
</body>
</html>