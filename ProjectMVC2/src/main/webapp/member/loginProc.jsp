<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <jsp:useBean id = "dao" class = "register.MembershipDAO"/>
    
    <%
    String id = request.getParameter("id");
    String pass = request.getParameter("pass");
    
    //dao에서 만든 함수 가져옴
    int check = dao.loginCheck(id, pass);
    
    if(check == 1){
    
    session.setAttribute("loginID", id);
    
    response.sendRedirect("imsimainpage.jsp");
    } else if (check == 0) {
    %>
    
	<script type="text/javascript">
		alert("비밀번호가 틀렸습니다.");
		history.go(-1); // 바로 이전페이지로 
</script>
    <% } else { //아이디가 존재 하지 않을때 %>
     <script type="text/javascript">
		alert("아이디가 존재하지않습니다.");
		history.go(-1); // 바로 이전페이지로 
</script>	

<% } %>