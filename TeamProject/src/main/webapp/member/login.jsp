<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String loginID = (String)session.getAttribute("loginID");
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행 스케쥴링 플래너 - 도죠</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<%-- <%
 if(loginID != null) {
%>
 --%>



<div class = "center">
	<div class ="container">
	   <div class = "text"><h2>LOG IN</h2></div>
	   <div class = "small-text">여행 스케쥴링 플래너 - 도죠</div>
	<div class = "form-container">
	   		<div class = "data">
	   	 		<label>ID</label>
	   	 		<input type = "text" name = "id">
	   	 	</div>
	   	 	
	   	 	<div class = "data">
	   	 		<label>PASSWORD</label>
	   	 		<input type = "password" name = "pass">
	   	 	</div>
	   	 	
	   	 	<!--비밀번호 찾기  -->
	   	 	<div class = "forget-pass">
	   	 	<a href ="findpassword">비밀번호를 잊으셨나요?</a>
	   	 	</div>
	   	 	
	   	 	<!--로그인 버튼  -->
	   	 	<div class = "btn"> 
	   	 	 	<div class = "log-button"></div>
	   	 	 	<button type ="submit" value = "login" onclick="#" >Log-in</button>
	   	 	</div>
	   	 	
	   	 	<!--회원가입 링크  -->
	   	 	<div class = "signup-link">회원이 아니신가요?
	   	 	 <a href = "regForm.jsp">회원가입하기</a>
	   	 	</div>
	   	 	
	   	 	<!-- -->
	   	 	<div class = "divider-container">
	   	 		<span>or</span>
	   	 	</div>
	   	 	
	   		 <!--소셜 로그인 연동 (수정해야됨)-->
	   	 	<div class = "sns-login">SNS 간편 로그인</div>
	   		 <div class = "sns-button">
	   		 	<div class = "socialBtn1">구글임시(아이콘)</div>
	   		 		<div></div>
	   		 	<div class = "socialBtn2">Line임시(아이콘)</div>
	   		 		<div></div>
	   		 	<div class = "socialBtn3">페이스북(아이콘)</div>
	   		 		<div></div>
	   		 </div>
	   	</div>
	  </div>
	</div>

</body>
</html>