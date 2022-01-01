<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="assets/css/inquery.css">
<title>Inquery</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
	function selfclose(){
		self.close();
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
                		<td><img src="assets/img/arrow2.png" class="img_icon"/> &nbsp; ${vo.responseContent}</td>
                	</tr>
                </table>
                
                <form action="inqueryresponseM" method="post">
                	<input type="hidden" name="qNum" value="${vo.qNum}">
                	<input type="hidden" name="user" value="${vo.user}">
					
					<div class="form-group">
					  <textarea class="form-control" rows="5" id="comment" name="comment"></textarea>
					</div>
	
                	<div class="divbutton">
						<input type="submit" value="답변">
						<input type="button" value="닫기" onclick="selfclose()">
					</div>
                </form>
            </div>
        </div>
</body>
</html>