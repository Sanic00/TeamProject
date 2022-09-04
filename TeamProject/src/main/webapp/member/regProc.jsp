<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("UTF-8");
    %>
    <jsp:useBean id = "dao" class = "com.member.model.MembershipDAO" />
    <jsp:useBean id = "vo" class = "com.member.model.MembershipVO" />
    
    <jsp:setProperty property = "*" name ="vo"/>
    
    <%
     //DAO에 있는 회원데이터 저장 메소드 
      boolean flag = dao.memberInsert(vo);
    %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행 스케쥴링 플래너 - 도죠</title>
</head>
<body>
	<div align = "center">
	<%
	if(flag) {
		out.println("<b>회원가입을 진심으로 축하드립니다<b><br>");
		out.println("<a href=login.jsp>로그인</a>");
	}else {
		out.println("<b>다시 입력 해 주세요.<b><br>");
		out.println("<a href=regForm.jsp>로그인</a>");
	}
	
	
	%>
	</div>
	
	
	
	
</body>
</html>