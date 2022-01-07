let idRegError = document.getElementById('idHelpBlock');
let pwdRegError = document.getElementById('passwordHelpBlock');
let emailDupCheck = document.getElementById('emailDupCheck');
let sendEmailBtn = document.getElementById('sendEmailBtn');
let userId = document.getElementById('userId');
let email = document.getElementById('email');
let idCheck = 0;
let emaildupCheck = 0;
let emailnumCheck = 0;



idDupCheck.addEventListener('click', () => {
	idCheck = 1;
})


sendEmailBtn.addEventListener('click', () => {
	emailnumCheck = 1;
})



 $("#idDupCheck").on('click', function () {
		var method = '';
		
		if(!userId.value){
			alert("아이디를 입력해주세요");
		} else {
			method = 'get';
		}
	
		$.ajax({
			url : '/PickFL/idDupCheck',
			type : method,
			data : { 
				id : $("#userId").val()
			} ,
			success : function(data) {
				alert(data);
				if(data.charAt(0) === '중'){
					idRegError.innerHTML = '<span style="color: red;">이미 있는 아이디입니다.</span>';
					idCheck = 0;
				} else {
					idRegError.innerHTML = '<span style="color: green;">사용가능한 아이디입니다.</span>';
					idCheck = 1;
				}
				
			},
			error : function (error) {
				console.log("통신 실패");
			}
		})
	})

 $("#emailDupCheck").on('click', function () {
		var method = '';
		
		if(!email.value){
			alert("이메일을 입력해주세요");
		} else {
			method = 'get';
		}
	
		$.ajax({
			url : '/PickFL/emailDupCheck',
			type : method,
			data : { 
				email : $("#email").val()
			} ,
			success : function(data) {
				alert(data);
				if(data.charAt(0) === '중'){
					emailRegError.innerHTML = '<span style="color: red;">이미 있는 이메일입니다.</span>';
					emaildupCheck = 0;
				} else {
					emailRegError.innerHTML = '<span style="color: green;">사용가능한 이메일입니다.</span>';
					emaildupCheck = 1;
				}
				
				},
			error : function (error) {
				console.log("통신 실패");
			}
		})
	})

function emailcheck(email) {
	var length = email.length;
	if(emaildupCheck == 1 && length!=0){
	var url = "emailcheck?email="+email;
	window.open(url,"emailCheck", "statusbar = no, toolbar=no, location=no, menubar=no, scrollbars=no, resizable=no, width=500, height=300")
	}
}

function confirmemail(emailconfirm_value, authNum){
	//값이없거나 인증코드불일치
	if(!emailconfirm_value || emailconfirm_value != authNum){
		alert("인증번호가 맞지않습니다.");
		self.close();
	} else if(emailconfirm_value == authNum) { // 일치하는 경우
		alert("인증번호가 일치합니다.");
		emailconfirm_value = "";
		self.close();
		opener.document.insertform.emailconfirm_value.value = 1;
	}
}

	
function validate() {
            let userPwd1 = document.getElementById('userPwd1');
            let userPwd2 = document.getElementById('userPwd2');
            let userName = document.getElementById('userName');
			let birth = document.getElementById('birth');
			let agree = document.getElementById('agree');
			
			let pwdCheckError = document.getElementById('pwdCheckError');
			let nameRegError = document.getElementById('nameRegError');
			let emailRegError = document.getElementById('emailRegError');
			let birthRegError = document.getElementById('birthRegError');

            if(!(/^[A-Za-z][A-Za-z\d]{5,12}$/.test(userId.value))){
                idRegError.innerHTML = '<span style="color: red;">유효한 아이디를 입력하세요.</span>';
                return false;
            } else if(/^[A-Za-z][A-Za-z\d]{5,12}$/.test(userId.value)){
				idRegError.innerHTML = '<span style="color: green;">유효한 아이디입니다.</span>';
				console.log("성공");
				console.log(userId.value);
			}
				 
            if(!(/^(?=.*?[A-Za-z])(?=.*?[0-9])(?=.*?[#$%]).{8,16}$/.test(userPwd1.value))){
                pwdRegError.innerHTML = '<span style="color: red;">유효한 비밀번호를 입력하세요.</span>';
                return false;
            } else if(/^(?=.*?[A-Za-z])(?=.*?[0-9])(?=.*?[#$%]).{8,16}$/.test(userPwd1.value)) {
				pwdRegError.innerHTML = '<span style="color: green;">유효한 비밀번호입니다.</span>';
			}

            if(userPwd1.value !== userPwd2.value) {
                pwdCheckError.innerHTML = '<span style="color: red;">동일한 비밀번호를 입력하세요.</span>';
                return false;
            }else {
				pwdCheckError.innerHTML = '<span style="color: green;">동일한 비밀번호입니다.</span>';
			}

            if(!(/^[가-힣]{2,}$/.test(userName.value))) {
                nameRegError.innerHTML = '<span style="color: red;">유효한 이름을 입력하세요.</span>';
                return false;
            }else {
				nameRegError.innerHTML = '<span style="color: green;">유효한 이름입니다.</span>';
			}

            if(!(/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/.test(email.value))){
                emailRegError.innerHTML = '<span style="color: red;">유효한 이메일을 입력하세요.</span>';
                return false;
            }else {
				emailRegError.innerHTML = '<span style="color: green;">유효한 이메일입니다.</span>';
			}

            if(!(/^[0-9]{6,6}$/.test(birth.value))){
                birthRegError.innerHTML = '<span style="color: red;">유효한 생년월일을 입력하세요.</span>';
                return false;
            }else {
				birthRegError.innerHTML = '<span style="color: green;">유효한 생년월일입니다.</span>';
			}
	
			if (idCheck === 0) {
				alert('아이디 중복확인을 해주세요.');
				return false;
			}
	
			if (emaildupCheck === 0) {
				alert('이메일 인증을 해주세요.');
				return false;
			}
	
			if (emailRegError.innerText.charAt(6) === '맞') {
				alert('이메일 인증을 해주세요.');
				return false;
			}
			
			if ($(agree).is(":checked") == false) {
				alert('이용약관에 동의해주세요.');
				return false;
			}
			
}






