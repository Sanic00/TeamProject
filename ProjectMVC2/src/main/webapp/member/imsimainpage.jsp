<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지 임시</title>
</head>
<body>
 <div class = "header">  
 	<nav id= "navcc">
 		<div class ="nav-wrapper navWidth">
 	<ul>
 	 <li id="loginlogoutNav">
		<div class ="nav-profile-btn-container">
		<span id ="logout">
		<button class =  "nav-profile-btn"  aria-expanded ="true"></button>
		</div>	
		<li>
			<a href ="cityPlan.mb?cmd=mypage">마이페이지</a>
		</li>
		<li>
			<a onclick ="logout()">로그아웃</a>
		</li>
	</ul>
	</div>
</nav>
</div>

</body>
</html>