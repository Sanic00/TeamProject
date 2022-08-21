<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "register.*" %>
    <%= request.setCharacterEncoding("utf-8") %>
    
    <jsp:useBean id ="dao" class="register.MembershipDAO"/>
    <jsp:useBean id ="vo" class ="register.MembershipVO" >
    <jsp:setProperty property ="*" name="vo"/>
    </jsp:useBean>
    
     <%									
     String loginID = (String)session.getAttribute("loginID");
     vo.setId(loginID);
     dao.updateMember(vo);
     %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행 스케쥴링 플래너 - 도죠</title>
<meta http-equiv ="Refresh" content = "1; url=mypage.jsp">
</head>
<body>

	<script type="text/javascript">
	alert("회원정보가 수정되었습니다.");
	</script>	

</body>
</html>