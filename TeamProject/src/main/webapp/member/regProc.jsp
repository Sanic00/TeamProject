<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("UTF-8");
    %>
    <jsp:useBean id = "dao" class = "register.MembershipDAO" />
    <jsp:useBean id = "vo" class = "register.MembershipVO" />
    
    <jsp:setProperty property = "*" name ="vo"/>
    
    <%
     //DAO에 있는 회원데이터 저장 메소드 
      boolean flag = dao.memberInsert(vo);
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

</body>
</html>