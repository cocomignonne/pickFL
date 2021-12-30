<%@ page import="util.EmailConfirm" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="assets/js/join.js"></script>
<script type="text/javascript" src="assets/js/selectPWD.js"></script>

<%
	String email = request.getParameter("email");
	EmailConfirm emailConfirm = new EmailConfirm();
	String authNum = emailConfirm.connectEmail(email);
%>

<form method="post" action="" name="emailcheck">
	<table>
		<tr>
			<th colspan="2">인증번호를 입력하세요.</th>
		</tr>
		<tr>
			<td>
				<input type="text" name="emailconfirm">
			</td>
			<td>
				<input type="button" value="확인" 
                 onclick="confirmemail(emailcheck.emailconfirm.value,
                                                               <%=authNum%>)">
			</td>
		</tr>
	</table>
</form>
