package com.member.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.control.ActionForward;
import com.member.model.MembershipDAO;

public class DeleteProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		MembershipDAO dao = MembershipDAO.getInstance();

		
		String loginID = (String)session.getAttribute("loginID");
    	String pass = request.getParameter("pass");
    	
    	int result = dao.deleteMember(loginID, pass);
    	
    	if(result !=0) {
    		session.invalidate();
    	}
    	
    	request.setAttribute("result", result);
    	
		return new ActionForward("/member/deleteProc.jsp", false);
	}

}
