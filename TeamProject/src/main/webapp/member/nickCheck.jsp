<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <jsp:useBean id="dao" class="register.MembershipDAO" />
     
     <%
     String nick = request.getParameter("nick");
     boolean check = dao.nickCheck(nick);
     %>
     
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript" src = "script.js"></script>
</head>
<body>

<div align = "center">
<b> <%= nick %></b>
	<%
	if(check){
		out.println("는 사용중인 닉네임입니다.<br><br>");
	}else {
		out.println("사용 가능한 닉네임입니다.<br><br>");
	}
	%>

	<a href ="#" oneclick = "javascript:self.close()">닫기</a>

</div>



</body>
</html>