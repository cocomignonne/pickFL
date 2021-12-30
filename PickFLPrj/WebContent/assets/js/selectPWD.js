let emailNumCheck = 0;

function emailcheck(email) {
	var length = email.length;
	if(length!=0){
	var url = "emailcheck?email=" + email;
	window.open(url,"emailCheck", "statusbar = no, toolbar=no, location=no, menubar=no, scrollbars=no, resizable=no, width=500, height=300")
	}
}

function confirmemail(emailconfirm_value, authNum){
	//값이없거나 인증코드불일치
	if(!emailconfirm_value || emailconfirm_value != authNum){
		alert("인증번호가 맞지않습니다.");
		emailNumCheck = 0;
		self.close();
	} else if(emailconfirm_value == authNum) { // 일치하는 경우
		alert("인증번호가 일치합니다.");
		emailconfirm_value = "";
		self.close();
		opener.document.insertform.emailconfirm_value.value = 1;
		emailNumCheck = 1;
	}
	
}		


function emailCheck() {
			if (emailNumCheck === 0) {
				alert('이메일 인증을 해주세요.');
				return false;
			}		
}



