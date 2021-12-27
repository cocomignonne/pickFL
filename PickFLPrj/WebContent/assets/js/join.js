var idCheck = 0;
var emailCheck = 0;
let idDupCheck = document.getElementById('idDupCheck');
let emailNumCheck = document.getElementById('emailNumCheck');
let idRegError = document.getElementById('idHelpBlock');
let pwdRegError = document.getElementById('passwordHelpBlock');
let pwdCheckError = document.getElementById('pwdCheckError');
let emailErrorVal = document.getElementById('emailError').value;
let nameError = document.getElementById('nameError');
let emailError = document.getElementById('emailError');
let emailNumError = document.getElementById('emailNumError');
let birthError = document.getElementById('birthError');

idDupCheck.addEventListener('click', () => {
	idCheck = 1;
})
emailNumCheck.addEventListener('click', () => {
	/*window.location.href='EverifCheck';
	emailNumError.innerHTML = '<span style="color: red;"><%=msg%></span>';
	
	if(emailErrorVal.equals("인증번호가 일치합니다.")) {
		emailCheck = 1;
	} else emailCheck=0;*/
		emailCheck = 1;
})


 $("#idDupCheck").on('click', function () {
		$.ajax({
			url : '/PickFL/idDupCheck',
			type : 'get',
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
				alert("통신실패");
			}
		})
	})
	
function validate() {
            let userId = document.getElementById('userId');
            let userPwd1 = document.getElementById('userPwd1');
            let userPwd2 = document.getElementById('userPwd2');
            let email = document.getElementById('email');
            let userName = document.getElementById('userName');
			let birth = document.getElementById('birth');
			let agree = document.getElementById('agree');

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
                nameError.innerHTML = '<span style="color: red;">유효한 이름을 입력하세요.</span>';
                return false;
            }else {
				nameError.innerHTML = '<span style="color: green;">유효한 이름입니다.</span>';
			}

            if(!(/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/.test(email.value))){
                emailError.innerHTML = '<span style="color: red;">유효한 이메일을 입력하세요.</span>';
                return false;
            }else {
				emailError.innerHTML = '<span style="color: green;">유효한 이메일입니다.</span>';
			}

            if(!(/^[0-9]{6,6}$/.test(birth.value))){
                birthError.innerHTML = '<span style="color: red;">유효한 생년월일을 입력하세요.</span>';
                return false;
            }else {
				birthError.innerHTML = '<span style="color: green;">유효한 생년월일입니다.</span>';
			}
	
			if (idCheck === 0) {
				alert('아이디 중복확인을 해주세요.');
				return false;
			}
	
			/*if (emailCheck === 0) {
				alert('이메일 인증을 해주세요.');
				return false;
			}*/
			
			if ($(agree).is(":checked") == false) {
				alert('이용약관에 동의해주세요.');
				return false;
			}
			
}