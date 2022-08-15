/*ID체크*/
function idCheck(id) {
	if(id == "") {
		alert("아이디를 입력해주세요.");
		document.regForm.id.focus();
	}else {
	 url = "idCheck.jsp?id=" +id
	 window.open(url, "post", "width=300, height=150");	
	}
}

/*닉네임 체크*/
function nickCheck(nick) {
	if(nick == ""){
		alert("닉네임을 입력해주세요.");
		document.regForm.nick.focus();
	}else {
		url ="nickCheck.jsp?nick="+nick
		window.open(url, "post", "width=300, height=150");
	}	
	
}


/*유효성 검사 이메일 비밀번호 맞는지*/
function inputCheck() {
	/*아이디 먼저 검사*/
	if(document.regForm.id.value==""){
		alert("아이디를 입력해주세요.");
		document.regForm.id.focus();
		return;
	}
	
	if(document.regForm.pass.value==""){
		alert("비밀번호를 입력해주세요.");
		document.regForm.pass.focus();
		return;
	}
	
	if(document.regForm.repass.value==""){
		alert("비밀번호를 똑같이 입력해주세요.");
		document.regForm.repass.focus();
		return;
	}
	/*비밀번호 2개 일치 체크 */
	if(document.regForm.pass.value !=document.regForm.repass.value){
		alert("비밀번호가 일치 하지 않습니다.");
		document.regForm.repass.focus();
		return;
	}
	
	if(document.regForm.nick.value==""){
		alert("닉네임을 입력해주세요.");
		document.regForm.nick.focus();
		return;
	}
	
	if(document.regForm.email.value==""){
		alert("email을 입력해주세요.");
		document.regForm.email.focus();
		/*중지*/
		return;
	}
	
	/*email 유효성 검사 */
	var str = document.regForm.email.value;
	var atPos = str.indexOf("@");
	var atLastPos = str.lastIndexOf('@');
	var dotPos = str.indexOf('.');
	var spacePos = str.indexOf(' ');
	var commaPos = str.indexOf(',');
	var eMailSize = str.length;
	
	if(atPos > 1 && atPos == atLastPos && dotPos > 3 && spacePos == -1 && commaPos == -1 && atPos +1 < dotPos && dotPos + 1 < eMailSize){
	}else{	
		alert("E-Mail 주소 형식이 잘못 되었습니다. \n\r 다시 입력 해주세요.");
		document.regForm.email.focus();
		return;
	}
	document.regForm.submit();
}

//이메일 인증 보내기 결과값이 true 라면 새창에 email정보를 get방식? false라면 기능 실현 하지않음
function emailAuthentication() {
	if(!emailValCheck()){
		return false;
	}
	var url = "confirmEmail.four?email=" + document.regForm.email.value;
	open(url, "post",
	"toolbar=no, location=no, menubar=no, scrollbars=no, resizable=no, width=300, height=200")
}
// const 상수,선언 후 변하지 않을 값의 자료형에 사용
//emailValCheck()가 정규식으로 입력된 값이 유효한지 검사
const form = document.regForm; //email을 포함하는 form의 위치
function emailValCheck(){
	var emailPattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-z](-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,4}$/i; //이메일 정규식 패턴
	var email = form.email.value; 
	// (매개변수 pattern, taget  message)를 호출해 결과에 따라 새창을 띄움
	if(!check(emailPattern, email, "유효하지 않은 이메일 주소입니다.")) {
		return false;
	}
	return true;
}

/*정규식 검증이 필요한 다른 항목에서도 사용가능하도록 만들어 코드 재사용성을 높임
taget을 pattern으로 검사해 유효하면 ture 반환
taget이 pattern에 맞지 않는다면?
alert로 message를 띄워 사용자에게 알림
유요하지 않은 입력에 포커스를 줌
false 반환*/

function check(pattern, taget, message) {
	if(pattern.test(taget)) {
		return true;
	}
	alert(message);
	taget.focus();
	return false;
}


function authCodeCheck() {
	var url = "authCodeCheck.jsp?inputedCode=" + document.regForm.authCode.value;
	open(url, "post",
	"toolbar=no, location=no, menubar=no, scrollbars=no, resizable=no, width=300, height=200");
}


//뒤로가기
function backbutton() {
	history.back();
}

//비밀번호 찾기 
"use strict";var re=/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;//뒤로가기 버튼
$("#sendNewPwdBtn").click(function(){// console.log(111111);
return re.test($("#findUserPwdEmail").val())?void $.ajax({type:"POST",url:"/sendNewPwd",data:{findUserPwdEmail:$("#findUserPwdEmail").val()},success:function success(res){alert(res.msg)}}):void alert("\uC798\uBABB\uB41C \uC774\uBA54\uC77C\uC785\uB2C8\uB2E4.")}),$("#backPage").click(function(){history.back()})