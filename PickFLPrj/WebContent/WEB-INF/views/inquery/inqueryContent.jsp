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
</head>
<body>
	<div class="margin-top">&nbsp;</div>
	<div class ="inquiryBox">
            <div class="container p-3 my-2 border">
              &nbsp;  ${vo.qTitle}
            </div>
            
            <hr width="90%">

            <div id="inquiry">
                <div class="container-sm p-5 my-2 border" id="content">
                            <img src="assets/img/arrow.svg" class="img_icon"> &nbsp; ${vo.qContent}
                </div>
               
               	<hr width="90%">
                
                <div class="container p-5 my-2 border">
                		<img src="assets/img/arrow2.png" class="img_icon"/> &nbsp; ${vo.responseContent}
                </div>
            </div>
        </div>
</body>
</html>