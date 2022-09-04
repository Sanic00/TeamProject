<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
   <%@page import = "com.member.model.*" %>
    <jsp:useBean id="dao" class = "com.member.model.MembershipDAO" />
    
    
    <%
    	String id = (String)session.getAttribute("loginID");
    	String pass = request.getParameter("pass");
    	
    	int check = dao.deleteMember(id,pass);
    	if(check == 1) {
    		session.invalidate(); //회원탈퇴 성공시 세션 끊기
    	
    %>
    
    <script type="text/javascript">
	alert("회원 탈퇴 되셨습니다.");
	location.replace('imsimainpage.jsp');
	</script>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
    <%} else { %>
    <script type="text/javascript">
	alert("비밀번호가 맞지 않습니다.");
	history.go(-1);
	</script>
	<% } %>

</body>
</html>