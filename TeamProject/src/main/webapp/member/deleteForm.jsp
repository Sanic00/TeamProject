<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import = "register.*" %>
    <jsp:useBean id="dao" class = "register.MembershipDAO" />
    
    <%
    	String loginID = (String)session.getAttribute("loginID");
    	MembershipVO vo = dao.getMember(loginID);
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행 스케쥴링 플래너 - 도죠</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript" src = "script.js"></script>
</head>
<body>
<form action="deleteProc.jsp" method="post" name="deleteForm">
	<div class = "container">
	<div><!--버튼을 눌러서 중복확인 중복화인은 자바스크립트로 함수로 구현  -->
	 	<label class = "label-text">아이디</label>
	 	<input class = "input" type = "text" name ="id" value = "<%=vo.getId()%>" disabled>
	</div>
	
	<div>
	 	 <label class = "label-text">PASSWORD</label>
	 	 <input class = "input" type = "password" name ="pass" onclick="refocus()">
	</div>
	
	<div>
		<input type ="submit" class = "memberdelete"  value = "회원탈퇴">
	</div>
	
	<div>
		<input type ="button" class = "back-button" value = "뒤로가기" onclick="backbutton()"> 
	</div>
					<!--그냥 한거임  -->
		<div class = "reason-contanier">
			<ul class="reason"><h2>탈퇴 사유를 체크해주세요.</h2>
		 		<li><input type="checkbox" >재가입을 위해서</li>
		 		<li><input type="checkbox" >불편해서</li>
		 		<li><input type="checkbox" >팀명이 마음에 안들어서</li>
		 		<li><input type="checkbox" >이유없음</li>
			</ul>
		</div>
   </div>
</form>
</body>
</html>