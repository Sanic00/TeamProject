<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행 스케쥴링 플래너 - 도죠</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript" src = "script.js"></script>
</head>
<body>
<div class="center">
  <div class ="container">
	<div class ="text">SIGN UP</div>
	<div class ="small-text">여행 스케쥴링 플래너 - 도죠</div>
	
	<form action="regProc.jsp" method = "post" name = "regForm"><!--회원가입 폼 안에 있는 정보들을 DB로 넣어줘야 된다. -->
	 	<div><!--버튼을 눌러서 중복확인 중복화인은 자바스크립트로 함수로 구현  -->
	 	  <label class = "label-text">아이디</label>
	 	  <input class = "imsi" type = "text" name ="id" >
	 	  <input class = "imsi2" type = "button" value = "확인" onclick="idCheck(this.form.id.value)"> <!--아이디 확인 버튼-->
	 	</div>
	 	
		<div>
	 	  <label class = "label-text">PASSWORD</label>
	 	  <input class = "#" type = "password" name ="pass">
	 	</div>
	 	
	 	<div>
	 	  <label class = "label-text">PASSWORD확인</label>
	 	  <input class = "#" type = "password" name ="repass">
	 	</div>
	 	
	 	<div>
	 	  <label class = "label-text">NickName</label>
	 	  <input class = "#" type = "text" name ="nick">
	 	  <input class = "#" type = "button" value = "확인" onclick="nickCheck(this.form.nick.value)">
	 	</div>
	 	
	 	<div>
	 	  <label class = "label-text">E-Mail</label>
	 	  <input class = "#" type = "text" name ="email">
	 	</div>
	 
		<div>
			<input type ="button" class = "#"  value = "회원가입" onclick="inputCheck()"><!--스크립트로 유효성 검사-->
		</div>
		
		<div>
			<input type ="button" class = "#" value = "뒤로가기" onclick="backbutton()"> 
		</div>
	
	</form>
  </div>
</div>		
</body>
</html>