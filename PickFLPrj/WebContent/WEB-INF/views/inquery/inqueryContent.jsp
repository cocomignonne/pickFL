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
	<div class ="inquiryBox">
        <hr/>
            <table class="inquirytable">
                <tr class="inquiry_head">
                    <th> 
                        ${vo.qTitle}
                    </th>
                </tr>
            </table>

            <div id="inquiry">
                <table class="inquirytable">
                        <tr class="inquiry_line">
                        <td>
                            <img src="assets/img/arrow.svg" class="img_icon"> &nbsp; ${vo.qContent}
                        </td>
                    </tr>
                </table>
                
                <hr>
                <table class="inquirytable">
                	<tr class="inquiry_body">
                		<td><img src="assets/img/arrow2.png" class="img_icon"/> &nbsp; ${vo.responseContent}</td>
                	</tr>
                </table>
            </div>
        </div>
</body>
</html>