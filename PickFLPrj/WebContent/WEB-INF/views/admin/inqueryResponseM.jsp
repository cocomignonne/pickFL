<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="assets/css/inquery.css">
<title>Inquery</title>
<script>
	function inqueryAnswer(){
	
	}
	function deleteInquery(){
		
	}
</script>
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
                
                <table class="inquirytable">
                	<tr class="inquiry_head2">
                		<th><!-- 답변제목과 답변자의 id출력 --></th>
                	</tr>
                </table>
                <hr>
                <table class="inquirytable">
                	<tr class="inquiry_body">
                		<td><img src="assets/img/arrow2.png" class="img_icon"/> &nbsp; </td>
                	</tr>
                </table>
                <form action="answer" method="get">
                
                
                	<div class="divbutton">
						<input type="submit" value="답변" onclick="inqueryAnswer()">
						<input type="button" value="삭제" onclick="deleteInquery()">
					</div>
                </form>
            </div>
        </div>
</body>
</html>