<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--이 페이지가 회원가입을 처리하는 함수 -->
<%@ page import = "register.MembershipVO"%>
<%@ page import = "register.MembershipDAO"%>
<%@ page import = "util.SHA256"%>
<%@ page import = "java.io.PrintWriter"%> <!-- 특정한 스크립트 구문을 출력하고자 할때 사용 -->

<%
	request.setCharacterEncoding("UTF-8");
	String userID = null;
	String userPassword = null;
	String userEmail = null;
	
	if(request.getParameter("id")!=null) {
	 	userID = request.getParameter("id");
	}
	
	if(request.getParameter("pass")!=null) {
	 	userID = request.getParameter("pass");
	}
	
	if(request.getParameter("email")!=null) {
	 	userID = request.getParameter("email");
	}
	if(ID == null || pass == null || email == null) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('입력이 안 된 사항이 있습니다.');");
		script.println("history.back()");
		script.println("</script>");
		script.close();
		return;
	}
	MembershipDAO memberDAO = new MembershipDAO();
	int result = memberDAO.join(new MembershipVO(id, pass, email));

%>
