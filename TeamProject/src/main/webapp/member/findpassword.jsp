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
 	<div class ="center">
 		<div class="container">
  			<div class = "text">비밀번호 찾기</div>
  			
  			<div>
  			<label class="label-text" for"findUserPwdEmail">이메일</label>
  				<input class ="uk-input" type ="email" id="findUserPwdEmail">
  			</div>
 		</div>
 		
 		<div class ="small-text">회원가입시 등록하셨던 이메일 주소를 입력해주세요.</div>
 		<div>
 			<button class ="#" type ="submit" id="sendNewPwdBtn">발급받기</button>
 		</div>
 		
 		<div class ="small-text">*메일이 도착하기 까지 몇 분 정도 소요 될 수 있습니다.</div>
 		<div>
			<input type ="button" class = "#" value = "뒤로가기" onclick="backbutton()"> 
		</div>
 	</div>
</body>
</html>