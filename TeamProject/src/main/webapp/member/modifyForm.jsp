<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import = "register.*" %>
    <jsp:useBean id="dao" class = "register.MembershipDAO" />
    
 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행 스케쥴링 플래너 - 도죠</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript" src = "script.js"></script>
</head>

	<%
    	String loginID = (String)session.getAttribute("loginID");
    	MembershipVO vo = dao.getMember(loginID);
    %>
<body>
<div class="center">
  <div class ="container">
	<div class ="text">회원 수정</div>
	<div class ="small-text">여행 스케쥴링 플래너 - 도죠</div>
	
	<form action="modifyProc.jsp" method = "post" name = "regForm"><!--회원가입 폼 안에 있는 정보들을 DB로 넣어줘야 된다. -->
	 	<div><!--버튼을 눌러서 중복확인 중복화인은 자바스크립트로 함수로 구현  -->
	 	  <label class = "label-text">아이디</label>
	 	  <input class = "input" type = "text" name ="id" value = "<%=vo.getId() %>" disabled>
	 	 
	 	</div>
	 	
		<div>
	 	  <label class = "label-text">PASSWORD</label>
	 	  <input class = "input" type = "password" name ="pass" value="<%=vo.getPass()%>">
	 	</div>
	 	
	 	<div>
	 	  <label class = "label-text">PASSWORD확인</label>
	 	  <input class = "input" type = "password" name ="repass" value="<%=vo.getPass()%>">
	 	</div>
	 	
	 	<div>
	 	  <label class = "label-text">NickName</label>
	 	  <input class = "input" type = "text" name ="nick" value = "<%=vo.getNick()%>" disabled>
	 	  <!-- <input class = "#" type = "button">  닉네임을 다시 바꿀수 있게할지 고민중-->
	 	</div>
	 	
	 	<div>
	 	  <label class = "label-text">E-Mail</label>
	 	  <input class = "input" type = "text" name ="email" value = "<%=vo.getEmail()%>">
	 	</div>
	 
		<div class = "membership-withdrawal">
		 	<a href ="deleteForm.jsp">회원탈퇴</a>
		</div>
		
		<div>
			<input type ="button" class = "membergaip"  value = "회원수정" onclick="updateCheck()"><!--스크립트로 유효성 검사-->
		</div>
		<div>
			<input type ="button" class = "back-button" value = "뒤로가기" onclick="backbutton()"> 
		</div>
	
	</form>
  </div>
</div>		
	
</body>
</html>