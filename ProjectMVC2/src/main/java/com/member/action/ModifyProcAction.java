package com.member.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.control.ActionForward;
import com.member.model.MembershipDAO;
import com.member.model.MembershipVO;

public class ModifyProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String loginID = (String)session.getAttribute("loginID");
		
		MembershipDAO dao = MembershipDAO.getInstance();
		
		MembershipVO vo = new MembershipVO(
				loginID,
				request.getParameter("pass"),
				request.getParameter("nick"),
				request.getParameter("email"));
		
		
		dao.updateMember(vo);
		
		
		return new ActionForward("/member/modifyProc.jsp", false);
	}

}
