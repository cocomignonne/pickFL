function validate() {
            let userId = document.getElementById('userId').value;
            let idRegError = document.getElementById('idHelpBlock');
            let userPwd1 = document.getElementById('userPwd1').value;
            let userPwd2 = document.getElementById('userPwd2').value;
            let pwdRegError = document.getElementById('passwordHelpBlock');
            let pwdCheckError = document.getElementById('pwdCheckError');
            let userName = document.getElementById('userName').value;
            let nameError = document.getElementById('nameError');
            let email = document.getElementById('email').value;
            let emailError = document.getElementById('emailError');

            if(!(/^[A-Za-z][A-Za-z\d]{6,12}$/.test(userId))){
                idRegError.innerHTML = '<span style="color: red;">유효한 아이디를 입력하세요.</span>';
                return false;
            }

            if(!(/^(?=.*?[A-Za-z])(?=.*?[0-9])(?=.*?[#$%])/.test(userPwd1))){
                pwdRegError.innerHTML = '<span style="color: red;">유효한 비밀번호를 입력하세요.</span>';
                return false;
            }

            if(userPwd1 !== userPwd2) {
                pwdCheckError.innerHTML = '<span style="color: red;">동일한 비밀번호를 입력하세요.</span>';
                userPwd2 = '';
                return false;
            }

            if(!(/^[가-힣]{2,}$/.test(userName))) {
                nameError.innerHTML = '<span style="color: red;">유효한 이름을 입력하세요.</span>';
                return false;
            }

            if(!(/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/.test(email))){
                emailError.innerHTML = '<span style="color: red;">유효한 이메일을 입력하세요.</span>';
                return false;
            }
        }